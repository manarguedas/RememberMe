/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Capa_Logica.Constantes.ConstantesComunicacion;
import Capa_Presentacion.GestionarCoordenadas_Presentacion;
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
public class Coordenadas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Coordenadas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Coordenadas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String idFacebook = request.getParameter("token");
        if(idFacebook.contentEquals(ConstantesComunicacion.LLavefacebook)){
                        try {
            int mIdD;
            try {
                mIdD = Integer.parseInt(request.getParameter("idDifunto"));
            } catch (NumberFormatException e) {
                mIdD = 0;
            }
            GestionarCoordenadas_Presentacion consulta = new GestionarCoordenadas_Presentacion();
            SingletonHttp.getInstance().EnviarResultado(response,request, consulta.ConsultarCoordenadas(mIdD));
        } catch (SQLException ex) {
            Logger.getLogger(Eventos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}

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
                String idFacebook = request.getParameter("token");
        if(idFacebook.contentEquals(ConstantesComunicacion.LLavefacebook)){
        GestionarCoordenadas_Presentacion agregar = new GestionarCoordenadas_Presentacion();
         String json = request.getParameter("json");
        System.out.println("Evento: " + json);
        SingletonHttp.getInstance().EnviarResultado(response,request, agregar.AgregarCoordenadas(json)); 
    
    }}

    
         @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String idFacebook = request.getParameter("token");
        if(idFacebook.contentEquals(ConstantesComunicacion.LLavefacebook)){
        int id = -1;
        System.out.println(request.getParameter("id") + "------------");
        String iDifunto = request.getParameter("id");
        if (iDifunto == null) {
            iDifunto = "0";
        }
        id = Integer.parseInt(iDifunto);
        GestionarCoordenadas_Presentacion consulta = new GestionarCoordenadas_Presentacion();
        SingletonHttp.getInstance().EnviarResultado(response,request, consulta.EliminarCoordenada(id));
    }}
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
