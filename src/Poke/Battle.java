package Poke;

import java.util.Random;

public class Battle {

	Random rand = new Random();
	
	Player[] players = new Player[2];
	
	PokemonBattling [] pok = new PokemonBattling[2]; //skrót
	PokemonBattling [] targets = new PokemonBattling[4]; //do podwójnych
	
	private int[] usedMove = new int[2];
	
	
	
	

	public Weather weather;


	public Battle() {
		
		pok[0]=players[0].pokemonBattling;
		pok[1]=players[1].pokemonBattling; //skrót

		// for(int i=0; i<2;++i)
		// {
		// for(int j=0; j<6;++j)
		// {
		// pokemon[i][j]=Pokemon.searchByName((i==0)? Frame.party.getItemAt(j) :
		// Frame.party2.getItemAt(j));
		// }
		// }



	}
	
	void reset()
	{
		for (int i = 0; i < 5; ++i) {
			for (int j= 0; j<4; ++j) {
				players[0].pokemon[i].move[j].pp = players[0].pokemon[i].move[j].ppmax;
				players[1].pokemon[i].move[j].pp = players[1].pokemon[i].move[j].ppmax;
			}
		}
	}

	void executeTurn() {
		
		int[] order = turnOrder();
		
		pok[0]=players[order[0]].pokemonBattling;
		pok[1]=players[order[1]].pokemonBattling;
		
		pok[0].move[usedMove[order[0]]].doMove(pok[1]);
		pok[1].move[usedMove[order[1]]].doMove(pok[0]);
		

	}
	
	public int[] turnOrder()
	{
		int[] order = new int[2];
		
		if(pok[0].getPriorityOfMove(usedMove[0])==pok[1].getPriorityOfMove(usedMove[1]))
		{
			
			if(pok[0].resultSpd()>pok[1].resultSpd())
			{
				order[0]=0;
				order[1]=1;

			}
			else if(pok[1].resultSpd()>pok[0].resultSpd())
			{
				order[0]=1;
				order[1]=0;
			}
			else
			{
				int r = rand.nextInt(2);
				
				order[0]=r;
				order[1]=(r-1)%2;
			}
			
		}
		else if(pok[0].getPriorityOfMove(usedMove[0])>pok[1].getPriorityOfMove(usedMove[1]))
		{
			order[0]=0;
			order[1]=1;
		}
		else
		{
			order[0]=1;
			order[1]=0;
		}
		return order;
	}
	/*
	public int[] turnOrder(PokemonBattling[] target) //dla podwójnych walk
	{
		Random r = new Random();
		
		int[] order = new int[4];
		int[] priorityOrder = new int[4];
		
		for(int i=0; i<4;++i)
		{
			int n=0;
			for(int j=0; j<4; ++j)
			{
				if(j==i) continue;
				
	
				if(pok[i].getPriorityOfMove(usedMove[i])>pok[j].getPriorityOfMove(usedMove[j]))
				{
					n++;
				}
				priorityOrder[i]=n;
				
			}
		}
		
		int nextPlace=0;

		for(int i=3; i>=0; --i) //dla każdego priorytetu od najwyższego
		{
			int[] pkmsOnPriority = new int[4];
			int k=0;
			for(int j=0; j<4; ++j)
			{
				if(priorityOrder[j]==i)
				{
					++k;
					pkmsOnPriority[k]=j; //tablica mieszcząca numery pokemonów w danym priorytecie (i)
				}
			}
			if(k==0) continue;
			if(k==1)
			{
				order[nextPlace]=pkmsOnPriority[0];
				++nextPlace;
				continue;
			}
			
			for (int j=0; j<k; ++j)
			{
				int place=nextPlace;
				for(int m=0; m<k;++m)
				{
					if(j==m) continue;
					if(pok[pkmsOnPriority[j]].resultSpd()<pok[pkmsOnPriority[m]].resultSpd())
					{
						++place;
					} else if (pok[pkmsOnPriority[j]].resultSpd()==pok[pkmsOnPriority[m]].resultSpd() && r.nextInt(2)==1)
					{
						++place;
					}
				}
				while(order[place]>=0 && order[place]<=4) ++place;
				order[place]=pkmsOnPriority[j];
				
				
			}
			nextPlace+=k;

		} 
		
		
		
		
		return order;
	}//zgrubsza powinno działać */


	

	public void switchPokemon(int id) {
		// odpalić kontunuuj
	}
	
	public void chooseMove(int id)
	{
		// odpalić kontynuuj
	}

	public void runTurn() {
		// odpalić turn w nowym wątku
	}
}
