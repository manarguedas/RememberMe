
var pictureSource;
var destinationType;
document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady()
{
    pictureSource = navigator.camera.PictureSourceType;
    destinationType = navigator.camera.DestinationType;
}


function onPhotoURISuccess(imageURI)
{
    console.log(imageURI);
    var largeImage = document.getElementById('file'); //'fotoPerfil');
    //largeImage.style.display = 'block';
    //largeImage.src = imageURI;
    alert(imageURI);
    largeImage.url = imageURI;
}

function onSuccess(imageData) {
    alert("iniciando la subida");
    alert("imageData");
    //   $.post("http://localhost:8080/BackEndRememberMeApp/app/imagenes", {data: imageData}, function(data) {
    //     alert("Image uploaded!");
    //});
//    $.ajax({
//        url: "",
//        type: "POST",
//        data: {image: imageData},
//        contentType: "multipart/form-data",
//        success: function() {
//            alert("Image uploaded!");
//        }
//    });

    var url = "http://localhost:8080/BackEndRememberMeApp/app/imagenes";
    var params = {image: imageData};
    // send the data
    $.post(url, params, function(data) {
        alert("Image uploaded!");
    }
    );
    alert("vara envianda");
}

function onPhotoDataSuccess(imageURI)
{
    var imgProfile = document.getElementById('imgProfile');
    imgProfile.src = imageURI;
    if (sessionStorage.isprofileimage === 1)
    {
        getLocation();
    }
    movePic(imageURI);
}

function onFail(message)
{
    alert('Failed because: ' + message);
}

function successMove(entry)
{
    sessionStorage.setItem('imagepath', entry.fullPath);
}

function resOnError(error)
{
    alert(error.code);
}
function uploadText(imageURI) {

}

function capturePhotoEdit()
{
    navigator.camera.getPicture(onSuccess, onFail, {quality: 20, allowEdit: true,
        destinationType: destinationType.DATA_URL});
}

function getPhoto(source)
{   
    uploadFromGallery();
    return;
    navigator.camera.getPicture(uploadText, onFail, {quality: 50,
        destinationType: destinationType.FILE_URI,
        sourceType: source});
}

function onFail(message)
{
    alert('Failed because: ' + message);
}


function uploadFromGallery() {

    // Retrieve image file location from specified source
    navigator.camera.getPicture(uploadPhoto,
                                function(message) {},
                                { quality: 30, 
                                destinationType: navigator.camera.DestinationType.FILE_URI,
                                sourceType: navigator.camera.PictureSourceType.PHOTOLIBRARY }
                                );

}

function uploadPhoto(imageURI) {
    var options = new FileUploadOptions();
    //options.fileKey="imagen";
    options.fileName= sessionStorage.getItem("idDifunto") + ".png";///imageURI.substr(imageURI.lastIndexOf('/')+1) + ".png";
    //options.mimeType="image/jpeg";
    
    var params = {"image":"hola.jps"};
    options.params = params;
    alert("Iniciando la transferencia.");
    var ft = new FileTransfer();
    //ft.upload(imageURI, "http://192.168.0.130:8080/BackEndRememberMeApp/app/imagenes", win, fail, options);
    ft.upload(imageURI, kConstantes.Servidor + kConstantes.DirImagenes, win, fail, options);
}

function win(r) {
    alert("Imagen subida");
    console.log("Code = " + r.responseCode);
    console.log("Response = " + r.response);
    console.log("Sent = " + r.bytesSent);
    document.location.reload();
}

function fail(error) {
    alert("No se pudo subir la fotografía.");
    //alert("An error has occurred: Code = " + error.code);
    console.log("upload error source " + error.source);
    console.log("upload error target " + error.target);
}


function CopiarImagen(){
     $.ajax({
        url: "http://localhost:8080/BackEndRememberMeApp/app/imagenes", //"http://192.168.5.103:8080/BackEndRememberMeApp/app/imagenes",
        type: "PUT",
        contentType: "application/json",
        data: {"nombre": "12121"},
        success: function() {
            alert("Image uploaded!");
        }
    });
    alert("put enviado");
}