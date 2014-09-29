
//onmousedown="ClickDown(GuardarDato,{6});" onmouseup="ClickUp();"


//Cascara que almacena el formato de las actividades
var FormatoEvento = '<div id="a{6}" class="panel panel-primary"> \
                    <div class="panel-heading"> \
                        <h5 class="panel-title">{1}</h5>\
                        <h6>Lugar: {2}, Fecha: {3}, Hora: {4} </h6>\
                    </div>\
                    <div class="panel-body">\
                        <small>{5}</small>\
                    </div>\
                </div>';

//estrutura de una actividad 
function Evento() {
    this.nom = "";
    this.des = "";
    this.fec = "";
    this.hor = "";
    this.lug = "";
    this.id = "";
}

//Admin de los eventos
function AdministradorEvento() {
    this.idd = "";
    this.eve = new Array();
	
//crea un evento desde cero
    this.CrearEvento = function CrearEvento() {
        this.eve = new Array();
    };
//Agrega una evento al administrador 
    this.AgregarEvento = function AgregarEvento(pNom, pLug, pFec, pHor, pDes, pId) {
        var mEve = new Evento();
        mEve.des = pDes;
        mEve.nom = pNom;
        mEve.fec = pFec;
        mEve.hor = pHor;
        mEve.lug = pLug;
        mEve.id = pId;
        this.eve[this.eve.length] = mEve;
    };
	//recibe la informacion del servidor, para cargarla localmente 
    this.CargarObjeto = function CargarObjeto(pObjeto) {
        this.eve = pObjeto.eve;
        this.idd = pObjeto.idd;
    };
//Envia la informacion al servidor para que agregue el nuevo evento al perfil del difunto
    this.EnviarEventoCrear = function EnviarEventoCrear(pIdDifunto) {
        this.idd = pIdDifunto;
        AjaxSolicitud(kConstantes.post, kConstantes.Servidor + kConstantes.DirEventos + "?json=" + JSON.stringify(this), JSON.stringify(this),
                function(data) {
                    alert("Eventos creados.");
                    document.location = "Actividades.html";
                });
    };
//Solicita al servidor todos los eventos relacionados con el perfil del difunto 
    this.CargarEvento = function(pIdDifunto) {
        pIdDifunto = sessionStorage.getItem('idDifunto');
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirEventos + "?idDifunto=" + pIdDifunto, "",
                function(data) {
                    AdminEve.CargarObjeto(data);
                    CargarTodosEventos(data);
                });
    };

//recupera la informacion de un solo evento, para ser modificada posteriormente 
    this.RecuperarEvento = function(pEvento) {
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirEventos + "?idDifunto=" + sessionStorage.getItem("idDifunto"), "",
                function(data) {
                    CargarEventoHtml(data.eve[0]);
                });
    };
//Envia al servidor una peticion para que guarde la informaci�n de un evento o actividad
    this.GuardarEvento = function(pIdEvento) {
        this.idd = "0";
        AjaxSolicitud(kConstantes.put, kConstantes.Servidor + kConstantes.DirEventos+"?json=" + JSON.stringify(this), JSON.stringify(this),
                function(data) {
                    alert("evento modificado");
                    document.location = "Actividades.html";
                });
    };

    this.GetEventos = function GetEventos() {
        return this.eve;
    };

    this.SetIdDifunto = function SetIdDifunto(pId) {
        this.idd = pId;
    };
}

//Administrador de los eventos
var AdminEve = new AdministradorEvento();

/////////////////////////////////////////////////////////////////////
//              Funcion que cargan datos en interfaz
/////////////////////////////////////////////////////////////////////

//Esta funcion lo que hace es cargar todos los eventos que le lleguen
function CargarTodosEventos(pOb) {
    var mResultado;
    var mResultadoFinal = "";
    for (var i = 0; i < pOb.eve.length; i++) { //carga los eventos
        mResultado = FormatoEvento.replace("{1}", pOb.eve[i].nom);
        mResultado = mResultado.replace("{2}", pOb.eve[i].lug);
        mResultado = mResultado.replace("{3}", pOb.eve[i].fec);
        mResultado = mResultado.replace("{4}", pOb.eve[i].hor);
        mResultado = mResultado.replace("{5}", pOb.eve[i].des);
        mResultado = mResultado.replace("{6}", pOb.eve[i].id);
        mResultadoFinal += mResultado;
    }
    $("#eveContenedor").html("<br>" + mResultadoFinal);
    if (sessionStorage.getItem("TipoUsuario") !== "0") { //agrega el evento de hold and press
        for (var j = 0; j < pOb.eve.length; j++) {
            AgregarHold("a" + pOb.eve[j].id);
        }
    }
}

//Carga un unico evento en pantalla para que sea modificado
function CargarEventoHtml(pEvento) {
    document.getElementById("nomEvento").value = pEvento.nom;
    document.getElementById("lugEvento").value = pEvento.lug;
    document.getElementById("fecEvento").value = pEvento.fec;
    document.getElementById("horEvento").value = pEvento.hor;
    document.getElementById("desEvento").value = pEvento.des;
    document.getElementById("Agregar").onclick = GuardarEvento;
    document.getElementById("Agregar").innerHTML = "Guardar";
    sessionStorage.setItem("idEvento", pEvento.id);
}


/////////////////////////////////////////////////////////////////////
//              Funcion que solicitan datos al servidor
/////////////////////////////////////////////////////////////////////

//Funcion que Envia a cargar un solo evento
function CargarUnEvento() {
    AdminEve.RecuperarEvento(sessionStorage.getItem('idEvento'));
}

/////////////////////////////////////////////////////////////////////
//              Funcion que envian datos al servidor 
/////////////////////////////////////////////////////////////////////

//Funcion que agrega la informacion introducida por el usuario y luego la envia al servidor con un post
function AgregarEvento() {
    if (AgregarDatosAdmin()) {
        AdminEve.EnviarEventoCrear(sessionStorage.getItem('idDifunto'));
    }
}

//Funcion que agrega la informacion introducida por el usuario y luego la envia por medio de put para que sea actualizada 
function GuardarEvento() {
    if (AgregarDatosAdmin()) {
        AdminEve.GuardarEvento(sessionStorage.getItem("idEvento"));
    }
}

//Esta funcion lo que hace es tomar todos los datos registrados por el usuario y los agrega al administrador
function AgregarDatosAdmin() {
    var nombre = document.getElementById("nomEvento").value;
    var lugar = document.getElementById("lugEvento").value;
    var fecha = document.getElementById("fecEvento").value;
    var hora = document.getElementById("horEvento").value;
    var descripcion = document.getElementById("desEvento").value;
    var id = sessionStorage.getItem("idEvento") + "";

    if (id === "null") {
        id = "-1";
    }
    else{
        id = id.substring(1, id.length)+"";
    }
    
    if (nombre === "" || lugar === "" || fecha === "" || hora === "" || descripcion === "") {
        alert("Aún hay espacios en blanco.");
        return false;
    }
    else {
        AdminEve.CrearEvento();
        AdminEve.AgregarEvento(nombre, lugar, fecha, hora, descripcion, id);
        return true;
    }
}

/////////////////////////////////////////////////////////////////////
//              Funcion que controlar el flujo de interfaz 
/////////////////////////////////////////////////////////////////////

//funcion que se llama cuando se presiona el boton de crear un evento 
function CrearEvento() {
    sessionStorage.setItem("mod", 0);
    document.location = "AgregarActividad.html";
}

//Funcion que se llama cuando se presiona el boton de modificar un evento seleccionado, el evento se carga para luego ser modificado
function ModificarEvento(pEvento) {
    sessionStorage.setItem("idEvento", pEvento);
    sessionStorage.setItem("mod", 1);
    document.location = "AgregarActividad.html";
}

//funcion que llama al servidor para que elimine un evento en especifico
function EliminarEvento(pEvento) {
    if (!confirm("¿Está seguro que desea eliminar esta actividad?"))
        return;
    AjaxSolicitud(kConstantes.delete, kConstantes.Servidor + kConstantes.DirEventos + "?id=" + pEvento.substring(1, pEvento.length), "",
            function() {
                alert("Evento eliminado");
                document.location = "Actividades.html";
            });
}

