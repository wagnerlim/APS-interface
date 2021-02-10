package br.com.UsuarioController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ConnectionFactory.ConnectionFactory;
import br.com.aps.DAO.AlunoDAO;
import br.com.modelo.Alunos;

public class AlunosController {

	private AlunoDAO AlunosDAO;

	public AlunosController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.AlunosDAO = new AlunoDAO(connection);
	}

	public List<Alunos> listar() {
		return this.AlunosDAO.listar();
	}

	public List<Alunos> listarComCurso() {
		return this.AlunosDAO.listarComCurso();
	}

	public List<String> listarCursos() {
		return this.AlunosDAO.listarCursos();
	}
	
	public List<String> listarSituacao() {
		return this.AlunosDAO.listarSituacao();
	}

	public void Deletar(String ra) {
		this.AlunosDAO.Deletar(ra);
	}
	
	public void Alterar(String nome, String data_nascimento, int Cursoid, int Situacaoid,String ra) {
		this.AlunosDAO.alterar(nome, data_nascimento, Cursoid, Situacaoid, ra);
		System.out.println("Alterações Aplicadas!");
	}
	
	public int ConversorCursoNomeId(String CursoNome) throws SQLException {
		
		return this.AlunosDAO.converterCursoEmInt(CursoNome);
	}
	
	public int ConversosSituacaoId(String Situacaonome) throws SQLException {
		
		return this.AlunosDAO.converterSituacaoInt(Situacaonome);
	}

}
