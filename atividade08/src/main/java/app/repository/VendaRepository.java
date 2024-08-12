package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Venda;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByClienteNomeContainingIgnoreCase(String clienteNome);
    List<Venda> findByFuncionarioNomeContainingIgnoreCase(String funcionarioNome);
}
