package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

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

		JComboBox CBCargo = new JComboBox();
		CBCargo.setModel(new DefaultComboBoxModel(
				new String[] { "", "Administrador", "Gerente de Vendas", "Vendedor", "Gerente de Estoque" }));
		CBCargo.setBounds(876, 93, 305, 38);
		contentPane.add(CBCargo);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblDataDeNascimento.setBounds(1241, 152, 415, 38);
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
//		
//		MaskFormatter mascaraCPF = null;
//		try {
//			mascaraCPF = new MaskFormatter("###.###.###-##");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		textCPF = new JFormattedTextField(mascaraCPF);
		textCPF = new JTextField();
		textCPF.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCPF.setColumns(10);
		textCPF.setBounds(1281, 93, 214, 38);
		contentPane.add(textCPF);

		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Krona One", Font.PLAIN, 12));
		textUsuario.setColumns(10);
		textUsuario.setBounds(1006, 32, 321, 38);
		contentPane.add(textUsuario);
//		
//		MaskFormatter mascaraTel = null;
//		try {
//			mascaraTel = new MaskFormatter("(##)#####-####");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		textTelefone = new JFormattedTextField(mascaraTel);
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Krona One", Font.PLAIN, 12));
		textTelefone.setColumns(10);
		textTelefone.setBounds(1517, 32, 345, 38);
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
		textDataNasc.setBounds(1588, 152, 274, 38);
		contentPane.add(textDataNasc);

		// Criação do ScrollPane, JFrame vai dentro
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 414, 1463, 593);
		contentPane.add(scrollPane);

		// Criação da JTable
		table = new JTable();
		table.setFont(new Font("Krona One", Font.PLAIN, 11));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int setar = table.getSelectedRow();

				textNome.setText(table.getModel().getValueAt(setar, 0).toString());
				textUsuario.setText(table.getModel().getValueAt(setar, 1).toString());
				textTelefone.setText(table.getModel().getValueAt(setar, 2).toString());
				String combobox = table.getModel().getValueAt(setar, 3).toString();

				if (combobox.equals("Administrador")) {
					CBCargo.setSelectedIndex(1);
				} else if (combobox.equals("Gerente de Vendas")) {
					CBCargo.setSelectedIndex(2);
				} else if (combobox.equals("Vendedor")) {
					CBCargo.setSelectedIndex(3);
				} else if (combobox.equals("Gerente de Estoque")) {
					CBCargo.setSelectedIndex(4);
				} else {
					CBCargo.setSelectedIndex(0);
				}

				textDataNasc.setText(table.getModel().getValueAt(setar, 4).toString());
				textEmail.setText(table.getModel().getValueAt(setar, 5).toString());
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

		JButton btnAdicionar = new JButton("Adicionar\r\n");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario func1 = new Funcionario();
				String nome = textNome.getText();
				Long cpf = Long.parseLong(textCPF.getText());
				String email = textEmail.getText();
				String usuario = textUsuario.getText();
				String senha = textSenha.getText();
				Long telefone = Long.parseLong(textTelefone.getText());
				String cargo = (String) CBCargo.getSelectedItem();
				String dataNascimento = textDataNasc.getText();
				String rua = textRua.getText();
				String estado = textEstado.getText();
				String cidade = textCidade.getText();
				String bairro = textBairro.getText();
				Long cep = Long.valueOf(textCep.getText());
				Double salario = Double.valueOf(textSalario.getText());
				Double comissao = Double.valueOf(textComissao.getText());

				func1.setNome(nome);
				func1.setCpf(cpf);
				func1.setEmail(email);
				func1.setUsuario(usuario);
				func1.setSenha(senha);
				func1.setTelefone(telefone);
				func1.setNivelCargo(cargo);
				func1.setDataDeNasc(dataNascimento);
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
					String data[] = { nome, usuario, String.valueOf(telefone), cargo, dataNascimento, email };

					DefaultTableModel tbltable = (DefaultTableModel) table.getModel();
					tbltable.addRow(data);
					System.out.println("Até aqui sim");

					Endereco verificacaoEnd = enddao.buscaEndereco(end);
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
					funcdao.inserir(func1);

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

					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
				}
					
				//Configuracao configuracao = new Configuracao();
				//Configuracao.textUsuario.setText(TelaFuncionarios.textUsuario.getText());
				//((JLabel) Configuracao.textSenha).setText(TelaFuncionarios.textSenha.getText());
				//configuracao.setVisible(true);
			}
		});
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBorder(new RoundedBorder(10));
		btnAdicionar.setBackground(Color.GREEN);
		btnAdicionar.setBounds(1069, 357, 251, 35);
		contentPane.add(btnAdicionar);

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

//		MaskFormatter mascaraCEP = null;
//		try {
//			mascaraCEP = new MaskFormatter("#####-### ");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		textCep =  new JFormattedTextField(mascaraCEP);

		textCep = new JTextField();
		textCep.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCep.setColumns(10);
		textCep.setBounds(1588, 93, 274, 38);
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
				System.out.print("Edite a linha: " + row);
			}

			@Override
			public void onDelete(int row) {

				int linhaSelecionada = table.getSelectedRow();
				String matricula = (String) table.getValueAt(linhaSelecionada, 0);

				// select no banco só pelo nome da matricula
				// buscaFuncionarioPorMatricula(matricula);
				// metodo retorna um Funcionario

				Funcionario funcDelete = new Funcionario();

				// quer excluir mesmo?

				funcdao.excluir(funcDelete);
				// remove a linha da tabela (visualmente)
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(row);
			}

			@Override
			public void onView(int row) {
				// TODO Auto-generated method stub

			}
		};
		table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
		table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
		table.setRowHeight(60);

	}
}
