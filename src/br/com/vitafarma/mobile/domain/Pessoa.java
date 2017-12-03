package br.com.vitafarma.mobile.domain;

import java.io.Serializable;

public abstract class Pessoa extends MyEntity implements Serializable {
	private static final long serialVersionUID = -2647800383900837579L;

	private Integer id;
	private String nome;
	private String cpf;
	private String email;

	public Pessoa() {
		this(null, null, null, null);
	}

	public Pessoa(Integer id, String nome, String cpf, String email) {
		this.setId(id);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
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

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return ("Id: " + this.getId() + "\nNome: " + this.getNome()
				+ "\nCpf: " + this.getCpf()
				+ "\nEmail: " + this.getEmail());
	}
}
