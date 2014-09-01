/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
function Biografia(){
    this.id = "";
    this.nom = "";
    this.des = "";
}

function AdministradorBiografia(){
    this.idd = "";
    this.bio = new Array();
    
    
    this.AgregarBiografia = function AgregarBiografia(pTitulo,pDescripcion){
        var mBio = new Biografia();
        mBio.des = pDescripcion;
        mBio.nom = pTitulo;
        this.bio[this.bio.length] = mBio;
        //this.bio.ap;
    };
    
    this.CargarObjeto = function  CargarJSON(pObjeto){
        this.bio = pObjeto.bio;
        this.idd = pObjeto.idd;
    };
    
    this.EnviarBiografiaCrear = function EnviarBiografiaCrear(pIdDifunto){
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
    
    this.CargarBiografias = function CargarBiografias(pIdDifunto){
        $.ajax({
            type: kConstantes.get, // it's easier to read GET request parameters
            url: kConstantes.Servidor + kConstantes.DirBiografias + "?idDifunto="+pIdDifunto,
            dataType: 'JSON',
            data: {
                json: ""
            },
            success: function(data) {
                AdminBio.CargarObjeto(data);
            },
            error: function(data) {
                alert('No se pudo conectar con el servidor.');
            }
        });
    };
    
}

var AdminBio = new AdministradorBiografia();
