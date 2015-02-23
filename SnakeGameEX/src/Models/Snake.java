package Models;

import java.awt.Color;
import java.awt.Graphics;

import Views.ApplicationFrame;

/**
 * 
 * @author Shabbir
 * This Class models the snake in the snake game
 */
public class Snake {
	
	//position and velocity
	public int xPos;
	public int yPos;
	public int sVelocity;
	
	//height and width of sqares
	public int sqHeight;
	public int sqLength;
	
	//current length of body
	public int bodyLength;

	Body[] mBody=new Body[2000];
	
	//heading direction

	public boolean hRight;
	public boolean hLeft;
	public boolean hUp;
	public boolean hDown;
	
	public Color color;
	
	public Snake(){

		//position and velocity
		xPos =100;
		yPos =100;
		sVelocity = 4;
		
		//height and width of sqares
		sqHeight=10;
		sqLength=10;
		
		//lenght of body
		bodyLength=4;
		
		//heading direction
		hRight=true;
		hLeft=false;
		hUp=false;
		hDown=false;
		
		color = Color.GREEN;
		
		//init body
		for (int i =0 ; i<this.bodyLength+1 ; i++ ) {
			mBody[i]=new Body(this.xPos,this.yPos, 1+1*i);
		}
	}
	
	//set heading direction
	public void goRight(){
		hRight=true;
		hLeft=false;
		hUp=false;
		hDown=false;
	}
	public void goLeft(){
		hRight=false;
		hLeft=true;
		hUp=false;
		hDown=false;
	}
	public void goUp(){
		hRight=false;
		hLeft=false;
		hUp=true;
		hDown=false;
	}
	public void goDown(){
		hRight=false;
		hLeft=false;
		hUp=false;
		hDown=true;
	}
	
	public void Update(){

		//move the snake
		if(hRight){
			xPos += sVelocity;
		}else if(hLeft){
			xPos -= sVelocity;
		}else if(hUp){
			yPos -= sVelocity;
		}else if(hDown){
			yPos += sVelocity;
		}
	
		for (int i =0 ; i<this.bodyLength+1 ; i++ ) {
			mBody[i].frameLeft=mBody[i].frameLeft-1;
			if (mBody[i].frameLeft==0){
				mBody[i].setBodyPosition(this.xPos,this.yPos,this.bodyLength);
			}
		}
		
		
	}
	
	//
	public void drawSnake(Graphics g) {

		for(int i=0;i<this.bodyLength;i++){
			this.drawBody(g, i);
		}
		
    }
    private void drawBody(Graphics g, int i){
    	g.setColor(mBody[i].color);
    	g.drawRect(mBody[i].xPos, mBody[i].yPos, mBody[i].size, mBody[i].size);
    	g.fillRect(mBody[i].xPos, mBody[i].yPos, mBody[i].size, mBody[i].size);

	}
	
	public boolean checkBodyColision(){
		//TODO: check if the snake hit its own body
		return false;
	}

	
	//Check if snake hit a wall
	public boolean isBordered(){
		if(xPos + sqLength > ApplicationFrame.SCREEN_WIDTH || xPos< 0){
			return true;
		}
		if(yPos + sqHeight > ApplicationFrame.SCREEN_HEIGHT || yPos < 0){
			return true;
		}
		
		return false;
	}

	
	//returns true if the food and snake are colliding
	public boolean checkFoodColision(Food mFood){
		//TODO: check if snake touches food
		return false;
	}
		
	//Increases the bodylength of the snake
	public void addBody() {
		//TODO: increase bodysize of snake by 1
	}
	
	

	
	
}
