/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function AjaxSolicitud(pTipo, pUrl, pJson, pFuncion) {
    if (pTipo===kConstantes.delete || pTipo===kConstantes.put){
        AjaxEspecializado(pTipo, pUrl, pJson, pFuncion);
        return;
    }
    $.ajax({
        type: pTipo, // it's easier to read GET request parameters
        url: pUrl,
        dataType: 'JSON',
        data: {
            json: pJson,
            token: kConstantes.tokenFacebook,
            idFacebook: sessionStorage.getItem("idUser")
            
        },
        success: function(data) {
            pFuncion(data);
        },
        error: function(data) {
            alert('No se pudo conectar con el servidor.');
        }
    });
}

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

function AjaxDelete(pTipo, pUrl, pJson, pFuncion) {
    $.ajax({
        type: "delete", // it's easier to read GET request parameters
        url: pUrl,
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

function AjaxPut(pTipo, pUrl, pJson, pFuncion) {
    $.ajax({
        type: "put", // it's easier to read GET request parameters
        url: pUrl,
        dataType: 'JSON',
        data: {
            json: pJson,
            idFacebook: "1"
        },
        success: function(data) {
            pFuncion(data);
        },
        error: function(data) {
            alert('No se pudo conectar con el servidor.');
        }
    });
}

//verifica que el recurso existe
function UrlExists(url)
{
   var img = new Image();
   img.src = url;
   return img.height !== 0;
}
