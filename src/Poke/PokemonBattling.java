package Poke;


public class PokemonBattling extends Pokemon{
	

	public int m_def=0, m_atk=0, m_spdef=0, m_spatk=0, m_spd=0;
	public int acc=100, evs=100;

	
	boolean confused=false;
	
	
	double stat(int m) //m_staty - zmienione w trakcie walki
	{
		return (m>=0)? (m+2)/2 : 2/(-m+2); //prawidłowy mnożnik
	}
	
	int resultAtk()
	{
		return atk*(int)stat(m_atk);
	}
	
	int resultSpatk()
	{
		return spatk*(int)stat(m_spatk);
	}
	
	int resultDef()
	{
		return def*(int)stat(m_def);
	}
	
	int resultSpdef()
	{
		return spdef*(int)stat(m_spdef);
	}
	
	int resultSpd()
	{
		return spd*(int)stat(m_spd);
	}
	
	public int getM_def() {
		return m_def;
	}

	public void setM_def(int m_def) {
		this.m_def = m_def;
	}

	public int getM_atk() {
		return m_atk;
	}

	public void setM_atk(int m_atk) {
		this.m_atk = m_atk;
	}

	public int getM_spdef() {
		return m_spdef;
	}

	public void setM_spdef(int m_spdef) {
		this.m_spdef = m_spdef;
	}

	public int getM_spatk() {
		return m_spatk;
	}

	public void setM_spatk(int m_spatk) {
		this.m_spatk = m_spatk;
	}

	public int getM_spd() {
		return m_spd;
	}

	public void setM_spd(int m_spd) {
		this.m_spd = m_spd;
	}

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}

	public int getEvs() {
		return evs;
	}

	public void setEvs(int evs) {
		this.evs = evs;
	}

	public boolean isConfused() {
		return confused;
	}

	public void setConfused(boolean confused) {
		this.confused = confused;
	}
	
}
