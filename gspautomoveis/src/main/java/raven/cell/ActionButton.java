package raven.cell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ActionButton extends JButton{
	
	private boolean mousePress;
	
	public ActionButton() {
		setContentAreaFilled(false);
		setBorder(new EmptyBorder(3,3,3, 3));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousePress=true;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mousePress=false;
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics g2=(Graphics2D)g.create();
		((Graphics2D) g2).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int witdh = getWidth();
		int heigth = getHeight();
		int size = Math.min(witdh, heigth);
		int x=(witdh-size)/2;
		int y = (heigth-size)/2;
		if(mousePress) {
			g2.setColor(Color.green);
		}else {
			g2.setColor(Color.yellow);
		}
		((Graphics2D) g2).fill(new  Ellipse2D.Double(x, y, size, size));
		g2.dispose();
		super.paintComponent(g);
	}
}
