/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Datos.Conexion;
import Capa_Presentacion.ConsultarEventos_Presentacion;
import Capa_Presentacion.GestionarEvento_Presentacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavovargas
 */
public class NewMain {

    /**
     * @param args the command line arguments
//     */
    public static void main(String[] args) throws SQLException {
        String f = "{\"idd\":\"2\", \"eve\":[{\"id\":\"32\",\"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"},{\"id\":\"33\", \"nom\":\"Vela\",\"des\":\"En la iglesia de no se donde se realizará la vela de juan perez\",\"lug\":\"Alajuela\",\"fec\":\"2014-23-12\",\"hor\":\"11:00\"}]}";
        GestionarEvento_Presentacion w =  new GestionarEvento_Presentacion();
        ConsultarEventos_Presentacion p = new ConsultarEventos_Presentacion();
        System.out.println(p.ConsultarEventos(1));
        //w.AgregarEvento(f);
    }
    
}
