package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.FuncionarioDAO;
import modelo.Funcionario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField text_nome;
	private JTextField text_matricula;
	private JTextField text_telefone;
	private JTextField text_cargo;
	private JTextField text_comissao;
	private JTextField text_metas;
	private JTextField text_email;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		Funcionario logado = new Funcionario();

		logado = funcdao.passaLogado();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_6_1_1 = new JLabel("Histórico");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1.setFont(new Font("Krona One", Font.BOLD, 22));
		lblNewLabel_6_1_1.setBounds(1432, 945, 279, 35);
		contentPane.add(lblNewLabel_6_1_1);

		JLabel lblNewLabel_6_1 = new JLabel("Configurações");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Krona One", Font.BOLD, 22));
		lblNewLabel_6_1.setBounds(1041, 945, 279, 35);
		contentPane.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6 = new JLabel("Sistema");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Krona One", Font.BOLD, 22));
		lblNewLabel_6.setBounds(639, 945, 279, 35);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1
				.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/carrinho compras.png")));
		lblNewLabel_5_1_1.setFont(new Font("Krona One", Font.BOLD, 20));
		lblNewLabel_5_1_1.setBounds(1552, 706, 40, 35);
		contentPane.add(lblNewLabel_5_1_1);

		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Engrenagem.png")));
		lblNewLabel_5_1.setFont(new Font("Krona One", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(1167, 706, 40, 35);
		contentPane.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Sistema.png")));
		lblNewLabel_5.setFont(new Font("Krona One", Font.BOLD, 20));
		lblNewLabel_5.setBounds(760, 706, 30, 35);
		contentPane.add(lblNewLabel_5);

		textField_8 = new JTextField();
		textField_8.setForeground(new Color(0, 0, 0));
		textField_8.setEnabled(false);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(1041, 616, 279, 378);
		contentPane.add(textField_8);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(74, 149, 175, 190);
		lblNewLabel_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Logo sem fundo.png")));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setBounds(74, 51, 166, 72);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 57));
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Veículos");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVeiculos telaveic = new TelaVeiculos();
				dispose();
				telaveic.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaveic.setVisible(true);
			}
		});
		lblNewLabel_4.setBounds(74, 418, 265, 35);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Configuracao telaconfig = new Configuracao();
				dispose();
				telaconfig.setLocationRelativeTo(null);
				telaconfig.setVisible(true);

			}
		});
		lblNewLabel_2_1.setBounds(28, 498, 40, 35);
		lblNewLabel_2_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Engrenagem.png")));
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_4_1 = new JLabel("Configurações");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Configuracao telaconfig = new Configuracao();
				dispose();
				telaconfig.setLocationRelativeTo(null);
				telaconfig.setVisible(true);
			}
		});
		lblNewLabel_4_1.setBounds(74, 498, 265, 35);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFuncionarios telafunc = new TelaFuncionarios();
				dispose();
				telafunc.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telafunc.setVisible(true);
			}
		});
		lblNewLabel_2_1_1.setBounds(28, 578, 40, 35);
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Pessoa.png")));
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("Funcionários");
		lblNewLabel_4_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFuncionarios telafunc = new TelaFuncionarios();
				dispose();
				telafunc.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telafunc.setVisible(true);
			}
		});
		lblNewLabel_4_1_1.setBounds(74, 578, 265, 35);
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHistoricoVeiculos telaHV = new TelaHistoricoVeiculos();
				dispose();
				telaHV.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaHV.setVisible(true);		
			}
		});
		lblNewLabel_2_1_1_1.setBounds(28, 653, 40, 35);
		lblNewLabel_2_1_1_1
				.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/carrinho compras.png")));
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Histórico");
		lblNewLabel_4_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHistoricoVeiculos telaHV = new TelaHistoricoVeiculos();
				dispose();
				telaHV.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaHV.setVisible(true);		
			}
		});
		lblNewLabel_4_1_1_1.setBounds(74, 653, 265, 35);
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFornecedores telafornec = new TelaFornecedores();
				dispose();
				telafornec.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telafornec.setVisible(true);
			}
		});
		lblNewLabel_2_1_1_1_1.setBounds(28, 725, 40, 35);
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/carro +.png")));
		contentPane.add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Fornecedores");
		lblNewLabel_4_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFornecedores telafornec = new TelaFornecedores();
				dispose();
				telafornec.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telafornec.setVisible(true);
			}
		});
		lblNewLabel_4_1_1_1_1.setBounds(74, 725, 265, 35);
		lblNewLabel_4_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin telalogin = new TelaLogin();
				dispose();
				telalogin.setLocationRelativeTo(null);
				telalogin.setVisible(true);
			}
		});
		lblNewLabel_2_1_1_1_1_1_1.setBounds(28, 945, 40, 35);
		lblNewLabel_2_1_1_1_1_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/sair.png")));
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Sair");
		lblNewLabel_4_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin telalogin = new TelaLogin();
				dispose();
				telalogin.setLocationRelativeTo(null);
				telalogin.setVisible(true);
			}
		});
		lblNewLabel_4_1_1_1_1_1_1.setBounds(74, 944, 93, 35);
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVeiculos telaveic = new TelaVeiculos();
				dispose();
				telaveic.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaveic.setVisible(true);
			}
		});
		lblNewLabel_2_1_2.setBounds(28, 418, 40, 35);
		lblNewLabel_2_1_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/bau veiculos.png")));
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-11, -58, 361, 1141);
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/bglateral.png")));
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_2_1_2_1 = new JLabel("");
		lblNewLabel_2_1_2_1.setBounds(380, 159, 40, 35);
		lblNewLabel_2_1_2_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/pessoa(nome).png")));
		contentPane.add(lblNewLabel_2_1_2_1);

		text_nome = new JTextField();
		text_nome.setFont(new Font("Krona One", Font.PLAIN, 20));
		text_nome.setEditable(false);
		text_nome.setBounds(546, 159, 239, 35);
		contentPane.add(text_nome);
		text_nome.setColumns(10);
		text_nome.setText(logado.getNome());

		JLabel lblNewLabel_nome = new JLabel("Nome:");
		lblNewLabel_nome.setBounds(430, 159, 106, 35);
		lblNewLabel_nome.setForeground(new Color(0, 0, 0));
		lblNewLabel_nome.setFont(new Font("Krona One", Font.PLAIN, 24));
		contentPane.add(lblNewLabel_nome);

		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("");
		lblNewLabel_2_1_2_1_1
				.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Tabele de verificação.png")));
		lblNewLabel_2_1_2_1_1.setBounds(867, 159, 40, 35);
		contentPane.add(lblNewLabel_2_1_2_1_1);

		JLabel lblNewLabel_matricula = new JLabel("Matrícula:");
		lblNewLabel_matricula.setForeground(Color.BLACK);
		lblNewLabel_matricula.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_matricula.setBounds(917, 159, 154, 35);
		contentPane.add(lblNewLabel_matricula);

		text_matricula = new JTextField();
		text_matricula.setFont(new Font("Krona One", Font.PLAIN, 20));
		text_matricula.setEditable(false);
		text_matricula.setColumns(10);
		text_matricula.setBounds(1081, 159, 239, 35);
		contentPane.add(text_matricula);
		text_matricula.setText(String.valueOf(logado.getMatricula()));

		JLabel lblNewLabel_2_1_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_2_1_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/telefone.png")));
		lblNewLabel_2_1_2_1_1_1.setBounds(1432, 159, 40, 35);
		contentPane.add(lblNewLabel_2_1_2_1_1_1);

		JLabel lblNewLabel_telefone = new JLabel("Telefone:");
		lblNewLabel_telefone.setForeground(Color.BLACK);
		lblNewLabel_telefone.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_telefone.setBounds(1482, 159, 154, 35);
		contentPane.add(lblNewLabel_telefone);

		MaskFormatter mascaraTel = null;
		try {
			mascaraTel = new MaskFormatter("(##)#####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		text_telefone = new JFormattedTextField(mascaraTel);
		text_telefone.setFont(new Font("Krona One", Font.PLAIN, 20));
		text_telefone.setEditable(false);
		text_telefone.setColumns(10);
		text_telefone.setBounds(1646, 159, 239, 35);
		contentPane.add(text_telefone);

		JLabel lblNewLabel_cargo = new JLabel("Cargo:");
		lblNewLabel_cargo.setForeground(Color.BLACK);
		lblNewLabel_cargo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_cargo.setBounds(430, 304, 106, 35);
		contentPane.add(lblNewLabel_cargo);

		text_cargo = new JTextField();
		text_cargo.setFont(new Font("Krona One", Font.PLAIN, 20));
		text_cargo.setEditable(false);
		text_cargo.setColumns(10);
		text_cargo.setBounds(546, 304, 239, 35);
		contentPane.add(text_cargo);
		text_cargo.setText(logado.getNivelCargo());

		JLabel lblNewLabel_comissao = new JLabel("Comissão:");
		lblNewLabel_comissao.setForeground(Color.BLACK);
		lblNewLabel_comissao.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_comissao.setBounds(928, 304, 175, 35);
		contentPane.add(lblNewLabel_comissao);

		text_comissao = new JTextField();
		text_comissao.setFont(new Font("Krona One", Font.PLAIN, 20));
		text_comissao.setEditable(false);
		text_comissao.setColumns(10);
		text_comissao.setBounds(1121, 304, 239, 35);
		contentPane.add(text_comissao);
		text_comissao.setText(String.valueOf(logado.getComissao()));

		JLabel lblNewLabel_metas = new JLabel("Metas:");
		lblNewLabel_metas.setForeground(Color.BLACK);
		lblNewLabel_metas.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_metas.setBounds(1530, 304, 106, 35);
		contentPane.add(lblNewLabel_metas);

		text_metas = new JTextField();
		text_metas.setFont(new Font("Krona One", Font.PLAIN, 20));
		text_metas.setEditable(false);
		text_metas.setColumns(10);
		text_metas.setBounds(1646, 304, 239, 35);
		contentPane.add(text_metas);

		JLabel lblNewLabel_email = new JLabel("E-mail:");
		lblNewLabel_email.setForeground(Color.BLACK);
		lblNewLabel_email.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_email.setBounds(430, 419, 119, 35);
		contentPane.add(lblNewLabel_email);

		text_email = new JTextField();
		text_email.setFont(new Font("Krona One", Font.PLAIN, 20));
		text_email.setEditable(false);
		text_email.setColumns(10);
		text_email.setBounds(561, 423, 799, 35);
		contentPane.add(text_email);
		text_email.setText(logado.getEmail());

		JLabel lblNewLabel_2_1_2_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_2_1_1_1_1
				.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Tabele de verificação.png")));
		lblNewLabel_2_1_2_1_1_1_1.setBounds(1478, 304, 40, 35);
		contentPane.add(lblNewLabel_2_1_2_1_1_1_1);

		JLabel lblNewLabel_2_1_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2_1_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/maleta.png")));
		lblNewLabel_2_1_2_1_2.setBounds(380, 304, 40, 35);
		contentPane.add(lblNewLabel_2_1_2_1_2);

		JLabel lblNewLabel_2_1_2_1_2_1 = new JLabel("");
		lblNewLabel_2_1_2_1_2_1
				.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/caixacorreio.png")));
		lblNewLabel_2_1_2_1_2_1.setBounds(380, 418, 40, 35);
		contentPane.add(lblNewLabel_2_1_2_1_2_1);

		JLabel lblNewLabel_2_1_2_1_1_2 = new JLabel("");
		lblNewLabel_2_1_2_1_1_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/moedas.png")));
		lblNewLabel_2_1_2_1_1_2.setBounds(867, 304, 40, 35);
		contentPane.add(lblNewLabel_2_1_2_1_1_2);

		JLabel lblNewLabel_2 = new JLabel("Sugestões de ações:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Krona One", Font.BOLD, 30));
		lblNewLabel_2.setBounds(920, 535, 440, 46);
		contentPane.add(lblNewLabel_2);

		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setEditable(false);
		textField_7.setBounds(639, 616, 279, 378);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setEnabled(false);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(1432, 616, 279, 378);
		contentPane.add(textField_9);

		JLabel lblNewLabel_2_1_2_1_1_1_2 = new JLabel("");
		lblNewLabel_2_1_2_1_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin telalogin = new TelaLogin();
				dispose();
				telalogin.setLocationRelativeTo(null);
				telalogin.setVisible(true);
			}
		});
		lblNewLabel_2_1_2_1_1_1_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/sair.png")));
		lblNewLabel_2_1_2_1_1_1_2.setBounds(1845, 12, 40, 35);
		contentPane.add(lblNewLabel_2_1_2_1_1_1_2);

		JLabel lblNewLabel_4_2_1_1_2 = new JLabel("Olá, ");
		lblNewLabel_4_2_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_4_2_1_1_2.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_2_1_1_2.setBounds(1482, 12, 70, 35);
		contentPane.add(lblNewLabel_4_2_1_1_2);

		JLabel lblNomeFunc = new JLabel(logado.getNome());
		lblNomeFunc.setForeground(Color.BLACK);
		lblNomeFunc.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNomeFunc.setBounds(1562, 12, 273, 35);
		contentPane.add(lblNomeFunc);

	}
}
