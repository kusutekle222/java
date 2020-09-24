package View;


import Controller.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Name;

/**
 * TeamView is to show us the gui for team add and remove teams
 */
public class TeamView extends Tab{
	
	private Label        first, team;
	private Button       addBtn, removeBtn,exit;
	private TextField     teamTxt;
	
	private controller control=new controller();
	
	public TeamView() {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);  // Override default
		grid.setHgap(10);
		grid.setVgap(12);

		setText("Team");
		first = new Label("Welcome to the Soccer League Application");
		first.setFont(new Font("Courier New", 16));
		first.setPadding(new Insets(10, 20, 20, 20));
	
		team = new Label("Team Colour: ");
		team.setFont(new Font("Courier New", 12));

		teamTxt = new TextField();
		teamTxt.setPromptText("Enter Team Colour"  );

		addBtn = new Button("Add a Team");
		addBtn.setStyle("-fx-color:#4169E1");
		addBtn.setFont(new Font("Courier New", 12));
		addBtn.setPadding(new Insets(10, 10, 10, 10));

		removeBtn = new Button("Remove a Team");
		removeBtn.setStyle("-fx-color:#4169E1");
		removeBtn.setFont(new Font("Courier New", 12));
		removeBtn.setPadding(new Insets(10, 10, 10, 10));
		
		exit = new Button("  Exit  ");
		exit.setStyle("-fx-color:#4169E1");
		exit.setFont(new Font("Courier New", 12));
		exit.setPadding(new Insets(10, 10, 10, 10));


		grid.add(first, 1, 0);
		
		grid.add(team, 0, 1);
		grid.add(teamTxt, 1, 1);
			
		HBox h1= new HBox(10);
	    h1.getChildren().addAll(addBtn);
	    HBox h2= new HBox(10);
	    h2.getChildren().addAll(removeBtn);
	    
	    HBox h3= new HBox(10);
	    h3.getChildren().addAll(exit);
		
	    HBox v1= new HBox(20);
	    v1.getChildren().addAll(h1,h2,h3);
	    
		HBox r3 = new HBox(20);
		r3.setAlignment(Pos.CENTER);
		
		r3.getChildren().addAll(first);
		
		HBox h4= new HBox(10);
		
		VBox layout=new VBox(20,r3, grid,h4,v1);
		layout.setPadding(new Insets(10, 30, 30, 10));
		//layout.setPadding(new Insets(10));
		

		addBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				control.addTeam( teamTxt.getText());
			}
		});
		removeBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				control.removeTeam( teamTxt.getText());
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
