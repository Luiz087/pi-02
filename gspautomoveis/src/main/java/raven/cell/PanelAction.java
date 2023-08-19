package raven.cell;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelAction extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAction frame = new PanelAction();
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
	
	public void initEvent(TableActionEvent event, int row) {
		cmdDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				event.onEdit(row);
			}
		});
		
		cmdEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				event.onDelete(row);
			}
		});
		
	}
	public PanelAction() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 179, 79);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton cmdDelete = new JButton("");
		cmdDelete.setBounds(35, 10, 51, 27);
		cmdDelete.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\delete.png"));
		contentPane.add(cmdDelete);
		
		JButton cmdEdit = new JButton("");
		cmdEdit.setBounds(91, 10, 51, 27);
		cmdEdit.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\edit.png"));
		contentPane.add(cmdEdit);
	}


}
