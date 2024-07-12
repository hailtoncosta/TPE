package br.tpe.testemunho_publico.Carrinhos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.tpe.testemunho_publico.Carrinhos.Model.CarrinhoModel;
import br.tpe.testemunho_publico.Carrinhos.Repository.CarrinhoRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<CarrinhoModel> listarUsuarios() {
        return (List<CarrinhoModel>) carrinhoRepository.findAll(Sort.by("descricao"));
    }

    public CarrinhoModel salvarUsuarios(CarrinhoModel carrinhoModel) {
        return carrinhoRepository.saveAndFlush(carrinhoModel);
    }

    public Optional<CarrinhoModel> findUserById(Long id) {
        return carrinhoRepository.findById(id);
    }

    public void excluirUsuario(Long id) {
        carrinhoRepository.deleteById(id);
    }

    
}
