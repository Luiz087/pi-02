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
import modelo.Fornecedor;
import modelo.Funcionario;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

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
		cbAbs.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "Não"}));
		cbAbs.setFont(new Font("Krona One", Font.PLAIN, 24));
		cbAbs.setBounds(1724, 49, 120, 28);
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
		scrollPane.setBounds(492, 296, 1291, 610);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Marca", "Modelo", "Fornecedor", "Promo\u00E7\u00E3o", "ABS", "Pot\u00EAncia",
						"Quilometragem", "Combust\u00EDvel", "Tipo", "Cor", "Ano", "Novo", "Pre\u00E7o"}));
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.setFont(new Font("Krona One", Font.PLAIN, 11));
		scrollPane.setViewportView(table);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblMarca.setBounds(371, 58, 109, 23);
		contentPane.add(lblMarca);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblAno.setBounds(1459, 49, 85, 27);
		contentPane.add(lblAno);
		
		JComboBox Cbcombustivel = new JComboBox();
		Cbcombustivel.setModel(new DefaultComboBoxModel(new String[] {"", "Gasolina", "Alcool", "Diesel", "Gasolina e Alcool", "Gasolina e Eletrico"}));
		Cbcombustivel.setBounds(978, 132, 164, 25);
		contentPane.add(Cbcombustivel);


		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCor.setBounds(1249, 201, 72, 23);
		contentPane.add(lblCor);

		JLabel lblNovo = new JLabel("Novo:");
		lblNovo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNovo.setBounds(382, 185, 98, 35);
		contentPane.add(lblNovo);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblTipo.setBounds(768, 49, 85, 35);
		contentPane.add(lblTipo);

		JLabel lblCombustivel = new JLabel("Combustível:");
		lblCombustivel.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCombustivel.setBounds(768, 132, 214, 25);
		contentPane.add(lblCombustivel);

		JLabel lblQuilometragem = new JLabel("Quilometragem:");
		lblQuilometragem.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblQuilometragem.setBounds(768, 189, 265, 35);
		contentPane.add(lblQuilometragem);

		txt_marca = new JTextField();
		txt_marca.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_marca.setColumns(10);
		txt_marca.setBounds(482, 58, 199, 26);
		contentPane.add(txt_marca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblModelo.setBounds(371, 131, 132, 23);
		contentPane.add(lblModelo);

		txt_modelo = new JTextField();
		txt_modelo.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_modelo.setColumns(10);
		txt_modelo.setBounds(504, 129, 199, 26);
		contentPane.add(txt_modelo);

		JComboBox comboBoxNovo = new JComboBox();
		comboBoxNovo.setFont(new Font("Krona One", Font.PLAIN, 24));
		comboBoxNovo.setModel(new DefaultComboBoxModel(new String[] { "", "Sim", "Não" }));
		comboBoxNovo.setBounds(487, 188, 116, 28);
		contentPane.add(comboBoxNovo);

		JComboBox comboBoxAno = new JComboBox();
		comboBoxAno.setModel(new DefaultComboBoxModel(new String[] {"", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"}));
		comboBoxAno.setBounds(1543, 49, 85, 23);
		contentPane.add(comboBoxAno);

		txt_cor = new JTextField();
		txt_cor.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_cor.setColumns(10);
		txt_cor.setBounds(1317, 199, 199, 26);
		contentPane.add(txt_cor);

		txt_tipo = new JTextField();
		txt_tipo.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_tipo.setColumns(10);
		txt_tipo.setBounds(847, 53, 199, 26);
		contentPane.add(txt_tipo);

		txt_quilometragem = new JTextField();
		txt_quilometragem.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_quilometragem.setColumns(10);
		txt_quilometragem.setBounds(1030, 193, 145, 26);
		contentPane.add(txt_quilometragem);

		txt_potencia = new JTextField();
		txt_potencia.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_potencia.setColumns(10);
		txt_potencia.setBounds(1385, 125, 132, 26);
		contentPane.add(txt_potencia);

		JLabel lblPotencia = new JLabel("Potência:");
		lblPotencia.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblPotencia.setBounds(1230, 125, 150, 27);
		contentPane.add(lblPotencia);

		JLabel lblABS = new JLabel("ABS:");
		lblABS.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblABS.setBounds(1638, 50, 85, 27);
		contentPane.add(lblABS);

		txt_preco = new JTextField();
		txt_preco.setFont(new Font("Krona One", Font.PLAIN, 24));
		txt_preco.setColumns(10);
		txt_preco.setBounds(1724, 125, 120, 26);
		contentPane.add(txt_preco);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblPreco.setBounds(1615, 126, 102, 27);
		contentPane.add(lblPreco);

		JLabel lblPromocao = new JLabel("Promoção:");
		lblPromocao.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblPromocao.setBounds(1545, 197, 175, 27);
		contentPane.add(lblPromocao);

		JComboBox comboBoxPromocao = new JComboBox();
		comboBoxPromocao.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "Não"}));
		comboBoxPromocao.setFont(new Font("Krona One", Font.PLAIN, 24));
		comboBoxPromocao.setBounds(1724, 196, 120, 28);
		contentPane.add(comboBoxPromocao);

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblFornecedor.setBounds(1071, 49, 192, 27);
		contentPane.add(lblFornecedor);

		JComboBox comboBoxFornecedor = new JComboBox();
		comboBoxFornecedor.setModel(new DefaultComboBoxModel(new String[] {"", "Kristofor", "Marrilee", "Mag", "Almire", "Deedee", "Billie", "Minny", "Melinda", "Benedikta", "Myra", "Catlaina", "Peggie", "Dedra", "Sarette", "Deanne", "Merill", "Orbadiah", "Wolfgang", "Sanderson", "Sula"}));
		comboBoxFornecedor.setFont(new Font("Krona One", Font.PLAIN, 24));
		comboBoxFornecedor.setBounds(1272, 49, 150, 28);
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
				String fornecedor = (String) comboBoxFornecedor.getSelectedItem();
				String potencia = txt_potencia.getText();
				String cor = txt_cor.getText();
				Integer ano = Integer.valueOf((String) comboBoxAno.getSelectedItem());
				Boolean abs = (Boolean) cbAbs.getSelectedItem().equals("Sim") ? true : false;
				Double precoCarro = Double.valueOf(txt_preco.getText());
				Boolean promocao = (Boolean) comboBoxPromocao.getSelectedItem().equals("Sim") ? true : false;;
				
				Fornecedor forn = forndao.pegarForn(fornecedor);
				
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
						|| promocao.equals("")) {
					TelaErro erro = new TelaErro();
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				} else {
					String liborio[] = { marca, modelo,forn.getNomeFornecedor(),String.valueOf(promocao), 
					String.valueOf(abs), potencia,String.valueOf(quilometragem),combustivel, tipo,
					cor, String.valueOf(ano), String.valueOf(novo), String.valueOf(precoCarro) };
					DefaultTableModel tbltable = (DefaultTableModel) table.getModel();
					tbltable.addRow(liborio);
					
					carrodao.inserir(carro);
					
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

					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
				}
			}
		});
		
		//
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBorder(new RoundedBorder(10));
		btnAdicionar.setBackground(Color.GREEN);
		btnAdicionar.setBounds(940, 250, 251, 35);
		contentPane.add(btnAdicionar);
		
		JButton btnEditar = new JButton("Atualizar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaContinuar telaContinua = new TelaContinuar();
			telaContinua.setLocationRelativeTo(null);
			telaContinua.setVisible(true);
			if (telaContinua.confirmado) {
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
				Boolean promocao = (Boolean) comboBoxPromocao.getSelectedItem().equals("Sim") ? true : false;;
			
	
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
				
				TelaSucesso sucesso = new TelaSucesso();
				sucesso.setLocationRelativeTo(null);
				sucesso.setVisible(true);
				
			}
			}
		});
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnEditar.setFocusPainted(false);
		btnEditar.setBorder(new RoundedBorder(10));
		btnEditar.setBackground(new Color(255, 255, 0));
		btnEditar.setBounds(679, 250, 251, 35);
		contentPane.add(btnEditar);
		
		JButton btnExcluir_1 = new JButton("Excluir\r\n");
		btnExcluir_1.setForeground(Color.BLACK);
		btnExcluir_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnExcluir_1.setFocusPainted(false);
		btnExcluir_1.setBorder(new RoundedBorder(10));
		btnExcluir_1.setBackground(new Color(255, 0, 0));
		btnExcluir_1.setBounds(778, 204, 251, 35);
		contentPane.add(btnExcluir_1);
		
		
	}
}

