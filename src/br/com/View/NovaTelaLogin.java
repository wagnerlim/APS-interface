package br.com.View;


import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.UsuarioController.UsuarioController;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class NovaTelaLogin extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaLogin;
	private JTextField campoUsuario;
	private JPasswordField campoSenha;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private UsuarioController usuariocontrole = new UsuarioController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Windows Classic".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException |InstantiationException |IllegalAccessException |javax.swing.UnsupportedLookAndFeelException ex) {
	    
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaTelaLogin novaTelaLogin = new NovaTelaLogin();
					novaTelaLogin.setVisible(true);
					novaTelaLogin.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovaTelaLogin() {
		
		setBounds(100, 100, 400, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		try {
			telaLogin = new FundoBg("C:\\Users\\wagne\\Desktop\\Estudos progamção 2\\APS-Interface\\Imagens\\Fundos de tela\\TelaLoginBckgrounnd.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		telaLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaLogin);
		telaLogin.setLayout(null);
		
		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoUsuario.setBounds(109, 242, 163, 20);
		telaLogin.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoSenha.setBounds(109, 280, 163, 20);
		campoSenha.setEchoChar('●');
		telaLogin.add(campoSenha);
		
		JButton botaoAcessar = new JButton("Acessar");
		botaoAcessar.setIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Estudos progamção 2\\APS-Interface\\Imagens\\icones Tela login\\entrar.png"));
		botaoAcessar.setBounds(109, 311, 111, 23);
		telaLogin.add(botaoAcessar);
		
		JCheckBox mostrarSenha = new JCheckBox("");
		mostrarSenha.setSelectedIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Estudos progamção 2\\APS-Interface\\Imagens\\icones Tela login\\visibilidade.png"));
		mostrarSenha.setPressedIcon(null);
		mostrarSenha.setIcon(new ImageIcon("C:\\Users\\wagne\\Desktop\\Estudos progamção 2\\APS-Interface\\Imagens\\icones Tela login\\invisivel.png"));
		mostrarSenha.setBounds(278, 270, 33, 34);
		telaLogin.add(mostrarSenha);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(109, 227, 46, 14);
		telaLogin.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(109, 268, 46, 14);
		telaLogin.add(lblNewLabel_1);
		
//		Eventos
// 		Evento para mostrar senha do checkBox		
		mostrarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mostrarSenha.isSelected()){
			           campoSenha.setEchoChar((char)0);
			        }else{
			            campoSenha.setEchoChar('●') ;
			        }
			}
		});
		
		botaoAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = campoUsuario.getText();
				String senha = String.copyValueOf(campoSenha.getPassword());
				if(usuariocontrole.UsuarioAutenticar(usuario, senha) == true) {
					
					dispose();
					TelaPrincipal tela2 = new TelaPrincipal();
					tela2.setLocationRelativeTo(null);
					tela2.setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(null, "Senha ou Usuario incorretos", "Error 404", JOptionPane.ERROR_MESSAGE);	
				}
			}
			
		});
		
		
	}

}
