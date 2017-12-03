package br.com.vitafarma.mobile.domain;

import java.io.Serializable;

public class Produto extends MyEntity implements Serializable {
	private static final long serialVersionUID = 1065201926314615380L;

	private Integer id;
	private String nome;
	private Double preco;

	public Produto() {
		this(null, null, null);
	}

	public Produto(Integer id, String nome, Double preco) {
		this.setId(id);
		this.setNome(nome);
		this.setPreco(preco);
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "\nId: " + this.getId() + "\nNome: " + this.getNome()
				+ "\nPreco: " + this.getPreco();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Produto)) {
			return false;
		}

		Produto other = (Produto) obj;

		if (this.getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!this.getId().equals(other.getId())) {
			return false;
		}

		return true;
	}
}
