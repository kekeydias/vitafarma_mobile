package br.com.vitafarma.mobile.domain;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable {
	private static final long serialVersionUID = 3587248233853027147L;

	private String matricula;

	public Aluno() {
		this(null, null, null, null, null);
	}

	public Aluno(Integer id, String nome, String cpf, String email,
			String matricula) {
		super(id, nome, cpf, email);
		this.setMatricula(matricula);
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Aluno)) {
			return false;
		}

		Aluno other = (Aluno) obj;

		if (this.getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!this.getId().equals(other.getId())) {
			return false;
		}

		return true;
	}

	public String toString() {
		return (super.toString() + "\nMatricula: " + this.getMatricula());
	}

	public void persist() {
		// TODO Auto-generated method stub
		return;
	}
}
