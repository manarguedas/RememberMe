/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.AgregarPerfil_Datos;
import Capa_Datos.Conexion;
import Capa_Datos.ObtenerPerfiles_Datos;
import Capa_Datos.PrepararQuerrys;
import Capa_Presentacion.AgregarPerfil_Presentacion;
import Capa_Presentacion.ConsultarPerfil_Presentacion;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gustavovargas
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        //String reader = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1820-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\"121\"}}";
//        Conexion c = new Conexion();
//        c.crearConexion();
//        c.ejecutarSQL("INSERT INTO ADMINISTRADORES  ( nombre, apellidos, fecha_nacimiento, fecha_defuncion, dir_foto) VALUES('Ney','Rojas','Tue Jan 04 00:00:00 CST 1820','Tue Jan 08 00:00:00 CST 1980','www.remembermeapp.com/recursos/fotos/121.png')");
        String reader = "{\"idd\":\"101\", \"eve\":[{\"id\":\"32\",\"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"},{\"id\":\"64\",\"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"}]}";
//        ParseJson_Evento p = new ParseJson_Evento();
//        Evento []eventos = new Evento[10];
//        for (int i = 0; i < 10; i++) {
//            eventos[i] = p.ParseEventoModelo(reader);
//            System.out.println("id evento: "+eventos[i].getId());
//        }
        //System.out.println(eventos[0].getId());
        //System.out.println(eventos.length);
        //System.out.println(eventos[0].getIdDifunto());
        //System.out.println(eventos[5].getIdDifunto());
//        System.out.println(p.ParsePerfilJson(eventos));
        //ResultSet p = c.ejecutarSQLSelect("select * from ADMINISTRADORES");
        //p.
        //AgregarPerfil_Presentacion e = new AgregarPerfil_Presentacion();
        //e.AgregarPerfil(reader);
        //String u = "INSERT INTO ADMINISTRADORES  (pk_administradores , Correo ) VALUES (2, 'nose.com')";
        //c.ejecutarSQL(u);
        //ParseJson_Perfil py = new ParseJson_Perfil();
        //ObtenerPerfiles_Datos r = new ObtenerPerfiles_Datos();
        //Perfil l = r.ObtenerPerfilDifunto(1);
        //AgregarPerfil_Datos p = new AgregarPerfil_Datos();
       // p.AgregarPerfil(l);
        //System.out.println(p.ParsePerfilJson(l));
        //p.ParsePerfilModelo(reader);
        // TODO code application logic here
        //ConsultarPerfil_Presentacion p = new ConsultarPerfil_Presentacion();
        ///System.out.println(p.ConsultarPerfil(030303));
    }
    
}
