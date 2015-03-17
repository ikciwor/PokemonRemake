package engine;

import java.awt.image.BufferedImage;

public class PokemonSpieces{
	
	public Type type1, type2; 
	public String name;
	public BufferedImage imgFront, imgBack;
	public int baseAtk, baseSpatk, baseDef, baseSpdef, baseSpd, baseHp;
	
	public PokemonSpieces(String name)
	{
		this.name=name;
	}

}
