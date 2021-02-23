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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tanmay
 */
public class FXMLHelpController implements Initializable {

    @FXML
    private Button qustionMarkHelpMaximButtonFXID;
    @FXML
    private Button qustionMarkHelpCloseButtonFXID;
    @FXML
    private HBox helpHBoxFXID;
    @FXML
    private AnchorPane hlepAnchorePaneFXID;
    @FXML
    private Label webLabelFXID;
    @FXML
    private Label creatorLabelFXID;
    @FXML
    private Label licenceLabelFXID;
    @FXML
    private Label agreementLabelFXID;
    

    @FXML
    public void helpMaximize(ActionEvent event) throws Exception{
        if (((Stage)qustionMarkHelpMaximButtonFXID.getScene().getWindow()).isMaximized()) {
            qustionMarkHelpMaximButtonFXID.setText("M");
            ((Stage)qustionMarkHelpMaximButtonFXID.getScene().getWindow()).setMaximized(false);
        } else {
            qustionMarkHelpMaximButtonFXID.setText("m");
            ((Stage)qustionMarkHelpMaximButtonFXID.getScene().getWindow()).setMaximized(true);
        }
        if ("m".equals(qustionMarkHelpMaximButtonFXID.getText())) {
            helpHBoxFXID.setAlignment(Pos.TOP_CENTER);
        } else {
            helpHBoxFXID.setAlignment(Pos.TOP_LEFT);
        }
        
    }

    @FXML
    public void helpClose(ActionEvent event) throws Exception{
        ((Stage)qustionMarkHelpCloseButtonFXID.getScene().getWindow()).close();
        
    }
       
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @author Tanmay
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        qustionMarkHelpMaximButtonFXID.setText("M");
        qustionMarkHelpCloseButtonFXID.setText("X");
        
    }    

    @FXML
    public void webOnMouseExited(MouseEvent event) {
        webLabelFXID.setTextFill(new Color(22, 96, 174, 1.0));
    }

    @FXML
    public void webOnMouseEntered(MouseEvent event) {
        webLabelFXID.setTextFill(Color.LIGHTBLUE);
    }

    @FXML
    public void webOnMouseClicked(MouseEvent event) {
        //wait for code
    }

    @FXML
    public void creatorOnMouseExited(MouseEvent event) {
        creatorLabelFXID.setUnderline(false);
    }

    @FXML
    public void creatorOnMouseEntered(MouseEvent event) {
        creatorLabelFXID.setUnderline(true);
    }

    @FXML
    public void creatorOnMouseClicked(MouseEvent event) {
        //wait for code
    }

    @FXML
    public void licenceOnMouseExited(MouseEvent event) {
        licenceLabelFXID.setUnderline(false);
    }

    @FXML
    public void licenceOnMouseEntered(MouseEvent event) {
        licenceLabelFXID.setUnderline(true);
    }

    @FXML
    public void licenceOnMouseClicked(MouseEvent event) {
        //wait for code
    }

    @FXML
    public void agreementOnMouseExited(MouseEvent event) {
        agreementLabelFXID.setUnderline(false);
    }

    @FXML
    public void agreementOnMouseEntered(MouseEvent event) {
        agreementLabelFXID.setUnderline(true);
    }

    @FXML
    public void agreementOnMouseClicked(MouseEvent event) {
        //wait for code
    }

    
}
