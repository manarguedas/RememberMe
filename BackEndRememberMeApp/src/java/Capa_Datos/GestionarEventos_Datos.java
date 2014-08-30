/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Logica.Evento;

/**
 *
 * @author gustavovargas
 */
public class GestionarEventos_Datos {
    
    
    public boolean AgregarEvento(Evento evento){
        Conexion conexion = new Conexion();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            String querry = preparar.AgregarEvento(evento);
            System.out.println(querry);
            return conexion.ejecutarSQL(querry);
        } else {
            return false;
        }
    }
}
