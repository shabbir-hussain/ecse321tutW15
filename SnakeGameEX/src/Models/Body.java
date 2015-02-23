package Models;

import java.awt.Color;
import Views.ApplicationFrame;

public class Body{

	public int xPos;
	public int yPos;
	
	public int size;

	public int frameLeft;


	
	public Color color;
	
	public Body(int x, int y, int f){
		xPos = x;
		yPos = y;
		size = 10;
		frameLeft= f;
		color = Color.GREEN;
	}
	public void setBodyPosition(int x, int y, int f){
		xPos=x;
		yPos=y;
		frameLeft = f;
	}
	
}