package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Buscar clientes com idade entre dois valores
    List<Cliente> findByIdadeBetween(int startAge, int endAge);

    // Buscar clientes cujo nome começa com determinado prefixo
    List<Cliente> findByNomeStartingWith(String nome);

    // Buscar clientes com idade superior a um determinado valor
    List<Cliente> findByIdadeGreaterThan(int idade);
}
