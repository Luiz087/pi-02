package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaFornecedores extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textTel;
	private JTextField textCNPJ;
	private JTextField textMarca;
	private JTextField textCidade;
	private JTable table;

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
		Color color = new Color(68, 117, 157);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1_1.setBounds(78, 193, 175, 190);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 57));
		lblNewLabel_3.setBounds(78, 49, 175, 87);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNome.setBounds(397, 25, 194, 88);
		contentPane.add(lblNome);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblCnpj.setBounds(1403, 36, 106, 88);
		contentPane.add(lblCnpj);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblCidade.setBounds(1169, 133, 150, 70);
		contentPane.add(lblCidade);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblMarca.setBounds(624, 124, 127, 88);
		contentPane.add(lblMarca);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblTelefone.setBounds(873, 36, 175, 88);
		contentPane.add(lblTelefone);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Krona One", Font.PLAIN, 20));
		textNome.setBounds(528, 49, 335, 50);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textTel = new JTextField();
		textTel.setFont(new Font("Krona One", Font.PLAIN, 20));
		textTel.setColumns(10);
		textTel.setBounds(1058, 49, 335, 50);
		contentPane.add(textTel);
		
		textCNPJ = new JTextField();
		textCNPJ.setFont(new Font("Krona One", Font.PLAIN, 20));
		textCNPJ.setColumns(10);
		textCNPJ.setBounds(1519, 49, 335, 50);
		contentPane.add(textCNPJ);
		
		textMarca = new JTextField();
		textMarca.setFont(new Font("Krona One", Font.PLAIN, 20));
		textMarca.setColumns(10);
		textMarca.setBounds(761, 147, 335, 50);
		contentPane.add(textMarca);
		
		textCidade = new JTextField();
		textCidade.setFont(new Font("Krona One", Font.PLAIN, 20));
		textCidade.setColumns(10);
		textCidade.setBounds(1329, 147, 335, 50);
		contentPane.add(textCidade);
		

		
		JButton btnAdicionar = new JButton("Adicionar\r\n");
		btnAdicionar.setBackground(new Color(0, 255, 0));
		 btnAdicionar.setForeground(new Color(0, 0, 0)); 
		 btnAdicionar.setFont(new Font("Krona One", Font.PLAIN, 20));
		 
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNome.getText().equals("")||textTel.getText().equals("") || textCNPJ.getText().equals("") ||textMarca.getText().equals("") || textCidade.getText().equals("") ) {
					System.out.print("deu ruim");
				}else {
					String data[] = {textNome.getText(), textTel.getText(), textCNPJ.getText(), textMarca.getText(), textCidade.getText()};
					
					//criar as linhas quando adicionar o fornecedor
					DefaultTableModel tbltable = (DefaultTableModel)table.getModel();
					tbltable.addRow(data);
					
					System.out.print("Deu boa");
					//limpar apos clicar no botão
					textNome.setText("");
					textTel.setText("");
					textCNPJ.setText("");
					textMarca.setText("");
					textCidade.setText("");
				}
			}
		});
		
		btnAdicionar.setBounds(1069, 264, 251, 35);
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBorder(new RoundedBorder(10));
	   
		contentPane.add(btnAdicionar);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/Engrenagem.png")));
		lblNewLabel_2_1.setBounds(28, 536, 40, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Configurações");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1.setBounds(74, 536, 265, 35);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4 = new JLabel("Veículos");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(74, 456, 265, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/Pessoa.png")));
		lblNewLabel_2_1_1.setBounds(28, 616, 40, 35);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/bau veiculos.png")));
		lblNewLabel_2_1_2.setBounds(28, 456, 40, 35);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Histórico");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1.setBounds(74, 691, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/carrinho compras.png")));
		lblNewLabel_2_1_1_1.setBounds(28, 691, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Funcionários");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1.setBounds(74, 616, 265, 35);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Fornecedores");
		lblNewLabel_4_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1_1.setBounds(74, 763, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/carro +.png")));
		lblNewLabel_2_1_1_1_1.setBounds(28, 763, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/Sistema.png")));
		lblNewLabel_2_1_1_1_1_1.setBounds(28, 846, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Sistema");
		lblNewLabel_4_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1_1_1.setBounds(74, 846, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Sair");
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_1_1_1_1_1_1.setBounds(47, 983, 93, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1.setIcon(new ImageIcon(TelaFornecedores.class.getResource("/visao/imagens/sair.png")));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(10, 983, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\pi-02\\gspautomoveis\\src\\main\\java\\visao\\imagens\\bglateral.png"));
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(-11, 0, 361, 1041);
		contentPane.add(lblNewLabel_1);
		
		//posição do Jpanel
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(438, 465, 1371, 537);
		contentPane.add(scrollPane);
		//cadastrar nome das colunas
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Telefone", "CNPJ", "Marca", "Cidade", "Ações" }));
		
		table.getColumnModel().getColumn(5).setPreferredWidth(1);
		
	}
}
