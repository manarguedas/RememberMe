/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.ObtenerPerfiles_Datos;

/**
 *
 * @author gustavovargas
 */
public class ConsultarPerfiles_Logica {

    public ConsultarPerfiles_Logica() {
    }
    
    
    public String ObtenerPerfilDifunto(int idDifunto){
        ObtenerPerfiles_Datos buscador = new ObtenerPerfiles_Datos();
        ParseJson_Perfil parse = new ParseJson_Perfil();
        Perfil perfil = buscador.ObtenerPerfilDifunto(idDifunto);
        if(perfil.getId()!=0){
            return parse.ParsePerfilJson(perfil);
        }else{
            ParseJson_Confirmacion fallo =  new ParseJson_Confirmacion();
            return fallo.Error();
        }
    }
    
}
