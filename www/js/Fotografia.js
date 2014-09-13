
var pictureSource;   
var destinationType; 

document.addEventListener("deviceready",onDeviceReady,false);

function onDeviceReady() 
{
    pictureSource=navigator.camera.PictureSourceType;
    destinationType=navigator.camera.DestinationType;
}


function onPhotoURISuccess(imageURI) 
{
    console.log(imageURI);
    var largeImage = document.getElementById('fotoPerfil');
    largeImage.style.display = 'block';
    largeImage.src = imageURI;
}

function onPhotoDataSuccess(imageURI) 
{ 
    var imgProfile = document.getElementById('imgProfile');
    imgProfile.src = imageURI;
    if(sessionStorage.isprofileimage===1)
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

function capturePhotoEdit() 
{
    navigator.camera.getPicture(onPhotoDataSuccess, onFail, { quality: 20, allowEdit: true,
    destinationType: destinationType.DATA_URL });
}

function getPhoto(source) 
{
    navigator.camera.getPicture(onPhotoURISuccess, onFail, { quality: 50, 
    destinationType: destinationType.FILE_URI,
    sourceType: source });
}

function onFail(message) 
{
    alert('Failed because: ' + message);
}
