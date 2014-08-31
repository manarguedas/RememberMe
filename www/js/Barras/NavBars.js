/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var CuerpoBarraInicio = '<nav class="navbar navbar-inverse" role="navigation">' +
                '<div class="navbar-header row BarraPrincipal" align="center">' + 
                    '<div class="ContenedorBotones">' + 
                        '<ul class="nav navbar-nav" >' +
                            '<li class="{1} col-xs-2 BotonAtras">' +
                                '<a href="registro.html">' +
                                    '<span class="glyphicon glyphicon-chevron-left"></span>'+
                                '</a>' +
                            '</li>' + 
                            '<li class="{2} col-xs-5 AnchoBoton">'+
                                '<a href="perfil.html">'+
                                    '<span class="glyphicon glyphicon-user"></span>'+
                                '</a>'+
                            '</li>'+
                            '<li class="{3} col-xs-5 AnchoBoton">'+
                                '<a href="buscar.html">'+
                                    '<span class="glyphicon glyphicon-search"></span>'+
                                '</a>'+
                            '</li>'+ 
                            '<li class="{4} col-xs-3 BotonAgregarPerfil">'+
                                '<a href="misperfiles.html">' +
                                    '<span class="glyphicon glyphicon-plus"></span>\
                                </a>\
                            </li>\
                        </ul>\
                    </div>\
                </div>\
        </nav>' ;


function ConfigurarBarra(pIndice){
    var mResultado = CuerpoBarraInicio.replace("{" + pIndice + "}","active");
    return mResultado;
}