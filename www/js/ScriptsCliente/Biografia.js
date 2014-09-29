/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//cascaron que se utiliza para mostrar las biografias en pantalla
var CascaronBiografia = '<div id="b{id}" class="panel panel-primary" onclick="SeleccionDato = 1;"> \
                        <div class="panel-heading"> \
                            <h5 class="panel-title">{tit}</h5>\
                        </div>\
                        <div class="panel-body">\
                            <small>{des}</small>\
                        </div>\
                    </div>';
//Estructura de una biografia
function Biografia() {
    this.id = "";
    this.nom = "";
    this.des = "";
}
//Administrador que se encarga de agregar, modificar o eliminar las biografias para un perfil
function AdministradorBiografia() {
    this.idd = "";
    this.bio = new Array();

	//funcion que crea desde cero, todas las biografias
    this.CrearBiografia = function() {
        this.idd = 0;
        this.bio = new Array();
    };
	//agrega una biografia 
    this.AgregarBiografia = function AgregarBiografia(pTitulo, pDescripcion, pId) {
        var mBio = new Biografia();
        mBio.des = pDescripcion;
        mBio.nom = pTitulo;
        mBio.id = pId;
        this.bio[this.bio.length] = mBio;
        //this.bio.ap;
    };
	
//funcion que carga toda su informacion, apartir de un json de entrada
    this.CargarObjeto = function  CargarJSON(pObjeto) {
        this.bio = pObjeto.bio;
        this.idd = pObjeto.idd;
    };
//funcion que se encarga de enviar toda la informacion de una biografia al servidor para que cree una biografia, bajo un id de difunto
    this.EnviarBiografiaCrear = function(pIdDifunto) {
        this.idd = pIdDifunto;
        AjaxSolicitud(kConstantes.post, kConstantes.Servidor + kConstantes.DirBiografias, JSON.stringify(this),
                function(data) {
                    alert("Biografias creadas.");
                    document.location = "misperfiles.html";

                });
    };
	//funcion que se encarga de cargar todas las biografias en el perfil de la persona 
    this.CargarBiografias = function CargarBiografias() {
        var pIdDifunto = sessionStorage.getItem("idDifunto");
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirBiografias + "?idDifunto=" + pIdDifunto, "",
                function(data) {
                    // AdminBio.CargarObjeto(data);
                    CargarBiografiasHtml(data);
                });
    };
	//carga una sola biografia para que sea modificada
    this.RecuperarUnaBiografia = function(pBiografia) {
        pBiografia = sessionStorage.getItem("idDifunto");
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirBiografias + "?idDifunto=" + pBiografia, "",
                function(data) {
                    CargarUnaBiografiaHtml(BuscarBiografia(pBiografia,data.bio));
                });
    };
	//Funcion que guarda o le solicita al servidor que actualice su informacion en el servidor, segun la info enviada en esta peticion
    this.GuardarBiografia = function(pBiografia) {
        this.idd = "0";
        AjaxSolicitud(kConstantes.put, kConstantes.Servidor + kConstantes.DirBiografias + "?json=" + JSON.stringify(this), JSON.stringify(this),
                function(data) {
                    alert("Biografía guardada");
                    document.location = "misperfiles.html";
                });
    };
}

//Administrador de las biografias
var AdminBio = new AdministradorBiografia();


/////////////////////////////////////////////////////////////////////
//              Funcion que cargan datos en interfaz
/////////////////////////////////////////////////////////////////////

//Funcion que carga las biografias en el perfil
function CargarBiografiasHtml(pOb) {
    if (pOb === null && pOb.bio === null) {
        console.log("No hay biografías");
        return;
    }
    var i = 0;
    var mHtmlResultado = "";
    var bio;
    for (i; i < pOb.bio.length; i++) { //se crean las biografias
        bio = CascaronBiografia;
        bio = bio.replace("{tit}", pOb.bio[i].nom);
        bio = bio.replace("{des}", pOb.bio[i].des);
        bio = bio.replace("{id}", pOb.bio[i].id);
        mHtmlResultado += bio;
    }
    document.getElementById("biografias").innerHTML = mHtmlResultado;
    if (sessionStorage.getItem("TipoUsuario") !== "0") { //se le agrega el evento press and hold
        for (var j = 0; j < pOb.bio.length; j++) {
            AgregarHold("b" + pOb.bio[j].id);
        }
    }
}

function CargarUnaBiografiaHtml(pBio) { //carga una unica biografia en la pantalla de modificar
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


function AgregarBiografia() { //funcion que agrega la biografia que se quiere agregar al administrador de biografias 
    if (AgregarBiografiaAdmin()) {
        AdminBio.EnviarBiografiaCrear(sessionStorage.getItem("idDifunto")); //se envia la biografia
    }
}

function GuardarBiografia() { //se agrega la biografia que se quiere modificar al admin, para luego ser actualizada
    if (AgregarBiografiaAdmin()) {
        AdminBio.GuardarBiografia(sessionStorage.getItem("idBio")); ///solicita la actualizacion al servidor
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

//Funcion que se llama cuando se presiona el boton de crear biografia en el perfil
function CrearBiografia() {
    sessionStorage.setItem("mod", 0);
    document.location = "AgregarBiografias.html";
}

//funcion que se llama cuando se presiona el boton de modificar una biografia
function ModificarBiografia(pBiografia) {
    sessionStorage.setItem("idBio", pBiografia);
    sessionStorage.setItem("mod", 1);
    document.location = "AgregarBiografias.html";
}

//Funcion que se llama cuando se presiona el boton de eliminar una biografia
function EliminarBiografia(pBiografia) {
    if (!confirm("¿Está seguro que desea eliminar esta biografía?"))
        return;
    AjaxSolicitud(kConstantes.delete, kConstantes.Servidor + kConstantes.DirBiografias + "?id=" + pBiografia.substring(1, pBiografia.length), "",
            function() {
                alert("Objeto Eliminado");
                document.location = "misperfiles.html";
            });
}
//funcion que devuelve la informacion de una biografia usando el id de la misma, se tiene que hacer una busqueda en la informacion brindada por el servidor
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
