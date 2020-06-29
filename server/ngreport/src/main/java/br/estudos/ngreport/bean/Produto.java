package br.estudos.ngreport.bean;

import java.math.BigDecimal;

public class Produto {

	private Long id;
	private String nome;
	private BigDecimal preco;
	private String tipoProduto;
	private String status;
	

	public Produto() {
		super();
	}
	
	public Produto(Long id, String nome, BigDecimal preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", tipoProduto=" + tipoProduto
				+ ", status=" + status + "]";
	}
}
