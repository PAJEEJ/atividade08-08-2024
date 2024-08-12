package app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entity.Produto;
import app.repository.ProdutoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public String save(Produto produto) {
        produtoRepository.save(produto);
        return "Produto criado com sucesso!";
    }

    @Transactional
    public String update(Produto produto, Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.save(produto);
            return "Produto atualizado com sucesso!";
        } else {
            return "Produto não encontrado.";
        }
    }

    @Transactional
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Produto> listarOs10MaisCaros() {
        return produtoRepository.findTop10ByOrderByPrecoDesc();
    }
}
