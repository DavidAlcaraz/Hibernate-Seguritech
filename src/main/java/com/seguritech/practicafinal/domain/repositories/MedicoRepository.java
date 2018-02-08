package com.seguritech.practicafinal.domain.repositories;

import com.seguritech.practicafinal.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long>
{
    List<Medico> findByDescripcion (String descripcion);
}
