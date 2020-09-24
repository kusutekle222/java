
package View;


import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
import javafx.scene.control.ComboBox;
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
import model.Team;

/**
 * PlayerView is show us GUI for player add, remove and search player
 *  to remove player put firstname 
 *  to search player put firstName and middleName
 *  to update put firstName and new goal values
 */
public class PlayerView extends Tab{

	private Label        first,firstName,middleName,lastName,email,phone,goalie,goal,team;
	private Button       addBtn, removeBtn, searchBtn,updateBtn, exit;
	private TextField    firstNameTxt,middleNameTxt,lastNameTxt,emailTxt,phoneTxt,goalieTxt,goalTxt,teamTxt;
	private TextArea     listplayer;
	private final ObservableList options = FXCollections.observableArrayList();

	private controller c=new controller();


	public PlayerView() {

		c.fillComboBox( options);
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);  // Override default
		grid.setHgap(10);
		grid.setVgap(12);

		listplayer = new TextArea("");
		VBox vb2 = new VBox(listplayer);

		setText("Player");
		first = new Label("Welcome to the Soccer League Application");
		first.setFont(new Font("Courier New", 16));
		first.setPadding(new Insets(10, 20, 20, 20));

		firstName = new Label("First Name: ");
		firstName.setFont(new Font("Courier New", 12));

		middleName = new Label("Middle Name: ");
		middleName.setFont(new Font("Courier New", 12));

		lastName = new Label("Last Name: ");
		lastName.setFont(new Font("Courier New", 12));

		email = new Label("Email: ");
		email.setFont(new Font("Courier New", 12));

		phone = new Label("Phone: ");
		phone.setFont(new Font("Courier New", 12));

		goalie = new Label("Goalie: ");
		goalie.setFont(new Font("Courier New", 12));

		goal = new Label("Goals: ");
		goal.setFont(new Font("Courier New", 12));

		team = new Label("Team Colour: ");
		team.setFont(new Font("Courier New", 12));


		firstNameTxt = new TextField();
		firstNameTxt.setPromptText("Enter First Name "  );
		middleNameTxt = new TextField();
		middleNameTxt.setPromptText("Enter Middle Name "  );
		lastNameTxt = new TextField();
		lastNameTxt.setPromptText("Enter Last Name "  );
		emailTxt = new TextField();
		emailTxt.setPromptText("Enter Email"  );
		phoneTxt = new TextField();
		phoneTxt.setPromptText("Enter Phone number "  );
		goalieTxt = new TextField();
		goalieTxt.setPromptText("Are there Goals? "  );
		goalTxt = new TextField();
		goalTxt.setPromptText("Enter Goals"  );
		teamTxt = new TextField();
		teamTxt.setPromptText("Enter Team Colour"  );


		// listCars = new TextArea();

		addBtn = new Button("Add a Player");
		addBtn.setStyle("-fx-color:#4169E1");
		addBtn.setFont(new Font("Courier New", 12));
		addBtn.setPadding(new Insets(10, 10, 10, 10));

		removeBtn = new Button("Remove a Player");
		removeBtn.setStyle("-fx-color:#4169E1");
		removeBtn.setFont(new Font("Courier New", 12));
		removeBtn.setPadding(new Insets(10, 10, 10, 10));

		searchBtn = new Button("Search Player ");
		searchBtn.setStyle("-fx-color:#4169E1");
		searchBtn.setFont(new Font("Courier New", 12));
		searchBtn.setPadding(new Insets(10, 10, 10, 10));

		updateBtn = new Button("Update Player ");
		updateBtn.setStyle("-fx-color:#4169E1");
		updateBtn.setFont(new Font("Courier New", 12));
		updateBtn.setPadding(new Insets(10, 10, 10, 10));

		exit = new Button("  Exit  ");
		exit.setStyle("-fx-color:#4169E1");
		exit.setFont(new Font("Courier New", 12));
		exit.setPadding(new Insets(10, 10, 10, 10));



		grid.add(first, 1, 0);

		grid.add(firstName, 0, 1);
		grid.add(firstNameTxt, 1, 1);

		grid.add(middleName, 0, 2);
		grid.add(middleNameTxt, 1, 2);

		grid.add(lastName, 0, 3);
		grid.add(lastNameTxt, 1, 3);

		grid.add(email, 2, 1);
		grid.add(emailTxt, 3, 1);

		grid.add(phone, 2, 2);
		grid.add(phoneTxt, 3, 2);

		grid.add(goalie, 2, 3);
		grid.add(goalieTxt, 3, 3);

		grid.add(goal, 2, 4);
		grid.add(goalTxt, 3, 4);


		final ComboBox comboBox= new ComboBox(options);
		comboBox.setMaxHeight(30);

		HBox r4 = new HBox(20);
		r4.getChildren().addAll(comboBox);

		grid.add(team, 4, 1);
		grid.add(r4, 5, 1);

		HBox h1= new HBox(10);
		h1.getChildren().addAll(addBtn);

		HBox h2= new HBox(10);
		h2.getChildren().addAll(removeBtn);

		HBox h3= new HBox(10);
		h3.getChildren().addAll(searchBtn);

		HBox h5= new HBox(10);
		h5.getChildren().addAll(updateBtn);

		HBox h4= new HBox(10);
		h4.getChildren().addAll(exit);

		HBox v1= new HBox(20);
		v1.getChildren().addAll(h1,h2,h3,h5,h4);

		HBox r3 = new HBox(20);
		r3.setAlignment(Pos.CENTER);
		r3.getChildren().addAll(first);


		VBox layout=new VBox(20,r3, grid,v1,vb2);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10, 30, 30, 10));





		addBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				c.addplayer(firstNameTxt.getText(), middleNameTxt.getText(),lastNameTxt.getText(), 
						phoneTxt.getText(),emailTxt.getText(),Integer.parseInt(goalTxt.getText()), 
						Boolean.parseBoolean(goalieTxt.getText()), comboBox.getValue().toString());
			}
		});

		removeBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				c.removeplayer(firstNameTxt.getText());
			}
		});

		searchBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String n = c.search(firstNameTxt.getText(), middleNameTxt.getText());
				listplayer.setText(n);
			}
		});


		updateBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				c.Update(Integer.parseInt(goalTxt.getText()),firstNameTxt.getText());
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