package Moves;

import Poke.PokemonBattling;
import Poke.Type;

public class Tackle extends Move{

	public Tackle(PokemonBattling user){
		super(user);
		pow=35;
		acc=100;
		type=Type.NORMAL;
		special=false;
		touch=true;
		name="TACKLE";
		
		pp=ppmax=35;
	}
	public void doMove(PokemonBattling target)
	{
		damage(target);
	}

}
