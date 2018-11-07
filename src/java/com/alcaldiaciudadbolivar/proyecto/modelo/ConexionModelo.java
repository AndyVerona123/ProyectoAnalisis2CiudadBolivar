/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcaldiaciudadbolivar.proyecto.modelo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andres
 */
public class ConexionModelo {

    private static ConexionModelo conexion;
    private EntityManagerFactory fabricaConexion;

    private ConexionModelo() {
        fabricaConexion = Persistence.createEntityManagerFactory("ProyectoCiudadBolivarPU");
    }

    public static ConexionModelo getConexion() {
        if (conexion == null) {
            conexion = new ConexionModelo();
        }
        return conexion;
    }

    public EntityManagerFactory getFabricarConexion() {
        return fabricaConexion;
    }
}
