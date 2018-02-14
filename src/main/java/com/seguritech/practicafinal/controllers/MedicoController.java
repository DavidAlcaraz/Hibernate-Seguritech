package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.domain.repositories.MedicoRepository;
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

    @GetMapping("/medico/{id}")
    public ResponseEntity<Medico> getMedico(@PathVariable("id") Long id) {
        Medico medico = medicoService.findOne(id);
        if (medico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medico);
    }

    @GetMapping(value = "/medico", params = {"nombre"})
    public List<Medico> listAll(String nombre) {
        List<Medico> medicos = medicoService.findByNombre(nombre);
        return medicos;
    }

    @PostMapping("/medico")
    public ResponseEntity<Medico> create(@RequestBody Medico medico) throws URISyntaxException {
        medicoService.save(medico);
        return ResponseEntity.created(new URI("/medico/" + medico.getId())).body(medico);
    }

    @PutMapping("/medico")
    public ResponseEntity<Medico> update(@RequestBody Medico medico) throws Exception
    {
        if (medico.getId() == null)
        {
            return ResponseEntity.badRequest().header("X-error", "El id no debe ser null").body(null);
        }
        medicoService.save(medico);
        return ResponseEntity.ok().body(medico);
    }

    @DeleteMapping("/medico/{id}")
    public ResponseEntity<Medico> deleteMedico(@PathVariable("id") Long id)
    {
        medicoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
