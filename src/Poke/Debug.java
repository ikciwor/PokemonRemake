package Poke;

import java.awt.BorderLayout;
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

import Poke.Type;

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

//				PokemonBattling pok[] = new PokemonBattling[2];
//				pok[0] = battle.pok[0];
//				pok[1] = battle.pok[1];
//				
//				
//				for(int i=0; i<2; ++i)
//				{
//					pok[i].atk=100;
//					pok[i].def=100;
//					pok[i].spd=100;
//					pok[i].spdef=100;
//					pok[i].spatk=100;
//					pok[i].maxhp=100;
//					pok[i].hp=100;
//					
//
//					
//
//				}
				
				EventQueue.invokeLater(new Runnable(){
					@Override
					public void run() {

						while(true)
						{
							int mh0, h0, mh1, h1;
							try{
								mh0=battle.pok[0].maxhp;
								h0=battle.pok[0].hp;
								Hp0.setText("Hp: " + h0 + "/" + mh0);
								mh1=battle.pok[1].maxhp;
								h1=battle.pok[1].hp;
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
		});
		
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
					mh0=battle.pok[0].maxhp;
					h0=battle.pok[0].hp;
					Hp0.setText("Hp: " + h0 + "/" + mh0);
					mh1=battle.pok[1].maxhp;
					h1=battle.pok[1].hp;
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