package br.com.einsteinlimeira.aulaswing.model;

/**
 * Classe que representa usuários do sistema. 
 * 
 * @author pedrobrigatto
 */
public class Usuario {
	
	private String username;
	private String senha;
	
	public Usuario (String username, String senha) {
		this.username = username;
		this.senha = senha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
