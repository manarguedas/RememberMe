/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Presentacion;

import Capa_Logica.ConsultarPerfiles_Logica;
import java.sql.SQLException;

/**
 *  CONSULTA PERFILES DE DIFUNTOS EN PRESENTACION
 * 
 * @author gustavovargas
 */
public class ConsultarPerfil_Presentacion {

    public ConsultarPerfil_Presentacion() {
    }
    
    /**
     * CONSULTA EL PERFIL COMPLETO DE UN DIFUNTO
     * 
     * @param idDifunto
     * @return VALOR DE RESULTADO
     * @throws SQLException 
     */
    public String ConsultarPerfil(int idDifunto) throws SQLException{
        ConsultarPerfiles_Logica  consulta = new ConsultarPerfiles_Logica();
        return consulta.ObtenerPerfilDifunto(idDifunto);
    }
    
    /**
     * CONSULTA LOS PERFILES DE UN ADMINISTRADOR EN PRESENTACION
     * 
     * @param idAdmin
     * @return VALOR DE RESULTADO
     * @throws SQLException 
     */
     public String ConsultarPerfilesAdmin(long idAdmin) throws SQLException{
        ConsultarPerfiles_Logica  consulta = new ConsultarPerfiles_Logica();
        return consulta.ObtenerPerfilesAdministrador(idAdmin);
    }
     
     /**
      * CONSULTA LOS PERFILES POR CONCIDENCIA DE BUSQUEDA
      * 
      * @param dato
      * @return PERFILES ENCONRADOS
      * @throws SQLException 
      */
     public String ConsultarPerfiles(String dato) throws SQLException{
        ConsultarPerfiles_Logica  consulta = new ConsultarPerfiles_Logica();
        return consulta.ObtenerPerfiles(dato);
    }
}
