package interfac;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



public class MainInterface extends Application {
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("./Principal.fxml"));
		Scene scene = new Scene(root, 1100, 800);
		
		primaryStage.setScene(scene);
		primaryStage.setMaximized(false);

		primaryStage.show();
	}
			
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
}
