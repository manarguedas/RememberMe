/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Logica.Constantes.ConstantesLlavesJson;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author gustavovargas
 */
public class ParseJson_Evento {

    public Evento ParseEventoModelo(String JsonEvento) {
        Evento evento = new Evento();
        try {

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(JsonEvento);

            int idDifunto = Integer.parseInt((String) jsonObject.get(ConstantesLlavesJson.idDifunto));

            JSONArray lang = (JSONArray) jsonObject.get(ConstantesLlavesJson.evento);

            Iterator i = lang.iterator();


                JSONObject jsonObject1 = (JSONObject) i.next();

                SimpleDateFormat ft = new SimpleDateFormat(ConstantesLlavesJson.formatoFecha);

                String input1 = (String) jsonObject1.get(ConstantesLlavesJson.fechaEvento);
                //System.out.println("++++++++> "+input1);
                Date fecha = ft.parse(input1);
                
                int idEvento = Integer.parseInt((String) jsonObject1.get(ConstantesLlavesJson.idEvento));
                String nombre = (String) jsonObject1.get(ConstantesLlavesJson.nombreEvento);
                String lugar = (String) jsonObject1.get(ConstantesLlavesJson.lugarEvento);
                String hora = (String) jsonObject1.get(ConstantesLlavesJson.horaEvento);
                String descripcion = (String) jsonObject1.get(ConstantesLlavesJson.descripcionEvento);

                evento.setFecha(fecha);
                evento.setDescripcion(descripcion);
                evento.setHora(hora);
                evento.setId(idEvento);
                evento.setIdDifunto(idDifunto);
                evento.setLugar(lugar);
                evento.setNombre(nombre);

            return evento;

        } catch (ParseException ex) {
            Logger.getLogger(ParseJson_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(ParseJson_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        evento.setId(0);
        return evento;
    }

    public String ParseEventosJson(List<Evento> eventos) {

        JSONObject obj = new JSONObject();
        JSONArray lista = new JSONArray();
        for (Evento evento : eventos) {
            obj.put(ConstantesLlavesJson.idDifunto, eventos.get(0).getIdDifunto());
            JSONObject obj2 = new JSONObject();
            obj2.put(ConstantesLlavesJson.nombre, evento.getNombre());
            obj2.put(ConstantesLlavesJson.descripcionEvento, evento.getDescripcion());
            obj2.put(ConstantesLlavesJson.idEvento, evento.getId());
            obj2.put(ConstantesLlavesJson.horaEvento, evento.getHora());
            obj2.put(ConstantesLlavesJson.lugarEvento, evento.getLugar());
            obj2.put(ConstantesLlavesJson.fechaEvento, evento.getFecha().getDate()+"/"+(evento.getFecha().getMonth()+1)+"/"+(evento.getFecha().getYear()+1900));
            lista.add(obj2);
        }
        obj.put(ConstantesLlavesJson.evento, lista);
        return obj.toJSONString();
    }

}
