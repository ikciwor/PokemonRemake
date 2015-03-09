package engine;

import moves.Move;

public class Action {
	
	Move move;
	int priority;
	int idToSwitch;
	


	public enum Type {MOVE, SWITCH, STILL}
	Type type;
	
	public Action(Move move)
	{
		type=Type.MOVE;
		this.move=move;
		this.priority=this.move.getPriority();
	}
	public Action(int id)
	{
		type=Type.SWITCH;
		this.idToSwitch=id;
		this.priority=6;
	}
	
	
	public int getPriority() {
		return priority;
	}
	
	public Type getType()
	{
		return type;
	}
	
	public int getIdToSwitch() {
		return idToSwitch;
	}
	
	public Move getMove() {
		return move;
	}
}
