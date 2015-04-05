package engine;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import framework.Gui;
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
//				FrameBuilt b = new FrameBuilt();

			}
		});
	}

}
