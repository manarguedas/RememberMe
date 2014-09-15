/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Capa_Presentacion.AgregarPerfil_Presentacion;
import Capa_Presentacion.ConsultarEventos_Presentacion;
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
public class Eventos extends HttpServlet {

    
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
            ConsultarEventos_Presentacion consulta = new ConsultarEventos_Presentacion();
            SingletonHttp.getInstance().EnviarResultado(response, consulta.ConsultarEventos(mIdD));
        } catch (SQLException ex) {
            Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         GestionarEvento_Presentacion agregar = new GestionarEvento_Presentacion();
         String json = request.getParameter("json");
        System.out.println("Evento: " + json);
        SingletonHttp.getInstance().EnviarResultado(response, agregar.AgregarEvento(json)); 
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
