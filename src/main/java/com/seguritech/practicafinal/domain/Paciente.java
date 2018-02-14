package com.seguritech.practicafinal.domain;

import org.aspectj.weaver.GeneratedReferenceTypeDelegate;

import javax.persistence.*;

/**
 *
 * @author Werner
 */
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "paciente_id")
    private Long id;

    private Long dni;

    @Column(name = "nombre")
    private String name;

    @Column(name = "obra_social_id")
    private Long obraSocial;

    private String estado;

    @Column(name = "fecha_creacion")
    private String fecha;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(Long obrasocial) {
        this.obraSocial = obrasocial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
