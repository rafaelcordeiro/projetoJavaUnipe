package br.com.devmedia.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.devmedia.service.ProdutoService;
import br.com.devmedia.domain.Produto;
import br.com.devmedia.exception.*;
/**
 */
@RestController
@RequestMapping("/api/v1.0")
public class ProdutoApi {

	@Autowired
	ProdutoService produtoDao;

	@GetMapping("/produto")
	public List<Produto> getAllProduto() 
	{
		return produtoDao.recuperar();
	}

	@GetMapping("/produto/{id}")
	public Produto recuperarPorID(@PathVariable(value = "id") Long id) {
		return produtoDao.recuperarPorId(id);
				//.orElseThrow(() -> new ProdutoNotFoundException("Produto", "id", id));
	}

	@PostMapping("/produto")
	public Produto criarProduto(@Valid @RequestBody Produto produto) {
		return produtoDao.salvar(produto);
	}

	@PutMapping("/produto/{id}")
	public Produto atualizarProduto(@PathVariable(value = "id") Long id, @Valid @RequestBody Produto produto) {

		Produto produtoNovo = produtoDao.recuperarPorId(id);
				//.orElseThrow(() -> new ProdutoNotFoundException("Produto", "id", id));

		produtoNovo.setNome(produtoNovo.getNome());
		produtoNovo.setTipo(produtoNovo.getTipo());

		Produto atualizarProduto = produtoDao.salvar(produtoNovo);
		return atualizarProduto;
	}

	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Produto> deleteProduto(@PathVariable(value = "id") Long id) {

		Produto produto = produtoDao.recuperarPorId(id);
				//.orElseThrow(() -> new ProdutoNotFoundException("Produto", "id", id));

		produtoDao.excluir(produto.getId());
		return ResponseEntity.ok().build();
	}
}
