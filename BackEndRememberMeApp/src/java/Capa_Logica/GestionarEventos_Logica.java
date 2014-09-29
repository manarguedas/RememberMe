/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.GestionarEventos_Datos;

/**
 * GESTIONA LOS EVENTOS 
 * @author gustavovargas
 */
public class GestionarEventos_Logica {

    /**
     * AGREGA UN EVENTO
     * @param jsonEvento
     * @return 
     */
    public String AgregarEvento(String jsonEvento) {
        ParseJson_Evento parse = new ParseJson_Evento();
        Evento evento = parse.ParseEventoModelo(jsonEvento);
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        GestionarEventos_Datos guardar = new GestionarEventos_Datos();
        if (evento.getId() != 0) {
            if (guardar.AgregarEvento(evento)) {
                return parseConf.Exito(evento.getId());
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }

    }
    /**
     * MODIFICA UN EVENTO
     * @param jsonEvento
     * @return 
     */
     public String ModificarEvento(String jsonEvento) {
        ParseJson_Evento parse = new ParseJson_Evento();
        Evento evento = parse.ParseEventoModelo(jsonEvento);
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        GestionarEventos_Datos guardar = new GestionarEventos_Datos();
        if (evento.getId() != 0) {
            if (guardar.ModificarEvento(evento)) {
                return parseConf.Exito(evento.getId());
            } else {
                return parseConf.Error();
            }
        } else {
            return parseConf.Error();
        }

    }
    
     /**
      * ELIMINA UN EVENTO
      * @param idEvento
      * @return 
      */
    public String EliminarEvento(int idEvento) {
        ParseJson_Confirmacion parseConf = new ParseJson_Confirmacion();
        GestionarEventos_Datos eliminar = new GestionarEventos_Datos();
            if (eliminar.EliminarEvento(idEvento)) {
                return parseConf.Exito(1);
            } else {
                return parseConf.Error();
            }
        } 
    }
