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
    static public String RecuperarPerfil = "select pk_perfiles, nombre, apellidos, fecha_nacimiento, fecha_defuncion, dir_foto, id_coordenadas, fk_administradores from PERFILES where pk_perfiles = ";
    static public String GuardarPerfil = "INSERT INTO PERFILES  (nombre, apellidos, fecha_nacimiento, fecha_defuncion, dir_foto, fk_administradores) VALUES";

}