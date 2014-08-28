/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ParseJason_Perfil {

    public Perfil ParsePerfilModelo(String json) {
        
        try {
            Perfil perfil = new Perfil();

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

            JSONObject jsonObject1 = ((JSONObject) jsonObject.get("perfil"));

            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

            String input1 = (String)jsonObject1.get("nac");
            String input2 = (String)jsonObject1.get("def");
            

            Date nacimiento = ft.parse(input1);
            Date defuncion = ft.parse(input2);
        
            int id =  Integer.parseInt((String)jsonObject1.get("id"));
            
            String nombre =  (String)jsonObject1.get("nom");
            String apellidos =  (String)jsonObject1.get("ape");
            String urlFoto =  (String)jsonObject1.get("url");
            
            System.out.println("Id: "+id+" Nombre: "+nombre+" "+apellidos+" url: "+urlFoto+" Dif: "+defuncion+" Nac: "+nacimiento);
            
            perfil.setNacimieno(nacimiento);
            perfil.setDefuncion(defuncion);
            perfil.setApellido(apellidos);
            perfil.setUrlFoto(urlFoto);
            perfil.setNombre(nombre);
            perfil.setId(id);

            return perfil;
            
        } catch (ParseException ex) {
            Logger.getLogger(ParseJason_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(ParseJason_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
    
    
    public String ParsePerfilJson() {

        JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try {

            FileWriter file = new FileWriter("/Users/gustavovargas/Desktop/test.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);
        return "";
    }
}
