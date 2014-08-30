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
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MarcoNey
 */
public class SingletonHttp extends HttpServlet {

    private static SingletonHttp instance = null;

    private SingletonHttp() {
    }

    public static SingletonHttp getInstance() {
        if (instance == null) {
            instance = new SingletonHttp();
        }
        return instance;
    }

    public void EnviarResultado(HttpServletResponse response, String mResultado)
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

    public void AddEncabezados(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
    }

}
