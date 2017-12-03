package br.com.vitafarma.mobile.domain;

import java.io.Serializable;
import java.util.Date;

import br.com.vitafarma.mobile.util.FormatUtils;

public class Funcionario extends Pessoa implements Serializable {
	private static final long serialVersionUID = -5157773515469841366L;

	private Date dataAdimissao;
	private Date dataDemissao;
	private Double salario;

	public Funcionario() {
		this(null, null, null, null, null, null, null);
	}

	public Funcionario(Integer id, String nome, String cpf, String email,
			Date dataAdimissao, Date dataDemissao, Double salario) {
		super(id, nome, cpf, email);
		this.setDataAdimissao(dataAdimissao);
		this.setDataDemissao(dataDemissao);
		this.setSalario(salario);
	}

	public Date getDataAdimissao() {
		return this.dataAdimissao;
	}

	public void setDataAdimissao(Date dataAdimissao) {
		this.dataAdimissao = dataAdimissao;
	}

	public Date getDataDemissao() {
		return this.dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Double getSalario() {
		return this.salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Funcionario)) {
			return false;
		}

		Funcionario other = (Funcionario) obj;

		if (this.getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!this.getId().equals(other.getId())) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {

		String demissao = "";
		if (this.getDataDemissao() != null) {
			demissao = "\nData de Demissao: "
					+ FormatUtils.getDateString(this.getDataDemissao());
		}

		return super.toString() + "\nSalario: "
				+ String.format("%.2f", this.getSalario())
				+ "\nData de Adimissao: "
				+ FormatUtils.getDateString(this.getDataAdimissao()) + demissao;
	}

	public void persist() {
		// TODO Auto-generated method stub
		return;
	}
}
