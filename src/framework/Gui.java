package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import moves.Absorb;
import moves.Tackle;
import engine.Battle;
import engine.Debug;
import engine.Player;
import engine.PokemonBattling;
import engine.PokemonSpieces;
import engine.Type;

public class Gui{
	
	
	private JButton[] moveButton=new JButton[4];
	private JButton switchButton;
	private JButton bagButton;
	private JButton runButton;
	private JLabel hpBar1;
	private JLabel hpBar2;
	private JLabel levelBar;
	private JLabel sprite2;
	private JLabel sprite1;
	private JLabel hpLabel;
	private JLabel levelLabel1;
	private JLabel levelLabel2;
	private JLabel nameLabel1;
	private JLabel nameLabel2;
	private JLabel infoLabel;
	private JPanel buttonPanel;
	private JPanel statPanel1;
	private JPanel statPanel2;
	
	FrameInterface frame = new FrameBuilt();
	Battle battle;
	Player activePlayer;


	private Player generatePlayer() {
		Player player = new Player(null);
		
		PokemonSpieces podusia = new PokemonSpieces("PODUSIA");
		podusia.baseAtk = 100;
		podusia.baseDef = 100;
		podusia.baseHp = 100;
		podusia.baseSpatk = 100;
		podusia.baseSpdef = 100;
		podusia.baseSpd = 100;
		podusia.type1 = engine.Type.NORMAL;
		podusia.type2 = engine.Type.DRAGON;
		
		player.pokemonBattling = new PokemonBattling(podusia);
		player.pokemonBattling.move[0] = new Tackle(player.pokemonBattling);
		player.pokemonBattling.move[1] = new Absorb(player.pokemonBattling);
		
		return player;
	}
	
	public Gui() {
		
		importComponents();

		enableGui(false);
		genActionListeners();
		
		this.battle = new Battle(this, generatePlayer(), generatePlayer());
		this.battle.takeOrders();
		
//		Debug debug = new Debug(battle);
	}

	private void genActionListeners() {

		for (int i = 0; i < 4; ++i) {
			addMoveButton(i);
		}

		switchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


			}
		});

	}

	private void addMoveButton(final int moveId) {
		moveButton[moveId].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				enableGui(false);
				battle.chooseMove(moveId);

			}
		});
	}

	private void enableGui(boolean b) {
		
		buttonPanel.setVisible(b);
		for (int i = 0; i < 4; ++i) {
			
			if(!b){
				moveButton[i].setEnabled(false);
			}else{
				if(activePlayer.pokemonBattling.move[i]!=null)
				{
					moveButton[i].setEnabled(true);
				}
			}

		}
		switchButton.setEnabled(b);
	}


	public void waitForOrders(Player player) {
		/*
		 * To jest jedyna metoda z którą będzie wywoływał Battle.
		 * Co więcej, wywołanie tej metody zawsze będzie ostanią operacją wykonaną przez Battle, potem Battle się zakończy.
		 */
		activePlayer = player;
		// [załadowanie interfejsu dla activePlayer (odpowiednie ataki itp.) -- użycie getterów z battle];
		// [odblokowanie interfejsu (uaktywnienie przyciskówi itp.)];
		updateStrings((player == battle.players[1])? 1 : 0);
		enableGui(true);
	}
	
	private void importComponents(){
		this.moveButton[0]=frame.getMoveButton0();
		this.moveButton[1]=frame.getMoveButton1();
		this.moveButton[2]=frame.getMoveButton2();
		this.moveButton[3]=frame.getMoveButton3();
		
		switchButton=frame.getSwitchButton();
		runButton=frame.getRunButton();
		bagButton=frame.getBagButton();
		
		hpBar1 =frame.getHpBar1();
		hpBar2 =frame.getHpBar2();
		levelBar =frame.getLevelBar();
		sprite1 =frame.getSprite1();
		sprite2 =frame.getSprite2();
		hpLabel =frame.getHpLabel();
		levelLabel1 =frame.getLevelLabel1();
		levelLabel2 =frame.getLevelLabel2();
		nameLabel1 =frame.getNameLabel1();
		nameLabel2 =frame.getNameLabel2();
		infoLabel =frame.getInfoLabel();
		
		buttonPanel = frame.getButtonPanel();
		statPanel1 = frame.getStatPanel1();
		statPanel2 = frame.getStatPanel2();
	}
	
	public void updateStrings(int k)
	{
		for (int i=0; i<4; ++i)
		{
			try{
				moveButton[i].setText(battle.pok[k].move[i].name);
			}catch(NullPointerException e){moveButton[i].setText("-");}

		}
		hpLabel.setText("HP: "+battle.pok[k].hp + "/"+battle.pok[k].maxhp);
		levelLabel1.setText("LVL: "+battle.pok[k].level);
		levelLabel2.setText("LVL: "+battle.pok[(1+k)%2].level);
		nameLabel1.setText(""+battle.pok[k].getName());
		nameLabel2.setText(""+battle.pok[(1+k)%2].getName());
	}

}
