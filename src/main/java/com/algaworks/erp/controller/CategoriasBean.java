package com.algaworks.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.algaworks.erp.model.Categoria;
import com.algaworks.erp.repository.Categorias;
import com.algaworks.erp.service.CategoriaService;
import com.algaworks.erp.util.FacesMessages;

@Named
@ViewScoped
public class CategoriasBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Categorias categorias;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private CategoriaService service;
	
	private List<Categoria> todasCategorias;
	private Categoria categoria = new Categoria();

	public void prepararNovoCadastro() {
		categoria = new Categoria();
	}
	
	public void consultarCategorias() {
		todasCategorias = categorias.todas();
	}
	
	public void cadastrarCategoria() {
		service.salvar(categoria);
		consultarCategorias();
		messages.info("Categoria cadastrada com sucesso!");
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:categoria-table"));
	}
	
	public void removerCategoria() {
		service.excluir(categoria);
		consultarCategorias();
		messages.info("Categoria removida com sucesso");
	}
	
	public List<Categoria> getTodasCategorias() {
		return todasCategorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	
	
	

}
