package app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByIdadeBetween(int startAge, int endAge);
    List<Cliente> findByNomeStartingWith(String nome);
    List<Cliente> findByIdadeGreaterThan(int idade);
}
