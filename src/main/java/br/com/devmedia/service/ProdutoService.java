package br.com.devmedia.service;

import java.util.List;

import br.com.devmedia.domain.Produto;

public interface ProdutoService {

    Produto salvar(Produto produto);
    List<Produto> recuperar();
    Produto recuperarPorId(long id);
    void atualizar(Produto produto);
    void excluir(long id);

}
