package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaErro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaErro frame = new TelaErro();
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
	public TelaErro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(376, 11, 74, 23);
		btnNewButton.setBorder(null);
		btnNewButton.setFocusPainted(false);

		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(telaLoginIncorreto.class.getResource("/visao/imagens/exclama.png")));
		lblNewLabel.setBounds(178, 23, 143, 100);
		contentPane.add(lblNewLabel);
		

		JLabel lblNewLabel_1 = new JLabel("OCORREU UM ERRO");
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(93, 134, 600, 77);
		contentPane.add(lblNewLabel_1);
		
	
		
	}
}
