/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

/**
 *
 * @author gustavovargas
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String reader = "{\"perfil\":{\"nom\":\"Ney\",\"ape\":\"Rojas\",\"nac\":\"1920-01-04\",\"def\":\"1980-01-08\",\"url\":\"www.remembermeapp.com/recursos/fotos/121.png\",\"id\":\"121\"}}";

        ParseJason_Perfil p = new ParseJason_Perfil();
        p.ParsePerfilJson();
        //p.ParsePerfilModelo(reader);
        // TODO code application logic here
    }
    
}
