package com.seguritech.practicafinal.service;

import com.seguritech.practicafinal.domain.Medico;

import java.util.List;

public interface MedicoService
{
    List<Medico> findAll();

    Medico findOne(Long id);

    List<Medico> findByNombre(String nombre);

    void save(Medico medico);

    void delete(Long id);
}
