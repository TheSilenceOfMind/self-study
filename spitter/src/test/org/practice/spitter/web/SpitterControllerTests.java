package org.practice.spitter.web;

import org.junit.Test;
import org.practice.spitter.Spitter;
import org.practice.spitter.data.SpitterRepository;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class SpitterControllerTests {

    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessForm() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("Jack", "Garrison", "jacky", "qwerty",
                "jacky@mail.ru");
        Spitter saved = new Spitter(1L, "Jack", "Garrison", "jacky", "qwerty",
                "jacky@mail.ru");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Garrison")
                .param("username", "jacky")
                .param("password", "qwerty")
                .param("email", "jacky@mail.ru"))
                .andExpect(redirectedUrl("/spitter/jacky"));

        verify(mockRepository, atLeastOnce()).save(unsaved);
    }
}
