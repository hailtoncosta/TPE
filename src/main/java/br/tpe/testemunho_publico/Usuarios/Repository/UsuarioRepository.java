package br.tpe.testemunho_publico.Usuarios.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.tpe.testemunho_publico.Usuarios.Model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    
    @Query("select u from UsuarioModel u where u.nome = ?1")
	UsuarioModel findUserByName(String nome);
	
	default Page<UsuarioModel> findUsuarioByName(String nome, Pageable pageable) {
		
		UsuarioModel usuario = new UsuarioModel();
		usuario.setNome(nome);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("nome", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		
		Example<UsuarioModel> example = Example.of(usuario, exampleMatcher);
		
		Page<UsuarioModel> usuarios = findAll(example, pageable);
		
		return usuarios;
	}
}
