package Poke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Frame extends JFrame {
	private static final long serialVersionUID = 345924759794811391L;

	public static int HEIGHT = 650, WIDTH = 650;

	/*
	 * Ekrany: 1. start - przycisk start 2. wybór poków - przycisk go, add,
	 * add2, remove, remove2, 4x combobox, 2x label x9, 2x label poków (label
	 * x18) 3. walka - combobox ataków, przycisk zmiana poka, przycisk atak, 4
	 * ataki 4. zmiana pokemona - combobox poków, 2 przyciski wybór i cancel,
	 * label x8: obrazek, nazwa, hp, def, atk, spdef, spatk, spd 5. wynik -
	 * przycisk do wyjcia i startu, label lose/win
	 * 
	 * suma: przycisk x13, combobox x5, label x10
	 */
	String fe = new String("EXAMPLE");

	Rectangle hp1 = new Rectangle();
	Rectangle hp2 = new Rectangle(); // paski hp

	JButton TESTER = new JButton("TEST");

	JButton[] move = new JButton[4];

	JButton start = new JButton("START");

	JButton go = new JButton("PLAY");

	static final JComboBox<String> poki2 = new JComboBox<String>();
	static final JComboBox<String> poki = new JComboBox<String>();

	static JComboBox<String>[] party = new JComboBox[2];

	JButton add = new JButton("v");
	JButton remove = new JButton("^");
	JButton add2 = new JButton("v");
	JButton remove2 = new JButton("^");

	JButton switchPkmn = new JButton("SWITCH");

	JButton exit = new JButton("START");

	JButton cancel = new JButton("Cancel");

	public JLabel[] staty = new JLabel[8]; // obrazek, nazwa, hp, def, atk,
											// spdef, spatk, spd
	public JLabel[] staty2 = new JLabel[8];

	JPanel hello = new JPanel();
	JPanel wybor = new JPanel();
	JPanel walka = new JPanel();
	JPanel wynik = new JPanel();
	JPanel change = new JPanel();
	
	JPanel statPanel = new JPanel();
	JPanel hudPanel[] = new JPanel[2];

	JPanel previousPanel;

	Rectangle hpBar[] = new Rectangle[2];
	
	Game game = new Game();

	public Frame() {

		for (int i = 0; i < 4; ++i) {
			move[i] = new JButton("EXAMPLE " + i);
		}
		party[0] = new JComboBox<String>();
		party[1] = new JComboBox<String>();

		setTitle("Halo");
		setLayout(null);

		add(hello, BorderLayout.CENTER);
		hello.setBounds(0, 0, WIDTH, HEIGHT);
		hello.setLayout(null);

		add(wybor, BorderLayout.CENTER);
		wybor.setBounds(0, 0, WIDTH, HEIGHT);
		wybor.setLayout(null);

		add(walka, BorderLayout.CENTER);
		walka.setBounds(0, 0, WIDTH, HEIGHT);
		walka.setLayout(null);

		add(wynik, BorderLayout.CENTER);
		wynik.setBounds(0, 0, WIDTH, HEIGHT);
		wynik.setLayout(null);

		add(change, BorderLayout.CENTER);
		change.setBounds(0, 0, WIDTH, HEIGHT);
		change.setLayout(null);
		
		//setUndecorated(true);

		pack();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH+4, HEIGHT+27);

		add(game);

		// genZmiana();
		// genWybor();
		genWalka();

	}

	void genHello() {
		hello.setVisible(true);
		wybor.setVisible(false);
		walka.setVisible(false);
		change.setVisible(false);
		wynik.setVisible(false);

		hello.add(start, BorderLayout.SOUTH);
		hello.setBounds(10, 10, 20, 20);
	}

	void genWybor() {
		hello.setVisible(false);
		wybor.setVisible(true);
		walka.setVisible(false);
		change.setVisible(false);
		wynik.setVisible(false);

		wybor.add(go, BorderLayout.SOUTH);
		go.setBounds(WIDTH / 2 - 30, HEIGHT - 90, 60, 20);

		wybor.add(add, BorderLayout.SOUTH);
		add.setBounds(WIDTH / 4 - 55, 60, 45, 20);

		wybor.add(add2, BorderLayout.SOUTH);
		add2.setBounds(3 * WIDTH / 4 - 55, 60, 45, 20);

		wybor.add(remove, BorderLayout.SOUTH);
		remove.setBounds(WIDTH / 4 + 10, 60, 45, 20);

		wybor.add(remove2, BorderLayout.SOUTH);
		remove2.setBounds(3 * WIDTH / 4 + 10, 60, 45, 20);

		wybor.add(party[0], BorderLayout.SOUTH);
		party[0].setBounds(40, 100, WIDTH / 2 - 80, 20);

		wybor.add(party[1], BorderLayout.SOUTH);
		party[1].setBounds(WIDTH / 2 + 40, 100, WIDTH / 2 - 80, 20);

		wybor.add(poki, BorderLayout.SOUTH);
		poki.setBounds(40, 20, WIDTH / 2 - 80, 20);

		wybor.add(poki2, BorderLayout.SOUTH);
		poki2.setBounds(WIDTH / 2 + 40, 20, WIDTH / 2 - 80, 20);

		wybor.add(staty[0] = new JLabel());
		staty[0].setBounds(WIDTH / 4 - 128, 140, 256, 256);

		wybor.add(staty2[0] = new JLabel());
		staty2[0].setBounds(3 * WIDTH / 4 - 128, 140, 256, 256);

		staty[0].setText(fe);
		staty2[0].setText(fe);

		staty2[0].setBackground(Color.white);
		staty2[0].setBackground(Color.white);

		for (int i = 1; i < 8; ++i) {
			wybor.add(staty[i] = new JLabel());
			staty[i].setBounds(WIDTH / 4 - 40, 256 + 140 + i * 20, 80, 20);
			staty[i].setText(fe);

			wybor.add(staty2[i] = new JLabel());
			staty2[i].setBounds(3 * WIDTH / 4 - 40, 256 + 140 + i * 20, 80, 20);
			staty2[i].setText(fe);
		}
	}

	void genWalka() {
		hello.setVisible(false);
		wybor.setVisible(false);
		walka.setVisible(true);
		change.setVisible(false);
		wynik.setVisible(false);
		
		
		hpBar[0]=new Rectangle();
		hpBar[1]=new Rectangle();
		
		walka.add(move[0]);
		move[0].setBounds(0, HEIGHT - 140, WIDTH / 2 - 100, 70);

		walka.add(move[1]);
		move[1].setBounds(WIDTH / 2 - 100, HEIGHT - 140, WIDTH / 2 - 100, 70);

		walka.add(move[2]);
		move[2].setBounds(0, HEIGHT - 70, WIDTH / 2 - 100, 70);

		walka.add(move[3]);
		move[3].setBounds(WIDTH / 2 - 100, HEIGHT - 70, WIDTH / 2 - 100, 70);

		walka.add(switchPkmn);
		switchPkmn.setBounds(WIDTH - 150, HEIGHT - 140, 150, 140);
		
		
	}

	void genChange() {
		hello.setVisible(false);
		wybor.setVisible(false);
		walka.setVisible(false);
		change.setVisible(true);
		wynik.setVisible(false);

		change.add(party[0], BorderLayout.SOUTH);
		party[0].setBounds(WIDTH / 2 - 80, 50, 160, 20);

		change.add(staty[0] = new JLabel());
		staty[0].setBounds(WIDTH / 2 - 128, 90, 256, 256);

		change.add(switchPkmn);
		switchPkmn.setBounds(0, HEIGHT - 100, WIDTH / 2, 100);

		change.add(cancel);
		cancel.setBounds(WIDTH / 2, HEIGHT - 100, WIDTH / 2, 100);

		staty[0].setText(fe);

		for (int i = 1; i < 8; ++i) {
			change.add(staty[i] = new JLabel());
			staty[i].setBounds(WIDTH / 2 - 40, 256 + 90 + i * 20, 80, 20);
			staty[i].setText(fe);
		}
	}

	void genWynik() {
		hello.setVisible(false);
		wybor.setVisible(false);
		walka.setVisible(false);
		change.setVisible(false);
		wynik.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;

	}

}

