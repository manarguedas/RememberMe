/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.AgregarPerfil_Datos;
import Capa_Datos.GestionarBiografias_Datos;

/**
 *
 * @author gustavovargas
 */
public class AgregarPerfil_Logica {

    public AgregarPerfil_Logica() {
        
    }

    
     public String EliminarPerfil(int idPerfil) {
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        AgregarPerfil_Datos eliminar = new AgregarPerfil_Datos();
            if (eliminar.EliminarPerfil(idPerfil)) {
                return parseConf.Exito(1);
            } else {
                return parseConf.Error();
            }
        }
    public String AgregarPerfil(String jsonDatos, long idFacebook) {
        ParseJson_Perfil parse = new ParseJson_Perfil();
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        Perfil perfil = parse.ParsePerfilModelo(jsonDatos);
        if (perfil.getId() != 0 && idFacebook!=0) {
            AgregarPerfil_Datos guardar = new AgregarPerfil_Datos();
            if (guardar.AgregarPerfil(perfil,idFacebook)) {
                return parseConf.Exito(perfil.getId());
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }
    }
    
    public String modificarPerfil(String jsonDatos) {
        ParseJson_Perfil parse = new ParseJson_Perfil();
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        Perfil perfil = parse.ParsePerfilModelo(jsonDatos);
        if (perfil.getId() != 0) {
            AgregarPerfil_Datos guardar = new AgregarPerfil_Datos();
            if (guardar.ModificarPerfil(perfil)) {
                return parseConf.Exito(perfil.getId());
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }
    }
}
