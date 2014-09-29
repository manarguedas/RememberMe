/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var FaceComentarioMod = ""; 	//Variable donde se almacena el valor de la llave de facebook, del usuario
var fechaComentarioMod = "";	//se almacena la fecha del comentario

//Cascara que se utiliza para mostrar la informacion del comentario
var CascaronComentario = '<div id="c{id}" class="panel panel-info" onclick="SeleccionDato = 0;" > \
                                <div class="panel-heading">\
                                    <h6 class="panel-title">{nom}<small>({fec})</small></h6>\
                                </div>\
                                <div class="panel-body">\
                                    <small>{des}</small>\
                                </div>\
                            </div>';
//Estructura interna de un comentario
function Comentario() {
    this.id = "";
    this.nom = "";
    this.des = "";
    this.fec = "";
}
//Administrador de comentarios, que se encarga de la gestion de los mismos
function AdministradorComentarios() {
    this.idd = "";
    this.com = new Array();
    this.CrearComentario = function() { //funcion que reinicia los valores almacenados de los comentarios 
        this.idd = "";
        this.com = new Array();
    };
//Funcion que agrega un comentario al administrador de comentarios
    this.AgregarComentario = function(pNombre, pDescripcion, pId) {
        var mCom = new Comentario();
        mCom.id = pId;
        mCom.des = pDescripcion;
        mCom.nom = pNombre;
        mCom.fec = new Date();
        mCom.fec = mCom.fec.getDate() + "/" + (mCom.fec.getMonth() + 1) + "/" + mCom.fec.getFullYear();
        this.com[this.com.length] = mCom;
    };
//funcion que envia la informacion de un comentario al servidor
    this.EnviarComentarioCrear = function(pIdDifunto) {
        this.idd = pIdDifunto;
        AjaxSolicitud(kConstantes.post, kConstantes.Servidor + kConstantes.DirComentarios, JSON.stringify(this),
                function() {
                    document.location = "misperfiles.html";
                });
    };

//funcion que se encarga de cargar todos los comentarios que se encuentren registrados bajo el nombre de un difunto
    this.CargarComentarios = function CargarComentarios() {
        var pIdDifunto = sessionStorage.getItem("idDifunto");
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirComentarios + "?idDifunto=" + pIdDifunto, "",
                CargarComentariosHtml);
    };

//llama al servidor a que actualice un comentarios de un difunto
    this.GuardarComentarioCrear = function(pIdDifunto) {
        this.idd = "1";
        AjaxSolicitud(kConstantes.put, kConstantes.Servidor + kConstantes.DirComentarios +"?json=" + JSON.stringify(this), JSON.stringify(this),
                function() {
                    document.location = "misperfiles.html";
                });
    };

//llama al servidor para que elimine un comentario en especifico del perfil de un difunto
    this.EliminarComentario = function(pIdComentario) {
        var pIdDifunto = sessionStorage.getItem("idDifunto");
        AjaxSolicitud(kConstantes.delete, kConstantes.Servidor + kConstantes.DirComentarios + "?idComentario=" + pIdComentario, "",
                function() {
                    alert("comentario eliminado");
                    document.reload();
                });
    };
}

//variable administradora de los comentarios 
var AdminCom = new AdministradorComentarios();

//funcion que carga los comentarios en el html
function CargarComentariosHtml(pOb) {
    if (pOb === null && pOb.com === null) {
        console.log("No hay comentarios");
        return;
    }
    var i = 0;
    var mHtmlResultado = "";
    var com;
    for (i; i < pOb.com.length; i++) { //Se crean los comentarios en pantalla 
        com = CascaronComentario;
        com = com.replace("{nom}", pOb.com[i].nom);
        com = com.replace("{des}", pOb.com[i].des);
        com = com.replace("{fec}", pOb.com[i].fec);
        com = com.replace("{id}", pOb.com[i].id);
        mHtmlResultado += com;
    }
    document.getElementById("comentarios").innerHTML = mHtmlResultado;
    if (sessionStorage.getItem("TipoUsuario") !== "0") { //se le agrega el eveto de press and hold a los comentarios
        for (var j = 0; j < pOb.com.length; j++) {
            AgregarHold("c" + pOb.com[j].id);
        }
    }
}

//funcion que toma la informacion introducida por el usuario y los agrega al admin de comentarios 
function AgregarAdminComentario(pNombreFace) { 
    var Nombre = pNombreFace;
    var Descripcion = document.getElementById("desCom").value;
    var id = sessionStorage.getItem("idCom") + "";

    if (id === "null") {
        id = "-1";
    }

    if (Descripcion === "") {
        alert("AÃºn hay campos vacÃ­os.");
        return false;
    }

    AdminCom.CrearComentario();
    AdminCom.AgregarComentario(Nombre, Descripcion, id);
    return true;
}

//Funcion que se encarga de enviar los datos al servidor para que este los guarde, y actualiza la pagina luego de esta hasana
function AgregarComentario() {
    if (AgregarAdminComentario(sessionStorage.getItem("nomFace"))) {
        AdminCom.EnviarComentarioCrear(sessionStorage.getItem("idDifunto"));
    }
}

//Funcion que se encarga de llamar a eliminar un comentario en especifico
function EliminarComentario(pComentario) {
    if (!confirm("¿Está seguro que desea eliminar este comentario?"))
        return;
    AjaxSolicitud(kConstantes.delete, kConstantes.Servidor + kConstantes.DirComentarios + "?id=" + pComentario.substring(1, pComentario.length), "",
            function() {
                alert("Objeto Eliminado");
                document.location = "perfil.html";
            });
}

//Funcion que llama al servidor a que actualice un comentarios en especifico 
function ModificarComentario(pComentario) {
    sessionStorage.setItem("idCom", pComentario.substring(1, pComentario.length) + "");
    sessionStorage.setItem("mod", 1);
    AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirComentarios + "?idDifunto=" + sessionStorage.getItem("idDifunto"), "",
                CargarUnComentario);
}
//funcion que se encarga de cargar un comentario en especifico para ser modificado posteriormente
function CargarUnComentario(pComentario) {
    var Comentario = BuscarCometario(sessionStorage.getItem("idCom"), pComentario.com);
    usuarioFaceComentario = Comentario.nom;
    fechaComentarioMod = Comentario.fec;
    document.getElementById("desCom").value = Comentario.des;
    document.getElementById("btnComentar").onclick = onClickGuardarComentario;
    document.getElementById("btnComentar").innerHTML = "Guardar comentario";
}

//funcion que se ejecuta cuando se presiona un guardar comentario, luego de haber modificado un comentario 
function onClickGuardarComentario() {
    document.getElementById("btnComentar").onclick = AgregarComentario;
    document.getElementById("btnComentar").innerHTML = "Comentario";
    if (AgregarAdminComentario(fechaComentarioMod)) {
        AdminCom.com[0].fec = usuarioFaceComentario;
        AdminCom.GuardarComentarioCrear();
    }   
}

//de todos los comentarios devueltos por el servidor, busca un comentario en especifico usando el id y lo retorna
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