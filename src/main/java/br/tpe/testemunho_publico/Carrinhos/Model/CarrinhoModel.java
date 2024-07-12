package br.tpe.testemunho_publico.Carrinhos.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "carrinhos")
@Data
@SequenceGenerator(name = "seq_carrinho", sequenceName = "seq_carrinho", allocationSize = 1, initialValue = 1)
public class CarrinhoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carrinho")
    private Long id;
    private String descricao;
    private String local;

}
