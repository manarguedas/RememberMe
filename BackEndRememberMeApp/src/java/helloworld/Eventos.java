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
public class Eventos extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mIdD = request.getParameter("idDifunto");
        System.out.println(mIdD + "eventos");
        if (mIdD!=null){
            mIdD = "-1";
        }
        SingletonHttp.getInstance().EnviarResultado(response, 
            "{\"idd\":\"101\", \"eve\":[{\"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"},{\"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"}]}");
   }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Evento: " + request.getParameter("json"));
        SingletonHttp.getInstance().EnviarResultado(response, 
                "{\"idd\":\"101\", \"eve\":[{\"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"},{\"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"}]}"); 
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
