/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import Capa_Logica.ParseJson_Perfil;
import Capa_Logica.Perfil;

/**
 *
 * @author gustavovargas
 */
public class ObtenerPerfiles_Datos {

    public ObtenerPerfiles_Datos() {
    }
    
    
    public Perfil ObtenerPerfilDifunto(int idDifunto){
        System.out.println("IdDifunto: "+idDifunto);
        String reader = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1820-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\""+idDifunto+"\"}}";
        ParseJson_Perfil p = new ParseJson_Perfil();
        Perfil l = p.ParsePerfilModelo(reader);
        return l;
    }
}
