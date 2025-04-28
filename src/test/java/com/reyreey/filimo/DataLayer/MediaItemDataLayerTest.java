package com.reyreey.filimo.DataLayer;

import com.reyreey.filimo.Model.Content.*;
import com.reyreey.filimo.Model.Content.Builder.ContentDetailBuilder;
import com.reyreey.filimo.Model.Content.Builder.MediaItemBuilder;
import com.reyreey.filimo.Repository.Content.IMediaItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 4/28/2025, Monday
 **/

@DataJpaTest
public class MediaItemDataLayerTest {

    @Autowired
    private IMediaItemRepository mediaItemRepository;

    @Test
    @Transactional
    @Rollback
    public void saveMovieTest() {

        double rate = 8.4;
        List<Genre> genres = List.of(Genre.ADVENTURE, Genre.HORROR);
        String code="01";
        String title="Adventure";

        ContentDetail detail = ContentDetailBuilder
                .aContentDetail()
                .withCode(code)
                .withTitle(title)
                .withSummary("Summary")
                .withReleaseDate(LocalDate.now())
                .build();

        Person person = Person.PersonBuilder.aPerson()
                .withFirstName("john")
                .withLastName("smith")
                .withDateOfBirth(LocalDate.now())
                .build();

        PersonRole role = PersonRole.PersonRoleBuilder.aPersonRole()
                .withRoleType(RoleType.ACTOR)
                .withPerson(person)
                .build();

        MediaItem movie = MediaItemBuilder.aMediaItem()
                .withGenres(genres)
                .withDetail(detail)
                .withRate(rate)
                .withPersonRoles(List.of(role))
                .build();

        MediaItem savedMovie = mediaItemRepository.save(movie);

        assertNotNull(savedMovie);
        assertNotNull(savedMovie.getDetail());

        assertNotNull(savedMovie.getId());

        assertEquals(rate, savedMovie.getRate());

        assertEquals(genres, savedMovie.getGenres());

        assertEquals(code, savedMovie.getDetail().getCode());
    }
}
