package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.service.MedicoService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicoControllerTest {
    
    private MockMvc mockMvc;

    private MedicoController medicoController;

    @Mock
    private MedicoService medicoService;

    public MedicoControllerTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Medico medico = new Medico();
        medico.setId(1L);
        medico.setNombre("Alcaraz");
        Mockito.when(medicoService.findOne(1L)).thenReturn(medico);

        medicoController = new MedicoController(medicoService);

        mockMvc = MockMvcBuilders.standaloneSetup(medicoController).build();
    }

    @Test
    public void testListAll_0args() {
        System.out.println("listAll");
        List<Medico> listAll = medicoService.findAll();
        assertEquals(0, listAll.size());
    }

    @Test
    public void testGetMedico_isError404WhenMedicoIsNotFound() throws Exception
    {
        System.out.print("getMedico");
        final long id = 2;

        mockMvc.perform(get("/medico/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }




    @Test
    public void testGetMedico_isOkWhenMedicoIsFound() throws Exception {
        System.out.println("getMedico");
        final long id = 1;

        mockMvc.perform(get("/medico/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.nombre").isString());
    }
}
