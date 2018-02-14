package com.seguritech.practicafinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "obras_sociales" )
public class ObraSocial
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "obra_social_id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
