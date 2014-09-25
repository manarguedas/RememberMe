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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gustavovargas
 */
public class PrepararQuerrys {
    
    public PreparedStatement RecuperarPerfil(int idDifunto, Connection conexion) throws SQLException{
        PreparedStatement pstmt = conexion.prepareStatement(ConstBaseDatos.RecuperarPerfil);
        pstmt.setInt( 1, idDifunto);
        return pstmt;
    }
    
    public PreparedStatement RecuperarPerfiles(long idAdministrador, Connection conexion) throws SQLException{
        PreparedStatement pstmt = conexion.prepareStatement(ConstBaseDatos.RecuperarPerfilesAdmin);
        pstmt.setLong( 1, idAdministrador);
        return pstmt;
    }
    
    public PreparedStatement RecuperarPerfilesDato(String dato, Connection conexion) throws SQLException{
        PreparedStatement pstmt = conexion.prepareStatement(ConstBaseDatos.RecuperarPerfiles+"'%"+dato+"%'"+"or apellidos LIKE "+"'%"+dato+"%'");
        return pstmt;
}
    
    public String AgregarPerfil(Perfil perfil, long idFacebook){
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
    
    public PreparedStatement RecuperarEventos(int idDifunto, Connection conexion) throws SQLException{
        PreparedStatement pstmt = conexion.prepareStatement(ConstBaseDatos.RecuperarEventos);
        pstmt.setInt( 1, idDifunto);
        return pstmt;
    }
    
    public PreparedStatement RecuperarCoordenadas(int idDifunto, Connection conexion) throws SQLException{
        PreparedStatement pstmt = conexion.prepareStatement(ConstBaseDatos.RecuperarCoodenada);
        pstmt.setInt( 1, idDifunto);
        return pstmt;

    }
    
    public PreparedStatement RecuperarBiografias(int idDifunto, Connection conexion) throws SQLException{
        PreparedStatement pstmt = conexion.prepareStatement(ConstBaseDatos.RecuperarBiografia);
        pstmt.setInt( 1, idDifunto);
        return pstmt;
    }
    
    public PreparedStatement RecuperarComentarios(int idDifunto, Connection conexion) throws SQLException{
        PreparedStatement pstmt = conexion.prepareStatement(ConstBaseDatos.RecuperarComentarios);
        pstmt.setInt( 1, idDifunto);
        return pstmt;
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
    
    public String ModificarPefil(Perfil perfil){
        return "UPDATE PERFILES SET nombre='"+perfil.nombre+"', apellidos='"+perfil.apellido+"', fecha_nacimiento='"+perfil.getNacimieno().toString()+"', fecha_defuncion='"+perfil.getDefuncion().toString()+"' WHERE pk_perfiles = " + perfil.getId();
    }
    
    public String ModificarBiografia(Biografia biografia){
        return "UPDATE BIOGRAFIAS SET descripcion='"+biografia.getDescripcion()+"', titulo='"+biografia.getNombre()+"' WHERE pk_biografia = " + biografia.getId();
    }
    
     public String ModificarEventos(Evento evento){
        return "UPDATE ITINERARIO SET fecha='"+evento.getFecha().toString()+"', hora='"+evento.getHora()+"', nombre_evento='"+evento.getNombre()+"', descripcion='"+evento.getDescripcion()+"', lugar='"+evento.getLugar()+"' WHERE pk_itinerario = " + evento.getId();
    }
     
     public String ModificarComentario(Comentario comentario){
        return "UPDATE COMENTARIOS SET  descripcion='"+comentario.getDescripcion()+"' WHERE pk_comentarios = " + comentario.getId();
    }
    
}
