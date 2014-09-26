/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

function CargarBusqueda(pIdUser) {
    AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirBusquedas + "?idUser=" + pIdUser, "",
            CargarTodosPerfiles);
}

function CargarBusquedaNombre(pNombre) {
    AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirBusquedasNombre + "?dato=" + pNombre, "",
            CargarTodosPerfiles);
}

function CargarTodosPerfiles(pOb) {
    var mResultado = "";
    var mResultadoParcial = "";
    for (var i = 0; i < pOb.bus.length; i++) {
        mResultadoParcial = FormatoLineaPerfil.replace("{2}", kConstantes.DirImagenesAlmacen + pOb.bus[i].id + ".png");
        mResultadoParcial = mResultadoParcial.replace("{1}", pOb.bus[i].id);
        mResultadoParcial = mResultadoParcial.replace("{3}", pOb.bus[i].nom);
        mResultado += mResultadoParcial;
    }
    $("#ListaPerfiles").html(mResultado);
}

function AbrirPerfil(pIdDifunto) {
    sessionStorage.setItem("idDifunto", pIdDifunto);
    location.href = "misperfiles.html";
}

function ExisteImagen(url) {
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