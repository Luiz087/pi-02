package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class TelaFuncionarios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarios frame = new TelaFuncionarios();
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
	public TelaFuncionarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/visao/imagens/bglateral.png")));
		lblNewLabel.setBounds(0, -43, 350, 1205);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNome.setBounds(480, 238, 133, 38);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblCpf.setBounds(480, 287, 93, 38);
		contentPane.add(lblCpf);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblUsurio.setBounds(480, 336, 163, 38);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblSenha.setBounds(480, 385, 143, 38);
		contentPane.add(lblSenha);
		
		JLabel lblNome_4 = new JLabel("Nome:");
		lblNome_4.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNome_4.setBounds(480, 434, 133, 38);
		contentPane.add(lblNome_4);
		
		JLabel lblNome_5 = new JLabel("Nome:");
		lblNome_5.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNome_5.setBounds(480, 489, 133, 38);
		contentPane.add(lblNome_5);
		
		JLabel lblNome_6 = new JLabel("Nome:");
		lblNome_6.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNome_6.setBounds(480, 550, 133, 38);
		contentPane.add(lblNome_6);
		
		JLabel lblNome_7 = new JLabel("Nome:");
		lblNome_7.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNome_7.setBounds(480, 620, 133, 38);
		contentPane.add(lblNome_7);
		
		JLabel lblNome_8 = new JLabel("Nome:");
		lblNome_8.setFont(new Font("Krona One", Font.PLAIN, 30));
		lblNome_8.setBounds(480, 682, 133, 38);
		contentPane.add(lblNome_8);
	}

}
