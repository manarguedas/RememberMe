/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.GestionarEventos_Logica;

/**
 * GESTIONA LOS EVENTOS PRESENTACION
 * @author gustavovargas
 */
public class GestionarEvento_Presentacion {
    
    /**
     * AGREGA UN NUEVO EVENTO
     * @param jsonEvento
     * @return 
     */
    public String AgregarEvento(String jsonEvento){
        GestionarEventos_Logica gestionar  = new GestionarEventos_Logica();
        return gestionar.AgregarEvento(jsonEvento);
    }
    
    /**
     * MODIFICA UN EVENTO
     * @param jsonEvento
     * @return 
     */
     public String ModificarEvento(String jsonEvento){
        GestionarEventos_Logica gestionar  = new GestionarEventos_Logica();
        return gestionar.ModificarEvento(jsonEvento);
    }
    
     /**
      * ELIMINA UN EVENTO
      * @param idEvento
      * @return 
      */
    public String EliminarEvento(int idEvento){
        GestionarEventos_Logica gestionar  = new GestionarEventos_Logica();
        return gestionar.EliminarEvento(idEvento);
    }
    
    
}
