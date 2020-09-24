
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

/**
 * ManagerView is show us Gui for add and remove managers
 */
public class ManagerView extends Tab{

	private Label        first,firstName,middleName,lastName,email,phone,dob,starRate,team;
	private Button       addBtn, removeBtn, loadBtn, exit;
	private TextField    firstNameTxt,middleNameTxt,lastNameTxt,emailTxt,phoneTxt,dobTxt,starRateTxt,teamTxt;
	private final ObservableList options = FXCollections.observableArrayList();

	private controller c=new controller();
	public ManagerView() {
		c.fillComboBox(options);
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);  // Override default
		grid.setHgap(10);
		grid.setVgap(12);


		setText("Manager");
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

		dob = new Label("DOB: ");
		dob.setFont(new Font("Courier New", 12));

		starRate = new Label("Star Rate: ");
		starRate.setFont(new Font("Courier New", 12));

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
		dobTxt = new TextField();
		dobTxt.setPromptText("Enter Date of birth "  );
		starRateTxt = new TextField();
		starRateTxt.setPromptText("Enter rate"  );
		teamTxt = new TextField();
		teamTxt.setPromptText("Enter Team Colour"  );


		// listCars = new TextArea();

		addBtn = new Button("Add a Manager");
		addBtn.setStyle("-fx-color:#4169E1");
		addBtn.setFont(new Font("Courier New", 12));
		addBtn.setPadding(new Insets(10, 10, 10, 10));

		removeBtn = new Button("Remove a Manager");
		removeBtn.setStyle("-fx-color:#4169E1");
		removeBtn.setFont(new Font("Courier New", 12));
		removeBtn.setPadding(new Insets(10, 10, 10, 10));


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

		grid.add(dob, 2, 3);
		grid.add(dobTxt, 3, 3);

		grid.add(starRate, 2, 4);
		grid.add(starRateTxt, 3, 4);

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
		h3.getChildren().addAll(exit);

		HBox v1= new HBox(20);
		v1.getChildren().addAll(h1,h2,h3);

		HBox r3 = new HBox(20);
		r3.setAlignment(Pos.CENTER);
		r3.getChildren().addAll(first);


		VBox layout=new VBox(20,r3, grid,v1);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10, 30, 30, 10));


		addBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				c.addManager(firstNameTxt.getText(), middleNameTxt.getText(),lastNameTxt.getText(), 
						phoneTxt.getText(),emailTxt.getText(),dobTxt.getText(),Integer.parseInt(starRateTxt.getText()), 
						comboBox.getValue().toString());
			}
		});

		removeBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				c.removeManager( firstNameTxt.getText());
			}
		});



		Pane pane = new Pane();
		pane.getChildren().addAll(layout);
		setContent(pane);

	}

}