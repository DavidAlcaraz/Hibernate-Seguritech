package com.seguritech.practicafinal.service.impl;


import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.domain.repositories.MedicoRepository;
import com.seguritech.practicafinal.service.MedicoService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MedicoServiceImpl implements MedicoService
{

    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico findOne(Long id) {
        return medicoRepository.findOne(id);
    }

    @Override
    public List<Medico> findByNombre(String nombre) {
        return medicoRepository.findByNombre(nombre);
    }

    @Override
    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public void delete(Long id) {
        medicoRepository.delete(id);
    }
}
