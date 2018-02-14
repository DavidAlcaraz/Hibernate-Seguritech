package com.seguritech.practicafinal.domain.repositories;

import com.seguritech.practicafinal.domain.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObraSocialRepository extends JpaRepository<ObraSocial, Long>
{
    List<ObraSocial> findByNombre(String nombre);
}
