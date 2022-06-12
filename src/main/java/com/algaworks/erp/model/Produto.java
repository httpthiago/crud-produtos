package com.algaworks.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSku;
	
	@NotEmpty
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@Column(nullable = false)
	private Double valor;
	
	@NotNull
	@Column(nullable = false)
	private Integer estoque;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	public Long getIdSku() {
		return idSku;
	}

	public void setIdSku(Long idSku) {
		this.idSku = idSku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public String getValor() {
//		BigDecimal novoValor = new BigDecimal(valor).setScale(2, RoundingMode.HALF_DOWN);
//		String resultado = "R$ " + novoValor.toString().replace('.', ',');
//		return resultado;
//	}
//	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSku);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(idSku, other.idSku);
	}

	@Override
	public String toString() {
		return "Produto [idSku=" + idSku + "]";
	}
	
	
}
