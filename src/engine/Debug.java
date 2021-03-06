package engine;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Debug extends JFrame{
	
	Debug debug;
	
	JButton loadDefault = new JButton("LOAD");
	
	Random rand = new Random();
	
	final Battle battle;
	
	JLabel Hp0 = new JLabel("Hp_0= ");
	JLabel Spieces0 = new JLabel("Spieces_0= ");
	JLabel Hp1 = new JLabel("Hp_1= ");
	JLabel Spieces1 = new JLabel("Spieces_1= ");
	
	JLabel currentPlayer = new JLabel();
	Thread loop = new Thread();
	
	public Debug(Battle battleabc)
	{
		pack();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLayout(new GridLayout(3, 2));
		

		
		this.battle = battleabc;
		add(loadDefault);
		loadDefault.setBounds(10, 10, 40, 40);
		add(currentPlayer);
		add(Hp0);
		add(Hp1);
		add(Spieces0);
		add(Spieces1);
		
		loadDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable(){
					@Override
					public void run() {

//						while(true)
//						{
							int mh0, h0, mh1, h1;
							try{
								mh0=battle.pok[0].getPokemon().maxhp;
								h0=battle.pok[0].getPokemon().hp;
								Hp0.setText("Hp: " + h0 + "/" + mh0);
								mh1=battle.pok[1].getPokemon().maxhp;
								h1=battle.pok[1].getPokemon().hp;
								Hp1.setText("Hp: " + h1 + "/" + mh1);
								
								currentPlayer.setText("Player: " + battle.getCurrentPlayer());
								loadDefault.setText("ok:" + (rand.nextInt()%10));
								
							} catch(NullPointerException e){
								loadDefault.setText("NullPointerException");
							}
							
//							try {
//								JOptionPane.showMessageDialog(new JFrame(), "TROLOLO");
//								Thread.sleep(5000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
							//debug.repaint();
//						}

					}
				});

			}
		});
		 Thread thread = new Thread(){
			    public void run(){
			    	int randv=0;
			    	while(true)
						{
							int mh0, h0, mh1, h1;
							try{
								mh0=battle.pok[0].getPokemon().maxhp;
								h0=battle.pok[0].getPokemon().hp;
								Hp0.setText("Hp: " + h0 + "/" + mh0);
								mh1=battle.pok[1].getPokemon().maxhp;
								h1=battle.pok[1].getPokemon().hp;
								Hp1.setText("Hp: " + h1 + "/" + mh1);
								
								currentPlayer.setText("Player: " + battle.getCurrentPlayer());
								++randv;
								randv%=8;
								if (randv==0)
									loadDefault.setText("Work: " + "--");
								else if (randv==1)
									loadDefault.setText("Work: " + "\\ ");
								else if (randv==2)
									loadDefault.setText("Work: " + "| ");
								else if (randv==3)
									loadDefault.setText("Work: " + "/ ");
								else if (randv==4)
									loadDefault.setText("Work: " + "--");
								else if (randv==5)
									loadDefault.setText("Work: " + "\\ ");	
								else if (randv==6)
									loadDefault.setText("Work: " + "| ");		
								else if (randv==7)
									loadDefault.setText("Work: " + "/ ");
									
								
							} catch(NullPointerException e){
								loadDefault.setText("NullPointerException");
							}
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
//							try {
//								JOptionPane.showMessageDialog(new JFrame(), "TROLOLO");
//								Thread.sleep(5000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							debug.repaint();
						}
			    }
			  };

			  thread.start();
		
//		round();
		
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
	EventQueue.invokeLater(new Runnable(){
		@Override
		public void run() {

			//while(true)
			{
				int mh0, h0, mh1, h1;
				try{
					mh0=battle.pok[0].getPokemon().maxhp;
					h0=battle.pok[0].getPokemon().hp;
					Hp0.setText("Hp: " + h0 + "/" + mh0);
					mh1=battle.pok[1].getPokemon().maxhp;
					h1=battle.pok[1].getPokemon().hp;
					Hp1.setText("Hp: " + h1 + "/" + mh1);
					
					currentPlayer.setText("Player: " + battle.getCurrentPlayer());
					loadDefault.setText("ok:" + (rand.nextInt()%2==0? 1 : 0));
					
				} catch(NullPointerException e){
					loadDefault.setText("NullPointerException");
				}
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//debug.repaint();
			}

		}
	});
	}
}