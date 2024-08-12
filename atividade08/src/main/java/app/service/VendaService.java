package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import app.entity.Venda;
import app.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda salvarVenda(Venda venda) {
        venda.calcularValorTotal();
        return vendaRepository.save(venda);
    }

    public List<Venda> buscarPorClienteNome(String nome) {
        return vendaRepository.findByClienteNomeContainingIgnoreCase(nome);
    }

    public List<Venda> buscarPorFuncionarioNome(String nome) {
        return vendaRepository.findByFuncionarioNomeContainingIgnoreCase(nome);
    }

    public List<Venda> listarAs10MaisCaras() {
        return vendaRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "valorTotal"))).getContent();
    }
}
