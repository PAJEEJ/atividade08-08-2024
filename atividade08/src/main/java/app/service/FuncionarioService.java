

package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	

	public String save (Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
		return "funcionariocadastrado com sucesso";
	}
	
	public String update (Funcionario funcionario, long id) {
		funcionario.setId(id);
		this.funcionarioRepository.save(funcionario);
		return "Atualizado com sucesso";
	}
	
	public Funcionario findById (long id) {
		
		Optional<Funcionario> optional = this.funcionarioRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	public List<Funcionario> findAll () {
		
		return this.funcionarioRepository.findAll();
		
	}
	
	public String delete (long id) {
		this.funcionarioRepository.deleteById(id);
		return "Veículo deletado com sucesso!";
	}
	
	
	public List<Funcionario> findByNome(String nome){
		return this.funcionarioRepository.findByNomeStartingWith(nome);
	}
	
	public List<Funcionario> findByAcimaAno(int idade) {
        return this.funcionarioRepository.findByIdadeGreaterThan(idade);
	
	
}}