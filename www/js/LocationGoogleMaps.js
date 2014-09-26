/* 
 * Utiliza las varibles y mÃ©todos para usar el API de Google Maps.
 */

var longitud;
var latitud;
var mensaje;

/*------------------------------------------------
 * Relacionado con establecer el Lugar de descanso
 *------------------------------------------------*/
//FunciÃ³n del botÃ³n de Lugar de descanso
function setLugar() {
    location.href = "SetLugarDescanso.html";
}

//Permite establecer la posiciÃ³n actual y presentarla en una mapa usando
//GoogleMaps, esta serÃ¡ la posiciÃ³n a establecer como Lugar de descanso.
//Se inicia cuando se carga la pÃ¡gina SetLugarDescanso.html.
function GuardarMapa() {
    mensaje = "Establecer lugar descanso.";
    GestionMapa(0);
}

function GestionMapa(pTipoVista) {
    var mapOptions = {
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById('mapa'), mapOptions);

    // Try HTML5 geolocation
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            if (pTipoVista === 0) {
                longitud = position.coords.longitude;
                latitud = position.coords.latitude;
            }
            //Guardar latitud y longitud para enviar al back-end
            var pos = new google.maps.LatLng(latitud, longitud);

            var infowindow = new google.maps.InfoWindow({
                map: map,
                position: pos,
                content: mensaje
            });

            map.setCenter(pos);
        }, function() {
            handleNoGeolocation(true);
        });
    } else {
        // Browser doesn't support Geolocation
        handleNoGeolocation(false);
    }
}

//Manejar errores si no hay Geolocation
function handleNoGeolocation(errorFlag) {
    if (errorFlag) {
        var content = 'Error: Fallo el servicio Geolocation.';
    } else {
        var content = 'Error: Geolocation no soportado.';
    }

    var options = {
        map: map,
        position: new google.maps.LatLng(60, 105),
        content: content
    };

    var infowindow = new google.maps.InfoWindow(options);
    map.setCenter(options.position);
}

/*-----------------------------------------
 * Relacionado con ver el Lugar de descanso
 *-----------------------------------------*/
//FunciÃ³n del botÃ³n de Lugar de descanso
function verLugar() {
    location.href = "VerLugarDescanso.html";
}

//Permite establecer la posiciÃ³n actual y presentarla en una mapa usando
//GoogleMaps, esta serÃ¡ la posiciÃ³n a establecer como Lugar de descanso.
//Se inicia cuando se carga la pÃ¡gina SetLugarDescanso.html.
function initialize2() {
    var mapOptions = {
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById('mapa'), mapOptions);

    // Try HTML5 geolocation
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            //AQUI va llamar a la funciÃ³n del back-end q da la lat y long
            var longitud = position.coords.longitude;//Cambiar por lo que viene
            var latitud = position.coords.latitude;//cambiar por lo que viene
            var pos = new google.maps.LatLng(latitud, longitud);

            var infowindow = new google.maps.InfoWindow({
                map: map,
                position: pos,
                content: 'Lugar de descanso'
            });

            map.setCenter(pos);
        }, function() {
            handleNoGeolocation(true);
        });
    } else {
        // Browser doesn't support Geolocation
        handleNoGeolocation(false);
    }
}


function onclickVerLugar() {
    if (sessionStorage.getItem("TipoUsuario") !== "0") {
        document.location = "SetLugarDescanso.html";
    }
    else {
        document.location = "VerLugarDescanso.html";
    }
}

function CargarPosicion() {
    AjaxSolicitud(kConstantes.get, kConstantes.Servidor + kConstantes.DirLocation + "?idDifunto=" + sessionStorage.getItem("idDifunto"), "",
            function(pDato) {
                if (pDato.cord.length === 0) {
                    alert("No tiene ninguna posición almacenada.");
                    return;
                }
                latitud = pDato.cord[0].cordx;
                longitud = pDato.cord[0].cordy;
                mensaje = "Lugar descanso.";
                GestionMapa(1);
            });

}

function GuardarPosicion() {
    var json = {"idd": sessionStorage.getItem("idDifunto"), "cord": [{"cordx": latitud + "", "cordy": longitud + ""}]};
    AjaxSolicitud(kConstantes.post, kConstantes.Servidor + kConstantes.DirLocation, JSON.stringify(json),
            function() {
                alert("Posición almacenada exitosamente.");
            });
}