/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.editor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tanmay
 */
public class FXMLCalculatorController implements Initializable {

    @FXML
    private AnchorPane finalCalculatorFXID;
    @FXML
    private Button calcCloseButtonFXID;
    @FXML
    private TextArea calculatorTextAreaFXID;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button divide;
    @FXML
    private Button multiplication;
    @FXML
    private Button negativePositive;
    @FXML
    private Button clr;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button positive;
    @FXML
    private Button percentage;
    @FXML
    private Button log;
    @FXML
    private Button ln;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button minus;
    @FXML
    private Button power;
    @FXML
    private Button modulo;
    @FXML
    private Button factorial;
    @FXML
    private Button zero;
    @FXML
    private Button openParenth;
    @FXML
    private Button closeParenth;
    @FXML
    private Button equalTo;
    @FXML
    private Button inverse;
    @FXML
    private Button sqrt;
    @FXML
    private Button mod;
    @FXML
    private Button calcGetButtonFXID;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @author Tanmay
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       calculatorTextAreaFXID.setWrapText(true);
    }    

    @FXML
    public void calculatorClose(ActionEvent event) {
        ((Stage)calcCloseButtonFXID.getScene().getWindow()).close();
    }
    
    @FXML
    public void calculatorClear(ActionEvent event){
        calculatorTextAreaFXID.clear();
        
    }
    
}
