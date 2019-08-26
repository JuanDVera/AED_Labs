package interfac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.BattleField;

public class StartController {
    @FXML
    private BorderPane space2;

    @FXML
    private BorderPane space1;

    @FXML
    private AnchorPane options2;

    @FXML
    private AnchorPane options1;
    @FXML
    private Button back;
    @FXML
    private TextField rowMatrix1;

    @FXML
    private TextField colMatrix1;

    @FXML
    private TextField rowMatrix2;

    @FXML
    private TextField colMatrix2;

    @FXML
    private ChoiceBox<String> cbRepeated;
    
    private BattleField model;
    
    private GridPane matriz1;
    private GridPane matriz2;
    private GridPane matriz3;
    private Label[][] labelcito1;
    private Label[][] labelcito2;
    private Label[][] labelcito3;   
    @FXML
    void initialize() {
    	matriz1 = new GridPane();
    	matriz2 = new GridPane();
    	matriz3 = new GridPane();
    	model = new BattleField();
    }
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

    @FXML
    void generateMulti(ActionEvent event) {
    	space1.setLeft(matriz1);
    	space1.setRight(matriz2);
    	labelcito1 = new Label[Integer.parseInt(rowMatrix1.getText())][Integer.parseInt(colMatrix1.getText())];
    	labelcito2 = new Label[Integer.parseInt(rowMatrix2.getText())][Integer.parseInt(colMatrix2.getText())];
    	model.createShips(Integer.parseInt(rowMatrix1.getText()), Integer.parseInt(colMatrix1.getText()));
    	model.createShips(Integer.parseInt(rowMatrix2.getText()), Integer.parseInt(colMatrix2.getText()));
    	
    	for (int i = 0; i < labelcito1.length; i++) {
			for (int j = 0; j < labelcito1[0].length; j++) {
				labelcito1[i][j] = new Label(""  + model.getMatrices().get(0)[i][j]);
			}
		}
    	for (int i = 0; i < labelcito2.length; i++) {
			for (int j = 0; j < labelcito2[0].length; j++) {
				labelcito2[i][j] = new Label(""  + model.getMatrices().get(1)[i][j]);
			}
		}
    	showMatrix1();
    	showMatrix2();
    }
    void showMatrix1() {
		for (int i = 0; i < labelcito1.length; i++) 
		{
			for (int j = 0; j < labelcito1[0].length; j++) 
			{
				matriz1.setVgap(17);
				matriz1.setHgap(17);
				matriz1.setAlignment(Pos.CENTER);
				matriz1.add(labelcito1[i][j], j, i);
			}
		}
    }
    void showMatrix2() {
		for (int i = 0; i < labelcito2.length; i++) 
		{
			for (int j = 0; j < labelcito2[0].length; j++) 
			{
				matriz2.setVgap(17);
				matriz2.setHgap(17);
				matriz2.setAlignment(Pos.CENTER);
				matriz2.add(labelcito2[i][j], j, i);
			}
		}
    }
    @FXML
    void showMulti(ActionEvent event) {
    	model.MultiplationOne(model.getMatrices().get(0), model.getMatrices().get(1));
    	space1.setBottom(matriz3);
    	labelcito3 = new Label[model.getDefinitive().length][model.getDefinitive()[0].length];
    	for (int i = 0; i < model.getDefinitive().length; i++) {
			for (int j = 0; j < model.getDefinitive()[0].length; j++) {
				labelcito3[i][j] = new Label("" + model.getDefinitive()[i][j]);
			}
		}
    	multi();
    	
    }
    void multi() {
		for (int i = 0; i < model.getDefinitive().length; i++) 
		{
			for (int j = 0; j < model.getDefinitive()[0].length; j++) 
			{
				matriz3.setVgap(17);
				matriz3.setHgap(17);
				matriz3.setAlignment(Pos.CENTER);
				matriz3.add(labelcito3[i][j], j, i);
			}
		}
    }

}
