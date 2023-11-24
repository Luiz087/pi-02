package visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.FuncionarioDAO;
import controle.SendEmail;
import controle.SendSMS;
import raven.cell.TableActionEvent;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaValidacao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();
	private JTextField textCodigo;
	private StringBuilder codigoGuardado;
	private JLabel lblTimer;
	private Timer timer;
	private Integer tipoMsg;

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

		JButton btnEnviarMsg = new JButton("ENVIAR");

		JLabel lblMenssagem = new JLabel("Selecione uma das opções!");
		lblMenssagem.setVerticalAlignment(SwingConstants.TOP);
		lblMenssagem.setVisible(false);
		lblMenssagem.setForeground(new Color(255, 0, 0));
		lblMenssagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenssagem.setFont(new Font("Krona One", Font.PLAIN, 12));
		lblMenssagem.setBounds(0, 150, 450, 16);
		contentPanel.add(lblMenssagem);

		JButton btnSairValidado = new JButton("FECHAR");
		btnSairValidado.setForeground(Color.WHITE);
		btnSairValidado.setFont(new Font("Krona One", Font.PLAIN, 15));
		btnSairValidado.setBackground(new Color(43, 45, 113));
		btnSairValidado.setBounds(10, 232, 430, 57);
		contentPanel.add(btnSairValidado);
		btnSairValidado.setVisible(false);

		JLabel gifEsperando = new JLabel("");
		gifEsperando.setIcon(new ImageIcon(TelaValidacao.class.getResource("/visao/imagens/esperandoResposta.gif")));
		gifEsperando.setBounds(175, 20, 100, 100);
		contentPanel.add(gifEsperando);

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

		btnEnviarMsg.setFont(new Font("Krona One", Font.PLAIN, 15));
		btnEnviarMsg.setBackground(new Color(67, 137, 203));
		btnEnviarMsg.setForeground(new Color(255, 255, 255));
		btnEnviarMsg.setBounds(10, 232, 430, 57);
		contentPanel.add(btnEnviarMsg);

		JLabel imgConversa = new JLabel("");
		imgConversa.setIcon(new ImageIcon(TelaValidacao.class.getResource("/visao/imagens/mensagem-cion.png")));
		imgConversa.setBounds(175, 20, 100, 100);
		contentPanel.add(imgConversa);

		JLabel lblMSGPrincipal = new JLabel("Validar seu usuário!");
		lblMSGPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMSGPrincipal.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblMSGPrincipal.setBounds(0, 119, 450, 26);
		contentPanel.add(lblMSGPrincipal);

		JLabel lblMenssagem2 = new JLabel("");
		lblMenssagem2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenssagem2.setFont(new Font("Krona One", Font.PLAIN, 12));
		lblMenssagem2.setBounds(0, 164, 450, 16);
		contentPanel.add(lblMenssagem2);
		lblMenssagem2.setVisible(false);

		JLabel lblSms = new JLabel("");
		lblSms.setIcon(new ImageIcon(TelaValidacao.class.getResource("/visao/imagens/msgPontinho.png")));
		lblSms.setHorizontalAlignment(SwingConstants.CENTER);
		lblSms.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblSms.setBounds(162, 168, 100, 26);
		contentPanel.add(lblSms);
		lblSms.setText("SMS");

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setIcon(new ImageIcon(TelaValidacao.class.getResource("/visao/imagens/emailTracado.png")));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblEmail.setBounds(162, 195, 125, 26);
		contentPanel.add(lblEmail);
		
		JLabel gifValidado = new JLabel("");
		gifValidado.setIcon(new ImageIcon(TelaValidacao.class.getResource("/visao/imagens/validado.gif")));
		gifValidado.setBounds(125, 20, 200, 100);
		contentPanel.add(gifValidado);

		MaskFormatter codigoMask = null;
		try {
			codigoMask = new MaskFormatter("####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textCodigo = new JFormattedTextField(codigoMask);
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (textCodigo.getText().trim().length() == 4) {
					//if (textCodigo.getText().equals(codigoGuardado.toString())) {
						if (funcdao.validar()) {
							gifEsperando.setVisible(false);
							gifValidado.setVisible(true);
							lblMSGPrincipal.setText("Parabéns, " + funcdao.passaLogado().getNome() + "!");
							lblMenssagem.setText("Sua conta foi validada com sucesso.");
							lblMenssagem2.setText("Aproveite o sistema!");
							lblMenssagem.setForeground(Color.BLACK);
							btnSairValidado.setVisible(true);
							lblMenssagem2.setVisible(true);
							lblTimer.setVisible(false);
							textCodigo.setVisible(false);
						} else {
							lblMenssagem.setText("Erro ao validar conta. Tente novamente!");
						}
					//} else {
						//lblMenssagem.setText("Código incorreto. Insira novamente ou gere outro.");
					//}
				} else {
					Integer cont = 4 - textCodigo.getText().trim().length();
					lblMenssagem.setText("Faltam " + cont + " números!");
				}
			}
		});
		textCodigo.setFont(new Font("Krona One", Font.PLAIN, 20));
		textCodigo.setBackground(new Color(255, 255, 255));
		textCodigo.setBounds(10, 232, 430, 57);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel imgSair = new JLabel("");
		imgSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaPrincipal princip = new TelaPrincipal();
					princip.checkValidacao();
				} catch (Exception e2) {
					System.out.println("Não tava logado");
				}
				dispose();
			}
		});
		imgSair.setIcon(new ImageIcon(TelaValidacao.class.getResource("/visao/imagens/voltar.png")));
		imgSair.setBounds(404, 11, 36, 30);
		contentPanel.add(imgSair);

		lblTimer = new JLabel("");
		lblTimer.setFont(new Font("Krona One", Font.PLAIN, 10));
		lblTimer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimer.setBounds(272, 207, 168, 14);
		contentPanel.add(lblTimer);
		gifValidado.setVisible(false);
		textCodigo.setVisible(false);
		gifEsperando.setVisible(false);
		

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

		btnEnviarMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkSms.isSelected() && !checkEmail.isSelected()) {
					lblMenssagem.setVisible(true);
				} else if (checkSms.isSelected()) {
					tipoMsg = 1;
					StringBuilder codigo = geradorCodigo();
					/*try {
						SendSMS.mandarSMS(funcdao.passaLogado().getNome(), funcdao.passaLogado().getTelefone(), 1,
								codigo);
					} catch (Exception e2) {
						System.out.println("só não tava logado");
					}*/
					btnEnviarMsg.setVisible(false);
					checkSms.setVisible(false);
					checkEmail.setVisible(false);
					lblSms.setVisible(false);
					lblEmail.setVisible(false);
					textCodigo.setVisible(true);
					gifEsperando.setVisible(true);
					imgConversa.setVisible(false);
					lblMSGPrincipal.setText("Seu código está a caminho!!");
					lblMenssagem.setText("Olhe sua caixa de entrada");
					lblMenssagem.setVisible(true);
					lblMenssagem.setForeground(Color.BLACK);
				} else {
					tipoMsg = 2;
					StringBuilder codigo = geradorCodigo();
					/*try {
						SendEmail.MandarEmail(funcdao.passaLogado().getEmail(), funcdao.passaLogado().getNome(), 3,
								codigo);
					} catch (Exception e2) {
						System.out.println("só não tava logado");
					}*/
					btnEnviarMsg.setVisible(false);
					checkSms.setVisible(false);
					checkEmail.setVisible(false);
					lblSms.setVisible(false);
					lblEmail.setVisible(false);
					textCodigo.setVisible(true);
					gifEsperando.setVisible(true);
					imgConversa.setVisible(false);
					lblMSGPrincipal.setText("Seu código está a caminho!!");
					lblMenssagem.setText("Olhe sua caixa de entrada");
					lblMenssagem.setVisible(true);
					lblMenssagem.setForeground(Color.BLACK);
					iniciarContagemRegressiva();
				}

			}
		});

		btnSairValidado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaPrincipal princip = new TelaPrincipal();
					princip.checkValidacao();
				} catch (Exception e2) {
					System.out.println("Não tava logado");
				}
				dispose();
			}
		});

	}

	private StringBuilder geradorCodigo() {
		Random random = new Random();
		StringBuilder codigo = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			int digito = random.nextInt(10);
			codigo.append(digito);
		}
		codigoGuardado = codigo;
		return codigo;
	}

	private Integer iniciarContagemRegressiva() {
		AtomicInteger segundos = new AtomicInteger(60);
		lblTimer.setText(Integer.toString(segundos.get()));
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				segundos.decrementAndGet();
				lblTimer.setText("Reenviar código (" + Integer.toString(segundos.get()) + ")");

				if (segundos.get() <= 0) {
					timer.cancel();
					lblTimer.setText("Reenviar Código");
					lblTimer.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							lblTimer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						}

						@Override
						public void mouseExited(MouseEvent e) {
							lblTimer.setCursor(Cursor.getDefaultCursor());
						}

						@Override
						public void mouseClicked(MouseEvent e) {
							if (tipoMsg == 1) {
								StringBuilder codigo = geradorCodigo();
								//SendSMS.mandarSMS(funcdao.passaLogado().getNome(), funcdao.passaLogado().getTelefone(),
										//1, codigo);
							} else if (tipoMsg == 2) {
								StringBuilder codigo = geradorCodigo();
								//SendEmail.MandarEmail(funcdao.passaLogado().getEmail(), funcdao.passaLogado().getNome(),
										//3, codigo);
							}
							lblTimer.setVisible(false);
						}
					});
				}
			}
		}, 1000, 1000);
		return 1;
	}

}
