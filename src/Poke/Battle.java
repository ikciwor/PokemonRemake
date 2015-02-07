package Poke;

import java.awt.EventQueue;
import java.util.Random;

import Moves.Move;

public class Battle {

	Random rand = new Random();

	Player[] players = new Player[2];

	public PokemonBattling[] pok = new PokemonBattling[2]; // skrót
	PokemonBattling[] targets = new PokemonBattling[4]; // do podwójnych
	
	private int[] idPokToSwitch=new int[2];
	private int currentPlayer=0;
	
	private boolean buttonsAllowed;

	Gui gui;

	public Weather weather;

	public Battle(Gui gui) {

		pok[0] = players[0].pokemonBattling;
		pok[1] = players[1].pokemonBattling; // skrót
		this.gui = gui;
		
		nextRound();

	}


	void reset() {
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 4; ++j) {
				players[0].pokemon[i].move[j].pp = players[0].pokemon[i].move[j].ppmax;
				players[1].pokemon[i].move[j].pp = players[1].pokemon[i].move[j].ppmax;
			}
		}
	}

	void executeRound() {

		int[] order = turnOrder();
		
		doAction(players[order[0]]);
		doAction(players[order[1]]);
		
		nextRound();

	}
	
	void doAction(Player player)
	{
		int n=(player==players[0])? 0 : 1;
		switch (player.getActionType()){
		case SWITCH: 
			switchPokemon(player);
			break;
		case MOVE:
			player.getActionMove().doMove(pok[(n%2)+1]);
		}
	}

	public int[] turnOrder() {
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

		} else if (players[0].getActionPriority() > players[1].getActionPriority()) {
			order[0] = 0;
			order[1] = 1;
		} else {
			order[0] = 1;
			order[1] = 0;
		}
		return order;
	}

	public void switchPokemon(Player player) {
		int id = player.getActionIdToSwitch();
		
		Pokemon swapPokemon = new Pokemon();
		swapPokemon=player.pokemon[0];
		player.pokemon[0]=player.pokemon[id];
		player.pokemon[id]=swapPokemon;
		player.pokemonBattling=(PokemonBattling) player.pokemon[0];
		
		
		// odpalić kontunuuj
	}
	
	public void chooseMove (Player player, int id)
	{
		player.setAction(id);
		
		gui.enableMoves(false);
		buttonsAllowed=false;
	}
	public void chooseMove (Player player, Move move)
	{
		int n=(player==players[0])? 0 : 1;
		player.setAction(move);
		
		gui.enableMoves(false);
		buttonsAllowed=false;
	}

	
	public void loadPokemon()
	{
		
	}

	public void takeOrders(int id) { 
		if (players[id].isBot()) {

		} else {
			currentPlayer=id;
			gui.enableMoves(true);
			buttonsAllowed=true;
		}
		
	}

	

	public void nextRound() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				takeOrders(0);

				executeRound();

			}
		});
		// odpalić turn w nowym wątku
	}
	
	public boolean areButtonsAllowed()
	{
		return buttonsAllowed;
	}
	
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}


}


/*
 * public int[] turnOrder(PokemonBattling[] target) //dla podwójnych walk {
 * Random r = new Random();
 * 
 * int[] order = new int[4]; int[] priorityOrder = new int[4];
 * 
 * for(int i=0; i<4;++i) { int n=0; for(int j=0; j<4; ++j) { if(j==i)
 * continue;
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
 * numery pokemonów w danym priorytecie (i) } } if(k==0) continue; if(k==1)
 * { order[nextPlace]=pkmsOnPriority[0]; ++nextPlace; continue; }
 * 
 * for (int j=0; j<k; ++j) { int place=nextPlace; for(int m=0; m<k;++m) {
 * if(j==m) continue;
 * if(pok[pkmsOnPriority[j]].resultSpd()<pok[pkmsOnPriority[m]].resultSpd())
 * { ++place; } else if
 * (pok[pkmsOnPriority[j]].resultSpd()==pok[pkmsOnPriority[m]].resultSpd()
 * && r.nextInt(2)==1) { ++place; } } while(order[place]>=0 &&
 * order[place]<=4) ++place; order[place]=pkmsOnPriority[j];
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