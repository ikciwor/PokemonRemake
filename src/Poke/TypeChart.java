package Poke;

import Poke.Type;

public class TypeChart {
	
	/* 0 - Normal
	 * 1 - Fight
	 * 2 - Fly
	 * 3 - Poison
	 * 4 - Ground
	 * 5 - Rock
	 * 6 - Bug
	 * 7 - Ghost
	 * 8 - Steel
	 * 9 - Fire
	 * 10 - Water
	 * 11 - Grass
	 * 12 - Electric
	 * 13 - Psychic
	 * 14 - Ice
	 * 15 - Dragon
	 * 16 - Dark
	 * 17 - Fairy
	 */
	
	public double factor(Type type1, Type type2)
	{
		return t[type1.getId()][type2.getId()];
	}
	
	public static final double t[][] = new double[18][18];
	
	public TypeChart()
	{

		t[0][0]=1;
		t[0][1]=1;
		t[0][2]=1;
		t[0][3]=1;
		t[0][4]=1;
		t[0][5]=0.5;
		t[0][6]=1;
		t[0][7]=0;
		t[0][8]=0.5;
		t[0][9]=1;
		t[0][10]=1;
		t[0][11]=1;
		t[0][12]=1;
		t[0][13]=1;
		t[0][14]=1;
		t[0][15]=1;
		t[0][16]=1;
		t[0][17]=1;
		
		t[1][0]=2;
		t[1][1]=1;
		t[1][2]=0.5;
		t[1][3]=0.5;
		t[1][4]=1;
		t[1][5]=2;
		t[1][6]=0.5;
		t[1][7]=0;
		t[1][8]=2;
		t[1][9]=1;
		t[1][10]=1;
		t[1][11]=1;
		t[1][12]=1;
		t[1][13]=0.5;
		t[1][14]=2;
		t[1][15]=1;
		t[1][16]=2;
		t[1][17]=0.5;
		
		t[2][0]=1;
		t[2][1]=2;
		t[2][2]=1;
		t[2][3]=1;
		t[2][4]=1;
		t[2][5]=0.5;
		t[2][6]=2;
		t[2][7]=1;
		t[2][8]=0.5;
		t[2][9]=1;
		t[2][10]=1;
		t[2][11]=2;
		t[2][12]=0.5;
		t[2][13]=1;
		t[2][14]=1;
		t[2][15]=1;
		t[2][16]=1;
		t[2][17]=1;
		
		t[3][0]=1;
		t[3][1]=1;
		t[3][2]=1;
		t[3][3]=0.5;
		t[3][4]=0.5;
		t[3][5]=0.5;
		t[3][6]=1;
		t[3][7]=0.5;
		t[3][8]=0;
		t[3][9]=1;
		t[3][10]=1;
		t[3][11]=2;
		t[3][12]=1;
		t[3][13]=1;
		t[3][14]=1;
		t[3][15]=1;
		t[3][16]=1;
		t[3][17]=2;
		
		t[4][0]=1;
		t[4][1]=1;
		t[4][2]=0;
		t[4][3]=2;
		t[4][4]=1;
		t[4][5]=2;
		t[4][6]=0.5;
		t[4][7]=1;
		t[4][8]=2;
		t[4][9]=2;
		t[4][10]=1;
		t[4][11]=0.5;
		t[4][12]=2;
		t[4][13]=1;
		t[4][14]=1;
		t[4][15]=1;
		t[4][16]=1;
		t[4][17]=1;
		
		t[5][0]=1;
		t[5][1]=0.5;
		t[5][2]=2;
		t[5][3]=1;
		t[5][4]=0.5;
		t[5][5]=1;
		t[5][6]=2;
		t[5][7]=1;
		t[5][8]=0.5;
		t[5][9]=2;
		t[5][10]=1;
		t[5][11]=1;
		t[5][12]=1;
		t[5][13]=1;
		t[5][14]=2;
		t[5][15]=1;
		t[5][16]=1;
		t[5][17]=1;
		
		t[6][0]=1;
		t[6][1]=0.5;
		t[6][2]=0.5;
		t[6][3]=0.5;
		t[6][4]=1;
		t[6][5]=1;
		t[6][6]=1;
		t[6][7]=0.5;
		t[6][8]=0.5;
		t[6][9]=0.5;
		t[6][10]=1;
		t[6][11]=2;
		t[6][12]=1;
		t[6][13]=2;
		t[6][14]=1;
		t[6][15]=2;
		t[6][16]=0.5;
		t[6][17]=1;
	

		
		t[7][0]=0;
		t[7][1]=1;
		t[7][2]=1;
		t[7][3]=1;
		t[7][4]=1;
		t[7][5]=1;
		t[7][6]=1;
		t[7][7]=2;
		t[7][8]=1;
		t[7][9]=1;
		t[7][10]=1;
		t[7][11]=1;
		t[7][12]=1;
		t[7][13]=2;
		t[7][14]=1;
		t[7][15]=1;
		t[7][16]=0.5;
		t[7][17]=1;
		
		t[8][0]=1;
		t[8][1]=1;
		t[8][2]=1;
		t[8][3]=1;
		t[8][4]=1;
		t[8][5]=2;
		t[8][6]=1;
		t[8][7]=1;
		t[8][8]=0.5;
		t[8][9]=0.5;
		t[8][10]=0.5;
		t[8][11]=1;
		t[8][12]=0.5;
		t[8][13]=1;
		t[8][14]=2;
		t[8][15]=1;
		t[8][16]=1;
		t[8][17]=2;
		
		t[9][0]=1;
		t[9][1]=1;
		t[9][2]=1;
		t[9][3]=1;
		t[9][4]=1;
		t[9][5]=0.5;
		t[9][6]=2;
		t[9][7]=1;
		t[9][8]=2;
		t[9][9]=0.5;
		t[9][10]=0.5;
		t[9][11]=2;
		t[9][12]=1;
		t[9][13]=1;
		t[9][14]=2;
		t[9][15]=0.5;
		t[9][16]=1;
		t[9][17]=1;
		
		t[10][0]=1;
		t[10][1]=1;
		t[10][2]=1;
		t[10][3]=1;
		t[10][4]=2;
		t[10][5]=2;
		t[10][6]=1;
		t[10][7]=1;
		t[10][8]=1;
		t[10][9]=2;
		t[10][10]=0.5;
		t[10][11]=0.5;
		t[10][12]=1;
		t[10][13]=1;
		t[10][14]=1;
		t[10][15]=0.5;
		t[10][16]=1;
		t[10][17]=1;
		
		t[11][0]=1;
		t[11][1]=1;
		t[11][2]=0.5;
		t[11][3]=0.5;
		t[11][4]=2;
		t[11][5]=2;
		t[11][6]=0.5;
		t[11][7]=1;
		t[11][8]=0.5;
		t[11][9]=0.5;
		t[11][10]=2;
		t[11][11]=0.5;
		t[11][12]=1;
		t[11][13]=1;
		t[11][14]=1;
		t[11][15]=0.5;
		t[11][16]=1;
		t[11][17]=1;
		
		t[12][0]=1;
		t[12][1]=1;
		t[12][2]=2;
		t[12][3]=1;
		t[12][4]=0;
		t[12][5]=1;
		t[12][6]=1;
		t[12][7]=1;
		t[12][8]=1;
		t[12][9]=1;
		t[7][10]=2;
		t[12][11]=0.5;
		t[12][12]=0.5;
		t[12][13]=1;
		t[12][14]=1;
		t[12][15]=0.5;
		t[12][16]=1;
		t[12][17]=1;
		
		t[13][0]=1;
		t[13][1]=2;
		t[13][2]=1;
		t[13][3]=2;
		t[13][4]=1;
		t[13][5]=1;
		t[13][6]=1;
		t[13][7]=1;
		t[13][8]=0.5;
		t[13][9]=1;
		t[13][10]=1;
		t[13][11]=1;
		t[13][12]=1;
		t[13][13]=0.5;
		t[13][14]=1;
		t[13][15]=1;
		t[13][16]=0;
		t[13][17]=1;
		
		t[14][0]=1;
		t[14][1]=1;
		t[14][2]=2;
		t[14][3]=1;
		t[14][4]=2;
		t[14][5]=1;
		t[14][6]=1;
		t[14][7]=1;
		t[14][8]=0.5;
		t[14][9]=0.5;
		t[14][10]=0.5;
		t[14][11]=2;
		t[14][12]=1;
		t[14][13]=1;
		t[14][14]=0.5;
		t[14][15]=2;
		t[14][16]=1;
		t[14][17]=1;
		
		t[15][0]=1;
		t[15][1]=1;
		t[15][2]=1;
		t[15][3]=1;
		t[15][4]=1;
		t[15][5]=1;
		t[15][6]=1;
		t[15][7]=1;
		t[15][8]=0.5;
		t[15][9]=1;
		t[15][10]=1;
		t[15][11]=1;
		t[15][12]=1;
		t[15][13]=1;
		t[15][14]=1;
		t[15][15]=2;
		t[15][16]=1;
		t[15][17]=0;
	
		t[16][0]=1;
		t[16][1]=0.5;
		t[16][2]=1;
		t[16][3]=1;
		t[16][4]=1;
		t[16][5]=1;
		t[16][6]=1;
		t[16][7]=2;
		t[16][8]=1;
		t[16][9]=1;
		t[16][10]=1;
		t[16][11]=1;
		t[16][12]=1;
		t[16][13]=2;
		t[16][14]=1;
		t[16][15]=1;
		t[16][16]=0.5;
		t[16][17]=0.5;
		
		t[17][0]=1;
		t[17][1]=2;
		t[17][2]=1;
		t[17][3]=0.5;
		t[17][4]=1;
		t[17][5]=1;
		t[17][6]=1;
		t[17][7]=1;
		t[17][8]=0.5;
		t[17][9]=0.5;
		t[17][10]=1;
		t[17][11]=1;
		t[17][12]=1;
		t[17][13]=1;
		t[17][14]=1;
		t[17][15]=2;
		t[17][16]=2;
		t[17][17]=1;
		
		
		
		
	}

}
