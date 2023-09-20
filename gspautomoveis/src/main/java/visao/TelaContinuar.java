package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaContinuar extends JFrame {

	private JPanel contentPane;
	public boolean confirmacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaContinuar frame = new TelaContinuar();
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
	public TelaContinuar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("DESEJA CONTINUAR?");
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(91, 145, 305, 77);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaContinuar.class.getResource("/visao/imagens/excalama amarelo.png")));
		lblNewLabel.setBounds(178, 23, 143, 100);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("VOLTAR");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				confirmacao = false;
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Krona One", Font.PLAIN, 11));
		btnNewButton_1.setBounds(32, 233, 143, 36);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setBorder(new RoundedBorder(20));

		JButton btnNewButton_1_1 = new JButton("SIM");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmacao = true;
			}
		});
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setFont(new Font("Krona One", Font.PLAIN, 11));
		btnNewButton_1_1.setBounds(275, 233, 143, 36);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1_1.setBorder(new RoundedBorder(20));

	}
}
