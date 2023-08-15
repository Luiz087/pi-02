package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaSucesso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSucesso frame = new TelaSucesso();
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
	public TelaSucesso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaSucesso.class.getResource("/visao/imagens/ok.png")));
		lblNewLabel.setBounds(178, 23, 143, 100);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("OPERAÇÃO CONCLUÍDA");
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(64, 123, 600, 77);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("COM SUCESSO");
		lblNewLabel_1_1.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(121, 168, 203, 77);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(255, 255, 255));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Krona One", Font.PLAIN, 11));
		btnNewButton.setBounds(151, 235, 143, 36);
		contentPane.add(btnNewButton);
		btnNewButton.setBorder(new RoundedBorder(20));
		
		
	}

}
