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
public class GestionarComentarios_Logica {
    
   public String AgregarComentario(String jsonComentario) {
        ParseJson_Comentario parse = new ParseJson_Comentario();
        Comentario comentario = parse.ParseComentarioModelo(jsonComentario);
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        GestionarComentarios_Datos guardar = new GestionarComentarios_Datos();
        if (comentario.getId() != 0) {
            if (guardar.AgregarComentario(comentario)) {
                return parseConf.Exito(comentario.getId());
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }

    }
       
    public String ConsultarComentarios(int idDifunto) throws SQLException{
          GestionarComentarios_Datos buscar =  new GestionarComentarios_Datos();
          ParseJson_Comentario parse = new ParseJson_Comentario();
          return parse.ParseComentarioJson(buscar.ObtenerComentariosDifunto(idDifunto));
    }
}
