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
    
    this.perfil = "";
    
    this.CrearPerfil = function CrearPerfil(){
        this.perfil = new Perfil();  
    };
    
    this.GetJSON = function GetJSON(){
        return JSON.stringify(this);
    };
    
    this.CargarJSON = function CargarJSON(pJSON){
        this.perfil = JSON.parse(pJSON).perfil;  
    };
    
    this.SetNombre = function SetNombre(pNombre){
        this.perfil.nom = pNombre;
    };
    
    this.SetApellido = function SetApellido(pApellido){
        this.perfil.ape = pApellido;
    };
    
    this.SetNacimiento = function SetNacimiento(pNacimiento){
        this.perfil.nac = pNacimiento;
    };
    
    this.SetDefuncion = function SetDefuncion(pDefuncion){
        this.perfil.def = pDefuncion;
    };
    
    this.SetUrl = function SetUrl(pUrl){
        this.perfil.url = pUrl;
    };
    
    this.GetNombre = function GetNombre(){
        return this.perfil.nom;
    };
    
    this.GetApellido = function GetApellido(){
        return this.perfil.ape;
    };
    
    this.GetNacimiento = function GetNacimiento(){
        return this.perfil.nac;
    };
    
    this.GetDefuncion = function GetDefuncion(){
        return this.perfil.def;
    };
    
    this.GetUrl = function GetUrl(){
        return this.perfil.url;
    };
}