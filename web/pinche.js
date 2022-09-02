window.onload=function(){
    alert("Bienvenido a Neko Registros");   
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
}

function dataEje (){
    let divEje = document.createElement('div');
    let other = document.createElement('h5');
    let boton = document.createElement('button');
    let buttond = document.createElement('button');
    other.append('Estas seguro de realizar el registro?');
    boton.append('Guardar');
    buttond.append('Cancelar');
    boton.setAttribute("class","btn btn-warning"); boton.setAttribute("oneclick","sendData()"); 
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

let form = document.getElementById('formu');
function retornarValor(input){ return !(input.value.trim()===''); }

form.addEventListener('submit', (event)=> {
   requiredFields.forEach((input)=> {valid = valid|requireValue(input,input);});
   if(!valid){ event.preventDefault();}
});

function sendData(){
	const XHR = new XMLHttpRequest();
	  var formData = new FormData(document.getElementById('formu'));
	  XHR.addEventListener('ok', (event) => {alert('La informacion ah sido enviada');});
	  XHR.addEventListener('error',(event) => {alert('Oops! ah ocurrido un error (T_T)');});
	  XHR.open('POST', '/ServletClient');
	  XHR.send(formData);	
}

