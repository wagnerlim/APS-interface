package br.com.View;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.UsuarioController.AlunosController;
import br.com.modelo.Alunos;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelo;
	private AlunosController AlunosController;
	private JTable table_1;
	private JLabel nomeLabel;
	private JLabel dataNascimentoLabel;
	private JLabel cursoLabel;
	private JLabel situacaoLabel;
	private JMenuItem adicionarAlunoMenuItem;

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
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		this.AlunosController = new AlunosController();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
//		contentPane = new JPanel();
		try {
//			"C:\\Users\\wagne\\Desktop\\Aps interface\\Prancheta 1.png" fundo para teste
//			"C:\\Users\\wagne\\Desktop\\Aps interface\\FundoTesteAPS.png" Outro fundo para teste
			contentPane = new FundoBg("C:\\Users\\wagne\\Desktop\\Aps interface\\FundoTesteAPS.png");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setContentPane(contentPane);

		table_1 = new JTable();
		table_1.setBounds(10, 218, 764, 169);

		modelo = (DefaultTableModel) table_1.getModel();
		modelo.addColumn("RA");
		modelo.addColumn("NOME");
		modelo.addColumn("DATA DE NASCIMENTO");
		modelo.addColumn("Nome Curso");
		modelo.addColumn("Situação");
		contentPane.setLayout(null);
		contentPane.add(table_1);

		JLabel raLabel = new JLabel("RA");
		raLabel.setForeground(Color.BLACK);
		raLabel.setBounds(10, 204, 46, 14);
		contentPane.add(raLabel);

		nomeLabel = new JLabel("Aluno");
		nomeLabel.setForeground(Color.BLACK);
		nomeLabel.setBounds(162, 204, 46, 14);
		contentPane.add(nomeLabel);

		dataNascimentoLabel = new JLabel("Data de Nascimento");
		dataNascimentoLabel.setForeground(Color.BLACK);
		dataNascimentoLabel.setBounds(315, 204, 138, 14);
		contentPane.add(dataNascimentoLabel);

		cursoLabel = new JLabel("Curso");
		cursoLabel.setForeground(Color.BLACK);
		cursoLabel.setBounds(468, 204, 46, 14);
		contentPane.add(cursoLabel);

		situacaoLabel = new JLabel("Situação");
		situacaoLabel.setForeground(Color.BLACK);
		situacaoLabel.setBounds(619, 204, 93, 14);
		contentPane.add(situacaoLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 794, 22);
		contentPane.add(menuBar);

		JMenu menuAlunos = new JMenu("Alunos");
		menuAlunos.setIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Icones\\study.png"));
		menuBar.add(menuAlunos);

		// Item do menu Alunos, Adicionar
		adicionarAlunoMenuItem = new JMenuItem("Adicionar");
		adicionarAlunoMenuItem.setIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Icones\\plus.png"));
		menuAlunos.add(adicionarAlunoMenuItem);

		// Item do menu Alunos, Remover
		JMenuItem RemoverAlunoMenu = new JMenuItem("Remover");
		RemoverAlunoMenu.setIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Icones\\delete.png"));
		menuAlunos.add(RemoverAlunoMenu);

		JMenu mnNewMenu = new JMenu("Usuários");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Icones\\Icones Usuarios\\user.png"));
		menuBar.add(mnNewMenu);

		JMenuItem AdicionarUsuarioMenuItem = new JMenuItem("Adicionar");
		AdicionarUsuarioMenuItem
				.setIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Icones\\Icones Usuarios\\userAdicionar.png"));
		mnNewMenu.add(AdicionarUsuarioMenuItem);

		JMenuItem removerUsuarioItem = new JMenuItem("Remover");
		removerUsuarioItem
				.setIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Icones\\Icones Usuarios\\userRemover.png"));
		mnNewMenu.add(removerUsuarioItem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Log off");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Icones\\Log off.png"));
		mnNewMenu.add(mntmNewMenuItem);

		// Botão de atualizar a tabela
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Icones\\botao-atualizar.png"));
		btnNewButton.setBounds(637, 170, 115, 23);
		contentPane.add(btnNewButton);

		// Caixa de cursos
		JComboBox<String> cursoCombox = new JComboBox<String>();
		cursoCombox.setBounds(23, 157, 138, 22);
		contentPane.add(cursoCombox);
		cursoCombox.addItem("Curso");
		List<String> cursos = this.cursosListar();
		for (String string : cursos) {
			cursoCombox.addItem(string);
		}

		// Caixa de Seleção de Situações da matricula

		JComboBox<String> SituacaoCombox = new JComboBox<String>();
		SituacaoCombox.setBounds(184, 157, 138, 22);
		contentPane.add(SituacaoCombox);
		SituacaoCombox.addItem("Selecione");
		List<String> Situacao = this.SituacaoListar();
		for (String string : Situacao) {
			SituacaoCombox.addItem(string);
		}

		// Botão Alterar
		JButton AlterarBotao = new JButton("Alterar");
		AlterarBotao.setBounds(10, 422, 89, 23);
		contentPane.add(AlterarBotao);

		JLabel cursosLabel = new JLabel("Cursos");
		cursosLabel.setForeground(Color.BLACK);
		cursosLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cursosLabel.setBounds(23, 143, 46, 14);
		contentPane.add(cursosLabel);

		JLabel matriculaLabel = new JLabel("Status");
		matriculaLabel.setForeground(Color.BLACK);
		matriculaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		matriculaLabel.setBounds(184, 143, 135, 14);
		contentPane.add(matriculaLabel);

		// Evento que acontece quando clica no botão Atualizar
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTabela();
				preencherTabelaComCurso();
			}
		});

		preencherTabelaComCurso();

		// Evento que acontece quando clica no item Adicionar do menu alunos
		adicionarAlunoMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarAlunoFrame novaView = new AdicionarAlunoFrame();
				novaView.setVisible(true);
				novaView.setLocationRelativeTo(null);
			}
		});

		// Evento que acontece quando clica no item remover do menu alunos
		RemoverAlunoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverAlunoFrame novaView = new RemoverAlunoFrame();
				novaView.setVisible(true);
				novaView.setLocationRelativeTo(null);
			}
		});

		// Evento que acontece quando clica no item Adicionar do menu Usuarios
		AdicionarUsuarioMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarUsuarioFrame novaView = new AdicionarUsuarioFrame();
				novaView.setVisible(true);
				novaView.setLocationRelativeTo(null);
			}
		});

		// Evento que acontece quando clica no item Remover menu do Usuarios
		removerUsuarioItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverUsuarioFrame novaView = new RemoverUsuarioFrame();
				novaView.setVisible(true);
				novaView.setLocationRelativeTo(null);
			}
		});

		// Evento que acontece quando clica no botão alterar
		AlterarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cursoCombox.getSelectedItem().equals("Curso") == true) {

					JOptionPane.showMessageDialog(null, "Selecione um curso", "Nenhum curso Selecionado",
							JOptionPane.ERROR_MESSAGE);

				} else if (SituacaoCombox.getSelectedItem().equals("Selecione") == true) {
					JOptionPane.showMessageDialog(null, "Selecione um status da matricula",
							"Nenhum Status da matricula foi selecionado", JOptionPane.ERROR_MESSAGE);
				} else {

					try {
						alterar(converterCursoEmInt(String.valueOf(cursoCombox.getSelectedItem())),
								converterSituacaoEmInt(String.valueOf(SituacaoCombox.getSelectedItem())));
						JOptionPane.showMessageDialog(null, "Alterações aplicadas!",
								"Alterações feitas", JOptionPane.INFORMATION_MESSAGE);
//					limparTabela();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		//Evento do botão  log off
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NovaTelaLogin novaTelaLogin = new NovaTelaLogin();
				novaTelaLogin.setVisible(true);
			}
		});

	}

	// METODOS DA VIEW
	public void preencherTabela() {
		List<Alunos> alunos = ListarAlunos();

		try {
			for (Alunos aluno : alunos) {
				modelo.addRow(new Object[] { aluno.getRA(), aluno.getNome(), aluno.getDataNascimento() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void limparTabela() {
		int UltimaTabela = modelo.getRowCount() - 1;
		System.out.println(UltimaTabela);
		modelo.removeRow(UltimaTabela);
		modelo.getDataVector().clear();
	}

	private void preencherTabelaComCurso() {
		List<Alunos> alunos = ListarAlunosComCurso();

		try {
			for (Alunos aluno : alunos) {
				modelo.addRow(new Object[] { aluno.getRA(), aluno.getNome(), aluno.getDataNascimento(),
						aluno.getCursonome(), aluno.getSituacaoNome() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private List<Alunos> ListarAlunos() {
		return this.AlunosController.listar();
	}

	private List<Alunos> ListarAlunosComCurso() {
		return this.AlunosController.listarComCurso();
	}

	private List<String> cursosListar() {

		return AlunosController.listarCursos();
	}

	private List<String> SituacaoListar() {

		return AlunosController.listarSituacao();
	}

	public int converterCursoEmInt(String CursoNome) throws SQLException {

		return this.AlunosController.ConversorCursoNomeId(CursoNome);

	}

	public int converterSituacaoEmInt(String Situacaonome) throws SQLException {

		return this.AlunosController.ConversosSituacaoId(Situacaonome);

	}

	private void alterar(int Cursoid, int Situacaoid) {
		Object objetoDaLinha = (Object) modelo.getValueAt(table_1.getSelectedRow(), table_1.getSelectedColumn());
		if (objetoDaLinha instanceof String) {
			String ra = (String) objetoDaLinha;
			String nome = (String) modelo.getValueAt(table_1.getSelectedRow(), 1);
			String data_nascimento = (String) modelo.getValueAt(table_1.getSelectedRow(), 2);

			this.AlunosController.Alterar(nome, data_nascimento, Cursoid, Situacaoid, ra);
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o RA");
		}
	}
}
