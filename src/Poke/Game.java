package Poke;
import java.awt.EventQueue;


import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
@SuppressWarnings("serial")



public class Game extends JPanel{
	
	
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		setFocusable(true);
	}

	
	
	public static void main(String[] args) throws InterruptedException  {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Gui gui = new Gui();

			}
		});
	}

}
