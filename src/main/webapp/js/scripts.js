let btnCancelarClase = document.getElementsByClassName('btn-cancelar-clase');

for (var i = 0; i < btnCancelarClase.length; i++) {
	//btnCancelarClase[i].addEventListener('click',mostrarModalCancelar);
        btnCancelarClase[i].addEventListener('click',mostrarModalCancelar);
}
function mostrarModalCancelar(event){
    let idClase = event.target.getAttribute('data-clase-id');
    
    console.log(idClase);
    document.getElementById('idClase').value = idClase;
    $('#modalCancelarClase').modal('show');	
}

let btnReservarClase = document.getElementsByClassName('btn-reservar');

for (var i = 0; i < btnReservarClase.length; i++) {
	btnReservarClase[i].addEventListener('click',mostrarModalReserva);
}
function mostrarModalReserva(){
	$('#modalReserva').modal('show');
}
