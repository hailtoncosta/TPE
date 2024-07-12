function confirmarExclusaoCarrinho() {
    if (confirm('Deseja excluir o carrinho?')) {
        return true;
    } else {
        return false;
    }
}