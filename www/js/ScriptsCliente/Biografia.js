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

    this.EnviarBiografiaCrear = function EnviarBiografiaCrear(pIdDifunto) {
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
            },
            error: function(data) {
                alert('No se pudo conectar con el servidor.');
            }
        });
    };

    this.CargarBiografias = function CargarBiografias() {
        var pIdDifunto = 8;//sessionStorage.getItem("idDifunto");
        alert(pIdDifunto);
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
    alert("entrado");
    if (pOb === null && pOb.bio === null) {
        console.log("No hay biografías");
        return;
    }
    var i = 0;
    var mHtmlResultado= "";
    var bio;
    alert("cargando los datos");
    for (i; i < pOb.bio.length; i++) {
        bio = CascaronBiografia;
        bio = replace.replace("{tit}",pOb.bio[i].nom);
        bio = replace.replace("{des}",pOb.bio[i].des);
        bio = replace.replace("{id}",pOb.bio[i].id);
        mHtmlResultado += bio;
    }
    $("#biografias").html = mHtmlResultado;
}
