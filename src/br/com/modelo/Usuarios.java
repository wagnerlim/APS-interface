package br.com.modelo;

public class Usuarios {
	
	private String Usuario;
	private String Senha;
	
	public Usuarios(String login,String senha) {
		this.Usuario = login;
		this.Senha = senha;
	}
	
	
	public String getUsuario() {
		return Usuario;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	
}
