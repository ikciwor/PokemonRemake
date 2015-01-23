package Poke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Frame extends JFrame{
	private static final long serialVersionUID = 345924759794811391L;

	public static int HEIGHT=650, WIDTH=650;
	
	
	/*
	 * Ekrany:
	 * 	1. start - przycisk start
	 * 	2. wybór poków - przycisk go, add, add2, remove, remove2, 4x combobox, 2x label x9, 2x label poków (label x18)
	 * 	3. walka - combobox ataków, przycisk zmiana poka, przycisk atak, 4 ataki
	 *  4. zmiana pokemona - combobox poków, 2 przyciski wybór i cancel, label x8: obrazek, nazwa, hp, def, atk, spdef, spatk, spd
	 * 	5. wynik - przycisk do wyjcia i startu, label lose/win
	 * 
	 * 	suma: przycisk x13, combobox x5, label x10
	 * 
	 */
	String fe = new String("EXAMPLE");
	
	Rectangle hp1 = new Rectangle();
	Rectangle hp2 = new Rectangle(); //paski hp
	
	JButton TESTER = new JButton("TEST");
	
	JButton at1 = new JButton("TEST1");
	JButton at2 = new JButton("TEST2");
	JButton at3 = new JButton("TEST3");
	JButton at4 = new JButton("TEST4");
	
	JButton start = new JButton("START");
	
	JButton go = new JButton("PLAY");
	
	static final JComboBox<String> poki2 = new JComboBox<String>();
	static final JComboBox<String> poki = new JComboBox<String>();
	
	static JComboBox<String> party = new JComboBox<String>();
	static JComboBox<String> party2 = new JComboBox<String>();
	
	JButton add = new JButton("v");
	JButton remove = new JButton("^");
	JButton add2 = new JButton("v");
	JButton remove2 = new JButton("^");
	
	JButton fight = new JButton("FIGHT");
	JButton change = new JButton("CHANGE");
	
	JButton switchpkmn = new JButton("SWITCH");
	
	JButton exit = new JButton("START");
	
	JButton cancel = new JButton("Cancel");

	public JLabel[] staty = new JLabel[8]; // obrazek, nazwa, hp, def, atk, spdef, spatk, spd
	public JLabel[] staty2 = new JLabel[8];
	
	JPanel hello = new JPanel();
	JPanel wybor = new JPanel();
	JPanel walka = new JPanel();
	JPanel wynik = new JPanel();
	JPanel zmiana = new JPanel();
	
	JPanel previousPanel;

	int typ;
	
	
	Game game = new Game();
	
	public Frame(){
		
		
	    setTitle("Halo");
	    setLayout(null);
	    
	    add(hello, BorderLayout.CENTER);
	    hello.setBounds(0,0,WIDTH,HEIGHT);
	    hello.setLayout(null);
	    
	    add(wybor, BorderLayout.CENTER);
	    wybor.setBounds(0,0,WIDTH,HEIGHT);
	    wybor.setLayout(null);
	    
	    add(walka, BorderLayout.CENTER);
	    walka.setBounds(0,0,WIDTH,HEIGHT);
	    walka.setLayout(null);
	    
	    add(wynik, BorderLayout.CENTER);
	    wynik.setBounds(0,0,WIDTH,HEIGHT);
	    wynik.setLayout(null);
		setUndecorated(true);
		
	    add(zmiana, BorderLayout.CENTER);
	    zmiana.setBounds(0,0,WIDTH,HEIGHT);
	    zmiana.setLayout(null);
		setUndecorated(true);
		
	    pack();
	    setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);

		
		add(game);

		gen();
		genZmiana();
		//genWybor();
		
	}
	
	void gen()
	{
	}
	
	void genHello()
	{
		hello.setVisible(true);
		wybor.setVisible(false);
		walka.setVisible(false);
		zmiana.setVisible(false);
		wynik.setVisible(false);

		hello.add(start, BorderLayout.SOUTH);
		hello.setBounds(10, 10, 20, 20);
	}
	
	void genWybor()
	{
		hello.setVisible(false);
		wybor.setVisible(true);
		walka.setVisible(false);
		zmiana.setVisible(false);
		wynik.setVisible(false);
		
		wybor.add(go, BorderLayout.SOUTH);
		go.setBounds(WIDTH/2-30, HEIGHT-90, 60, 20);
		
		wybor.add(add, BorderLayout.SOUTH);
		add.setBounds(WIDTH/4-55, 60, 45, 20);
		
		wybor.add(add2, BorderLayout.SOUTH);
		add2.setBounds(3*WIDTH/4-55, 60, 45, 20);
		
		wybor.add(remove, BorderLayout.SOUTH);
		remove.setBounds(WIDTH/4+10, 60, 45, 20);
		
		wybor.add(remove2, BorderLayout.SOUTH);
		remove2.setBounds(3*WIDTH/4+10, 60, 45, 20);
		
		
		wybor.add(party, BorderLayout.SOUTH);
		party.setBounds(40, 100, WIDTH/2-80, 20);
		
		wybor.add(party2, BorderLayout.SOUTH);
		party2.setBounds(WIDTH/2+40, 100, WIDTH/2-80, 20);
		
		wybor.add(poki, BorderLayout.SOUTH);
		poki.setBounds(40, 20, WIDTH/2-80, 20);
		
		wybor.add(poki2, BorderLayout.SOUTH);
		poki2.setBounds(WIDTH/2+40, 20, WIDTH/2-80, 20);
		
		wybor.add(staty[0]=new JLabel());
		staty[0].setBounds(WIDTH/4-128, 140, 256, 256);
		
		wybor.add(staty2[0]=new JLabel());
		staty2[0].setBounds(3*WIDTH/4-128, 140, 256, 256);
		
		staty[0].setText(fe);
		staty2[0].setText(fe);
		
		staty2[0].setBackground(Color.white);
		staty2[0].setBackground(Color.white);
		
		for(int i=1; i<8; ++i)
		{
			wybor.add(staty[i]=new JLabel());
			staty[i].setBounds(WIDTH/4-40, 256+140+i*20, 80, 20);
			staty[i].setText(fe);
			
			wybor.add(staty2[i]=new JLabel());
			staty2[i].setBounds(3*WIDTH/4-40, 256+140+i*20, 80, 20);
			staty2[i].setText(fe);
		}
	}
	
	void genWalka()
	{
		hello.setVisible(false);
		wybor.setVisible(false);
		walka.setVisible(true);
		zmiana.setVisible(false);
		wynik.setVisible(false);
		
		walka.add(at1);
		at1.setBounds(0, HEIGHT-140, WIDTH/2-100, 70);
		
		walka.add(at2);
		at2.setBounds(WIDTH/2-100, HEIGHT-140, WIDTH/2-100, 70);
		
		walka.add(at3);
		at3.setBounds(0, HEIGHT-70, WIDTH/2-100, 70);
		
		walka.add(at4);
		at4.setBounds(WIDTH/2-100, HEIGHT-70, WIDTH/2-100, 70);
		
		walka.add(change);
		change.setBounds(WIDTH-150, HEIGHT-140, 150, 140);
	}
	
	void genZmiana()
	{
		hello.setVisible(false);
		wybor.setVisible(false);
		walka.setVisible(false);
		zmiana.setVisible(true);
		wynik.setVisible(false);
		
		zmiana.add(party, BorderLayout.SOUTH);
		party.setBounds(WIDTH/2-80, 50, 160, 20);
		
		zmiana.add(staty[0]=new JLabel());
		staty[0].setBounds(WIDTH/2-128, 90, 256, 256);
		
		zmiana.add(switchpkmn);
		switchpkmn.setBounds(0, HEIGHT-100, WIDTH/2, 100);
		
		zmiana.add(cancel);
		cancel.setBounds(WIDTH/2, HEIGHT-100, WIDTH/2, 100);
		
		staty[0].setText(fe);

		
		for(int i=1; i<8; ++i)
		{
			zmiana.add(staty[i]=new JLabel());
			staty[i].setBounds(WIDTH/2-40, 256+90+i*20, 80, 20);
			staty[i].setText(fe);
		}
	}
	
	void genWynik()
	{
		hello.setVisible(false);
		wybor.setVisible(false);
		walka.setVisible(false);
		zmiana.setVisible(false);
		wynik.setVisible(true);
	}
	

	
}

/*
 * 	private static  String fe = new String("EXAMPLE");
	
	static Rectangle hp1 = new Rectangle();
	static Rectangle hp2 = new Rectangle(); //paski hp
	
	static JButton TESTER = new JButton("TEST");
	
	static JButton at1 = new JButton("TEST1");
	static JButton at2 = new JButton("TEST2");
	static JButton at3 = new JButton("TEST3");
	static JButton at4 = new JButton("TEST4");
	
	static JButton start = new JButton("START");
	
	static JButton go = new JButton("PLAY");
	
	static final JComboBox<String> poki2 = new JComboBox<String>();
	static final JComboBox<String> poki = new JComboBox<String>();
	
	static JComboBox<String> party = new JComboBox<String>();
	static JComboBox<String> party2 = new JComboBox<String>();
	
	static JButton add = new JButton("v");
	static JButton remove = new JButton("^");
	static JButton add2 = new JButton("v");
	static JButton remove2 = new JButton("^");
	
	static JButton fight = new JButton("FIGHT");
	static JButton change = new JButton("CHANGE");
	
	static JButton switchpkmn = new JButton("SWITCH");
	
	static JButton exit = new JButton("START");
	
	static JButton cancel = new JButton("Cancel");

	static public JLabel[] staty = new JLabel[8]; // obrazek, nazwa, hp, def, atk, spdef, spatk, spd
	static public JLabel[] staty2 = new JLabel[8];
	
	static JPanel hello = new JPanel();
	static JPanel wybor = new JPanel();
	static JPanel walka = new JPanel();
	static JPanel wynik = new JPanel();
	static JPanel zmiana = new JPanel();
	
	static JPanel previousPanel;
	*/
