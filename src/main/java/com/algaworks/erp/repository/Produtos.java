package com.algaworks.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.erp.model.Produto;

public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Produtos() {
		
	}
	
	public Produtos(EntityManager manager) {
		this.manager = manager;
	}

	public Produto porId(Long id) {
		return manager.find(Produto.class, id);
	}

	public List<Produto> todos() {
		return manager.createQuery("from Produto", Produto.class).getResultList();
	}

	public List<Produto> pesquisar(String nome, Long idSku) {
		String jpql = "from Produto where (nome like :nome or nome is null) or (idSku like :idSku or idSku is null)";

		TypedQuery<Produto> query = manager.createQuery(jpql, Produto.class);

		query.setParameter("nome", "%" + nome + "%");
		query.setParameter("idSku", idSku);

		return query.getResultList();
	}

	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}

	public void remover(Produto produto) {
		produto = porId(produto.getIdSku());
		manager.remove(produto);
	}
}
