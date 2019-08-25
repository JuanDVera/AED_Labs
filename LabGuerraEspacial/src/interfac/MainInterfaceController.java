package interfac;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainInterfaceController implements Initializable {
	
	
	
	
	@FXML
	private Button star;
	@FXML
	private Button instruction;
	@FXML
	private Button exit;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

//	public void viewInstructions() throws Exception {
//		
//		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("./Instruction.fxml"));
//		Parent root1= (Parent)fxmlLoader.load();
//		 
//		
//		Stage stage= new Stage();
//		 
//		stage.setScene(new Scene(root1));
//		 
//		
//		stage.show();
//		
//	}
//	
//	
	

}
