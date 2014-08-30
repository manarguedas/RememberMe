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

function AdministrarPerfil(){
    
    this.per = "";
    
    this.CrearPerfil = function CrearPerfil(){
        this.per = new Perfil();  
    };
    
    this.GetJSON = function GetJSON(){
        return JSON.stringify(this);
    };
    
    this.CargarJSON = function CargarJSON(pJSON){
        this.per = JSON.parse(pJSON).perfil; 
    };
    
    this.RecuperarPerfil = function RecuperarPerfil(pIdDifunto){
        $.ajax({
            type: kConstantes.get, // it's easier to read GET request parameters
            url: kConstantes.Servidor + kConstantes.DirPerfiles + "?idDifunto="+pIdDifunto,
            dataType: 'JSON',
            data: {
                json: "" // look here!
            },
            success: function(data) {
                var mJson = JSON.stringify(data);
                AdmiPer.CargarJSON(mJson);
            },
            error: function(data) {
                alert('No se pudo obtener el perfil.');
            }
        });
    };

    this.EnviarPerfilCrear = function EnviarPerfilCrear(){
        $.ajax({
            type: kConstantes.post, // it's easier to read GET request parameters
            url: kConstantes.Servidor + kConstantes.DirPerfiles ,
            dataType: 'JSON',
            data: {
                json: JSON.stringify(this)
            },
            success: function(data) {
                alert("Perfil creado");
            },
            error: function(data) {
                alert('No se pudo crear el perfil.');
            }
        });
    };
    
    this.Ejecutar = function Ejecutar(pJson){
        alert(this.per.nom + "soy la funcion " + pJson);
    };
    
    
    this.SetNombre = function SetNombre(pNombre){
        this.per.nom = pNombre;
    };
    
    this.SetApellido = function SetApellido(pApellido){
        this.per.ape = pApellido;
    };
    
    this.SetNacimiento = function SetNacimiento(pNacimiento){
        this.per.nac = pNacimiento;
    };
    
    this.SetDefuncion = function SetDefuncion(pDefuncion){
        this.per.def = pDefuncion;
    };
    
    this.SetUrl = function SetUrl(pUrl){
        this.per.url = pUrl;
    };
    
    this.GetNombre = function GetNombre(){
        return this.per.nom;
    };
    
    this.GetApellido = function GetApellido(){
        return this.per.ape;
    };
    
    this.GetNacimiento = function GetNacimiento(){
        return this.per.nac;
    };
    
    this.GetDefuncion = function GetDefuncion(){
        return this.per.def;
    };
    
    this.GetUrl = function GetUrl(){
        return this.per.url;
    };
}

var AdmiPer = new AdministrarPerfil();