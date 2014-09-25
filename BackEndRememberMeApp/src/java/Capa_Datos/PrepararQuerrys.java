/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Datos.Constantes.ConstBaseDatos;
import Capa_Logica.Biografia;
import Capa_Logica.Comentario;
import static Capa_Logica.Constantes.ConstantesLlavesJson.Biografia;
import Capa_Logica.Coordenada;
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
    
    public String AgregarPerfil(Perfil perfil, int idFacebook){
        return ConstBaseDatos.GuardarPerfil+"('"+perfil.getNombre()+"','"+perfil.getApellido()+"','"+perfil.getNacimieno().toString()+"','"+perfil.getDefuncion().toString()+"','"+perfil.getUrlFoto()+"',"+idFacebook+")";
    }
    
    public String AgregarEvento(Evento evento){
        return ConstBaseDatos.GuardarEvento+"("+evento.getIdDifunto()+",'"+evento.getFecha().toString()+"','"+evento.getHora()+"','"+evento.getNombre()+"','"+evento.getDescripcion()+"','"+evento.getLugar()+"')";
    }
    
    public String AgregarBiografia(Biografia biografia){
        return ConstBaseDatos.GuardarBiografia+"("+biografia.getIdd()+",'"+biografia.getDescripcion()+"','"+biografia.getNombre()+"')";
    }
    
    public String AgregarCoordenada(Coordenada coordenada){
        return ConstBaseDatos.GuardarCoordenada+"('"+coordenada.getCordX()+"','"+coordenada.getCordY()+"',"+coordenada.getIdd()+")";
    }
    
    public String AgregarComentario(Comentario comentario){
        return ConstBaseDatos.GuardarComentario+"("+comentario.getIdd()+",'"+comentario.getDescripcion()+"','"+comentario.getNombre()+"','"+comentario.getFecha().toString()+"')";
    }
    
    public String RecuperarEventos(int idDifunto){
        return ConstBaseDatos.RecuperarEventos+idDifunto;
    }
    
    public String RecuperarCoordenadas(int idDifunto){
        return ConstBaseDatos.RecuperarCoodenada+idDifunto;
    }
    
    public String RecuperarBiografias(int idDifunto){
        return ConstBaseDatos.RecuperarBiografia+idDifunto;
    }
    
    public String RecuperarComentarios(int idDifunto){
        return ConstBaseDatos.RecuperarComentarios+idDifunto;
    }
    
    public String EliminarEvento(int idEvento){
        return ConstBaseDatos.EliminarEvento+idEvento;
    }
    
    public String EliminarBiografia(int idBiografia){
        return ConstBaseDatos.EliminarBiografia+idBiografia;
    }
    
    public String EliminarCordenada(int idCoordenada){
        return ConstBaseDatos.EliminarCoordenada+idCoordenada;
    }
    
    public String EliminarComentarios(int idComentarios){
        return ConstBaseDatos.EliminarComentario+idComentarios;
    }
    
    public String EliminarPefil(int idPerfil){
        return ConstBaseDatos.EliminarPerfiles+idPerfil;
    }
}
