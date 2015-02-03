package Poke;

import java.awt.EventQueue;
import java.util.Random;

import Moves.Move;

public class Battle {

	Random rand = new Random();

	Player[] players = new Player[2];

	PokemonBattling[] pok = new PokemonBattling[2]; // skrót
	PokemonBattling[] targets = new PokemonBattling[4]; // do podwójnych

	private Move[] chosenMove = new Move[2];
	
	private enum TypeOfTurn {MOVE, SWITCH, STILL}
	TypeOfTurn[] typeOfTurn = new TypeOfTurn[2];
	
	private int[] idPokToSwitch=new int[2];

	Frame frame;

	public Weather weather;

	public Battle() {

		pok[0] = players[0].pokemonBattling;
		pok[1] = players[1].pokemonBattling; // skrót
		
		nextRound();

	}

	public void getFrame(Frame frame) {
		this.frame = frame;
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
		
		switch(typeOfTurn[order[0]]){
		
		case MOVE:
			chosenMove[order[0]].doMove(pok[1]);
			break;
		case SWITCH:
			switchPokemon(players[order[0]], idPokToSwitch[order[0]]);
			break;
		case STILL:
			break;
		}
		
		switch(typeOfTurn[order[1]]){
		
		case MOVE:
			chosenMove[order[1]].doMove(pok[1]);
			break;
		case SWITCH:
			switchPokemon(players[order[1]], idPokToSwitch[order[1]]);
			break;
		case STILL:
			break;
		}
		
		nextRound();

	}

	public int[] turnOrder() {
		int[] order = new int[2];

		if (chosenMove[0].getPriority() == chosenMove[1].getPriority()) {

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

		} else if (chosenMove[0].getPriority() > chosenMove[1].getPriority()) {
			order[0] = 0;
			order[1] = 1;
		} else {
			order[0] = 1;
			order[1] = 0;
		}
		return order;
	}

	public void switchPokemon(Player player, int id) {
		
		Pokemon swapPokemon = new Pokemon();
		swapPokemon=player.pokemon[0];
		player.pokemon[0]=player.pokemon[id];
		player.pokemon[id]=swapPokemon;
		player.pokemonBattling=(PokemonBattling) player.pokemon[0];
		
		
		// odpalić kontunuuj
	}

	
	public void loadPokemon()
	{
		
	}

	public void prepareTurn(final int id) { 
		if (players[id].isBot()) {

		} else {
			frame.enableMoves(true);
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {

					while (true) {
						if (frame.getPressedButton() >= 0) {
							if (frame.getPressedButton() <4) {
								chosenMove[id] = pok[id].move[frame.getPressedButton()];
								typeOfTurn[id]=TypeOfTurn.MOVE;
							}
							else if(frame.getPressedButton()==5) // zmiana pokemona
							{
								chosenMove[id].setPriority(6);
								typeOfTurn[id]=TypeOfTurn.SWITCH;
							}
							break;
						}
					}

				}
			});
		}
		frame.enableMoves(false);

		// odpalić kontynuuj
	}
	

	public void nextRound() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				prepareTurn(0);
				prepareTurn(1);

				executeRound();

			}
		});
		// odpalić turn w nowym wątku
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