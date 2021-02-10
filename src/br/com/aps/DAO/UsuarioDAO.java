package br.com.aps.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class UsuarioDAO {
	
	private Connection connection;
	
	public UsuarioDAO(Connection conexao) {
		this.connection = conexao;
	}
	
	public void salvar(String login,String senha) {
		
		try {
		String sql = "INSERT INTO USUARIOS (NOME_USUARIO, SENHA) VALUES (?, ?)";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setString(1, login);
				pstm.setString(2, senha);
					pstm.execute();
					System.out.println("Usuario Salvo Com sucesso!");
					JOptionPane.showMessageDialog(null, "Usuario " + login + " salvo com sucesso!", "Operação concluida com sucesso ", JOptionPane.INFORMATION_MESSAGE);
					
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	public boolean autenticadorUsuarioeSenha(String usuario, String senha) {
		try {
			
		
		String sql = "select nome_usuario from usuarios where nome_usuario = ? and senha = ?";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setString(1, usuario);
			pstm.setString(2, senha);
			pstm.execute();
		
		ResultSet resultado = pstm.executeQuery();
		boolean existe = resultado.next();
		
		System.out.println(existe);
		return existe;
		}
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean autenticadorUsuario(String usuario ) {
		try {
			
		
		String sql = "select nome_usuario from usuarios where nome_usuario = ?";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setString(1, usuario);
			pstm.execute();
		
		ResultSet resultado = pstm.executeQuery();
		boolean existe = resultado.next();
		
		System.out.println(existe);
		return existe;
		}
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Deletar (String Usuario) {
		if(autenticadorUsuario(Usuario) == true) {
			try {
				String sql = " Delete from usuarios where NOME_USUARIO = ?";

				try (PreparedStatement pstm = connection.prepareStatement(sql)) {

					pstm.setString(1, Usuario);
					pstm.execute();
					System.out.println("Deletado com sucesso!");
					JOptionPane.showMessageDialog(null, "Usuario " + Usuario + " deletado com sucesso!", "Operação concluida", JOptionPane.INFORMATION_MESSAGE);
				//	return true;
				}
			} catch (SQLException e) {
				
				throw new RuntimeException();
				
			}
		}else {
			JOptionPane.showMessageDialog(null, "Usuario " + Usuario + " não encontrado ", "nenhum usuario foi encontrado", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
}
