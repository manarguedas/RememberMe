/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var CuerpoBarraInicio = '<nav class="navbar navbar-inverse BarraPrincipal" role="navigation">' +
        '<div class="ContenedorBotones">' +
        '<div class="nav navbar-header" align="center">' +
        '<ul id="barraEstado" class="nav navbar-nav" >' +
        '<li class="{1} col-xs-2 col-md-2 BotonAtras">' +
        '<a id="btnAtras" onclick="{funcion}" >' +
        '<span class="{clase}"></span>' +
        '</a>' +
        '</li>' +
        '<li class="{2} col-xs-5 col-md-4 AnchoBoton">' +
        '<a href="perfil.html" onclick="onClickMisPerfiles();">' +
        '<span class="glyphicon glyphicon-user"></span>' +
        '</a>' +
        '</li>' +
        '<li class="{3} col-xs-5 col-md-4 AnchoBoton">' +
        '<a href="buscar.html" onclick="onClickBusquedas();">' +
        '<span class="glyphicon glyphicon-search"></span>' +
        '</a>' +
        '</li>' +
        '</ul>\
                    </div>\
                </div>\
        </nav>\n\
';
var CuerpoBarraActividades = '<nav class="navbar-default BarraActividades" > \
            <div class=""> \
                <div class="ContenedorBotonesActividades" align="center"> \
                    <ul class="nav navbar-nav col-xs-12 col-lg-12"> \
                        <li class="{1} AnchoBotonPerfil col-xs-3 col-lg-3"> \
                            <a href="misperfiles.html"> \
                                <span class="glyphicon glyphicon-user"></span> Perfil</a> \
                        </li > \
                        <li class="{2} AnchoBotonActividades col-xs-6 col-lg-6"> \
                            <a href="Actividades.html"> \
                                <span class="glyphicon glyphicon-calendar"></span> Actividades</a> \
                        </li> \
                        <li class="{3} AnchoBotonPerfil col-xs-3 col-lg-3"> \
                            <a href="Galeria.html"> \
                                <span class="glyphicon glyphicon-picture"></span> Fotos</a> \
                        </li> \
                    </ul> \
                </div> \
            </div> \
        </nav>\n\
<br><br><br><br><br><br>';

var AccionAtras;

function ConfigurarBarra(pIndice, pAtras) {
    var mResultado = CuerpoBarraInicio.replace("{" + pIndice + "}", "active");
    mResultado = ConfigurarAtras(pAtras, mResultado);
    //if (pIndice === 3)
    //    mResultado = mResultado.replace("{5}", "none");
    var iframe = document.createElement("div");
    iframe.innerHTML = mResultado;
    document.body.appendChild(iframe);
    return mResultado;
}

function HacerBack() {
    eval(AccionAtras);
}

function ConfigurarAtras(pIndice, pString) {
    var mResultado = pString;
    var mFuncion = "document.location='perfil.html'";
    var mClase = "glyphicon glyphicon-chevron-left";
    switch (pIndice) {
        case 1:
            mFuncion = "navigator.app.exitApp();";
            mClase = "glyphicon glyphicon-off";
            break;
        case 2:
            mFuncion = "document.location='perfil.html'";
            break;
        case 3:
            mFuncion = "document.location='misperfiles.html'";
            break;
        case 4:
            mFuncion = "document.location='Actividades.html'";
            break;
        case 5:
            mFuncion = "document.location='Galeria.html'";
            break;
        default:
            break;
    }
    if (sessionStorage.getItem("TipoUsuario") === "0" && pIndice!==1) {
        mFuncion = "document.location='buscar.html'";
    }
    AccionAtras = mFuncion;
    document.addEventListener("backbutton", HacerBack, false);

    mResultado = mResultado.replace("{funcion}", mFuncion);
    mResultado = mResultado.replace("{clase}", mClase);

    return mResultado;
}

function ConfigurarBarraActividades(pIndice) {
    var mResultado = CuerpoBarraActividades.replace("{" + (pIndice - 1) + "}", "active");
    if (sessionStorage.getItem("TipoUsuario") === "0") {
        pIndice = 0;
    }
    switch (pIndice) {
        case 1:
            ConfigurarAgregarPerfil();
            return;
            break;
        case 2:
            ConfigurarOpecionesPerfil();
            break;
        case 3:
            ConfigurarAgregarPerfil();
            ConfigurarAgregar();
            break;
        default:
            break;
    }

    var iframe = document.createElement("div");
    iframe.innerHTML = mResultado;
    document.body.appendChild(iframe);
    return mResultado;
}

function ConfigurarAgregarPerfil() {
    document.getElementById("barraEstado").innerHTML += '<li class="{4} col-xs-3 col-lg-3 BotonAgregarPerfil" >' +
            '<a id = "AgregarHref" onclick="AgregarPerfil();">' +
            '<span class="glyphicon glyphicon-plus"></span>\
                                </a>\
                            </li>';
}

function ConfigurarAgregar() {
    document.getElementById("AgregarHref").onclick = CrearEvento;
    document.getElementById("AgregarHref").href = "AgregarActividad.html";
}

function ConfigurarOpecionesPerfil() {
    document.getElementById("barraEstado").innerHTML += '<li class="col-xs-5 col-lg-5 BotonAgregarPerfil" >' +
            '<a id = "AgregarHref" onclick="MostrarOpciones();"' +
            '<span class="glyphicon glyphicon-align-justify"></span>\
                                </a>\
                            </li>';
}

function onClickMisPerfiles() {
    sessionStorage.setItem("TipoUsuario", "1");
}

function onClickBusquedas() {
    sessionStorage.setItem("TipoUsuario", "0");
}

