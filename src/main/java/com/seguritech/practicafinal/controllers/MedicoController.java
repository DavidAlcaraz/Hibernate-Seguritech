package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.service.MedicoService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MedicoController
{

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService)
    {
        this.medicoService = medicoService;
    }

    @GetMapping(value = "/medico")
    public List<Medico> listAll()
    {
        List<Medico> medicos = medicoService.findAll();
        System.out.print(medicos.size());
        return medicos;
    }
}
