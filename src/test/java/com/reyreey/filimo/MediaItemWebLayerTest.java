package com.reyreey.filimo;

import com.reyreey.filimo.Controller.Content.api.MediaItemController2;
import com.reyreey.filimo.DTO.MediaItemDTO;
import com.reyreey.filimo.Model.Content.*;
import com.reyreey.filimo.Model.Content.Factory.ContentDetailFactory;
import com.reyreey.filimo.Service.Content.IMediaItemService;
import com.reyreey.filimo.Service.Content.Impl.MediaItemService;
import com.reyreey.filimo.Utill.CSVToDTO.Mapper.MediaItemMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 3/30/2025, Sunday
 **/

@WebMvcTest(controllers = MediaItemController2.class)
public class MediaItemWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MediaItemService mediaItemService;

    @MockitoBean
    private IMediaItemService iMediaItemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    void createMovieTest() throws Exception {

        //create input
        Video video1 = new Video() ;
        video1.setQuality(Quality.Q720);
        video1.setUrl("https://example.com/video1.mp4");

        ContentDetail detail = ContentDetailFactory
                .createContentDetail("code_001","Inception",
                        "A thief who steals corporate secrets through the use of dream-sharing technology is given the task of planting an idea into the mind of a CEO."
                        , LocalDate.now());

        Person person = new Person() ;
        person.setFirstName("John");
        person.setLastName("Smith");
        person.setDateOfBirth(LocalDate.now());

        PersonRole role = new PersonRole() ;
        role.setRoleType(RoleType.ACTOR);
        role.setPerson(person);

        MediaItem movie =  new MediaItem();
        movie.setGenres(List.of(Genre.ACTION, Genre.ROMANCE));
        movie.setVideos(List.of(video1));
        movie.setRate(5.9);
        movie.setDetail(detail);
        movie.setPersonRoles(List.of(role));

        MediaItemDTO movieDTO = MediaItemMapper.mapToDTO(movie);

        //call mediaItemService
        given(mediaItemService.createMediaItem(any(MediaItemDTO.class),eq(null)))
                .willAnswer((invocation)-> invocation.getArgument(0));


        ResultActions response = mockMvc.perform(post("/api/add-media-item")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(movieDTO)));

        //check response
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(movieDTO.getCode())))
                .andExpect(jsonPath("$.title", is(movieDTO.getTitle())))
                .andExpect(jsonPath("$.summary", is(movieDTO.getSummary())))
                .andExpect(jsonPath("$.releaseDate", is(movieDTO.getReleaseDate().toString())))
                .andExpect(jsonPath("$.rate", is(movieDTO.getRate())));

        for (int i = 0; i < movieDTO.getVideos().size(); i++) {
            response.andExpect(jsonPath("$.videos[" + i + "].url", is(movieDTO.getVideos().get(i).getUrl())))
                    .andExpect(jsonPath("$.videos[" + i + "].quality", is(movieDTO.getVideos().get(i).getQuality().toString())));
        }

        for (int i = 0; i < movieDTO.getGenres().size(); i++) {
            response.andExpect(jsonPath("$.genres[" + i + "]", is(movieDTO.getGenres().get(i).toString())));
        }

        for (int i = 0; i < movieDTO.getPersonRoles().size(); i++) {
            response.andExpect(jsonPath("$.personRoles[" + i + "].roleType", is(movieDTO.getPersonRoles().get(i).getRoleType().toString())))
                    .andExpect(jsonPath("$.personRoles[" + i + "].firstName", is(movieDTO.getPersonRoles().get(i).getFirstName())))
                    .andExpect(jsonPath("$.personRoles[" + i + "].lastName", is(movieDTO.getPersonRoles().get(i).getLastName())))
                    .andExpect(jsonPath("$.personRoles[" + i + "].dateOfBirth", is(movieDTO.getPersonRoles().get(i).getDateOfBirth().toString())));
        }

    }
}
