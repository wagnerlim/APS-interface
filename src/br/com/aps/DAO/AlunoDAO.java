package br.com.aps.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.modelo.Alunos;

public class AlunoDAO {
	
	private Connection connection;
	
	public AlunoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void Salvar (Alunos aluno) {
		try {
			String sql = "INSERT INTO ALUNOS (RA, NOME,Data_Nascimento) VALUES (?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				pstm.setString(1, aluno.getRA());
					pstm.setString(2, aluno.getNome());
						pstm.setString(3, aluno.getDataNascimento());
				

				pstm.execute();
				System.out.println("Salvo com sucesso!");
				
			}
		} catch (SQLException e) {
			throw new RuntimeException();
			
		}
	}
	
	
	
	public void SalvarComCurso (Alunos aluno) {
		try {
			String sql = "INSERT INTO ALUNOS (RA, NOME,Data_Nascimento,CursoID) VALUES (?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				pstm.setString(1, aluno.getRA());
					pstm.setString(2, aluno.getNome());
						pstm.setString(3, aluno.getDataNascimento());
							pstm.setInt(4, aluno.getCursoId());
				

				pstm.execute();
				System.out.println("Salvo com sucesso!");
				
			}
		} catch (SQLException e) {
			throw new RuntimeException();
			
		}
	}
	
	public List<Alunos> listar(){
		
		try {
			List<Alunos> Alunos = new ArrayList<Alunos>();
			String sql = "SELECT RA, NOME,Data_Nascimento  FROM ALUNOS";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				trasformarResultSetEmAlunos(Alunos, pstm);
			}
			return Alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
			
	}
	
	public List<Alunos> listarComCurso(){
		
		try {
			List<Alunos> Alunos = new ArrayList<Alunos>();
			String sql = "SELECT RA, NOME, Data_Nascimento, CursoID, SituaçãoID  FROM ALUNOS";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				trasformarResultSetEmAlunosComCurso(Alunos, pstm);
			}
			return Alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
			
	}
	
	
	private void trasformarResultSetEmAlunos(List<Alunos> aluno, PreparedStatement pstm)  {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Alunos produto = new Alunos(rst.getString(1), rst.getString(2), rst.getString(3));

				aluno.add(produto);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
			}
	}
	
	
	
	private void trasformarResultSetEmAlunosComCurso(List<Alunos> aluno, PreparedStatement pstm)  {
		try (ResultSet rst = pstm.getResultSet()) {
				
				
			while (rst.next()) {
				Alunos produto = new Alunos(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4),rst.getInt(5));
				transformadorCursoNome(produto, rst);
				transformadorSituacaoNome(produto, rst);
				
				aluno.add(produto);
			}
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
			}
	}
	
	private void transformadorCursoNome (Alunos aluno, ResultSet rst) throws SQLException {
		
		int id = rst.getInt(4);
		
		String sql = "SELECT nome from curso where Cursoid = " + id;
		try(PreparedStatement injector = connection.prepareStatement(sql)){
			injector.execute();
			ResultSet resultado = injector.executeQuery();
			resultado.next();
			aluno.setCursonome(resultado.getString(1));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void transformadorSituacaoNome(Alunos aluno ,ResultSet rst) throws SQLException {
		
		int id = rst.getInt(5);
		
		String sql = "SELECT Descrição from Situação where SituaçãoID = " + id;
		try(PreparedStatement injector = connection.prepareStatement(sql)){
			injector.execute();
			ResultSet resultado = injector.executeQuery();
			resultado.next();
			aluno.setSituacaoNome(resultado.getString(1));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> listarCursos(){
		try{
			List<String> categorias = new ArrayList<>();
			
			String sql = "SELECT NOME FROM Curso";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						String curso = rst.getString(1);

						categorias.add(curso);
					}
				}
			}
			return categorias;
		
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
}
	
	public List<String> listarSituacao(){
		try{
			List<String> categorias = new ArrayList<>();
			
			String sql = "SELECT Descrição FROM Situação";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						String curso = rst.getString(1);

						categorias.add(curso);
					}
				}
			}
			return categorias;
		
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
}
	
	public void Deletar (String ra) {
		try {
			String sql = " Delete from alunos where RA = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				pstm.setString(1, ra);
				pstm.execute();
				System.out.println("Deletado com sucesso!");
				
			//	return true;
			}
		} catch (SQLException e) {
			
			throw new RuntimeException();
			
		}
	}
	
	public void alterar(String nome, String data_nascimento, int Cursoid, int Situacaoid,String ra){
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE ALUNOS P SET P.NOME = ?, P.DATA_NASCIMENTO = ?, P.CURSOID = ?, P.SITUAÇÃOID = ? WHERE RA = ?")) {
			stm.setString(1, nome);
			stm.setString(2, data_nascimento);
			stm.setInt(3, Cursoid);
			stm.setInt(4, Situacaoid);
			stm.setString(5, ra);
			stm.execute();
		}catch (SQLException e) {
			throw new RuntimeException(e);
			}
	}
	
	public int converterCursoEmInt(String CursoNome) throws SQLException  {

		String sql = "select cursoID from curso where nome = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, CursoNome);
			pstm.execute();

			ResultSet resultado = pstm.executeQuery();
			resultado.next();

			return resultado.getInt(1);
		}

	}
	
	public int converterSituacaoInt(String CursoNome) throws SQLException  {

		String sql = "select SituaçãoID from Situação where Descrição = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, CursoNome);
			pstm.execute();

			ResultSet resultado = pstm.executeQuery();
			resultado.next();

			return resultado.getInt(1);
		}

	}
	
	
	
}



