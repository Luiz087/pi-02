package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.FuncionarioDAO;
import modelo.Funcionario;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JTextField textSenha;
	private JPasswordField passwordSenha;
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin telaLogin = new TelaLogin();
					telaLogin.setLocationRelativeTo(null);
					telaLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {

		setUndecorated(true);
		Color color = new Color(68, 117, 157);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 580);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordSenha = new JPasswordField();
		passwordSenha.setFont(new Font("Krona One", Font.PLAIN, 30));
		passwordSenha.setBackground(new Color(255, 255, 255));
		passwordSenha.setBounds(602, 272, 303, 35);
		passwordSenha.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color));
		contentPane.add(passwordSenha);

		JLabel lblNewLabel_3_2 = new JLabel("Bem-Vindo");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Krona One", Font.PLAIN, 36));
		lblNewLabel_3_2.setBounds(32, 48, 264, 72);
		contentPane.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_1 = new JLabel("Automóveis");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNewLabel_3_1.setBounds(36, 398, 237, 87);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1_2.setBounds(70, 147, 175, 190);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 57));
		lblNewLabel_3.setBounds(70, 324, 175, 87);
		contentPane.add(lblNewLabel_3);

		JLabel imgLateral = new JLabel("");
		imgLateral.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/imagens/bglateral.png")));
		imgLateral.setBounds(0, -382, 323, 1384);
		contentPane.add(imgLateral);

		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(466, 104, 126, 69);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(438, 260, 154, 69);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/imagens/user.png")));
		lblNewLabel.setBounds(393, 113, 86, 60);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/imagens/senha.png")));
		lblNewLabel_2.setBounds(387, 250, 60, 79);
		contentPane.add(lblNewLabel_2);

		textLogin = new JTextField();
		textLogin.setForeground(new Color(0, 0, 0));
		textLogin.setFont(new Font("Krona One", Font.PLAIN, 30));
		textLogin.setBounds(602, 120, 303, 35);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		textLogin.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color));

		textSenha = new JTextField();
		textSenha.setForeground(new Color(0, 0, 0));
		textSenha.setFont(new Font("Krona One", Font.PLAIN, 30));
		textSenha.setColumns(10);
		textSenha.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color));
		textSenha.setBounds(602, 272, 303, 35);
		contentPane.add(textSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.setForeground(new Color(0, 0, 0));

		btnEntrar.setFont(new Font("Krona One", Font.PLAIN, 30));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String login = textLogin.getText();
				char[] pass = passwordSenha.getPassword();
				String senha = "";
				if (pass != null && pass.length > 0) {
					senha = String.valueOf(pass);
				}
				if (senha.isEmpty() || login.isEmpty()) {
					telaLoginIncorreto dadosIncorretos = new telaLoginIncorreto();
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
					passwordSenha.setText(null);
					textLogin.setText(null);

				} else {
					Funcionario testelogin = new Funcionario();
					testelogin.setUsuario(login);
					testelogin.setSenha(senha);
					
					boolean login1 = funcdao.login(testelogin);
					
					if(login1) {
						TelaPrincipal telaPrincip = new TelaPrincipal();
						dispose();
						telaPrincip.setExtendedState(MAXIMIZED_BOTH);
						telaPrincip.setVisible(true);
						TelaSucesso sucesso = new TelaSucesso();
						sucesso.setLocationRelativeTo(null);
						sucesso.setVisible(true);
					} else {
						telaLoginIncorreto dadosIncorretos = new telaLoginIncorreto();
						dadosIncorretos.setLocationRelativeTo(null);
						dadosIncorretos.setVisible(true);
					}
					
				}

			}
		});
		btnEntrar.setBounds(601, 383, 202, 60);
		btnEntrar.setBorder(new RoundedBorder(20));
		contentPane.add(btnEntrar);

		JButton btnNewButton = new JButton("X");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(940, 0, 60, 45);
		btnNewButton.setBorder(null);
		btnNewButton.setFocusPainted(false);
		contentPane.add(btnNewButton);

	}
}
