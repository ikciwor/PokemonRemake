package Moves;

import Poke.PokemonBattling;

public class Growl extends Move{
	
	public Growl()
	{
		name="GROWL";
		pp=ppmax=40;
	}
	
	public void doMove(PokemonBattling target)
	{
		target.modifyMAtk(-1);
	}

}
