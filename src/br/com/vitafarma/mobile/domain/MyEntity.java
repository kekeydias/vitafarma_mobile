package br.com.vitafarma.mobile.domain;

import java.io.Serializable;

public abstract class MyEntity implements Serializable {
	private static final long serialVersionUID = 2945351132114241329L;

	public static final String ALUNOS = "ALUNOS";
	public static final String AUTHORITIES = "AUTHORITIES";
	public static final String CENARIOS = "CENARIOS";
	public static final String CLIENTES = "CLIENTES";
	public static final String FUNCIONARIOS = "FUNCIONARIOS";
	public static final String PESSOAS = "PESSOAS";
	public static final String PRODUTOS = "PRODUTOS";
	public static final String USUARIOS = "USUARIOS";

	public MyEntity() {
		super();
	}
}
