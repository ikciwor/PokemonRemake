package Poke;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

public class Debug extends JFrame{
	
	Debug debug;
	
	public Debug(Battle battle)
	{
		Debug debug = new Debug(battle);
		pack();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawString("DEBUG: ", 10, 10);
	}


void round() {
	EventQueue.invokeLater(new Runnable() {
		@Override
		public void run() {

			while(true)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				debug.repaint();
			}

		}
	});
	}	
}