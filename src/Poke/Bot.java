package Poke;

import java.util.Random;

public class Bot {

	private Battle battle;

	Random rand = new Random();

	private Player me;
	private Player opponent;

	public Bot(Battle battle, Player me, Player opponent) {
		this.battle = battle;
		this.me = me;
		this.opponent = opponent;

	}

	public void play() {
		if (me.pokemonBattling.isFainted()) {

		} else {
			battle.takeOrders(rand.nextInt(4));
		}
	}

}
