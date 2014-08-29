/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Presentacion.ConsultarPerfil_Presentacion;

/**
 *
 * @author gustavovargas
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String reader = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1820-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\"121\"}}";

        //ParseJson_Perfil py = new ParseJson_Perfil();
        //Perfil l = py.ParsePerfilModelo(reader);
        //System.out.println(p.ParsePerfilJson(l));
        //p.ParsePerfilModelo(reader);
        // TODO code application logic here
        ConsultarPerfil_Presentacion p = new ConsultarPerfil_Presentacion();
        System.out.println(p.ConsultarPerfil(030303));
    }
    
}
