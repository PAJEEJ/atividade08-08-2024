package app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entity.Venda;
import app.repository.VendaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional
    public Venda salvarVenda(Venda venda) {
        venda.calcularValorTotal();
        return vendaRepository.save(venda);
    }

    @Transactional
    public Venda atualizarVenda(Venda venda) {
        venda.calcularValorTotal();
        return vendaRepository.save(venda);
    }

    @Transactional
    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Venda> listarTodos() {
        return vendaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Venda> buscarPorClienteNome(String clienteNome) {
        return vendaRepository.findByClienteNome(clienteNome);
    }

    @Transactional(readOnly = true)
    public List<Venda> buscarPorFuncionarioNome(String funcionarioNome) {
        return vendaRepository.findByFuncionarioNome(funcionarioNome);
    }

    @Transactional(readOnly = true)
    public List<Venda> listarAs10MaisCaras() {
        return vendaRepository.findTop10ByOrderByValorTotalDesc();
    }
}
