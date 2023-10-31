package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.CarroDAO;
import controle.FornecedorDAO;
import controle.FuncionarioDAO;
import controle.SendEmail;
import controle.VendaDAO;
import modelo.Carro;
import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Venda;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textNomeC;
	private JTextField textCPFC;
	private JTextField textTelefoneC;
	private JTextField textCepC;
	private JTextField textCidadeC;
	private JTextField textEstadoC;
	private JTextField textRuaC;
	private JTextField textDataCompra;
	private JTextField textPreco;
	private JTextField textBairroC;
	private CarroDAO cardao = CarroDAO.getInstancia();
	private FornecedorDAO forndao = FornecedorDAO.getInstancia();
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textAno;
	private JTextField textQuilometragem;
	private JTextField textFornecedor;
	private VendaDAO vendadao = VendaDAO.getInstancia();
	private JTextField textEmailC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendas frame = new TelaVendas(null);
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
	public TelaVendas(Integer idCarroRecebido) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setVisible(false);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setVisible(true);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel.setVisible(false);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVendas telaHV = new TelaVendas(1);
				dispose();
				telaHV.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaHV.setVisible(true);

			}
		});

		Carro carro = cardao.clicado(idCarroRecebido);
		Fornecedor forn = forndao.buscaFornecedor(carro.getFornecedor());

		JPanel panel_1 = new JPanel();
		panel_1.setVisible(false);
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFornecedores telafornec = new TelaFornecedores();
				dispose();
				telafornec.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telafornec.setVisible(true);
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFuncionarios telafunc = new TelaFuncionarios();
				dispose();
				telafunc.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telafunc.setVisible(true);
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Configuracao telaconfig = new Configuracao();
				dispose();
				telaconfig.setLocationRelativeTo(null);
				telaconfig.setVisible(true);
			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setVisible(false);
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVeiculos telaveic = new TelaVeiculos();
				dispose();
				telaveic.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaveic.setVisible(true);

			}
		});

		JPanel panel_5 = new JPanel();
		panel_5.setVisible(false);
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin telalogin = new TelaLogin();
				dispose();
				telalogin.setLocationRelativeTo(null);
				telalogin.setVisible(true);
			}
		});

		panel_5.setBounds(0, 931, 334, 63);
		contentPane.add(panel_5);
		panel_4.setBounds(0, 399, 334, 63);
		contentPane.add(panel_4);
		panel_3.setBounds(0, 482, 334, 56);
		contentPane.add(panel_3);
		panel_2.setBounds(0, 564, 334, 52);
		contentPane.add(panel_2);
		panel_1.setBounds(0, 711, 334, 52);
		contentPane.add(panel_1);
		panel.setForeground(new Color(0, 0, 0));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_2.setForeground(new Color(0, 0, 0));
		panel_3.setForeground(new Color(0, 0, 0));
		panel_4.setForeground(new Color(0, 0, 0));
		panel_5.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 640, 334, 52);
		contentPane.add(panel);
		panel.setBackground(new Color(215, 215, 215, 50));
		panel_1.setBackground(new Color(215, 215, 215, 50));
		panel_2.setBackground(new Color(215, 215, 215, 50));
		panel_3.setBackground(new Color(215, 215, 215, 50));
		panel_4.setBackground(new Color(215, 215, 215, 50));
		panel_5.setBackground(new Color(215, 215, 215, 50));

		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("       Sair");
		lblNewLabel_4_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setVisible(true);

			}
		});
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_1_1_1_1_1_1.setBounds(0, 936, 334, 58);
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1);

		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 57));
		lblNewLabel_3.setBounds(63, 43, 166, 72);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1.setBounds(63, 141, 175, 190);
		contentPane.add(lblNewLabel_1);

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
		lblNewLabel_2_1_2.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/bau veiculos.png")));
		lblNewLabel_2_1_2.setBounds(17, 410, 40, 35);
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_4 = new JLabel("        Veículos");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVeiculos telaveic = new TelaVeiculos();
				dispose();
				telaveic.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaveic.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setVisible(true);

			}
		});
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(0, 399, 328, 63);
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
		lblNewLabel_2_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/Engrenagem.png")));
		lblNewLabel_2_1.setBounds(17, 490, 40, 35);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_4_1 = new JLabel("       Configurações");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Configuracao telaconfig = new Configuracao();
				dispose();
				telaconfig.setLocationRelativeTo(null);
				telaconfig.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setVisible(true);

			}
		});
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1.setBounds(0, 482, 328, 56);
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
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/Pessoa.png")));
		lblNewLabel_2_1_1.setBounds(17, 570, 40, 35);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("    Funcionários");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFuncionarios telafunc = new TelaFuncionarios();
				dispose();
				telafunc.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telafunc.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setVisible(true);

			}
		});
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1.setBounds(0, 564, 328, 52);
		contentPane.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVendas telaHV = new TelaVendas(1);
				dispose();
				telaHV.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaHV.setVisible(true);
			}
		});
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/carrinho compras.png")));
		lblNewLabel_2_1_1_1.setBounds(17, 645, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("        Histórico");
		lblNewLabel_4_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVendas telaHV = new TelaVendas(1);
				dispose();
				telaHV.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaHV.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setVisible(true);

			}
		});
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1.setBounds(0, 640, 334, 52);
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
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/carro +.png")));
		lblNewLabel_2_1_1_1_1.setBounds(17, 717, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("     Fornecedores");
		lblNewLabel_4_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFornecedores telafornec = new TelaFornecedores();
				dispose();
				telafornec.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telafornec.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setVisible(true);

			}
		});
		lblNewLabel_4_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1_1.setBounds(0, 711, 334, 52);
		contentPane.add(lblNewLabel_4_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/sair.png")));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(17, 931, 40, 63);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel.setBounds(-14, -47, 361, 1141);
		contentPane.add(lblNewLabel);

		JLabel lblMarca = new JLabel("Nome:");
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblMarca.setBounds(962, 319, 114, 38);
		contentPane.add(lblMarca);

		textNomeC = new JTextField();
		textNomeC.setFont(new Font("Krona One", Font.PLAIN, 14));
		textNomeC.setBounds(1086, 319, 233, 38);
		contentPane.add(textNomeC);
		textNomeC.setColumns(10);

		JLabel lblCpfCliente = new JLabel("CPF:");
		lblCpfCliente.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpfCliente.setBounds(1002, 152, 74, 38);
		contentPane.add(lblCpfCliente);

		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textCPFC = new JFormattedTextField(mascaraCPF);
		textCPFC.setFont(new Font("Krona One", Font.PLAIN, 14));
		textCPFC.setColumns(10);
		textCPFC.setBounds(1086, 152, 233, 38);
		contentPane.add(textCPFC);

		JLabel lblTelefoneCliente = new JLabel("Telefone:");
		lblTelefoneCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneCliente.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblTelefoneCliente.setBounds(919, 233, 157, 38);
		contentPane.add(lblTelefoneCliente);

		textTelefoneC = new JTextField();
		textTelefoneC.setFont(new Font("Krona One", Font.PLAIN, 14));
		textTelefoneC.setColumns(10);
		textTelefoneC.setBounds(1086, 233, 233, 38);
		contentPane.add(textTelefoneC);

		textCepC = new JTextField();
		textCepC.setFont(new Font("Krona One", Font.PLAIN, 14));
		textCepC.setColumns(10);
		textCepC.setBounds(1583, 407, 233, 38);
		contentPane.add(textCepC);

		JLabel lblBairro = new JLabel("CEP:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblBairro.setBounds(1480, 407, 93, 38);
		contentPane.add(lblBairro);

		JLabel lblCidae = new JLabel("Cidade:");
		lblCidae.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblCidae.setBounds(944, 407, 132, 38);
		contentPane.add(lblCidae);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Krona One", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Pix", "Boleto", "Crédito", "Débito"}));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(1583, 564, 233, 38);
		contentPane.add(comboBox);

		textCidadeC = new JTextField();
		textCidadeC.setFont(new Font("Krona One", Font.PLAIN, 14));
		textCidadeC.setColumns(10);
		textCidadeC.setBounds(1086, 407, 233, 38);
		contentPane.add(textCidadeC);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblEstado.setBounds(1430, 487, 143, 38);
		contentPane.add(lblEstado);

		textEstadoC = new JTextField();
		textEstadoC.setFont(new Font("Krona One", Font.PLAIN, 14));
		textEstadoC.setColumns(10);
		textEstadoC.setBounds(1583, 487, 233, 38);
		contentPane.add(textEstadoC);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRua.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblRua.setBounds(1478, 152, 95, 38);
		contentPane.add(lblRua);

		textRuaC = new JTextField();
		textRuaC.setFont(new Font("Krona One", Font.PLAIN, 14));
		textRuaC.setColumns(10);
		textRuaC.setBounds(1583, 152, 233, 38);
		contentPane.add(textRuaC);

		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblData.setBounds(1473, 314, 100, 38);
		contentPane.add(lblData);

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textDataCompra = new JFormattedTextField(mascaraData);
		textDataCompra.setFont(new Font("Krona One", Font.PLAIN, 14));
		textDataCompra.setColumns(10);
		textDataCompra.setBounds(1583, 319, 233, 38);
		contentPane.add(textDataCompra);

		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblPreo.setBounds(443, 463, 114, 38);
		contentPane.add(lblPreo);

		textPreco = new JTextField();
		textPreco.setEditable(false);
		textPreco.setFont(new Font("Krona One", Font.PLAIN, 14));
		textPreco.setColumns(10);
		textPreco.setBounds(567, 463, 233, 38);
		contentPane.add(textPreco);
		textPreco.setText("R$ " + String.valueOf(carro.getPrecoCarro()));
		textPreco.setBackground(Color.WHITE);

		JLabel lblCep = new JLabel("Bairro:");
		lblCep.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblCep.setBounds(962, 487, 114, 38);
		contentPane.add(lblCep);

		textBairroC = new JTextField();
		textBairroC.setFont(new Font("Krona One", Font.PLAIN, 14));
		textBairroC.setColumns(10);
		textBairroC.setBounds(1086, 487, 233, 38);
		contentPane.add(textBairroC);

		JFrame tela = this;
		
		JButton btnVender = new JButton("Vender");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConfirmacao confirma = new TelaConfirmacao(tela);
				confirma.setVisible(true);
				confirma.setLocationRelativeTo(tela);
				if(confirma.getResult()==true) {
					Venda venda = new Venda();
					String cpfErrado = textCPFC.getText();
					String cpfSemHifens = cpfErrado.replaceAll("-", "");
					String cpfstring = cpfSemHifens.replaceAll("\\.", "");
					cpfstring = cpfstring.trim();
					Long cpf = null;
					if (!cpfstring.isEmpty()) {
						cpf = Long.valueOf(cpfstring);
					}
					venda.setCpfCliente(cpf);
					venda.setCarro(carro);
					Endereco end = new Endereco();
					venda.setEnderecoCliente("Rua " + textRuaC.getText() + ", Bairro " + textBairroC.getText() + ", "
							+ textCidadeC.getText() + ", " + textEstadoC.getText() + ", " + textCepC.getText());
					venda.setFunc(funcdao.passaLogado());
					venda.setNomeCliente(textNomeC.getText());
					venda.setPrecoVenda(carro.getPrecoCarro());
					venda.setTelefoneCliente(Long.valueOf((textTelefoneC.getText())));
					venda.setFormaPagamento(String.valueOf(comboBox.getSelectedItem()));

					String dataNascimento = textDataCompra.getText();

					String primeiroParte = dataNascimento.substring(0, 2);
					String segundaParte = dataNascimento.substring(3, 5);
					String terceiroParte = dataNascimento.substring(6, 10);
					LocalDate dataNascimentoCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
							Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));
					venda.setDataVenda(dataNascimentoCorreta);
					vendadao.inserir(venda);

					TelaVeiculos vei = new TelaVeiculos();
					vei.setExtendedState(MAXIMIZED_BOTH);
					vei.setVisible(true);
					
					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
					
					SendEmail.MandarEmail(textEmailC.getText(), textNomeC.getText(), 2);
					
					dispose();
				} else {
					erro("Venda cancelada!");
				}
			}
		});
		btnVender.setFont(new Font("Krona One", Font.PLAIN, 14));
		btnVender.setBackground(Color.GREEN);
		btnVender.setBounds(1286, 657, 251, 35);
		contentPane.add(btnVender);

		JLabel lblNewLabel_2 = new JLabel("Informação do Carro");
		lblNewLabel_2.setFont(new Font("Krona One", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(474, 60, 340, 63);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel_5.setBounds(889, 60, 5, 678);
		contentPane.add(lblNewLabel_5);

		JLabel lblCpfCliente_1 = new JLabel("Marca:");
		lblCpfCliente_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpfCliente_1.setBounds(451, 141, 106, 38);
		contentPane.add(lblCpfCliente_1);

		textMarca = new JTextField();
		textMarca.setEditable(false);
		textMarca.setFont(new Font("Krona One", Font.PLAIN, 14));
		textMarca.setColumns(10);
		textMarca.setBounds(567, 141, 233, 38);
		contentPane.add(textMarca);
		textMarca.setText(carro.getMarca());
		textMarca.setBackground(Color.WHITE);

		JLabel lblMarca_1 = new JLabel("Modelo:");
		lblMarca_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblMarca_1.setBounds(431, 205, 126, 38);
		contentPane.add(lblMarca_1);

		textModelo = new JTextField();
		textModelo.setEditable(false);
		textModelo.setFont(new Font("Krona One", Font.PLAIN, 14));
		textModelo.setColumns(10);
		textModelo.setBounds(567, 205, 233, 38);
		contentPane.add(textModelo);
		textModelo.setText(carro.getModelo());
		textModelo.setBackground(Color.WHITE);

		JLabel lblCidae_1 = new JLabel("Ano:");
		lblCidae_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblCidae_1.setBounds(478, 272, 79, 38);
		contentPane.add(lblCidae_1);

		textAno = new JTextField();
		textAno.setEditable(false);
		textAno.setFont(new Font("Krona One", Font.PLAIN, 14));
		textAno.setColumns(10);
		textAno.setBounds(567, 271, 233, 38);
		contentPane.add(textAno);
		textAno.setText(String.valueOf(carro.getAno()));
		textAno.setBackground(Color.WHITE);

		JLabel lblQuilometragem = new JLabel("Km:");
		lblQuilometragem.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblQuilometragem.setBounds(490, 335, 67, 38);
		contentPane.add(lblQuilometragem);

		Float num = 5.8f;

		textQuilometragem = new JTextField();
		textQuilometragem.setEditable(false);
		textQuilometragem.setFont(new Font("Krona One", Font.PLAIN, 14));
		textQuilometragem.setColumns(10);
		textQuilometragem.setBounds(567, 335, 233, 38);
		contentPane.add(textQuilometragem);
		textQuilometragem.setText(String.valueOf(carro.getQuilometragem() + " Km"));
		textQuilometragem.setBackground(Color.WHITE);

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblFornecedor.setBounds(347, 399, 210, 38);
		contentPane.add(lblFornecedor);

		textFornecedor = new JTextField();
		textFornecedor.setEditable(false);
		textFornecedor.setFont(new Font("Krona One", Font.PLAIN, 14));
		textFornecedor.setColumns(10);
		textFornecedor.setBounds(567, 399, 233, 38);
		contentPane.add(textFornecedor);
		textFornecedor.setText(forn.getNomeFornecedor());
		textFornecedor.setBackground(Color.WHITE);
		
		textEmailC = new JTextField();
		textEmailC.setFont(new Font("Krona One", Font.PLAIN, 14));
		textEmailC.setColumns(10);
		textEmailC.setBounds(1583, 233, 233, 38);
		contentPane.add(textEmailC);
		
		JLabel lblEmailCliente = new JLabel("Email:");
		lblEmailCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailCliente.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblEmailCliente.setBounds(1449, 233, 124, 38);
		contentPane.add(lblEmailCliente);
		
		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPagamento.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblPagamento.setBounds(1354, 567, 219, 38);
		contentPane.add(lblPagamento);
		
		

	}
	
	private void erro(String string) {
		TelaErro erro = new TelaErro((JFrame) this, string);
		erro.setLocationRelativeTo(null);
		erro.setVisible(true);
	}
}
