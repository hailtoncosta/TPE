package br.tpe.testemunho_publico.Usuarios.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.tpe.testemunho_publico.Usuarios.Model.UsuarioModel;
import br.tpe.testemunho_publico.Usuarios.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<UsuarioModel> listarUsuarios(int pageNumber) {
        return usuarioRepository.findAll(PageRequest.of(pageNumber - 1, 10, Sort.by("nome")));
    }

    public UsuarioModel salvarUsuarios(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public void atualizarUsuarios(UsuarioModel usuarioModel) {
        usuarioRepository.save(usuarioModel);
    }

    public Optional<UsuarioModel> findUserById(Long id) {
        return usuarioRepository.findById(id);
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
