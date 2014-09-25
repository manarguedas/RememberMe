/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var CascaronComentario = '<div class="panel panel-info" id="{id}"> \
                                <div class="panel-heading">\
                                    <h6 class="panel-title">{nom}<small>({fec})</small></h6>\
                                </div>\
                                <div class="panel-body">\
                                    <small>{des}</small>\
                                </div>\
                            </div>';
function Comentario() {
    this.id = "";
    this.nom = "";
    this.des = "";
    this.fec = "";
}

function AdministradorComentarios() {
    this.idd = "";
    this.com = new Array();
    this.CrearComentario = function() {
        this.idd = "";
        this.com = new Array();
    };
    this.AgregarComentario = function(pNombre, pDescripcion) {
        var mCom = new Comentario();
        mCom.id = 1;
        mCom.des = pDescripcion;
        mCom.nom = pNombre;
        mCom.fec = new Date();
        mCom.fec = mCom.fec.getDate() + "/" + (mCom.fec.getMonth() + 1) + "/" + mCom.fec.getFullYear();
        alert("la fecha es " + mCom.fec);
        this.com[this.com.length] = mCom;
    };
    this.EnviarComentarioCrear = function(pIdDifunto) {
        this.idd = pIdDifunto;
        AjaxSolicitud(kConstantes.post, kConstantes.Servidor + kConstantes.DirComentarios, JSON.stringify(this),
                function() {
                    document.location = "misperfiles.html";
                });
    };

    this.CargarComentarios = function CargarComentarios() {
        var pIdDifunto = sessionStorage.getItem("idDifunto");
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirComentarios + "?idDifunto=" + pIdDifunto, "",
                CargarComentariosHtml);
    };

    this.EliminarComentario = function (pIdComentario) {
        var pIdDifunto = sessionStorage.getItem("idDifunto");
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirComentarios + "?idComentario=" + pIdComentario, "",
                function (){
                    alert("comentario eliminado");
                    document.reload();
                });
    };
}

var AdminCom = new AdministradorComentarios();
function CargarComentariosHtml(pOb) {
    if (pOb === null && pOb.com === null) {
        console.log("No hay comentarios");
        return;
    }
    var i = 0;
    var mHtmlResultado = "";
    var com;
    for (i; i < pOb.com.length; i++) {
        com = CascaronComentario;
        com = com.replace("{nom}", pOb.com[i].nom);
        com = com.replace("{des}", pOb.com[i].des);
        com = com.replace("{fec}", pOb.com[i].fec);
        com = com.replace("{id}", pOb.com[i].id);
        mHtmlResultado += com;
    }
    document.getElementById("comentarios").innerHTML = mHtmlResultado;
}

function AgregarComentario() {
    var Nombre = sessionStorage.getItem("nomFace");
    var Descripcion = document.getElementById("desCom").value;
    if (Descripcion === "") {
        alert("Aún hay campos vacíos.");
        return;
    }

    AdminCom.CrearComentario();
    AdminCom.AgregarComentario(Nombre, Descripcion);
    AdminCom.EnviarComentarioCrear(sessionStorage.getItem("idDifunto"));
}


