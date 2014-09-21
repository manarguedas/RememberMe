
var FormatoEvento = '<div class="panel panel-primary" onmousedown="ClickDown(GuardarDato,{6});" onmouseup="ClickUp();" > \
                    <div class="panel-heading"> \
                        <h5 class="panel-title">{1}</h5>\
                        <h6>Lugar: {2}, Fecha: {3}, Hora: {4} </h6>\
                    </div>\
                    <div class="panel-body">\
                        <small>{5}</small>\
                    </div>\
                </div>';


function Evento() {
    this.nom = "";
    this.des = "";
    this.fec = "";
    this.hor = "";
    this.lug = "";
    this.id = "";
}

function AdministradorEvento() {
    this.idd = "";
    this.eve = new Array();

    this.CrearEvento = function CrearEvento() {
        this.eve = new Array();
    };

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

    this.CargarObjeto = function CargarObjeto(pObjeto) {
        this.eve = pObjeto.eve;
        this.idd = pObjeto.idd;
    };

    this.EnviarEventoCrear = function EnviarEventoCrear(pIdDifunto) {
        this.idd = pIdDifunto;
        AjaxSolicitud(kConstantes.post, kConstantes.Servidor + kConstantes.DirEventos, JSON.stringify(this),
                function(data) {
                    alert("Eventos creados.");
                    document.location = "Actividades.html";
                });
    };

    this.CargarEvento = function(pIdDifunto) {
        pIdDifunto = sessionStorage.getItem('idDifunto');
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirEventos + "?idDifunto=" + pIdDifunto, "",
                function(data) {
                    AdminEve.CargarObjeto(data);
                    CargarTodosEventos(data);
                });
    };

    this.RecuperarEvento = function(pEvento) {
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirEventos + "?idDifunto=" + sessionStorage.getItem("idDifunto"), "",
                function(data) {
                    alert(JSON.stringify(data));
                    CargarEventoHtml(data.eve[0]);
                });
    };

    this.GuardarEvento = function(pIdEvento) {
        AjaxSolicitud(kConstantes.put, kConstantes.Servidor + kConstantes.DirEventos + "?idEvento=" + pIdEvento, JSON.stringify(this),
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

var AdminEve = new AdministradorEvento();

/////////////////////////////////////////////////////////////////////
//              Funcion que cargan datos en interfaz
/////////////////////////////////////////////////////////////////////

//Esta funcion lo que hace es cargar todos los eventos que le lleguen
function CargarTodosEventos(pOb) {
    var mResultado;
    var mResultadoFinal = "";
    for (var i = 0; i < pOb.eve.length; i++) {
        mResultado = FormatoEvento.replace("{1}", pOb.eve[i].nom);
        mResultado = mResultado.replace("{2}", pOb.eve[i].lug);
        mResultado = mResultado.replace("{3}", pOb.eve[i].fec);
        mResultado = mResultado.replace("{4}", pOb.eve[i].hor);
        mResultado = mResultado.replace("{5}", pOb.eve[i].des);
        mResultado = mResultado.replace("{6}", pOb.eve[i].id);
        mResultadoFinal += mResultado;
    }
    $("#eveContenedor").html("<br>" + mResultadoFinal);
}

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



function AgregarEvento() {
    if (AgregarDatosAdmin()) {
        AdminEve.EnviarEventoCrear(sessionStorage.getItem('idDifunto'));
    }
}
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
    var id = sessionStorage.getItem("idEvento");

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

function CrearEvento() {
    sessionStorage.setItem("mod", 0);
    document.location = "AgregarActividad.html";
}

function ModificarEvento(pEvento) {
    sessionStorage.setItem("idEvento", pEvento);
    sessionStorage.setItem("mod", 1);
    document.location = "AgregarActividad.html";
}

function EliminarEvento(pEvento) {
    if (!confirm("¿Está seguro que desea eliminar esta actividad?"))
        return;
    AjaxSolicitud(kConstantes.delete, kConstantes.Servidor + kConstantes.DirEventos + "?idEvento=" + pEvento, "",
            function() {
                alert("Objeto Eliminado");
            });
}

