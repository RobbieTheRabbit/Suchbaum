package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/*********************************************************************
 * Die Main Klasse für die Tiefensuche
 * 
 * @author Sven Böhrnsen
 *********************************************************************/

public class Main extends Application {
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("layout.css").toExternalForm());

			primaryStage.setTitle("Yggdrasil- Binärer Suchbaum Visualisierer");
			primaryStage.setResizable(false);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
