package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import controle.FuncionarioDAO;
import modelo.Funcionario;

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
import javax.swing.SwingConstants;

public class Configuracao extends JFrame {

	protected static Object textSenha;
	private JPanel contentPane;
	public static JTextField textUsuario;
	private JTextField textTel;
	public static JTextField textSen;
	private JTextField textEmail;
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();

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
		Funcionario func = new Funcionario();

		func = funcdao.passaLogado();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_3_1 = new JLabel("AUTOMÓVEIS");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Krona One", Font.PLAIN, 33));
		lblNewLabel_3_1.setBounds(320, 113, 288, 72);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 99));
		lblNewLabel_3.setBounds(315, 22, 298, 80);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Configuracao.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1.setBounds(59, 11, 175, 190);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Configuracao.class.getResource("/visao/imagens/bgcima.png")));
		lblNewLabel.setBounds(0, 0, 884, 208);
		contentPane.add(lblNewLabel);
<<<<<<< Updated upstream

		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblUsurio.setBounds(26, 243, 163, 38);
		contentPane.add(lblUsurio);

=======
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblUsuario.setBounds(26, 243, 163, 38);
		contentPane.add(lblUsuario);
		
>>>>>>> Stashed changes
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Krona One", Font.PLAIN, 12));
		textUsuario.setColumns(10);
		textUsuario.setBounds(193, 248, 321, 38);
		textUsuario.setText(func.getUsuario());
		contentPane.add(textUsuario);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblTelefone.setBounds(26, 334, 163, 38);
		contentPane.add(lblTelefone);

		textTel = new JTextField();
		textTel.setFont(new Font("Krona One", Font.PLAIN, 12));
		textTel.setColumns(10);
		textTel.setBounds(193, 334, 345, 38);
		textTel.setText(String.valueOf(func.getTelefone()));
		contentPane.add(textTel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblSenha.setBounds(26, 426, 114, 38);
		contentPane.add(lblSenha);

		textSen = new JTextField();
		textSen.setFont(new Font("Krona One", Font.PLAIN, 12));
		textSen.setColumns(10);
		textSen.setBounds(193, 431, 196, 38);
		textSen.setText(func.getSenha());
		contentPane.add(textSen);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblEmail.setBounds(26, 492, 98, 38);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Krona One", Font.PLAIN, 12));
		textEmail.setColumns(10);
		textEmail.setBounds(193, 497, 675, 38);
		textEmail.setText(func.getEmail());
		contentPane.add(textEmail);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				}
			}
		);
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBorder(new RoundedBorder(10));
		btnAtualizar.setBackground(new Color(255, 218, 70));
		btnAtualizar.setBounds(348, 576, 251, 35);
		contentPane.add(btnAtualizar);

	}
}
