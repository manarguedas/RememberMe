/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.AgregarPerfil_Logica;

/**
 * Clase para el manejo de los perfiles del usuario
 * 
 * @author gustavovargas
 */
public class AgregarPerfil_Presentacion {

    public AgregarPerfil_Presentacion() {
    }
    
    /**
     * AGREGAR UN NUEVO PERIL DE USUARIO
     * 
     * @param jsonPerfil
     * @param idFacebook
     * @return MENSAJE DE CONFIRMACION
     */
    public String AgregarPerfil(String jsonPerfil, long idFacebook){
        AgregarPerfil_Logica agregar = new AgregarPerfil_Logica();
        return agregar.AgregarPerfil(jsonPerfil, idFacebook);
    }
     /**
      * MODIFICAR EL PERFIL DE UN USUARIO
      * 
      * @param jsonPerfil
      * @return MENSAJE DE CONFIRMACION
      */
    public String ModificarPerfil(String jsonPerfil){
        AgregarPerfil_Logica agregar = new AgregarPerfil_Logica();
        return agregar.modificarPerfil(jsonPerfil);
    }
    
    /**
     * ELIMINA EL PERFIL DE UN USUARIO
     * 
     * @param idPerfil
     * @return MENSAJE DE CONFIRMACION
     */
    public String EliminarPerfil(int idPerfil){
        AgregarPerfil_Logica agregar = new AgregarPerfil_Logica();
        return agregar.EliminarPerfil(idPerfil);
    }
}
