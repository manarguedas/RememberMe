/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Esta funcion es la que se encarga de realizar solicitudes al servidor 
//recibe la direccion, la funcion que se ejecuta, un parametro json y el tipo de solicitud
function AjaxSolicitud(pTipo, pUrl, pJson, pFuncion) {
    if (pTipo===kConstantes.delete || pTipo===kConstantes.put){
        AjaxEspecializado(pTipo, pUrl, pJson, pFuncion); //si la solicitud es un put o un delete, la solicitud tiene que ser procesada de una forma diferente
        return;
    }
    $.ajax({
        type: pTipo, // it's easier to read GET request parameters
        url: pUrl,
        dataType: 'JSON',
        data: {
            json: pJson,
            token: kConstantes.tokenFacebook, //se envia el token de facebook en cada solicitud
            idFacebook: sessionStorage.getItem("idUser")
            
        },
        success: function(data) {
            pFuncion(data); //se llama a la funcion, en caso de exito
        },
        error: function(data) {
            alert('No se pudo conectar con el servidor.');
        }
    });
}

//funcion especializada que se tiene que hacer en caso de que la solicitud sea delete o put, pues no funcionaba correctamente el envio de parametros
function AjaxEspecializado(pTipo, pUrl, pJson, pFuncion){
     $.ajax({
        type: pTipo, // it's easier to read GET request parameters
        url: pUrl + "&token=" + kConstantes.tokenFacebook,
        dataType: 'JSON',
        data: {
            json: pJson 
        },
        success: function(data) {
            pFuncion(data);
        },
        error: function(data) {
            alert('No se pudo conectar con el servidor.');
        }
    });
}
