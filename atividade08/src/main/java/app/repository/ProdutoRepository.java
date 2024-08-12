package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Funcionario;
import app.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findTop10ByOrderByPrecoDesc();
    // Buscar clientes com idade entre dois valores
    List<Funcionario> findByIdadeBetween(int startAge, int endAge);

    // Buscar clientes cujo nome começa com determinado prefixo
    List<Funcionario> findByNomeStartingWith(String nome);

    // Buscar clientes com idade superior a um determinado valor
    List<Funcionario> findByIdadeGreaterThan(int idade);
}
