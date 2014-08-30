/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.GestionarEventos_Logica;

/**
 *
 * @author gustavovargas
 */
public class GestionarEvento_Presentacion {
    
    
    public String AgregarEvento(String jsonEvento){
        GestionarEventos_Logica gestionar  = new GestionarEventos_Logica();
        return gestionar.AgregarEvento(jsonEvento);
    }
    
}
