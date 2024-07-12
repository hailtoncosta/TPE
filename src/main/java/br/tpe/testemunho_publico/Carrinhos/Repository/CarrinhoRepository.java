package br.tpe.testemunho_publico.Carrinhos.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.tpe.testemunho_publico.Carrinhos.Model.CarrinhoModel;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Long> {
    
    @Query("select u from CarrinhoModel u where u.descricao = ?1")
	CarrinhoModel findUserByDescricao(String descricao);
	
	default Page<CarrinhoModel> findCarrinhoByDescricao(String descricao, Pageable pageable) {
		
		CarrinhoModel carrinho = new CarrinhoModel();
		carrinho.setDescricao(descricao);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("descricao", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		
		Example<CarrinhoModel> example = Example.of(carrinho, exampleMatcher);
		
		Page<CarrinhoModel> carrinhos = findAll(example, pageable);
		
		return carrinhos;
	}
}
