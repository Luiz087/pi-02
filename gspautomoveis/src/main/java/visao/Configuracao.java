package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Configuracao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracao frame = new Configuracao();
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
	public Configuracao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 57));
		lblNewLabel_3.setBounds(71, 67, 181, 72);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Configuracao.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1.setBounds(348, 11, 175, 190);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Configuracao.class.getResource("/visao/imagens/bgcima.png")));
		lblNewLabel.setBounds(0, 0, 884, 208);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblUsurio.setBounds(26, 243, 163, 38);
		contentPane.add(lblUsurio);
		
		textField = new JTextField();
		textField.setFont(new Font("Krona One", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(193, 248, 321, 38);
		contentPane.add(textField);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblTelefone.setBounds(26, 334, 163, 38);
		contentPane.add(lblTelefone);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Krona One", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(193, 334, 345, 38);
		contentPane.add(textField_1);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblSenha.setBounds(26, 426, 114, 38);
		contentPane.add(lblSenha);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Krona One", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(193, 431, 196, 38);
		contentPane.add(textField_2);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblEmail.setBounds(26, 492, 98, 38);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Krona One", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(199, 497, 675, 38);
		contentPane.add(textField_3);
		
		JButton btnAdicionar = new JButton("Adicionar\r\n");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBorder(new RoundedBorder(10));
		btnAdicionar.setBackground(Color.BLUE);
		btnAdicionar.setBounds(348, 576, 251, 35);
		contentPane.add(btnAdicionar);
		
		  
	}
}
