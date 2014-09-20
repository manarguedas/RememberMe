/* 
 * Utiliza las varibles y métodos para usar el API de Google Maps.
 */

/*------------------------------------------------
 * Relacionado con establecer el Lugar de descanso
 *------------------------------------------------*/
//Función del botón de Lugar de descanso
function setLugar(){
    location.href="SetLugarDescanso.html";
}

//Permite establecer la posición actual y presentarla en una mapa usando
//GoogleMaps, esta será la posición a establecer como Lugar de descanso.
//Se inicia cuando se carga la página SetLugarDescanso.html.
function initialize(){
    var mapOptions = {
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById('mapa'), mapOptions);

    // Try HTML5 geolocation
    if(navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var longitud = position.coords.longitude;
            var latitud = position.coords.latitude;
            //Guardar latitud y longitud para enviar al back-end
            var pos = new google.maps.LatLng(latitud, longitud);

            var infowindow = new google.maps.InfoWindow({
              map: map,
              position: pos,
              content: 'Posición a establecer'
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
//Función del botón de Lugar de descanso
function verLugar(){
    location.href="VerLugarDescanso.html";
}

//Permite establecer la posición actual y presentarla en una mapa usando
//GoogleMaps, esta será la posición a establecer como Lugar de descanso.
//Se inicia cuando se carga la página SetLugarDescanso.html.
function initialize2(){
    var mapOptions = {
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById('mapa'), mapOptions);

    // Try HTML5 geolocation
    if(navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            //AQUI va llamar a la función del back-end q da la lat y long
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