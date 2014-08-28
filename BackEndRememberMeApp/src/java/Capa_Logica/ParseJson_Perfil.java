/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Logica.Constantes.ConstantesLlavesJson;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author gustavovargas
 */
public class ParseJson_Perfil {

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
            
            System.out.println("Id: "+id+" Nombre: "+nombre+" "+apellidos+" url: "+urlFoto+" Dif: "+defuncion+" Nac: "+nacimiento);
            
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
    
    
    public String ParsePerfilJson(Perfil perfil) {

        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();    
        obj.put(ConstantesLlavesJson.nombre, perfil.getNombre());
        obj.put(ConstantesLlavesJson.apellido, perfil.getApellido());
        obj.put(ConstantesLlavesJson.identificador, perfil.getId());
        obj.put(ConstantesLlavesJson.urlFoto, perfil.getUrlFoto());
        obj.put(ConstantesLlavesJson.fechaNacimiento, (perfil.getNacimieno().getYear()+1900)+"-"+(perfil.getNacimieno().getMonth()+1)+"-"+perfil.getNacimieno().getDate());
        obj.put(ConstantesLlavesJson.fechaDefuncion, (perfil.getDefuncion().getYear()+1900)+"-"+(perfil.getDefuncion().getMonth()+1)+"-"+perfil.getDefuncion().getDate());
        obj2.put(ConstantesLlavesJson.perfil, obj);
        return obj2.toJSONString();
    }
}
