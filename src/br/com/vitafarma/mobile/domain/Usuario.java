package br.com.vitafarma.mobile.domain;

import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable {
	private static final long serialVersionUID = 2505879126546359228L;

	private String username;
	private String password;
	private Boolean enabled;
	private Authority authority;

	public Usuario() {
		this(null, null, null, null);
	}

	public Usuario(String username, String password, Boolean enabled,
			Authority authority) {
		this.setUsername(username);
		this.setPassword(password);
		this.setEnabled(enabled);
		this.setAuthority(authority);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Aluno)) {
			return false;
		}

		Usuario other = (Usuario) obj;

		if (this.getUsername() == null) {
			if (other.getUsername() != null) {
				return false;
			}
		} else if (!this.getUsername().equals(other.getUsername())) {
			return false;
		}

		return true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Nome: ").append(getNome()).append(", ");
		sb.append("Email: ").append(getEmail()).append(", ");
		sb.append("Username: ").append(getUsername()).append(", ");
		sb.append("Password: ").append(getPassword()).append(", ");
		sb.append("Enabled: ").append(getEnabled()).append(", ");
		sb.append("Authority: ").append(getAuthority());

		return sb.toString();
	}

	public void persist() {
		// TODO Auto-generated method stub
		return;
	}
}
