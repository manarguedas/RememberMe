/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.GestionarBiografias_Datos;
import Capa_Datos.GestionarComentarios_Datos;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class GestionarBiografias_Logica {
    
    
    public String AgregarBiografia(String jsonBiografia) {
        ParseJson_Biografia parse = new ParseJson_Biografia();
        Biografia biografia = parse.ParseBiografiaModelo(jsonBiografia);
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        GestionarBiografias_Datos guardar = new GestionarBiografias_Datos();
        if (biografia.getId() != 0) {
            if (guardar.AgregarBiografia(biografia)) {
                return parseConf.Exito(biografia.getId());
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }

    }
    
       public String ModificarBiografia(String jsonBiografia) {
        ParseJson_Biografia parse = new ParseJson_Biografia();
        Biografia biografia = parse.ParseBiografiaModelo(jsonBiografia);
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        GestionarBiografias_Datos guardar = new GestionarBiografias_Datos();
        if (biografia.getId() != 0) {
            if (guardar.ModificarBiografia(biografia)) {
                return parseConf.Exito(biografia.getId());
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }

    }
       
    public String EliminarBiografia(int idBiografia) {
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        GestionarBiografias_Datos eliminar = new GestionarBiografias_Datos();
            if (eliminar.EliminarBiografia(idBiografia)) {
                return parseConf.Exito(1);
            } else {
                return parseConf.Error();
            }
        }
       
    public String ConsultarBiografia(int idDifunto) throws SQLException{
          GestionarBiografias_Datos buscar =  new GestionarBiografias_Datos();
          ParseJson_Biografia parse = new ParseJson_Biografia();
          return parse.ParseBiografiasJson(buscar.ObtenerBiografiasDifunto(idDifunto));
    }
}
