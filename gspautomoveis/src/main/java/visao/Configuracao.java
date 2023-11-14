package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.mysql.cj.xdevapi.Table;

import controle.Conexao;
import controle.FuncionarioDAO;
import modelo.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Configuracao extends JFrame {

	protected static Object textSenha;
	private JPanel contentPane;
	public static JTextField textUsuario;
	private JTextField textTel;
	public static JTextField textSen;
	private JTextField textEmail;
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();
	private JTextField textID;

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
	 * 
	 * @param princip
	 */
	public Configuracao() {
		setFont(new Font("Krona One", Font.PLAIN, 12));
		setTitle("Configurações");
		Funcionario func = new Funcionario();

		func = funcdao.passaLogado();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(196, 155, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSair = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPrincipal princip = new TelaPrincipal();
				princip.setVisible(true);
				princip.setExtendedState(MAXIMIZED_BOTH);
				dispose();
			}
		});
		
		lblSair.setIcon(new ImageIcon(Configuracao.class.getResource("/visao/imagens/voltar.png")));
		lblSair.setBounds(828, 22, 40, 35);
		contentPane.add(lblSair);
		

		JLabel lblNewLabel_3_1 = new JLabel("CONFIGURAÇÕES");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(196, 155, 87));
		lblNewLabel_3_1.setFont(new Font("Krona One", Font.PLAIN, 33));
		lblNewLabel_3_1.setBounds(258, 113, 408, 72);
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

		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblUsurio.setBounds(25, 314, 163, 38);
		contentPane.add(lblUsurio);

		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Krona One", Font.PLAIN, 12));
		textUsuario.setColumns(10);
		textUsuario.setBounds(192, 319, 321, 38);
		contentPane.add(textUsuario);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblTelefone.setBounds(27, 373, 163, 38);
		contentPane.add(lblTelefone);

		MaskFormatter mascaraTel = null;
		try {
			mascaraTel = new MaskFormatter("(##)#####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textTel = new JFormattedTextField(mascaraTel);
		textTel.setFont(new Font("Krona One", Font.PLAIN, 12));
		textTel.setColumns(10);
		textTel.setBounds(194, 373, 345, 38);
		contentPane.add(textTel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblSenha.setBounds(26, 426, 114, 38);
		contentPane.add(lblSenha);

		textSen = new JTextField();
		textSen.setFont(new Font("Krona One", Font.PLAIN, 12));
		textSen.setColumns(10);
		textSen.setBounds(193, 431, 196, 38);
		contentPane.add(textSen);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblEmail.setBounds(26, 492, 98, 38);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Krona One", Font.PLAIN, 12));
		textEmail.setColumns(10);
		textEmail.setBounds(193, 497, 675, 38);
		contentPane.add(textEmail);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario func1 = new Funcionario();
				
				String telefone = textTel.getText();
				try {
					String telefoneErrado = textTel.getText();

					String telefoneLimpo = telefoneErrado.replaceAll("[()\\s-]+", "");

					if (telefoneLimpo.matches("\\d{10,11}")) {
						telefone = telefoneLimpo;
					} else {
						System.out.println("Número de telefone inválido");
					}
				} catch (NumberFormatException e1) {
					System.out.println("Erro ao converter para Long: " + e1.getMessage());
				}
				
				func1.setMatricula(Integer.valueOf(textID.getText()));
				func1.setUsuario(textUsuario.getText());
				func1.setTelefone(Long.valueOf(telefone));
				func1.setEmail(textEmail.getText());
				func1.setSenha(textSen.getText());

				Configuracao config = new Configuracao();
				
				String usuarioLogado = funcdao.passaLogado().getUsuario();

				for (Funcionario func : funcdao.ListarUsuarios()) {
					if (!func.getUsuario().equals(func1.getUsuario())||func.getUsuario().equals(usuarioLogado)) {
						funcdao.atualizarFunc(func1);
					} else {
						TelaErro erro = new TelaErro(config, "Usuário já existe no sistema!");
						erro.setLocationRelativeTo(null);
						erro.setVisible(true);
						break;
					}
				}

			}
		});
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBorder(new RoundedBorder(10));
		btnAtualizar.setBackground(new Color(255, 218, 70));
		btnAtualizar.setBounds(348, 576, 251, 35);
		contentPane.add(btnAtualizar);

		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblId.setBounds(25, 242, 147, 38);
		contentPane.add(lblId);

		textID = new JTextField();
		textID.setEditable(false);
		textID.setFont(new Font("Krona One", Font.PLAIN, 12));
		textID.setColumns(10);
		textID.setBounds(192, 242, 321, 38);
		contentPane.add(textID);

		try {
			textID.setText(String.valueOf(func.getMatricula()));
			textEmail.setText(func.getEmail());
			textTel.setText(String.valueOf(func.getTelefone()));
			textSen.setText(func.getSenha());
			textUsuario.setText(func.getUsuario());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
