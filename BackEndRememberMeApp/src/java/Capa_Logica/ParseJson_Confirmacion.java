/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import Capa_Logica.Constantes.ConstantesComunicacion;
import org.json.simple.JSONObject;

/**
 *
 * @author gustavovargas
 */
public class ParseJson_Confirmacion {
    
    public String Error(){
        JSONObject obj = new JSONObject();
        obj.put(ConstantesComunicacion.LLaveMensaje, ConstantesComunicacion.fallo);
        return obj.toJSONString();
    }
    
    
    public String Exito(){
        JSONObject obj = new JSONObject();
        obj.put(ConstantesComunicacion.LLaveMensaje, ConstantesComunicacion.exito);
        return obj.toJSONString();
    }
    
}
