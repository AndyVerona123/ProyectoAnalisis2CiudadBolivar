/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcaldiaciudadbolivar.proyecto.controlador;

import com.alcaldiaciudadbolivar.proyecto.modelo.dto.CiudadanoDTO;
import com.alcaldiaciudadbolivar.proyecto.modelo.negocio.CiudadanoNegocio;
import java.io.IOException;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class ServletCiudadano extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        recuperarAccion(request, response);
    }

    //Procesas las acciones que llegan de la vista hacia el servlet
    public void recuperarAccion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("Guardar")) {
            guardarUsuario(request, response);
        }
    }

    public void guardarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombres = request.getParameter("nombre");
        String apellidos = request.getParameter("apellido");
        String identificacion = request.getParameter("cedula");
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contra");
        CiudadanoDTO dto = new CiudadanoDTO();
        dto.setNombres(nombres);
        dto.setApellidos(apellidos);
        dto.setIdentificacion(identificacion);
        dto.setCorreo(correo);
        dto.setContraseña(contraseña);
        CiudadanoNegocio datos = new CiudadanoNegocio();
        try {
            if (datos.exiteCorreo(correo) != true) {
                if (datos.exiteIdentificacion(identificacion) != true) {
                    datos.guardarCiudadano(dto);
                    request.setAttribute("mensaje", "Ok, Usuario " + nombres + " " + apellidos + " fue agregado al sistema");
                    request.getRequestDispatcher("web/ciudadano/guardar.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", "Esta identificacion ya se encuentra registrada");
                    request.getRequestDispatcher("web/ciudadano/guardar.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("mensaje", "Este correo ya se encuentra registrado");
                request.getRequestDispatcher("web/ciudadano/guardar.jsp").forward(request, response);
            }

        } catch (Exception error) {
            if (error instanceof PersistenceException) {
                request.setAttribute("mensaje", "Problemas con el servidor de la base de datos");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "ha ocurrido un error desconocido");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
