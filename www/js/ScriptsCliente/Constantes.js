/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//esta estructura contiene las constantes utilizadas a los largo de la aplicacion, para su correcto funcionamiento
function Constantes(){
    this.Servidor = "http://www.remembermeapp.com:8080/BackEndRememberMeApp/"; //contine la direccion del app
    this.DirPerfiles = "app/perfiles"; //direccion para los perfiles 
    this.DirBiografias = "app/biografias"; //direccion para las biogarfias 
    this.DirEventos = "app/eventos"; //direccion para las actividades 
    this.DirBusquedas = "app/busquedas"; //dreccion para realizar la busqueda por id de usuario
    this.DirBusquedasNombre = "app/busquedasPerfiles"; //direccion para realizar las busquedas por nombre y no por id de usuario 
    this.DirComentarios = "app/comentarios"; //direccion para los comentarios 
    this.DirImagenes = "app/imagenes"; //direccion para subir imagenes al servidor 
    this.DirLocation = "app/coordenadas"; //direccion para las coordenadas del sepulcro 
    
    this.DirImagenesAlmacen = "http://www.remembermeapp.com:8080/imagenes/"; //lugar donde se almacenan las imagenes de los difuntos 
    
    this.get = "GET";
    this.post = "POST";
    this.delete = "DELETE";
    this.put = "PUT";
    
    this.tokenFacebook = "669076949827119"; //token de identificacion de facebook, sin el la aplicacion no se puede identificar y el servidor no retorna resultados 
}
var kConstantes = new Constantes();

