/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Perfil() {
    this.nom = "";
    this.ape = "";
    this.nac = "";
    this.def = "";
    this.url = "";
    this.id = "";
}

function AdministrarPerfil() {

    this.per = "";
    
    
    this.CrearPerfil = function CrearPerfil() {
        this.per = new Perfil();
    };

    this.GetJSON = function GetJSON() {
        return JSON.stringify(this);
    };

    this.CargarJSON = function CargarJSON(pJSON) {
        this.per = JSON.parse(pJSON).perfil;
    };

    this.RecuperarPerfil = function RecuperarPerfil(pIdDifunto) {
        pIdDifunto = sessionStorage.getItem("idDifunto");
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirPerfiles + "?idDifunto=" + pIdDifunto, "",
                function(data) {
                    var mJson = JSON.stringify(data);
                    AdmiPer.CargarJSON(mJson);
                    CargarPerfilHtml(data);
                });
    };

    this.EnviarPerfilCrear = function EnviarPerfilCrear() {
        AjaxSolicitud(kConstantes.post, kConstantes.Servidor + kConstantes.DirPerfiles, JSON.stringify(this),
                function() {
                    alert("Perfil creado");
                    document.location = "perfil.html";
                });
    };

    this.RecuperarUnPerfil = function() {
        AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirPerfiles + "?idDifunto=" + sessionStorage.getItem("idDifunto"), "",
                CargarUnPerfilHtml);
    };

    this.GuardarPerfil = function() {
        AjaxSolicitud(kConstantes.put, kConstantes.Servidor + kConstantes.DirPerfiles + "?json=" + JSON.stringify(this), JSON.stringify(this),
                function(data) {
                    alert("Perfil Guardado");
                    document.location = "misperfiles.html";
                });
    };

    this.Ejecutar = function Ejecutar(pJson) {
        alert(this.per.nom + "soy la funcion " + pJson);
    };


    this.SetNombre = function SetNombre(pNombre) {
        this.per.nom = pNombre;
    };

    this.SetApellido = function SetApellido(pApellido) {
        this.per.ape = pApellido;
    };

    this.SetNacimiento = function SetNacimiento(pNacimiento) {
        this.per.nac = pNacimiento;
    };

    this.SetDefuncion = function SetDefuncion(pDefuncion) {
        this.per.def = pDefuncion;
    };

    this.SetUrl = function SetUrl(pUrl) {
        this.per.url = pUrl;
    };

    this.GetNombre = function GetNombre() {
        return this.per.nom;
    };

    this.GetApellido = function GetApellido() {
        return this.per.ape;
    };

    this.GetNacimiento = function GetNacimiento() {
        return this.per.nac;
    };

    this.GetDefuncion = function GetDefuncion() {
        return this.per.def;
    };

    this.GetUrl = function GetUrl() {
        return this.per.url;
    };
}

var AdmiPer = new AdministrarPerfil();

/////////////////////////////////////////////////////////////////
//          Funciones utilizadas en la parte de interfaz
/////////////////////////////////////////////////////////////////

function MostrarOpciones() {
    var EstiloOpciones = document.getElementById("opPerfil").style;
    if (EstiloOpciones.visibility === "visible")
        EstiloOpciones.visibility = "hidden";
    else
        EstiloOpciones.visibility = "visible";
}



/////////////////////////////////////////////////////////////////////
//              Funcion que cargan datos en interfaz
/////////////////////////////////////////////////////////////////////

function CargarPerfilHtml(pOb) {
    if (pOb === null && pOb.per === null) {
        alert("Error al cargar el perfil");
        return;
    }

    document.getElementById("nomDifunto").innerHTML = (pOb.per.nom + " " + pOb.per.ape);
    document.getElementById("nacDifunto").innerHTML = ("<b>Fecha de nacimiento: </b>" + pOb.per.nac);
    document.getElementById("defDifunto").innerHTML = ("<b>Fecha de defunción: </b>" + pOb.per.def);
    sessionStorage.setItem('idDifunto', pOb.per.id);
    
    if (true) {
        document.getElementById("fotoDifunto").src = kConstantes.DirImagenesAlmacen + pOb.per.id + ".png";///"./images/FondoNegro.png";  //pOb.per.url;
    }
}

function CargarUnPerfilHtml(pPerfil) {
    document.getElementById("nom").value = pPerfil.per.nom;
    document.getElementById("ape").value = pPerfil.per.ape;
    document.getElementById("nac").value = pPerfil.per.nac;
    document.getElementById("def").value = pPerfil.per.def;

    document.getElementById("Agregar").onclick = GuardarDifunto;
    document.getElementById("Agregar").innerHTML = "Guardar";
}


/////////////////////////////////////////////////////////////////////
//              Funcion que solicitan datos al servidor
/////////////////////////////////////////////////////////////////////

//Funcion que Envia a cargar un solo evento
function CargarUnPerfil() {
    AdmiPer.RecuperarUnPerfil();
}

/////////////////////////////////////////////////////////////////////
//              Funcion que envian datos al servidor 
/////////////////////////////////////////////////////////////////////


function AgregarDifunto() {
    if (AgregarPerfilAdmin()) {
        AdmiPer.EnviarPerfilCrear();
    }
}

function GuardarDifunto() {
    if (AgregarPerfilAdmin()) {
        AdmiPer.GuardarPerfil();
    }
}

//Esta funcion lo que hace es tomar todos los datos registrados por el usuario y los agrega al administrador
function AgregarPerfilAdmin() {
    var Nombre = document.getElementById("nom").value;
    var Apellido = document.getElementById("ape").value;
    var Nacimiento = document.getElementById("nac").value;
    var Defuncion = document.getElementById("def").value;
    var id = sessionStorage.getItem("idDifunto") + "";

    if (id === "null") {
        id = "-1";
    }

    if (Nombre === "" || Apellido === "" || Nacimiento === "" || Defuncion === "") {
        alert("Aún hay campos vacíos.");
        return false;
    }

    AdmiPer.CrearPerfil();
    AdmiPer.SetApellido(Apellido);
    AdmiPer.SetDefuncion(Defuncion);
    AdmiPer.SetNacimiento(Nacimiento);
    AdmiPer.SetNombre(Nombre);
    AdmiPer.SetUrl("");
    AdmiPer.per.id = id;

    return true;
}

/////////////////////////////////////////////////////////////////////
//              Funcion que controlar el flujo de interfaz 
/////////////////////////////////////////////////////////////////////

function AgregarPerfil() {
    sessionStorage.setItem("mod", 0);
    document.location = "AgregarPerfil.html";
}

function ModificarPerfil() {
    sessionStorage.setItem("mod", 1);
    document.location = "AgregarPerfil.html";
}

function EliminarPerfil() {
    if (!confirm("¿Está seguro que desea eliminar este perfil?"))
        return;
    AjaxSolicitud(kConstantes.delete, kConstantes.Servidor + kConstantes.DirPerfiles + "?idDifunto=" + sessionStorage.getItem("idDifunto"), "",
            function() {
                alert("Perfil Eliminado");
                document.location = "perfil.html";
            });
}
