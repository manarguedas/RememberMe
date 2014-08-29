/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Datos.Constantes.ConstBaseDatos;
import Capa_Logica.Perfil;

/**
 *
 * @author gustavovargas
 */
public class PrepararQuerrys {
    
    public String RecuperarPerfil(int idDifunto){
        return ConstBaseDatos.RecuperarPerfil+idDifunto;
    }
    
    public String AgregarPerfil(Perfil perfil){
        return ConstBaseDatos.GuardarPerfil+"('"+perfil.getNombre()+"','"+perfil.getApellido()+"','"+perfil.getNacimieno().toString()+"','"+perfil.getDefuncion().toString()+"','"+perfil.getUrlFoto()+"',1)";
    }
    
}
