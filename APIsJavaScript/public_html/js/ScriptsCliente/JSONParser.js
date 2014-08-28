/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Perfil() {
    this.nom;
    this.ape;
    this.nac;
    this.def;
    this.url;
    this.id;
}

function CrearPerfil(){
    var perfil = new Perfil();
    perfil.nom = "Ney";
    perfil.ape = "Rojas";
    perfil.nac = "dd/mm/aaaa";
    perfil.def = "07/02/2090";
    perfil.url = "djskndasdsa.png";
    perfil.id = "jkshjdkls";
    alert(JSON.stringify(perfil));
}