function confirmarExclusaoUsuario() {
    if (confirm('Deseja excluir o usuario?')) {
        return true;
    } else {
        return false;
    }
}