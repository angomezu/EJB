/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANGOMEZU
 */
@Entity
@Table(name = "DEPARTAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findById", query = "SELECT d FROM Departamento d WHERE d.id = :id"),
    @NamedQuery(name = "Departamento.findByNombre", query = "SELECT d FROM Departamento d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Departamento.findByCantidadEmpleados", query = "SELECT d FROM Departamento d WHERE d.cantidadEmpleados = :cantidadEmpleados"),
    @NamedQuery(name = "Departamento.findByCantidadCajas", query = "SELECT d FROM Departamento d WHERE d.cantidadCajas = :cantidadCajas"),
    @NamedQuery(name = "Departamento.findByEstado", query = "SELECT d FROM Departamento d WHERE d.estado = :estado")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Id
    @SequenceGenerator(name="departamento_sec", sequenceName="sec_departamento", allocationSize = 1 )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="departamento_sec")
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 20)
    @Column(name = "CANTIDAD_EMPLEADOS")
    private String cantidadEmpleados;
    @Size(max = 20)
    @Column(name = "CANTIDAD_CAJAS")
    private String cantidadCajas;
    @Size(max = 100)
    @Column(name = "ESTADO")
    private String estado;

    public Departamento() {
    }

    public Departamento(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(String cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public String getCantidadCajas() {
        return cantidadCajas;
    }

    public void setCantidadCajas(String cantidadCajas) {
        this.cantidadCajas = cantidadCajas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.test.entidades.Departamento[ id=" + id + " ]";
    }
    
}
