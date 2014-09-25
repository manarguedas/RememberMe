/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function AjaxSolicitud(pTipo, pUrl, pJson, pFuncion) {
    $.ajax({
        type: pTipo, // it's easier to read GET request parameters
        url: pUrl,
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