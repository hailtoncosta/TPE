function validarCamposAgendamentos() {

	var cliente = document.getElementById('clientes');
	var servico = document.getElementById('servicos');
	var valor = document.getElementById('valor');

	if (cliente.value === '') {
		document.getElementById('cliente-error').innerHTML = "Informe o cliente!";
		cliente.focus();
		return false;
	} else {
		document.getElementById('cliente-error').innerHTML = "";
	}
	
	if (servico.value === '') {
		document.getElementById('servico-error').innerHTML = "Informe o serviço!";
		servico.focus();
		return false;
	} else {
		document.getElementById('servico-error').innerHTML = "";
	}
	
	if (valor.value === '') {
		document.getElementById('valor-error').innerHTML = "Informe o valor!";
		valor.focus();
		return false;
	} else {
		document.getElementById('valor-error').innerHTML = "";
	}
	
		return true;
}

function exibirvalor() {
	var valor = document.getElementById("valor");
	
		valor.value = "10.00";
	
}



