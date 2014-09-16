/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var CascaronBiografia = '<div class="panel panel-primary" id="{id}"> \
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


    this.CrearBiografia = function (){
        this.idd = 0;
        this.bio = new Array();
    };

    this.AgregarBiografia = function AgregarBiografia(pTitulo, pDescripcion) {
        var mBio = new Biografia();
        mBio.des = pDescripcion;
        mBio.nom = pTitulo;
        this.bio[this.bio.length] = mBio;
        //this.bio.ap;
    };

    this.CargarObjeto = function  CargarJSON(pObjeto) {
        this.bio = pObjeto.bio;
        this.idd = pObjeto.idd;
    };

    this.EnviarBiografiaCrear = function (pIdDifunto) {
        this.idd = pIdDifunto;
        $.ajax({
            type: kConstantes.post, // it's easier to read GET request parameters
            url: kConstantes.Servidor + kConstantes.DirBiografias,
            dataType: 'JSON',
            data: {
                json: JSON.stringify(this)
            },
            success: function(data) {
                alert("Biografias creadas.");
                document.location = "misperfiles.html";
            },
            error: function(data) {
                alert('No se pudo conectar con el servidor.');
            }
        });
    };

    this.CargarBiografias = function CargarBiografias() {
        var pIdDifunto = sessionStorage.getItem("idDifunto");
        $.ajax({
            type: kConstantes.get,
            url: kConstantes.Servidor + kConstantes.DirBiografias + "?idDifunto=" + pIdDifunto,
            dataType: 'JSON',
            data: {
                json: ""
            },
            success: function(data) {
               // AdminBio.CargarObjeto(data);
                CargarBiografiasHtml(data);
            },
            error: function(data) {
                alert('No se pudo conectar con el servidor.');
            }
        });
    };

}

var AdminBio = new AdministradorBiografia();


function CargarBiografiasHtml(pOb) {
    if (pOb === null && pOb.bio === null) {
        console.log("No hay biografías");
        return;
    }
    var i = 0;
    var mHtmlResultado= "";
    var bio;
    for (i; i < pOb.bio.length; i++) {
        bio = CascaronBiografia;
        bio = bio.replace("{tit}",pOb.bio[i].nom);
        bio = bio.replace("{des}",pOb.bio[i].des);
        bio = bio.replace("{id}",pOb.bio[i].id);
        mHtmlResultado += bio;
    }
    document.getElementById("biografias").innerHTML=mHtmlResultado; 
}


function AgregarBiografia() {
    var Nombre = document.getElementById("nom").value;
    var Descripcion = document.getElementById("des").value;

    if (Nombre === "" || Descripcion === "") {
        alert("Aún hay campos vacíos.");
        return;
    }
    
    AdminBio.CrearBiografia();
    AdminBio.AgregarBiografia(Nombre, Descripcion);
    AdminBio.EnviarBiografiaCrear(sessionStorage.getItem("idDifunto"));
}