package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Paciente;
import com.seguritech.practicafinal.service.PacienteService;
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

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.service.MedicoService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.http.MediaType;

import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteControllerTest {

    private MockMvc mockMvc;

    private PacienteController pacienteController;

    @Mock
    PacienteService pacienteService;

    public PacienteControllerTest(){}

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setName("Alcaraz");
        Mockito.when(pacienteService.findOne(1L)).thenReturn(paciente);

        pacienteController = new PacienteController(pacienteService);

        mockMvc = MockMvcBuilders.standaloneSetup(pacienteController).build();
    }

    @Test
    public void testlistAll() {
        System.out.println("listAll");
        List<Paciente> pacientes = pacienteController.listAll();
        assertEquals(0, pacientes.size());
    }

    @Test
    public void testGetPaciente_isError404WhenPacienteIsNotFound() throws Exception {
        System.out.print("getPaciente");
        final long id = 2;

        mockMvc.perform(get("/paciente/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }
}