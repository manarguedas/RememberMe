/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Logica.Constantes.ConstantesLlavesJson;
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
 * @author Administrator
 */
public class ParseJson_Comentario {
  
        
    public Comentario ParseComentarioModelo(String JsonComentario) {
        Comentario comentario = new Comentario();
        try {

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(JsonComentario);

            int idDifunto = Integer.parseInt((String) jsonObject.get(ConstantesLlavesJson.idDifunto));

            JSONArray lang = (JSONArray) jsonObject.get(ConstantesLlavesJson.comentario);

            Iterator i = lang.iterator();

            while (i.hasNext()) {

                JSONObject jsonObject1 = (JSONObject) i.next();
                
                String nombre = (String) jsonObject1.get(ConstantesLlavesJson.nombreComentario);
                String descripcion = (String) jsonObject1.get(ConstantesLlavesJson.descripcionComentario);
                
                comentario.setDescripcion(descripcion);
                comentario.setNombre(nombre);
                comentario.setIdd(idDifunto);
                comentario.setFecha(new Date());
                comentario.setId(1);
            }

            return comentario;

        } catch (ParseException ex) {
            Logger.getLogger(ParseJson_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        comentario.setId(0);
        return comentario;
    }

    public String ParseComentarioJson(List<Comentario> comentarios) {

        JSONObject obj = new JSONObject();
        JSONArray lista = new JSONArray();
        for (Comentario comentario : comentarios) {
            obj.put(ConstantesLlavesJson.idDifunto, comentarios.get(0).getIdd());
            JSONObject obj2 = new JSONObject();
            obj2.put(ConstantesLlavesJson.fechaComentario, comentario.getFecha().getDate()+"/"+(comentario.getFecha().getMonth()+1)+"/"+(comentario.getFecha().getYear()+1900));
            obj2.put(ConstantesLlavesJson.identificador, comentario.getId());
            obj2.put(ConstantesLlavesJson.nombreComentario, comentario.getNombre());
            obj2.put(ConstantesLlavesJson.descripcionComentario, comentario.getDescripcion());
            lista.add(obj2);
        }
        obj.put(ConstantesLlavesJson.comentario, lista);
        return obj.toJSONString();
    }
    
}
