/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function Evento(){
    this.nom = "";
    this.des = "";
    this.fec = "";
    this.hor = "";
    this.lug = "";
}

function AdministradorEvento(){
    this.idd = "";
    this.eve = new Array();
    
    
    this.AgregarEvento = function AgregarEvento(pNom,pDes,pFec,pHor,pLug){
        var mEve = new Evento();
        mEve.des = pDes;
        mEve.nom = pNom;
        mEve.fec = pFec;
        mEve.hor = pHor;
        mEve.lug = pLug;
        this.eve[this.eve.length] = mEve;
    };
    
    this.CargarObjeto = function CargarObjeto(pObjeto){
        this.eve = pObjeto.eve;
        this.idd = pObjeto.idd;
    };
    
    this.EnviarEventoCrear = function EnviarEventoCrear(pIdDifunto){
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
    
    this.CargarEvento = function CargarEvento(pIdDifunto){
        $.ajax({
            type: kConstantes.get, // it's easier to read GET request parameters
            url: kConstantes.Servidor + kConstantes.DirEventos + "?idDifunto="+pIdDifunto,
            dataType: 'JSON',
            data: {
                json: ""
            },
            success: function(data) {
                AdminEve.CargarObjeto(data);
            },
            error: function(data) {
                alert('No se pudo conectar con el servidor.');
            }
        });
    };
    
}

var AdminEve = new AdministradorEvento();
