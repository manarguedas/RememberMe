

function ClickDown(pFuncion, pParametro) {
    idTimeOut = setTimeout(function() {
        pFuncion(pParametro);
    }, 1000);
}

function ClickUp() {
    alert("up");
    clearTimeout(idTimeOut);
}

function GuardarDato(pId){
    sessionStorage.setItem("EveId",pId);
    Aparecer();
}

function Aparecer() {
    document.getElementById("opciones").style.visibility = "visible";
}
function Desaparecer() {
    document.getElementById("opciones").style.visibility = "hidden";
}

function LlamarFuncion(pFuncion){
    idTimeOut = setTimeout(function() {
        pFuncion(sessionStorage.getItem("EveId"));
    }, 1);
}

