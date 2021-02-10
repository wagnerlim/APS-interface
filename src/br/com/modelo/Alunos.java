package br.com.modelo;

public class Alunos {
	
	private String RA;
	private String nome;
	private String dataNascimento;
	private int CursoId;
	private String Cursonome;
	private int Situacao;
	private String SituacaoNome;
	
	public Alunos(String ra, String nome ,String nascimento) {
		
		this.RA = ra;
		this.nome = nome;
		this.dataNascimento = nascimento;
	}
	
	public Alunos(String ra, String nome ,String nascimento,int Curso) {
		
		this.RA = ra;
		this.nome = nome;
		this.dataNascimento = nascimento;
		this.CursoId = Curso;
	}
	
	public Alunos(String ra, String nome ,String nascimento,String Curso) {
		
		this.RA = ra;
		this.nome = nome;
		this.dataNascimento = nascimento;
		this.Cursonome = Curso;
		
	}
	
public Alunos(String ra, String nome ,String nascimento,int Curso,int Situacao) {
		
		this.RA = ra;
		this.nome = nome;
		this.dataNascimento = nascimento;
		this.CursoId = Curso;
		this.Situacao = Situacao;
	}
	
	public String getRA() {
		return RA;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}

	public int getCursoId() {
		return CursoId;
	}
	
	public int getSituacaoo() {
		return Situacao;
	}
	
	public void setCursoId(int cursoId) {
		CursoId = cursoId;
	}
	
	public String getCursonome() {
		return Cursonome;
	}
	
	public void setCursonome(String cursonome) {
		Cursonome = cursonome;
	}
	
	public void setSituacaoNome(String situacaoNome) {
		SituacaoNome = situacaoNome;
	}
	
	public String getSituacaoNome() {
		return SituacaoNome;
	}
	
}
