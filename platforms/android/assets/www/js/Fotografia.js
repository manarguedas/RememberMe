/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    console.log(imageURI + "la vara fallo");
    alert(imageURI);
    var largeImage = document.getElementById('sls');
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

function movePic(file)
{ 
    window.resolveLocalFileSystemURI(file, resolveOnSuccess, resOnError); 
} 

function resolveOnSuccess(entry)
{ 
    var d = new Date();
    var n = d.getTime();
    var newFileName = n + ".jpg";
    var myFolderApp = "MyAppFolder";
    window.requestFileSystem(LocalFileSystem.PERSISTENT, 0, function(fileSys) 
    {      
        fileSys.root.getDirectory( myFolderApp,
                {create:true, exclusive: false},
                function(directory) 
                {
                    entry.moveTo(directory, newFileName,  successMove, resOnError);
                },
        resOnError);
    },
    resOnError);
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
