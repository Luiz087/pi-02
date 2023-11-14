package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.CarroDAO;
import controle.VendaDAO;
import modelo.Carro;
import modelo.Funcionario;
import modelo.Venda;
import ravenU.cell.TableActionCellEditorU;
import ravenU.cell.TableActionCellRenderU;
import ravenU.cell.TableActionEventU;

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
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class TelaHistoricoVeiculos extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JPanel panel;
	private CarroDAO carrodao = CarroDAO.getInstancia();
	private VendaDAO vendadao = VendaDAO.getInstancia();
	private JTextField comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHistoricoVeiculos frame = new TelaHistoricoVeiculos();
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
		setTitle("Histórico");
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
				TelaHistoricoVeiculos telaHV = new TelaHistoricoVeiculos();
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
		
		JPanel panel_6 = new JPanel();
		panel_6.setVisible(false);
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPrincipal prin = new TelaPrincipal();
				dispose();
				prin.setLocationRelativeTo(null);
				prin.setVisible(true);
			}
		});
		
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Home");
		lblNewLabel_4_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_2.setFont(new Font("Krona One", Font.PLAIN, 26));
		lblNewLabel_4_1_1_2.setBounds(80, 775, 254, 52);
		contentPane.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("");
		lblNewLabel_2_1_3.setIcon(new ImageIcon(TelaHistoricoVeiculos.class.getResource("/visao/imagens/casa.png")));
		lblNewLabel_2_1_3.setBounds(17, 792, 40, 35);
		contentPane.add(lblNewLabel_2_1_3);

		panel_6.setBounds(0, 931, 334, 63);
		contentPane.add(panel_6);
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
		panel_6.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 640, 334, 52);
		contentPane.add(panel);
		panel.setBackground(new Color(215, 215, 215, 50));
		panel_1.setBackground(new Color(215, 215, 215, 50));
		panel_2.setBackground(new Color(215, 215, 215, 50));
		panel_3.setBackground(new Color(215, 215, 215, 50));
		panel_4.setBackground(new Color(215, 215, 215, 50));
		panel_5.setBackground(new Color(215, 215, 215, 50));
		panel_6.setBackground(new Color(215, 215, 215, 50));

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

		JLabel lblNewLabel_3 = new JLabel("Histórico");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(50, 23, 254, 72);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon(TelaHistoricoVeiculos.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1.setBounds(76, 141, 175, 190);
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
		lblNewLabel_2_1_2
				.setIcon(new ImageIcon(TelaHistoricoVeiculos.class.getResource("/visao/imagens/bau veiculos.png")));
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
		lblNewLabel_2_1
				.setIcon(new ImageIcon(TelaHistoricoVeiculos.class.getResource("/visao/imagens/Engrenagem.png")));
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
				telafunc.setVisible(true);
			}
		});
		lblNewLabel_2_1_1.setIcon(new ImageIcon(TelaHistoricoVeiculos.class.getResource("/visao/imagens/Pessoa.png")));
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
				TelaHistoricoVeiculos telaHV = new TelaHistoricoVeiculos();
				dispose();
				telaHV.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaHV.setVisible(true);
			}
		});
		lblNewLabel_2_1_1_1
				.setIcon(new ImageIcon(TelaHistoricoVeiculos.class.getResource("/visao/imagens/carrinho compras.png")));
		lblNewLabel_2_1_1_1.setBounds(17, 645, 40, 35);
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("        Histórico");
		lblNewLabel_4_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHistoricoVeiculos telaHV = new TelaHistoricoVeiculos();
				dispose();
				telaHV.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaHV.setVisible(true);
			}

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
		lblNewLabel_2_1_1_1_1
				.setIcon(new ImageIcon(TelaHistoricoVeiculos.class.getResource("/visao/imagens/carro +.png")));
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(478, 253, 1271, 690);
		contentPane.add(scrollPane);
		// cadastrar nome das colunas
		table = new JTable();
		table.setFont(new Font("Krona One", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Cliente", "Cpf", "Telefone", "Endereço", "Data Venda", "Preço venda", "Ações" }));

		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1_1_1_1
				.setIcon(new ImageIcon(TelaHistoricoVeiculos.class.getResource("/visao/imagens/sair.png")));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(17, 931, 40, 63);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaHistoricoVeiculos.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel.setBounds(-14, -47, 361, 1141);
		contentPane.add(lblNewLabel);
		
		for (Venda venda : vendadao.ListarVendas()) {
			
			String[] partes = String.valueOf(venda.getDataVenda()).split("-");

			String primeiroParte = partes[0];
			String segundaParte = partes[1];
			String terceiroParte = partes[2];

			// Reorganiza as partes da string no formato desejado
			String resultado = terceiroParte + "/" + segundaParte + "/" + primeiroParte;

			DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
			String data[] = { venda.getNomeCliente(), String.valueOf(venda.getCpfCliente()), String.valueOf(venda.getTelefoneCliente()),
					venda.getEnderecoCliente(), resultado, String.valueOf(venda.getPrecoVenda())};
			tblModel.addRow(data);
		}
		table.setRowHeight(60);
		
		comboBox = new JTextField();
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(!comboBox.getText().isEmpty()) {
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.setRowCount(0);
					for (Venda venda : vendadao.buscaPorPalavra(String.valueOf(comboBox.getText()))) {
						String[] partes = String.valueOf(venda.getDataVenda()).split("-");

						String primeiroParte = partes[0];
						String segundaParte = partes[1];
						String terceiroParte = partes[2];

						String resultado = terceiroParte + "/" +  segundaParte + "/" + primeiroParte;

						DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
						String data[] = { venda.getNomeCliente(), String.valueOf(venda.getCpfCliente()), String.valueOf(venda.getTelefoneCliente()),
								venda.getEnderecoCliente(), resultado, String.valueOf(venda.getPrecoVenda())};
						tblModel.addRow(data);
					}
				} else {
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.setRowCount(0);
					for (Venda venda : vendadao.ListarVendas()) {
						
						String[] partes = String.valueOf(venda.getDataVenda()).split("-");

						String primeiroParte = partes[0];
						String segundaParte = partes[1];
						String terceiroParte = partes[2];

						// Reorganiza as partes da string no formato desejado
						String resultado = terceiroParte + "/" + segundaParte + "/" + primeiroParte;

						DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
						String data[] = { venda.getNomeCliente(), String.valueOf(venda.getCpfCliente()), String.valueOf(venda.getTelefoneCliente()),
								venda.getEnderecoCliente(), resultado, String.valueOf(venda.getPrecoVenda())};
						tblModel.addRow(data);
					}
				}
			}
		});
		table.getColumnModel().getColumn(6).setPreferredWidth(1);

		TableActionEventU eventU = new TableActionEventU(){
			@Override
			public void onEdit(int row) {
				//esse aqui tlg pai
			}

			@Override
			public void onDelete(int row) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onView(int row) {
				// TODO Auto-generated method stub
				
			}

		};
		table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRenderU());
		table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditorU(eventU));
		
		
		comboBox.setHorizontalAlignment(SwingConstants.CENTER);
		comboBox.setFont(new Font("Krona One", Font.PLAIN, 20));
		comboBox.setBounds(698, 52, 771, 63);
		contentPane.add(comboBox);
		comboBox.setColumns(10);

	}

	public static void AddRowToJtable(Object[] objects) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(objects);
		
		
	}
}
