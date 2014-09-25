/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Capa_Presentacion.ConsultarEventos_Presentacion;
import Capa_Presentacion.GestionarBiografias_Presentacion;
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
 * @author MarcoNey
 */
public class Biografias extends HttpServlet {

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
            GestionarBiografias_Presentacion consulta = new GestionarBiografias_Presentacion();
            SingletonHttp.getInstance().EnviarResultado(response, consulta.ConsultarBiografias(mIdD));
        } catch (SQLException ex) {
            Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
        }}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         GestionarBiografias_Presentacion agregar = new GestionarBiografias_Presentacion();
         String json = request.getParameter("json");
        System.out.println("Evento: " + json);
        SingletonHttp.getInstance().EnviarResultado(response, agregar.AgregarBiografia(json)); 
    
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         GestionarBiografias_Presentacion agregar = new GestionarBiografias_Presentacion();
         String json = request.getParameter("json");
        System.out.println("Evento: " + json);
        SingletonHttp.getInstance().EnviarResultado(response, agregar.ModificarBiografia(json)); 
    
    }

     @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idDifunto = -1;
        System.out.println(request.getParameter("id") + "------------");
        String iDifunto = request.getParameter("id");
        if (iDifunto == null) {
            iDifunto = "0";
        }
        idDifunto = Integer.parseInt(iDifunto);
        GestionarBiografias_Presentacion consulta = new GestionarBiografias_Presentacion();
        SingletonHttp.getInstance().EnviarResultado(response, consulta.EliminarBiografia(idDifunto));
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
