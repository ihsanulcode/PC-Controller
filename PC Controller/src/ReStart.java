import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ReStart extends Application implements EventHandler<ActionEvent> {

	Pane root = new Pane();
	private TextField hours_txt;
	private TextField min_txt;
	private TextField seconds_txt;
	private Label hours_lbl;
	private Label min_lbl;
	private Label seconds_lbl;
	private Button setButton;

	public void start(Stage primaryStage) {

		// Hour
		hours_lbl = new Label("Enter Hours : ");
		hours_txt = new TextField();
		hours_lbl.setLayoutX(100);
		hours_lbl.setLayoutY(100);
		hours_txt.setLayoutX(200);
		hours_txt.setLayoutY(100);
		root.getChildren().add(hours_lbl);
		root.getChildren().add(hours_txt);

		// Minute
		min_lbl = new Label("Enter Minute : ");
		min_txt = new TextField();
		min_lbl.setLayoutX(100);
		min_lbl.setLayoutY(150);
		min_txt.setLayoutX(200);
		min_txt.setLayoutY(150);
		root.getChildren().add(min_lbl);
		root.getChildren().add(min_txt);

		// Second
		seconds_lbl = new Label("Enter Second : ");
		seconds_txt = new TextField();
		seconds_lbl.setLayoutX(100);
		seconds_lbl.setLayoutY(200);
		seconds_txt.setLayoutX(200);
		seconds_txt.setLayoutY(200);
		root.getChildren().add(seconds_lbl);
		root.getChildren().add(seconds_txt);

		// SET Button
		setButton = new Button("Set");
		setButton.setOnAction(this);
		setButton.setLayoutX(230);
		setButton.setLayoutY(280);
		root.getChildren().add(setButton);

		Scene s = new Scene(root, 500, 400);
		primaryStage.setTitle("Re-Start Timer Settings");
		primaryStage.getIcons().add(new Image("/timer icon.png"));
		primaryStage.setScene(s);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {

		//when set button pressed
		if (event.getSource() == setButton) {

			//if user input null
			if ((hours_txt.getText().equals("")) || (min_txt.getText().equals(""))
					|| (seconds_txt.getText().equals(""))) {
				ErrorAlert();
				//if user input is negative
			}else if(Integer.valueOf(hours_txt.getText()) < 0 || Integer.valueOf(min_txt.getText()) < 0
					|| Integer.valueOf(seconds_txt.getText()) < 0) {
				ErrorAlert();
				//if user input 0 for all field
			}else if(Integer.valueOf(hours_txt.getText()) == 0 && Integer.valueOf(min_txt.getText()) == 0
					&& Integer.valueOf(seconds_txt.getText()) == 0) {
				ErrorAlert();
			}//otherwise calculate total second
			else {

				int h = Integer.valueOf(hours_txt.getText());

				int m = Integer.valueOf(min_txt.getText());

				int s = Integer.valueOf(seconds_txt.getText());
				int total = (h * 60 * 60) + (m * 60) + s;

				try {

					// Runtime run = Runtime.getRuntime();
					// Process pro = run.exec("shutdown -r -t " + total);
					Runtime.getRuntime().exec("shutdown -r -t " + total);

				} catch (Exception e) {
					ErrorAlert();
				}

			}

		}
	}

	public void ErrorAlert() { // This method is to generate Error alert dialog box.
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Alert");
		alert.setHeaderText("Error !");
		alert.setContentText("Please Enter correct values!");

		// Get the Stage.
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

		// Add a custom icon.
		stage.getIcons().add(new Image(this.getClass().getResource("/warning icon.jpg").toString()));
		alert.showAndWait();
	}
}
