package Views;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import Controllers.GameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Shabbir
 * This class is the container class for the project
 */
public class ApplicationFrame extends JFrame {

	// constants
	public static final int SCREEN_WIDTH = 400;
	public static final int SCREEN_HEIGHT = 400;
	public static final String APP_NAME = "Snake Game 2015";
	
	public static final int TIMEOUT = 30;                          		
	protected GameController controller = new GameController(); 
		
	public  ApplicationFrame(){
		init();
	}
	
	/**
	 * Initialize the window
	 */
	private void init(){
		
		//set the Frame properties
		add(controller.getField());
		setSize(SCREEN_WIDTH,SCREEN_HEIGHT);	
		setTitle(APP_NAME);
		pack();         												
		
		//set the x button as the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
		setLocationRelativeTo(null);
		setVisible(true);
		
	}



}
