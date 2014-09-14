/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.GestionarCoordenadas_Datos;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class GestionarCoordenadas_Logica {
    
    public String AgregarCoordenada(String jsonCoordenada) {
        ParseJson_Coordenada parse = new ParseJson_Coordenada();
        Coordenada coordenada = parse.ParseCoordenadaModelo(jsonCoordenada);
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        GestionarCoordenadas_Datos guardar = new GestionarCoordenadas_Datos();
        if (coordenada.getIdd() != 0) {
            if (guardar.AgregarCoodenadas(coordenada)) {
                return parseConf.Exito(coordenada.getIdd());
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }

    }
       
    public String ConsultarCoordenada(int idDifunto) throws SQLException{
          GestionarCoordenadas_Datos buscar =  new GestionarCoordenadas_Datos();
          ParseJson_Coordenada parse = new ParseJson_Coordenada();
          return parse.ParseCoordenadaJson(buscar.ObtenerCoordenadasDifunto(idDifunto));
    }
}
