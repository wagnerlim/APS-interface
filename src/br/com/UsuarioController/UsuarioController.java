package br.com.UsuarioController;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.ConnectionFactory.ConnectionFactory;
import br.com.aps.DAO.UsuarioDAO;

public class UsuarioController {

	private UsuarioDAO usuarioDAO;

	public UsuarioController() {
		Connection conexao = new ConnectionFactory().recuperarConexao();
		this.usuarioDAO = new UsuarioDAO(conexao);
	}

	public boolean UsuarioAutenticar(String usuario, String senha) {
		if (this.usuarioDAO.autenticadorUsuarioeSenha(usuario, senha) == true) {
			System.out.println("Usuario Autenticado");
			return true;
		} else {
			System.out.println("Falha na autenticação");

			return false;
		}
	}

	public boolean Salvar(String login, String senha) {
		if (this.usuarioDAO.autenticadorUsuario(login) == true) {
			System.err.println("Esse usuário já existe!");
			JOptionPane.showMessageDialog(null, "Usuário já existente!", "Error 404", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			this.usuarioDAO.salvar(login, senha);
			return true;
		}
	}

	public void Deletar(String usuario) {
		this.usuarioDAO.Deletar(usuario);
		
	}
	
}
