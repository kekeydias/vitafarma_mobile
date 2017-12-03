package br.com.vitafarma.mobile.domain;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
	private static final long serialVersionUID = 7117601563082094822L;

	private String endereco;

	public Cliente() {
		this(null, null, null, null, null);
	}

	public Cliente(Integer id, String nome, String cpf, String email,
			String endereco) {
		super(id, nome, cpf, email);
		this.setEndereco(endereco);
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return super.toString() + "\nEndereco: " + this.getEndereco();
	}
}
