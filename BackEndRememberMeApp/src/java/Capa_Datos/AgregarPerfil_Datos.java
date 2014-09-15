/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Logica.Perfil;
import java.sql.ResultSet;

/**
 *
 * @author gustavovargas
 */
public class AgregarPerfil_Datos {

    public AgregarPerfil_Datos() {
    }

    public boolean AgregarPerfil(Perfil perfil, int idFacebook) {
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.AgregarPerfil(perfil,idFacebook);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
    
    
    // Funcion en prueba
    public boolean EliminarPerfil(Perfil perfil, int idFacebook) {
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.AgregarPerfil(perfil,idFacebook);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
}
