import java.awt.Desktop;
import java.io.File;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
	// Application > Scene > Pane

	//declaring buttons so that we could use it for action
	private Button C;
	private Button D;
	private Button E;
	private Button F;
	private Button G;
	private Button restart_button;
	private Button shutDown_button;
	private Button SD_Timer;
	private Button RS_Timer;
	private Button info_button;

	// Desktop > for access directories
	Desktop desktop = Desktop.getDesktop();
	//Pane the main scene
	Pane root = new Pane();
	//For call other classes
	Application obj1 = new ShutDown();
	Application obj2 = new ReStart();

	public void start(Stage primaryStage) {

		// C button
		C = new Button("C-Drive");
		C.setOnAction(this);
		C.setLayoutX(50);
		C.setLayoutY(150);
		C.setStyle("-fx-background-color: #9ACD32");
		root.getChildren().add(C);

		// D button
		D = new Button("D-Drive");
		D.setOnAction(this);
		D.setLayoutX(130);
		D.setLayoutY(150);
		D.setStyle("-fx-background-color: #9ACD32");
		root.getChildren().add(D);

		// E button
		E = new Button("E-Drive");
		E.setOnAction(this);
		E.setLayoutX(210);
		E.setLayoutY(150);
		E.setStyle("-fx-background-color: #9ACD32");
		root.getChildren().add(E);

		// F button
		F = new Button("F-Drive");
		F.setOnAction(this);
		F.setLayoutX(290);
		F.setLayoutY(150);
		F.setStyle("-fx-background-color: #9ACD32");
		root.getChildren().add(F);

		// G button
		G = new Button("G-Drive");
		G.setOnAction(this);
		G.setLayoutX(370);
		G.setLayoutY(150);
		G.setStyle("-fx-background-color: #9ACD32");
		root.getChildren().add(G);

		// HBox to store all drive buttons
		HBox row = new HBox();
		row.setLayoutX(68);
		row.setLayoutY(130);
		row.setSpacing(5);

		// Setting the margin to the nodes
		HBox.setMargin(C, new Insets(20, 10, 20, 20));
		HBox.setMargin(D, new Insets(20, 10, 20, 10));
		HBox.setMargin(E, new Insets(20, 10, 20, 10));
		HBox.setMargin(F, new Insets(20, 10, 20, 10));
		HBox.setMargin(G, new Insets(20, 20, 20, 10));

		// retrieving the observable list of the HBox
		ObservableList<Node> listOfDrive = row.getChildren();

		// Adding all the nodes to the observable list (HBox)
		listOfDrive.addAll(C, D, E, F, G);
		row.setStyle("-fx-background-color: #af753f");
		root.getChildren().add(row);

	
		
		// > Shut-Down
		// Shut-Down button
		shutDown_button = new Button("Shut-Down");
		shutDown_button.setOnAction(this);
		shutDown_button.setStyle("-fx-background-color: #9ACD32");
		root.getChildren().add(shutDown_button);

		// Set Timer for Shut Down button
		SD_Timer = new Button("Set Timer");
		SD_Timer.setOnAction(this);
		SD_Timer.setStyle("-fx-background-color: #9ACD32");
		root.getChildren().add(SD_Timer);

		// VBox to store Shut Down options
		VBox rowForSD = new VBox();
		rowForSD.setLayoutX(68);
		rowForSD.setLayoutY(245);

		// Setting the margin to the nodes
		VBox.setMargin(shutDown_button, new Insets(20, 60, 10, 20));
		VBox.setMargin(SD_Timer, new Insets(10, 60, 20, 20));

		// retrieving the observable list of the VBox
		ObservableList<Node> listOfSD = rowForSD.getChildren();

		// Adding all the nodes to the observable list (VBox)
		listOfSD.addAll(shutDown_button, SD_Timer);
		rowForSD.setStyle("-fx-background-color: #af753f");
		root.getChildren().add(rowForSD);

		
		
		
		// > Re-Start
		// Re-Start button
		restart_button = new Button("Re-Start");
		restart_button.setOnAction(this);
		restart_button.setStyle("-fx-background-color: #9ACD32");
		root.getChildren().add(restart_button);

		// Set Timer for Re-Starting PC button
		RS_Timer = new Button("Set Timer");
		RS_Timer.setOnAction(this);
		RS_Timer.setStyle("-fx-background-color: #9ACD32");
		root.getChildren().add(RS_Timer);

		// VBox to store Re-Start options
		VBox rowForRS = new VBox();
		rowForRS.setLayoutX(340);
		rowForRS.setLayoutY(245);

		// Setting the margin to the nodes
		VBox.setMargin(restart_button, new Insets(20, 60, 10, 20));
		VBox.setMargin(RS_Timer, new Insets(10, 60, 20, 20));

		// retrieving the observable list of the VBox
		ObservableList<Node> listOfRS = rowForRS.getChildren();

		// Adding all the nodes to the observable list (VBox)
		listOfRS.addAll(restart_button, RS_Timer);
		rowForRS.setStyle("-fx-background-color: #af753f");
		root.getChildren().add(rowForRS);

		
		
		
		// > System info
		info_button = new Button("Show System Info");
		info_button.setOnAction(this);
		info_button.setStyle("-fx-background-color: #9ACD32");

		// VBox to store others info
		VBox infoBox = new VBox();
		infoBox.setLayoutX(70);
		infoBox.setLayoutY(388);
		
		// Setting the margin to the nodes
		VBox.setMargin(info_button, new Insets(20, 148, 20, 160));

		// retrieving the observable list of the VBox
		ObservableList<Node> list = infoBox.getChildren();

		// Adding all the nodes to the observable list (VBox)
		list.addAll(info_button);
		infoBox.setStyle("-fx-background-color: #af753f");
		root.getChildren().add(infoBox);

		
		
		
		// > Labels
		// Drive Folders
		Label drive = new Label("DRIVE FOLDERS");
		drive.setFont(new Font("Arial", 12));
		drive.setLayoutX(235);
		drive.setLayoutY(102);
		drive.setEffect(new DropShadow(10, Color.WHITE));
		drive.setTextFill(Color.BLACK);
		root.getChildren().add(drive);

		// OPTION: SHUT DOWN
		Label OptionSD = new Label("OPTION: SHUT DOWN");
		OptionSD.setFont(new Font("Arial", 12));
		OptionSD.setLayoutX(80);
		OptionSD.setLayoutY(220);
		OptionSD.setEffect(new DropShadow(10, Color.WHITE));
		OptionSD.setTextFill(Color.BLACK);
		root.getChildren().add(OptionSD);

		// OPTION: RE-START
		Label OptionRS = new Label("OPTION: RE-START");
		OptionRS.setFont(new Font("Arial", 12));
		OptionRS.setLayoutX(355);
		OptionRS.setLayoutY(220);
		OptionRS.setEffect(new DropShadow(10, Color.WHITE));
		OptionRS.setTextFill(Color.BLACK);
		root.getChildren().add(OptionRS);

		// Team Abstract
		Label buttom_label1 = new Label("Developed By");
		buttom_label1.setFont(new Font("Arial", 13));
		buttom_label1.setTextFill(Color.BLACK);
		buttom_label1.setLayoutX(240);
		buttom_label1.setLayoutY(485);

		Label buttom_label2 = new Label("Team Abstract");
		buttom_label2.setFont(new Font("Arial", 18));
		buttom_label2.setTextFill(Color.WHITESMOKE);
		buttom_label2.setLayoutX(210);
		buttom_label2.setLayoutY(505);
		root.getChildren().add(buttom_label1);
		root.getChildren().add(buttom_label2);

		// Title Label
		Label title_label = new Label("PC Controller");
		title_label.setLayoutX(195);
		title_label.setLayoutY(40);
		title_label.setFont(new Font("Arial", 30));
		//title_label.setTextFill(Color.BLACK);
		root.getChildren().add(title_label);

		// main pane
		root.setStyle("-fx-background-color: #CD853F");
		Scene s = new Scene(root, 550, 550);
		primaryStage.setTitle("PC Controller Application");
		primaryStage.getIcons().add(new Image("/main icon.png"));
		primaryStage.setScene(s);
		primaryStage.show();

	}
	
	@Override
	public void handle(ActionEvent event) {

		//when C button clicked
		if (event.getSource() == C) { // C

			try {
				//execute C drive using File class then open
				File directory = new File("C:\\");
				desktop.open(directory);

			} catch (Exception ex) {
				//if drive not exist on your pc then the program will show an alert!
				DriveNotFoundAlert();

			}

		}
		
		//when D button clicked
		if (event.getSource() == D) { // D

			try {

				File directory = new File("D:\\");
				desktop.open(directory);

			} catch (Exception ex) {
				DriveNotFoundAlert();

			}

		}

		//when E button clicked
		if (event.getSource() == E) { // E
			try {
				File directory = new File("E:\\");
				desktop.open(directory);
			} catch (Exception ex) {
				DriveNotFoundAlert();
			}
		}

		//when F button clicked
		if (event.getSource() == F) { // F
			try {
				File directory = new File("F:\\");
				desktop.open(directory);
			} catch (Exception ex) {
				DriveNotFoundAlert();
			}
		}

		//when G button clicked 
		if (event.getSource() == G) { // G
			try {
				File directory = new File("G:\\");
				desktop.open(directory);
			} catch (Exception ex) {
				DriveNotFoundAlert();
			}
		}

		//when re start button clicked 
		if (event.getSource() == restart_button) { // Re-Start
			try {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				// Get the Stage.
				Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

				// Add a custom icon.
				stage.getIcons().add(new Image(this.getClass().getResource("/switch.png").toString()));
				alert.setTitle("Confirmation !");
				alert.setHeaderText("Are you sure you want to Re-start your PC?");
				alert.setContentText("Click ok to confirm Re-Start");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					// Runtime run = Runtime.getRuntime();
					// Process pro = run.exec("shutdown -r -t 1");
					Runtime.getRuntime().exec("shutdown -r -t 1");
				}
			} catch (Exception ex) {
				ErrorAlert();
			}
		}

		//when shut down button pressed
		if (event.getSource() == shutDown_button) { // Shut Down
			try {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				// Get the Stage.
				Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

				// Add a custom icon.
				stage.getIcons().add(new Image(this.getClass().getResource("/switch.png").toString()));
				alert.setTitle("Confirmation !");
				alert.setHeaderText("Are you sure you want to Shut Down your PC?");
				alert.setContentText("Click ok to confirm Shut Down");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					// Runtime run = Runtime.getRuntime();
					// Process pro = run.exec("shutdown -s -t 1");
					Runtime.getRuntime().exec("shutdown -s -t 1");
				}

			} catch (Exception ex) {
				ErrorAlert();
			}
		}

		if (event.getSource() == SD_Timer) { // Shut Down Timer

			//Application obj1 = new ShutDown();
			Stage ShutDown_TimerStage = new Stage();
			try {
				obj1.start(ShutDown_TimerStage);
			} catch (Exception ex) {
				ErrorAlert();
			}
		}

		if (event.getSource() == RS_Timer) { // Re-Start Timer
			//Application obj2 = new ReStart();
			Stage Restart_TimerStage = new Stage();
			try {
				obj2.start(Restart_TimerStage);
			} catch (Exception ex) {
				ErrorAlert();
			}
		}

		if (event.getSource() == info_button) { // CMD-systeminfo
			try {
				Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + "systeminfo");

			} catch (Exception ex) {
				ErrorAlert();
			}
		}

	}

	public void DriveNotFoundAlert() { // This method is to generate Drive not found alert dialog box.
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Drive");
		alert.setHeaderText("Drive Error !");
		alert.setContentText("DRIVE NOT FOUND ON YOUR PC");

		// Get the Stage.
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

		// Add a custom icon.
		stage.getIcons().add(new Image(this.getClass().getResource("/drive.png").toString()));

		alert.showAndWait();
	}

	public void ErrorAlert() { // This method is to generate Error alert dialog box.
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Warning");
		alert.setHeaderText("Error !");
		alert.setContentText("Ooops, there was an error!");

		// Get the Stage.
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

		// Add a custom icon.
		stage.getIcons().add(new Image(this.getClass().getResource("/warning icon.jpg").toString()));

		alert.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
