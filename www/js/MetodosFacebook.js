/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function login() {
    if (!window.cordova) {
        var appId = prompt("669076949827119", "RememberMeApp");
        facebookConnectPlugin.browserInit(appId);
    }
    facebookConnectPlugin.login(["email"],
            function(response) {
                GuardarUsuario(response.authResponse.userID);
            },
            function(response) {
                alert("No se pudo conectar con facebook");
                GuardarUsuario(response.authResponse.userID);
            });
};


function GuardarUsuario(pIdUsuario) {
    //alert(pIdUsuario);
    sessionStorage.setItem("idUser", pIdUsuario);
    GuardarNombre(pIdUsuario);
}

function GuardarNombre(pIdUsuario) {
    if (pIdUsuario==="") return;
    facebookConnectPlugin.api(pIdUsuario+"/?fields=name", [],
            function(response) {
                //alert(response.name);
                sessionStorage.setItem("nomFace",response.name);
                window.location = "perfil.html";
            },
            function(response) {
                alert(response.name);
            });
};

//Permite publicar un comentario en el muro sobre que se agrego un perfil
// nuevo en al app Remember Me
function newStatusOnFB(pNombreDifunto){
    alert(pNombreDifunto);
    facebookConnectPlugin.getLoginStatus(
        function (status) {
            //alert("current status: " + JSON.stringify(status));
            
            //Recibe el nombre de la persona cuyo perfil fue agregado
            var person = pNombreDifunto;
            //Post generico que se publica al agregar un perfil nuevo
            var post = "Se ha agregado el perfil de " + person + " \n\
            y esta disponible su informacion en la app RememberMe";
            
            //Establece el mensaje a publicar
            var options = { method:"feed", caption:post };
            facebookConnectPlugin.showDialog(options,
                function (result) {
                    alert("Publicacion: " + JSON.stringify(result));
                }, function (e) {
                alert("Fallo: " + e);
            });
        }
    );
}