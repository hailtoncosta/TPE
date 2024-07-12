function validarCamposCarrinhos() {

	
	var descricao = document.getElementById('descricao');
	var local = document.getElementById('local');
	
	if (descricao.value === '') {
		document.getElementById('descricao-error').innerHTML = "Informe a descrição!";
		descricao.focus();
		return false;
	} else {
		document.getElementById('descricao-error').innerHTML = "";
	}
	
	if (local.value === '') {
		document.getElementById('local-error').innerHTML = "Informe o local!";
		local.focus();
		return false;
	} else {
		document.getElementById('local-error').innerHTML = "";
	}
	
	confirmarSalvar();
	
	return true;
}

function confirmarSalvar() {
	Swal.fire({
		position: "center",
		icon: "success",
		title: "Carrinho salvo com sucesso!",
		showConfirmButton: false,
		timer: 1500
	  });

}
