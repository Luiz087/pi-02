package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.EnderecoDAO;
import controle.FornecedorDAO;
import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Funcionario;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

public class TelaFornecedores extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textTel;
	private JTextField textCNPJ;
	private JTextField textMarca;
	private JTextField textCidade;
	private JTable table;
	private JTextField textEstado;
	private JTextField textBairro;
	private JTextField textRua;
	private JTextField textCep;
	private EnderecoDAO enddao = EnderecoDAO.getInstancia();
	private FornecedorDAO forndao = FornecedorDAO.getInstancia();
	private JTextField textEmpresa;
	private JTextField textId;
	private JPanel panel;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedores frame = new TelaFornecedores();
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
	public TelaFornecedores() {
		setTitle("Fornecedores");

		Fornecedor fornec = new Fornecedor();
		Endereco end = new Endereco();

		Color color = new Color(68, 117, 157);
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
				TelaHistoricoVeiculos telaHV = new TelaHistoricoVeiculos();
				dispose();
				telaHV.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaHV.setVisible(true);

			}
		});

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

		JPanel panel_6 = new JPanel();
		panel_6.setVisible(false);
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPrincipal prin = new TelaPrincipal();
				dispose();
				prin.setLocationRelativeTo(null);
				prin.setVisible(true);
			}
		});

		LineBorder redBorder = new LineBorder(Color.RED);
		LineBorder blackBorder = new LineBorder(Color.BLACK);

		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Home");
		lblNewLabel_4_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_2.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1_2.setBounds(61, 835, 278, 52);
		contentPane.add(lblNewLabel_4_1_1_1_2);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/casa.png")));
		lblNewLabel.setBounds(22, 842, 40, 35);
		contentPane.add(lblNewLabel);

		panel_6.setBounds(0, 824, 340, 63);
		contentPane.add(panel_6);

		panel_5.setBounds(0, 967, 340, 63);
		contentPane.add(panel_5);
		panel_4.setBounds(0, 439, 340, 63);
		contentPane.add(panel_4);
		panel_3.setBounds(0, 526, 340, 56);
		contentPane.add(panel_3);
		panel_2.setBounds(0, 610, 340, 52);
		contentPane.add(panel_2);
		panel_1.setBounds(0, 759, 340, 52);
		contentPane.add(panel_1);
		panel.setForeground(new Color(0, 0, 0));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_2.setForeground(new Color(0, 0, 0));
		panel_3.setForeground(new Color(0, 0, 0));
		panel_4.setForeground(new Color(0, 0, 0));
		panel_5.setForeground(new Color(0, 0, 0));
		panel_6.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 684, 340, 52);
		contentPane.add(panel);
		panel.setBackground(new Color(215, 215, 215, 50));
		panel_1.setBackground(new Color(215, 215, 215, 50));
		panel_2.setBackground(new Color(215, 215, 215, 50));
		panel_3.setBackground(new Color(215, 215, 215, 50));
		panel_4.setBackground(new Color(215, 215, 215, 50));
		panel_5.setBackground(new Color(215, 215, 215, 50));
		panel_6.setBackground(new Color(215, 215, 215, 50));

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor forn1 = new Fornecedor();
				Endereco end1 = new Endereco();

				Integer id = Integer.valueOf(textId.getText());
				String nome = textNome.getText();
				Long telefone = Long.parseLong(textTel.getText());
				String empresa = textEmpresa.getText();
				Long Cep = Long.parseLong(textCep.getText());
				Long Cnpj = Long.parseLong(textCNPJ.getText());
				String estado = textEstado.getText();
				String cidade = textCidade.getText();
				String rua = textRua.getText();
				String bairro = textBairro.getText();
				String marca = textMarca.getText();

				end1.setBairro(bairro);
				end1.setCep(Cep);
				end1.setCidade(cidade);
				end1.setEstado(estado);
				end1.setRua(rua);

				forn1.setMarca(marca);
				forn1.setIdFornecedor(id);
				forn1.setNomeFornecedor(nome);
				forn1.setTelefoneFornecedor(telefone);
				forn1.setEmpresa(empresa);
				forn1.setCnpjfornecedor(Cnpj);
				forn1.setEndereco(end1);

				forndao.atualizar(forn1);

				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setValueAt(nome, linhaSelecionada, 1);
					model.setValueAt(telefone, linhaSelecionada, 2);
					model.setValueAt(Cnpj, linhaSelecionada, 3);
					model.setValueAt(marca, linhaSelecionada, 4);
					model.setValueAt(empresa, linhaSelecionada, 6);

					// Tela de sucesso de ação
					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
				}
			}
		});
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 20));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBorder(new RoundedBorder(10));
		btnAtualizar.setBackground(new Color(255, 255, 0));
		btnAtualizar.setBounds(982, 360, 251, 35);
		contentPane.add(btnAtualizar);

		JButton btnAdicionar = new JButton("Adicionar\r\n");
		btnAdicionar.setBackground(new Color(0, 255, 0));
		btnAdicionar.setForeground(new Color(0, 0, 0));
		btnAdicionar.setFont(new Font("Krona One", Font.PLAIN, 20));

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNome.getText().equals("") || textTel.getText().equals("") || textCNPJ.getText().equals("")
						|| textMarca.getText().equals("") || textCidade.getText().equals("")
						|| textBairro.getText().equals("") || textEstado.getText().equals("")
						|| textCep.getText().equals("") || textRua.getText().equals("")) {
					erro("Preencha todos os campos!");
				}
				if (textNome.getText().equals("")) {
					textNome.setBorder(redBorder);
				}
				if (textTel.getText().equals("")) {
					textTel.setBorder(redBorder);
				}
				if (textCNPJ.getText().equals("")) {
					textCNPJ.setBorder(redBorder);
				}
				if (textMarca.getText().equals("")) {
					textMarca.setBorder(redBorder);
				}
				if (textCidade.getText().equals("")) {
					textCidade.setBorder(redBorder);
				}
				if (textBairro.getText().equals("")) {
					textBairro.setBorder(redBorder);
				}
				if (textEstado.getText().equals("")) {
					textEstado.setBorder(redBorder);
				}
				if (textCep.getText().equals("")) {
					textCep.setBorder(redBorder);
				}
				if (textRua.getText().equals("")) {
					textRua.setBorder(redBorder);
				}
				if (textCep.getText().equals("")) {
					textRua.setBorder(redBorder);
				}
				if (textEmpresa.getText().equals("")) {
					textEmpresa.setBorder(redBorder);
				} else {
					String cnpj = textCNPJ.getText();
					for (Fornecedor forn : forndao.ListarCNPJ()) {
						if (!cnpj.isEmpty()) {
							if (!forn.getCnpjfornecedor().equals(cnpj)) {

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

								Long cep = null;
								try {
									String cepErrado = textCep.getText();

									String cepString = cepErrado.replaceAll("-", "");

									cepString = cepString.trim();

									if (!cepString.isEmpty()) {
										cep = Long.valueOf(cepString);

									}

								} catch (NumberFormatException e1) {
									System.out.println("Erro ao converter para Long: " + e1.getMessage());
								}

								String cnpjErrado = textCNPJ.getText();
								if (!cnpjErrado.isEmpty()) {
									try {

										String cnpjString = cnpjErrado.replaceAll("-", "");

										cnpjString = cnpjString.trim();

										Long conpj2 = Long.valueOf(cnpjString);
										fornec.setCnpjfornecedor(Long.valueOf(cnpjErrado));

									} catch (NumberFormatException e1) {
										System.out.println("Erro ao converter para Long: " + e1.getMessage());
									}
								}

								fornec.setNomeFornecedor(textNome.getText());
								fornec.setEmpresa(textEmpresa.getText());
								fornec.setTelefoneFornecedor(Long.valueOf(telefone));
								fornec.setMarca(textMarca.getText());
								end.setCidade(textCidade.getText());
								end.setRua(textRua.getText());
								end.setBairro(textBairro.getText());
								end.setEstado(textEstado.getText());
								end.setCep(Long.valueOf(cep));
								fornec.setEndereco(end);

								Endereco verificacaoEnd = enddao.buscaEnderecoByAtributo(end);
								if (verificacaoEnd == null) {
									/*
									 * Se o endereco for null Significa que nao encontrou nada no BD
									 */
									Integer idend = enddao.inserir(end);
									end.setIdEndereco(idend);
								} else {
									/*
									 * Se o endereco nao eh null significa que ja esta cadastrado
									 */
									end.setIdEndereco(verificacaoEnd.getIdEndereco());
								}

								fornec.setEndereco(end);
								Integer id = forndao.inserir(fornec);

								String data[] = { String.valueOf(id), textNome.getText(), textTel.getText(),
										textCNPJ.getText(), textMarca.getText(), textCidade.getText(),
										textEmpresa.getText() };

								// criar as linhas quando adicionar o fornecedor
								DefaultTableModel tbltable = (DefaultTableModel) table.getModel();
								tbltable.addRow(data);

								System.out.println("Passou");

								System.out.print("Deu boa");
								// limpar apos clicar no botão
								textNome.setText("");
								textTel.setText("");
								textCNPJ.setText("");
								textMarca.setText("");
								textCidade.setText("");
								textBairro.setText("");
								textEstado.setText("");
								textRua.setText("");
								textCep.setText("");
								textEmpresa.setText("");
							} else {
								erro("Nome de usuário já cadastrado!");
							}
						}
					}
				}
			}
		});

		btnAdicionar.setBounds(982, 360, 251, 35);
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBorder(new RoundedBorder(10));

		contentPane.add(btnAdicionar);

		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAtualizar.setVisible(false);
				btnAdicionar.setVisible(true);

			}
		});

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1_1.setBounds(78, 193, 175, 190);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpresa.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblEmpresa.setBounds(846, 205, 199, 70);
		contentPane.add(lblEmpresa);

		textEmpresa = new JTextField();
		textEmpresa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textEmpresa.setBorder(blackBorder);
			}
		});
		textEmpresa.setFont(new Font("Krona One", Font.PLAIN, 12));
		textEmpresa.setColumns(10);
		textEmpresa.setBounds(1053, 219, 324, 38);
		contentPane.add(textEmpresa);

		JLabel lblNewLabel_3 = new JLabel("Fornecedores");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 36));
		lblNewLabel_3.setBounds(0, 23, 399, 87);
		contentPane.add(lblNewLabel_3);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNome.setBounds(360, 53, 138, 35);
		contentPane.add(lblNome);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnpj.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblCnpj.setBounds(382, 205, 116, 70);
		contentPane.add(lblCnpj);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblCidade.setBounds(1143, 113, 151, 70);
		contentPane.add(lblCidade);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblMarca.setBounds(1411, 26, 138, 70);
		contentPane.add(lblMarca);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblTelefone.setBounds(842, 26, 190, 70);
		contentPane.add(lblTelefone);

		textNome = new JTextField();
		textNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textNome.setBorder(blackBorder);
			}
		});
		textNome.setFont(new Font("Krona One", Font.PLAIN, 12));
		textNome.setBounds(508, 49, 324, 38);
		contentPane.add(textNome);
		textNome.setColumns(10);

		MaskFormatter mascaraTel = null;
		try {
			mascaraTel = new MaskFormatter("(##)#####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textTel = new JFormattedTextField(mascaraTel);
		textTel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textTel.setBorder(blackBorder);
			}
		});
		textTel.setFont(new Font("Krona One", Font.PLAIN, 12));
		textTel.setColumns(10);
		textTel.setBounds(1042, 40, 335, 38);
		contentPane.add(textTel);

		MaskFormatter mascaraCNPJ = null;
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textCNPJ = new JFormattedTextField(mascaraCNPJ);
		textCNPJ.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textCNPJ.setBorder(blackBorder);
			}
		});
		textCNPJ.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCNPJ.setColumns(10);
		textCNPJ.setBounds(508, 219, 324, 38);
		contentPane.add(textCNPJ);

		textMarca = new JTextField();
		textMarca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textMarca.setBorder(blackBorder);
			}
		});
		textMarca.setFont(new Font("Krona One", Font.PLAIN, 12));
		textMarca.setColumns(10);
		textMarca.setBounds(1559, 36, 299, 38);
		contentPane.add(textMarca);

		textCidade = new JTextField();
		textCidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textCidade.setBorder(blackBorder);
			}
		});
		textCidade.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCidade.setColumns(10);
		textCidade.setBounds(1304, 130, 175, 38);
		contentPane.add(textCidade);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/Engrenagem.png")));
		lblNewLabel_2_1.setBounds(28, 536, 40, 35);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_4_1 = new JLabel("         Configurações");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setVisible(true);

			}
		});
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1.setBounds(0, 526, 339, 56);
		contentPane.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4 = new JLabel("         Veículos");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setVisible(true);

			}
		});
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(0, 439, 339, 63);
		contentPane.add(lblNewLabel_4);

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
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/Pessoa.png")));
		lblNewLabel_2_1_1.setBounds(28, 616, 40, 35);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/bau veiculos.png")));
		lblNewLabel_2_1_2.setBounds(28, 456, 40, 35);
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("         Histórico");
		lblNewLabel_4_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setVisible(true);
			}
		});
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1.setBounds(0, 684, 339, 52);
		contentPane.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1
				.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/carrinho compras.png")));
		lblNewLabel_2_1_1_1.setBounds(28, 691, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("         Funcionários");
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
		lblNewLabel_4_1_1.setBounds(0, 610, 339, 52);
		contentPane.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("         Fornecedores");
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
		lblNewLabel_4_1_1_1_1.setBounds(0, 759, 339, 52);
		contentPane.add(lblNewLabel_4_1_1_1_1);

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
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/carro +.png")));
		lblNewLabel_2_1_1_1_1.setBounds(28, 763, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("      Sair");
		lblNewLabel_4_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin telalogin = new TelaLogin();
				dispose();
				telalogin.setLocationRelativeTo(null);
				telalogin.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setVisible(true);

			}
		});
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_1_1_1_1_1_1.setBounds(0, 967, 340, 63);
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1);

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
		lblNewLabel_2_1_1_1_1_1_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/sair.png")));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(10, 983, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(-11, 0, 361, 1041);
		contentPane.add(lblNewLabel_1);

		// posição do Jpanel
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(369, 422, 1484, 550);
		contentPane.add(scrollPane);
		// cadastrar nome das colunas
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int setar = table.getSelectedRow();

				Fornecedor fornC = new Fornecedor();
				Integer IdFornecedor = Integer.valueOf(table.getModel().getValueAt(setar, 0).toString());
				Fornecedor forn = new Fornecedor();
				forn.setIdFornecedor(IdFornecedor);
				fornC = forndao.buscaFornecedor(forn);
				fornC.setEndereco(enddao.buscaEndereco(fornC.getEndereco().getIdEndereco()));

				textId.setText(String.valueOf(fornC.getIdFornecedor()));
				textNome.setText(fornC.getNomeFornecedor());
				textTel.setText(String.valueOf(fornC.getTelefoneFornecedor()));
				textMarca.setText(fornC.getMarca());
				textCidade.setText(fornC.getEndereco().getCidade());
				textCNPJ.setText(String.valueOf(fornC.getCnpjfornecedor()));
				textEmpresa.setText(fornC.getEmpresa());

				textBairro.setText(fornC.getEndereco().getBairro());
				textEstado.setText(fornC.getEndereco().getEstado());
				textRua.setText(fornC.getEndereco().getRua());
				textCep.setText(String.valueOf(fornC.getEndereco().getCep()));

			}
		});
		table.setFont(new Font("Krona One", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Telefone", "CNPJ", "Marca", "Cidade", "Empresa", "A\u00E7\u00F5es" }));
		for (Fornecedor forncs : forndao.ListarFornecedores()) {
			DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
			Endereco endF = enddao.buscaEndereco(forncs.getIdFornecedor());
			String data[] = { String.valueOf(forncs.getIdFornecedor()), forncs.getNomeFornecedor(),
					String.valueOf(forncs.getTelefoneFornecedor()), String.valueOf(forncs.getCnpjfornecedor()),
					forncs.getMarca(), endF.getCidade(), forncs.getEmpresa() };
			tblModel.addRow(data);
		}

		table.getColumnModel().getColumn(7).setPreferredWidth(155);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRua.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblRua.setBounds(1401, 202, 92, 76);
		contentPane.add(lblRua);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblEstado.setBounds(349, 113, 151, 70);
		contentPane.add(lblEstado);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblBairro.setBounds(1483, 116, 136, 70);
		contentPane.add(lblBairro);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblCep.setBounds(846, 121, 93, 60);
		contentPane.add(lblCep);

		textEstado = new JTextField();
		textEstado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textEstado.setBorder(blackBorder);
			}
		});
		textEstado.setFont(new Font("Krona One", Font.PLAIN, 12));
		textEstado.setColumns(10);
		textEstado.setBounds(508, 126, 324, 38);
		contentPane.add(textEstado);

		textBairro = new JTextField();
		textBairro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textBairro.setBorder(blackBorder);
			}
		});
		textBairro.setFont(new Font("Krona One", Font.PLAIN, 12));
		textBairro.setColumns(10);
		textBairro.setBounds(1629, 127, 229, 38);
		contentPane.add(textBairro);

		textRua = new JTextField();
		textRua.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textRua.setBorder(blackBorder);
			}
		});
		textRua.setFont(new Font("Krona One", Font.PLAIN, 12));
		textRua.setColumns(10);
		textRua.setBounds(1503, 219, 355, 38);
		contentPane.add(textRua);

		MaskFormatter mascaraCEP = null;
		try {
			mascaraCEP = new MaskFormatter("#####-### ");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textCep = new JFormattedTextField(mascaraCEP);

		textCep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textCep.setBorder(blackBorder);
			}
		});
		textCep.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCep.setColumns(10);
		textCep.setBounds(949, 130, 175, 38);
		contentPane.add(textCep);
		JFrame essaJanela = this;

		TableActionEvent event = new TableActionEvent() {

			@Override
			public void onEdit(int row) {
				btnAtualizar.setVisible(true);
				btnAdicionar.setVisible(false);
				textRua.setEditable(false);
				textBairro.setEditable(false);
				textCidade.setEditable(false);
				textEstado.setEditable(false);
				textCep.setEditable(false);
			}

			@Override
			public void onDelete(int row) {

				int linhaSelecionada = table.getSelectedRow();
				Integer IdFornecedor = Integer.valueOf(table.getModel().getValueAt(linhaSelecionada, 0).toString());

				TelaConfirmacao confirma = new TelaConfirmacao(essaJanela);
				confirma.setVisible(true);
				confirma.setLocationRelativeTo(null);
				if (confirma.getResult() == true) {
					forndao.excluir(IdFornecedor);

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.removeRow(row);

					// tela de sucesso de ação
					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
				} else {
					erro("Ação cancelada!");
				}
			}

			@Override
			public void onView(int row) {
				// TODO Auto-generated method stub

			}
		};
		table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
		table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
		table.setRowHeight(60);

		JLabel lblID = new JLabel("ID:");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblID.setBounds(448, 286, 50, 70);
		contentPane.add(lblID);

		textId = new JTextField();
		textId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textId.setBorder(blackBorder);
			}
		});
		textId.setEditable(false);
		textId.setFont(new Font("Krona One", Font.PLAIN, 12));
		textId.setColumns(10);
		textId.setBounds(508, 298, 127, 38);
		contentPane.add(textId);

		btnAtualizar.setVisible(false);
		btnAdicionar.setVisible(true);

	}

	private void erro(String string) {
		TelaErro erro = new TelaErro(this, null);
		erro.setLocationRelativeTo(null);
		erro.setVisible(true);
	}
}
