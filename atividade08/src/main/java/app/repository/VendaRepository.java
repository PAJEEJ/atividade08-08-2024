package app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByClienteNome(String clienteNome);
    List<Venda> findByFuncionarioNome(String funcionarioNome);
    List<Venda> findTop10ByOrderByValorTotalDesc();
}
