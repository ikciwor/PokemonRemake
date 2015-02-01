package Moves;

import java.util.Random;

import Poke.*;


public abstract class Move{
	
	protected PokemonBattling user;
	
	Random rand = new Random();
	TypeChart tab = new TypeChart ();
	
	
	public String name = new String("DEFAULT");
	
	public int pow=0, acc=100;
	public Type type=Type.NORMAL;
	public boolean special=false;
	public int critRatio=1; //1 - normalne, speed/512
	public boolean touch=false;
	public int ppmax=0;
	public int pp=ppmax;
	public int priority=0;
	
	
	
	void damage(PokemonBattling target)
	{
		int cAtk=(special)? user.spatk : user.atk; //atak pokemona użyty do obliczeń
		int cDef=(special)? target.spdef : target.def;
		
		double mod=tab.factor(type, target.spieces.type1) * (tab.factor(type, target.spieces.type2) * ((critical()) ? 2 : 1) * ((user.spieces.type1==type) ? 2 : 1)) * (rand.nextInt(15)/100+0.85); //rel. typów, STAB1STAB2, critical, random
		
		double loss=( (2*user.level+10 )/255 * cAtk/cDef * pow * ((special)? user.resultSpatk()/target.resultSpdef() : user.resultAtk()/target.resultDef() ) +2) * mod; //level, staty, moc, m_staty, mod
		
		target.hp=(loss>=target.hp)? 0 : target.hp-(int)loss;
	}
	
	boolean critical()
	{
		return critRatio*user.spd/512>=rand.nextInt(100);
	}
	
	public void doMove(PokemonBattling target)
	{

	}
	
	

	

	
	

}
