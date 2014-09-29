/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.GestionarBiografias_Logica;
import java.sql.SQLException;

/**
 * GESTIONA EL MANEJO DE LAS BIOGRAFIAS 
 * 
 * @author gustavo
 */
public class GestionarBiografias_Presentacion {
    
    /**
     * AGEGA UNA NUEVA BIOGRAFIA
     * 
     * @param jsonBiografia
     * @return MENSAJE DE RESULTADO
     */
    public String AgregarBiografia(String jsonBiografia){
        GestionarBiografias_Logica gestionar  = new GestionarBiografias_Logica();
        return gestionar.AgregarBiografia(jsonBiografia);
    }
    
    /**
     * MODIFICA UNA BIOGRAFIA
     * 
     * @param jsonBiografia
     * @return VALOR DE RESULTADO
     */
    public String ModificarBiografia(String jsonBiografia){
        GestionarBiografias_Logica gestionar  = new GestionarBiografias_Logica();
        return gestionar.ModificarBiografia(jsonBiografia);
    }
    
    /**
     * ELIMINA UNA BIOGRAFIA
     * 
     * @param idBiografia
     * @return 
     */
    public String EliminarBiografia(int idBiografia){
        GestionarBiografias_Logica gestionar  = new GestionarBiografias_Logica();
        return gestionar.EliminarBiografia(idBiografia);
    }
    
    /**
     * CONSULTA ULAS BIOGRAFIAS DE UN DIFUNTO
     * 
     * @param idDifunto
     * @return
     * @throws SQLException 
     */
        public String ConsultarBiografias(int idDifunto) throws SQLException{
        GestionarBiografias_Logica consultar = new GestionarBiografias_Logica();
        return consultar.ConsultarBiografia(idDifunto);
    }
}
