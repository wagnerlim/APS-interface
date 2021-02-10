package br.com.View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.UsuarioController.UsuarioController;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AdicionarUsuarioFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UsuarioController user;
	private JTextField LoginTxt;
	private JPasswordField senhaTxt;
	private JPasswordField confirmacaoSenhaTxt;
	private JLabel senhaLabel;
	private JLabel senhaConfrimacaoLabel;

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
					AdicionarUsuarioFrame frame = new AdicionarUsuarioFrame();
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
	public AdicionarUsuarioFrame() {
		setResizable(false);
		this.user = new UsuarioController();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		try {
			contentPane = new FundoBg("C:\\Users\\wagne\\Desktop\\Aps interface\\FundoAdicionarAluno.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		LoginTxt = new JTextField();
		LoginTxt.setBounds(10, 51, 120, 20);
		contentPane.add(LoginTxt);
		LoginTxt.setColumns(10);

		senhaTxt = new JPasswordField();
		senhaTxt.setBounds(10, 103, 120, 20);
		senhaTxt.setEchoChar('●');
		contentPane.add(senhaTxt);

		confirmacaoSenhaTxt = new JPasswordField();
		confirmacaoSenhaTxt.setBounds(10, 147, 120, 20);
		confirmacaoSenhaTxt.setEchoChar('●');
		contentPane.add(confirmacaoSenhaTxt);

		JCheckBox mostrarSenhaCheckBox = new JCheckBox("Mostrar Senha");
		mostrarSenhaCheckBox.setBounds(136, 146, 97, 23);
		contentPane.add(mostrarSenhaCheckBox);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(41, 172, 89, 23);
		contentPane.add(btnNewButton);

		JLabel UsuarioLabel = new JLabel("Usuario");
		UsuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		UsuarioLabel.setBounds(10, 37, 46, 14);
		contentPane.add(UsuarioLabel);

		senhaLabel = new JLabel("Senha");
		senhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		senhaLabel.setBounds(10, 89, 46, 14);
		contentPane.add(senhaLabel);

		senhaConfrimacaoLabel = new JLabel("Confirmar senha");
		senhaConfrimacaoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		senhaConfrimacaoLabel.setBounds(10, 134, 120, 14);
		contentPane.add(senhaConfrimacaoLabel);
		
// Mostrar Senha evento ao clicar		
		mostrarSenhaCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mostrarSenhaCheckBox.isSelected()) {
					senhaTxt.setEchoChar((char) 0);
					confirmacaoSenhaTxt.setEchoChar((char) 0);
				} else {
					senhaTxt.setEchoChar('●');
					confirmacaoSenhaTxt.setEchoChar('●');
				}
			}
		});
		
//	Evento botão cadastrar
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = String.copyValueOf(senhaTxt.getPassword());
				String senha2 = String.copyValueOf(confirmacaoSenhaTxt.getPassword());
				
				
				if(senha.equals(senha2)) {
					salvar();
					
				}else {
					JOptionPane.showMessageDialog(null, "As senhas não são iguais!", "Error 404", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	//Metodos da view
	public void salvar() {
		
		String senha = String.copyValueOf(senhaTxt.getPassword());
		user.Salvar(LoginTxt.getText(), senha);
	
		
		
	}
	
}


