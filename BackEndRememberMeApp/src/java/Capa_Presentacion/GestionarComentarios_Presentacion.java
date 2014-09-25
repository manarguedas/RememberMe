/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.GestionarComentarios_Logica;
import Capa_Logica.GestionarCoordenadas_Logica;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class GestionarComentarios_Presentacion {
 
        
    public String AgregarComentario(String jsonComentario){
        GestionarComentarios_Logica gestionar  = new GestionarComentarios_Logica();
        return gestionar.AgregarComentario(jsonComentario);
    }
    
    public String ModificarComentario(String jsonComentario){
        GestionarComentarios_Logica gestionar  = new GestionarComentarios_Logica();
        return gestionar.ModificarComentario(jsonComentario);
    }
    
    public String EliminarComentario(int idComentario){
        GestionarComentarios_Logica gestionar  = new GestionarComentarios_Logica();
        return gestionar.EliminarComentarios(idComentario);
    }
    
        public String ConsultarComentario(int idDifunto) throws SQLException{
        GestionarComentarios_Logica consultar = new GestionarComentarios_Logica();
        return consultar.ConsultarComentarios(idDifunto);
    }
    
}
