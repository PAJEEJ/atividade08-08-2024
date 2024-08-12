

package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
import app.entity.Produto;
import app.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	

	public String save (Produto produto) {
		this.produtoRepository.save(produto);
		return "Produtocadastrado com sucesso";
	}
	
	public String update (Produto Produto, long id) {
		Produto.setId(id);
		this.produtoRepository.save(Produto);
		return "Atualizado com sucesso";
	}
	
	public Produto findById (long id) {
		
		Optional<Produto> optional = this.produtoRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	public List<Produto> findAll () {
		
		return this.produtoRepository.findAll();
		
	}
	
	public String delete (long id) {
		this.produtoRepository.deleteById(id);
		return "Veículo deletado com sucesso!";
	}
	
	
	public List<Funcionario> findByNome(String nome){
		return this.produtoRepository.findByNomeStartingWith(nome);
	}
	
	public List<Funcionario> findByAcimaAno(int idade) {
        return this.produtoRepository.findByIdadeGreaterThan(idade);
	

}}	
