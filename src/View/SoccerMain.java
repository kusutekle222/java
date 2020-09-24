package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SoccerMain extends Application {

	/**
	 * 
	 * Main method use to launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	
	}
	
	/**
	 *  * This method is to start the application
     * @param primaryStage
     * 
	 */
	@Override 
	public void start(Stage primaryStage)  {
		TabPane tabPane = new TabPane();
         
		tabPane.getTabs().add(new PlayerView());
		tabPane.getTabs().add(new ManagerView());
		tabPane.getTabs().add(new TeamView());
        tabPane.getTabs().add(new DisplayPlayer());
        tabPane.getTabs().add(new DisplayAllTeams());
        tabPane.getTabs().add(new DisplayManagers());
        VBox vBox = new VBox(tabPane);
        
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Soccer League Application");
        primaryStage.show();
              
	}
}

