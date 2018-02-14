package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.ObraSocial;
import com.seguritech.practicafinal.domain.repositories.ObraSocialRepository;
import com.seguritech.practicafinal.service.ObraSocialService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ObraSocialServiceImpl implements ObraSocialService
{

    private final ObraSocialRepository obraSocialRepository;

    public ObraSocialServiceImpl(ObraSocialRepository obraSocialRepository) {
        this.obraSocialRepository = obraSocialRepository;
    }

    @Override
    public List<ObraSocial> findAll() {
        return obraSocialRepository.findAll();
    }

    @Override
    public ObraSocial findOne(Long id) {
        return obraSocialRepository.findOne(id);
    }

    @Override
    public List<ObraSocial> findByNombre(String nombre) {
        return obraSocialRepository.findByNombre(nombre);
    }

    @Override
    public void save(ObraSocial obraSocial) {
        obraSocialRepository.save(obraSocial);
    }

    @Override
    public void delete(Long id) {
        obraSocialRepository.delete(id);
    }
}
