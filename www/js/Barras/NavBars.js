/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Este archivo contine las diferentes barras de navegacion de la aplicacion

//Cascaron que se utiliza para la barra principal de de navegacion entre los perfiles que tiene el usuario y la busqueda de los mismos 

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

//Cascaron que tiene los detalles de un perfil 
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


var AccionAtras; //variable que se utiliza para almacenar accion del boton de atras

//funcion que se encarga de cambiar la configuracion de la barra, en este caso cambia cual pestana esta activa 
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

//funcion que se llama cuando el usuario presiona back
function HacerBack() {
    eval(AccionAtras); //evalua una instruccion desde un string
}

//configuracion de las acciones del boton atras
function ConfigurarAtras(pIndice, pString) {
    var mResultado = pString;
    var mFuncion = "document.location='perfil.html'";
    var mClase = "glyphicon glyphicon-chevron-left";
    switch (pIndice) { //cambia la accion segun el indice introducico 
        case 1:	//en la pantalla princiapl
            mFuncion = "navigator.app.exitApp();"; //se sale de la aplicacion
            mClase = "glyphicon glyphicon-off";
            break;
        case 2:	//cuando esta viendo el detalle de algun perfil
            mFuncion = "document.location='perfil.html'"; //se devuelve a los perfiles creados por el usuario 
            break;
        case 3:	//cuando se metio a crear biografia, a la localizacion, entre otros
            mFuncion = "document.location='misperfiles.html'"; //se devuelve a los detalles del perfil
            break;
        case 4:	//cuando se metio a agregar o modificar una actividad
            mFuncion = "document.location='Actividades.html'"; //se devuelve a las actividades de ese perfil
            break;
        case 5: //cuando se metio a la galeria para agrgar fotos o algo asi 
            mFuncion = "document.location='Galeria.html'";
            break;
        default:
            break;
    }
    if (sessionStorage.getItem("TipoUsuario") === "0" && pIndice !== 1) {
        mFuncion = "document.location='buscar.html'";	// si estaba en la seccion de busqueda se tiene que devolver a las busquedas 
    }
    AccionAtras = mFuncion;
    document.addEventListener("backbutton", HacerBack, false); //se le agrega el evento de back del telefono

    mResultado = mResultado.replace("{funcion}", mFuncion);
    mResultado = mResultado.replace("{clase}", mClase);

    return mResultado;
}

//configuracion de cual boton esta activo en la barra de actividades
function ConfigurarBarraActividades(pIndice) {
    var mResultado = CuerpoBarraActividades.replace("{" + (pIndice - 1) + "}", "active");
    if (sessionStorage.getItem("TipoUsuario") === "0") {
        pIndice = 0;
    }
    switch (pIndice) {
        case 1: //en la pagina principal 
            ConfigurarAgregarPerfil();
            return;
            break;
        case 2:	//En el detalle de un perfil
            ConfigurarOpecionesPerfil();
            break;
        case 3:	//en la pantalla de las actividades
            ConfigurarAgregarPerfil();
            ConfigurarAgregar();
            break;
        case 4:	//en la pantalla de las actividades
            ConfigurarAgregarPerfil();
            ConfigurarAgregarFotoGaleria();
            break;
        default:
            break;
    }

    var iframe = document.createElement("div");
    iframe.innerHTML = mResultado;
    document.body.appendChild(iframe);
    return mResultado;
}

//se configura el boton de la pantalla principal para agregar un perfil 
function ConfigurarAgregarPerfil() {
    document.getElementById("barraEstado").innerHTML += '<li class="{4} col-xs-3 col-lg-3 BotonAgregarPerfil" >' +
            '<a id = "AgregarHref" onclick="AgregarPerfil();">' +
            '<span class="glyphicon glyphicon-plus"></span>\
                                </a>\
                            </li>';
}

//Configura la interfaz para que el boton de agregar agregue fotos a la galeria 
function ConfigurarAgregarFotoGaleria() {
    alert('cambiando a subir foto');
    document.getElementById("AgregarHref").onclick = SubirFotoGaleria;
    document.getElementById("AgregarHref").href = 'javascript: void(0)';
}

//Se cambian las acciines del borton de agregar un perfil
function ConfigurarAgregar() {
    document.getElementById("AgregarHref").onclick = CrearEvento;
    document.getElementById("AgregarHref").href = "AgregarActividad.html";
}

//Se cambia la accion de agregar un perfil por la de mostrar las opciones en el detalle de un perfil 
function ConfigurarOpecionesPerfil() {
    document.getElementById("barraEstado").innerHTML += '<li class="col-xs-5 col-lg-5 BotonAgregarPerfil" >' +
            '<a id = "AgregarHref" onclick="MostrarOpciones();"' +
            '<span class="glyphicon glyphicon-align-justify"></span>\
                                </a>\
                            </li>';
}

//funcion que se ejecuta cuando se presiona la pestana de mis perfiles 
function onClickMisPerfiles() {
    sessionStorage.setItem("TipoUsuario", "1");
}
//funcion que se ejecuta cuando se presiona el boton de busqueda de perfiles 
function onClickBusquedas() {
    sessionStorage.setItem("TipoUsuario", "0");
}

