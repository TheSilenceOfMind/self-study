package org.practice.spitter.web;

import org.junit.Test;
import org.practice.spitter.data.JdbcSpittleRepository;
import org.practice.spitter.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTests {

    @Autowired
    SpittleRepository repository;

    @Test
    public void testHomePage() throws Exception {
        SpittleController controller = new SpittleController(repository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("spittles"));
    }

}
