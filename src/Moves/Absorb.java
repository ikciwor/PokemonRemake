package Moves;

import Poke.PokemonBattling;
import Poke.Type;


public class Absorb extends Move{
	
	public Absorb()
	{
		pow=25;
		acc=100;
		type=Type.GRASS;
		special=true;
		touch=true;
		name="ABSORB";
		pp=ppmax=25;
		
	}
	
	public void doMove(PokemonBattling target)
	{
		double lastdmg=target.hp; //strata hp, jednoczenie pamięta ile miał hp przed atakiem
		damage(target);
		lastdmg=lastdmg-target.hp;
		user.recover((int)lastdmg/2);
	}
	

}
