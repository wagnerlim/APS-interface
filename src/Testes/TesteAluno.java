package Testes;

import java.sql.Connection;

import br.com.ConnectionFactory.ConnectionFactory;
import br.com.aps.DAO.AlunoDAO;
import br.com.modelo.Alunos;

public class TesteAluno {
	
	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Alunos wagner = new Alunos("756321", "Jose", "05/03/1995");
		AlunoDAO teste = new AlunoDAO(connection);
		
		System.out.println(wagner.getRA());
		System.out.println(wagner.getNome());
		System.out.println(wagner.getDataNascimento());
		
		teste.Salvar(wagner);
	}

}
