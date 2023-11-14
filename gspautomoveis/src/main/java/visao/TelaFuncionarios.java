package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import controle.EnderecoDAO;
import controle.FuncionarioDAO;
import controle.SendEmail;
import modelo.Endereco;
import modelo.Funcionario;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;

public class TelaFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	public static JTextField textUsuario;
	private JTextField textTelefone;
	public static JTextField textSenha;
	private JTextField textEmail;
	private JTextField textDataNasc;
	private JTable table;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textEstado;
	private JTextField textCep;
	private JTextField textCidade;
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();
	private JTextField textComissao;
	private JTextField textSalario;
	private EnderecoDAO enddao = EnderecoDAO.getInstancia();
	private JTextField textId;
	private JPanel panel;

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
		setTitle("Funcionários");
		Funcionario func = new Funcionario();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1119);
		contentPane = new JPanel();
		JButton btnAtualizar = new JButton("Atualizar");
		JButton btnAdicionar = new JButton("Adicionar\r\n");
		btnAdicionar.setVisible(true);
		btnAtualizar.setVisible(false);

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
		
		
		panel_6.setBounds(0, 777, 350, 63);
		contentPane.add(panel_6);
		panel_5.setBounds(0, 913, 350, 63);
		contentPane.add(panel_5);
		panel_4.setBounds(0, 390, 350, 63);
		contentPane.add(panel_4);
		panel_3.setBounds(0, 474, 350, 56);
		contentPane.add(panel_3);
		panel_2.setBounds(0, 554, 350, 52);
		contentPane.add(panel_2);
		panel_1.setBounds(0, 702, 350, 52);
		contentPane.add(panel_1);
		panel.setForeground(new Color(0, 0, 0));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_2.setForeground(new Color(0, 0, 0));
		panel_3.setForeground(new Color(0, 0, 0));
		panel_4.setForeground(new Color(0, 0, 0));
		panel_5.setForeground(new Color(0, 0, 0));
		panel_6.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 629, 350, 52);
		contentPane.add(panel);
		panel.setBackground(new Color(215, 215, 215, 50));
		panel_1.setBackground(new Color(215, 215, 215, 50));
		panel_2.setBackground(new Color(215, 215, 215, 50));
		panel_3.setBackground(new Color(215, 215, 215, 50));
		panel_4.setBackground(new Color(215, 215, 215, 50));
		panel_5.setBackground(new Color(215, 215, 215, 50));
		panel_6.setBackground(new Color(215, 215, 215, 50));
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Home");
		lblNewLabel_4_1_2.setBounds(94, 16, 135, 33);
		panel_6.add(lblNewLabel_4_1_2);
		lblNewLabel_4_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_2.setFont(new Font("Krona One", Font.PLAIN, 26));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(32, 11, 40, 38);
		panel_6.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/casa.png")));

		JComboBox CBCargo = new JComboBox();
		CBCargo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CBCargo.setBorder(blackBorder);
			}
		});
		CBCargo.setModel(new DefaultComboBoxModel(
				new String[] { "", "Administrador", "Gerente de Vendas", "Vendedor", "Gerente de Estoque" }));
		CBCargo.setBounds(876, 93, 305, 38);
		contentPane.add(CBCargo);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botão atualizar
				Funcionario func1 = new Funcionario();
				Endereco end = new Endereco();
				Integer matricula = Integer.valueOf(textId.getText());
				String nome = textNome.getText();
				String email = textEmail.getText();
				String usuario = textUsuario.getText();
				String telefoneErrado = textTelefone.getText();
				String rua = textRua.getText();
				String bairro = textBairro.getText();
				String cidade = textCidade.getText();
				String estado = textEstado.getText();
				Long cep = null;
				try {
					String cepErrado = textCep.getText();

					String cepString = cepErrado.replaceAll("-", "");

					cep = Long.valueOf(cepString);

				} catch (NumberFormatException e1) {
					System.out.println("Erro ao converter para Long: " + e1.getMessage());
				}

				end.setBairro(bairro);
				end.setCep(cep);
				end.setCidade(cidade);
				end.setEstado(estado);
				end.setRua(rua);

				String telefone = textTelefone.getText();
				try {
					telefoneErrado = textTelefone.getText();

					String telefoneLimpo = telefoneErrado.replaceAll("[()\\s-]+", "");
					telefone = telefoneLimpo;
					if (telefoneLimpo.matches("\\d{10,11}")) {
						telefone = telefoneLimpo;
					} else {
						System.out.println("Número de telefone inválido");
					}
				} catch (NumberFormatException e1) {
					System.out.println("Erro ao converter para Long: " + e1.getMessage());
				}
				String cargo = (String) CBCargo.getSelectedItem();
				Double comissao = Double.valueOf(textComissao.getText());
				Double salario = Double.valueOf(textSalario.getText());

				func1.setEndereco(end);
				func1.setMatricula(matricula);
				func1.setNome(nome);
				func1.setEmail(email);
				func1.setUsuario(usuario);
				func1.setTelefone(Long.valueOf(telefone));
				func1.setNivelCargo(cargo);
				func1.setSalario(salario);
				func1.setComissao(comissao);

				funcdao.atualizar(func1);

				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setValueAt(nome, linhaSelecionada, 1);
					model.setValueAt(usuario, linhaSelecionada, 2);
					model.setValueAt(telefone, linhaSelecionada, 3);
					model.setValueAt(cargo, linhaSelecionada, 4);
					model.setValueAt(email, linhaSelecionada, 6);

					// Tela de sucesso de ação
					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
				}

			}
		});

		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBorder(new RoundedBorder(10));
		btnAtualizar.setBackground(new Color(255, 249, 0));
		btnAtualizar.setBounds(1069, 357, 251, 35);
		contentPane.add(btnAtualizar);

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Retirar máscaras de CPF, Data de Nascimento e CEP

				if (textNome.getText().equals("") || textCPF.getText().equals("") || textEmail.getText().equals("")
						|| textUsuario.getText().equals("") || textSenha.getText().equals("")
						|| textTelefone.getText().equals("") || CBCargo.getSelectedIndex() == 0
						|| textDataNasc.getText().equals("") || textRua.getText().equals("")
						|| textCep.getText().equals("") || textBairro.getText().equals("")
						|| textCidade.getText().equals("") || textEstado.getText().equals("")
						|| textComissao.getText().equals("") || textSalario.getText().equals("")) {
					erro("Preencha todos os dados!");
					if (textNome.getText().equals("")) {
						textNome.setBorder(redBorder);
					}
					if (textCPF.getText().equals("")) {
						textCPF.setBorder(redBorder);
					}
					if (textUsuario.getText().equals("")) {
						textUsuario.setBorder(redBorder);
					}
					if (textSenha.getText().equals("")) {
						textSenha.setBorder(redBorder);
					}
					if (textEmail.getText().equals("")) {
						textEmail.setBorder(redBorder);
					}
					if (textTelefone.getText().equals("")) {
						textTelefone.setBorder(redBorder);
					}
					if (CBCargo.getSelectedIndex() == 0) {
						CBCargo.setBorder(redBorder);
					}
					if (textDataNasc.getText().equals("")) {
						textDataNasc.setBorder(redBorder);
					}
					if (textRua.getText().equals("")) {
						textRua.setBorder(redBorder);
					}
					if (textCep.getText().equals("")) {
						textRua.setBorder(redBorder);
					}
					if (textBairro.getText().equals("")) {
						textBairro.setBorder(redBorder);
					}
					if (textCidade.getText().equals("")) {
						textCidade.setBorder(redBorder);
					}
					if (textEstado.getText().equals("")) {
						textEstado.setBorder(redBorder);
					}
					if (textComissao.getText().equals("")) {
						textComissao.setBorder(redBorder);
					}
					if (textSalario.getText().equals("")) {
						textSalario.setBorder(redBorder);
					}
				} else {
					for (Funcionario funcTeste : funcdao.ListarUsuarios()) {
						if (!funcTeste.getUsuario().equals(textUsuario.getText())) {
							Funcionario func1 = new Funcionario();
							String nome = textNome.getText();
							String cpfErrado = textCPF.getText();
							String cpfSemHifens = cpfErrado.replaceAll("-", "");
							String cpfstring = cpfSemHifens.replaceAll("\\.", "");
							cpfstring = cpfstring.trim();
							Long cpf = null;
							if (!cpfstring.isEmpty()) {
								cpf = Long.valueOf(cpfstring);
							}

							String email = textEmail.getText();
							String usuario = textUsuario.getText();
							String senha = textSenha.getText();
							String telefone = textTelefone.getText();
							try {
								String telefoneErrado = textTelefone.getText();

								String telefoneLimpo = telefoneErrado.replaceAll("[()\\s-]+", "");

								if (telefoneLimpo.matches("\\d{10,11}")) {
									telefone = telefoneLimpo;
								} else {
									System.out.println("Número de telefone inválido");
								}
							} catch (NumberFormatException e1) {
								System.out.println("Erro ao converter para Long: " + e1.getMessage());
							}

							String cargo = (String) CBCargo.getSelectedItem();

							String dataNascimento = textDataNasc.getText();

							String primeiroParte = dataNascimento.substring(0, 2);
							String segundaParte = dataNascimento.substring(3, 5);
							String terceiroParte = dataNascimento.substring(6, 10);

							LocalDate dataNascimentoCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
									Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));

							String rua = textRua.getText();
							String estado = textEstado.getText();
							String cidade = textCidade.getText();
							String bairro = textBairro.getText();
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

							Double salario = Double.valueOf(textSalario.getText());
							Double comissao = Double.valueOf(textComissao.getText());

							func1.setNome(nome);
							func1.setCpf(cpf);
							func1.setEmail(email);
							func1.setUsuario(usuario);
							func1.setSenha(senha);
							func1.setTelefone(Long.valueOf(telefone));
							func1.setNivelCargo(cargo);
							func1.setDataDeNasc(dataNascimentoCorreta);
							func1.setSalario(salario);
							func1.setComissao(comissao);

							Endereco end = new Endereco();
							end.setRua(rua);
							end.setCidade(cidade);
							end.setEstado(estado);
							end.setCep(cep);
							end.setBairro(bairro);

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

							func1.setEndereco(end);
							Integer matricula = funcdao.inserir(func1);
							SendEmail.MandarEmail(func1.getEmail(), func1.getNome(), 1);
							System.out.println("Passou");

							textNome.setText("");
							textCPF.setText("");
							textEmail.setText("");
							textUsuario.setText("");
							textSenha.setText("");
							textTelefone.setText("");
							CBCargo.setSelectedIndex(0);

							textRua.setText("");
							textCidade.setText("");
							textEstado.setText("");
							textCep.setText("");
							textBairro.setText("");
							textComissao.setText("");
							textSalario.setText("");

							String data[] = { String.valueOf(matricula), nome, usuario, telefone, cargo,
									textDataNasc.getText(), email };
							textDataNasc.setText("");
							DefaultTableModel tbltable = (DefaultTableModel) table.getModel();
							tbltable.addRow(data);

							TelaSucesso sucesso = new TelaSucesso();
							sucesso.setLocationRelativeTo(null);
							sucesso.setVisible(true);
							break;

						} else {
							erro("Nome de usuário já cadastrado!");
						}

					}
				}

				/*
				 * Configuracao configuracao = new Configuracao();
				 * Configuracao.textUsuario.setText(TelaFuncionarios.textUsuario.getText());
				 * Configuracao.textSen.setText(TelaFuncionarios.textSenha.getText());
				 * configuracao.setVisible(true);
				 */
			}

		});

		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBorder(new RoundedBorder(10));
		btnAdicionar.setBackground(Color.GREEN);
		btnAdicionar.setBounds(1069, 357, 251, 35);
		contentPane.add(btnAdicionar);

		JLabel lblNewLabel_4 = new JLabel("          Veículos");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setVisible(true);

			}
		});
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(0, 390, 350, 63);
		contentPane.add(lblNewLabel_4);

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
		lblNewLabel_2_1_1_1_1_1_1.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/sair.png")));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(39, 928, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);

		JLabel lblNewLabel_3 = new JLabel("Funcionários");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(0, 34, 350, 52);
		contentPane.add(lblNewLabel_3);

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
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/carro +.png")));
		lblNewLabel_2_1_1_1_1.setBounds(39, 708, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1
				.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/carrinho compras.png")));
		lblNewLabel_2_1_1_1.setBounds(39, 636, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("          Histórico");
		lblNewLabel_4_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setVisible(true);
			}
		});
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1.setBounds(0, 629, 350, 52);
		contentPane.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/bau veiculos.png")));
		lblNewLabel_2_1_2.setBounds(39, 401, 40, 35);
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("         Sair");
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
		lblNewLabel_4_1_1_1_1_1_1.setBounds(0, 913, 350, 63);
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("          Funcionários");
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
		lblNewLabel_4_1_1.setBounds(0, 554, 350, 52);
		contentPane.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/Engrenagem.png")));
		lblNewLabel_2_1.setBounds(39, 481, 40, 35);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("          Fornecedores");
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
		lblNewLabel_4_1_1_1_1.setBounds(0, 702, 350, 52);
		contentPane.add(lblNewLabel_4_1_1_1_1);

		JLabel lblNewLabel_4_1 = new JLabel("          Configurações");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setVisible(true);

			}
		});
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1.setBounds(0, 474, 350, 56);
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
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/Pessoa.png")));
		lblNewLabel_2_1_1.setBounds(39, 561, 40, 35);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1.setBounds(85, 132, 175, 190);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel.setBounds(0, -43, 350, 1205);
		contentPane.add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNome.setBounds(420, 34, 108, 38);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf.setBounds(1196, 93, 93, 38);
		contentPane.add(lblCpf);

		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblUsurio.setBounds(862, 32, 163, 38);
		contentPane.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblSenha.setBounds(414, 93, 114, 38);
		contentPane.add(lblSenha);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblTelefone.setBounds(1355, 32, 188, 38);
		contentPane.add(lblTelefone);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblEmail.setBounds(430, 152, 98, 38);
		contentPane.add(lblEmail);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblDataDeNascimento.setBounds(1252, 152, 332, 38);
		contentPane.add(lblDataDeNascimento);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCargo.setBounds(762, 93, 104, 38);
		contentPane.add(lblCargo);

		textNome = new JTextField();
		textNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textNome.setBorder(blackBorder);
			}
		});
		textNome.setForeground(new Color(0, 0, 0));
		textNome.setFont(new Font("Krona One", Font.PLAIN, 12));
		textNome.setBounds(542, 32, 292, 38);
		contentPane.add(textNome);
		textNome.setColumns(10);

		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textCPF = new JFormattedTextField(mascaraCPF);
		textCPF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textCPF.setBorder(blackBorder);
			}
		});
		textCPF.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCPF.setColumns(10);
		textCPF.setBounds(1281, 93, 214, 38);
		contentPane.add(textCPF);

		textUsuario = new JTextField();
		textUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textUsuario.setBorder(blackBorder);
			}
		});
		textUsuario.setFont(new Font("Krona One", Font.PLAIN, 12));
		textUsuario.setColumns(10);
		textUsuario.setBounds(1006, 32, 321, 38);
		contentPane.add(textUsuario);

		MaskFormatter mascaraTel = null;
		try {
			mascaraTel = new MaskFormatter("(##)#####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textTelefone = new JFormattedTextField(mascaraTel);
		textTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textTelefone.setBorder(blackBorder);
			}
		});
		textTelefone.setFont(new Font("Krona One", Font.PLAIN, 12));
		textTelefone.setColumns(10);
		textTelefone.setBounds(1523, 34, 345, 38);
		contentPane.add(textTelefone);

		textSenha = new JTextField();
		textSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textSenha.setBorder(blackBorder);
			}
		});
		textSenha.setFont(new Font("Krona One", Font.PLAIN, 12));
		textSenha.setColumns(10);
		textSenha.setBounds(542, 93, 196, 38);
		contentPane.add(textSenha);

		textEmail = new JTextField();
		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textEmail.setBorder(blackBorder);
			}
		});
		textEmail.setFont(new Font("Krona One", Font.PLAIN, 12));
		textEmail.setColumns(10);
		textEmail.setBounds(542, 152, 675, 38);
		contentPane.add(textEmail);

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textDataNasc = new JFormattedTextField(mascaraData);
		textDataNasc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textDataNasc.setBorder(blackBorder);
			}
		});
		textDataNasc.setFont(new Font("Krona One", Font.PLAIN, 12));
		textDataNasc.setColumns(10);
		textDataNasc.setBounds(1594, 152, 274, 38);
		contentPane.add(textDataNasc);

		// Criação do ScrollPane, JFrame vai dentro
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(414, 403, 1454, 560);
		contentPane.add(scrollPane);

		// Criação da JTable
		table = new JTable();
		table.setFont(new Font("Krona One", Font.PLAIN, 11));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int setar = table.getSelectedRow();
				Integer matricula = Integer.valueOf(table.getModel().getValueAt(setar, 0).toString());
				Funcionario funcC = new Funcionario();

				funcC = funcdao.clicado(matricula);
				funcC.setEndereco(enddao.buscaEndereco(funcC.getEndereco().getIdEndereco()));

				textNome.setText(funcC.getNome());
				textUsuario.setText(funcC.getUsuario());
				textTelefone.setText(String.valueOf(funcC.getTelefone()));
				if (funcC.getNivelCargo().equals("Administrador")) {
					CBCargo.setSelectedIndex(1);
				} else if (funcC.getNivelCargo().equals("Gerente de Vendas")) {
					CBCargo.setSelectedIndex(2);
				} else if (funcC.getNivelCargo().equals("Vendedor")) {
					CBCargo.setSelectedIndex(3);
				} else if (funcC.getNivelCargo().equals("Gerente de Estoque")) {
					CBCargo.setSelectedIndex(4);
				} else {
					CBCargo.setSelectedIndex(0);
				}
				textCPF.setText(getName());
				textSenha.setText(trocarPorAsteriscos(String.valueOf(funcC.getSenha())));
				textEmail.setText(funcC.getEmail());
				textSalario.setText(String.valueOf(funcC.getSalario()));
				textComissao.setText(String.valueOf(funcC.getComissao()));

				textRua.setText(funcC.getEndereco().getRua());
				textCidade.setText(funcC.getEndereco().getCidade());
				textEstado.setText(funcC.getEndereco().getEstado());
				textCPF.setText(String.valueOf(funcC.getCpf()));
				textCep.setText(String.valueOf(funcC.getEndereco().getCep()));
				textBairro.setText(funcC.getEndereco().getBairro());

				textSenha.setEditable(false);
				textCPF.setEditable(false);
				textDataNasc.setEditable(false);
				textRua.setEditable(false);
				textBairro.setEditable(false);
				textCidade.setEditable(false);
				textEstado.setEditable(false);
				textCep.setEditable(false);
				textNome.setEditable(false);
				textUsuario.setEditable(false);
				textTelefone.setEditable(false);
				CBCargo.setEditable(false);
				textEmail.setEditable(false);
				textSalario.setEditable(false);
				textComissao.setEditable(false);
				
				textId.setText(String.valueOf(funcC.getMatricula()));

				String[] partes = String.valueOf(funcC.getDataDeNasc()).split("-");

				String primeiroParte = partes[0];
				String segundaParte = partes[1];
				String terceiroParte = partes[2];

				// Reorganiza as partes da string no formato desejado
				String resultado = terceiroParte + segundaParte + primeiroParte;

				textDataNasc.setText(resultado);

			}
		});

		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Matrícula", "Nome", "Usu\u00E1rio",
				"Telefone", "Cargo", "Data de Nascimento", "Email", "A\u00E7\u00F5es" }));

		for (Funcionario funcs : funcdao.ListarFuncionarios()) {
			String[] partes = String.valueOf(funcs.getDataDeNasc()).split("-");

			String primeiroParte = partes[0];
			String segundaParte = partes[1];
			String terceiroParte = partes[2];

			// Reorganiza as partes da string no formato desejado
			String resultado = terceiroParte + segundaParte + primeiroParte;

			DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
			String data[] = { String.valueOf(funcs.getMatricula()), funcs.getNome(), funcs.getUsuario(),
					String.valueOf(funcs.getTelefone()), funcs.getNivelCargo(), resultado, funcs.getEmail() };
			tblModel.addRow(data);
		}

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblRua.setBounds(460, 211, 72, 38);
		contentPane.add(lblRua);

		textRua = new JTextField();
		textRua.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textRua.setBorder(blackBorder);
			}
		});
		textRua.setFont(new Font("Krona One", Font.PLAIN, 12));
		textRua.setColumns(10);
		textRua.setBounds(542, 211, 196, 38);
		contentPane.add(textRua);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblBairro.setBounds(1118, 211, 104, 38);
		contentPane.add(lblBairro);

		textBairro = new JTextField();
		textBairro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textBairro.setBorder(blackBorder);
			}
		});
		textBairro.setFont(new Font("Krona One", Font.PLAIN, 12));
		textBairro.setColumns(10);
		textBairro.setBounds(1232, 211, 249, 38);
		contentPane.add(textBairro);

		JLabel lblCpf_2_1 = new JLabel("Estado:");
		lblCpf_2_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_1.setBounds(762, 211, 151, 38);
		contentPane.add(lblCpf_2_1);

		textEstado = new JTextField();
		textEstado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textEstado.setBorder(blackBorder);
			}
		});
		textEstado.setFont(new Font("Krona One", Font.PLAIN, 12));
		textEstado.setColumns(10);
		textEstado.setBounds(897, 211, 196, 38);
		contentPane.add(textEstado);

		JLabel lblCpf_2_2 = new JLabel("CEP:");
		lblCpf_2_2.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_2.setBounds(1505, 93, 79, 38);
		contentPane.add(lblCpf_2_2);

		MaskFormatter mascaraCEP = null;
		try {
			mascaraCEP = new MaskFormatter("#####-###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textCep = new JFormattedTextField(mascaraCEP);
		textCep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarCep();
			}

			@Override
			public void focusGained(FocusEvent e) {
				textCep.setBorder(blackBorder);
			}
		});
		textCep.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCep.setColumns(10);
		textCep.setBounds(1582, 93, 175, 38);
		contentPane.add(textCep);

		JLabel lblCpf_2_3 = new JLabel("Cidade:");
		lblCpf_2_3.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_3.setBounds(1505, 211, 151, 38);
		contentPane.add(lblCpf_2_3);

		textCidade = new JTextField();
		textCidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textCidade.setBorder(blackBorder);
			}
		});
		textCidade.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCidade.setColumns(10);
		textCidade.setBounds(1646, 211, 222, 38);
		contentPane.add(textCidade);

		textComissao = new JTextField();
		textComissao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textComissao.setBorder(blackBorder);
			}
		});
		textComissao.setFont(new Font("Krona One", Font.PLAIN, 12));
		textComissao.setColumns(10);
		textComissao.setBounds(941, 271, 196, 38);
		contentPane.add(textComissao);

		JLabel lblCpf_2_2_1 = new JLabel("Comissão:");
		lblCpf_2_2_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_2_1.setBounds(762, 271, 175, 38);
		contentPane.add(lblCpf_2_2_1);

		JLabel lblCpf_2_1_1 = new JLabel("Salário:");
		lblCpf_2_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_1_1.setBounds(409, 271, 123, 38);
		contentPane.add(lblCpf_2_1_1);

		textSalario = new JTextField();
		textSalario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textSalario.setBorder(blackBorder);
			}
		});
		textSalario.setFont(new Font("Krona One", Font.PLAIN, 12));
		textSalario.setColumns(10);
		textSalario.setBounds(542, 271, 196, 38);
		contentPane.add(textSalario);

		// Mudando o tamanho da coluna 7 (Ações)
		table.getColumnModel().getColumn(6).setPreferredWidth(1);
		JFrame essaJanela = this;
		TableActionEvent event = new TableActionEvent() {

			@Override
			public void onEdit(int row) {
				btnAtualizar.setVisible(true);
				btnAdicionar.setVisible(false);
			}

			@Override
			public void onDelete(int row) {

				int linhaSelecionada = table.getSelectedRow();
				Integer matricula = Integer.valueOf(table.getModel().getValueAt(linhaSelecionada, 0).toString());

				// select no banco só pelo nome da matricula
				// buscaFuncionarioPorMatricula(matricula);
				// metodo retorna um Funcionario

				Funcionario funcDelete = new Funcionario();
				funcDelete = funcdao.clicado(matricula);

				// quer excluir mesmo?
				// FALTA COLOCAR CONFIRMAÇÃO

				TelaConfirmacao confirma = new TelaConfirmacao(essaJanela);
				confirma.setLocationRelativeTo(essaJanela);
				confirma.setVisible(true);
				if (confirma.getResult() == true) {
					funcdao.excluir(funcDelete);

					// remove a linha da tabela (visualmente)
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

			}
		};
		table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
		table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
		table.setRowHeight(60);

		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Quando clicar na página, os botões e textFields desativados voltam a ser
				// ativos e editaveis
				btnAdicionar.setVisible(true);
				btnAtualizar.setVisible(false);
				textSenha.setEditable(true);
				textCPF.setEditable(true);
				textDataNasc.setEditable(true);
				textRua.setEditable(true);
				textCidade.setEditable(true);
				textCep.setEditable(true);
				textEstado.setEditable(true);
				textBairro.setEditable(true);
				
			}
		});

		JLabel lblIdFunc = new JLabel("Id:");
		lblIdFunc.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblIdFunc.setBounds(1154, 271, 40, 38);
		contentPane.add(lblIdFunc);

		textId = new JTextField();
		textId.setEditable(false);
		textId.setFont(new Font("Krona One", Font.PLAIN, 12));
		textId.setColumns(10);
		textId.setBounds(1196, 271, 98, 38);
		contentPane.add(textId);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Krona One", Font.PLAIN, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnBuscar.setBounds(1767, 93, 101, 38);
		btnBuscar.setBorder(new RoundedBorder(20));
		btnBuscar.setBackground(Color.WHITE);
		contentPane.add(btnBuscar);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textId.setText("");
				textNome.setText("");
				textEmail.setText("");
				textUsuario.setText("");
				textTelefone.setText("");
				textRua.setText("");
				textBairro.setText("");
				textCidade.setText("");
				textEstado.setText("");
				textCep.setText("");
				textDataNasc.setText("");
				textCPF.setText("");
				textSalario.setText("");
				textComissao.setText("");
				textSenha.setText("");
				CBCargo.setSelectedIndex(0);
				
				btnAdicionar.setVisible(true);
				btnAtualizar.setVisible(false);
				textSenha.setEditable(true);
				textCPF.setEditable(true);
				textDataNasc.setEditable(true);
				textRua.setEditable(true);
				textCidade.setEditable(true);
				textCep.setEditable(true);
				textEstado.setEditable(true);
				textBairro.setEditable(true);
				textNome.setEditable(true);
				textUsuario.setEditable(true);
				textEmail.setEditable(true);
				textTelefone.setEditable(true);
				textComissao.setEditable(true);
				textSalario.setEditable(true);
				CBCargo.setEditable(true);

			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/419660 (1).png")));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(1304, 271, 56, 38);
		contentPane.add(btnNewButton);

	}

	public static String trocarPorAsteriscos(String palavra) {
		StringBuilder resultado = new StringBuilder();

		for (int i = 0; i < palavra.length(); i++) {
			resultado.append('*');
		}

		return resultado.toString();
	}

	private void buscarCep() {
		String logradouro = "";
		String tipoLogradoro = "";
		String resultado = null;
		Long cepS = null;
		try {
			String cepErrado = textCep.getText();
			String cepString = cepErrado.replaceAll("-", "");
			cepS = Long.valueOf(cepString);
		} catch (NumberFormatException e1) {
			System.out.println("Erro ao converter para Long: " + e1.getMessage());
		}
		String cep = String.valueOf(cepS);

		try {
			URL url = new URL(" http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					textCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					textBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					textEstado.setText(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradoro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
					} else {
						erro("CEP inválido!");
					}
				}
				textRua.setText(tipoLogradoro + " " + logradouro);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void erro(String string) {
		TelaErro erro = new TelaErro((JFrame) this, string);
		erro.setLocationRelativeTo(null);
		erro.setVisible(true);
	}
	
}
