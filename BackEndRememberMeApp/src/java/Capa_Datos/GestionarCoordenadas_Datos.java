/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Logica.Biografia;
import Capa_Logica.Coordenada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class GestionarCoordenadas_Datos {
    
   public boolean AgregarCoodenadas(Coordenada coordenada){
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.AgregarCoordenada(coordenada);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
   
   public boolean EliminarCoodenadas(int idCoordenada){
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.EliminarCordenada(idCoordenada);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
    
    
        public List<Coordenada> ObtenerCoordenadasDifunto(int idDifunto) throws SQLException {
        Conexion conexion = new Conexion();
        List<Coordenada> coordenadas = new ArrayList();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            System.out.println(preparar.RecuperarCoordenadas(idDifunto,conexion.getConexion()));
            ResultSet resultado = conexion.ejecutarSQLSelect(preparar.RecuperarCoordenadas(idDifunto,conexion.getConexion()));
            while (resultado.next()) {
                Coordenada coordenada = new Coordenada();
                coordenada.setIdd(resultado.getInt("pk_perfiles"));
                coordenada.setCordX(resultado.getString("coordenada_x"));
                coordenada.setCordY(resultado.getString("coordenada_y"));
                coordenadas.add(coordenada);
                //String reader = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1820-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\""+idDifunto+"\"}}";
            }
        }
        return coordenadas;
    }
}
