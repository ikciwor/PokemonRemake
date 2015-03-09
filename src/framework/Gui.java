package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import moves.Absorb;
import moves.Tackle;
import engine.Battle;
import engine.Debug;
import engine.Player;
import engine.PokemonBattling;
import engine.PokemonSpieces;
import engine.Type;

public class Gui /*extends Frame*/{
	
	
	JButton[] moveButton=new JButton[4];
	JButton switchButton;
	JButton bagButton;
	JButton runButton;
	
	FrameInterface frame = new FrameBuilt();
	Battle battle;
	//Player[] players = new Player[2];
	Player activePlayer;

	private Player generatePlayer() {
		Player player = new Player(null);
		
		PokemonSpieces podusia = new PokemonSpieces("Podusia");
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
		enableGui(false);
		
		this.moveButton[0]=frame.getMoveButton0();
		this.moveButton[1]=frame.getMoveButton1();
		this.moveButton[2]=frame.getMoveButton2();
		this.moveButton[3]=frame.getMoveButton3();
		
		switchButton=frame.getSwitchButton();
		runButton=frame.getRunButton();
		bagButton=frame.getBagButton();
		
		genActionListeners();
		
		battle = new Battle(this, generatePlayer(), generatePlayer());
		//players[0] = battle.players[0];
		//players[1] = battle.players[1];
		
		Debug debug = new Debug(battle);
	}

	private void genActionListeners() {

		for (int i = 0; i < 4; ++i) {
			addMoveButton(i);
		}

		switchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*enableGui(false);

				if (change.isVisible()) {
					battle.choosePokemon(party[battle.getCurrentPlayer()]
							.getSelectedIndex());
				} else {
					genChange();
				}*/

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
		enableGui(true);
	}
	
	public void updateStrings(int k)
	{
		for (int i=0; i<4; ++i)
		{
			moveButton[i].setText(battle.pok[k].move[i].name);
		}
	}

}
