/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.ConsultarEventos_Logica;
import Capa_Logica.GestionarBiografias_Logica;
import Capa_Logica.GestionarComentarios_Logica;
import Capa_Logica.GestionarEventos_Logica;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class GestionarBiografias_Presentacion {
    
    
    public String AgregarBiografia(String jsonBiografia){
        GestionarBiografias_Logica gestionar  = new GestionarBiografias_Logica();
        return gestionar.AgregarBiografia(jsonBiografia);
    }
    
    public String EliminarBiografia(int idBiografia){
        GestionarBiografias_Logica gestionar  = new GestionarBiografias_Logica();
        return gestionar.EliminarBiografia(idBiografia);
    }
        public String ConsultarBiografias(int idDifunto) throws SQLException{
        GestionarBiografias_Logica consultar = new GestionarBiografias_Logica();
        return consultar.ConsultarBiografia(idDifunto);
    }
}
