/* global Swal */

window.onload=function(){
    alert("Se quiere registrar Master?");   
}

function comeDom (){
    let cliente = new Object();
    let codigo=document.getElementById("cod");
    let nombre=document.getElementById("name");
    let direccion=document.getElementById("loc");
    let correo=document.getElementById("mail");
    let telefono=document.getElementById("tel");
    cliente.codigo=cod.value;
    cliente.nombre=name.value;
    cliente.direccion=loc.value;
    cliente.correo=mail.value;
    cliente.telefono=tel.value;
    console.log(cliente);
    cod.value='';
    name.value='';
    loc.value='';
    mail.value='';
    tel.value='';
}

function dataEje (){
    let divEje = document.createElement('div');
    let other = document.createElement('h5');
    let boton = document.createElement('button');
    let buttond = document.createElement('button');
    other.append('Estas seguro de realizar el registro?');
    boton.append('Guardar');
    buttond.append('Cancelar');
    boton.setAttribute("class","btn btn-warning");boton.setAttribute("type","button"); boton.setAttribute("oneclick","sendData()"); 
    buttond.setAttribute("type","reset"); buttond.setAttribute("class","btn btn-dark");
    let container = document.getElementById('nuevo');
    container.append(other);
    container.append(divEje);
    container.append(boton);
    container.append(buttond);
}

/*function confirm (){
    var eve = document.getElementsByName("confi");
    if (confirm('Estas seguro de realizar el Regisro?')){
        var form = document.getElementById("formu");
        form.submit();
    }
    else{alert("No se realizo el registro");}
    }*/

function sendData(){
	const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('formu'))).toString();
	  XHR.addEventListener('error',(event) => {alert('Oops! ah ocurrido un error (T_T)');});
	  XHR.open('POST', 'ServletClient', true);
          XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    
          XHR.onload = () => { if (XHR.readyState === XHR.DONE && XHR.status === 200){
            console.log("response => " + XHR.response);
            document.getElementById('regTab').innerHTML=XHR.response; susMsj('Cliente guardado exitosamente'); clearFormu();}};
          XHR.send(formData);	
}

function clearFormu(){
    document.getElementById("cod").value='';
    document.getElementById("name").value='';
    document.getElementById("loc").value='';
    document.getElementById("mail").value='';
    document.getElementById("tel").value='';
}

function susMsj(msj){
  Swal.fire({
  icon: 'success',
  title: msj,
  showConfirmButton: false,
  timer: 1500
})
}

function eliminarcliente(codigo){
    const XHR = new XMLHttpRequest();
    var formData = new URLSearchParams(new FormData());

    XHR.addEventListener('error', (event) => {
      alert('Oops! Something went wrong.');
    });

    XHR.open('POST', 'ServletClient', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
      if (XHR.readyState === XHR.DONE && XHR.status === 200) {
        console.log("response => " + XHR.response);
        susMsj('Adiooos Neko Cliente');
        setTimeout( 2000 );
      }
    };        
    formData.append('codigoBD', codigo);
    formData.append('control', 'ELIMINAR');
    XHR.send(formData); 

}
function f5() { window.location.reload();};