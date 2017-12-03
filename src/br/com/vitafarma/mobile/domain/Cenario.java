package br.com.vitafarma.mobile.domain;

import java.io.Serializable;
import java.util.Date;

public class Cenario extends MyEntity implements Serializable {
	private static final long serialVersionUID = -8610380359760552949L;

	private Integer id;
	private Usuario criadoPor;
	private Usuario atualizadoPor;
	private String nome;
	private Date dataCriacao;
	private Date dataAtualizacao;

	public Cenario() {
		this(null, null, null, null, null, null);
	}

	public Cenario(Integer id, Usuario criadoPor, Usuario atualizadoPor,
			String nome, Date dataCriacao, Date dataAtualizacao) {
		this.setId(id);
		this.setCriadoPor(criadoPor);
		this.setAtualizadoPor(atualizadoPor);
		this.setNome(nome);
		this.setDataCriacao(dataCriacao);
		this.setDataAtualizacao(dataAtualizacao);
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getCriadoPor() {
		return this.criadoPor;
	}

	public void setCriadoPor(Usuario criadoPor) {
		this.criadoPor = criadoPor;
	}

	public Usuario getAtualizadoPor() {
		return this.atualizadoPor;
	}

	public void setAtualizadoPor(Usuario atualizadoPor) {
		this.atualizadoPor = atualizadoPor;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return this.dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Cenario)) {
			return false;
		}

		Cenario other = (Cenario) obj;

		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}

		return true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Id: ").append(getId()).append(", ");
		sb.append("CriadoPor: ").append(getCriadoPor()).append(", ");
		sb.append("AtualizadoPor: ").append(getAtualizadoPor()).append(", ");
		sb.append("Nome: ").append(getNome()).append(", ");
		sb.append("DataCriacao: ").append(getDataCriacao()).append(", ");
		sb.append("DataAtualizacao: ").append(getDataAtualizacao())
				.append(", ");

		return sb.toString();
	}

	public void persist() {
		// TODO Auto-generated method stub
		return;
	}
}
