function validarCamposUsuarios() {

	
	var nome = document.getElementById('nome');
	var congregacao = document.getElementById('congregacao');
	var telefone = document.getElementById('telefone');
	var email = document.getElementById('email');
	var password = document.getElementById('password');
	
	if (nome.value === '') {
		document.getElementById('nome-error').innerHTML = "Informe o seu nome!";
		nome.focus();
		return false;
	} else {
		document.getElementById('nome-error').innerHTML = "";
	}
	
	if (congregacao.value === '') {
		document.getElementById('congregacao-error').innerHTML = "Informe a sua congregação!";
		congregacao.focus();
		return false;
	} else {
		document.getElementById('congregacao-error').innerHTML = "";
	}
	
	if (telefone.value === '') {
		document.getElementById('telefone-error').innerHTML = "Informe o seu telefone!";
		telefone.focus();
		return false;
	} else {
		document.getElementById('telefone-error').innerHTML = "";
	}
	
	if (email.value === '') {
		document.getElementById('email-error').innerHTML = "Informe o seu email!";
		email.focus();
		return false;
	} else {
		document.getElementById('email-error').innerHTML = "";
	}
	
	if (password.value === '') {
		document.getElementById('password-error').innerHTML = "Informe a sua senha!";
		password.focus();
		return false;
	} else {
		document.getElementById('password-error').innerHTML = "";
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
