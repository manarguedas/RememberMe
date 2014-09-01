/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var FormatoEvento = '<div class="panel panel-primary"> \
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

    this.CrearEvento = function CrearEvento(){
        this.eve = new Array();
    }

    this.AgregarEvento = function AgregarEvento(pNom, pLug, pFec, pHor, pDes) {
        var mEve = new Evento();
        mEve.des = pDes;
        mEve.nom = pNom;
        mEve.fec = pFec;
        mEve.hor = pHor;
        mEve.lug = pLug;
        mEve.id = "1";
        this.eve[this.eve.length] = mEve;
    };

    this.CargarObjeto = function CargarObjeto(pObjeto) {
        this.eve = pObjeto.eve;
        this.idd = pObjeto.idd;
    };

    this.EnviarEventoCrear = function EnviarEventoCrear(pIdDifunto) {
        this.idd = pIdDifunto;
        $.ajax({
            type: kConstantes.post, // it's easier to read GET request parameters
            url: kConstantes.Servidor + kConstantes.DirEventos,
            dataType: 'JSON',
            data: {
                json: JSON.stringify(this)
            },
            success: function(data) {
                alert("Eventos creados.");
            },
            error: function(data) {
                alert('No se pudo conectar con el servidor.');
            }
        });
    };

    this.CargarEvento = function CargarEvento(pIdDifunto) {
        pIdDifunto = sessionStorage.getItem('idDifunto');
        $.ajax({
            type: kConstantes.get, // it's easier to read GET request parameters
            url: kConstantes.Servidor + kConstantes.DirEventos + "?idDifunto=" + pIdDifunto,
            dataType: 'JSON',
            data: {
                json: ""
            },
            success: function(data) {
                AdminEve.CargarObjeto(data);
                CargarTodosEventos(data);
            },
            error: function(data) {
                alert('No se pudo conectar con el servidor.');
            }
        });
    };

    this.GetEventos = function GetEventos() {
        return this.eve;
    };
    
    this.SetIdDifunto = function SetIdDifunto(pId){
        this.idd = pId;
    }
}

var AdminEve = new AdministradorEvento();

function CargarTodosEventos(pOb) {
    var mResultado;
    var mResultadoFinal = "";
    for (var i = 0; i < pOb.eve.length; i++) {
        mResultado = FormatoEvento.replace("{1}", pOb.eve[i].nom);
        mResultado = mResultado.replace("{2}", pOb.eve[i].lug);
        mResultado = mResultado.replace("{3}", pOb.eve[i].fec);
        mResultado = mResultado.replace("{4}", pOb.eve[i].hor);
        mResultado = mResultado.replace("{5}", pOb.eve[i].des);
        mResultadoFinal += mResultado;
    }
    $("#eveContenedor").html("<br>" + mResultadoFinal);
}

function AgregarEvento(){
    var nombre = document.getElementById("nomEvento").value;
    var lugar = document.getElementById("lugEvento").value;
    var fecha = document.getElementById("fecEvento").value;
    var hora = document.getElementById("horEvento").value;
    var descripcion = document.getElementById("desEvento").value;
    
    if (nombre==="" || lugar==="" || fecha==="" || hora==="" || descripcion===""){
        alert("Aún hay espacios en blanco.");
        return;
    }
    
    AdminEve.CrearEvento();
    AdminEve.AgregarEvento(nombre,lugar,fecha,hora,descripcion);
    AdminEve.EnviarEventoCrear(sessionStorage.getItem('idDifunto'));
}