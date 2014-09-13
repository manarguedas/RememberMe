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
    sessionStorage.setItem("idUser", pIdUsuario);
    window.location = "perfil.html";
}

function apiTest(pIdUsuario) {
    if (pIdUsuario==="") return;
    facebookConnectPlugin.api(pIdUsuario+"/?fields=id,email,name", [],
            function(response) {
                alert(response.name);

            },
            function(response) {
                alert(response.name);
            });
};
