/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcaldiaciudadbolivar.proyecto.modelo.negocio;

import com.alcaldiaciudadbolivar.proyecto.modelo.ConexionModelo;
import com.alcaldiaciudadbolivar.proyecto.modelo.dto.CiudadanoDTO;
import com.alcaldiaciudadbolivar.proyecto.persistencia.ImplementacionDAO.CiudadanoDAO;
import com.alcaldiaciudadbolivar.proyecto.persistencia.entidades.Ciudadano;
import java.util.List;

/**
 *
 * @author Andres
 */
public class CiudadanoNegocio {

    ConexionModelo conexion;
    CiudadanoDAO daoUser;

    public CiudadanoNegocio() {
        conexion = ConexionModelo.getConexion();
        daoUser = new CiudadanoDAO(conexion.getFabricarConexion());
    }

    public void guardarCiudadano(CiudadanoDTO dto) {
        Ciudadano entidad = new Ciudadano();
        entidad.setNombres(dto.getNombres());
        entidad.setApellidos(dto.getApellidos());
        entidad.setIdentificacion(dto.getIdentificacion());
        entidad.setCorreo(dto.getCorreo());
        entidad.setContraseña(dto.getContraseña());
        daoUser.crear(entidad);
    }

    public boolean exiteCorreo(String correo) {
        List<Ciudadano> ciudadano = daoUser.buscarTodosCiudadanos();

        for (Ciudadano q : ciudadano) {
            if (q.getCorreo().equals(correo)) {
                return true;
            }
        }
        return false;
    }

    public boolean exiteIdentificacion(String identificacion) {
        List<Ciudadano> ciudadano = daoUser.buscarTodosCiudadanos();
        for (Ciudadano q : ciudadano) {
            if (q.getIdentificacion().equals(identificacion)) {
                return true;
            }
        }
        return false;
    }
}
