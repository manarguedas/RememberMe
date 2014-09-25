/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Capa_Logica.Constantes.ConstantesComunicacion;

/**
 *
 * @author Administrator
 */
public class SingletonVerificacion {
    
   private static SingletonVerificacion instance = null;

    private SingletonVerificacion() {
    }

    public static SingletonVerificacion getInstance() {
        if (instance == null) {
            instance = new SingletonVerificacion();
        }
        return instance;
    }

    public boolean EnviarResultado(int idFacebook){
        
        if(idFacebook == ConstantesComunicacion.LLavefacebook){
            return true;
        }else{
            return false;
        }
    }
}
