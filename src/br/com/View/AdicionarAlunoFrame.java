package br.com.View;

import java.awt.EventQueue;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.ConnectionFactory.ConnectionFactory;
import br.com.UsuarioController.AlunosController;

import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdicionarAlunoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel adicionarAlunoFrame;
	private JTextField nomeAlunoTxt;
	private JTextField dataNascimentoTxt;
	private AlunosController alunoController;
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	private Connection connection = connectionFactory.recuperarConexao();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarAlunoFrame frame = new AdicionarAlunoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdicionarAlunoFrame() {

		this.alunoController = new AlunosController();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		adicionarAlunoFrame = new JPanel();
		try {
			adicionarAlunoFrame = new FundoBg("C:\\Users\\wagne\\Desktop\\Aps interface\\FundoAdicionarAluno.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		adicionarAlunoFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(adicionarAlunoFrame);
		adicionarAlunoFrame.setLayout(null);

		nomeAlunoTxt = new JTextField();
		nomeAlunoTxt.setBounds(10, 64, 180, 20);
		adicionarAlunoFrame.add(nomeAlunoTxt);
		nomeAlunoTxt.setColumns(10);

		dataNascimentoTxt = new JTextField();
		dataNascimentoTxt.setBounds(10, 130, 180, 20);
		adicionarAlunoFrame.add(dataNascimentoTxt);
		dataNascimentoTxt.setColumns(10);

		JComboBox<String> CursoBox = new JComboBox<String>();
		CursoBox.setBounds(250, 63, 147, 22);
		adicionarAlunoFrame.add(CursoBox);
		CursoBox.addItem("Selecione");
		List<String> cursos = this.cursosListar();
		for (String string : cursos) {
			CursoBox.addItem(string);
		}

		JLabel nomeLabel = new JLabel("Nome do Aluno");
		nomeLabel.setBounds(10, 50, 127, 14);
		adicionarAlunoFrame.add(nomeLabel);

		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setBounds(10, 114, 156, 14);
		adicionarAlunoFrame.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(250, 129, 89, 23);
		adicionarAlunoFrame.add(btnNewButton);
		
//		Evento botão Adicionar
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(CursoBox.getSelectedItem().equals("Selecione") == true) {
					JOptionPane.showMessageDialog(null, "Selecione um curso ", "Nenhum curso foi selecionado ",
							JOptionPane.ERROR_MESSAGE);
				}
				
				else if (autenticadorData() == true) {
					
					String CursoNome = String.valueOf(CursoBox.getSelectedItem());
					Salvar(CursoNome);
					JOptionPane.showMessageDialog(null, "Aluno(a) " + nomeAlunoTxt.getText() + " foi adicionado com sucesso!", "Operação concluida",
							JOptionPane.INFORMATION_MESSAGE);
					
				
					
				} else {
					JOptionPane.showMessageDialog(null, "O formato da data deve ser DD/MM/AAAA", "Erro de formato",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

	private List<String> cursosListar() {

		return alunoController.listarCursos();
	}

	public void Salvar(String box) {
		Random gerador = new Random();

		int Random = gerador.nextInt(999999);
		
//		System.out.println(Random);
		autenticadorRa(Random);

		String raAutenticado = "" + Random;

		try {
			String sql = "INSERT INTO ALUNOS (RA, NOME,Data_Nascimento, CursoId, SituaçãoID) VALUES (?, ?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				pstm.setString(1, raAutenticado);
				pstm.setString(2, nomeAlunoTxt.getText());
				pstm.setString(3, dataNascimentoTxt.getText());
				pstm.setInt(4, converterCursoEmInt(box));
				pstm.setInt(5, 1);

				pstm.execute();
				
				limparCampos();
				System.out.println("Salvo com sucesso!");
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public int converterCursoEmInt(String CursoNome) throws SQLException {

		return this.alunoController.ConversorCursoNomeId(CursoNome);

	}

	public int NumeroAleatorio() {

		Random gerador = new Random();

		int Random = gerador.nextInt(999999);

		return Random;
	}

	public String ConverterRaEmString(int valor) {

		String StringRA = "" + valor;

		return StringRA;

	}

	private boolean autenticadorRa(int Random) {
		Random gerador = new Random();

		while (ResultSetBoolean(Random) == true) {
			System.out.println("Esse RA já existe");
			Random = gerador.nextInt();
			System.out.println("Vou usar esse novo" + Random);
		}
		Boolean existe = true;

		return existe;

	}

	private boolean ResultSetBoolean(int Random) {

		Random gerador = new Random();

		String raString = "" + Random;
		System.out.println(raString);

		try {

			String sql = "select RA from alunos where RA = ? ";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				pstm.setString(1, raString);
				pstm.execute();

				ResultSet resultado = pstm.executeQuery();
				boolean existe = resultado.next();

				while (existe == true) {
					Random = gerador.nextInt();
					System.out.println(Random);
					ResultSetBoolean(Random);
				}

				System.out.println(existe);

				return existe;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean autenticadorData() {
		if (dataNascimentoTxt.getText().length() == 10) {
			return true;
		} else {
			return false;
		}
	}
	
	private void limparCampos() {
		dataNascimentoTxt.setText("");
		nomeAlunoTxt.setText("");
	}
	
	

}
