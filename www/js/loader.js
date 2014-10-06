/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var cascaraCargando = '<div id="Cargador"  style="position: fixed; top: 0px; left: 0px; z-index: 100;" align="center">\
            <div style="top: 9%; margin-left: 35%; margin-right: 38%; position: fixed;">\
                <br><div class="spinner" ></div>\
                <h3 style="color:  white;">Cargando</h3>\
            </div>\
            <div style="top: 5%; margin: 15%; left:0px; position: fixed; background-color: #0088cc; border-radius: 10px; opacity: 0.7; width: 70%; height: 50%; z-index: -2;" ></div>\
        </div>';


function MostrarCargando() {
    var div = document.getElementById('Cargador');
    if (!div) {
        document.body.innerHTML += (cascaraCargando);
    }
    
}

function OcultarCargando() {
    var div = document.getElementById('Cargador');
    if (div) {
        div.parentNode.removeChild(div);
    }
}