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
	public boolean confirmado;

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
        // ... Código anterior ...

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

        JButton btnSim = new JButton("SIM");
        btnSim.setBackground(new Color(255, 255, 255));
        btnSim.setFont(new Font("Krona One", Font.PLAIN, 11));
        btnSim.setBounds(275, 233, 143, 36);
        contentPane.add(btnSim);
        btnSim.setBorder(new RoundedBorder(20));
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
