package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.CarroDAO;
import controle.FornecedorDAO;
import modelo.Carro;
import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Funcionario;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaVeiculos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txt_marca;
	private JTextField txt_modelo;
	private JTextField txt_cor;
	private JTextField txt_tipo;
	private JTextField txt_quilometragem;
	private JTextField txt_potencia;
	private FornecedorDAO forndao = FornecedorDAO.getInstancia();
	private JTextField txt_preco;
	private CarroDAO carrodao = CarroDAO.getInstancia();
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVeiculos frame = new TelaVeiculos();
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
	public TelaVeiculos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cbAbs = new JComboBox();
		cbAbs.setModel(new DefaultComboBoxModel(new String[] { "", "Sim", "Não" }));
		cbAbs.setFont(new Font("Krona One", Font.PLAIN, 24));
		cbAbs.setBounds(1009, 92, 120, 28);
		contentPane.add(cbAbs);

		JLabel lblNewLabel_2_1_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1_1.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/sair.png")));
		lblNewLabel_2_1_1_1_1_1_1_1.setBounds(39, 894, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1_1_1_1 = new JLabel("Sair");
		lblNewLabel_4_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_1_1_1_1_1_1_1.setBounds(76, 894, 93, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1_1);

		JLabel lblNewLabel_3_1 = new JLabel("GSP");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Krona One", Font.PLAIN, 57));
		lblNewLabel_3_1.setBounds(78, 49, 175, 87);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 57));
		lblNewLabel_3.setBounds(78, 193, 175, 190);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Veículos");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(85, 429, 265, 35);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/bau veiculos.png")));
		lblNewLabel_2_1_2.setBounds(39, 429, 40, 35);
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/Engrenagem.png")));
		lblNewLabel_2_1.setBounds(39, 509, 40, 35);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_4_1 = new JLabel("Configurações");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1.setBounds(85, 509, 265, 35);
		contentPane.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("Funcionários");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1.setBounds(85, 589, 265, 35);
		contentPane.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/Pessoa.png")));
		lblNewLabel_2_1_1.setBounds(39, 589, 40, 35);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1
				.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/carrinho compras.png")));
		lblNewLabel_2_1_1_1.setBounds(39, 664, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Histórico");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1.setBounds(85, 664, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Fornecedores");
		lblNewLabel_4_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1_1.setBounds(85, 736, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/carro +.png")));
		lblNewLabel_2_1_1_1_1.setBounds(39, 736, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/Sistema.png")));
		lblNewLabel_2_1_1_1_1_1.setBounds(39, 819, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Sistema");
		lblNewLabel_4_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1_1_1.setBounds(85, 819, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(0, -109, 361, 1221);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Sair");
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_1_1_1_1_1_1.setBounds(58, 956, 93, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1.setBounds(21, 956, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(89, 166, 175, 190);
		contentPane.add(lblNewLabel_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(371, 285, 989, 440);
		contentPane.add(scrollPane);

		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Marca", "Modelo", "Fornecedor", "Promo\u00E7\u00E3o", "ABS", "Pot\u00EAncia",
						"Quilometragem", "Combust\u00EDvel", "Tipo", "Cor", "Ano", "Novo", "Pre\u00E7o", "Ações" }));
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.setFont(new Font("Krona One", Font.PLAIN, 11));
		scrollPane.setViewportView(table);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblMarca.setBounds(371, 58, 109, 23);
		contentPane.add(lblMarca);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblAno.setBounds(1139, 92, 85, 27);
		contentPane.add(lblAno);

		JComboBox Cbcombustivel = new JComboBox();
		Cbcombustivel.setModel(new DefaultComboBoxModel(
				new String[] { "", "Gasolina", "Alcool", "Diesel", "Gasolina e Alcool", "Gasolina e Eletrico" }));
		Cbcombustivel.setBounds(923, 133, 164, 25);
		contentPane.add(Cbcombustivel);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCor.setBounds(1030, 171, 72, 23);
		contentPane.add(lblCor);

		JLabel lblNovo = new JLabel("Novo:");
		lblNovo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNovo.setBounds(382, 169, 98, 35);
		contentPane.add(lblNovo);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblTipo.setBounds(691, 49, 85, 35);
		contentPane.add(lblTipo);

		JLabel lblCombustivel = new JLabel("Combustível:");
		lblCombustivel.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCombustivel.setBounds(713, 133, 214, 25);
		contentPane.add(lblCombustivel);

		JLabel lblQuilometragem = new JLabel("Quilometragem:");
		lblQuilometragem.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblQuilometragem.setBounds(613, 169, 265, 35);
		contentPane.add(lblQuilometragem);

		txt_marca = new JTextField();
		txt_marca.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_marca.setColumns(10);
		txt_marca.setBounds(482, 58, 199, 26);
		contentPane.add(txt_marca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblModelo.setBounds(371, 133, 132, 23);
		contentPane.add(lblModelo);

		txt_modelo = new JTextField();
		txt_modelo.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_modelo.setColumns(10);
		txt_modelo.setBounds(504, 131, 199, 26);
		contentPane.add(txt_modelo);

		JComboBox comboBoxNovo = new JComboBox();
		comboBoxNovo.setFont(new Font("Krona One", Font.PLAIN, 24));
		comboBoxNovo.setModel(new DefaultComboBoxModel(new String[] { "", "Sim", "Não" }));
		comboBoxNovo.setBounds(487, 172, 116, 28);
		contentPane.add(comboBoxNovo);

		JComboBox comboBoxAno = new JComboBox();
		comboBoxAno.setModel(new DefaultComboBoxModel(new String[] { "", "2023", "2022", "2021", "2020", "2019", "2018",
				"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005",
				"2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992",
				"1991", "1990" }));
		comboBoxAno.setBounds(1223, 92, 85, 23);
		contentPane.add(comboBoxAno);

		txt_cor = new JTextField();
		txt_cor.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_cor.setColumns(10);
		txt_cor.setBounds(1098, 169, 199, 26);
		contentPane.add(txt_cor);

		txt_tipo = new JTextField();
		txt_tipo.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_tipo.setColumns(10);
		txt_tipo.setBounds(770, 53, 199, 26);
		contentPane.add(txt_tipo);

		txt_quilometragem = new JTextField();
		txt_quilometragem.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_quilometragem.setColumns(10);
		txt_quilometragem.setBounds(875, 173, 145, 26);
		contentPane.add(txt_quilometragem);

		txt_potencia = new JTextField();
		txt_potencia.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_potencia.setColumns(10);
		txt_potencia.setBounds(1252, 131, 132, 26);
		contentPane.add(txt_potencia);

		JLabel lblPotencia = new JLabel("Potência:");
		lblPotencia.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblPotencia.setBounds(1097, 131, 150, 27);
		contentPane.add(lblPotencia);

		JLabel lblABS = new JLabel("ABS:");
		lblABS.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblABS.setBounds(923, 93, 85, 27);
		contentPane.add(lblABS);

		txt_preco = new JTextField();
		txt_preco.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_preco.setColumns(10);
		txt_preco.setBounds(483, 92, 120, 26);
		contentPane.add(txt_preco);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblPreco.setBounds(374, 93, 102, 27);
		contentPane.add(lblPreco);

		JLabel lblPromocao = new JLabel("Promoção:");
		lblPromocao.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblPromocao.setBounds(613, 93, 175, 27);
		contentPane.add(lblPromocao);

		JComboBox comboBoxPromocao = new JComboBox();
		comboBoxPromocao.setModel(new DefaultComboBoxModel(new String[] { "", "Sim", "Não" }));
		comboBoxPromocao.setFont(new Font("Krona One", Font.PLAIN, 24));
		comboBoxPromocao.setBounds(792, 92, 120, 28);
		contentPane.add(comboBoxPromocao);

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblFornecedor.setBounds(979, 49, 192, 27);
		contentPane.add(lblFornecedor);

		JComboBox comboBoxFornecedor = new JComboBox();
		comboBoxFornecedor.setModel(new DefaultComboBoxModel(new String[] { "", "Kristofor", "Marrilee", "Mag",
				"Almire", "Deedee", "Billie", "Minny", "Melinda", "Benedikta", "Myra", "Catlaina", "Peggie", "Dedra",
				"Sarette", "Deanne", "Merill", "Orbadiah", "Wolfgang", "Sanderson", "Sula" }));
		comboBoxFornecedor.setFont(new Font("Krona One", Font.PLAIN, 24));
		comboBoxFornecedor.setBounds(1180, 49, 150, 28);
		contentPane.add(comboBoxFornecedor);

		JButton btnAdicionar = new JButton("Adicionar\r\n");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carro carro = new Carro();
				String marca = txt_marca.getText();
				String modelo = txt_modelo.getText();
				Boolean novo = comboBoxNovo.getSelectedItem().equals("Sim") ? true : false;
				String tipo = txt_tipo.getText();
				String combustivel = (String) Cbcombustivel.getSelectedItem();
				Long quilometragem = Long.valueOf(txt_quilometragem.getText());
				String potencia = txt_potencia.getText();
				String cor = txt_cor.getText();
				Integer ano = Integer.valueOf((String) comboBoxAno.getSelectedItem());
				Boolean abs = (Boolean) cbAbs.getSelectedItem().equals("Sim") ? true : false;
				Double precoCarro = Double.valueOf(txt_preco.getText());
				Boolean promocao = (Boolean) comboBoxPromocao.getSelectedItem().equals("Sim") ? true : false;

				System.out.println(comboBoxFornecedor.getSelectedItem());
				Fornecedor forn = forndao.pegarForn(String.valueOf(comboBoxFornecedor.getSelectedItem()));

				carro.setFornecedor(forn);
				carro.setMarca(marca);
				carro.setModelo(modelo);
				carro.setNovo(novo);
				carro.setTipo(tipo);
				carro.setCombustivel(combustivel);
				carro.setQuilometragem(quilometragem);
				carro.setPotencia(potencia);
				carro.setCor(cor);
				carro.setAno(ano);
				carro.setAbs(abs);
				carro.setPrecoCarro(precoCarro);
				carro.setPromocao(promocao);

				if (marca.equals("") || modelo.equals("") || novo.equals("") || tipo.equals("")
						|| combustivel.equals("") || quilometragem.equals("") || potencia.equals("") || cor.equals("")
						|| ano.equals("") || abs.equals("") || abs.equals("") || precoCarro.equals("")
						|| promocao.equals("") || forn.equals("")) {
					TelaErro erro = new TelaErro();
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				} else {
					

					Integer id = carrodao.inserir(carro);
					
					txt_marca.setText("");
					txt_modelo.setText("");
					txt_tipo.setText("");
					txt_quilometragem.setText("");
					txt_potencia.setText("");
					txt_cor.setText("");
					txt_preco.setText("");
					comboBoxNovo.setSelectedIndex(0);
					Cbcombustivel.setSelectedIndex(0);
					comboBoxFornecedor.setSelectedIndex(0);
					comboBoxAno.setSelectedIndex(0);
					cbAbs.setSelectedIndex(0);
					comboBoxPromocao.setSelectedIndex(0);
					String carroPromo;
					String carroAbs;
					String carroNovo;
					if (carro.getPromocao() == true) {
						carroPromo = "Sim";
					} else {
						carroPromo = "Não";
					}
					if (carro.getAbs() == true) {
						carroAbs = "Sim";
					} else {
						carroAbs = "Não";
					}
					if (carro.getNovo() == true) {
						carroNovo = "Sim";
					} else {
						carroNovo = "Não";
					}
					String data[] = {String.valueOf(id), carro.getMarca(), carro.getModelo(),
							forn.getNomeFornecedor(), carroPromo, carroAbs, carro.getPotencia(),
							String.valueOf(carro.getQuilometragem()), carro.getCombustivel(), carro.getTipo(),
							carro.getCor(), String.valueOf(carro.getAno()), carroNovo,
							String.valueOf(carro.getPrecoCarro()) };
					DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
					tblModel.addRow(data);
					
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
		btnAdicionar.setBounds(940, 223, 251, 35);
		contentPane.add(btnAdicionar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * TelaContinuar telaContinua = new TelaContinuar();
				 * telaContinua.setLocationRelativeTo(null); telaContinua.setVisible(true);
				 */
				// if (telaContinua.confirmado) {
				Carro carro = new Carro();
				String marca = txt_marca.getText();
				String modelo = txt_modelo.getText();
				Boolean novo = comboBoxNovo.getSelectedItem().equals("Sim") ? true : false;
				String tipo = txt_tipo.getText();
				String combustivel = (String) Cbcombustivel.getSelectedItem();
				Long quilometragem = Long.valueOf(txt_quilometragem.getText());
				String fornecedor = (String) comboBoxFornecedor.getSelectedItem();
				String potencia = txt_potencia.getText();
				String cor = txt_cor.getText();
				Integer ano = Integer.valueOf((String) comboBoxAno.getSelectedItem());
				Boolean abs = (Boolean) cbAbs.getSelectedItem().equals("Sim") ? true : false;
				Double precoCarro = Double.valueOf(txt_preco.getText());
				Boolean promocao = (Boolean) comboBoxPromocao.getSelectedItem().equals("Sim") ? true : false;
				Integer id = Integer.valueOf(textId.getText());

				Fornecedor fornece = new Fornecedor();
				carro.setIdCarro(id);
				fornece = forndao.pegarForn(fornecedor);
				carro.setFornecedor(fornece);
				carro.setMarca(marca);
				carro.setModelo(modelo);
				carro.setNovo(novo);
				carro.setAno(ano);
				carro.setCor(cor);
				carro.setTipo(tipo);
				carro.setCombustivel(combustivel);
				carro.setQuilometragem(quilometragem);
				carro.setPotencia(potencia);
				carro.setAbs(abs);
				carro.setPrecoCarro(precoCarro);
				carro.setPromocao(promocao);

				carrodao.atualizar(carro);

				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setValueAt(marca, linhaSelecionada, 1);
					model.setValueAt(modelo, linhaSelecionada, 2);
					model.setValueAt(fornecedor, linhaSelecionada, 3);
					if (promocao) {
						model.setValueAt("Sim", linhaSelecionada, 4);
					} else {
						model.setValueAt("Não", linhaSelecionada, 4);
					}
					if (abs) {
						model.setValueAt("Sim", linhaSelecionada, 5);
					} else {
						model.setValueAt("Não", linhaSelecionada, 5);
					}
					model.setValueAt(potencia, linhaSelecionada, 6);
					model.setValueAt(quilometragem, linhaSelecionada, 7);
					model.setValueAt(combustivel, linhaSelecionada, 8);
					model.setValueAt(tipo, linhaSelecionada, 9);
					model.setValueAt(cor, linhaSelecionada, 10);
					model.setValueAt(ano, linhaSelecionada, 11);
					if (novo) {
						model.setValueAt("Sim", linhaSelecionada, 12);
					} else {
						model.setValueAt("Não", linhaSelecionada, 12);
					}
					model.setValueAt(precoCarro, linhaSelecionada, 13);

					// Tela de sucesso de ação
					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
				}

			}
		});

		table.getColumnModel().getColumn(14).setPreferredWidth(200);

		TableActionEvent event = new TableActionEvent() {

			@Override
			public void onEdit(int row) {
				btnAtualizar.setVisible(true);
				btnAdicionar.setVisible(false);
			}

			@Override
			public void onDelete(int row) {

				int linhaSelecionada = table.getSelectedRow();
				Integer id = Integer.valueOf(table.getModel().getValueAt(linhaSelecionada, 0).toString());

				// select no banco só pelo id
				// buscaVeiculoPorId(id);
				// metodo retorna um veiculo

				// Carro carroDelete = new Carro();
				// carroDelete = carrodao.clicado(id);

				// quer excluir mesmo?
				// FALTA COLOCAR CONFIRMAÇÃO

				carrodao.excluir(id);

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
		table.getColumnModel().getColumn(14).setCellRenderer(new TableActionCellRender());
		table.getColumnModel().getColumn(14).setCellEditor(new TableActionCellEditor(event));
		table.setRowHeight(60);

		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBorder(new RoundedBorder(10));
		btnAtualizar.setBackground(new Color(255, 255, 0));
		btnAtualizar.setBounds(940, 223, 251, 35);
		contentPane.add(btnAtualizar);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblId.setBounds(1302, 166, 40, 35);
		contentPane.add(lblId);

		textId = new JTextField();
		textId.setEditable(false);
		textId.setFont(new Font("Krona One", Font.PLAIN, 24));
		textId.setColumns(10);
		textId.setBounds(1349, 170, 62, 26);
		contentPane.add(textId);

		for (Carro carros : carrodao.ListarCarros()) {
			DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
			Fornecedor forn = forndao.buscaFornecedor(carros.getFornecedor());
			String carroPromo;
			String carroAbs;
			String carroNovo;
			if (carros.getPromocao() == true) {
				carroPromo = "Sim";
			} else {
				carroPromo = "Não";
			}
			if (carros.getAbs() == true) {
				carroAbs = "Sim";
			} else {
				carroAbs = "Não";
			}
			if (carros.getNovo() == true) {
				carroNovo = "Sim";
			} else {
				carroNovo = "Não";
			}
			String data[] = { String.valueOf(carros.getIdCarro()), carros.getMarca(), carros.getModelo(),
					forn.getNomeFornecedor(), carroPromo, carroAbs, carros.getPotencia(),
					String.valueOf(carros.getQuilometragem()), carros.getCombustivel(), carros.getTipo(),
					carros.getCor(), String.valueOf(carros.getAno()), carroNovo,
					String.valueOf(carros.getPrecoCarro()) };
			tblModel.addRow(data);
		}

		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAdicionar.setVisible(true);
				btnAtualizar.setVisible(false);
				Cbcombustivel.setSelectedIndex(0);
				comboBoxFornecedor.setSelectedIndex(0);
				txt_marca.setEditable(true);
				txt_modelo.setEditable(true);

				textId.setText("");
				txt_marca.setText("");
				txt_modelo.setText("");
				txt_tipo.setText("");
				txt_quilometragem.setText("");
				txt_potencia.setText("");
				txt_cor.setText("");
				txt_preco.setText("");
				comboBoxNovo.setSelectedIndex(0);
				Cbcombustivel.setSelectedIndex(0);
				comboBoxFornecedor.setSelectedIndex(0);
				comboBoxAno.setSelectedIndex(0);
				cbAbs.setSelectedIndex(0);
				comboBoxPromocao.setSelectedIndex(0);

			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int setar = table.getSelectedRow();
				Integer id = Integer.valueOf(table.getModel().getValueAt(setar, 0).toString());
				Carro car = new Carro();
				car = carrodao.clicado(id);

				textId.setText(String.valueOf(car.getIdCarro()));
				txt_marca.setText(car.getMarca());
				txt_modelo.setText(car.getModelo());
				txt_tipo.setText(car.getTipo());
				txt_quilometragem.setText(String.valueOf(car.getQuilometragem()));
				txt_potencia.setText(String.valueOf(car.getPotencia()));
				txt_cor.setText(car.getCor());
				txt_preco.setText(String.valueOf(car.getPrecoCarro()));
				if (car.getNovo().equals(true)) {
					comboBoxNovo.setSelectedIndex(1);
				} else {
					comboBoxNovo.setSelectedIndex(2);
				}
				if (car.getCombustivel().equals("Gasolina")) {
					Cbcombustivel.setSelectedIndex(1);
				} else if (car.getCombustivel().equals("Alcool")) {
					Cbcombustivel.setSelectedIndex(2);
				} else if (car.getCombustivel().equals("Diesel")) {
					Cbcombustivel.setSelectedIndex(3);
				} else if (car.getCombustivel().equals("Gasolina e Alcool")) {
					Cbcombustivel.setSelectedIndex(4);
				} else {
					Cbcombustivel.setSelectedIndex(5);
				}

				Integer idFornCarro = car.getFornecedor().getIdFornecedor();
				Fornecedor forn = new Fornecedor();
				forn.setIdFornecedor(idFornCarro);
				Fornecedor nomeForn = forndao.buscaFornecedor(forn);
				for (int i = 0; i < comboBoxFornecedor.getItemCount(); i++) {
					if (nomeForn.getNomeFornecedor().equals((String) comboBoxFornecedor.getItemAt(i))) {
						comboBoxFornecedor.setSelectedIndex(i);
						break;
					}
				}
				for (int i = 0; i < comboBoxAno.getItemCount(); i++) {
					if (car.getAno().equals(comboBoxAno.getItemAt(i))) {
						comboBoxAno.setSelectedIndex(i);
						break;
					}
				}
				if (car.getAbs().equals(true)) {
					cbAbs.setSelectedIndex(1);
				} else {
					cbAbs.setSelectedIndex(2);
				}
				if (car.getAbs().equals(true)) {
					comboBoxPromocao.setSelectedIndex(1);
				} else {
					comboBoxPromocao.setSelectedIndex(2);
				}

				txt_marca.setEditable(false);
				txt_modelo.setEditable(false);

			}
		});

	}
}
