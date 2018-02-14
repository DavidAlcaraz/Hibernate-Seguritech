package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Paciente;
import com.seguritech.practicafinal.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PacienteController
{
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping(value = "/paciente")
    public List<Paciente> listAll()
    {
        List<Paciente> pacientes = pacienteService.findAll();
        System.out.print(pacientes.size());
        return pacientes;
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<Paciente> getPaciente(@PathVariable("id") Long id)
    {
        Paciente paciente = pacienteService.findOne(id);
        if (paciente == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }

    @GetMapping(value = "paciente", params = {"nombre"})
    public List<Paciente> listAll(String name)
    {
        List<Paciente> pacientes = pacienteService.findByName(name);
        return pacientes;
    }

    @PostMapping("/paciente")
    public ResponseEntity<Paciente> create (@RequestBody Paciente paciente) throws URISyntaxException
    {
        if (paciente.getId() != null)
        {
            return ResponseEntity.badRequest().header("X-error", "El id debe ser null").body(null);
        }
        pacienteService.save(paciente);
        return ResponseEntity.created(new URI("/paciente" + paciente.getId())).body(paciente);
    }

    @PutMapping("/paciente")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente) throws Exception
    {
        if(paciente.getId() == null)
        {
            return ResponseEntity.badRequest().header("X-error", "El id debe ser null").body(null);
        }
        pacienteService.save(paciente);
        return ResponseEntity.ok().body(paciente);
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Paciente> deleteRol(@PathVariable("id") Long id)
    {
        pacienteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
