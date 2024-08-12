package app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToMany
    private List<Produto> produtos;

    private String observacoes;

    private Double valorTotal;

    @PrePersist
    @PreUpdate
    public void calcularValorTotal() {
        this.valorTotal = produtos.stream()
                                  .mapToDouble(Produto::getPreco)
                                  .sum();
    }

    // getters and setters
}
