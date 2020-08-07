/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.editor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tanmay
 */
public class FXMLSettingController implements Initializable {

    //*****************Setting Panes****************************
    @FXML
    private AnchorPane settingAnchorPaneFXID;
    
    //******************Setting Color Box************************
    @FXML
    private ColorPicker settingTextColorChooserFXID;
    
    //******************Setting Combo box************************
    @FXML
    private ComboBox<String> settingButtonBarComboBoxFXID;
    @FXML
    private ComboBox<String> settingDefaultLangComboBoxFXID;
    
    
    //*****************final and Setting Text Area*************************
    @FXML
    private TextArea finalTextAreaFXID;
    @FXML
    private TextArea settingTextAreaFXID;
    
    
    //*****************Setting Label****************************
    @FXML
    private Label settingHelpLabelFXID;
    @FXML
    private Label settingAboutLabelFXID;
    @FXML 
    private Label settingCheckForUpdatesLabelFXID;
    
    
    //****************Setting Buttons****************************
    @FXML
    private Button settingCloseeButtonFXID;
    @FXML
    private Button settingCancelButtonFXID;
    @FXML
    private Button settingOkButtonFXID;
    
    //****************Setting Check Box****************************
    @FXML
    private CheckBox settingParanthesisCheckBoxFXID;
    @FXML
    private CheckBox settingComentClouseCheckBoxFXID;
    @FXML
    private CheckBox settingDoubleQuateCheckBoxFXID;
    @FXML
    private CheckBox settingBracketsCheckBoxFXID;
    @FXML
    private CheckBox settingBrasesCheckBoxFXID;
    @FXML
    private CheckBox settingHeaderClouseCheckBoxFXID;
    @FXML
    private CheckBox settingSingleQuateCheckBoxFXID;
    
    
    
    @FXML
    public void parenthesisAction(ActionEvent event){
        String settingBuffer = settingTextAreaFXID.getText();
        if (settingParanthesisCheckBoxFXID.isSelected()) {
            
            settingBuffer += "("+ " " +")";
            settingTextAreaFXID.setText(settingBuffer);
            
        } else {
            settingBuffer = "";
            settingTextAreaFXID.setText(settingBuffer);
        }
    }
    
    @FXML
    public void settingCloseButtonAction(ActionEvent event){
        ((Stage)settingCloseeButtonFXID.getScene().getWindow()).close();
//        settingAnchorPaneFXID.close
    }
    
    
    @FXML 
    public void settingHelpAboutCheckForUpdateLabelOnMouseEntered(MouseEvent event){
        //isHovar() default value is false
       
        if(settingHelpLabelFXID.isHover()){
            settingHelpLabelFXID.setUnderline(true);
            settingAboutLabelFXID.setUnderline(false);
            settingCheckForUpdatesLabelFXID.setUnderline(false);
        }
        else if(settingAboutLabelFXID.isHover()){
            settingHelpLabelFXID.setUnderline(false);
            settingAboutLabelFXID.setUnderline(true);
            settingCheckForUpdatesLabelFXID.setUnderline(false);
        }
        else if(settingCheckForUpdatesLabelFXID.isHover()){
            settingHelpLabelFXID.setUnderline(false);
            settingAboutLabelFXID.setUnderline(false);
            settingCheckForUpdatesLabelFXID.setUnderline(true);
        }
        else{
            settingHelpLabelFXID.setUnderline(false);
            settingAboutLabelFXID.setUnderline(false);
            settingCheckForUpdatesLabelFXID.setUnderline(false);
        }
        
    }
    
    
    
    @FXML
    public void settingOkButtonAction(ActionEvent event){
//        settingTextColorChooserFXID.get
//        
//        String buffer = settingTextAreaFXID.getText();
//        
//        finalTextAreaFXID.setText(finalTextAreaFXID.getText()+ buffer);
        
        ((Stage)settingOkButtonFXID.getScene().getWindow()).close();
         
    }
    
    @FXML
    public void settingCancelButtonAction(ActionEvent event){
        ((Stage)settingCancelButtonFXID.getScene().getWindow()).close();
//        settingCancelButtonFXID.getStylesheets().add(getClass().getResource("settingstyles.css").toExternalForm());
//        settingCancelButtonFXID.cancelButtonProperty();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ObservableList<String> buttonBarList = 
            FXCollections.observableArrayList("Verticle","Horizontal");
        
        
        settingButtonBarComboBoxFXID.setPromptText("Default");
        settingButtonBarComboBoxFXID.setEditable(false);
        settingButtonBarComboBoxFXID.getItems().addAll(buttonBarList);
        
        ObservableList<String> defaultLanguageList = 
            FXCollections.observableArrayList("Default","Ada","Basic","C","Cobol","CSS","Html","Java","Javascript","Pascal","Tan10","Udi","Xml");
        
        settingDefaultLangComboBoxFXID.setPromptText("Default");
        settingDefaultLangComboBoxFXID.setEditable(false);
        settingDefaultLangComboBoxFXID.getItems().addAll(defaultLanguageList);
    }    
    
}
