package engine;

import java.util.Random;

import moves.Move;

public class Pokemon {

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
	 public PokemonBattling turnIntoBattling()
	 {
		 PokemonBattling out=new PokemonBattling(spieces);
		 
		 out.atk=this.atk;
		 out.def=this.def;
		 out.hp=this.hp;
		 out.spatk=this.spatk;
		 out.spdef=this.spdef;
		 out.spd=this.spd;
		 out.maxhp=this.maxhp;
		 
		 out.ev_atk=this.ev_atk;
		 out.ev_hp=this.ev_hp;
		 out.ev_def=this.ev_def;
		 out.ev_spdef=this.ev_spdef;
		 out.ev_spatk=this.ev_spatk;
		 out.ev_spd=this.ev_spd;
		 
		 out.level=this.level;
		 out.status=this.status;
		 out.name=this.name;
		 
		 out.move[0]=this.move[0];
		 out.move[0]=this.move[1];
		 out.move[0]=this.move[2];
		 out.move[0]=this.move[3];
		 
		 out.iv_atk=this.iv_atk;
		 out.iv_hp=this.iv_hp;
		 out.iv_def=this.iv_def;
		 out.iv_spdef=this.iv_spdef;
		 out.iv_spatk=this.iv_spatk;
		 out.iv_spd=this.iv_spd;
				 	 
		 return out;
	 }
	
}
