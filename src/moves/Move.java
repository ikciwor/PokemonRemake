package moves;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import engine.*;


public abstract class Move{
	
	protected PokemonBattling user;
	
	Random rand = new Random();
	TypeChart tab = new TypeChart ();
	
	
	public String name = new String("???");
	
	public int pow=0, acc=100;
	public Type type;
	public boolean special=false;
	public int critRatio=1; //1 - normalne, speed/512
	public boolean touch=false;
	public int ppmax=0;
	public int pp=ppmax;
	private int priority=0;
	
	public Move(PokemonBattling user){
		this.user=user;
	}
	
	
	
	void damage(PokemonBattling target)
	{
		int cAtk=(special)? user.resultSpatk() : user.resultAtk(); //atak pokemona użyty do obliczeń
		int cDef=(special)? target.resultSpdef() : target.resultDef();
		int STAB=(user.getPokemon().spieces.type1==type) ? 2 : 1;
		double typeMod = tab.factor(type, target.getPokemon().spieces.type1) * tab.factor(type, target.getPokemon().spieces.type2);
		int level=user.getPokemon().level;
		
		double modifer=critical() * typeMod * STAB * (rand.nextInt(15)/100+0.85);
		
		double loss=(((2*level+10)*cAtk*pow)/(250*cDef)+2)*modifer;
		
		target.getPokemon().hp=(loss>=target.getPokemon().hp)? 0 : target.getPokemon().hp-(int)loss;
		
		JOptionPane.showMessageDialog(new JFrame(), "DMG: " + loss + " lub int " + (int)loss);
	}
	
	int critical()
	{
		return (critRatio*user.getPokemon().spd/512>=rand.nextInt(100)) ? 2 : 1;
	}
	
	abstract public void doMove(PokemonBattling target);


	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	

	

	
	

}
