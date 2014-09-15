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
        return consulta.ObtenerPerfilDifunto(idDifunto);
    }
    
     public String ConsultarPerfilesAdmin(int idAdmin) throws SQLException{
        ConsultarPerfiles_Logica  consulta = new ConsultarPerfiles_Logica();
        return consulta.ObtenerPerfilesAdministrador(idAdmin);
    }
     
     public String ConsultarPerfiles(String dato) throws SQLException{
        ConsultarPerfiles_Logica  consulta = new ConsultarPerfiles_Logica();
        return consulta.ObtenerPerfiles(dato);
    }
}
