package Poke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends Frame {

	Battle battle = new Battle(this);
	Player[] players = new Player[2];

	public Gui() {
		players[0] = battle.players[0];
		players[1] = battle.players[1];
	}

	void gen() {

		for (int i = 0; i < 4; ++i) {
			addMoveButton(i);
		}

		switchPkmn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				enableMoves(false);
				if (battle.areButtonsAllowed()) {

					if (change.isVisible()) {
						battle.chooseMove(players[battle.getCurrentPlayer()],
								party[battle.getCurrentPlayer()]
										.getSelectedIndex());
					} else {
						genChange();
					}

				}

			}
		});

	}

	private void addMoveButton(final int d) {
		move[d].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				enableMoves(false);
				if (battle.areButtonsAllowed()) {

					battle.chooseMove(players[battle.getCurrentPlayer()],
							battle.pok[battle.getCurrentPlayer()].move[d]);
					if (battle.getCurrentPlayer() < 2) {
						battle.takeOrders(battle.getCurrentPlayer() + 1);
					} else {
						battle.executeRound();
					}
				}

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
	
	public void waitForOrders()
	{
		enableMoves(true);
	}

}
