package br.tpe.testemunho_publico.Designar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.tpe.testemunho_publico.Designar.Model.DesignarModel;
import br.tpe.testemunho_publico.Designar.Repository.DesignarRepository;

@Service
public class DesignarService {

    @Autowired
    private DesignarRepository designarRepository;

    public List<DesignarModel> listarDesigCarrinho() {
        return (List<DesignarModel>) designarRepository.findAll(Sort.by("nomeUsuario"));
    }

    public DesignarModel salvarUsuarios(DesignarModel designarModel) {
        return designarRepository.saveAndFlush(designarModel);
    }

    public Optional<DesignarModel> findUserById(Long id) {
        return designarRepository.findById(id);
    }

    public void excluirDesigCarrinho(Long id) {
        designarRepository.deleteById(id);
    }

    
}
