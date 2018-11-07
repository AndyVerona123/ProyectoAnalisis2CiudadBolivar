/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcaldiaciudadbolivar.proyecto.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "ciudadanos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudadano.findAll", query = "SELECT c FROM Ciudadano c")
    , @NamedQuery(name = "Ciudadano.findByUsuarioId", query = "SELECT c FROM Ciudadano c WHERE c.usuarioId = :usuarioId")
    , @NamedQuery(name = "Ciudadano.findByNombres", query = "SELECT c FROM Ciudadano c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "Ciudadano.findByApellidos", query = "SELECT c FROM Ciudadano c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Ciudadano.findByIdentificacion", query = "SELECT c FROM Ciudadano c WHERE c.identificacion = :identificacion")
    , @NamedQuery(name = "Ciudadano.findByCorreo", query = "SELECT c FROM Ciudadano c WHERE c.correo = :correo")
    , @NamedQuery(name = "Ciudadano.findByContrase\u00f1a", query = "SELECT c FROM Ciudadano c WHERE c.contrase\u00f1a = :contrase\u00f1a")})
public class Ciudadano implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Column(name = "contrase\u00f1a")
    private String contraseña;

    public Ciudadano() {
    }

    public Ciudadano(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Ciudadano(Integer usuarioId, String nombres, String apellidos, String identificacion, String correo) {
        this.usuarioId = usuarioId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudadano)) {
            return false;
        }
        Ciudadano other = (Ciudadano) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alcaldiaciudadbolivar.proyecto.persistencia.entidades.Ciudadano[ usuarioId=" + usuarioId + " ]";
    }

}
