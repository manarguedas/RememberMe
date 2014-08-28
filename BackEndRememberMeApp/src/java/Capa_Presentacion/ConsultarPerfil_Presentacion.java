/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.ConsultarPerfiles_Logica;

/**
 *
 * @author gustavovargas
 */
public class ConsultarPerfil_Presentacion {

    public ConsultarPerfil_Presentacion() {
    }
    
    public String ConsultarPerfil(int idDifunto){
        ConsultarPerfiles_Logica  consulta = new ConsultarPerfiles_Logica();
        return consulta.ObtenerPerfilDifunto(idDifunto);
}
}
