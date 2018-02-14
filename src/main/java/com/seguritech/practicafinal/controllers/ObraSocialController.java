package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.ObraSocial;
import com.seguritech.practicafinal.service.ObraSocialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObraSocialController
{
    private final ObraSocialService obraSocialService;

    public ObraSocialController(ObraSocialService obraSocialService) {
        this.obraSocialService = obraSocialService;
    }

    @GetMapping(value = "/obra")
    public List<ObraSocial> listAll()
    {
        List<ObraSocial> obras = obraSocialService.findAll();
        System.out.print(obras.size());
        return obras;
    }

    @GetMapping(value = "/obra/{id}")
    public ResponseEntity<ObraSocial> getObra(@PathVariable("id") Long id)
    {
        ObraSocial obraSocial = obraSocialService.findOne(id);
        if (obraSocial == null)
        {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obraSocial);
    }
}
