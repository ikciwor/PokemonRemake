package Poke;

public class Player {
	
//	Pokemon[] pokemon = new Pokemon[6];
	PokemonBattling pokemonBattling;
	Pokemon[] pokemon = new Pokemon[5];
	
	
	Bot bot;
	
	public Player(Bot bot){
		
	}
	
	public boolean isBot()
	{
		return bot!=null;
	}

}
