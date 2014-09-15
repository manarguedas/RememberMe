/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.AgregarPerfil_Datos;

/**
 *
 * @author gustavovargas
 */
public class AgregarPerfil_Logica {

    public AgregarPerfil_Logica() {
        
    }

    public String AgregarPerfil(String jsonDatos, int idFacebook) {
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
}
