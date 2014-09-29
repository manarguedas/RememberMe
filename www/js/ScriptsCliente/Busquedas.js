/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//plantilla que se utiliza para mostrar los resultados de cualquier busqueda
var FormatoLineaPerfil = '<a  onclick=AbrirPerfil({1}); class="list-group-item">\
                                <div class="ContenedorPerfil row">\
                                    <div class="col-xs-4" >\
                                        <img src="{2}" onError="this.src =\'images/FondoNegro.png\'" alt="" width="100" height="100" class="img-circle">\
                                    </div>\
                                    <div class="col-xs-8">\
                                        <h3  class="col-xs-12">{3}</h3>\
                                    </div>\
                                </div>\
                            </a>';

//funcion que pide todos los perfiles creados por una persona
function CargarBusqueda(pIdUser) {
    AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirBusquedas + "?idUser=" + pIdUser, "",
            CargarTodosPerfiles);
}

//funcion que solicita al servidor devolver los perfiles que contengan ese nombre
function CargarBusquedaNombre(pNombre) {
    AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirBusquedasNombre + "?dato=" + pNombre, "",
            CargarTodosPerfiles);
}
//funcion que carga en pantalla todos los perfiles devueltos por el servidor en alguna peticion anterior
function CargarTodosPerfiles(pOb) {
    var mResultado = "";
    var mResultadoParcial = "";
    for (var i = 0; i < pOb.bus.length; i++) { //Comienza a cargar todos los perfiles, utilizando la plantilla
        mResultadoParcial = FormatoLineaPerfil.replace("{2}", kConstantes.DirImagenesAlmacen + pOb.bus[i].id + ".png");
        mResultadoParcial = mResultadoParcial.replace("{1}", pOb.bus[i].id);
        mResultadoParcial = mResultadoParcial.replace("{3}", pOb.bus[i].nom);
        mResultado += mResultadoParcial;
    }
    $("#ListaPerfiles").html(mResultado); //se ingresa la info
}

function AbrirPerfil(pIdDifunto) { //Funcion que se llama cuando se abre un perfil
    sessionStorage.setItem("idDifunto", pIdDifunto);
    location.href = "misperfiles.html";
}

function ExisteImagen(url) { //funcion que se utiliza para ver si la imagen que se solicita existe 
    var element = document.createElement("img");
    element.src = url;
    if (element.src.length === 0) {
        alert("no");
        return false;
    }
    else {
        alert("si");
        return true;
    }
}