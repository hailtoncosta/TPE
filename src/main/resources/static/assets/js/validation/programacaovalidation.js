function validarCamposProgramacao() {

	var carrinho = document.getElementById('carrinho');
	var dia = document.getElementById('dia');
	var horario = document.getElementById('horario');
	var usuario_um = document.getElementById('usuario_um');
	var usuario_dois = document.getElementById('usuario_dois');
	var usuario_tres = document.getElementById('usuario_tres');

	if (carrinho.selectedIndex == 0) {
		document.getElementById('carrinho-error').innerHTML = "Selecione um carrinho!";
		carrinho.focus();
		return false;
	} else {
		document.getElementById('carrinho-error').innerHTML = "";
	}
	
	if (dia.selectedIndex == 0) {
		document.getElementById('dia-error').innerHTML = "Selecione um dia!";
		dia.focus();
		return false;
	} else {
		document.getElementById('dia-error').innerHTML = "";
	}
	
	if (horario.selectedIndex == 0) {
		document.getElementById('horario-error').innerHTML = "Selecione um horário!";
		horario.focus();
		return false;
	} else {
		document.getElementById('horario-error').innerHTML = "";
	}
	
	confirmarSalvar();
	
	return true;
}

function confirmarSalvar() {
	Swal.fire({
		position: "center",
		icon: "success",
		title: "Usuário salvo com sucesso!",
		showConfirmButton: false,
		timer: 1500
	  });

}
