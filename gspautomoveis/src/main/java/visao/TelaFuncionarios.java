package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.FuncionarioDAO;
import modelo.Endereco;
import modelo.Funcionario;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class TelaFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textUsuario;
	private JTextField textTelefone;
	private JTextField textSenha;
	private JTextField textEmail;
	private JTextField textDataNasc;
	private JTextField textCargo;
	private JTable table;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textEstado;
	private JTextField textCep;
	private JTextField textCidade;
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();
	private JTextField textComissao;
	private JTextField textSalario;

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
		lblNome.setBounds(399, 32, 133, 38);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf.setBounds(1196, 99, 93, 38);
		contentPane.add(lblCpf);

		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblUsurio.setBounds(862, 32, 163, 38);
		contentPane.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblSenha.setBounds(389, 92, 143, 38);
		contentPane.add(lblSenha);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblTelefone.setBounds(1355, 32, 188, 38);
		contentPane.add(lblTelefone);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblEmail.setBounds(409, 152, 123, 38);
		contentPane.add(lblEmail);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblDataDeNascimento.setBounds(1241, 152, 415, 38);
		contentPane.add(lblDataDeNascimento);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCargo.setBounds(780, 99, 133, 38);
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
		textCPF.setBounds(1299, 99, 196, 38);
		contentPane.add(textCPF);

		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Krona One", Font.PLAIN, 12));
		textUsuario.setColumns(10);
		textUsuario.setBounds(1035, 32, 292, 38);
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
		textTelefone =  new JTextField();
		textTelefone.setFont(new Font("Krona One", Font.PLAIN, 12));
		textTelefone.setColumns(10);
		textTelefone.setBounds(1553, 32, 309, 38);
		contentPane.add(textTelefone);

		textSenha = new JTextField();
		textSenha.setFont(new Font("Krona One", Font.PLAIN, 12));
		textSenha.setColumns(10);
		textSenha.setBounds(542, 99, 196, 38);
		contentPane.add(textSenha);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Krona One", Font.PLAIN, 12));
		textEmail.setColumns(10);
		textEmail.setBounds(542, 152, 675, 38);
		contentPane.add(textEmail);
		
		MaskFormatter mascaraData= null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textDataNasc = new JFormattedTextField(mascaraData);
		textDataNasc.setFont(new Font("Krona One", Font.PLAIN, 12));
		textDataNasc.setColumns(10);
		textDataNasc.setBounds(1666, 152, 196, 38);
		contentPane.add(textDataNasc);

		textCargo = new JTextField();
		textCargo.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCargo.setColumns(10);
		textCargo.setBounds(923, 99, 258, 38);
		contentPane.add(textCargo);

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
				textEmail.setText(table.getModel().getValueAt(setar, 5).toString());
				textUsuario.setText(table.getModel().getValueAt(setar, 1).toString());
				textTelefone.setText(table.getModel().getValueAt(setar, 2).toString());
				textCargo.setText(table.getModel().getValueAt(setar, 3).toString());
				textDataNasc.setText(table.getModel().getValueAt(setar, 4).toString());

			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Usu\u00E1rio", "Telefone",
				"Cargo", "Data de Nascimento", "Email", "A\u00E7\u00F5es" }));
		for (Funcionario funcs : funcdao.ListarFuncionarios()) {
			DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
			String data[] = { funcs.getNome(), funcs.getUsuario(), String.valueOf(funcs.getTelefone()),
					funcs.getNivelCargo(), funcs.getDataDeNasc(), funcs.getEmail()};
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
				String cargo = textCargo.getText();
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
					funcdao.inserir(func1);
					System.out.println("Passou");

					textNome.setText("");
					textCPF.setText("");
					textEmail.setText("");
					textUsuario.setText("");
					textSenha.setText("");
					textTelefone.setText("");
					textCargo.setText("");
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
		lblRua.setBounds(439, 211, 93, 38);
		contentPane.add(lblRua);

		textRua = new JTextField();
		textRua.setFont(new Font("Krona One", Font.PLAIN, 12));
		textRua.setColumns(10);
		textRua.setBounds(542, 211, 196, 38);
		contentPane.add(textRua);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblBairro.setBounds(399, 271, 133, 38);
		contentPane.add(lblBairro);

		textBairro = new JTextField();
		textBairro.setFont(new Font("Krona One", Font.PLAIN, 12));
		textBairro.setColumns(10);
		textBairro.setBounds(542, 271, 196, 38);
		contentPane.add(textBairro);

		JLabel lblCpf_2_1 = new JLabel("Estado:");
		lblCpf_2_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_1.setBounds(762, 211, 151, 38);
		contentPane.add(lblCpf_2_1);

		textEstado = new JTextField();
		textEstado.setFont(new Font("Krona One", Font.PLAIN, 12));
		textEstado.setColumns(10);
		textEstado.setBounds(928, 211, 196, 38);
		contentPane.add(textEstado);

		JLabel lblCpf_2_2 = new JLabel("CEP:");
		lblCpf_2_2.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_2.setBounds(762, 271, 93, 38);
		contentPane.add(lblCpf_2_2);
		
//		MaskFormatter mascaraCEP = null;
//		try {
//			mascaraCEP = new MaskFormatter("#####-### ");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		textCep =  new JFormattedTextField(mascaraCEP);

		textCep =  new JTextField();
		textCep.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCep.setColumns(10);
		textCep.setBounds(865, 271, 196, 38);
		contentPane.add(textCep);

		JLabel lblCpf_2_3 = new JLabel("Cidade:");
		lblCpf_2_3.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_3.setBounds(1505, 99, 151, 38);
		contentPane.add(lblCpf_2_3);

		textCidade = new JTextField();
		textCidade.setFont(new Font("Krona One", Font.PLAIN, 12));
		textCidade.setColumns(10);
		textCidade.setBounds(1666, 99, 196, 38);
		contentPane.add(textCidade);

		textComissao = new JTextField();
		textComissao.setFont(new Font("Krona One", Font.PLAIN, 12));
		textComissao.setColumns(10);
		textComissao.setBounds(1300, 271, 196, 38);
		contentPane.add(textComissao);

		JLabel lblCpf_2_2_1 = new JLabel("Comissão:");
		lblCpf_2_2_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_2_1.setBounds(1078, 271, 212, 38);
		contentPane.add(lblCpf_2_2_1);

		JLabel lblCpf_2_1_1 = new JLabel("Salário:");
		lblCpf_2_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf_2_1_1.setBounds(1134, 211, 156, 38);
		contentPane.add(lblCpf_2_1_1);

		textSalario = new JTextField();
		textSalario.setFont(new Font("Krona One", Font.PLAIN, 12));
		textSalario.setColumns(10);
		textSalario.setBounds(1300, 211, 196, 38);
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
				if (table.isEditing()) {
					table.getCellEditor().stopCellEditing();
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				model.removeRow(row);
			}

			@Override
			public void onView(int row) {
				// TODO Auto-generated method stub

			}
		};
		table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
		table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
		table.setRowHeight(60);

	}
}
