package Testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.ConnectionFactory.ConnectionFactory;
import br.com.aps.DAO.UsuarioDAO;


public class TesteConsulta {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		
			
		UsuarioDAO teste = new UsuarioDAO(connection);
		
		
		System.out.println(teste.autenticadorUsuarioeSenha("Errado","1234"));
	}
}
