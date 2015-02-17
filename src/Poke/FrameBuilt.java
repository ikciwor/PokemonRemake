package Poke;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FrameBuilt extends JFrame{

	/**
	 * Create the application.
	 */
	public FrameBuilt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 604, 627);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton move_3 = new JButton("New button");
		move_3.setBackground(Color.WHITE);
		move_3.setBounds(12, 518, 197, 70);
		panel.add(move_3);
		
		JButton switchPkmn = new JButton("SWITCH");
		switchPkmn.setBackground(Color.WHITE);
		switchPkmn.setBounds(448, 448, 140, 140);
		panel.add(switchPkmn);
		
		JButton move_1 = new JButton("New button");
		move_1.setBackground(Color.WHITE);
		move_1.setBounds(12, 448, 197, 70);
		panel.add(move_1);
		
		JButton move_2 = new JButton("New button");
		move_2.setBackground(Color.WHITE);
		move_2.setBounds(209, 448, 197, 70);
		panel.add(move_2);
		
		JButton move_4 = new JButton("New button");
		move_4.setBackground(Color.WHITE);
		move_4.setBounds(209, 518, 197, 70);
		panel.add(move_4);
		
		JPanel dataPanel_0 = new JPanel();
		dataPanel_0.setBounds(300, 378, 288, 62);
		panel.add(dataPanel_0);
		dataPanel_0.setLayout(null);
		
		JLabel hpAmount_0 = new JLabel("hpAmount");
		hpAmount_0.setBounds(12, 12, 92, 23);
		dataPanel_0.add(hpAmount_0);
		
		JLabel lvl_0 = new JLabel("Lvl");
		lvl_0.setBounds(208, 12, 68, 23);
		dataPanel_0.add(lvl_0);
		
		JLabel status_0 = new JLabel("Status");
		status_0.setBounds(116, 12, 68, 23);
		dataPanel_0.add(status_0);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setBounds(12, 35, 264, 15);
		dataPanel_0.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/media/radek/Dysk przenośny/Radek/Programowanie/Java/PokemonRemake/img/?64x64.png"));
		lblNewLabel_1.setBounds(92, 310, 128, 128);
		panel.add(lblNewLabel_1);
	}
}
