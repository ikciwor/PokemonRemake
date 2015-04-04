package engine;

import moves.Move;
import engine.Action.Type;

public class Player {
	
//	Pokemon[] pokemon = new Pokemon[6];
	public PokemonBattling pokemonBattling;
	public Pokemon[] pokemon = new Pokemon[5];
	
	private Action action;
	
	private Bot bot;
	
	public Player(Bot bot){
		
	}
	
	public boolean isBot()
	{
		return bot!=null;
	}
	
	public void setAction(Move move)
	{
		action = new Action(move);
	}
	public void setAction(int id)
	{
		action = new Action(id);
	}
	
	public int getActionPriority()
	{
		return action.getPriority();
	}
	
	public Type getActionType()
	{
		return action.getType();
	}
	
	public int getActionIdToSwitch() {
		return action.getIdToSwitch();
	}
	
	public Move getActionMove() {
		return action.getMove();
	}

}
