package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Funcionario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textUsuario;
	private JTextField textTelefone;
	private JTextField textSenha;
	private JTextField textEmail;
	private JTextField textDataNasc;
	private JTextField textCargo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarios frame = new TelaFuncionarios();
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
	public TelaFuncionarios() {
		Funcionario func = new Funcionario();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1119);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel.setBounds(0, -43, 350, 1205);
		contentPane.add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNome.setBounds(399, 32, 133, 38);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblCpf.setBounds(439, 92, 93, 38);
		contentPane.add(lblCpf);

		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblUsurio.setBounds(862, 32, 163, 38);
		contentPane.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblSenha.setBounds(775, 92, 143, 38);
		contentPane.add(lblSenha);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblTelefone.setBounds(1355, 32, 188, 38);
		contentPane.add(lblTelefone);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblEmail.setBounds(409, 152, 123, 38);
		contentPane.add(lblEmail);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblDataDeNascimento.setBounds(1241, 152, 415, 38);
		contentPane.add(lblDataDeNascimento);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblCargo.setBounds(1152, 92, 133, 38);
		contentPane.add(lblCargo);

		textNome = new JTextField();
		textNome.setBounds(542, 32, 292, 38);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textCPF = new JTextField();
		textCPF.setColumns(10);
		textCPF.setBounds(542, 92, 196, 38);
		contentPane.add(textCPF);

		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(1035, 32, 292, 38);
		contentPane.add(textUsuario);

		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(1553, 32, 309, 38);
		contentPane.add(textTelefone);

		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(928, 92, 196, 38);
		contentPane.add(textSenha);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(542, 152, 675, 38);
		contentPane.add(textEmail);

		textDataNasc = new JTextField();
		textDataNasc.setColumns(10);
		textDataNasc.setBounds(1666, 152, 196, 38);
		contentPane.add(textDataNasc);

		textCargo = new JTextField();
		textCargo.setColumns(10);
		textCargo.setBounds(1295, 92, 567, 38);
		contentPane.add(textCargo);
		
		// Criação do ScrollPane, JFrame vai dentro
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 265, 1463, 742);
		contentPane.add(scrollPane);

		// Criação da JTable
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int setar = table.getSelectedRow();
				
				textNome.setText(table.getModel().getValueAt(setar, 0).toString());
				textEmail.setText(table.getModel().getValueAt(setar, 5).toString());
				textUsuario.setText(table.getModel().getValueAt(setar, 1).toString());
				textTelefone.setText(table.getModel().getValueAt(setar, 2).toString());
				textCargo.setText(table.getModel().getValueAt(setar, 3).toString());
				textDataNasc.setText(table.getModel().getValueAt(setar, 4).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Usu\u00E1rio", "Telefone", "Cargo", "Data de Nascimento","Email" , "A\u00E7\u00F5es" }));
		
		JButton btnAdicionar = new JButton("Adicionar\r\n");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText();
				Long cpf = Long.parseLong(textCPF.getText());
				String email = textEmail.getText();
				String usuario = textUsuario.getText();
				String senha = textSenha.getText();
				Long telefone = Long.parseLong(textTelefone.getText());
				String cargo = textCargo.getText();
				String dataNascimento = textDataNasc.getText();
				
				if(nome.equals("")||cpf.equals("")||email.equals("")||usuario.equals("")||senha.equals("")||telefone.equals("")||cargo.equals("")||dataNascimento.equals("")) {
					System.out.print("mal");
				} else {
					String data[] = {nome,usuario,String.valueOf(telefone),cargo,dataNascimento,email};
					
					DefaultTableModel tbltable = (DefaultTableModel)table.getModel();
					tbltable.addRow(data);
					
					
					
					textNome.setText("");
					textCPF.setText("");
					textEmail.setText("");
					textUsuario.setText("");
					textSenha.setText("");
					textTelefone.setText("");
					textCargo.setText("");
					textDataNasc.setText("");
				}
				
			}
		});
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Krona One", Font.PLAIN, 20));
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBorder(new RoundedBorder(10));
		btnAdicionar.setBackground(Color.GREEN);
		btnAdicionar.setBounds(1069, 208, 251, 35);
		contentPane.add(btnAdicionar);

		// Mudando o tamanho da coluna 7 (Ações)
		table.getColumnModel().getColumn(6).setPreferredWidth(1);
		
		
	}
}
