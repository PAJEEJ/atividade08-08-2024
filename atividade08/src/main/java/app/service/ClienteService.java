package app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entity.Cliente;
import app.repository.ClienteRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public String save(Cliente cliente) {
        clienteRepository.save(cliente);
        return "Cliente criado com sucesso!";
    }

    @Transactional
    public String update(Cliente cliente, Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.save(cliente);
            return "Cliente atualizado com sucesso!";
        } else {
            return "Cliente não encontrado.";
        }
    }

    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Cliente> listarPorIdade(int startAge, int endAge) {
        return clienteRepository.findByIdadeBetween(startAge, endAge);
    }
}
