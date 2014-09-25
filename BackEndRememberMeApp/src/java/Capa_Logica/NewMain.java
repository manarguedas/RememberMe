/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.AgregarPerfil_Datos;
import Capa_Datos.GestionarBiografias_Datos;
import Capa_Datos.GestionarComentarios_Datos;
import Capa_Presentacion.AgregarPerfil_Presentacion;
import Capa_Presentacion.ConsultarEventos_Presentacion;
import Capa_Presentacion.ConsultarPerfil_Presentacion;
import Capa_Presentacion.GestionarBiografias_Presentacion;
import Capa_Presentacion.GestionarComentarios_Presentacion;
import Capa_Presentacion.GestionarCoordenadas_Presentacion;
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
        String evento = "{\"idd\":\"3\", \"eve\":[{\"id\":\"10\",\"nom\":\"Vela\",\"des\":\"No se que poner para la prueba\",\"lug\":\"Cartago(Campeon)\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"},{\"id\":\"33\", \"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"}]}";
        String  perfil = "{\"per\":{\"nom\":\"Jorge(Chino)\",\"ape\":\"Bolanos\",\"nac\":\"14/03/2030\",\"def\":\"15/03/2030\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\"10\"}}";
//        ParseJson_Perfil parse = new ParseJson_Perfil();
        
//        Perfil p = parse.ParsePerfilModelo(g);
        String biografia = "{\"idd\":\"1\", \"bio\":[{\"id\":\"10\",\"nom\":\"Joven\",\"des\":\"fue muy malcriado\"},{\"id\":\"10\",\"nom\":\"Adultez\",\"des\":\"fue un gran padre que siempre aconsejo a sus hijo a ser mejores\"}]}";
//        //System.out.println(parse.ParsePerfilJson(p));
       //String h =  "{\"idd\":\"8\", \"cord\":[{\"cordx\":\"564634654\",\"cordy\":\"564635463\"}]}";
        String comentario = "{\"idd\":\"8\", \"com\":[{\"id\":\"2\",\"des\":\"Talves era una buena persona\",\"fec\":\"Nulo\",\"nom\":\"Gustavo Vargas\"}]}";
//String o = "{\"bus\":[{\"id\":\"2\",\"nom\":\"Nombre\",\"url\":\"IMAGEN.png\"},{\"id\":\"1\",\"nom\":\"Nombre\",\"url\":\"IMAGEN.png\"}]}";
        //AgregarPerfil_Datos k = new AgregarPerfil_Datos();
//        //System.out.println(k.AgregarPerfil(p));
        
       // ParseJson_Comentario h = new ParseJson_Comentario();
  
       // Comentario b = h.ParseComentarioModelo(com);
        GestionarBiografias_Presentacion gb = new GestionarBiografias_Presentacion();
        System.out.println("gb "+gb.ModificarBiografia(biografia));
        GestionarComentarios_Presentacion gc = new GestionarComentarios_Presentacion();
        System.out.println("gc " + gc.ModificarComentario(comentario));
        GestionarEvento_Presentacion ge = new GestionarEvento_Presentacion();
        System.out.println("ge " + ge.ModificarEvento(evento));
        AgregarPerfil_Presentacion gp = new AgregarPerfil_Presentacion();
        System.out.println("gp "+gp.EliminarPerfil(8));
       // System.out.println(i.ConsultarCoordenadas(9));
         //List<Comentario> u = new ArrayList();
        //u.add(h.ParseComentarioModelo(com));
        //System.out.println(h.ParseComentarioJson(u));
        //GestionarBiografias_Presentacion i = new GestionarBiografias_Presentacion();
        //System.out.println(i.));
        //System.out.println(h.ParseBiografiasJson(u));
        //GestionarBiografias_Presentacion k = new GestionarBiografias_Presentacion();
        //System.out.println(k.AgregarBiografia(bio));
//        //GestionarEvento_Presentacion k = new GestionarEvento_Presentacion();
//        //System.out.println(k.AgregarEvento(f));
       // AgregarPerfil_Presentacion l = new AgregarPerfil_Presentacion();
        ///ConsultarPerfil_Presentacion j = new ConsultarPerfil_Presentacion();
        //ConsultarEventos_Presentacion p = new ConsultarEventos_Presentacion();
        //System.out.println("Dato:"+p.ConsultarEventos(3));
       // System.out.println(j.ConsultarPerfiles("N"));
        //System.out.println(l.AgregarPerfil(g));
//        //GestionarEvento_Presentacion w =  new GestionarEvento_Presentacion();
//        //w.AgregarEvento(f);
//        //System.out.println(p.ConsultarEventos(1));
//        //w.AgregarEvento(f);
    }
    
}
