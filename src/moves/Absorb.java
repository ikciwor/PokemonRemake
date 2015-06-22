package moves;

import engine.PokemonBattling;
import engine.Type;

public class Absorb extends Move {

	public Absorb(PokemonBattling user) {
		super(user);
		pow = 20;
		acc = 100;
		type = Type.GRASS;
		special = true;
		touch = true;
		name = "ABSORB";
		pp = ppmax = 25;

	}

	public void doMove(PokemonBattling target) {
		double lastdmg = target.getPokemon().hp; // strata hp, jednoczenie pamięta ile miał
									// hp przed atakiem
		damage(target);
		lastdmg = lastdmg - target.getPokemon().hp;
		user.getPokemon().recover((int) lastdmg / 2);
	}

}
