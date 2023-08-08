package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(74, 149, 175, 190);
		lblNewLabel_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Logo sem fundo.png")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setBounds(74, 51, 175, 87);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 57));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Veículos");
		lblNewLabel_4.setBounds(74, 418, 265, 35);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(28, 498, 40, 35);
		lblNewLabel_2_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Engrenagem.png")));
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Configurações");
		lblNewLabel_4_1.setBounds(74, 498, 265, 35);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBounds(28, 578, 40, 35);
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Pessoa.png")));
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Funcionários");
		lblNewLabel_4_1_1.setBounds(74, 578, 265, 35);
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setBounds(28, 653, 40, 35);
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/carrinho compras.png")));
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Histórico");
		lblNewLabel_4_1_1_1.setBounds(74, 653, 265, 35);
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1.setBounds(28, 725, 40, 35);
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/carro +.png")));
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Fornecedores");
		lblNewLabel_4_1_1_1_1.setBounds(74, 725, 265, 35);
		lblNewLabel_4_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1.setBounds(28, 808, 40, 35);
		lblNewLabel_2_1_1_1_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Sistema.png")));
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Sistema");
		lblNewLabel_4_1_1_1_1_1.setBounds(74, 808, 265, 35);
		lblNewLabel_4_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		contentPane.add(lblNewLabel_4_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1.setBounds(10, 945, 40, 35);
		lblNewLabel_2_1_1_1_1_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/sair.png")));
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Sair");
		lblNewLabel_4_1_1_1_1_1_1.setBounds(47, 945, 93, 35);
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setBounds(28, 418, 40, 35);
		lblNewLabel_2_1_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/bau veiculos.png")));
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-11, -58, 361, 1141);
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/bglateral.png")));
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_2_1_2_1 = new JLabel("");
		lblNewLabel_2_1_2_1.setBounds(380, 159, 40, 35);
		lblNewLabel_2_1_2_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/pessoa(nome).png")));
		contentPane.add(lblNewLabel_2_1_2_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(546, 159, 239, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4_2 = new JLabel("Nome:");
		lblNewLabel_4_2.setBounds(430, 159, 106, 35);
		lblNewLabel_4_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_2.setFont(new Font("Krona One", Font.PLAIN, 24));
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("");
		lblNewLabel_2_1_2_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/Tabele de verificação.png")));
		lblNewLabel_2_1_2_1_1.setBounds(867, 159, 40, 35);
		contentPane.add(lblNewLabel_2_1_2_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Matrícula:");
		lblNewLabel_4_2_1.setForeground(Color.BLACK);
		lblNewLabel_4_2_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_2_1.setBounds(917, 159, 154, 35);
		contentPane.add(lblNewLabel_4_2_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(1081, 159, 239, 35);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_1_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_2_1_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/visao/imagens/telefone.png")));
		lblNewLabel_2_1_2_1_1_1.setBounds(1432, 159, 40, 35);
		contentPane.add(lblNewLabel_2_1_2_1_1_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Telefone:");
		lblNewLabel_4_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_2_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_2_1_1.setBounds(1482, 159, 154, 35);
		contentPane.add(lblNewLabel_4_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(1646, 159, 239, 35);
		contentPane.add(textField_2);
	}
}
