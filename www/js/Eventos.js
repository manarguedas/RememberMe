

function ClickDown(pFuncion, pParametro) {
    idTimeOut = setTimeout(function() {
        pFuncion(pParametro);
    }, 200);
}

function ClickUp() {
    alert("up");
    clearTimeout(idTimeOut);
}

function GuardarDato(pId) {
    sessionStorage.setItem("EveId", pId);
    Aparecer();
}

function Aparecer() {
    document.getElementById("opciones").style.visibility = "visible";
}
function Desaparecer() {
    document.getElementById("opciones").style.visibility = "hidden";
}

function LlamarFuncion(pFuncion) {
    idTimeOut = setTimeout(function() {
        pFuncion(sessionStorage.getItem("EveId"));
    }, 1);
}


var gnStartTime = 0;
var gbStillTouching = false;
var lastClickedId = 0;

function checkTapHold(nID) {
    alert("hold");
    if ((gbStillTouching) && (gnStartTime === nID)) {
        gbStillTouching = false;
        gnStartTime = 0;
        gnStartTime = 0;
        GuardarDato(lastClickedId);
    }
}

function AgregarHold(pId) {
    document.getElementById(pId).addEventListener('touchstart', function(event) {
        gnStartTime = Number(new Date());
        gbStillTouching = true;
        lastClickedId = pId;
        idTimeOut = setTimeout(function() {
            checkTapHold(gnStartTime);
            clearTimeout();
        }, 1200);
    }, false);

    document.getElementById(pId).addEventListener('touchmove', function(event) {
        gbStillTouching = false;
        clearTimeout(idTimeOut);
    }, false);

    document.getElementById(pId).addEventListener('touchend', function(event) {
        gbStillTouching = false;
        clearTimeout(idTimeOut);
    }, false);

}
