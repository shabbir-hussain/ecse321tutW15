package Controllers;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;

import Models.Food;
import Models.Snake;
import Models.Body;
import Views.ApplicationFrame;
import Views.Field;
import java.util.ArrayList;

/**
 * 
 * @author Shabbir
 * This class glues the model and the view together by updating the model
 * the redrawing the view
 */
public class GameController extends Field implements ActionListener {
		
	//declare game specific variables
	protected Field mField;
	protected Snake mSnake;
	protected Food mFood;
	protected boolean gameover=false;
	
	//declare frame specific variables
	private Timer timer;
	Random rand = new Random();
	SnakeKeyAdapter ka = new SnakeKeyAdapter();
	
	public GameController()
	{
		//create Field pointer defined in controller
		mField = this;
		
		//create an instance for the snake
		mSnake = new Snake();
		
		//create an instance of the food
		mFood = new Food(rand.nextInt(ApplicationFrame.SCREEN_WIDTH),rand.nextInt(ApplicationFrame.SCREEN_HEIGHT));
		
		//start the timer
		timer = new Timer(ApplicationFrame.TIMEOUT,this);
		timer.start();
		
		//Add a key listener to this panel
		this.addKeyListener(ka);
	}
	
	public void Draw(){
		//calls the paintComponent function
		mField.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//redraw the snake and the food
		mSnake.drawSnake(g);
		mFood.drawFood(g);

        
        Toolkit.getDefaultToolkit().sync();
	}
	
	public void Update(){
		
		//show the gameover overlay
		if(gameover){
			mField.pnl.setVisible(true);
			return;
		}
		
		//check for gameover scenario
		if(mSnake.isBordered()|| mSnake.checkBodyColision()){
			gameover=true;
		}
		
		//check for snake eating food
		if(mSnake.checkFoodColision(mFood)){
			
			//move foood
			mFood.newPos();
			
			//increase snake's body
			mSnake.addBody();
		}
		
		//update the snake's position
		mSnake.Update();		
	}


	//This method is called everytime the timer times out
	//The basic Game loop
	@Override
	public void actionPerformed(ActionEvent arg0) {

		Update();
		Draw();
	}

	//Reset's the game
	public void restart(){
		mField.pnl.setVisible(false);
		gameover=false;
		mSnake=new Snake();
	}

	private class SnakeKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int key = e.getKeyCode();

			if (key==KeyEvent.VK_ENTER){
				restart();
			}
	
	        if ((key == KeyEvent.VK_LEFT) && (!mSnake.hRight)) {
	            mSnake.goLeft();
	        }
	
	        if ((key == KeyEvent.VK_RIGHT) && (!mSnake.hLeft)) {
	            mSnake.goRight();
	        }
	
	        if ((key == KeyEvent.VK_UP) && (!mSnake.hDown)) {
	            mSnake.goUp();
	        }
	
	        if ((key == KeyEvent.VK_DOWN) && (!mSnake.hUp)) {
	            mSnake.goDown();
	        }
		}
	}

	

	
///////////////////GETTERS AND SETTERS//////////////////
	public Field getField(){
		return mField;
	}
	
}
