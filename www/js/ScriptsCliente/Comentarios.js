/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var FaceComentarioMod = "";
var fechaComentarioMod = "";

var CascaronComentario = '<div id="c{id}" class="panel panel-info" onclick="SeleccionDato = 0;" > \
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
    this.AgregarComentario = function(pNombre, pDescripcion, pId) {
        var mCom = new Comentario();
        mCom.id = pId;
        mCom.des = pDescripcion;
        mCom.nom = pNombre;
        mCom.fec = new Date();
        mCom.fec = mCom.fec.getDate() + "/" + (mCom.fec.getMonth() + 1) + "/" + mCom.fec.getFullYear();
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

    this.GuardarComentarioCrear = function(pIdDifunto) {
        this.idd = "1";
        AjaxSolicitud(kConstantes.put, kConstantes.Servidor + kConstantes.DirComentarios +"?json=" + JSON.stringify(this), JSON.stringify(this),
                function() {
                    document.location = "misperfiles.html";
                });
    };

    this.EliminarComentario = function(pIdComentario) {
        var pIdDifunto = sessionStorage.getItem("idDifunto");
        AjaxSolicitud(kConstantes.delete, kConstantes.Servidor + kConstantes.DirComentarios + "?idComentario=" + pIdComentario, "",
                function() {
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
    if (sessionStorage.getItem("TipoUsuario") !== "0") {
        for (var j = 0; j < pOb.com.length; j++) {
            AgregarHold("c" + pOb.com[j].id);
        }
    }
}

function AgregarAdminComentario(pNombreFace) {
    var Nombre = pNombreFace;
    var Descripcion = document.getElementById("desCom").value;
    var id = sessionStorage.getItem("idCom") + "";

    if (id === "null") {
        id = "-1";
    }

    if (Descripcion === "") {
        alert("Aún hay campos vacíos.");
        return false;
    }

    AdminCom.CrearComentario();
    AdminCom.AgregarComentario(Nombre, Descripcion, id);
    return true;
}

function AgregarComentario() {
    if (AgregarAdminComentario(sessionStorage.getItem("nomFace"))) {
        AdminCom.EnviarComentarioCrear(sessionStorage.getItem("idDifunto"));
    }
}


function EliminarComentario(pComentario) {
    if (!confirm("¿Está seguro que desea eliminar este comentario?"))
        return;
    AjaxSolicitud(kConstantes.delete, kConstantes.Servidor + kConstantes.DirComentarios + "?id=" + pComentario.substring(1, pComentario.length), "",
            function() {
                alert("Objeto Eliminado");
                document.location = "perfil.html";
            });
}

function ModificarComentario(pComentario) {
    sessionStorage.setItem("idCom", pComentario.substring(1, pComentario.length) + "");
    sessionStorage.setItem("mod", 1);
    AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirComentarios + "?idDifunto=" + sessionStorage.getItem("idDifunto"), "",
                CargarUnComentario);
}

function CargarUnComentario(pComentario) {
    var Comentario = BuscarCometario(sessionStorage.getItem("idCom"), pComentario.com);
    usuarioFaceComentario = Comentario.nom;
    fechaComentarioMod = Comentario.fec;
    document.getElementById("desCom").value = Comentario.des;
    document.getElementById("btnComentar").onclick = onClickGuardarComentario;
    document.getElementById("btnComentar").innerHTML = "Guardar comentario";
}

function onClickGuardarComentario() {
    document.getElementById("btnComentar").onclick = AgregarComentario;
    document.getElementById("btnComentar").innerHTML = "Comentario";
    if (AgregarAdminComentario(fechaComentarioMod)) {
        AdminCom.com[0].fec = usuarioFaceComentario;
        AdminCom.GuardarComentarioCrear();
    }   
}

function BuscarCometario(pId, pArrayComentarios){
    var mResultado = 0;
    for(var i = 0; i < pArrayComentarios.length; i++){
        if ((pArrayComentarios[i].id+"") === (pId+"")){
            mResultado = pArrayComentarios[i];
            break;
        }
    }
    return mResultado;
}