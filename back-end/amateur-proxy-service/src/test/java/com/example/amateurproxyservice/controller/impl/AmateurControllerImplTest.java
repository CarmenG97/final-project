package com.example.amateurproxyservice.controller.impl;

import com.example.amateurproxyservice.model.Amateur;
import com.example.amateurproxyservice.repository.AmateurRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
class AmateurControllerImplTest {

    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private AmateurRepository amateurRepository;

    private Amateur amateur;

    @BeforeEach
    void setUp() {
        amateur = new Amateur("Carmen", "carmen@hotmail.com", 8, "123456", "");
        amateurRepository.save(amateur);
    }

    @AfterEach
    void tearDown() {
        amateurRepository.deleteAll();
    }

    @Test
    void register() throws Exception {
        Amateur amateur1 = new Amateur("Carmen", "carmen@hotmail.com", 8, "123456", "");

        String body = objectMapper.writeValueAsString(amateur1);

        MvcResult mvcResult = mockMvc.perform(

                        post("/amateurs")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(amateur.getName()));
    }

    @Test
    void findAll() throws Exception {
        MvcResult mvcResult = mockMvc.perform(

                        get("/amateurs")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(amateur.getName()));
    }

    @Test
    void getAmateurById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(

                        get("/amateurs/" + amateur.getId())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(amateur.getName()));
    }

}