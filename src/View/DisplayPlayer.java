package View;

import java.util.List;

import Controller.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
 * DisplayPlayer is Gui for display the players to the screen 
 * @author kusu
 *
 */
public class DisplayPlayer extends Tab {
	private TextField teamTxt;
	private Label team,first;
	private TextArea textarea;

	private controller c= new controller();
	private Button Display,exit;
	private final ObservableList options = FXCollections.observableArrayList();


	public DisplayPlayer() {
		c.fillComboBox(options);
		setText("DisplayPlayer");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);  // Override default
		grid.setHgap(10);
		grid.setVgap(12);

		first = new Label("Welcome to the Soccer League Application");
		first.setFont(new Font("Courier New", 16));
		first.setPadding(new Insets(10, 20, 20, 20));

		team = new Label("Team Colour: ");
		team.setFont(new Font("Courier New", 12));



		teamTxt = new TextField();
		teamTxt.setPromptText("Enter team colour "  );


		Display = new Button(" Display Players ");
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

		final ComboBox comboBox= new ComboBox(options);
		comboBox.setMaxHeight(30);

		HBox r4 = new HBox(20);
		r4.getChildren().addAll(comboBox);

		grid.add(team, 4, 1);
		grid.add(r4, 5, 1);

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
				String n = c.playerDetail(comboBox.getValue().toString());
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
