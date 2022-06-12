package com.algaworks.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.erp.model.Categoria;
import com.algaworks.erp.repository.Categorias;
import com.algaworks.erp.util.Transacional;

public class CategoriaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Categorias categorias;
	
	@Transacional
	public void salvar(Categoria categoria) {
		categorias.guardar(categoria);
	}
	
	@Transacional
	public void excluir(Categoria categoria) {
		categorias.remover(categoria);
	}

}