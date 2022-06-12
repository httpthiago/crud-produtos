package com.algaworks.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.algaworks.erp.model.Categoria;

public class Categorias implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Categoria porId(Long id) {
		return manager.find(Categoria.class, id);
	}
	
	public List<Categoria> todas() {
		return manager.createQuery("from Categoria", Categoria.class).getResultList();
	}
	
	public Categoria guardar(Categoria categoria) {
		return manager.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		categoria = porId(categoria.getId());
		manager.remove(categoria);
	}
}
