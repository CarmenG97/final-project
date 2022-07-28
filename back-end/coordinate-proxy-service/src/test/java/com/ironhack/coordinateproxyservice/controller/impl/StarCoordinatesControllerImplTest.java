package com.ironhack.coordinateproxyservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.coordinateproxyservice.controller.dto.StarCoordinatesDTO;
import com.ironhack.coordinateproxyservice.model.StarCoordinates;
import com.ironhack.coordinateproxyservice.repository.StarCoordinatesRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StarCoordinatesControllerImplTest {
    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper(); // Contruir Objetos JSON a partir de clase de JAVA

    @Autowired
    private StarCoordinatesRepository starCoordinatesRepository;

    private StarCoordinates starCoordinates;
    private StarCoordinatesDTO starCoordinatesDTO;

    @BeforeEach
    void setUp() {
        starCoordinates = new StarCoordinates(1l, 1, 90, new BigDecimal("100"));
        starCoordinatesDTO = new StarCoordinatesDTO("North", new BigDecimal("20"));

        starCoordinatesRepository.save(starCoordinates);
    }

    @AfterEach
    void tearDown() {
        starCoordinatesRepository.deleteAll();
    }

    @Test
    void astronomicalInformation() throws Exception {
        MvcResult mvcResult = mockMvc.perform(

                        get("/stars/coordinates/astronomical")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(List.of(starCoordinates).toString()));

    }

    @Test
    void curiousInformation() throws Exception {
        MvcResult mvcResult = mockMvc.perform(

                        get("stars/coordinates")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(List.of(starCoordinatesDTO).toString()));

    }

    @Test
    void astronomicalInformationStarById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(

                        get("/stars/coordinates/astronomical/" + starCoordinates.getSAO())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(starCoordinates.toString()));

    }

    @Test
    void curiousInformationStarById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(

                        get("/stars/coordinates/" + starCoordinates.getSAO())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(starCoordinatesDTO.toString()));
    }


}