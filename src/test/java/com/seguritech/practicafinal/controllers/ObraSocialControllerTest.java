package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.ObraSocial;
import com.seguritech.practicafinal.service.ObraSocialService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObraSocialControllerTest {

    private MockMvc mockMvc;

    private ObraSocialController obraSocialController;

    @Mock
    ObraSocialService obraSocialService;

    public ObraSocialControllerTest(){}

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ObraSocial obraSocial = new ObraSocial();
        obraSocial.setId(1L);
        obraSocial.setNombre("Alcaraz");
        Mockito.when(obraSocialService.findOne(1L)).thenReturn(obraSocial);

        obraSocialController = new ObraSocialController(obraSocialService);

        mockMvc = MockMvcBuilders.standaloneSetup(obraSocialController).build();
    }

    @Test
    public void listAll() {
        System.out.println("listAll");
        List<ObraSocial> pacientes = obraSocialController.listAll();
        assertEquals(0, pacientes.size());
    }
}