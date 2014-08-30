/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Datos;

import Capa_Logica.Evento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gustavovargas
 */
public class ObtenerEventos_Datos {

    public List<Evento> ObtenerEventosDifunto(int idDifunto) throws SQLException {
        Conexion conexion = new Conexion();
        List<Evento> eventos = new ArrayList();
        if (conexion.crearConexion()) {
            PrepararQuerrys preparar = new PrepararQuerrys();
            ResultSet resultado = conexion.ejecutarSQLSelect(preparar.RecuperarEventos(idDifunto));
            while (resultado.next()) {
                Evento evento = new Evento();
                evento.setId(resultado.getInt("pk_itinerario"));
                evento.setNombre(resultado.getString("nombre_evento"));
                evento.setDescripcion(resultado.getString("descripcion"));
                evento.setHora(resultado.getString("hora"));
                evento.setIdDifunto(idDifunto);
                evento.setLugar(resultado.getString("lugar"));
                evento.setFecha(new Date(resultado.getString("fecha")));
                eventos.add(evento);
                //String reader = "{\"per\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1820-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\""+idDifunto+"\"}}";
            }
        }
        return eventos;
    }

}
