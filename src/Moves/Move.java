package Moves;

import java.util.Random;

import Poke.*;


public abstract class Move{
	
	protected PokemonBattling user;
	protected PokemonBattling victim;
	
	Random rand = new Random();
	TypeChart tab = new TypeChart ();
	
	
	public String name = new String("DEFAULT");
	
	public int pow=0, acc=100;
	public Type type=Type.NORMAL;
	public boolean sp=false;
	public int critratio=1; //1 - normalne, speed/512
	public boolean touch=false;
	public int ppmax=0;
	public int pp=ppmax;
	
	void damage()
	{
		int cAtk=(sp)? user.spatk : user.atk; //atak pokemona użyty do obliczeń
		int cDef=(sp)? victim.spdef : victim.def;
		
		double mod=tab.factor(type, victim.spieces.type1) * (tab.factor(type, victim.spieces.type2) * ((critical()) ? 2 : 1) * ((user.spieces.type1==type) ? 2 : 1)) * (rand.nextInt(15)/100+0.85); //rel. typów, STAB1STAB2, critical, random
		
		double loss=( (2*user.level+10 )/255 * cAtk/cDef * pow * ((sp) ? (stat(user.m_spatk)/stat(victim.m_spdef)) : (stat(user.m_atk)/stat(victim.m_def))) +2) * mod; //level, staty, moc, m_staty, mod
		
		victim.hp=(loss>=victim.hp)? 0 : victim.hp-(int)loss;
	}
	
	double stat(int m) //m_staty - zmienione w trakcie walki
	{
		return (m>=0)? (m+2)/2 : 2/(-m+2); //prawidłowy mnożnik
	}
	
	boolean critical()
	{
		return critratio*user.spd/512>=rand.nextInt(100);
	}
	
	public void doMove(){}
	
	

}
