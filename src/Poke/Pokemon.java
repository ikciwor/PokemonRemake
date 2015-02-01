package Poke;

import java.util.Random;

import Moves.Move;

public class Pokemon {

	Random rand = new Random();

	public PokemonSpieces spieces = new PokemonSpieces("");

	int ev_hp = 0, ev_spd = 0, ev_atk = 0, ev_spatk = 0, ev_def = 0,
			ev_spdef = 0;

	int iv_hp = rand.nextInt(16), iv_def = rand.nextInt(16),iv_atk = rand.nextInt(16), iv_spdef = rand.nextInt(16),iv_spatk = rand.nextInt(16), iv_spd = rand.nextInt(16);

	public int level = 50;
	public int hp, def, atk, spdef, spatk, spd;
	public Status status;
	protected int maxhp;
	
	private int badPoison=0;

	Move[] move = new Move[4];

	public void recover(int rec) {
		hp = (rec + hp >= maxhp) ? maxhp : rec + hp;
	}
	
	public void damage(int dmg) {
		hp = (hp - dmg > 0) ? hp - dmg : 0;
	}

	public Pokemon() {
		maxhp = (iv_hp + spieces.baseHp + (int) Math.sqrt((double) ev_hp) / 8 + 50) * level / 50 + 10;

		atk = (iv_atk + spieces.baseAtk + (int) Math.sqrt((double) ev_atk) / 8) * level / 50 + 5;
		spatk = (iv_spatk + spieces.baseSpatk + (int) Math.sqrt((double) ev_spatk) / 8) * level / 50 + 5;
		def = (iv_def + spieces.baseDef + (int) Math.sqrt((double) ev_def) / 8) * level / 50 + 5;
		spdef = (iv_spdef + spieces.baseSpdef + (int) Math.sqrt((double) ev_spdef) / 8) * level / 50 + 5;
		spd = (iv_spd + spieces.baseSpd + (int) Math.sqrt((double) ev_spd) / 8) * level / 50 + 5; // okrelanie
																								// statów
	}
	
	public boolean isFainted()
	{
		return hp<=0;
	}
	
	public void doPoison()
	{
		if(badPoison==0)
		{
			damage((int)(maxhp/8));
		}
		else
		{
			damage((int)(maxhp*badPoison/16));
		}
			
	}
	
	
	
}
