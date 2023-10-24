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

public class TelaErro extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaErro dialog = new TelaErro(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param tableActionEvent
	 * @param b
	 * @param string
	 * @param tableActionEvent
	 */

	public TelaErro(JFrame asd, String string) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setUndecorated(true);

		JButton btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Krona One", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(64, 0, 0));
		btnNewButton_1.setBounds(10, 232, 430, 57);
		contentPanel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaErro.class.getResource("/visao/imagens/exclama.png")));
		lblNewLabel.setBounds(175, 20, 100, 100);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ocorreu um erro!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 131, 450, 26);
		contentPanel.add(lblNewLabel_1);

		JLabel lblMsg = new JLabel("");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblMsg.setBounds(0, 170, 450, 26);
		contentPanel.add(lblMsg);
		lblMsg.setText(string);

	}
}
