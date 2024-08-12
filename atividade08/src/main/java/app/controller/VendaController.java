package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Venda;
import app.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> criarVenda(@RequestBody Venda venda) {
        return ResponseEntity.ok(vendaService.salvarVenda(venda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> atualizarVenda(@PathVariable Long id, @RequestBody Venda venda) {
        venda.setId(id);
        return ResponseEntity.ok(vendaService.atualizarVenda(venda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long id) {
        vendaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarVendaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Venda>> listarVendas() {
        return ResponseEntity.ok(vendaService.listarTodos());
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Venda>> listarVendasPorCliente(@RequestParam String clienteNome) {
        return ResponseEntity.ok(vendaService.buscarPorClienteNome(clienteNome));
    }

    @GetMapping("/funcionario")
    public ResponseEntity<List<Venda>> listarVendasPorFuncionario(@RequestParam String funcionarioNome) {
        return ResponseEntity.ok(vendaService.buscarPorFuncionarioNome(funcionarioNome));
    }

    @GetMapping("/top10")
    public ResponseEntity<List<Venda>> listarTop10Vendas() {
        return ResponseEntity.ok(vendaService.listarAs10MaisCaras());
    }
}
