package br.com.vitafarma.mobile.domain;

import java.io.Serializable;

public class Authority extends MyEntity implements Serializable {
	private static final long serialVersionUID = 8739246006672184100L;

	private String username;
	private String authority;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Username: ").append(getUsername()).append(", ");
		sb.append("Authority: ").append(getAuthority()).append(", ");

		return sb.toString();
	}

	public void persist() {
		// TODO Auto-generated method stub
		return;
	}
}
