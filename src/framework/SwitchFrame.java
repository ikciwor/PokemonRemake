package framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import engine.Battle;
import engine.Player;
import engine.Pokemon;

public class SwitchFrame extends JFrame {

	private JPanel contentPane;
	private JPanel buttonPanel;
	private JComboBox<String> party;
	private JLabel abilityLabel;
	private JLabel spdefLabel;
	private JLabel spatkLabel;
	private JLabel spdLabel;
	private JLabel hpLabel;
	private JLabel atkLabel;
	private JLabel defLabel;
	private JLabel move2;
	private JLabel move0;
	private JLabel move1;
	private JLabel move3;
	private JPanel statPanel;
	private JLabel sprite;
	private JButton cancelButton;
	private JButton switchButton;

	private Pokemon[] pokemons = new Pokemon[6];
	private JLabel statusLabel;
	private JButton loadButton;
	
	Battle battle;
	FrameInterface battleFrame;
	private JLabel type2;
	private JLabel type1;

	/**
	 * Create the frame.
	 */
	public SwitchFrame(final Battle battle, final FrameInterface battleFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		setVisible(true);
		this.battle=battle;
		this.battleFrame=battleFrame;

		buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 248, 372, 73);
		contentPane.add(buttonPanel);
								GridBagLayout gbl_buttonPanel = new GridBagLayout();
								gbl_buttonPanel.columnWidths = new int[]{124, 124, 124, 0};
								gbl_buttonPanel.rowHeights = new int[]{73, 0};
								gbl_buttonPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
								gbl_buttonPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
								buttonPanel.setLayout(gbl_buttonPanel);
								
										cancelButton = new JButton("CANCEL");
										cancelButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												battleFrame.setVisible(true);
												setVisible(false);
												
											}
										});
										
												loadButton = new JButton("LOAD");
												loadButton.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
														loadStats(party.getSelectedIndex());
													}
												});
												
														switchButton = new JButton("SWITCH");
														switchButton.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent arg0) {
																int id=party.getSelectedIndex();
																if(id!=0){
																	battle.choosePokemon(id);
																}
																battleFrame.setVisible(true);
																setVisible(false);
																
															}
														});
														GridBagConstraints gbc_switchButton = new GridBagConstraints();
														gbc_switchButton.fill = GridBagConstraints.BOTH;
														gbc_switchButton.insets = new Insets(0, 0, 0, 5);
														gbc_switchButton.gridx = 0;
														gbc_switchButton.gridy = 0;
														buttonPanel.add(switchButton, gbc_switchButton);
												GridBagConstraints gbc_loadButton = new GridBagConstraints();
												gbc_loadButton.fill = GridBagConstraints.BOTH;
												gbc_loadButton.insets = new Insets(0, 0, 0, 5);
												gbc_loadButton.gridx = 1;
												gbc_loadButton.gridy = 0;
												buttonPanel.add(loadButton, gbc_loadButton);
										GridBagConstraints gbc_cancelButton = new GridBagConstraints();
										gbc_cancelButton.fill = GridBagConstraints.BOTH;
										gbc_cancelButton.gridx = 2;
										gbc_cancelButton.gridy = 0;
										buttonPanel.add(cancelButton, gbc_cancelButton);

		party = new JComboBox();
		party.setBounds(12, 12, 128, 24);
		contentPane.add(party);

		sprite = new JLabel("SPRITE");
		sprite.setBounds(12, 48, 128, 128);
		contentPane.add(sprite);

		statPanel = new JPanel();
		statPanel.setBackground(Color.WHITE);
		statPanel.setBounds(152, 12, 232, 225);
		contentPane.add(statPanel);
		statPanel.setLayout(null);

		move3 = new JLabel("-");
		move3.setBounds(122, 39, 98, 15);
		statPanel.add(move3);

		move1 = new JLabel("-");
		move1.setBounds(122, 12, 98, 15);
		statPanel.add(move1);

		move0 = new JLabel("-");
		move0.setBounds(12, 12, 98, 15);
		statPanel.add(move0);

		move2 = new JLabel("-");
		move2.setBounds(12, 39, 98, 15);
		statPanel.add(move2);

		defLabel = new JLabel("DEFENCE");
		defLabel.setBounds(122, 112, 98, 15);
		statPanel.add(defLabel);

		atkLabel = new JLabel("ATTACK:");
		atkLabel.setBounds(12, 112, 98, 15);
		statPanel.add(atkLabel);

		hpLabel = new JLabel("HP:");
		hpLabel.setBounds(12, 85, 98, 15);
		statPanel.add(hpLabel);

		spdLabel = new JLabel("SPEED:");
		spdLabel.setBounds(122, 85, 98, 15);
		statPanel.add(spdLabel);

		spatkLabel = new JLabel("SP ATK:");
		spatkLabel.setBounds(12, 139, 98, 15);
		statPanel.add(spatkLabel);

		spdefLabel = new JLabel("SP DEF:");
		spdefLabel.setBounds(122, 139, 98, 15);
		statPanel.add(spdefLabel);

		abilityLabel = new JLabel("Abilities are not supported.");
		abilityLabel.setBackground(Color.LIGHT_GRAY);
		abilityLabel.setBounds(12, 166, 208, 47);
		statPanel.add(abilityLabel);

		statusLabel = new JLabel("STATUS");
		statusLabel.setBounds(12, 215, 128, 21);
		contentPane.add(statusLabel);
		
		type1 = new JLabel("-");
		type1.setFont(new Font("Dialog", Font.BOLD, 10));
		type1.setBounds(12, 188, 58, 15);
		contentPane.add(type1);
		
		type2 = new JLabel("-");
		type2.setFont(new Font("Dialog", Font.BOLD, 10));
		type2.setBounds(82, 188, 58, 15);
		contentPane.add(type2);
	}

	public void loadPartyForPlayer(Player player) {
		
//		party = new JComboBox<String>();
		party.setBounds(12, 12, 128, 24);
		contentPane.add(party);

		pokemons[0] = (player.pokemonBattling);
		party.addItem(pokemons[0].getName());
		
		for (int i=0; i < 5; ++i) {
			try{
				pokemons[i + 1] = (player.pokemon[i]);
				party.addItem(pokemons[i+1].getName());
			}catch(NullPointerException e){break;}
		}

	}

	public void loadStats(int n) {
		
		if(pokemons[n].move[0]!=null) move0.setText(pokemons[n].move[0].name); else move0.setText("-");
		if(pokemons[n].move[1]!=null) move1.setText(pokemons[n].move[1].name); else move1.setText("-");
		if(pokemons[n].move[2]!=null) move2.setText(pokemons[n].move[2].name); else move2.setText("-");
		if(pokemons[n].move[3]!=null) move3.setText(pokemons[n].move[3].name); else move3.setText("-");

		hpLabel.setText("HP: " + pokemons[n].hp + "/" + pokemons[n].maxhp);
		spdLabel.setText("SPD: " + pokemons[n].spd);
		atkLabel.setText("ATTACK: : " + pokemons[n].atk);
		defLabel.setText("DEFENCE: " + pokemons[n].def);
		spatkLabel.setText("SP ATK: " + pokemons[n].spatk);
		spdefLabel.setText("SP DEF: " + pokemons[n].spdef);
		
		if(pokemons[n].spieces.type1!=null) type1.setText(pokemons[n].spieces.type1.getName()); else move3.setText("-");
		if(pokemons[n].spieces.type2!=null) type2.setText(pokemons[n].spieces.type2.getName()); else move3.setText("-");
	}
}
