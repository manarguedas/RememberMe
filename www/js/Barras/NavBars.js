/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var CuerpoBarraInicio = '<nav class="navbar navbar-inverse" role="navigation">' +
                '<div class="navbar-header row BarraPrincipal" align="center">' + 
                    '<div class="ContenedorBotones">' + 
                        '<ul class="nav navbar-nav" >' +
                            '<li class="{1} col-xs-2 BotonAtras">' +
                                '<a href="registro.html">' +
                                    '<span class="glyphicon glyphicon-chevron-left"></span>'+
                                '</a>' +
                            '</li>' + 
                            '<li class="{2} col-xs-5 AnchoBoton">'+
                                '<a href="perfil.html">'+
                                    '<span class="glyphicon glyphicon-user"></span>'+
                                '</a>'+
                            '</li>'+
                            '<li class="{3} col-xs-5 AnchoBoton">'+
                                '<a href="buscar.html">'+
                                    '<span class="glyphicon glyphicon-search"></span>'+
                                '</a>'+
                            '</li>'+ 
                            '<li class="{4} col-xs-3 BotonAgregarPerfil" style="display: {5};">'+
                                '<a id = "AgregarHref" href="AgregarPerfil.html">' +
                                    '<span class="glyphicon glyphicon-plus"></span>\
                                </a>\
                            </li>\
                        </ul>\
                    </div>\
                </div>\
        </nav>' ;


var CuerpoBarraActividades = '<nav class="navbar-default NavBarActividades BarraPrincipal" > \
            <div class="BarraPrincipal"> \
                <div class="ContenedorBotonesActividades BarraPrincipal" align="center"> \
                    <ul class="nav navbar-nav col-xs-12"> \
                        <li class="{1} AnchoBotonPerfil col-xs-3"> \
                            <a href="misperfiles.html"> \
                                <span class="glyphicon glyphicon-user"></span> Perfil</a> \
                        </li > \
                        <li class="{2} AnchoBotonActividades col-xs-6"> \
                            <a href="Actividades.html"> \
                                <span class="glyphicon glyphicon-calendar"></span> Actividades</a> \
                        </li> \
                        <li class="{3} AnchoBotonPerfil col-xs-3"> \
                            <a href="Galeria.html"> \
                                <span class="glyphicon glyphicon-picture"></span> Fotos</a> \
                        </li> \
                    </ul> \
                </div> \
            </div> \
        </nav>';


function ConfigurarBarra(pIndice){
    var mResultado = CuerpoBarraInicio.replace("{" + pIndice + "}","active");
    if (pIndice===3) mResultado = mResultado.replace("{5}","none");
    
    var iframe = document.createElement("div");
    iframe.innerHTML = mResultado;
    document.body.appendChild(iframe);
    
    return mResultado;
}

function ConfigurarBarraActividades(pIndice){
    var mResultado = CuerpoBarraActividades.replace("{" + pIndice + "}","active");
    
    switch(pIndice){
        case 2:
            ConfigurarAgregar();
            break;
    }
    
    var iframe = document.createElement("div");
    iframe.innerHTML = mResultado;
    document.body.appendChild(iframe);
    
    return mResultado;
}

function ConfigurarAgregar(){
    document.getElementById("AgregarHref").href = "AgregarActividad.html";
}