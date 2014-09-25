/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Logica.Biografia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class GestionarBiografias_Datos {
    
    public boolean AgregarBiografia(Biografia biografia){
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.AgregarBiografia(biografia);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
    
    public boolean ModificarBiografia(Biografia biografia){
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.ModificarBiografia(biografia);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
    
    public boolean EliminarBiografia(int idBiografia){
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.EliminarBiografia(idBiografia);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
    
        public List<Biografia> ObtenerBiografiasDifunto(int idDifunto) throws SQLException {
        Conexion conexion = new Conexion();
        List<Biografia> biografias = new ArrayList();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            System.out.println(preparar.RecuperarBiografias(idDifunto));
            ResultSet resultado = conexion.ejecutarSQLSelect(preparar.RecuperarBiografias(idDifunto));
            while (resultado.next()) {
                Biografia biografia = new Biografia();
                biografia.setId(resultado.getInt("pk_biografia"));
                biografia.setNombre(resultado.getString("titulo"));
                biografia.setDescripcion(resultado.getString("descripcion"));
                biografia.setIdd(idDifunto);
                biografias.add(biografia);
                //String reader = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1820-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\""+idDifunto+"\"}}";
            }
        }
        return biografias;
    }
}
