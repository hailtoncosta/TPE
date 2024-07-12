package br.tpe.testemunho_publico.Designar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "desgcarrinhos")
@Data
@SequenceGenerator(name = "seq_desgcarrinhos", sequenceName = "seq_desgcarrinhos", allocationSize = 1, initialValue = 1)
public class DesignarModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_desgcarrinhos")
    private Long id;
    private String usuario_um;
    private String usuario_dois;
    private String usuario_tres;
    private String carrinho;
    private String dia;
    private String horario;

}
