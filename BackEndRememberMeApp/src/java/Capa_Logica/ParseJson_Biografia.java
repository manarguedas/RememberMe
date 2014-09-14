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
 * @author Administrator
 */
public class ParseJson_Biografia {
    
    public Biografia ParseBiografiaModelo(String JsonBiografia) {
        Biografia biografia = new Biografia();
        try {

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(JsonBiografia);

            int idDifunto = Integer.parseInt((String) jsonObject.get(ConstantesLlavesJson.idDifunto));

            JSONArray lang = (JSONArray) jsonObject.get(ConstantesLlavesJson.Biografia);

            Iterator i = lang.iterator();

            while (i.hasNext()) {

                JSONObject jsonObject1 = (JSONObject) i.next();
                
                String nombre = (String) jsonObject1.get(ConstantesLlavesJson.nombreBiografia);
                String descripcion = (String) jsonObject1.get(ConstantesLlavesJson.descripcionBiografia);
                
                biografia.setDescripcion(descripcion);
                biografia.setNombre(nombre);
                biografia.setIdd(idDifunto);
            }

            return biografia;

        } catch (ParseException ex) {
            Logger.getLogger(ParseJson_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return biografia;
    }

    public String ParseBiografiasJson(List<Biografia> biografias) {

        JSONObject obj = new JSONObject();
        JSONArray lista = new JSONArray();
        for (Biografia biografia : biografias) {
            obj.put(ConstantesLlavesJson.idDifunto, biografias.get(0).getIdd());
            JSONObject obj2 = new JSONObject();
            obj2.put(ConstantesLlavesJson.nombreBiografia, biografia.getNombre());
            obj2.put(ConstantesLlavesJson.descripcionBiografia, biografia.getDescripcion());
            lista.add(obj2);
        }
        obj.put(ConstantesLlavesJson.evento, lista);
        return obj.toJSONString();
    }
}
