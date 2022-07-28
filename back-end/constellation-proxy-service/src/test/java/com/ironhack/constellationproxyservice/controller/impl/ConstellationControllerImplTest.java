package com.ironhack.constellationproxyservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.constellationproxyservice.client.StarServiceClient;
import com.ironhack.constellationproxyservice.controller.dto.ConstellationCuriousDTO;
import com.ironhack.constellationproxyservice.controller.dto.ConstellationDTO;
import com.ironhack.constellationproxyservice.controller.dto.StarCuriousDTO;
import com.ironhack.constellationproxyservice.controller.dto.StarDTO;
import com.ironhack.constellationproxyservice.repository.ConstellationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
class ConstellationControllerImplTest {

    @Autowired
    private ConstellationRepository constellationRepository;
    @MockBean
    private StarServiceClient starServiceClient;

    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper();

    private ConstellationDTO constellationDTO;
    private ConstellationCuriousDTO constellationCuriousDTO;

    private StarDTO starDTO;
    private StarCuriousDTO starCuriousDTO;

    @BeforeEach
    void setUp() {
        starDTO = new StarDTO(1l, "star", "ALPHA", "ARIES", 1, 1.1, 2.2, 5, 4.2, "", 1.0, 90, new BigDecimal("100"));
        starCuriousDTO = new StarCuriousDTO(1l, "star", "ALPHA", "ARIES", "1", 3.3, "Supergigante", "rojo", "", new BigDecimal("22"));
        constellationDTO = new ConstellationDTO(1l, "ARIES", "star", 5, List.of(starDTO), "", "");
        constellationCuriousDTO = new ConstellationCuriousDTO(1l, "ARIES", "star", 5, List.of(starCuriousDTO), "", "", "");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void astronomicalInformation() throws Exception {
        MvcResult mvcResult = mockMvc.perform(

                        get("/constellations/astronomical")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(constellationDTO.getConstellationName()));

    }

    @Test
    void curiousInformation() throws Exception {
        MvcResult mvcResult = mockMvc.perform(

                        get("/constellations")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(constellationCuriousDTO.getConstellationName()));

    }

    @Test
    void astronomicalInformationById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(

                        get("/constellations/" + constellationDTO.getId())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(constellationCuriousDTO.getConstellationName()));
    }

    @Test
    void curiousInformationById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(

                        get("/constellations/" + constellationDTO.getId())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(constellationCuriousDTO.getConstellationName()));
    }
}