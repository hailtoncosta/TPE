package br.tpe.testemunho_publico.Usuarios.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.tpe.testemunho_publico.Usuarios.Model.UsuarioModel;
import br.tpe.testemunho_publico.Usuarios.Repository.UsuarioRepository;
import br.tpe.testemunho_publico.Usuarios.Service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/cad_usuarios")
    public ModelAndView cadastroUsuario() {
        ModelAndView modelAndView = new ModelAndView("usuario/cad_usuarios");
        modelAndView.addObject("objusuario", new UsuarioModel());
        return modelAndView;
    }

    @GetMapping("/listarusuarios")
    public ModelAndView ListarUsuario() {
        ModelAndView modelAndView = new ModelAndView("usuario/listarusuarios");
        modelAndView.addObject("listarusuarios", usuarioRepository.findAll(PageRequest.of(0, 10, Sort.by("nome"))));
        return modelAndView;
    }

    @PostMapping("/salvarUsuarios")
    public ModelAndView salvarUsuario(UsuarioModel usuarioModel) {
        usuarioRepository.save(usuarioModel);
        return cadastroUsuario();
    }

    @GetMapping("/alterarUsuario/{id}")
    public ModelAndView alterarUsuario(@PathVariable("id") Long id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("usuario/cad_usuarios");
        modelAndView.addObject("objusuario", usuario.get());
        return modelAndView;
    }

    @GetMapping("/deletarUsuario/{id}")
    public ModelAndView deletarUsuario(@PathVariable("id") Long id) {
        usuarioService.excluirUsuario(id);
        return new ModelAndView("redirect:/usuario/listarusuarios");
    }

    @GetMapping("/usuariopag")
    public ModelAndView carregarUsuarioPorPaginacao(@PageableDefault(size = 10) Pageable pageable,
            ModelAndView modelAndView) {
        Page<UsuarioModel> pageUsuario = usuarioRepository.findAll(pageable);
        modelAndView.addObject("listarusuarios", pageUsuario);
        modelAndView.addObject("objusuario", new UsuarioModel());
        modelAndView.setViewName("usuario/listarusuarios");
        return modelAndView;
    }

    @PostMapping("/pesquisarusuario")
    public ModelAndView pesquisarUsuario(@RequestParam("nomepesquisa") String nomepesquisa,
            @PageableDefault(size = 10, sort = { "nome" }) Pageable pageable) {

        Page<UsuarioModel> usuarios = null;

        usuarios = usuarioRepository.findUsuarioByName(nomepesquisa, pageable);

        ModelAndView modelAndView = new ModelAndView("usuario/listarusuarios");

        modelAndView.addObject("objusuario", new UsuarioModel());
        modelAndView.addObject("listarusuario", usuarios);
        modelAndView.addObject("nomepesquisa", nomepesquisa);

        return modelAndView;
    }
}
