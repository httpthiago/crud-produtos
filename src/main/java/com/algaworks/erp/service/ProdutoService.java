package com.algaworks.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.erp.model.Produto;

import com.algaworks.erp.repository.Produtos;
import com.algaworks.erp.util.Transacional;

public class ProdutoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	@Transacional
	public void salvar(Produto produto) {
		produtos.guardar(produto);
	}

	@Transacional
	public void excluir(Produto produto) {
		produtos.remover(produto);
	}
}
