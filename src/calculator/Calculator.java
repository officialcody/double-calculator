
package calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*******
 * <p> Title: Calculator Class. </p>
 * 
 * <p> Description: A JavaFX demonstration application and baseline for a sequence of projects </p>
 * 
 * <p> Copyright: Lynn Robert Carter Â© 2016 </p>
 * 
 * @author Sparsh Goel
 *
 * @version 4.03	2018-02-25 The mainline of a JavaFX-based GUI implementation of a Double calculator
 * 
 */

public class Calculator extends Application {
	
	public final static double WINDOW_WIDTH = 650;
	public final static double WINDOW_HEIGHT = 400;
	
	public UserInterface theGUI;

	/**********
	 * This is the start method that is called once the application has been loaded into memory and is 
	 * ready to get to work.
	 * 
	 * In designing this application I have elected to IGNORE all opportunities for automatic layout
	 * support and instead have elected to manually position each GUI element and its properties in
	 * order to exercise complete control over the user interface look and feel.
	 * 
	 */
	@Override
	public void start(Stage theStage) throws Exception {
		
		theStage.setTitle("Sparsh Goel");						// This line show the label of the Calculator window.
		
		Pane theRoot = new Pane();												// This line creates a Java Pane within the Calculator Window.
		
		theGUI = new UserInterface(theRoot);									// This line creates a Graphical User Interface.
		
		Scene theScene = new Scene(theRoot, WINDOW_WIDTH, WINDOW_HEIGHT);		// This line creates the scene.
		
		theStage.setScene(theScene);											// This line sets the scene on the stage.
		
		theStage.show();														// This line shows the stage to the user.
		
		// When the stage is shown to the user, the pane within the window is visible.  This means that the
		// labels, fields, and buttons of the Graphical User Interface (GUI) are visible and it is now 
		// possible for the user to select input fields and enter values into them, click on buttons, and 
		// read the labels, the results, and the error messages.
	}
	
	//This method is used to launch the JavaFX application.
	
	public static void main(String[] args) {				
		launch(args);											
	}															
}
