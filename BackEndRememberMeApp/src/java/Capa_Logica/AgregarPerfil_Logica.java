/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.AgregarPerfil_Datos;
import Capa_Datos.GestionarBiografias_Datos;

/**
 * AGREGAR PERFILES CAPA LOGICA
 * @author gustavovargas
 */
public class AgregarPerfil_Logica {

    public AgregarPerfil_Logica() {
        
    }

    /**
     * ELIMINA UN PERFIL
     * @param idPerfil
     * @return 
     */
     public String EliminarPerfil(int idPerfil) {
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion(); // MENSAJE DE EXITO
        AgregarPerfil_Datos eliminar = new AgregarPerfil_Datos();
            if (eliminar.EliminarPerfil(idPerfil)) { // ELIMINA EL PERFIL
                return parseConf.Exito(1);
            } else {
                return parseConf.Error();
            }
        }
     
     /**
      * AGREGA UN PERFIL
      * @param jsonDatos
      * @param idFacebook
      * @return 
      */
    public String AgregarPerfil(String jsonDatos, long idFacebook) {
        ParseJson_Perfil parse = new ParseJson_Perfil();
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        Perfil perfil = parse.ParsePerfilModelo(jsonDatos);
        if (perfil.getId() != 0 && idFacebook!=0) { // VERIFICA QUE EL PERFIL VENGA COMPLETO
            AgregarPerfil_Datos guardar = new AgregarPerfil_Datos();
            if (guardar.AgregarPerfil(perfil,idFacebook)) { // AGREGA EL PERFIL
                return parseConf.Exito(perfil.getId());
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }
    }
    
    /**
     * MODIFICA UN PERFIL
     * @param jsonDatos
     * @return 
     */
    public String modificarPerfil(String jsonDatos) {
        ParseJson_Perfil parse = new ParseJson_Perfil();
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        Perfil perfil = parse.ParsePerfilModelo(jsonDatos); //PARSE DEL JSON DEL PERFIL
        if (perfil.getId() != 0) {
            AgregarPerfil_Datos guardar = new AgregarPerfil_Datos();
            if (guardar.ModificarPerfil(perfil)) { // MODIFICA EL PERFIL
                return parseConf.Exito(perfil.getId()); 
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }
    }
}
