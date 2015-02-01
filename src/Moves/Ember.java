package Moves;

import Poke.PokemonBattling;
import Poke.Status;
import Poke.Type;

public class Ember extends Move{
	
	public Ember()
	{
		pow=40;
		pp=25;
		ppmax=25;
		special=true;
		touch=false;
		type=Type.FIRE;
		name="EMBER";
	}
	
	public void doMove(PokemonBattling target)
	{
		damage(target);
		if(rand.nextInt(10)==0)
			target.status=Status.BURN;
	}

}
