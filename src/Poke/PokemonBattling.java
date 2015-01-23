package Poke;


public class PokemonBattling extends Pokemon{
	

	public int m_hp=0, m_def=0, m_atk=0, m_spdef=0, m_spatk=0, m_spd=0;
	public int acc=100, evs=100;

	
	boolean confused=false;
	
	boolean fainted()
	{
		return hp<=0;
	}
	

	

	
	double stat(int m) //m_staty - zmienione w trakcie walki
	{
		return (m>=0)? (m+2)/2 : 2/(-m+2); //prawidłowy mnożnik
	}
	
	int r_atk()
	{
		return atk*(int)stat(m_atk);
	}
	
	int r_spatk()
	{
		return spatk*(int)stat(m_spatk);
	}
	
	int r_def()
	{
		return def*(int)stat(m_def);
	}
	
	int r_spdef()
	{
		return spdef*(int)stat(m_spdef);
	}
	
	int r_spd()
	{
		return spd*(int)stat(m_spd);
	}
	

}
