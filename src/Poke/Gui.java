package Poke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Moves.Tackle;

public class Gui extends Frame {
	
	
	

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
		podusia.type1 = Poke.Type.NORMAL;
		podusia.type2 = Poke.Type.DRAGON;
		
		player.pokemonBattling = new PokemonBattling(podusia);
		player.pokemonBattling.move[0] = new Tackle(player.pokemonBattling);
		
		return player;
	}
	
	public Gui() {
		enableGui(false);
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

		switchPkmn.addActionListener(new ActionListener() {
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
		move[moveId].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				enableGui(false);
				battle.chooseMove(moveId);

			}
		});
	}

	private void enableGui(boolean b) {
		for (int i = 0; i < 4; ++i) {
			
			if(!b){
				move[i].setEnabled(false);
			}else{
				if(activePlayer.pokemonBattling.move[i]!=null)
				{
					move[i].setEnabled(true);
				}
			}

		}
		switchPkmn.setEnabled(b);
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

}
