/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.AgregarPerfil_Datos;
import Capa_Datos.Conexion;
import Capa_Datos.GestionarBiografias_Datos;
import Capa_Presentacion.AgregarPerfil_Presentacion;
import Capa_Presentacion.ConsultarEventos_Presentacion;
import Capa_Presentacion.ConsultarPerfil_Presentacion;
import Capa_Presentacion.GestionarBiografias_Presentacion;
import Capa_Presentacion.GestionarEvento_Presentacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavovargas
 */
public class NewMain {

    /**
//     * @param args the command line arguments
////     */
    public static void main(String[] args) throws SQLException {
//       ConsultarPerfil_Presentacion o = new ConsultarPerfil_Presentacion();
//        System.out.println(o.ConsultarPerfil(3));
////        String f = "{\"idd\":\"3\", \"eve\":[{\"id\":\"32\",\"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"},{\"id\":\"33\", \"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"}]}";
        //String g = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"14/03/2030\",\"def\":\"15/03/2030\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\"1\"}}";
//        ParseJson_Perfil parse = new ParseJson_Perfil();
//        Perfil p = parse.ParsePerfilModelo(g);
        String bio = "{\"idd\":\"9\", \"bio\":[{\"nom\":\"Joven\",\"des\":\"fue muy malcriado\"},{\"nom\":\"Adultez\",\"des\":\"fue un gran padre que siempre aconsejo a sus hijo a ser mejores\"}]}";
//        //System.out.println(parse.ParsePerfilJson(p));
//        //AgregarPerfil_Datos k = new AgregarPerfil_Datos();
//        //System.out.println(k.AgregarPerfil(p));
        //ParseJson_Biografia h = new ParseJson_Biografia();
       // Biografia b = h.ParseBiografiaModelo(bio);
         //List<Biografia> u = new ArrayList();
        //u.add(h.ParseBiografiaModelo(bio));
        GestionarBiografias_Presentacion i = new GestionarBiografias_Presentacion();
        System.out.println(i.ConsultarBiografias(8));
        //System.out.println(h.ParseBiografiasJson(u));
        //GestionarBiografias_Presentacion k = new GestionarBiografias_Presentacion();
        //System.out.println(k.AgregarBiografia(bio));
//        //GestionarEvento_Presentacion k = new GestionarEvento_Presentacion();
//        //System.out.println(k.AgregarEvento(f));
       // AgregarPerfil_Presentacion l = new AgregarPerfil_Presentacion();
        //ConsultarPerfil_Presentacion j = new ConsultarPerfil_Presentacion();
        //ConsultarEventos_Presentacion p = new ConsultarEventos_Presentacion();
        //System.out.println("Dato:"+p.ConsultarEventos(3));
        //System.out.println(j.ConsultarPerfilesAdmin(1));
        //System.out.println(l.AgregarPerfil(g));
//        //GestionarEvento_Presentacion w =  new GestionarEvento_Presentacion();
//        //w.AgregarEvento(f);
//        //System.out.println(p.ConsultarEventos(1));
//        //w.AgregarEvento(f);
    }
    
}
