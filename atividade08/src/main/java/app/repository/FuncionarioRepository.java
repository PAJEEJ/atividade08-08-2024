package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Cliente;
import app.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByNomeContainingIgnoreCase(String nome);
    

    // Buscar clientes com idade entre dois valores
    List<Funcionario> findByIdadeBetween(int startAge, int endAge);

    // Buscar clientes cujo nome começa com determinado prefixo
    List<Funcionario> findByNomeStartingWith(String nome);

    // Buscar clientes com idade superior a um determinado valor
    List<Funcionario> findByIdadeGreaterThan(int idade);
}

