package Poke;

import java.util.Random;

public class Battle {

	Random rand = new Random();
	
	Player[] players = new Player[2];
	

	public Weather weather;


	public Battle() {

		// for(int i=0; i<2;++i)
		// {
		// for(int j=0; j<6;++j)
		// {
		// pokemon[i][j]=Pokemon.searchByName((i==0)? Frame.party.getItemAt(j) :
		// Frame.party2.getItemAt(j));
		// }
		// }



	}
	
	void reset()
	{
		for (int i = 0; i < 5; ++i) {
			for (int j= 0; j<4; ++j) {
				players[0].pokemon[i].move[j].pp = players[0].pokemon[i].move[j].ppmax;
				players[1].pokemon[i].move[j].pp = players[1].pokemon[i].move[j].ppmax;
			}
		}
	}

	void executeTurn(int a) {
		int r = rand.nextInt(2);
		Pokemon pok0 = players[0].pokemonBattling;
		
		
		int order = (players[0].pokemonBattling.resultSpd() > players[1].pokemonBattling.resultSpd()) ? 0
				: (players[0].pokemonBattling.resultSpd() == players[1].pokemonBattling.resultSpd()) ? (int) r
						: 1;

		players[order].pokemonBattling.move[a].doMove(players[order].pokemonBattling);

		players[(order+1)%2].pokemonBattling.move[r].doMove(players[(order+1)%2].pokemonBattling); // bot wybiera losowo

	}

	public void switchPokemon(int id) {
		// odpalić kontunuuj
	}
	
	public void chooseMove(int id)
	{
		// odpalić kontynuuj
	}

	public void runTurn() {
		// odpalić turn w nowym wątku
	}
}
