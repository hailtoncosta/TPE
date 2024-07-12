package br.tpe.testemunho_publico.Designar.Controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.tpe.testemunho_publico.Carrinhos.Repository.CarrinhoRepository;
import br.tpe.testemunho_publico.Designar.Model.DesignarModel;
import br.tpe.testemunho_publico.Designar.Repository.DesignarRepository;
import br.tpe.testemunho_publico.Designar.Service.DesignarService;
import br.tpe.testemunho_publico.Usuarios.Repository.UsuarioRepository;

@RestController
@RequestMapping("/designar")
public class DesignarController {

    @Autowired
    private DesignarService designarService;

    @Autowired
    private DesignarRepository designarRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @GetMapping("/desg_carrinhos")
    public ModelAndView cadDesginarCarrinho() {
        ModelAndView modelAndView = new ModelAndView("designar/desg_carrinhos");
        modelAndView.addObject("objdesgcarrinho", new DesignarModel());
        modelAndView.addObject("listausuarios", usuarioRepository.findAll());
        modelAndView.addObject("listacarrinhos", carrinhoRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/listardesgcarrinhos")
    public ModelAndView ListarDesigUsuario() {
        ModelAndView modelAndView = new ModelAndView("designar/listardesgcarrinhos");
        modelAndView.addObject("listardesigcarrinhos", designarRepository.findAll(PageRequest.of(0, 10, Sort.by("carrinho"))));
        return modelAndView;
    }
    
    @PostMapping("/salvarDesigCarrinho")
    public ModelAndView salvarDesigCarrinho(DesignarModel designarModel) {
        designarRepository.save(designarModel);
        return cadDesginarCarrinho();
    }

    @GetMapping("/alterarDesigCarrinho/{id}")
    public ModelAndView alterarDesigCarrinho(@PathVariable("id") Long id) {
        Optional<DesignarModel> desigCarrinho = designarRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("designar/desg_carrinhos");
        modelAndView.addObject("objdesgcarrinho", desigCarrinho.get());
        modelAndView.addObject("listausuarios", usuarioRepository.findAll());
        modelAndView.addObject("listacarrinhos", carrinhoRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/deletarDesigCarrinho/{id}")
    public ModelAndView deletarDesigCarrinho(@PathVariable("id") Long id) {
        designarService.excluirDesigCarrinho(id);
        return new ModelAndView("redirect:/designar/listardesgcarrinhos");
    }

    @GetMapping("/desigcarrinhopag")
	public ModelAndView carregarDesigCarrinhoPorPaginacao(@PageableDefault(size = 10) Pageable pageable, ModelAndView modelAndView) {
        Page<DesignarModel> pageDesgCarrinho = designarRepository.findAll(pageable);
        modelAndView.addObject("listardesigcarrinhos", pageDesgCarrinho);
		modelAndView.addObject("objdesgcarrinho", new DesignarModel());
		modelAndView.setViewName("designar/listardesgcarrinhos");
		return modelAndView;
	}
}
