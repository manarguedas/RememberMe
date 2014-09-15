/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Logica.Constantes.ConstantesLlavesJson;
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
public class ParseJson_Coordenada {
   
        public Coordenada ParseCoordenadaModelo(String JsonCoordenada) {
        Coordenada coordenada = new Coordenada();
        try {

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(JsonCoordenada);

            int idDifunto = Integer.parseInt((String) jsonObject.get(ConstantesLlavesJson.idDifunto));

            JSONArray lang = (JSONArray) jsonObject.get(ConstantesLlavesJson.coordenada);

            Iterator i = lang.iterator();

            while (i.hasNext()) {

                JSONObject jsonObject1 = (JSONObject) i.next();
                
                String coordenadaX = (String) jsonObject1.get(ConstantesLlavesJson.coordenadaX);
                String coordenadaY = (String) jsonObject1.get(ConstantesLlavesJson.coordenadaY);
                
                coordenada.setCordX(coordenadaX);
                coordenada.setCordY(coordenadaY);
                coordenada.setIdd(idDifunto);
            }

            return coordenada;

        } catch (ParseException ex) {
            Logger.getLogger(ParseJson_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        coordenada.setIdd(0);
        return coordenada;
    }

    public String ParseCoordenadaJson(List<Coordenada> coordenadas) {

        JSONObject obj = new JSONObject();
        JSONArray lista = new JSONArray();
        for (Coordenada coordenada : coordenadas) {
            obj.put(ConstantesLlavesJson.idDifunto, coordenadas.get(0).getIdd());
            JSONObject obj2 = new JSONObject();
            obj2.put(ConstantesLlavesJson.coordenadaY, coordenada.getCordY());
            obj2.put(ConstantesLlavesJson.coordenadaX, coordenada.getCordX());
            lista.add(obj2);
        }
        obj.put(ConstantesLlavesJson.coordenada, lista);
        return obj.toJSONString();
    }
    
}
