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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendas frame = new TelaVendas();
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
	public TelaVendas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				TelaVendas telaHV = new TelaVendas();
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
		
		panel_5.setBounds(0, 931, 334, 63);
		contentPane.add(panel_5);
		panel_4.setBounds(0, 399, 334, 63);
		contentPane.add(panel_4);
		panel_3.setBounds(0, 482, 334, 56);
		contentPane.add(panel_3);
		panel_2.setBounds(0, 564, 334, 52);
		contentPane.add(panel_2);
		panel_1.setBounds(0, 711, 334, 52);
		contentPane.add(panel_1);
		panel.setForeground(new Color(0, 0, 0));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_2.setForeground(new Color(0, 0, 0));
		panel_3.setForeground(new Color(0, 0, 0));
		panel_4.setForeground(new Color(0, 0, 0));
		panel_5.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 640, 334, 52);
		contentPane.add(panel);
		panel.setBackground(new Color(215, 215,215, 50));
		panel_1.setBackground(new Color(215, 215,215, 50));
		panel_2.setBackground(new Color(215, 215,215, 50));
		panel_3.setBackground(new Color(215, 215,215, 50));
		panel_4.setBackground(new Color(215, 215,215, 50));
		panel_5.setBackground(new Color(215, 215,215, 50));
		
		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("       Sair");
		lblNewLabel_4_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setVisible(true);

			}
		});
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNewLabel_4_1_1_1_1_1_1.setBounds(0, 936, 334, 58);
		contentPane.add(lblNewLabel_4_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 57));
		lblNewLabel_3.setBounds(63, 43, 166, 72);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1.setBounds(63, 141, 175, 190);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVeiculos telaveic = new TelaVeiculos();
				dispose();
				telaveic.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaveic.setVisible(true);
			}
		});
		lblNewLabel_2_1_2.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/bau veiculos.png")));
		lblNewLabel_2_1_2.setBounds(17, 410, 40, 35);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("        Veículos");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVeiculos telaveic = new TelaVeiculos();
				dispose();
				telaveic.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaveic.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setVisible(true);

			}
		});
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(0, 399, 328, 63);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Configuracao telaconfig = new Configuracao();
				dispose();
				telaconfig.setLocationRelativeTo(null);
				telaconfig.setVisible(true);
			}
		});
		lblNewLabel_2_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/Engrenagem.png")));
		lblNewLabel_2_1.setBounds(17, 490, 40, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("       Configurações");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Configuracao telaconfig = new Configuracao();
				dispose();
				telaconfig.setLocationRelativeTo(null);
				telaconfig.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setVisible(true);

			}
		});
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1.setBounds(0, 482, 328, 56);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFuncionarios telafunc = new TelaFuncionarios();
				dispose();
				telafunc.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telafunc.setVisible(true);			}
		});
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/Pessoa.png")));
		lblNewLabel_2_1_1.setBounds(17, 570, 40, 35);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("    Funcionários");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
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
		lblNewLabel_4_1_1.setBounds(0, 564, 328, 52);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVendas telaHV = new TelaVendas();
				dispose();
				telaHV.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaHV.setVisible(true);	
			}
		});
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/carrinho compras.png")));
		lblNewLabel_2_1_1_1.setBounds(17, 645, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("        Histórico");
		lblNewLabel_4_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaVendas telaHV = new TelaVendas();
				dispose();
				telaHV.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaHV.setVisible(true);			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setVisible(true);

			}
		});
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_1.setBounds(0, 640, 334, 52);
		contentPane.add(lblNewLabel_4_1_1_1);
		
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
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/carro +.png")));
		lblNewLabel_2_1_1_1_1.setBounds(17, 717, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("     Fornecedores");
		lblNewLabel_4_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
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
		lblNewLabel_4_1_1_1_1.setBounds(0, 711, 334, 52);
		contentPane.add(lblNewLabel_4_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/sair.png")));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(17, 931, 40, 63);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaVendas.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel.setBounds(-14, -47, 361, 1141);
		contentPane.add(lblNewLabel);
		
		JLabel lblMarca = new JLabel("Nome:");
		lblMarca.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblMarca.setBounds(483, 177, 114, 38);
		contentPane.add(lblMarca);
		
		textField = new JTextField();
		textField.setFont(new Font("Krona One", Font.PLAIN, 14));
		textField.setBounds(607, 177, 233, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpfCliente = new JLabel("CPF:");
		lblCpfCliente.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpfCliente.setBounds(1002, 177, 74, 38);
		contentPane.add(lblCpfCliente);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Krona One", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(1086, 177, 233, 38);
		contentPane.add(textField_1);
		
		JLabel lblTelefoneCliente = new JLabel("Telefone:");
		lblTelefoneCliente.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblTelefoneCliente.setBounds(1428, 177, 157, 38);
		contentPane.add(lblTelefoneCliente);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Krona One", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(1595, 177, 233, 38);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Krona One", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(1595, 340, 233, 38);
		contentPane.add(textField_3);
		
		JLabel lblBairro = new JLabel("CEP:");
		lblBairro.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblBairro.setBounds(1492, 340, 93, 38);
		contentPane.add(lblBairro);
		
		JLabel lblCidae = new JLabel("Cidade:");
		lblCidae.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblCidae.setBounds(934, 340, 132, 38);
		contentPane.add(lblCidae);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Krona One", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(1086, 340, 233, 38);
		contentPane.add(textField_4);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblEstado.setBounds(447, 500, 143, 38);
		contentPane.add(lblEstado);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Krona One", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(607, 503, 233, 38);
		contentPane.add(textField_5);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblRua.setBounds(981, 503, 85, 38);
		contentPane.add(lblRua);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Krona One", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(1086, 503, 233, 38);
		contentPane.add(textField_6);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblData.setBounds(497, 665, 93, 38);
		contentPane.add(lblData);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Krona One", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(607, 670, 233, 38);
		contentPane.add(textField_7);
		
		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblPreo.setBounds(940, 665, 126, 38);
		contentPane.add(lblPreo);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Krona One", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(1086, 665, 233, 38);
		contentPane.add(textField_8);
		
		JLabel lblCep = new JLabel("Bairro:");
		lblCep.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblCep.setBounds(476, 340, 114, 38);
		contentPane.add(lblCep);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Krona One", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(607, 340, 233, 38);
		contentPane.add(textField_9);
		
		JButton btnNewButton = new JButton("Vender");
		btnNewButton.setFont(new Font("Krona One", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(940, 842, 251, 35);
		contentPane.add(btnNewButton);

		
	}
}

