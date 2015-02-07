package Poke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends Frame {
	
	Battle battle = new Battle(this);
	Player[] players = new Player[2];
	
	public Gui()
	{
		players[0]=battle.players[0];
		players[1]=battle.players[1];
	}

	void gen() {
		
		for(int i=0; i<4; ++i){
			addMoveButton(i);
		}
		
		switchPkmn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				enableMoves(false);
				if (battle.areButtonsAllowed()) {
					
					if(change.isVisible()){
						battle.players[battle.getCurrentPlayer()]//88888
					}
					else {
						genChange();
					}
					
				}

			}
		});
		
	}
	public void addMoveButton(final int d)
	{
		move[d].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				enableMoves(false);
				if (battle.areButtonsAllowed()) {

					battle.chooseMove(players[battle.getCurrentPlayer()], battle.pok[battle.getCurrentPlayer()].move[d]);
					if(battle.getCurrentPlayer()<2)
					{
						battle.takeOrders(battle.getCurrentPlayer()+1);
					}
					else
					{
						battle.executeRound();
					}
				}

			}
		});
	}
	
	public int getPressedButton()
	{
		if(move[0].getModel().isPressed())
		{
			return 0;
		}
		if(move[1].getModel().isPressed())
		{
			return 1;
		}
		if(move[2].getModel().isPressed())
		{
			return 2;
		}
		if(move[3].getModel().isPressed())
		{
			return 3;
		}
		if(switchPkmn.getModel().isPressed())
		{
			return 5;
		}
		return -1;
			
	}
	

	public void enableMoves(boolean b)
	{
		for(int i=0; i<4; ++i)
		{
			move[i].setEnabled(b);
		}
	}
	
	public void enableMoves(int a, boolean b)
	{
			move[a].setEnabled(b);
	}

}
