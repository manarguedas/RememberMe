/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function Comunicador(){
    this.tipo = "GET";
    this.url = "/app";
    this.dato;
    this.llamarFuncion;
    
    this.SetFuncion = function SetFuncion(pFuncion){
        this.llamarFuncion = pFuncion;
    };
    
    this.SetTipo = function SetTipo(pTipo){
        this.tipo = pTipo;
    };
    
    this.SetUrl = function SetUrl(pUrl){
        this.url = pUrl;
    };
    
    this.SetDato = function SetDato(pDato){
        this.dato = pDato;
    };
    
    this.Enviar = function Enviar(){        
    $.ajax({
          url: this.url, //,
          type: this.tipo,
          data: this.dato,
          success: function (result) {
             alert("sdsds" + result);
          },
          error:function(result,status,er) {
              alert("error: "+data.success()+" status: "+status+" er:"+er);
          }
      });
    };
}



function GetJ(){
    $.get( "http://localhost:8080/BackEndRememberMeApp/perfiles", function( data ) {
  alert( JSON.stringify(data) );
  console.log(data);
  alert( "Load was performed." );
});
    
}

function Ajax(){
    
    $.ajax({
    type: 'get', // it's easier to read GET request parameters
    url: 'http://localhost:8080/BackEndRememberMeApp/perfiles',
    dataType: 'JSON',
    data: { 
      loadProds: 1,
      test: "{\"per\":\"nac\"}" // look here!
    },
    success: function(data) {
        alert( JSON.stringify(data));
    },
    error: function(data) {
        alert('fail');
    }
});
}

function Request(){
    
      var xmlhttp;
    function init() {
       // put more code here in case you are concerned about browsers that do not provide XMLHttpRequest object directly
       xmlhttp = new XMLHttpRequest();
    }
    function getdetails() {
        var url = "http://localhost:8080/BackEndRememberMeApp/perfiles";
        xmlhttp.open('GET',url,true);
        xmlhttp.setRequestHeader('Content-Type', 'application/json');
        xmlhttp.send("json={\"per\":\"nac\"}");
        
        xmlhttp.onreadystatechange = function() {
               if (xmlhttp.readyState === 4) {
                  if ( xmlhttp.status === 200) {
                      alert(xmlhttp.responseText);
                       var det = eval( "(" +  xmlhttp.responseText + ")");
                       alert(xmlhttp.responseText);
                 }
                 else
                       alert("Error ->" + xmlhttp.responseText);
              }
        };
    }
            init();
        getdetails();
  
    
}