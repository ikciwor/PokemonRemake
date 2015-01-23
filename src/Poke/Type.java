package Poke;

public enum Type {
	
	NORMAL(0), FIGHT(1), FLY(2), POISON(3), GROUND(4), ROCK(5), BUG(6), GHOST(7), STEEL(8), FIRE(9), 
	WATER(10), GRASS(11), ELECTRIC(12), PSYCHIC(13), ICE(14), DRAGON(15), DARK(16), FAIRY(17);

	 private int id;

	private Type(int i) {
		 id = i;
	 }

	 public int getId() {
	 return id;
	 }
}	
