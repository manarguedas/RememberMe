/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.ConsultarEventos_Logica;
import java.sql.SQLException;

/**
 * CONSULTA VENTOS DE UN DIFUNTO EN CAPA DE PRESENTACION
 * 
 * @author gustavovargas
 */
public class ConsultarEventos_Presentacion {
    
    /**
     * CONSULTA EVENTOS DE UN DIFUNTO
     * @param idDifunto
     * @return MENSAJE DE CONFIAMCION
     * @throws SQLException 
     */
    public String ConsultarEventos(int idDifunto) throws SQLException{
        ConsultarEventos_Logica consultar = new ConsultarEventos_Logica();
        return consultar.ConsultarEventos(idDifunto);
    }
}
