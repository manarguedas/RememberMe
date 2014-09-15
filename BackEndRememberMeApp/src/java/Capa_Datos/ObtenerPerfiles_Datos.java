/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Logica.Evento;
import Capa_Logica.ParseJson_Perfil;
import Capa_Logica.Perfil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gustavovargas
 */
public class ObtenerPerfiles_Datos {

    public ObtenerPerfiles_Datos() {
    }

    public Perfil ObtenerPerfilDifunto(int idDifunto) throws SQLException {
        Conexion conexion = new Conexion();
        Perfil perfil = new Perfil();
        if(conexion.crearConexion()){
        PrepararQuerrys preparar = new PrepararQuerrys();
        ResultSet resultado = conexion.ejecutarSQLSelect(preparar.RecuperarPerfil(idDifunto));
        if (resultado.next()) {
            perfil.setId(resultado.getInt("pk_perfiles"));
            perfil.setNombre(resultado.getString("nombre"));
            perfil.setApellido(resultado.getString("apellidos"));
            perfil.setUrlFoto(resultado.getString("dir_foto"));
            perfil.setDefuncion(new Date(resultado.getString("fecha_defuncion")));
            perfil.setNacimieno(new Date(resultado.getString("fecha_nacimiento")));
            //String reader = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1820-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\""+idDifunto+"\"}}";
        } else {
            perfil.setId(0);
        }
        }else{
            perfil.setId(0);
        }
        return perfil;
    }
    
   public List<Perfil> ObtenerPerfilesAdmin(int idAdmin) throws SQLException {
        Conexion conexion = new Conexion();
        List<Perfil> perfiles = new ArrayList();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            ResultSet resultado = conexion.ejecutarSQLSelect(preparar.RecuperarPerfiles(idAdmin));
            while (resultado.next()) {
                Perfil perfil = new Perfil();
                perfil.setId(resultado.getInt("pk_perfiles"));
                perfil.setNombre(resultado.getString("nombre"));
                perfil.setApellido(resultado.getString("apellidos"));
                perfil.setUrlFoto(resultado.getString("dir_foto"));
                perfiles.add(perfil);
                //String reader = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1820-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\""+idDifunto+"\"}}";
            }
        }
        return perfiles;
    }
   
   
      public List<Perfil> ObtenerPerfiles(String dato) throws SQLException {
        Conexion conexion = new Conexion();
        List<Perfil> perfiles = new ArrayList();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            ResultSet resultado = conexion.ejecutarSQLSelect(preparar.RecuperarPerfilesDato(dato));
            while (resultado.next()) {
                Perfil perfil = new Perfil();
                perfil.setId(resultado.getInt("pk_perfiles"));
                perfil.setNombre(resultado.getString("nombre"));
                perfil.setApellido(resultado.getString("apellidos"));
                perfil.setUrlFoto(resultado.getString("dir_foto"));
                perfiles.add(perfil);
                //String reader = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1820-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\""+idDifunto+"\"}}";
            }
        }
        return perfiles;
    }
}
