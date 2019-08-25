package interfac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class StartController {
    @FXML
    private AnchorPane space2;

    @FXML
    private AnchorPane space1;

    @FXML
    private AnchorPane options2;

    @FXML
    private AnchorPane options1;
    @FXML
    private Button back;
    
    @FXML
    void showSpace1(ActionEvent event) {
    	options2.toBack();
    	options2.setVisible(false);
    	space2.toBack();
    	space2.setVisible(false);
    	options1.setVisible(true);
    	options1.toFront();
    	space1.toFront();
    	space1.setVisible(true);
    }

    @FXML
    void showSpace2(ActionEvent event) {
    	options1.toBack();
    	options1.setVisible(false);
    	space1.toBack();
    	space1.setVisible(false);
    	options2.setVisible(true);
    	options2.toFront();
    	space2.toFront();
    	space2.setVisible(true);
    }
    @FXML
    void goBack(ActionEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
    		back.getScene().setRoot(root);
    	}catch(Exception e) {
    		
    	}
    }

}
