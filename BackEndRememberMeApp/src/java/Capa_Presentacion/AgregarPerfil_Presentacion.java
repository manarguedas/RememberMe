/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.AgregarPerfil_Logica;

/**
 *
 * @author gustavovargas
 */
public class AgregarPerfil_Presentacion {

    public AgregarPerfil_Presentacion() {
    }
    
    public String AgregarPerfil(String jsonPerfil, int idFacebook){
        AgregarPerfil_Logica agregar = new AgregarPerfil_Logica();
        return agregar.AgregarPerfil(jsonPerfil, idFacebook);
    }
}
