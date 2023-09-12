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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class TelaVeiculos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_12;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1_1.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/sair.png")));
		lblNewLabel_2_1_1_1_1_1_1_1.setBounds(85, 912, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1_1_1 = new JLabel("Sair");
		lblNewLabel_4_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_1_1_1_1_1_1_1.setBounds(122, 912, 93, 35);
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
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/visao/imagens/carrinho compras.png")));
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
		scrollPane.setBounds(480, 309, 1291, 610);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fornecedor", "Promo\u00E7\u00E3o", "Pre\u00E7o", "ABS", "Pot\u00EAncia", "Quilometragem", "Combust\u00EDvel", "Tipo", "Cor", "Ano", "Novo", "Modelo", "Marca", "ID"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.setFont(new Font("Krona One", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JLabel lblPromoo = new JLabel("Marca:");
		lblPromoo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblPromoo.setBounds(371, 58, 109, 23);
		contentPane.add(lblPromoo);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Ano:");
		lblNewLabel_2_2_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1.setBounds(1459, 49, 85, 27);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Cor:");
		lblNewLabel_2_2_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1_1.setBounds(1249, 201, 72, 23);
		contentPane.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Novo:");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1_1_1.setBounds(382, 185, 98, 35);
		contentPane.add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1 = new JLabel("Tipo:");
		lblNewLabel_2_2_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1_1_1_1.setBounds(768, 49, 85, 35);
		contentPane.add(lblNewLabel_2_2_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_2 = new JLabel("Combustível:");
		lblNewLabel_2_2_1_1_2.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1_1_2.setBounds(768, 132, 214, 25);
		contentPane.add(lblNewLabel_2_2_1_1_2);
		
		JLabel lblNewLabel_2_2_1_1_2_1 = new JLabel("Quilometragem:");
		lblNewLabel_2_2_1_1_2_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1_1_2_1.setBounds(768, 189, 407, 27);
		contentPane.add(lblNewLabel_2_2_1_1_2_1);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Krona One", Font.PLAIN, 24));
		textField_12.setColumns(10);
		textField_12.setBounds(482, 58, 199, 26);
		contentPane.add(textField_12);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblModelo.setBounds(371, 131, 132, 23);
		contentPane.add(lblModelo);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(504, 129, 199, 26);
		contentPane.add(textField_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Krona One", Font.PLAIN, 24));
		textField_5.setColumns(10);
		textField_5.setBounds(976, 131, 199, 26);
		contentPane.add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Krona One", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "Não"}));
		comboBox.setBounds(487, 188, 116, 28);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(1543, 49, 85, 23);
		contentPane.add(comboBox_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Krona One", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(1317, 199, 199, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Krona One", Font.PLAIN, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(847, 53, 199, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Krona One", Font.PLAIN, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(1030, 189, 145, 26);
		contentPane.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Krona One", Font.PLAIN, 24));
		textField_6.setColumns(10);
		textField_6.setBounds(1385, 125, 132, 26);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_2_2_1_1_2_1_1 = new JLabel("Potência:");
		lblNewLabel_2_2_1_1_2_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1_1_2_1_1.setBounds(1230, 125, 150, 27);
		contentPane.add(lblNewLabel_2_2_1_1_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1_2_1_1_1 = new JLabel("ABS:");
		lblNewLabel_2_2_1_1_2_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1_1_2_1_1_1.setBounds(1638, 50, 85, 27);
		contentPane.add(lblNewLabel_2_2_1_1_2_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Krona One", Font.PLAIN, 24));
		textField_7.setColumns(10);
		textField_7.setBounds(1719, 50, 125, 26);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Krona One", Font.PLAIN, 24));
		textField_8.setColumns(10);
		textField_8.setBounds(1724, 125, 120, 26);
		contentPane.add(textField_8);
		
		JLabel lblNewLabel_2_2_1_1_2_1_1_1_1 = new JLabel("Preço:");
		lblNewLabel_2_2_1_1_2_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1_1_2_1_1_1_1.setBounds(1615, 126, 102, 27);
		contentPane.add(lblNewLabel_2_2_1_1_2_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_2_1_1_1_1_1 = new JLabel("Promoção:");
		lblNewLabel_2_2_1_1_2_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1_1_2_1_1_1_1_1.setBounds(1545, 197, 175, 27);
		contentPane.add(lblNewLabel_2_2_1_1_2_1_1_1_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Krona One", Font.PLAIN, 24));
		comboBox_2.setBounds(1724, 196, 120, 28);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_2_2_1_1_2_1_2 = new JLabel("Fornecedor:");
		lblNewLabel_2_2_1_1_2_1_2.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_2_2_1_1_2_1_2.setBounds(1071, 49, 192, 27);
		contentPane.add(lblNewLabel_2_2_1_1_2_1_2);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		comboBox_2_1.setBounds(1272, 49, 150, 28);
		contentPane.add(comboBox_2_1);
		
		
	}
}
