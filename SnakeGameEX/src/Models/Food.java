package Models;

import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class Food {

	Random rnd = new Random();

	public int xPos;
	public int yPos;
	
	public int size;
	
	public Color color;
	
	public Food mFood = this;
	
	public Food(int x, int y){
		xPos = x;
		yPos = y;
		size = 10;
		
		color = Color.WHITE;
	}
	public void newPos(){
		xPos = rnd.nextInt(400-20);
		yPos = rnd.nextInt(400-20);
	}
	
	public void drawFood(Graphics g){
		g.setColor(mFood.color);
		g.drawRect(mFood.xPos, mFood.yPos, mFood.size, mFood.size);
		g.fillRect(mFood.xPos, mFood.yPos, mFood.size, mFood.size);
	}
}
