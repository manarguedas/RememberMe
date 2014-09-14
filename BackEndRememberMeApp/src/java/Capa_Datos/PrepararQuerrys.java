/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Datos.Constantes.ConstBaseDatos;
import Capa_Logica.Biografia;
import static Capa_Logica.Constantes.ConstantesLlavesJson.Biografia;
import Capa_Logica.Evento;
import Capa_Logica.Perfil;

/**
 *
 * @author gustavovargas
 */
public class PrepararQuerrys {
    
    public String RecuperarPerfil(int idDifunto){
        return ConstBaseDatos.RecuperarPerfil+idDifunto;
    }
    
    public String RecuperarPerfiles(int idAdministrador){
        return ConstBaseDatos.RecuperarPerfilesAdmin+idAdministrador;
    }
    
    public String RecuperarPerfilesDato(String dato){
        return ConstBaseDatos.RecuperarPerfiles+"'%"+dato+"%'"+"or apellidos LIKE "+"'%"+dato+"%'";
    }
    
    public String AgregarPerfil(Perfil perfil){
        return ConstBaseDatos.GuardarPerfil+"('"+perfil.getNombre()+"','"+perfil.getApellido()+"','"+perfil.getNacimieno().toString()+"','"+perfil.getDefuncion().toString()+"','"+perfil.getUrlFoto()+"',1)";
    }
    
    public String AgregarEvento(Evento evento){
        return ConstBaseDatos.GuardarEvento+"("+evento.getIdDifunto()+",'"+evento.getFecha().toString()+"','"+evento.getHora()+"','"+evento.getNombre()+"','"+evento.getDescripcion()+"','"+evento.getLugar()+"')";
    }
    
    public String AgregarBiografia(Biografia biografia){
        return ConstBaseDatos.GuardarBiografia+"("+biografia.getIdd()+",'"+biografia.getDescripcion()+"','"+biografia.getNombre()+"')";
    }
    
    public String RecuperarEventos(int idDifunto){
        return ConstBaseDatos.RecuperarEventos+idDifunto;
    }
    
    public String RecuperarBiografias(int idDifunto){
        return ConstBaseDatos.RecuperarBiografia+idDifunto;
    }
    
}
