/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.GestionarEventos_Datos;

/**
 *
 * @author gustavovargas
 */
public class GestionarEventos_Logica {

    public String AgregarEvento(String jsonEvento) {
        ParseJson_Evento parse = new ParseJson_Evento();
        Evento evento = parse.ParseEventoModelo(jsonEvento);
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        GestionarEventos_Datos guardar = new GestionarEventos_Datos();
        if (evento.getId() != 0) {
            if (guardar.AgregarEvento(evento)) {
                return parseConf.Exito();
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }

    }
    
    
    
    
}
