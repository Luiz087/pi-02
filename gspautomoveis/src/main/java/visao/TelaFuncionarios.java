package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.AbstractButton;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.EnderecoDAO;
import controle.FuncionarioDAO;
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
		JButton btnAtualizar = new JButton("Atualizar");
		JButton btnAdicionar = new JButton("Adicionar\r\n");
		btnAdicionar.setVisible(true);
		btnAtualizar.setVisible(false);
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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JComboBox CBCargo = new JComboBox();
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
				// Botão adicionar
				Funcionario func1 = new Funcionario();
				String nome = textNome.getText();
				String cpfErrado = textCPF.getText();
				String cpfSemHifens = cpfErrado.replaceAll("-", "");
				String cpfstring = cpfSemHifens.replaceAll("\\.", "");
				Long cpf = Long.valueOf(cpfstring);
				
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
				String dataNascimentoSemTraco = dataNascimento.replaceAll("-", "");
				String dataNascimentoCorreta = dataNascimentoSemTraco.replaceAll("\\.", "");

				String rua = textRua.getText();
				String estado = textEstado.getText();
				String cidade = textCidade.getText();
				String bairro = textBairro.getText();
				Long cep = null;
				try {
				    String cepErrado = textCep.getText();
				    
				    String cepString = cepErrado.replaceAll("-", "");
				    
				    cep = Long.valueOf(cepString);
				    
				    
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

				func1.setEndereco(end);

				if (nome.equals("") || cpf.equals("") || email.equals("") || usuario.equals("") || senha.equals("")
						|| telefone.equals("") || cargo.equals("") || dataNascimento.equals("") || rua.equals("")
						|| cep.equals("") || bairro.equals("") || cidade.equals("") || estado.equals("")
						|| comissao.equals("") || salario.equals("")) {
					System.out.print("mal");
				} else {

					System.out.println("Até aqui sim");

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

					System.out.println("Passou");

					textNome.setText("");
					textCPF.setText("");
					textEmail.setText("");
					textUsuario.setText("");
					textSenha.setText("");
					textTelefone.setText("");
					CBCargo.setSelectedIndex(0);
					textDataNasc.setText("");
					textRua.setText("");
					textCidade.setText("");
					textEstado.setText("");
					textCep.setText("");
					textBairro.setText("");
					textComissao.setText("");
					textSalario.setText("");
					
					String data[] = {String.valueOf(matricula), nome, usuario, telefone, cargo, dataNascimento, email };

					DefaultTableModel tbltable = (DefaultTableModel) table.getModel();
					tbltable.addRow(data);

					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
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

		JLabel lblNewLabel_4 = new JLabel("Veículos");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(85, 401, 265, 35);
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

		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 57));
		lblNewLabel_3.setBounds(85, 34, 166, 72);
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

		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Sistema");
		lblNewLabel_4_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1_1_1.setBounds(85, 791, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1
				.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/carrinho compras.png")));
		lblNewLabel_2_1_1_1.setBounds(39, 636, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Histórico");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1.setBounds(85, 636, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/bau veiculos.png")));
		lblNewLabel_2_1_2.setBounds(39, 401, 40, 35);
		contentPane.add(lblNewLabel_2_1_2);

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
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_1_1_1_1_1_1.setBounds(85, 927, 93, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1);

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
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1.setBounds(85, 561, 265, 35);
		contentPane.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/Engrenagem.png")));
		lblNewLabel_2_1.setBounds(39, 481, 40, 35);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1
				.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/Sistema.png")));
		lblNewLabel_2_1_1_1_1_1.setBounds(39, 791, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);

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
		lblNewLabel_4_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1_1.setBounds(85, 708, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1);

		JLabel lblNewLabel_4_1 = new JLabel("Configurações");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1.setBounds(85, 481, 265, 35);
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
		lblDataDeNascimento.setBounds(1241, 152, 332, 38);
		contentPane.add(lblDataDeNascimento);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCargo.setBounds(762, 93, 104, 38);
		contentPane.add(lblCargo);

		textNome = new JTextField();
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
		textCPF.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCPF.setColumns(10);
		textCPF.setBounds(1281, 93, 214, 38);
		contentPane.add(textCPF);

		textUsuario = new JTextField();
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
		textTelefone.setFont(new Font("Krona One", Font.PLAIN, 12));
		textTelefone.setColumns(10);
		textTelefone.setBounds(420, 345, 345, 38);
		contentPane.add(textTelefone);

		textSenha = new JTextField();
		textSenha.setFont(new Font("Krona One", Font.PLAIN, 12));
		textSenha.setColumns(10);
		textSenha.setBounds(542, 93, 196, 38);
		contentPane.add(textSenha);

		textEmail = new JTextField();
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
		textDataNasc.setFont(new Font("Krona One", Font.PLAIN, 12));
		textDataNasc.setColumns(10);
		textDataNasc.setBounds(784, 345, 274, 38);
		contentPane.add(textDataNasc);

		// Criação do ScrollPane, JFrame vai dentro
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 403, 961, 257);
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
				textId.setText(String.valueOf(funcC.getMatricula()));

				String[] partes = funcC.getDataDeNasc().split("-");

				String primeiroParte = partes[0];
				String segundaParte = partes[1];
				String terceiroParte = partes[2];

				// Reorganiza as partes da string no formato desejado
				String resultado = terceiroParte + "/" + segundaParte + "/" + primeiroParte;

				textDataNasc.setText(resultado);

			}
		});

		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Matrícula", "Nome", "Usu\u00E1rio",
				"Telefone", "Cargo", "Data de Nascimento", "Email", "A\u00E7\u00F5es" }));

		for (Funcionario funcs : funcdao.ListarFuncionarios()) {
			DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
			String data[] = { String.valueOf(funcs.getMatricula()), funcs.getNome(), funcs.getUsuario(),
					String.valueOf(funcs.getTelefone()), funcs.getNivelCargo(), funcs.getDataDeNasc(),
					funcs.getEmail() };
			tblModel.addRow(data);
		}

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblRua.setBounds(460, 211, 72, 38);
		contentPane.add(lblRua);

		textRua = new JTextField();
		textRua.setFont(new Font("Krona One", Font.PLAIN, 12));
		textRua.setColumns(10);
		textRua.setBounds(542, 211, 196, 38);
		contentPane.add(textRua);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblBairro.setBounds(1118, 211, 104, 38);
		contentPane.add(lblBairro);

		textBairro = new JTextField();
		textBairro.setFont(new Font("Krona One", Font.PLAIN, 12));
		textBairro.setColumns(10);
		textBairro.setBounds(1232, 211, 249, 38);
		contentPane.add(textBairro);

		JLabel lblCpf_2_1 = new JLabel("Estado:");
		lblCpf_2_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_1.setBounds(762, 211, 151, 38);
		contentPane.add(lblCpf_2_1);

		textEstado = new JTextField();
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
		textCep =  new JFormattedTextField(mascaraCEP);
		textCep.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCep.setColumns(10);
		textCep.setBounds(725, 307, 274, 38);
		contentPane.add(textCep);

		JLabel lblCpf_2_3 = new JLabel("Cidade:");
		lblCpf_2_3.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_3.setBounds(1505, 211, 151, 38);
		contentPane.add(lblCpf_2_3);

		textCidade = new JTextField();
		textCidade.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCidade.setColumns(10);
		textCidade.setBounds(1640, 211, 222, 38);
		contentPane.add(textCidade);

		textComissao = new JTextField();
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
		textSalario.setFont(new Font("Krona One", Font.PLAIN, 12));
		textSalario.setColumns(10);
		textSalario.setBounds(542, 271, 196, 38);
		contentPane.add(textSalario);

		// Mudando o tamanho da coluna 7 (Ações)
		table.getColumnModel().getColumn(6).setPreferredWidth(1);

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

				funcdao.excluir(funcDelete);

				// remove a linha da tabela (visualmente)
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(row);

				// tela de sucesso de ação
				TelaSucesso sucesso = new TelaSucesso();
				sucesso.setLocationRelativeTo(null);
				sucesso.setVisible(true);
			}
 
		@Override
			public void onView(int row) {
			// TODO Auto-generated method stub

			}
		};
		table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
		table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
		table.setRowHeight(60);

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

	}

	public static String trocarPorAsteriscos(String palavra) {
		StringBuilder resultado = new StringBuilder();

		for (int i = 0; i < palavra.length(); i++) {
			resultado.append('*');
		}

		return resultado.toString();
	}
}
