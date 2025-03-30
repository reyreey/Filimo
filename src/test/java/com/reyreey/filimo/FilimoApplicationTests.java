package com.reyreey.filimo;

import com.reyreey.filimo.Controller.Content.api.MediaItemController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class FilimoApplicationTests {

    @Autowired
    private MediaItemController mediaItemController;

    @Test
    void contextLoads() throws Exception{
        assertThat(mediaItemController).isNotNull();
    }

}
