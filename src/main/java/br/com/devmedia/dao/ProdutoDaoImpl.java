package br.com.devmedia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.devmedia.domain.Playlist;
import br.com.devmedia.domain.Produto;

@Repository
public class ProdutoDaoImpl implements ProdutoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Produto salvar(Produto produto) {
        em.persist(produto);
        return produto;
    }

    @Override
    public List<Produto> recuperar() {
        return em.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    @Override
    public Produto recuperarPorID(long id) {
        return em.find(Produto.class, id);
    }

    @Override
    public void atualizar(Produto produto) {
        em.merge(produto);
    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(Produto.class, id));
    }
}
