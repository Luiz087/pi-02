package visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import raven.cell.TableActionEvent;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConfirmacao extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaConfirmacao dialog = new TelaConfirmacao(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param tableActionEvent 
	 * @param b 
	 * @param string 
	 * @param tableActionEvent 
	 */
	
	private boolean resultado;
	
	
	public TelaConfirmacao(JFrame essaJanela) {
		super(essaJanela, true);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setUndecorated(true);
				
		JButton btnNewButton = new JButton("CONFIRMAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultado = true;
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Krona One", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(128, 255, 0));
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setBounds(10, 232, 211, 57);
		contentPanel.add(btnNewButton);
		btnNewButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JButton btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultado = false;
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Krona One", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(64, 0, 0));
		btnNewButton_1.setBounds(229, 232, 211, 57);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaConfirmacao.class.getResource("/visao/imagens/excalama amarelo.png")));
		lblNewLabel.setBounds(175, 20, 100, 100);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tem certeza que");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 131, 414, 26);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("deseja continuar?");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 153, 414, 26);
		contentPanel.add(lblNewLabel_1_1);
		
	}
	
	public boolean getResult() {
	    return resultado;
	}
}
