let btnNuevaFecha = document.getElementById('btn-nueva-fecha');
btnNuevaFecha.addEventListener('click',mostrarModalFechaNueva);

function mostrarModalFechaNueva(){
	document.getElementById('titulo-nueva-fecha').innerHTML = "Nueva fecha disponible";
        document.getElementById('enviarFecha').value = "Agregar nueva fecha";
        document.getElementById('accionFecha').value = "nuevaFecha";
        
	$('#modalNuevaFecha').modal('show');
}
let botonesMostrarModalEdicion = document.getElementsByClassName('btn-editar-fecha');

	for( let i=0; i < botonesMostrarModalEdicion.length; i++ ){
		botonesMostrarModalEdicion[i].addEventListener('click', mostrarModalEdicion );
	}

function mostrarModalEdicion(event){
	
        document.getElementById('titulo-nueva-fecha').innerHTML = "Editar fecha y horario";
        document.getElementById('accionFecha').value = "editarFecha";
        let idFecha = event.target.getAttribute('data-fecha-id');
	
        let boxidFecha = document.getElementById('box-id-fecha');
        boxidFecha.innerHTML = ` <input type='hidden' name='idFecha' value='${idFecha}'>`;
        
	let filaFecha = document.getElementById( 'fila-' + idFecha );
        let fecha   = filaFecha.getElementsByTagName('td')[0].innerHTML;
        let horario = filaFecha.getElementsByTagName('td')[1].innerHTML;
        console.log(fecha);
        $('#idFecha').val(idFecha);
        $('#fecha').val(fecha);
        $('#horario').val(horario);
        
	$('#modalNuevaFecha').modal('show');	
}


let btnMostrarModalEliminar = document.getElementsByClassName('btn-eliminar-fecha');

for (var i = 0; i < btnMostrarModalEliminar.length; i++) {
	btnMostrarModalEliminar[i].addEventListener('click',mostrarModalEliminarFecha);
}

function mostrarModalEliminarFecha(event){
         let idFecha = event.target.getAttribute('data-fecha-id');
         console.log(idFecha);
         let boxidFecha = document.getElementById('box-id-fecha-eliminar');
         boxidFecha.innerHTML = ` <input type='hidden' name='idFecha' value='${idFecha}'>`;
	$('#modalEliminarFecha').modal('show');
}

