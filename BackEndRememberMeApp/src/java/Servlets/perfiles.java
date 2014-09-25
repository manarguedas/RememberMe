/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Capa_Datos.AgregarPerfil_Datos;
import Capa_Presentacion.AgregarPerfil_Presentacion;
import Capa_Presentacion.ConsultarPerfil_Presentacion;
import java.io.BufferedReader;
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
public class perfiles extends HttpServlet {

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

        response.setContentType("application/json");
        AddEncabezados(response);
        PrintWriter out = response.getWriter();
        try {
            String json = request.getParameter("json");
            /* TODO output your page here. You may use following sample code. */
            out.println(json);
            out.flush();
        } finally {
            out.close();
        }
    }

    protected void EnviarResultado(HttpServletResponse response, String mResultado)
            throws ServletException, IOException {
        AddEncabezados(response);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            out.println(mResultado);
            out.flush();
        } finally {
            out.close();
        }
    }

    private String GetDifunto(int pIdDifunto) throws SQLException {
        ConsultarPerfil_Presentacion consulta = new ConsultarPerfil_Presentacion();
        return consulta.ConsultarPerfil(pIdDifunto);
    }

    private void AddEncabezados(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
    }

    protected void enviarJson(HttpServletRequest request, HttpServletResponse response) {
        try {
            //TODO: externalize the Allow-Origin
            AddEncabezados(response);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println("{");
            out.println("\"First Name\": \"Devesh\",");
            out.println("\"Last Name\": \"Sharma\"");
            out.println("}");
            out.close();
        } catch (IOException e) {
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
        
        //processRequest(request, response);
        try {
            int idDifunto = -1;
            System.out.println(request.getParameter("idDifunto") + "------------");
            String iDifunto = request.getParameter("idDifunto");

            if (iDifunto == null 
                    ) {
                iDifunto = "0";
            }
            idDifunto = Integer.parseInt(iDifunto);
            EnviarResultado(response, GetDifunto(idDifunto));
        } catch (SQLException ex) {
            Logger.getLogger(perfiles.class.getName()).log(Level.SEVERE, null, ex);
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
        String json = request.getParameter("json");
        int mIdD;
            try {
                mIdD = Integer.parseInt(request.getParameter("idFacebook"));
            } catch (NumberFormatException e) {
                mIdD = 0;
            }
        AgregarPerfil_Presentacion agregar = new AgregarPerfil_Presentacion();
        EnviarResultado(response, agregar.AgregarPerfil(json,mIdD));
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String json = request.getParameter("json");
        int mIdD;
            try {
                mIdD = Integer.parseInt(request.getParameter("idFacebook"));
            } catch (NumberFormatException e) {
                mIdD = 0;
            }
        AgregarPerfil_Presentacion actualizar = new AgregarPerfil_Presentacion();
        SingletonHttp.getInstance().EnviarResultado(response, actualizar.ModificarPerfil(json));
    
    }
    
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idDifunto = -1;
        System.out.println(request.getParameter("idDifunto") + "------------");
        String iDifunto = request.getParameter("idDifunto");
        if (iDifunto == null) {
            iDifunto = "0";
        }
        idDifunto = Integer.parseInt(iDifunto);
        AgregarPerfil_Presentacion consulta = new AgregarPerfil_Presentacion();
        SingletonHttp.getInstance().EnviarResultado(response, consulta.EliminarPerfil(idDifunto));
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
