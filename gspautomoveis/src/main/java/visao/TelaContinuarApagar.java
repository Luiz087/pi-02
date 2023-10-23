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

public class TelaContinuarApagar extends JFrame {

	private JPanel contentPane;
	public boolean confirmado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaContinuarApagar frame = new TelaContinuarApagar();
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
	public TelaContinuarApagar() {
        // ... Código anterior ...
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        JButton btnVoltar = new JButton("VOLTAR");
        btnVoltar.setBackground(new Color(255, 255, 255));
        btnVoltar.setFont(new Font("Krona One", Font.PLAIN, 11));
        btnVoltar.setBounds(32, 233, 143, 36);
        contentPane.add(btnVoltar);
        btnVoltar.setBorder(new RoundedBorder(20));
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	confirmado = false;
                dispose();
            }
        });
        
		JLabel lblNewLabel_1 = new JLabel("DESEJA CONTINUAR?");
		lblNewLabel_1.setFont(new Font("Krona One", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(91, 145, 305, 77);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaContinuarApagar.class.getResource("/visao/imagens/excalama amarelo.png")));
		lblNewLabel.setBounds(178, 23, 143, 100);

        JButton btnSim = new JButton("SIM");
        btnSim.setBackground(new Color(255, 255, 255));
        btnSim.setFont(new Font("Krona One", Font.PLAIN, 11));
        btnSim.setBounds(275, 233, 143, 36);
        contentPane.add(btnSim);
        btnSim.setBorder(new RoundedBorder(20));
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(TelaContinuarApagar.class.getResource("/visao/imagens/excalama amarelo.png")));
        lblNewLabel_2.setBounds(173, 37, 100, 100);
        contentPane.add(lblNewLabel_2);
        btnSim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação ao clicar em SIM
                // Adicione aqui a lógica para continuar a execução
                // Exemplo: chamarMetodoParaContinuar();
            	confirmado = true;
            	dispose();
            }
        });
		
		

    }
	
	public boolean retornaConfirmado() {
		return confirmado;
		
	}
}
