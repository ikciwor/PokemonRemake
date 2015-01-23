package Moves;

public class Growl extends Move{
	
	public Growl()
	{
		name="GROWL";
		pp=ppmax=40;
	}
	
	public void doMove()
	{
		victim.m_atk--;
		--pp;
	}

}
