package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaHistoricoVeiculos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHistoricoFornecedores frame = new TelaHistoricoFornecedores();
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
	public TelaHistoricoVeiculos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Krona One", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecionar Marca", "Agrale", "Aston Martin", "Audi", "BMW", "BYD", "CAOA Chery", "Chevrolet", "Citroën", "Effa", "Ferrari", "Fiat", "Ford", "Foton", "Haval", "Honda", "Hyundai", "Iveco", "JAC", "Jaguar", "Jeep", "Kia", "Lamborghini", "Land Rover", "Lexus", "Maserati", "McLaren", "Mercedes-AMG", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Peugeot", "Porsche", "RAM", "Renault", "Rolls-Royce", "Seres", "Subaru", "Suzuki", "Toyota", "Volkswagen", "Volvo"}));
		comboBox.setBounds(614, 70, 929, 44);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Sair");
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_1_1_1_1_1_1.setBounds(63, 936, 93, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 57));
		lblNewLabel_3.setBounds(63, 43, 166, 72);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaHistoricoFornecedores.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1.setBounds(63, 141, 175, 190);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(TelaHistoricoFornecedores.class.getResource("/visao/imagens/bau veiculos.png")));
		lblNewLabel_2_1_2.setBounds(17, 410, 40, 35);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("Veículos");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(63, 410, 265, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(TelaHistoricoFornecedores.class.getResource("/visao/imagens/Engrenagem.png")));
		lblNewLabel_2_1.setBounds(17, 490, 40, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Configurações");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1.setBounds(63, 490, 265, 35);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TelaHistoricoFornecedores.class.getResource("/visao/imagens/Pessoa.png")));
		lblNewLabel_2_1_1.setBounds(17, 570, 40, 35);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Funcionários");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1.setBounds(63, 570, 265, 35);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(TelaHistoricoFornecedores.class.getResource("/visao/imagens/carrinho compras.png")));
		lblNewLabel_2_1_1_1.setBounds(17, 645, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Histórico");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1.setBounds(63, 645, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(TelaHistoricoFornecedores.class.getResource("/visao/imagens/carro +.png")));
		lblNewLabel_2_1_1_1_1.setBounds(17, 717, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Fornecedores");
		lblNewLabel_4_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1_1.setBounds(63, 717, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1.setIcon(new ImageIcon(TelaHistoricoFornecedores.class.getResource("/visao/imagens/Sistema.png")));
		lblNewLabel_2_1_1_1_1_1.setBounds(17, 800, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Sistema");
		lblNewLabel_4_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1_1_1.setBounds(63, 800, 265, 35);
		contentPane.add(lblNewLabel_4_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1.setIcon(new ImageIcon(TelaHistoricoFornecedores.class.getResource("/visao/imagens/sair.png")));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(17, 937, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaHistoricoFornecedores.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel.setBounds(-14, -47, 361, 1141);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(478, 253, 1271, 690);
		contentPane.add(scrollPane);
		//cadastrar nome das colunas
		table = new JTable();
		table.setFont(new Font("Krona One", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Marca", "Quilometragem", "Ano", "ABS", "Valor"
			}
		));
		
		
	}
}

