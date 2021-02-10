package br.com.View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.UsuarioController.UsuarioController;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class RemoverUsuarioFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UsuarioController user;
	private JTextField textField;
	private JLabel lblNewLabel;
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
	        } catch (ClassNotFoundException |InstantiationException |IllegalAccessException |javax.swing.UnsupportedLookAndFeelException ex) {
	    
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverUsuarioFrame frame = new RemoverUsuarioFrame();
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
	public RemoverUsuarioFrame() {
		user = new UsuarioController();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		try {
			contentPane = new FundoBg("C:\\Users\\wagne\\Desktop\\Estudos progamção 2\\APS-Interface\\Imagens\\Fundos de tela\\FundoRemoverAluno.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(142, 101, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Deletar");
		btnNewButton.setBounds(169, 149, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(141, 83, 99, 14);
		contentPane.add(lblNewLabel);
		
// 		Evento do botão deletar
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.Deletar(textField.getText());
				textField.setText("");
			}
		});
		
	}

}
