/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var CascaronBiografia = '<div id="b{id}" class="panel panel-primary" onclick="SeleccionDato = 1;"> \
                        <div class="panel-heading"> \
                            <h5 class="panel-title">{tit}</h5>\
                        </div>\
                        <div class="panel-body">\
                            <small>{des}</small>\
                        </div>\
                    </div>';

function Biografia() {
    this.id = "";
    this.nom = "";
    this.des = "";
}

function AdministradorBiografia() {
    this.idd = "";
    this.bio = new Array();


    this.CrearBiografia = function() {
        this.idd = 0;
        this.bio = new Array();
    };

    this.AgregarBiografia = function AgregarBiografia(pTitulo, pDescripcion, pId) {
        var mBio = new Biografia();
        mBio.des = pDescripcion;
        mBio.nom = pTitulo;
        mBio.id = pId;
        this.bio[this.bio.length] = mBio;
        //this.bio.ap;
    };

    this.CargarObjeto = function  CargarJSON(pObjeto) {
        this.bio = pObjeto.bio;
        this.idd = pObjeto.idd;
    };

    this.EnviarBiografiaCrear = function(pIdDifunto) {
        this.idd = pIdDifunto;
        AjaxSolicitud(kConstantes.post, kConstantes.Servidor + kConstantes.DirBiografias, JSON.stringify(this),
                function(data) {
                    alert("Biografias creadas.");
                    document.location = "misperfiles.html";

                });
    };

    this.CargarBiografias = function CargarBiografias() {
        var pIdDifunto = sessionStorage.getItem("idDifunto");
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirBiografias + "?idDifunto=" + pIdDifunto, "",
                function(data) {
                    // AdminBio.CargarObjeto(data);
                    CargarBiografiasHtml(data);
                });
    };

    this.RecuperarUnaBiografia = function(pBiografia) {
        pBiografia = sessionStorage.getItem("idDifunto");
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirBiografias + "?idDifunto=" + pBiografia, "",
                function(data) {
                    CargarUnaBiografiaHtml(BuscarBiografia(pBiografia,data.bio));
                });
    };

    this.GuardarBiografia = function(pBiografia) {
        this.idd = "0";
        AjaxSolicitud(kConstantes.put, kConstantes.Servidor + kConstantes.DirBiografias + "?json=" + JSON.stringify(this), JSON.stringify(this),
                function(data) {
                    alert("Biografía guardada");
                    document.location = "misperfiles.html";
                });
    };
}

var AdminBio = new AdministradorBiografia();


/////////////////////////////////////////////////////////////////////
//              Funcion que cargan datos en interfaz
/////////////////////////////////////////////////////////////////////

function CargarBiografiasHtml(pOb) {
    if (pOb === null && pOb.bio === null) {
        console.log("No hay biografías");
        return;
    }
    var i = 0;
    var mHtmlResultado = "";
    var bio;
    for (i; i < pOb.bio.length; i++) {
        bio = CascaronBiografia;
        bio = bio.replace("{tit}", pOb.bio[i].nom);
        bio = bio.replace("{des}", pOb.bio[i].des);
        bio = bio.replace("{id}", pOb.bio[i].id);
        mHtmlResultado += bio;
    }
    document.getElementById("biografias").innerHTML = mHtmlResultado;
    if (sessionStorage.getItem("TipoUsuario") !== "0") {
        for (var j = 0; j < pOb.bio.length; j++) {
            AgregarHold("b" + pOb.bio[j].id);
        }
    }
}

function CargarUnaBiografiaHtml(pBio) {
    document.getElementById("nom").value = pBio.nom;
    document.getElementById("des").value = pBio.des;
    document.getElementById("Agregar").onclick = GuardarBiografia;
    document.getElementById("Agregar").innerHTML = "Guardar";
    sessionStorage.setItem("idBio", pBio.id);



}


/////////////////////////////////////////////////////////////////////
//              Funcion que solicitan datos al servidor
/////////////////////////////////////////////////////////////////////

//Funcion que Envia a cargar un solo evento
function CargarUnaBiografia() {
    AdminBio.RecuperarUnaBiografia(sessionStorage.getItem('idBio'));
}

/////////////////////////////////////////////////////////////////////
//              Funcion que envian datos al servidor 
/////////////////////////////////////////////////////////////////////


function AgregarBiografia() {
    if (AgregarBiografiaAdmin()) {
        AdminBio.EnviarBiografiaCrear(sessionStorage.getItem("idDifunto"));
    }
}

function GuardarBiografia() {
    if (AgregarBiografiaAdmin()) {
        AdminBio.GuardarBiografia(sessionStorage.getItem("idBio"));
    }
}

//Esta funcion lo que hace es tomar todos los datos registrados por el usuario y los agrega al administrador
function AgregarBiografiaAdmin() {
    var Nombre = document.getElementById("nom").value;
    var Descripcion = document.getElementById("des").value;
    var id =sessionStorage.getItem("idBio") + "";

    if (id === "null") {
        id = "-1";
    }
    else{
        id = id.substring(1, id.length) + "";
    }
    if (Nombre === "" || Descripcion === "") {
        alert("Aún hay campos vacíos.");
        return false;
    }
    else {
        AdminBio.CrearBiografia();
        AdminBio.AgregarBiografia(Nombre, Descripcion, id);
        return true;
    }
}

/////////////////////////////////////////////////////////////////////
//              Funcion que controlar el flujo de interfaz 
/////////////////////////////////////////////////////////////////////


function CrearBiografia() {
    sessionStorage.setItem("mod", 0);
    document.location = "AgregarBiografias.html";
}

function ModificarBiografia(pBiografia) {
    sessionStorage.setItem("idBio", pBiografia);
    sessionStorage.setItem("mod", 1);
    document.location = "AgregarBiografias.html";
}

function EliminarBiografia(pBiografia) {
    if (!confirm("¿Está seguro que desea eliminar esta biografía?"))
        return;
    AjaxSolicitud(kConstantes.delete, kConstantes.Servidor + kConstantes.DirBiografias + "?id=" + pBiografia.substring(1, pBiografia.length), "",
            function() {
                alert("Objeto Eliminado");
                document.location = "misperfiles.html";
            });
}

function BuscarBiografia(pId, pArrayComentarios){
    var mResultado = 0;
    for(var i = 0; i < pArrayComentarios.length; i++){
        if ((pArrayComentarios[i].id+"") === (pId+"")){
            mResultado = pArrayComentarios[i];
            break;
        }
    }
    return mResultado;
}
