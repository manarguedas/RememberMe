/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Logica.Constantes.ConstantesLlavesJson;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * PARSE DE JSON PARA PERFILES
 * @author gustavovargas
 */
public class ParseJson_Perfil {

    /**
     * PARSEA UN JSON A UN MODELO PERFIL
     * @param json
     * @return 
     */
    public Perfil ParsePerfilModelo(String json) {
        Perfil perfil = new Perfil();
        try {
            

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

            JSONObject jsonObject1 = ((JSONObject) jsonObject.get(ConstantesLlavesJson.perfil));

            SimpleDateFormat ft = new SimpleDateFormat(ConstantesLlavesJson.formatoFecha);

            String input1 = (String)jsonObject1.get(ConstantesLlavesJson.fechaNacimiento);
            String input2 = (String)jsonObject1.get(ConstantesLlavesJson.fechaDefuncion);
            

            Date nacimiento = ft.parse(input1);
            Date defuncion = ft.parse(input2);
        
            int id =  Integer.parseInt((String)jsonObject1.get(ConstantesLlavesJson.identificador));
            
            String nombre =  (String)jsonObject1.get(ConstantesLlavesJson.nombre);
            String apellidos =  (String)jsonObject1.get(ConstantesLlavesJson.apellido);
            String urlFoto =  (String)jsonObject1.get(ConstantesLlavesJson.urlFoto);
            
            perfil.setNacimieno(nacimiento);
            perfil.setDefuncion(defuncion);
            perfil.setApellido(apellidos);
            perfil.setUrlFoto(urlFoto);
            perfil.setNombre(nombre);
            perfil.setId(id);

            return perfil;
            
        } catch (ParseException ex) {
            Logger.getLogger(ParseJson_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(ParseJson_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perfil;
}
    
    /**
     * PARSEA UN MODELO DE PERFIL COMPLETO A UN JSON
     * 
     * @param perfil
     * @return 
     */
    
    public String ParsePerfilJson(Perfil perfil) {
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();    
        obj.put(ConstantesLlavesJson.nombre, perfil.getNombre());
        obj.put(ConstantesLlavesJson.apellido, perfil.getApellido());
        obj.put(ConstantesLlavesJson.identificador, perfil.getId());
        obj.put(ConstantesLlavesJson.urlFoto, perfil.getUrlFoto());
        obj.put(ConstantesLlavesJson.fechaNacimiento, perfil.getNacimieno().getDate()+"/"+(perfil.getNacimieno().getMonth()+1)+"/"+(perfil.getNacimieno().getYear()+1900));
        obj.put(ConstantesLlavesJson.fechaDefuncion, perfil.getDefuncion().getDate()+"/"+(perfil.getDefuncion().getMonth()+1)+"/"+(perfil.getDefuncion().getYear()+1900));
        obj2.put(ConstantesLlavesJson.perfil, obj);
        return obj2.toJSONString();
    }
    
    /**
     * PARSEA UNA LISTA DE MODELOS DE PERFILES A UN JSON
     * @param perfiles
     * @return 
     */
    public String ParsePerfilesJson(List<Perfil> perfiles) {
        JSONObject obj2 = new JSONObject();
        JSONArray lista = new JSONArray();
        for (Perfil perfil : perfiles) {
        JSONObject obj = new JSONObject();
        obj.put(ConstantesLlavesJson.nombre, perfil.getNombre());
        obj.put(ConstantesLlavesJson.identificador, perfil.getId());
        obj.put(ConstantesLlavesJson.urlFoto, perfil.getUrlFoto());
        lista.add(obj);
        }
        obj2.put(ConstantesLlavesJson.busqueda, lista);
        
        return obj2.toJSONString();
    }
}
