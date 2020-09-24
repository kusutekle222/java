package View;

import java.util.List;

import Controller.controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.League;
import model.Player;
import model.Team;


/**
 * DisplayManager id GUI for display manager detail to the screen 
 * @author kusu
 *
 */
public class DisplayManagers extends Tab {
	private Label manager,first;
	private TextArea textarea;
	
	private controller c= new controller();
	private Button Display,Display1,exit;
	public DisplayManagers() {
		setText("Display Managers");
			
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);  // Override default
		grid.setHgap(10);
		grid.setVgap(12);
	
		first = new Label("Welcome to the Soccer League Application");
		first.setFont(new Font("Courier New", 16));
		first.setPadding(new Insets(10, 20, 20, 20));

		manager = new Label("All Managers With both Ordering  ");
		manager.setFont(new Font("Courier New", 12));
		
		
		
		
		Display = new Button("Display Manager ");
		Display.setStyle("-fx-color:#4169E1");
		Display.setFont(new Font("Courier New", 12));
		Display.setPadding(new Insets(10, 10, 10, 10));
		

		
		exit = new Button("  Exit  ");
		exit.setStyle("-fx-color:#4169E1");
		exit.setFont(new Font("Courier New", 12));
		exit.setPadding(new Insets(10, 10, 10, 10));
	     
	     textarea = new TextArea("");
		VBox vb2 = new VBox(textarea);

	    
	    grid.add(first, 1, 0);
		grid.add(manager, 0, 1);
		
		HBox h3= new HBox(10);
		h3.getChildren().addAll(Display);
		
		
		HBox h6= new HBox(10);
		h6.getChildren().addAll(exit);
		
		HBox h5= new HBox(10);
		h5.getChildren().addAll(h3,h6);

		HBox r3 = new HBox(20);
		r3.setAlignment(Pos.CENTER);
		r3.getChildren().addAll(first);

		VBox layout=new VBox(20,r3, grid,h5,vb2);
		layout.setPadding(new Insets(10, 30, 30, 10));

		
		
	    Display.setOnAction(new EventHandler<ActionEvent>() {
		
			public void handle(ActionEvent event) {
				String n = c.displayManager();
				textarea.setText(n);
			}
		});
	    

	    
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		}
				);
	    Pane pane = new Pane();
	    pane.getChildren().addAll(layout);
	    setContent(pane);
		
		
	}

}
