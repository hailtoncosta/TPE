package br.tpe.testemunho_publico.Designar.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.tpe.testemunho_publico.Designar.Model.DesignarModel;

@Repository
public interface DesignarRepository extends JpaRepository<DesignarModel, Long> {
    
    @Query("select u from DesignarModel u where u.carrinho = ?1")
	DesignarModel findUserByName(String carrinho);
	
	default Page<DesignarModel> findDesigCarrinhoByName(String carriho, Pageable pageable) {
		
		DesignarModel carrinhos = new DesignarModel();
		carrinhos.setCarrinho(carriho);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("nomeUsuario", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		
		Example<DesignarModel> example = Example.of(carrinhos, exampleMatcher);
		
		Page<DesignarModel> usuarios = findAll(example, pageable);
		
		return usuarios;
	}
}
