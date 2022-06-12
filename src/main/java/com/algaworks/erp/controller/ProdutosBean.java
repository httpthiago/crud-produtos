package com.algaworks.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.algaworks.erp.model.Categoria;
import com.algaworks.erp.model.Produto;
import com.algaworks.erp.repository.Categorias;
import com.algaworks.erp.repository.Produtos;
import com.algaworks.erp.service.ProdutoService;
import com.algaworks.erp.util.FacesMessages;

@Named
@ViewScoped
public class ProdutosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	@Inject
	private Categorias categorias;

	@Inject
	private ProdutoService produtoService;

	@Inject
	private FacesMessages messages;

	private Produto produto = new Produto();
	private List<Produto> todosProdutos;
	private String nomePesquisa;
	private Long idSku;

	public void prepararNovoCadastro() {
		produto = new Produto();
	}

	public void consultar() {
		todosProdutos = produtos.todos();
	}
	
	public void pesquisar() {
		todosProdutos = produtos.pesquisar(nomePesquisa, idSku);
	}

	public void cadastrarProduto() {
		produtoService.salvar(produto);
		consultar();
		messages.info("Produto cadastrado com sucesso: " + produto.getNome());
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:produto-table"));
	}

	public void removerProduto() {
		produtoService.excluir(produto);
		consultar();
		messages.info("Produto excluído com sucesso: " + produto.getNome());
	}

	public List<Categoria> getTodasCategorias() {
		return categorias.todas();
	}

	public List<Produto> getTodosProdutos() {
		return todosProdutos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public Long getIdSku() {
		return idSku;
	}

	public void setIdSku(Long idSku) {
		this.idSku = idSku;
	}	
}
