/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Logica;

import java.util.Date;

/**
 *
 * @author gustavovargas
 */
public class Perfil {
    public String nombre;
    public String apellido;
    public String urlFoto;
    public int id;
    public Date nacimieno;
    public Date defuncion;

    public Perfil() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNacimieno() {
        return nacimieno;
    }

    public void setNacimieno(Date nacimieno) {
        this.nacimieno = nacimieno;
    }

    public Date getDefuncion() {
        return defuncion;
    }

    public void setDefuncion(Date defuncion) {
        this.defuncion = defuncion;
    }

    
    
}
