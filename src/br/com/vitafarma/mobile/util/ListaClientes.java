package br.com.vitafarma.mobile.util;

import br.com.vitafarma.mobile.domain.Cliente;

public class ListaClientes {

	private Cliente cliente;
	private Cliente prox;
	private Cliente ant;

	public ListaClientes() {
		this.cliente = new Cliente();
		this.prox = null;
		this.ant = null;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getProx() {
		return this.prox;
	}

	public void setProx(Cliente prox) {
		this.prox = prox;
	}

	public Cliente getAnt() {
		return this.ant;
	}

	public void setAnt(Cliente ant) {
		this.ant = ant;
	}
}
