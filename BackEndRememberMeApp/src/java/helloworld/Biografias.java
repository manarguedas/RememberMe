/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MarcoNey
 */
public class Biografias extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Biografias</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Biografias at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SingletonHttp.getInstance().EnviarResultado(response, 
                "{\"idd\":\"101\", \"bio\":[{\"nom\":\"Joven\",\"des\":\"fue muy malcriado\"},{\"nom\":\"Adultez\",\"des\":\"fue un gran padre que siempre aconsejo a sus hijo a ser mejores\"}]}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Biografia:"+request.getParameter("json"));
        SingletonHttp.getInstance().EnviarResultado(response, 
                "{\"idd\":\"101\", \"bio\":[{\"nom\":\"Joven\",\"des\":\"fue muy malcriado\"},{\"nom\":\"Adultez\",\"des\":\"fue un gran padre que siempre aconsejo a sus hijo a ser mejores\"}]}");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
