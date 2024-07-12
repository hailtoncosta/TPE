package br.tpe.testemunho_publico.Carrinhos.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.tpe.testemunho_publico.Carrinhos.Model.CarrinhoModel;
import br.tpe.testemunho_publico.Carrinhos.Repository.CarrinhoRepository;
import br.tpe.testemunho_publico.Carrinhos.Service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @GetMapping("/cad_carrinhos")
    public ModelAndView cadastroCarrinho() {
        ModelAndView modelAndView = new ModelAndView("carrinho/cad_carrinhos");
        modelAndView.addObject("objcarrinho", new CarrinhoModel());
        return modelAndView;
    }

    @GetMapping("/listarcarrinhos")
    public ModelAndView ListarCarrinho() {
        ModelAndView modelAndView = new ModelAndView("carrinho/listarcarrinhos");
        modelAndView.addObject("listarcarrinhos", carrinhoRepository.findAll(PageRequest.of(0, 10, Sort.by("descricao"))));
        return modelAndView;
    }
    
    @PostMapping("/salvarcarrinhos")
    public ModelAndView salvarCarrinho(CarrinhoModel carrinhoModel, Model model) {
        carrinhoService.salvarUsuarios(carrinhoModel);
        return new ModelAndView("redirect:/carrinho/cad_carrinhos");
    }

    @GetMapping("/alterarCarrinho/{id}")
    public ModelAndView alterarCarrinho(@PathVariable("id") Long id) {
        Optional<CarrinhoModel> carrinho = carrinhoRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("carrinho/cad_carrinhos");
        modelAndView.addObject("objcarrinho", carrinho.get());
        return modelAndView ;
    }

    @GetMapping("/deletarCarrinho/{id}")
    public ModelAndView deletarCarrinho(@PathVariable("id") Long id) {
        carrinhoService.excluirUsuario(id);
        return new ModelAndView("redirect:/carrinho/listarcarrinhos");
    }

    @GetMapping("/carrinhopag")
	public ModelAndView carregarCarrinhoPorPaginacao(@PageableDefault(size = 10) Pageable pageable, ModelAndView modelAndView) {
        Page<CarrinhoModel> pageCarrinho = carrinhoRepository.findAll(pageable);
        modelAndView.addObject("listarcarrinhos", pageCarrinho);
		modelAndView.addObject("objcarrinho", new CarrinhoModel());
		modelAndView.setViewName("carrinho/listarcarrinhos");
		return modelAndView;
	}
}
