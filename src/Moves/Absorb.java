package Moves;

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
	
	public void doMove()
	{
		double lastdmg=victim.hp; //strata hp, jednoczenie pamięta ile miał hp przed atakiem
		damage();
		lastdmg=lastdmg-victim.hp;
		user.recover((int)lastdmg/2);
		--pp;
	}
	

}
