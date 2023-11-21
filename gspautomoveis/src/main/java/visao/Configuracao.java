package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.mysql.cj.xdevapi.Table;

import controle.Conexao;
import controle.FuncionarioDAO;
import controle.Validacoes;
import modelo.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Configuracao extends JFrame {

	protected static Object textSenha;
	private JPanel contentPane;
	public static JTextField textUsuario;
	private JTextField textTel;
	public static JTextField textSen;
	private JTextField textEmail;
	private FuncionarioDAO funcdao = FuncionarioDAO.getInstancia();
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracao frame = new Configuracao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param princip
	 */
	public Configuracao() {
		setFont(new Font("Krona One", Font.PLAIN, 12));
		setTitle("Configurações");
		Funcionario func = new Funcionario();
		
		LineBorder redBorder = new LineBorder(Color.RED);
		LineBorder blackBorder = new LineBorder(Color.BLACK);

		func = funcdao.passaLogado();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textUsuario.setBorder(blackBorder);
				textSen.setBorder(blackBorder);
				textTel.setBorder(blackBorder);
				textEmail.setBorder(blackBorder);
			}
		});
		contentPane.setForeground(new Color(196, 155, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSair = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPrincipal princip = new TelaPrincipal();
				princip.setVisible(true);
				princip.setExtendedState(MAXIMIZED_BOTH);
				dispose();
			}
		});

		lblSair.setIcon(new ImageIcon(Configuracao.class.getResource("/visao/imagens/voltar.png")));
		lblSair.setBounds(828, 22, 40, 35);
		contentPane.add(lblSair);

		JLabel lblNewLabel_3_1 = new JLabel("CONFIGURAÇÕES");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(196, 155, 87));
		lblNewLabel_3_1.setFont(new Font("Krona One", Font.PLAIN, 33));
		lblNewLabel_3_1.setBounds(258, 113, 408, 72);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3 = new JLabel("GSP");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Krona One", Font.PLAIN, 99));
		lblNewLabel_3.setBounds(315, 22, 298, 80);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Configuracao.class.getResource("/visao/imagens/Logo sem fundo.png")));
		lblNewLabel_1.setBounds(59, 11, 175, 190);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Configuracao.class.getResource("/visao/imagens/bgcima.png")));
		lblNewLabel.setBounds(0, 0, 884, 208);
		contentPane.add(lblNewLabel);

		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblUsurio.setBounds(0, 319, 175, 38);
		contentPane.add(lblUsurio);

		textUsuario = new JTextField();
		textUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textUsuario.setBorder(blackBorder);
			}
		});
		textUsuario.setFont(new Font("Krona One", Font.PLAIN, 12));
		textUsuario.setColumns(10);
		textUsuario.setBounds(192, 319, 321, 38);
		contentPane.add(textUsuario);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblTelefone.setBounds(0, 373, 175, 38);
		contentPane.add(lblTelefone);

		MaskFormatter mascaraTel = null;
		try {
			mascaraTel = new MaskFormatter("(##)#####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textTel = new JFormattedTextField(mascaraTel);
		textTel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textTel.setBorder(blackBorder);
			}
		});
		textTel.setFont(new Font("Krona One", Font.PLAIN, 12));
		textTel.setColumns(10);
		textTel.setBounds(194, 373, 345, 38);
		contentPane.add(textTel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblSenha.setBounds(0, 431, 175, 38);
		contentPane.add(lblSenha);

		textSen = new JTextField();
		textSen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textSen.setBorder(blackBorder);
			}
		});
		textSen.setFont(new Font("Krona One", Font.PLAIN, 12));
		textSen.setColumns(10);
		textSen.setBounds(193, 431, 196, 38);
		contentPane.add(textSen);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblEmail.setBounds(0, 497, 175, 38);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textEmail.setBorder(blackBorder);
			}
		});
		textEmail.setFont(new Font("Krona One", Font.PLAIN, 12));
		textEmail.setColumns(10);
		textEmail.setBounds(193, 497, 675, 38);
		contentPane.add(textEmail);

		JFrame frame = this;

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario func1 = new Funcionario();
				String telefoneSting = textTel.getText().trim();
				telefoneSting = telefoneSting.replaceAll("[()\\s-]+", "");
				telefoneSting = telefoneSting.trim();

				if (!textUsuario.getText().trim().equals("") || !textID.getText().trim().equals("")
						|| Validacoes.validaEmail(textEmail.getText().trim()) || !textSen.getText().trim().equals("")
						|| !telefoneSting.equals("")) {
					func1.setMatricula(Integer.valueOf(textID.getText()));
					func1.setUsuario(textUsuario.getText().trim());
					func1.setTelefone(Validacoes.validaTelefone(textTel.getText().trim()));
					func1.setEmail(textEmail.getText().trim());
					func1.setSenha(textSen.getText());

					if (funcdao.ListarUsuarios(func1.getUsuario()) == null) {
						funcdao.atualizarFunc(func1);
					} else {
						TelaErro erro = new TelaErro(frame, "Usuário já existe no sistema!");
						erro.setLocationRelativeTo(null);
						erro.setVisible(true);
					}
				} else {
					erro("Preencha todos os dados!");
					if(textUsuario.getText().equals("")) {
						textUsuario.setBorder(redBorder);
					}
					if(telefoneSting.equals("")) {
						textTel.setBorder(redBorder);
					}
					if(textSen.getText().equals("")) {
						textSen.setBorder(redBorder);
					}
					if(textEmail.getText().equals("")) {
						textEmail.setBorder(redBorder);
					}
				}
			}
		});
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBorder(new RoundedBorder(10));
		btnAtualizar.setBackground(new Color(255, 218, 70));
		btnAtualizar.setBounds(348, 576, 251, 35);
		contentPane.add(btnAtualizar);

		JLabel lblId = new JLabel("Id:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblId.setBounds(0, 242, 175, 38);
		contentPane.add(lblId);

		textID = new JTextField();
		textID.setEditable(false);
		textID.setFont(new Font("Krona One", Font.PLAIN, 12));
		textID.setColumns(10);
		textID.setBounds(192, 242, 321, 38);
		contentPane.add(textID);

		try {
			textID.setText(String.valueOf(func.getMatricula()));
			textEmail.setText(func.getEmail());
			textTel.setText(String.valueOf(func.getTelefone()));
			textSen.setText(func.getSenha());
			textUsuario.setText(func.getUsuario());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	private void erro(String string) {
		TelaErro erro = new TelaErro((JFrame) this, string);
		erro.setLocationRelativeTo(null);
		erro.setVisible(true);
	}
}
