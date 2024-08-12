package app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entity.Funcionario;
import app.repository.FuncionarioRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public String save(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return "Funcionario criado com sucesso!";
    }

    @Transactional
    public String update(Funcionario funcionario, Long id) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.save(funcionario);
            return "Funcionario atualizado com sucesso!";
        } else {
            return "Funcionario não encontrado.";
        }
    }

    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }
}
