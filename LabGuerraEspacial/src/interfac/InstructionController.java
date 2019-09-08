package interfac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InstructionController {
    @FXML
    private Button back;
   

    @FXML
    void goBack(ActionEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
    		back.getScene().setRoot(root);
    	}catch(Exception e) {
    		
    	}
    	
    }
   
}
