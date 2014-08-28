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

    public String AgregarPerfil(String jsonDatos) {
        ParseJson_Perfil parse = new ParseJson_Perfil();
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        Perfil perfil = parse.ParsePerfilModelo(jsonDatos);
        if (perfil.getId() != 0) {
            AgregarPerfil_Datos guardar = new AgregarPerfil_Datos();
            if (guardar.AgregarPerfil(perfil)) {
                return parseConf.Exito();
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }
    }
}
