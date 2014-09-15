/* 
 * Utiliza la varibles y métodos para usar Google Maps.
 */
function setLugar(){
    location.href="SetLugarDescanso.html";
}

function initialize(){
    /*navigator.geolocation.getCurrentPosition(onSuccess, onError);
}

function onSuccess(position){
    var element = document.getElementById('geolocation');
    var longitud = position.coords.longitude;
    var latitud = position.coords.latitude;
    var latlong = new google.maps.LatLng(latitud, longitud);
    
    var mapOptions = {
        center: latlong,
        zoom: 16,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    
    var map = new google.maps.Map(document.getElementById('geolocation'), mapOptions);
}

function onError(error){
    alert("Código: " + error.code + " mensaje: " + error.message);
}*/

var mapOptions = {
    zoom: 6
  };
  map = new google.maps.Map(document.getElementById('geolocation'),
      mapOptions);

  // Try HTML5 geolocation
  if(navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
      var pos = new google.maps.LatLng(position.coords.latitude,
                                       position.coords.longitude);

      var infowindow = new google.maps.InfoWindow({
        map: map,
        position: pos,
        content: 'Location found using HTML5.'
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

function handleNoGeolocation(errorFlag) {
  if (errorFlag) {
    var content = 'Error: The Geolocation service failed.';
  } else {
    var content = 'Error: Your browser doesn\'t support geolocation.';
  }

  var options = {
    map: map,
    position: new google.maps.LatLng(60, 105),
    content: content
  };

  var infowindow = new google.maps.InfoWindow(options);
  map.setCenter(options.position);
}

google.maps.event.addDomListener(window, 'load', initialize);
