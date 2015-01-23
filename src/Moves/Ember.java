package Moves;

import Poke.Status;
import Poke.Type;

public class Ember extends Move{
	
	public Ember()
	{
		pow=40;
		pp=25;
		ppmax=25;
		sp=true;
		touch=false;
		type=Type.FIRE;
		name="EMBER";
	}
	
	public void doMove()
	{
		damage();
		if(rand.nextInt(10)==0)
			victim.status=Status.BURN;
	}

}
