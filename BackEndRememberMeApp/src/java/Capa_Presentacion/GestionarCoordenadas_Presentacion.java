/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.GestionarCoordenadas_Logica;
import java.sql.SQLException;

/**
 * GESTIONA LAS COORDENADAS DE UNA TUMBA
 * @author Administrator
 */
public class GestionarCoordenadas_Presentacion {
        
    /**
     * AGREGA LAS COORDENADAS DE UN DIFUNTO
     * 
     * @param jsonBiografia
     * @return 
     */
    public String AgregarCoordenadas(String jsonBiografia){
        GestionarCoordenadas_Logica gestionar  = new GestionarCoordenadas_Logica();
        return gestionar.AgregarCoordenada(jsonBiografia);
    }
     /**
      * ELIMINA LAS COORDENADAS DE UN DIFUNTO
      * 
      * @param idCoordenada
      * @return 
      */
    public String EliminarCoordenada(int idCoordenada){
        GestionarCoordenadas_Logica gestionar  = new GestionarCoordenadas_Logica();
        return gestionar.EliminarCoordenada(idCoordenada);
    }
  
    /**
     * CONSULTA LAS COORDENADAS DE UN DIFUNTO
     * @param idDifunto
     * @return
     * @throws SQLException 
     */
        public String ConsultarCoordenadas(int idDifunto) throws SQLException{
        GestionarCoordenadas_Logica consultar = new GestionarCoordenadas_Logica();
        return consultar.ConsultarCoordenada(idDifunto);
    }
}
