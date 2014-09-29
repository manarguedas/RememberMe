
//funcion que se ejecuta cuando se presiona una elemento
function ClickDown(pFuncion, pParametro) {
    idTimeOut = setTimeout(function() {
        pFuncion(pParametro);
    }, 200);
}

//funcion que se ejecuta cuando se elevanta el mouse
function ClickUp() {
    alert("up");
    clearTimeout(idTimeOut);
}

//guarda el id del objeto que se selecciono
function GuardarDato(pId) {
    sessionStorage.setItem("EveId", pId);
    Aparecer();
}

//funcion que muestra las opciones de modificar y eliminar 
function Aparecer() {
    document.getElementById("opciones").style.visibility = "visible";
}

//funcion que esconde las opciones de modificar y eliminar 
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

//funcion que checa que el dedo no dejo de ser presionado durante almenos un segundo 
function checkTapHold(nID) {
    alert("hold");
    if ((gbStillTouching) && (gnStartTime === nID)) {
        gbStillTouching = false;
        gnStartTime = 0;
        gnStartTime = 0;
        GuardarDato(lastClickedId);
    }
}

//Funcion que agrega a un elemento el evento de que pueda ser presionado con el dedo
function AgregarHold(pId) {
    document.getElementById(pId).addEventListener('touchstart', function(event) { //funcion que se ejcuta cuando el usuario comenzo el toque
        gnStartTime = Number(new Date());
        gbStillTouching = true;
        lastClickedId = pId;
        idTimeOut = setTimeout(function() {
            checkTapHold(gnStartTime);
            clearTimeout();
        }, 1200); //espera 1200 ms y ejecuta checkTapHold(gnStartTime) para ver si se cumplio el tiempo
    }, false);

    document.getElementById(pId).addEventListener('touchmove', function(event) {	//funcion que se ejecuta si la persona mueve el dedo
        gbStillTouching = false;
        clearTimeout(idTimeOut);
    }, false);

    document.getElementById(pId).addEventListener('touchend', function(event) { //funcion que se ejecuta en caso de el usuario solto el dedo
        gbStillTouching = false;
        clearTimeout(idTimeOut);
    }, false);

}
