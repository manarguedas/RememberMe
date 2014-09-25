/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos.Constantes;

/**
 *
 * @author gustavovargas
 */
public class ConstBaseDatos {
    
    static public String RecuperarBiografia = "select pk_biografia, fk_pefiles,descripcion, titulo from BIOGRAFIAS where fk_pefiles = ?";
    static public String RecuperarPerfil = "select pk_perfiles, nombre, apellidos, fecha_nacimiento, fecha_defuncion, dir_foto, idAdministrador from PERFILES where pk_perfiles = ?";
    static public String RecuperarPerfilesAdmin = "select pk_perfiles, nombre, apellidos, dir_foto from PERFILES where idAdministrador = ?";
    static public String RecuperarPerfiles = "select pk_perfiles, nombre, apellidos, dir_foto from PERFILES where nombre LIKE ";
    static public String GuardarPerfil = "INSERT INTO PERFILES  (nombre, apellidos, fecha_nacimiento, fecha_defuncion, dir_foto, idAdministrador) VALUES";
    static public String GuardarEvento = "INSERT INTO ITINERARIO  (fk_pefiles, fecha, hora, nombre_evento, descripcion, lugar) VALUES";
    static public String GuardarBiografia = "INSERT INTO BIOGRAFIAS (fk_pefiles,descripcion, titulo) VALUES";
    static public String GuardarComentario = "INSERT INTO COMENTARIOS (fk_pefil_difunto,descripcion, nombre, fecha) VALUES";
    static public String RecuperarEventos = "select pk_itinerario, fk_pefiles, fecha, hora, nombre_evento, descripcion, lugar from ITINERARIO where fk_pefiles = ?";
    static public String RecuperarComentarios = "select pk_comentarios, fk_pefil_difunto, fecha, nombre, descripcion from COMENTARIOS where fk_pefil_difunto = ?";
    static public String RecuperarCoodenada = "select pk_perfiles, coordenada_x, coordenada_y from COORDENADAS where pk_perfiles = ?";
    static public String GuardarCoordenada = "INSERT INTO COORDENADAS (coordenada_x,coordenada_y,pk_perfiles) VALUES";
    static public String EliminarEvento = "DELETE FROM ITINERARIO WHERE pk_itinerario = ";
    static public String EliminarBiografia = "DELETE FROM BIOGRAFIAS WHERE pk_biografia = ";
    static public String EliminarCoordenada = "DELETE FROM COORDENADAS WHERE pk_perfiles = ";
    static public String EliminarComentario = "DELETE FROM COMENTARIOS WHERE pk_comentarios = ";
    static public String EliminarPerfiles = "DELETE FROM PERFILES WHERE pk_perfiles = ";
}
