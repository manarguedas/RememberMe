/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.ObtenerPerfiles_Datos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gustavovargas
 */
public class ConsultarPerfiles_Logica {

    public ConsultarPerfiles_Logica() {
    }
    
    
    public String ObtenerPerfilDifunto(int idDifunto) throws SQLException{
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
    
    public String ObtenerPerfilesAdministrador(int idAdmin) throws SQLException{
        ObtenerPerfiles_Datos buscador = new ObtenerPerfiles_Datos();
        List<Perfil> perfiles = buscador.ObtenerPerfilesAdmin(idAdmin);
        ParseJson_Perfil parse = new ParseJson_Perfil();
        return parse.ParsePerfilesJson(perfiles);
    }
    
    public String ObtenerPerfiles(String dato) throws SQLException{
        ObtenerPerfiles_Datos buscador = new ObtenerPerfiles_Datos();
        List<Perfil> perfiles = buscador.ObtenerPerfiles(dato);
        ParseJson_Perfil parse = new ParseJson_Perfil();
        return parse.ParsePerfilesJson(perfiles);
    }
    
}
