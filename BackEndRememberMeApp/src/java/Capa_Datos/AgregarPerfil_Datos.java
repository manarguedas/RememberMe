/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Logica.Perfil;

/**
 *
 * @author gustavovargas
 */
public class AgregarPerfil_Datos {

    public AgregarPerfil_Datos() {
    }
    
    public boolean AgregarPerfil(Perfil perfil){
        // Agregar el perfil a la base de datos
        System.out.println("Perfil agregado");
        
        return true;
    }
}
