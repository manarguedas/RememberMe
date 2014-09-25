/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;


import Capa_Presentacion.GestionarComentarios_Presentacion;
import Capa_Presentacion.GestionarEvento_Presentacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class Comentarios extends HttpServlet {


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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
            int mIdD;
            try {
                mIdD = Integer.parseInt(request.getParameter("idDifunto"));
            } catch (NumberFormatException e) {
                mIdD = 0;
            }
            GestionarComentarios_Presentacion consulta = new GestionarComentarios_Presentacion();
            SingletonHttp.getInstance().EnviarResultado(response,request, consulta.ConsultarComentario(mIdD));
        } catch (SQLException ex) {
            Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 GestionarComentarios_Presentacion agregar = new GestionarComentarios_Presentacion();
         String json = request.getParameter("json");
        System.out.println("Evento: " + json);
        SingletonHttp.getInstance().EnviarResultado(response,request, agregar.AgregarComentario(json)); 
    }
    
     @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 GestionarComentarios_Presentacion agregar = new GestionarComentarios_Presentacion();
         String json = request.getParameter("json");
        System.out.println("Evento: " + json);
        SingletonHttp.getInstance().EnviarResultado(response,request, agregar.ModificarComentario(json)); 
    }
    
     @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = -1;
        System.out.println(request.getParameter("id") + "------------");
        String iDifunto = request.getParameter("id");
        if (iDifunto == null) {
            iDifunto = "0";
        }
        id = Integer.parseInt(iDifunto);
        GestionarComentarios_Presentacion consulta = new GestionarComentarios_Presentacion();
        SingletonHttp.getInstance().EnviarResultado(response,request, consulta.EliminarComentario(id));
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
