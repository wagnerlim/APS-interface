package br.com.View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import br.com.UsuarioController.AlunosController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class RemoverAlunoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField RAtxt;
	private JLabel lblNewLabel_1;
	
	
	

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
					RemoverAlunoFrame frame = new RemoverAlunoFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	AlunosController controlador = new AlunosController();
	/**
	 * Create the frame.
	 */
	public RemoverAlunoFrame() {
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
		try {
			contentPane = new FundoBg("C:\\Users\\wagne\\Desktop\\Estudos progamção 2\\APS-Interface\\Imagens\\Fundos de tela\\FundoRemoverAluno.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		RAtxt = new JTextField();
		RAtxt.setBounds(161, 121, 112, 20);
		contentPane.add(RAtxt);
		RAtxt.setColumns(10);

		lblNewLabel_1 = new JLabel("RA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(141, 122, 17, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Remover");
		btnNewButton.setBounds(171, 152, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
				JOptionPane.showMessageDialog(null, "Aluno Removido com sucesso!", "Operação Concluida", JOptionPane.INFORMATION_MESSAGE);	
				RAtxt.setText("");
			}
		});
		
	}

	private void remover() {
		
		controlador.Deletar(RAtxt.getText());
		
	}
	
	
}
