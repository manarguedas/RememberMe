/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Logica.Biografia;
import Capa_Logica.Comentario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class GestionarComentarios_Datos {
    
   public boolean AgregarComentario(Comentario comentario){
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.AgregarComentario(comentario);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
   
   public boolean ModificarComentario(Comentario comentario){
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.ModificarComentario(comentario);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
   
   public boolean EliminarComentario(int idComentario){
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.EliminarComentarios(idComentario);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
    
    
   public List<Comentario> ObtenerComentariosDifunto(int idDifunto) throws SQLException {
        Conexion conexion = new Conexion();
        List<Comentario> comentarios = new ArrayList();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            System.out.println(preparar.RecuperarComentarios(idDifunto,conexion.getConexion()));
            ResultSet resultado = conexion.ejecutarSQLSelect(preparar.RecuperarComentarios(idDifunto,conexion.getConexion()));
            while (resultado.next()) {
                Comentario comentario = new Comentario();
                comentario.setId(resultado.getInt("pk_comentarios"));
                comentario.setNombre(resultado.getString("nombre"));
                comentario.setDescripcion(resultado.getString("descripcion"));
                comentario.setFecha(new Date(resultado.getString("fecha")));
                comentario.setIdd(idDifunto);
                comentarios.add(comentario);
                //String reader = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1820-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\""+idDifunto+"\"}}";
            }
        }
        return comentarios;
    }
    
}
