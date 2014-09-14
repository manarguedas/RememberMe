/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.GestionarCoordenadas_Logica;
import Capa_Logica.GestionarEventos_Logica;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class GestionarCoordenadas_Presentacion {
        
    public String AgregarCoordenadas(String jsonBiografia){
        GestionarCoordenadas_Logica gestionar  = new GestionarCoordenadas_Logica();
        return gestionar.AgregarCoordenada(jsonBiografia);
    }
    
    public String EliminarCoordenada(int idCoordenada){
        GestionarCoordenadas_Logica gestionar  = new GestionarCoordenadas_Logica();
        return gestionar.EliminarCoordenada(idCoordenada);
    }
    
        public String ConsultarCoordenadas(int idDifunto) throws SQLException{
        GestionarCoordenadas_Logica consultar = new GestionarCoordenadas_Logica();
        return consultar.ConsultarCoordenada(idDifunto);
    }
}
