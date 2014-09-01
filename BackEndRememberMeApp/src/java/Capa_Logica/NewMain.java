/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.AgregarPerfil_Datos;
import Capa_Datos.Conexion;
import Capa_Presentacion.AgregarPerfil_Presentacion;
import Capa_Presentacion.ConsultarEventos_Presentacion;
import Capa_Presentacion.ConsultarPerfil_Presentacion;
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
//        //System.out.println(parse.ParsePerfilJson(p));
//        //AgregarPerfil_Datos k = new AgregarPerfil_Datos();
//        //System.out.println(k.AgregarPerfil(p));
//        //GestionarEvento_Presentacion k = new GestionarEvento_Presentacion();
//        //System.out.println(k.AgregarEvento(f));
       // AgregarPerfil_Presentacion l = new AgregarPerfil_Presentacion();
        ConsultarPerfil_Presentacion j = new ConsultarPerfil_Presentacion();
        System.out.println(j.ConsultarPerfilesAdmin(1));
        //System.out.println(l.AgregarPerfil(g));
//        //GestionarEvento_Presentacion w =  new GestionarEvento_Presentacion();
//        //w.AgregarEvento(f);
//        //System.out.println(p.ConsultarEventos(1));
//        //w.AgregarEvento(f);
    }
    
}
