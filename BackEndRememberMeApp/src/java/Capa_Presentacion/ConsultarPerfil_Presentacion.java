/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.ConsultarPerfiles_Logica;
import java.sql.SQLException;

/**
 *
 * @author gustavovargas
 */
public class ConsultarPerfil_Presentacion {

    public ConsultarPerfil_Presentacion() {
    }
    
    public String ConsultarPerfil(int idDifunto) throws SQLException{
        ConsultarPerfiles_Logica  consulta = new ConsultarPerfiles_Logica();
        //return consulta.ObtenerPerfilDifunto(idDifunto);
        if (idDifunto==0) return "{\"men\":\"0\"}";
        return "{\"perfil\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"dd/mm/aaaa\",\"def\":\"dd/mm/aaaa\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":121}}";
    }
}
