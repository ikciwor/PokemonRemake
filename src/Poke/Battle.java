package Poke;

import java.util.Random;

import Moves.Move;

public class Battle {
	
	Random rand = new Random();
	
	PokemonBattling[] pokemonBattling =new PokemonBattling[2];
	Pokemon[][] pokemon = new Pokemon[2][6];
	
	public Weather weather;
	
	int pokemonInBattle; //gdyby były dwa bulbasaury
	
	public Battle()
	{
		
		
		
//		for(int i=0; i<2;++i)
//		{
//			for(int j=0; j<6;++j)
//			{
//				pokemon[i][j]=Pokemon.searchByName((i==0)? Frame.party.getItemAt(j) : Frame.party2.getItemAt(j));
//			}
//		}
		
		
		for(int i=0; i<6; ++i)
		{
			pokemon[0][i].move[0].pp=pokemon[0][i].move[0].ppmax;
			pokemon[0][i].move[1].pp=pokemon[0][i].move[1].ppmax;
			pokemon[0][i].move[2].pp=pokemon[0][i].move[2].ppmax;
			pokemon[0][i].move[3].pp=pokemon[0][i].move[3].ppmax;
			
			pokemon[1][i].move[0].pp=pokemon[0][i].move[0].ppmax;
			pokemon[1][i].move[1].pp=pokemon[0][i].move[1].ppmax;
			pokemon[1][i].move[2].pp=pokemon[0][i].move[2].ppmax;
			pokemon[1][i].move[3].pp=pokemon[0][i].move[3].ppmax; //resetowanie pp
		}
		
		
	}
	

	void turn(int a)
	{
		int r=rand.nextInt(4);
		int order= (pokemonBattling[0].r_spd() > pokemonBattling[1].r_spd()) ? 0 : (pokemonBattling[0].r_spd() == pokemonBattling[1].r_spd())? (int)r : 1;
		
		pokemonBattling[order%2].move[a].doMove();
		
		pokemonBattling[(order+1)%2].move[r].doMove(); //bot wybiera losowo
		
	}
	
	void switchPokemon()
	{
		
	}
	

}
