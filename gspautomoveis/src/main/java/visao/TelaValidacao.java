package visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.FuncionarioDAO;
import controle.SendEmail;
import controle.SendSMS;
import raven.cell.TableActionEvent;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JTextField;

public class TelaValidacao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();
	private JTextField textCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaValidacao dialog = new TelaValidacao(null);
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

	public TelaValidacao(JFrame asd) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setUndecorated(true);

		JButton btnNewButton_1 = new JButton("ENVIAR");
		
		JButton btnValidar = new JButton("VALIDAR");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValidar.setForeground(new Color(64, 0, 0));
		btnValidar.setBackground(new Color(0, 255, 0));
		btnValidar.setFont(new Font("Krona One", Font.PLAIN, 14));
		btnValidar.setBounds(327, 232, 113, 57);
		contentPanel.add(btnValidar);

		JRadioButton checkSms = new JRadioButton("");
		checkSms.setForeground(new Color(255, 255, 255, 0));
		checkSms.setBackground(new Color(255, 255, 255, 0));
		checkSms.setHorizontalAlignment(SwingConstants.CENTER);
		checkSms.setBounds(141, 164, 21, 30);
		contentPanel.add(checkSms);

		JRadioButton checkEmail = new JRadioButton("");
		checkEmail.setForeground(new Color(255, 255, 255, 0));
		checkEmail.setBackground(new Color(255, 255, 255, 0));
		checkEmail.setHorizontalAlignment(SwingConstants.CENTER);
		checkEmail.setBounds(141, 195, 21, 30);
		contentPanel.add(checkEmail);

		btnNewButton_1.setFont(new Font("Krona One", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(67, 137, 203));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(10, 232, 430, 57);
		contentPanel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaValidacao.class.getResource("/visao/imagens/mensagem-cion.png")));
		lblNewLabel.setBounds(175, 20, 100, 100);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Validar seu usuário!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 119, 450, 26);
		contentPanel.add(lblNewLabel_1);

		JLabel lblMsg = new JLabel("");
		lblMsg.setIcon(new ImageIcon(
				TelaValidacao.class.getResource("/visao/imagens/f4beaa7e-e32c-464e-8283-08cb1834059b.png")));
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblMsg.setBounds(162, 168, 100, 26);
		contentPanel.add(lblMsg);
		lblMsg.setText("SMS");

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setIcon(new ImageIcon(
				TelaValidacao.class.getResource("/visao/imagens/5e8d82cc-4f43-4450-be22-8f30ab746642.png")));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblEmail.setBounds(162, 195, 125, 26);
		contentPanel.add(lblEmail);

		JLabel lblSelecionarOpcao = new JLabel("Selecione uma das opções!");
		lblSelecionarOpcao.setVisible(false);
		lblSelecionarOpcao.setForeground(new Color(255, 0, 0));
		lblSelecionarOpcao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecionarOpcao.setFont(new Font("Krona One", Font.PLAIN, 12));
		lblSelecionarOpcao.setBounds(0, 143, 450, 26);
		contentPanel.add(lblSelecionarOpcao);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Krona One", Font.PLAIN, 20));
		textCodigo.setBackground(new Color(255, 255, 255));
		textCodigo.setBounds(10, 232, 318, 57);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		textCodigo.setVisible(false);
		btnValidar.setVisible(false);
		
		checkSms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkEmail.isSelected()) {
					checkEmail.setSelected(false);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				checkSms.setBackground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				checkSms.setBackground(Color.WHITE);
			}
		});

		checkEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkSms.isSelected()) {
					checkSms.setSelected(false);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				checkEmail.setBackground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				checkEmail.setBackground(Color.WHITE);
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkSms.isSelected() && !checkEmail.isSelected()) {
					lblSelecionarOpcao.setVisible(true);
				} else if (checkSms.isSelected()) {
					Random random = new Random();
					StringBuilder codigo = new StringBuilder();

					for (int i = 0; i < 4; i++) {
						int digito = random.nextInt(10); // Gera números aleatórios de 0 a 9
						codigo.append(digito);
					}
					//SendSMS.mandarSMS(funcdao.passaLogado().getNome(), funcdao.passaLogado().getTelefone(), 1, null);
					btnNewButton_1.setVisible(false);
					textCodigo.setVisible(true);
					btnValidar.setVisible(true);
				} else {
					Random random = new Random();
					StringBuilder codigo = new StringBuilder();

					for (int i = 0; i < 4; i++) {
						int digito = random.nextInt(10); // Gera números aleatórios de 0 a 9
						codigo.append(digito);
					}
					//SendEmail.MandarEmail(funcdao.passaLogado().getEmail(), funcdao.passaLogado().getNome(), 1, codigo);
					btnNewButton_1.setVisible(false);
					textCodigo.setVisible(true);
					btnValidar.setVisible(true);
				}

			}
		});

	}
}
