package interfac;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;


public class PrincipalController implements Initializable {
	
	
	
	
	@FXML
	private Button start;
	@FXML
	private Button instruction;
	@FXML
	private Button exit;
	
    @FXML
    void showExit(ActionEvent event) {

    }

    @FXML
    void showInstruction(ActionEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("Instruction.fxml"));
    		start.getScene().setRoot(root);
    	}catch(Exception e) {
    		System.out.println("Vali verga");
    	}
    }

    @FXML
    void showStart(ActionEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
    		start.getScene().setRoot(root);
    	}catch(Exception e) {
    		System.out.println("Vali verga");
    	}
		
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	


	

}
