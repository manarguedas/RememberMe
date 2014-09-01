/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var FormatoLineaPerfil = '<a  onclick=AbrirPerfil({1}); class="list-group-item">\
                                <div class="ContenedorPerfil row">\
                                    <div class="col-xs-4" >\
                                        <img src="{2}" alt="" width="100" height="100" class="img-circle">\
                                    </div>\
                                    <div class="col-xs-8">\
                                        <h3  class="col-xs-12">{3}</h3>\
                                    </div>\
                                </div>\
                            </a>';

function CargarBusqueda(pIdUser) {
    $.ajax({
        type: kConstantes.get, // it's easier to read GET request parameters
        url: kConstantes.Servidor + kConstantes.DirBusquedas + "?idUser=" + pIdUser,
        dataType: 'JSON',
        data: {
            json: ""
        },
        success: function(data) {
            CargarTodosPerfiles(data);
        },
        error: function(data) {
            alert('No se pudo conectar con el servidor.');
        }
    });
}

function CargarTodosPerfiles(pOb) {
    var mResultado = "";
    var mResultadoParcial = "";
    for (var i = 0; i < pOb.bus.length; i++) {
        mResultadoParcial = FormatoLineaPerfil.replace("{2}","images/FondoNegro.png");
        mResultadoParcial = mResultadoParcial.replace("{1}",pOb.bus[i].id);
        mResultadoParcial = mResultadoParcial.replace("{3}",pOb.bus[i].nom);
        mResultado += mResultadoParcial;
    }
    $("#ListaPerfiles").html(mResultado);
}

function AbrirPerfil(pIdDifunto){
    sessionStorage.setItem("idDifunto",pIdDifunto);
    location.href = "misperfiles.html";
}