package Poke;

import java.util.Random;

public class Bot {
	
	private Battle battle;
	
	Random rand = new Random();
	
	private Player me;
	private Player opponent;
	
	public Bot(Battle battle, Player me, Player opponent){
		this.battle = battle;	
		this.me=me;
		this.opponent=opponent;
		
	}
	
	public void play()
	{
		if(me.pokemonBattling.isFainted()) {
			int which = 1;  // which
			battle.switchPokemon(me, which);
		} else {
			battle.takeOrders(rand.nextInt(4));
		}
	}
	

}
