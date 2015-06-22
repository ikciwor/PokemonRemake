package engine;

import java.util.Random;

import moves.Move;

public class Pokemon implements Cloneable{

	Random rand = new Random();

	public PokemonSpieces spieces;

	int ev_hp = 0, ev_spd = 0, ev_atk = 0, ev_spatk = 0, ev_def = 0,
			ev_spdef = 0;

	int iv_hp = rand.nextInt(16), iv_def = rand.nextInt(16),iv_atk = rand.nextInt(16), iv_spdef = rand.nextInt(16),iv_spatk = rand.nextInt(16), iv_spd = rand.nextInt(16);

	public int level = 50;
	public int maxhp, def, atk, spdef, spatk, spd;
	public Status status=Status.NONE;
	public int hp;
	public String name = new String();
	
	private int badPoison=0;

	public Move[] move = new Move[4];

	public Pokemon(PokemonSpieces spieces) {
		
		this.spieces=spieces;
		
		/* Określanie statów */
		
		maxhp = (iv_hp + spieces.baseHp + (int) Math.sqrt((double) ev_hp) / 8 + 50) * level / 50 + 10;

		atk = (iv_atk + spieces.baseAtk + (int) Math.sqrt((double) ev_atk) / 8) * level / 50 + 5;
		spatk = (iv_spatk + spieces.baseSpatk + (int) Math.sqrt((double) ev_spatk) / 8) * level / 50 + 5;
		def = (iv_def + spieces.baseDef + (int) Math.sqrt((double) ev_def) / 8) * level / 50 + 5;
		spdef = (iv_spdef + spieces.baseSpdef + (int) Math.sqrt((double) ev_spdef) / 8) * level / 50 + 5;
		spd = (iv_spd + spieces.baseSpd + (int) Math.sqrt((double) ev_spd) / 8) * level / 50 + 5;
		
		hp=maxhp;
	}
	
	public void damage(int dmg) {
		hp = (hp - dmg > 0) ? hp - dmg : 0;
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
	
	public boolean isFainted()
	{
		return hp<=0;
	}
	
	public void recover(int rec) {
		hp = (rec + hp >= maxhp) ? maxhp : rec + hp;
	}
	
	public String getName()
	{
		return (name==null || name.length()<1)? spieces.name : name;
	}
	 
	
}
