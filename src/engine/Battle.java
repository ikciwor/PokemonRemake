package engine;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JOptionPane;

import framework.BattleGui;
import framework.GuiInterface;

public class Battle {

	Random rand = new Random();

	public Player[] players = new Player[2];

	public PokemonBattling[] pok = new PokemonBattling[2];

	private int[] idPokToSwitch = new int[2];
	private int currentPlayer = -1;

	public GuiInterface gui;

	public Weather weather;

	public Battle(BattleGui gui, Player player0, Player player1) {
		
		players[0]=player0;
		players[1]=player1;

		pok[0] = players[0].pokemonBattling;
		pok[1] = players[1].pokemonBattling;
		this.gui = gui;
	}

	public void choosePokemon(int id) {
		players[getCurrentPlayer()].setAction(id);
		takeOrders();
	}

	public void chooseMove(int moveId) {
		players[getCurrentPlayer()].setAction(pok[currentPlayer].move[moveId]);
		takeOrders();
	}
	
	public void takeOrders() {
		/*
		 * Uwaga: Dowolny z playerów może zostać pominięty, np. z powodu jakiegoś 'fly'.
		 *        Wówczas takeOrders się nie kończy, tylko od razu przechodzi do kolejnego etapu.
		 */
		
		if (currentPlayer == -1) {
			currentPlayer = 0;
			gui.waitForOrders(players[currentPlayer]);
			return;
		}
		
		if (currentPlayer == 0) {
			currentPlayer = 1;
			gui.waitForOrders(players[currentPlayer]);
			return;
		}

		currentPlayer = -1;
		executeRound();
		
		/*if (players[id].isBot()) {

		} else {
			currentPlayer = id;
			gui.waitForOrders(players[currentPlayer]);
		}
		
		++currentPlayer;
		
		if (getCurrentPlayer() < 1) {
			takeOrders(getCurrentPlayer() + 1);
		} else {
			executeRound();
		}*/
	}
	
	private void reset() {
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 4; ++j) {
				players[0].pokemon[i].move[j].pp = players[0].pokemon[i].move[j].ppmax;
				players[1].pokemon[i].move[j].pp = players[1].pokemon[i].move[j].ppmax;
			}
		}
	}

	void executeRound() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				int[] order = turnOrder();
				doAction(players[order[0]]);
				doAction(players[order[1]]);
				
				// ...
				
				takeOrders();

			}
		});
	}

	private void doAction(Player player) {
		int n = (player == players[0]) ? 0 : 1;
		if (player.getActionType() == Action.Type.SWITCH) {
			switchPokemon(player);
		}
		else if (player.getActionType() == Action.Type.MOVE) {
			player.getActionMove().doMove(pok[1-(n % 2)]);
		}

	}

	private int[] turnOrder() {
		int[] order = new int[2];

		if (players[0].getActionPriority() == players[1].getActionPriority()) {

			if (pok[0].resultSpd() > pok[1].resultSpd()) {
				order[0] = 0;
				order[1] = 1;

			} else if (pok[1].resultSpd() > pok[0].resultSpd()) {
				order[0] = 1;
				order[1] = 0;
			} else {
				int r = rand.nextInt(2);

				order[0] = r;
				order[1] = (r - 1) % 2;
			}

		} else if (players[0].getActionPriority() > players[1]
				.getActionPriority()) {
			order[0] = 0;
			order[1] = 1;
		} else {
			order[0] = 1;
			order[1] = 0;
		}
		return order;
	}

	private void switchPokemon(Player player) {
		int id = player.getActionIdToSwitch();

		Pokemon swapPokemon;
		swapPokemon = player.pokemon[id];
		player.pokemon[id] = player.pokemonBattling.turnIntoNotBattling();
//		player.pokemon[id] = swapPokemon;
		player.pokemonBattling = swapPokemon.turnIntoBattling();
	}

	private void loadPokemon() {

	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void endBattle(Player winner)
	{
		
	}

}

/*
 * public int[] turnOrder(PokemonBattling[] target) //dla podwójnych walk {
 * Random r = new Random();
 * 
 * int[] order = new int[4]; int[] priorityOrder = new int[4];
 * 
 * for(int i=0; i<4;++i) { int n=0; for(int j=0; j<4; ++j) { if(j==i) continue;
 * 
 * 
 * if(pok[i].getPriorityOfMove(usedMove[i])>pok[j].getPriorityOfMove(usedMove
 * [j])) { n++; } priorityOrder[i]=n;
 * 
 * } }
 * 
 * int nextPlace=0;
 * 
 * for(int i=3; i>=0; --i) //dla każdego priorytetu od najwyższego { int[]
 * pkmsOnPriority = new int[4]; int k=0; for(int j=0; j<4; ++j) {
 * if(priorityOrder[j]==i) { ++k; pkmsOnPriority[k]=j; //tablica mieszcząca
 * numery pokemonów w danym priorytecie (i) } } if(k==0) continue; if(k==1) {
 * order[nextPlace]=pkmsOnPriority[0]; ++nextPlace; continue; }
 * 
 * for (int j=0; j<k; ++j) { int place=nextPlace; for(int m=0; m<k;++m) {
 * if(j==m) continue;
 * if(pok[pkmsOnPriority[j]].resultSpd()<pok[pkmsOnPriority[m]].resultSpd()) {
 * ++place; } else if
 * (pok[pkmsOnPriority[j]].resultSpd()==pok[pkmsOnPriority[m]].resultSpd() &&
 * r.nextInt(2)==1) { ++place; } } while(order[place]>=0 && order[place]<=4)
 * ++place; order[place]=pkmsOnPriority[j];
 * 
 * 
 * } nextPlace+=k;
 * 
 * }
 * 
 * 
 * 
 * 
 * return order; }//zgrubsza powinno działać
 */