/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.GestionarComentarios_Logica;
import java.sql.SQLException;

/**
 *  GESTIONA LOS COMENTARIOS DE LOS PERFILES DE LOS FALLECIDOS
 * 
 * @author Administrator
 */
public class GestionarComentarios_Presentacion {
 
    /**
     * AGREGA UN NUEVO COMENTARIO
     * 
     * @param jsonComentario
     * @return  VALOR DE RETORNO
     */
    public String AgregarComentario(String jsonComentario){
        GestionarComentarios_Logica gestionar  = new GestionarComentarios_Logica();
        return gestionar.AgregarComentario(jsonComentario);
    }
    
    /**
     * MODIFICA UN COMENTARIO
     * @param jsonComentario
     * @return VALOR DE RETORNO
     */
    public String ModificarComentario(String jsonComentario){
        GestionarComentarios_Logica gestionar  = new GestionarComentarios_Logica();
        return gestionar.ModificarComentario(jsonComentario);
    }
    
    /**
     * ELIMINA UN COMENTARIO
     * @param idComentario
     * @return VALOR DE RETORNO
     */
    public String EliminarComentario(int idComentario){
        GestionarComentarios_Logica gestionar  = new GestionarComentarios_Logica();
        return gestionar.EliminarComentarios(idComentario);
    }
    
    /**
     * CONSULTA LOS COMETARIOS DE UN DIFUNTO
     * @param idDifunto
     * @return COMENTARIOS DEL DIFUNTO
     * @throws SQLException 
     */
    
        public String ConsultarComentario(int idDifunto) throws SQLException{
        GestionarComentarios_Logica consultar = new GestionarComentarios_Logica();
        return consultar.ConsultarComentarios(idDifunto);
    }
    
}
