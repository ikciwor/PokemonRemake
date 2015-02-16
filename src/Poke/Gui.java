package Poke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends Frame {

	Battle battle = new Battle(this);
	Player[] players = new Player[2];
	Player activePlayer;

	public Gui() {
		players[0] = battle.players[0];
		players[1] = battle.players[1];

		// Debug debug = new Debug(battle);
		genActionListeners();
	}

	private void genActionListeners() {

		for (int i = 0; i < 4; ++i) {
			addMoveButton(i);
		}

		switchPkmn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				enableMoves(false);

				if (change.isVisible()) {
					battle.choosePokemon(party[battle.getCurrentPlayer()]
							.getSelectedIndex());
				} else {
					genChange();
				}

			}
		});

	}

	private void addMoveButton(final int d) {
		move[d].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				enableMoves(false);

				battle.chooseMove(battle.pok[battle.getCurrentPlayer()].move[d]);

			}
		});
	}

	private void enableMoves(boolean b) {
		for (int i = 0; i < 4; ++i) {
			move[i].setEnabled(b);
		}
	}

	private void enableMoves(int a, boolean b) {
		move[a].setEnabled(b);
	}

	public void waitForOrders(Player player) {
		/*
		 * To jest jedyna metoda z którą będzie wywoływał Battle.
		 * Co więcej, wywołanie tej metody zawsze będzie ostanią operacją wykonaną przez Battle, potem Battle się zakończy.
		 */
		activePlayer = player;
		// [załadowanie interfejsu dla activePlayer (odpowiednie ataki itp.) -- użycie getterów z battle];
		// [odblokowanie interfejsu (uaktywnienie przyciskówi itp.)];
		enableMoves(true);
	}

}
