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

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.JPasswordField;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JTextField textSenha;

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

		JLabel imgLateral = new JLabel("");
		imgLateral.setIcon(new ImageIcon(TelaLogin.class.getResource("/visao/imagens/bemvindologin.png")));
		imgLateral.setBounds(0, -382, 323, 1286);
		contentPane.add(imgLateral);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(421, 104, 126, 69);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(393, 260, 154, 69);
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
		textLogin.setBounds(557, 120, 303, 35);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		textLogin.setBorder(BorderFactory.createMatteBorder(0,0,3,0, color));
		
		textSenha = new JTextField();
		textSenha.setForeground(new Color(0, 0, 0));
		textSenha.setFont(new Font("Krona One", Font.PLAIN, 30));
		textSenha.setColumns(10);
		
		
		textSenha.setBorder(BorderFactory.createMatteBorder(0,0,3,0, color));
		textSenha.setBounds(557, 272, 303, 35);
		contentPane.add(textSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.setForeground(new Color(0, 0, 0));
		
		
		btnEntrar.setFont(new Font("Krona One", Font.PLAIN, 30));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntrar.setBounds(556, 383, 202, 60);
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
		btnNewButton.setBounds(924, 0, 60, 45);
		btnNewButton.setBorder(null);
		btnNewButton.setFocusPainted(false);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(659, 481, 46, 14);
		contentPane.add(lblNewLabel_3);

	}
}
