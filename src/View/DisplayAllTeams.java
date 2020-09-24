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
 * DisplayAllTeam is GUI for display all the team to the screen
 * @author kusu
 *
 */
public class DisplayAllTeams extends Tab {
	private Label league,first;
	private TextArea textarea;

	private controller c= new controller();
	private Button Display,exit;
	public DisplayAllTeams() {
		setText("DisplayTeams");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);  // Override default
		grid.setHgap(10);
		grid.setVgap(12);

		first = new Label("Welcome to the Soccer League Application");
		first.setFont(new Font("Courier New", 16));
		first.setPadding(new Insets(10, 20, 20, 20));

		league = new Label("All Teams in the League ");
		league.setFont(new Font("Courier New", 12));

		Display = new Button("Display");
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
		grid.add(league, 0, 1);

		HBox h3= new HBox(10);
		h3.getChildren().addAll(Display);

		HBox h4= new HBox(10);
		h4.getChildren().addAll(exit);

		HBox h5= new HBox(10);
		h5.getChildren().addAll(h3,h4);

		HBox r3 = new HBox(20);
		r3.setAlignment(Pos.CENTER);
		r3.getChildren().addAll(first);

		VBox layout=new VBox(20,r3, grid,h5,vb2);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10, 30, 30, 10));

		
		Display.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String n = c.displayTeam();
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
