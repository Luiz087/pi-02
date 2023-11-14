package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AmadoBatista extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblFuncionario;
	private JLabel lblCliente;
	private JLabel lblEdit;
	private JLabel lblEdit_1;
	private JLabel lblEdit_2;
	private JLabel lblEdit_3;
	private JLabel lblEdit_4;
	private JLabel lblFuncionario_6;
	private JLabel lblFuncionario_7;
	private JLabel lblFuncionario_8;
	private JLabel lblFuncionario_9;
	private JLabel lblFuncionario_10;
	private JLabel lblFuncionario_11;
	private JLabel lblFuncionario_12;
	private JLabel lblFuncionario_13;
	private JLabel lblFuncionario_14;
	private JLabel lblFuncionario_15;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmadoBatista frame = new AmadoBatista();
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
	public AmadoBatista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AmadoBatista.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_2.setBounds(311, 0, 190, 183);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AmadoBatista.class.getResource("/visao/imagens/bgcima.png")));
		lblNewLabel_1.setBounds(0, 0, 884, 172);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("CARRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(10, 183, 78, 17);
		contentPane.add(lblNewLabel);
		
		lblFuncionario = new JLabel("FUNCIONÁRIO");
		lblFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario.setBounds(311, 177, 156, 28);
		contentPane.add(lblFuncionario);
		
		lblCliente = new JLabel("CLIENTE");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCliente.setBounds(667, 177, 108, 23);
		contentPane.add(lblCliente);
		
		lblEdit = new JLabel("edit");
		lblEdit.setHorizontalAlignment(SwingConstants.LEFT);
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEdit.setBounds(10, 237, 156, 28);
		contentPane.add(lblEdit);
		
		lblEdit_1 = new JLabel("edit");
		lblEdit_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEdit_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEdit_1.setBounds(10, 300, 156, 28);
		contentPane.add(lblEdit_1);
		
		lblEdit_2 = new JLabel("edit");
		lblEdit_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEdit_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEdit_2.setBounds(10, 371, 156, 28);
		contentPane.add(lblEdit_2);
		
		lblEdit_3 = new JLabel("edit");
		lblEdit_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblEdit_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEdit_3.setBounds(10, 445, 156, 28);
		contentPane.add(lblEdit_3);
		
		lblEdit_4 = new JLabel("edit");
		lblEdit_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblEdit_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEdit_4.setBounds(10, 508, 156, 28);
		contentPane.add(lblEdit_4);
		
		lblFuncionario_6 = new JLabel("edit");
		lblFuncionario_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario_6.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario_6.setBounds(311, 237, 156, 28);
		contentPane.add(lblFuncionario_6);
		
		lblFuncionario_7 = new JLabel("edit");
		lblFuncionario_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario_7.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario_7.setBounds(311, 300, 156, 28);
		contentPane.add(lblFuncionario_7);
		
		lblFuncionario_8 = new JLabel("edit");
		lblFuncionario_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario_8.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario_8.setBounds(311, 371, 156, 28);
		contentPane.add(lblFuncionario_8);
		
		lblFuncionario_9 = new JLabel("edit");
		lblFuncionario_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario_9.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario_9.setBounds(311, 445, 156, 28);
		contentPane.add(lblFuncionario_9);
		
		lblFuncionario_10 = new JLabel("edit");
		lblFuncionario_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario_10.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario_10.setBounds(311, 508, 156, 28);
		contentPane.add(lblFuncionario_10);
		
		lblFuncionario_11 = new JLabel("edit");
		lblFuncionario_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario_11.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario_11.setBounds(667, 237, 156, 28);
		contentPane.add(lblFuncionario_11);
		
		lblFuncionario_12 = new JLabel("edit");
		lblFuncionario_12.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario_12.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario_12.setBounds(667, 300, 156, 28);
		contentPane.add(lblFuncionario_12);
		
		lblFuncionario_13 = new JLabel("edit");
		lblFuncionario_13.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario_13.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario_13.setBounds(667, 371, 156, 28);
		contentPane.add(lblFuncionario_13);
		
		lblFuncionario_14 = new JLabel("edit");
		lblFuncionario_14.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario_14.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario_14.setBounds(667, 445, 156, 28);
		contentPane.add(lblFuncionario_14);
		
		lblFuncionario_15 = new JLabel("edit");
		lblFuncionario_15.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionario_15.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFuncionario_15.setBounds(667, 508, 156, 28);
		contentPane.add(lblFuncionario_15);
	}
}
