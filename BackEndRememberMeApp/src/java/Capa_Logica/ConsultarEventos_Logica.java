/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.GestionarEventos_Datos;
import Capa_Datos.ObtenerEventos_Datos;
import java.sql.SQLException;

/**
 * CONSULTA EVENTOS EN CAPA LOGICA
 * @author gustavovargas
 */
public class ConsultarEventos_Logica {
    
    /**
     * 
     * CONSULTA EVENTOS DE UN DIFUNTO
     * @param idDifunto
     * @return
     * @throws SQLException 
     */
      public String ConsultarEventos(int idDifunto) throws SQLException{
          ObtenerEventos_Datos buscar =  new ObtenerEventos_Datos();
          ParseJson_Evento parse = new ParseJson_Evento();
          return parse.ParseEventosJson(buscar.ObtenerEventosDifunto(idDifunto)); // CONSULTA LOS EVENTOS
    }
      
      
}
