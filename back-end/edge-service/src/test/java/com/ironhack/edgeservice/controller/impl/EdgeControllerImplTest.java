package com.ironhack.edgeservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.edgeservice.client.AmateurServiceClient;
import com.ironhack.edgeservice.client.ConstellationServiceClient;
import com.ironhack.edgeservice.client.EventServiceClient;
import com.ironhack.edgeservice.client.StarServiceClient;
import com.ironhack.edgeservice.controller.dto.*;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class EdgeControllerImplTest {

    @MockBean
    private StarServiceClient starServiceClient;

    @MockBean
    private ConstellationServiceClient constellationServiceClient;

    @MockBean
    private EventServiceClient eventServiceClient;

    @MockBean
    private AmateurServiceClient amateurServiceClient;

    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper(); // Contruir Objetos JSON a partir de clase de JAVA

    private StarDTO starDTO;
    private StarCuriousDTO starCuriousDTO;
    private ConstellationDTO constellationDTO;
    private ConstellationCuriousDTO constellationCuriousDTO;
    private EventDTO eventDTO;
    private AmateurDTO amateurDTO;
    private Amateur amateur;
    private AmateurAttendEventDTO amateurAttendEventDTO;

    @BeforeEach
    void setUp() {
        starDTO = new StarDTO(1l, "star", "ALPHA", "ARIES", 1, 1.1, 2.2, 5, 4.2, "", 1.0, 90, new BigDecimal("100"));
        starCuriousDTO = new StarCuriousDTO(1l, "star", "ALPHA", "ARIES", 1, 3.3, "Supergigante", "rojo", "", new BigDecimal("22"), "");
        constellationDTO = new ConstellationDTO(1l, "ARIES", "star", 5, List.of(starDTO), "", "", "");
        constellationCuriousDTO = new ConstellationCuriousDTO(1l, "ARIES", "star", 5, List.of(starCuriousDTO), "", "", "");
        amateurDTO = new AmateurDTO(1l, "amateur", "amateur@hotmail.com", 5, "123456", "");
        amateur = new Amateur(1l, "amateur", "amateur@hotmail.com", 5, "123456", "");
        eventDTO = new EventDTO(1l, "event", "02/08/2022", "Algeciras", "", "");
        amateurAttendEventDTO = new AmateurAttendEventDTO(amateurDTO.getId(), eventDTO.getId());
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void astronomicalInformationConstellation() throws Exception {
        Mockito.when(constellationServiceClient.astronomicalInformation()).thenReturn(List.of(constellationDTO));
        MvcResult mvcResult = mockMvc.perform(

                        get("/constellations/astronomical")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(constellationDTO.getConstellationName()));
    }


    @Test
    void curiousInformationConstellation() throws Exception {
        Mockito.when(constellationServiceClient.curiousInformation()).thenReturn(List.of(constellationCuriousDTO));
        MvcResult mvcResult = mockMvc.perform(

                        get("/constellations")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(constellationCuriousDTO.getConstellationName()));

    }

    @Test
    void astronomicalInformationConstellationById() throws Exception {
        Mockito.when(constellationServiceClient.astronomicalInformationById(constellationDTO.getId())).thenReturn(constellationDTO);
        MvcResult mvcResult = mockMvc.perform(

                        get("/constellations/astronomical/" + constellationDTO.getId())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(constellationDTO.getConstellationName()));
    }

    @Test
    void curiousInformationConstellationById() throws Exception {
        Mockito.when(constellationServiceClient.curiousInformationById(constellationCuriousDTO.getId())).thenReturn(constellationCuriousDTO);
        MvcResult mvcResult = mockMvc.perform(

                        get("/constellations/" + constellationDTO.getId())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(constellationCuriousDTO.getConstellationName()));
    }

    @Test
    void astronomicalInformationStar() throws Exception {
        Mockito.when(starServiceClient.astronomicalInformation()).thenReturn(List.of(starDTO));
        MvcResult mvcResult = mockMvc.perform(

                        get("/stars/astronomical")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(starDTO.getStarName()));
    }

    @Test
    void curiousInformationStar() throws Exception {
        Mockito.when(starServiceClient.curiousInformation()).thenReturn(List.of(starCuriousDTO));
        MvcResult mvcResult = mockMvc.perform(

                        get("/stars")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(starCuriousDTO.getStarName()));
    }

    @Test
    void curiousInformationByConstellation() {
    }

    @Test
    void astronomicalInformationStarById() throws Exception {
        Mockito.when(starServiceClient.astronomicalInformationStarById(starDTO.getSAO())).thenReturn(starDTO);
        MvcResult mvcResult = mockMvc.perform(

                        get("/stars/astronomical/" + starDTO.getSAO())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(starDTO.getStarName()));
    }

    @Test
    void curiousInformationStarById() throws Exception {
        Mockito.when(starServiceClient.curiousInformationStarById(starCuriousDTO.getSAO())).thenReturn(starCuriousDTO);
        MvcResult mvcResult = mockMvc.perform(

                        get("/stars/" + starDTO.getSAO())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(starCuriousDTO.getStarName()));
    }

    @Test
    void findAll() throws Exception {
        Mockito.when(amateurServiceClient.findAll()).thenReturn(List.of(amateurDTO));
        MvcResult mvcResult = mockMvc.perform(

                        get("/amateurs")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(amateurDTO.getName()));
    }

    @Test
    void getAmateurById() throws Exception {
        Mockito.when(amateurServiceClient.getAmateurById(amateurDTO.getId())).thenReturn(amateurDTO);
        MvcResult mvcResult = mockMvc.perform(

                        get("/amateurs/" + amateurDTO.getId())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(amateurDTO.getName()));
    }

    @Test
    void findAllEvents() throws Exception {
        Mockito.when(eventServiceClient.findAll()).thenReturn(List.of(eventDTO));
        MvcResult mvcResult = mockMvc.perform(

                        get("/events")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(eventDTO.getEventName()));
    }

    @Test
    void findEventById() throws Exception {
        Mockito.when(eventServiceClient.findById(eventDTO.getId())).thenReturn(eventDTO);
        MvcResult mvcResult = mockMvc.perform(

                        get("/events/" + eventDTO.getId())
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains(eventDTO.getEventName()));
    }

}
