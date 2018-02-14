package com.seguritech.practicafinal.service;

import com.seguritech.practicafinal.domain.Paciente;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface PacienteService
{
    List<Paciente> findAll();

    Paciente findOne(Long id);

    List<Paciente> findByName(String name);

    void save(Paciente paciente);

    void delete(Long id);
}
