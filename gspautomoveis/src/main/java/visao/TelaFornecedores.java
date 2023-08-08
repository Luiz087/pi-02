package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;

public class TelaFornecedores extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\pi-02\\gspautomoveis\\src\\main\\java\\visao\\imagens\\bglateral.png"));
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(-11, 0, 361, 1041);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNewLabel.setBounds(397, 25, 194, 88);
		contentPane.add(lblNewLabel);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblCnpj.setBounds(1403, 36, 106, 88);
		contentPane.add(lblCnpj);
		
		JLabel lblNewLabel_2 = new JLabel("Cidade");
		lblNewLabel_2.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(1169, 133, 150, 70);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblMarca.setBounds(624, 124, 127, 88);
		contentPane.add(lblMarca);
		
		JLabel lblTelfone = new JLabel("Telefone");
		lblTelfone.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblTelfone.setBounds(873, 36, 175, 88);
		contentPane.add(lblTelfone);
		
		textField = new JTextField();
		textField.setFont(new Font("Krona One", Font.PLAIN, 20));
		textField.setBounds(528, 49, 335, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Krona One", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(1058, 49, 335, 50);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Krona One", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(1519, 49, 335, 50);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Krona One", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(761, 147, 335, 50);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Krona One", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(1329, 147, 335, 50);
		contentPane.add(textField_4);
		
		JButton btnAdicionar = new JButton("Adicionar\r\n");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setFont(new Font("Krona One", Font.PLAIN, 20));
		btnAdicionar.setBounds(1069, 264, 261, 35);
		btnAdicionar.setBorder(new RoundedBorder(10));
		contentPane.add(btnAdicionar);
	}
}
