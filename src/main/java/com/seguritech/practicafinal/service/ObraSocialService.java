package com.seguritech.practicafinal.service;

import com.seguritech.practicafinal.domain.ObraSocial;

import java.util.List;

public interface ObraSocialService
{
    List<ObraSocial> findAll();

    ObraSocial findOne(Long id);

    List<ObraSocial> findByNombre(String nombre);

    void save(ObraSocial obraSocial);

    void delete(Long id);
}
