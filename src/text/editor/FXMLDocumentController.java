/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.editor;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author Tanmay
 */

public class FXMLDocumentController implements Initializable {
    /*******************Integer*************************************/
    private static int flineNo = 1;
    private final int defaultTextSize = 12;
    private static int carretposition;
    
    /*********************Strings*********************************************/
    
    private final String newLine = "\n";
    private final String emptyString = "";
    private final String fontFamily = "System";
    private final String _8tab =  "\t\t\t\t\t\t\t\t";
    private final String errorMsg = "Failed to create new Window.";
    private final String dateFormate ="dd/MM/yyyy";
    private final String timeFormate = "hh : mm : ss aa";
    
    
    private final String editorFXML = "";
    private final String calculatorFXML = "FXMLCalculator.fxml";
    private final String helpFXML = "FXMLHelp.fxml";
    private final String settingFXML = "FXMLSetting.fxml";
    
   
   /****************Pane Declaration**************************/
    @FXML
    private VBox rootVBoxFXID;
    @FXML
    private VBox finalTextAreaContainerVBoxFXID;
    
    @FXML
    private HBox finalRootTextAreaContainerHBoxFXID;
    
    /****************Text Area Declaration**************************/
    @FXML
    private TextArea finalTextAreaFXID;
    
    /****************Text Field Declaration**************************/
    @FXML
    private TextField finalTimeTfFXID;
    
    @FXML
    private TextField finalDateTfFXID;
         
    @FXML
    private TextField finalLengthTfFXID;
    
    @FXML
    private TextField finalRowTfFXID;
    
    @FXML
    private TextField finalStatusTfFXID;
    
    /****************Label Declaration**************************/
    @FXML
    private Label finallabelFXID;
    @FXML
    private TextArea finalLineNumberTextAreaFXID;                             ////////chorr
    
    /****************Combo Box Declaration**************************/
    @FXML
    private ComboBox<String> finalFontsComboBoxFXID;
    
    @FXML
    private ComboBox<String> finalTextSizeComboBoxFXID;
    
    @FXML 
    private ComboBox<String> finalColorChooserComboBoxFXID;
    
    /****************Check Box Declaration**************************/
    @FXML
    private CheckBox finalWrapTextCheckBoxFXID;
    
    @FXML
    private CheckBox finalBoldCbFXID;
    
    @FXML
    private CheckBox finalItalicCbFXID;
    
    /****************Button Declaration**************************/
    @FXML
    private Button finalDateBtFXID;
    @FXML
    private Button finalTimeBtFXID;
    
    @FXML
    private Button finalDarkModeBtFXID;
    
    @FXML
    private Button finalLightModeBtFXID;
    
    @FXML
    private Button finalEncrptBtFXID;
    
    @FXML
    private Button finalSettingBtFXID;
     
    @FXML
    private Button finalGotoBtFXID;
    
    @FXML
    private Button finalCalcButtonFXID;
    
    @FXML
    private ColorPicker finalColorFXID;
    @FXML
    private Button finalClearBtFXID;
    @FXML
    private Button finalNewTabBtFXID1;
    @FXML
    private Button finalOpenBtFXID;
    @FXML
    private Button finalSavebtFXID;
    @FXML
    private Button finalCutBtFXID;
    @FXML
    private Button finalCopyBtFXID;
    @FXML
    private Button finalPasteBtFXID;
    @FXML
    private Button finalTabBtFXID;
    @FXML 
    private Button finalDeleteAllTabButtonFXID1;
    
    @FXML
    private Tab finaltab;
    @FXML 
    private TabPane finaltabpane;
    
     
    /****************Declaration End**************************/
    
    /****************Method Start************************************
     * @param event @author Tanmay
     ************************************************************************/
    //code for Clear file and set status and label default
    //this part can be modified
    
    @FXML
    public void handleClearButtonAction(ActionEvent event){
        System.out.println("You clicked Clear Button!");
        finalTextAreaFXID.clear();
        finallabelFXID.setText("New File");
        finalStatusTfFXID.setText("Status");
        finalLengthTfFXID.setText("0");
        finalRowTfFXID.setText("1"); 
        finalLineNumberTextAreaFXID.setText(emptyString);
        finalLineNumberTextAreaFXID.setDisable(true);
        flineNo=1;
        
    }
    
    int tab_number=1;
    
    
    int ac = 0;//it can be use boolean 
    @FXML
    public void handleNewTabButtonAction(ActionEvent event) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.NullPointerException{
         System.out.println("You clicked New Button!");
//         if(ac==1){
//                finalTextAreaContainerVBoxFXID.getChildren().clear();
//                finaltabpane = new TabPane();
//                finalTextAreaContainerVBoxFXID.getChildren().add(finaltabpane);
//                finaltabpane.setMaxWidth(1196);
//                finaltabpane.setMaxHeight(611);
//         }
//
//        finaltabpane.getSelectionModel().select(tab_number);
        
        //back to the tabbed pane
        finalRootTextAreaContainerHBoxFXID.getChildren().clear();
        finalRootTextAreaContainerHBoxFXID.getChildren().add(finalTextAreaContainerVBoxFXID);
        
        
        finaltab = new Tab("New File " + tab_number++);
        finalTextAreaFXID = new TextArea();
        finaltab.setContent(finalTextAreaFXID);
        finaltabpane.getTabs().add(0, finaltab);
         
    }
    
    @FXML
    public void handleDeleteAllTabButtonAction(ActionEvent event) throws java.lang.ArrayIndexOutOfBoundsException{
         System.out.println("You clicked delete button Button!");
         finaltabpane.getTabs().clear();
         tab_number = 1;
             ac=1;
//            for (int i = 0; i <600; i+=2)
//            {
//                Line line1 = new Line(i, 0, i, 600);
//                line1.setStroke(Color.BLACK);
//                Line line2 = new Line(0, i, 600, i);
//                line2.setStroke(Color.BLACK);
//                finalTextAreaContainerVBoxFXID.getChildren().addAll(line1, line2);
//            }
        
        //clear tabbed pane and set what u want here
        //you can you use any nodes, controls, graph etc code your own
        finalRootTextAreaContainerHBoxFXID.getChildren().clear();
        Rectangle rectangle = new Rectangle(1400, 630, Color.CORNFLOWERBLUE);//(width, height, color) chnage width, height
        rectangle.setStrokeDashOffset(12);      
        rectangle.setStrokeLineCap(StrokeLineCap.ROUND);
        rectangle.setStrokeType(StrokeType.CENTERED);
        finalRootTextAreaContainerHBoxFXID.getChildren().add(rectangle);
         
    }
    
    
    
    //code for Open file and set path as status
    //now this part is completed

    /**
     *
     * @param event
     */
    @FXML
    public void handleOpenButtonMouseClick(MouseEvent event) throws RuntimeException, NullPointerException{
        System.out.println("You clicked Open Button!");
              
        FileChooser fileChooser = new FileChooser();
        
        /************************ File Extension **********************************/
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("All Files", "*.*"),
            new FileChooser.ExtensionFilter("Text", "*.txt"),
            new FileChooser.ExtensionFilter("Xml", "*.xml"),
            new FileChooser.ExtensionFilter("Html", "*.html"),
            new FileChooser.ExtensionFilter("C", "*.c"),
            new FileChooser.ExtensionFilter("Java", "*.java")
        );
        /**************************************************************************/
        
        Path file = Paths.get(fileChooser.showOpenDialog(new Stage()).getAbsolutePath());
        
        //Path generate RunTimeException if Open FileChooser and without file choose Cancel it.
        
        fileChooser.setTitle("Open a File");
        
        
        try {
            
            try (Scanner fin = new Scanner(file)) {
                String buffer = emptyString;
                while (fin.hasNext()) {
                    buffer += fin.nextLine() + newLine;
                } 
                finalTextAreaFXID.setText(buffer);
                
                finalStatusTfFXID.setText(emptyString + file);
                finallabelFXID.setText(emptyString + file.getFileName());
                finaltab.setText(emptyString + file.getFileName());
            }
            
        } 
        catch (IOException e) {
            Logger.getLogger(TextEditor.
            class.getName()).
            log(Level.SEVERE, null, e);
        }  
        
        if (finalStatusTfFXID.getText().isEmpty()) {
           finalGotoBtFXID.setDisable(true);
        } else {
            finalGotoBtFXID.setDisable(false);
        }
        /****************Length*********************************/
        currentLengthOfText();
    }
    
    //code for Save file and set path as status
    //now this part is completed
    @FXML
    public void handleSaveButtonAction(ActionEvent event) {
        System.out.println("You clicked Save Button!");
        FileChooser fileChooser = new FileChooser();
        
        /************************ File Extension **********************************/
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("All Files", "*.*"),
            new FileChooser.ExtensionFilter("Text", "*.txt"),
            new FileChooser.ExtensionFilter("Xml", "*.xml"),
            new FileChooser.ExtensionFilter("Html", "*.html"),
            new FileChooser.ExtensionFilter("C", "*.c"),
            new FileChooser.ExtensionFilter("Java", "*.java")
        );
        /**************************************************************************/
        
        String file = fileChooser.showSaveDialog(new Stage()).getAbsolutePath();
//        String fileName = fileChooser.getInitialFileName();
        fileChooser.setTitle("Save a File");
//        fileChooser.setInitialFileName(finalDateTfFXID.getText()+ emptyString +finalTimeTfFXID.getText());
        try {
            try (PrintWriter fout = new PrintWriter(file)) {
                fout.print(finalTextAreaFXID.getText());
            }
            finalStatusTfFXID.setText(emptyString + file);
            finallabelFXID.setText(emptyString + file);
            finaltab.setText(emptyString +file); 
              
            
        } catch (FileNotFoundException e) {
            Logger.getLogger(TextEditor.
            class.getName()).
            log(Level.SEVERE, null, e);
        }
        if (finalStatusTfFXID.getText().isEmpty()) {
           finalGotoBtFXID.setDisable(true);
        } else {
            finalGotoBtFXID.setDisable(false);
        }
    }
    
    //waiting for writing code
    @FXML
    public void handleCutButtonAction(ActionEvent event) throws RuntimeException{
        System.out.println("You clicked Cut Button!");
        finalTextAreaFXID.cut();
    }
    
    //waiting for writing code
    @FXML
    public void handleCopyButtonAction(ActionEvent event) throws RuntimeException{
        System.out.println("You clicked Copy Button!");
        finalTextAreaFXID.copy();
    }
    
    //Text Paste Code
    @FXML
    public void handlePasteButtonAction(ActionEvent event) throws RuntimeException{
        System.out.println("You clicked Paste Button!");
        finalTextAreaFXID.paste();
    }
    
    //Extra Tab Code
    @FXML
    public void handleTabButtonMouseClicked(MouseEvent event) throws RuntimeException{
        System.out.println("You clicked Tab Button!");
        String buffer =finalTextAreaFXID.getText();
        buffer += _8tab;
        finalTextAreaFXID.setText(buffer);
        /****************Length*********************************/
        currentLengthOfText();
//        finalTextAreaFXID;
                
           
    }
    
    //System Date pick by user Code
    @FXML
    public void handleDateButtonAction(ActionEvent event) throws java.util.ConcurrentModificationException{
        System.out.println("You clicked Date Button!");
        String buffer = finalTextAreaFXID.getText();
        String blankText = emptyString;
        if (!buffer.equals(blankText)) {
            buffer =  buffer+ newLine +finalDateTfFXID.getText();
            finalTextAreaFXID.setText(buffer);
        } else {
            buffer += finalDateTfFXID.getText();
            finalTextAreaFXID.setText(buffer);
        }
        /****************Length*********************************/
        currentLengthOfText();
        /***************Row setting, it can be delete******************/
        String rowString = finalRowTfFXID.getText();
        int lineNo = Integer.valueOf(rowString);
            lineNo += 1;
            String buffer1 = newLine + lineNo  ;
            finalRowTfFXID.setText(buffer1);
        
    }
 
    //System Time pick by user Code
    @FXML
    public void handleTimeButtonAction(ActionEvent event) throws java.util.ConcurrentModificationException{
        System.out.println("You clicked Time Button!");
        String buffer =finalTextAreaFXID.getText();
        String blankText = emptyString;                      //finalRowTfFXID.getText()  use insteed of emptyString
        if(!buffer.equals(blankText)){
            buffer +=   newLine +finalTimeTfFXID.getText();
            finalTextAreaFXID.setText(buffer);
        }
        else{
            buffer += finalTimeTfFXID.getText();
            finalTextAreaFXID.setText(buffer);
        }
        /****************Length*********************************/
        currentLengthOfText();
        /***************Row setting, it can be delete******************/
        String rowString = finalRowTfFXID.getText();
        int lineNo = Integer.valueOf(rowString);
            lineNo += 1;
            String buffer1 = newLine + lineNo  ;
            finalRowTfFXID.setText(buffer1);
        
    }
    
    //when Dark Mode enable then DarkMode Button disable
    @FXML
    public void handleDarkModeButtonAction(ActionEvent event) throws RuntimeException{
        System.out.println("You clicked Dark Mode Button!");
            rootVBoxFXID.setBlendMode(BlendMode.EXCLUSION);
            finalDarkModeBtFXID.setBlendMode(BlendMode.SRC_OVER);
            finalTextSizeComboBoxFXID.setBlendMode(BlendMode.GREEN);
            
                        
            finalDarkModeBtFXID.setDisable(true);
            finalLightModeBtFXID.setDisable(false);
        
    }
    
    //when Light Mode enable then LightMode Button disable
    @FXML
    public void handleLightModeButtonAction(ActionEvent event) throws RuntimeException{
        System.out.println("You clicked Light Mode Button!");
            rootVBoxFXID.setBlendMode(BlendMode.SRC_OVER);
            finalLightModeBtFXID.setBlendMode(BlendMode.SRC_OVER);
            finalTextSizeComboBoxFXID.setBlendMode(BlendMode.SRC_OVER);
            
           
            finalDarkModeBtFXID.setDisable(false);
            finalLightModeBtFXID.setDisable(true);
       
    }
    
    
    public void handleEncryptButtonAction(ActionEvent event) throws Exception{
        StringBuffer beforeEncrypt = new StringBuffer(finalTextAreaFXID.getText());
        StringBuffer afterEncrypt = beforeEncrypt.reverse();
//        finalTextAreaFXID.setText();
    }
    
    public Color forgroundColor(Color c){    
      return c;
    }
    
    
    @FXML
    public void handleFontsComboBoxAction(ActionEvent event) throws RuntimeException{
        switch(finalFontsComboBoxFXID.getValue()){
            case "Aparajita":
                finalTextAreaFXID.setFont(Font.font("Aparajita" ,Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Arial":
                finalTextAreaFXID.setFont(Font.font("Arial",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Arial Black":
                finalTextAreaFXID.setFont(Font.font("Arial Black",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Arial Narrow":
                finalTextAreaFXID.setFont(Font.font("Arial Narrow",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Book Antiqua":
                finalTextAreaFXID.setFont(Font.font("Book Antiqua",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Bookman Old Style":
                finalTextAreaFXID.setFont(Font.font("Bookman Old Style",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Bookshelf Symbol 7":
                finalTextAreaFXID.setFont(Font.font("Bookshelf Symbol 7",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Calibri":
                finalTextAreaFXID.setFont(Font.font("Calibri",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Calibri Light":
                finalTextAreaFXID.setFont(Font.font("Calibri Light",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Cambria":
                finalTextAreaFXID.setFont(Font.font("Cambria",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Cambria Math":
                finalTextAreaFXID.setFont(Font.font("Cambria Math",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Candara":
                finalTextAreaFXID.setFont(Font.font("Candara",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Candara Light":
                finalTextAreaFXID.setFont(Font.font("Candara Light",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Century":
                finalTextAreaFXID.setFont(Font.font("Century",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
            case "Comic Sans MS":
                finalTextAreaFXID.setFont(Font.font("Comic Sans MS",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
                //this is not end yet, more font to apply case and continue
            default:
                finalTextAreaFXID.setFont(Font.font("Syatem",Double.valueOf(finalTextSizeComboBoxFXID.getValue())));
                break;
                
        }
        
    }
    
    
    public void handleTextColorComboBoxAction(ActionEvent event) throws RuntimeException{
        if (null != finalColorChooserComboBoxFXID.getValue()) {
            switch(finalColorChooserComboBoxFXID.getValue()){
                case "ALICEBLUE":
//                    Color color = Color.ALICEBLUE;
//                    String s = finalTextAreaFXID.getText();
//                    s
                    break;
                case "ANTIQUEWHITE":
                    break;
                case "AQUA":
                    break;
                case "AQUAMARINE":
                    break;
                case "AZURE":
                    break;
                case "BEIGE":
                    break;
                case "BISQUE":
                    break;
                case "BLACK":
                    break;
                case "BLANCHEDALMOND":
                    break;
                case "BLUE":
                    break;
                case "BLUEVIOLET":
                    break;
                case "BROWN":
                    break;
                case "BURLYWOOD":
                    break;
                case "CADETBLUE":
                    break;
                case "CHARTREUSE":
                    break;
                case "CHOCOLATE":
                    break;
                case "CORAL":
                    break;
                case "CORNFLOWERBLUE":
                    break;
                case "CORNSILK":
                    break;
                case "CRIMSON":
                    break;
                case "CYAN":
                    break;
                case "DARKBLUE":
                    break;
                case "DARKCYAN":
                    break;
                case "DARKGOLDENROD":
                    break;
                case "DARKGRAY":
                    break;
                case "DARKGREEN":
                    break;
                case "DARKKHAKI":
                    break;
                case "DARKMAGENTA":
                    break;
                case "DARKOLIVEGREEN":
                    break;
                case "DARKORANGE":
                    break;
                case "DARKORCHID":
                    break;
                case "DARKRED":
                    break;
                case "DARKSALMON":
                    break;
                case "DARKSEAGREEN":
                    break;
                case "DARKSLATEBLUE":
                    break;
                case "DARKSLATEGRAY":
                    break;
                case "DARKTURQUOISE":
                    break;
                case "DARKVIOLET":
                    break;
                case "DEEPPINK":
                    break;
                case "DEEPSKYBLUE":
                    break;
                case "DIMGRAY":
                    break;
                case "DODGERBLUE":
                    break;
                case "FIREBRICK":
                    break;
                case "FLORALWHITE":
                    break;
                case "FORESTGREEN":
                    break;
                case "FUCHSIA":
                    break;
                case "GAINSBORO":
                    break;
                case "GHOSTWHITE":
                    break;
                case "GOLD":
                    break;
                case "GRAY":
                    break;
                case "HONEYDEW":
                    break;
                case "HOTPINK":
                    break;
                case "INDIANRED":
                    break;
                case "INDIGO":
                    break;
                case "IVORY":
                    break;
                case "KHAKI":
                    break;
                case "LAVENDER":
                    break;
                case "LAVENDERBLUSH":
                    break;
                case "LAWNGREEN":
                    break;
                case "LEMONCHIFFON":
                    break;
                case "LIGHTBLUE":
                    break;
                case "LIGHTCORAL":
                    break;
                case "LIGHTCYAN":
                    break;
                case "LIGHTGOLDENRODYELLOW":
                    break;
                case "LIGHTGRAY":
                    break;
                case "LIGHTGREEN":
                    break;
                case "LIGHTPINK":
                    break;
                case "LIGHTSALMON":
                    break;
                case "LIGHTSEAGREEN":
                    break;
                case "LIGHTSKYBLUE":
                    break;
                case "LIGHTSLATEGRAY":
                    break;
                case "LIGHTSTEELBLUE":
                    break;
                case "LIGHTYELLOW":
                    break;
                case "LIME":
                    break;
                case "LIMEGREEN":
                    break;
                case "LINEN":
                    break;
                case "MAGENTA":
                    break;
                case "MAROON":
                    break;
                case "MEDIUMAQUAMARINE":
                    break;
                case "MEDIUMBLUE":
                    break;
                case "MEDIUMORCHID":
                    break;
                case "MEDIUMPURPLE":
                    break;
                case "MEDIUMSEAGREEN":
                    break;
                case "MEDIUMSLATEBLUE":
                    break;
                case "MEDIUMSPRINGGREEN":
                    break;
                case "MEDIUMTURQUOISE":
                    break;
                case "MEDIUMVIOLETRED":
                    break;
                case "MIDNIGHTBLUE":
                    break;
                case "MINTCREAM":
                    break;
                case "MISTYROSE":
                    break;
                case "MOCCASIN":
                    break;
                case "NAVAJOWHITE":
                    break;
                case "NAVY":
                    break;
                case "OLDLACE":
                    break;
                case "OLIVE":
                    break;
                case "OLIVEDRAB":
                    break;
                case "ORANGE":
                    break;
                case "ORANGERED":
                    break;
                case "ORCHID":
                    break;
                case "PALEGOLDENROD":
                    break;
                case "PALEGREEN":
                    break;
                case "PALETURQUOISE":
                    break;
                case "PALEVIOLETRED":
                    break;
                case "PAPAYAWHIP":
                    break;
                case "PEACHPUFF":
                    break;
                case "PERU":
                    break;
                case "PINK":
                    break;
                case "PLUM":
                    break;
                case "POWDERBLUE":
                    break;
                case "PURPLE":
                    break;
                case "RED":
                    break;
                case "ROSYBROWN":
                    break;
                case "ROYALBLUE":
                    break;
                case "SADDLEBROWN":
                    break;
                case "SALMON":
                    break;
                case "SANDYBROWN":
                    break;
                case "SEAGREEN":
                    break;
                case "SEASHELL":
                    break;
                case "SIENNA":
                    break;
                case "SILVER":
                    break;
                case "SKYBLUE":
                    break;
                case "SLATEBLUE":
                    break;
                case "SLATEGRAY":
                    break;
                case "SNOW":
                    break;
                case "SPRINGGREEN":
                    break;
                case "STEELBLUE":
                    break;
                case "TANMAY":
                    break;
                case "TEAL":
                    break;
                case "THISTLE":
                    break;
                case "TOMATO":
                    break;
                case "TRANSPARENT":
                    break;
                case "TURQUOISE":
                    break;
                case "UDAIVAL":
                    break;
                case "VIOLET":
                    break;
                case "WHEAT":
                    break;
                case "WHITE":
                    break;
                case "WHITESMOKE":
                    break;
                case "YELLOW":
                    break;
                case "YELLOWGREEN":
                    break;
             
            }
        } else {
        }
    }
    
    //they're only for #helpStageShow
    private double x0ffset = 0;
    private double y0ffset = 0;
    
    @FXML
    public void helpStageShow(ActionEvent event) throws RuntimeException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(helpFXML));
            Scene helpScene = new Scene(fxmlLoader.load(), 600, 400);
            Stage helpStage = new Stage();

            //with lamda exp
            helpStage.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                System.exit(0);
            });
            
            helpScene.setCursor(Cursor.HAND);
            helpStage.initStyle(StageStyle.UNDECORATED);
            helpStage.setScene(helpScene);
            
            helpScene.setOnMousePressed((eventl)-> {
                x0ffset = eventl.getSceneX();
                y0ffset = eventl.getSceneY();
            });
        
            helpScene.setOnMouseDragged((eventl) -> {
                helpStage.setX(eventl.getScreenX() - x0ffset );
                helpStage.setY(eventl.getScreenY() - y0ffset);
            });
            
            
            helpStage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, errorMsg, e);
        }
        
    }
    
    @FXML
    public void handleCalculator(ActionEvent event) throws Exception{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(calculatorFXML));
            Scene calculatorScene = new Scene(fxmlLoader.load(), 420, 390);
            Stage calculatorStage = new Stage();

            //with lamda exp
            calculatorStage.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                System.exit(0);
            });
            
            calculatorScene.setCursor(Cursor.HAND);
            calculatorStage.initStyle(StageStyle.UNDECORATED);
            calculatorStage.setScene(calculatorScene);
            calculatorStage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, errorMsg, e);
        }
        
    }
    
    /*setting dialog open, now setting disable goto the 
    * public void initialize(URL url, ResourceBundle rb)  
    * and enable it,set value false
    */
    @FXML
    public void handleSettingButtonAction(ActionEvent event) throws RuntimeException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(settingFXML));
            /* 
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene settingScene = new Scene(fxmlLoader.load(), 600, 400);
            Stage settinStage = new Stage();

            //with lamda exp
            settinStage.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                System.exit(0);
            });
            /* without lamda exp
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
            });
            */
            settingScene.setCursor(Cursor.HAND);
            settinStage.initStyle(StageStyle.UNDECORATED);
            settinStage.setScene(settingScene);
            settinStage.show();
            
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, errorMsg, e);
        }
        
    }
    
    
    //waiting for writing code
    @FXML
    public void handleGotoButtonAction(ActionEvent event) throws RuntimeException, java.lang.reflect.InvocationTargetException {
        System.out.println("You clicked Goto Button");
        FileChooser fileChooser = new FileChooser(); 
        fileChooser.setTitle("GoTo");
        
        /************************ File Extension **********************************/
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("All Files", "*.*"),
            new FileChooser.ExtensionFilter("Text", "*.txt"),
            new FileChooser.ExtensionFilter("Xml", "*.xml"),
            new FileChooser.ExtensionFilter("Html", "*.html"),
            new FileChooser.ExtensionFilter("C", "*.c"),
            new FileChooser.ExtensionFilter("Java", "*.java")
        );
        /**************************************************************************/
        
        String file = fileChooser.showSaveDialog(new Stage()).getAbsolutePath();
        
//        fileChooser.setInitialDirectory(
//                new File(System.getProperty(finalStatusTfFXID.getText()))
//            );
        fileChooser.setInitialDirectory(new File(file, finalStatusTfFXID.getText()));
//        String s = finalStatusTfFXID.getText();
//        fileChooser.setInitialDirectory(new File(s));
        
        try {
            try (PrintWriter fout = new PrintWriter(file)) {
                fout.print(finalTextAreaFXID.getText());
            }
            finalStatusTfFXID.setText(emptyString + file);
            finallabelFXID.setText(emptyString + file);
        } catch (FileNotFoundException e) {
            Logger.getLogger(TextEditor.
            class.getName()).
            log(Level.SEVERE, null, e);
        }
      
    }
    
    @FXML
    public void handleWrapTextCheckBoxAction(ActionEvent event) throws RuntimeException{
        if (finalWrapTextCheckBoxFXID.isSelected()) {
            finalTextAreaFXID.setWrapText(true);
        } else {
            finalTextAreaFXID.setWrapText(false);
        }
    }
    
    //code for Check Box and set Bold or Italic or Both fonts and also text size 
    //now this part is completed
    @FXML
    public void handleCheckandComboBoxAction(ActionEvent event) throws RuntimeException{
        System.out.println("You clicked Bold Check Box");
        
        if (finalBoldCbFXID.isSelected() && finalItalicCbFXID.isSelected()) 
        {
            finalBoldCbFXID.setFont(javafx.scene.text.Font.font("System", FontWeight.BOLD, 12));//we can use "finalFontsComboBoxFXID.getValue()" instead of "fontFamily"
            finalItalicCbFXID.setFont(javafx.scene.text.Font.font("System", FontPosture.ITALIC, 12));

            if(null != finalTextSizeComboBoxFXID.getValue())
            {
                switch (finalTextSizeComboBoxFXID.getValue()) 
                {
                    case "10":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC , 10));
                        break;
                    case "12":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  12));
                        break;
                    case "14":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  14));
                        break;
                    case "16":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  16));
                        break;
                    case "18":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  18));
                        break;
                    case "20":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  20));
                        break;
                    case "22":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  22));
                        break;
                    case "24":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  24));
                        break;
                    case "26":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  26));
                        break;
                    case "28":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  28));
                        break;
                    case "30":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  30));
                        break;
                    case "32":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC ,  32));
                        break;
                    default:
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC , defaultTextSize));
                        break;
                }
            }else{
                
                finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,FontPosture.ITALIC , defaultTextSize));
            }   
        }
        
        else if(finalBoldCbFXID.isSelected())
        {
            finalBoldCbFXID.setFont(javafx.scene.text.Font.font("System", FontWeight.BOLD, 12));
            finalItalicCbFXID.setFont(javafx.scene.text.Font.font("System", FontWeight.NORMAL, 12));
            if(null != finalTextSizeComboBoxFXID.getValue())
            {
                switch (finalTextSizeComboBoxFXID.getValue()) 
                {
                    case "10":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, 10));
                        break;
                    case "12":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,  12));
                        break;
                    case "14":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, 14));
                        break;
                    case "16":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD,  16));
                        break;
                    case "18":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, 18));
                        break;
                    case "20":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, 20));
                        break;
                    case "22":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, 22));
                        break;
                    case "24":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, 24));
                        break;
                    case "26":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, 26));
                        break;
                    case "28":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, 28));
                        break;
                    case "30":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, 30));
                        break;
                    case "32":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, 32));
                        break;
                    default:
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, defaultTextSize));
                        break;
                }
            }
            else{
               finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontWeight.BOLD, defaultTextSize)); 
            }
        }
        else if (finalItalicCbFXID.isSelected()) 
        {
            finalBoldCbFXID.setFont(javafx.scene.text.Font.font("System", FontWeight.NORMAL, 12));
            finalItalicCbFXID.setFont(javafx.scene.text.Font.font("System", FontPosture.ITALIC, 12));

            if(null != finalTextSizeComboBoxFXID.getValue())
            {
                switch (finalTextSizeComboBoxFXID.getValue()) 
                {
                    case "10":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC , 10));
                        break;
                    case "12":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  12));
                        break;
                    case "14":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  14));
                        break;
                    case "16":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  16));
                        break;
                    case "18":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  18));
                        break;
                    case "20":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  20));
                        break;
                    case "22":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  22));
                        break;
                    case "24":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  24));
                        break;
                    case "26":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  26));
                        break;
                    case "28":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  28));
                        break;
                    case "30":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  30));
                        break;
                    case "32":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC ,  32));
                        break;
                    default:
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC, defaultTextSize));  
                        break;
                }
            }else{
                finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.ITALIC, defaultTextSize));  
            }
        }         
        
        else
        {
            finalBoldCbFXID.setFont(javafx.scene.text.Font.font("System", FontWeight.NORMAL, 12));
            finalItalicCbFXID.setFont(javafx.scene.text.Font.font("System", FontWeight.NORMAL, 12));

            if(null != finalTextSizeComboBoxFXID.getValue())
            {
                switch (finalTextSizeComboBoxFXID.getValue()) 
                {
                    case "10":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR , 10));
                        break;
                    case "12":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  12));
                        break;
                    case "14":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  14));
                        break;
                    case "16":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  16));
                        break;
                    case "18":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  18));
                        break;
                    case "20":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  20));
                        break;
                    case "22":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  22));
                        break;
                    case "24":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  24));
                        break;
                    case "26":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  26));
                        break;
                    case "28":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  28));
                        break;
                    case "30":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  30));
                        break;
                    case "32":
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR ,  32));
                        break;
                    default:
                        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR, defaultTextSize));  
                        break;
                }
            } 
            else{
                finalTextAreaFXID.setFont(javafx.scene.text.Font.font(finalFontsComboBoxFXID.getValue(), FontPosture.REGULAR, defaultTextSize));  
                
            }
        }
    }
     
    //current date on Text Field
    public void currentDateOnDateTextField() throws RuntimeException{
        Thread currentDateThread = new Thread(){
            @Override
            public void run(){
                for(;;){
                    DateFormat dateFormat = new SimpleDateFormat(dateFormate);
                    Date date = new Date();
                    finalDateTfFXID.setText(dateFormat.format(date));
                    
                    try {
                        sleep(1000);
                    } 
                    catch (InterruptedException ex) {
                         //...
                    }
                    
                }
            }
        };
        currentDateThread.start();
    }
    
    //current Time on Text Field
    public void liveTimeOnTimeTextField() throws RuntimeException{
        Thread liveclockThread = new Thread(){
            @Override
            public void run(){
                for (;;) {
                    DateFormat timeFormat = new SimpleDateFormat(timeFormate);
                    String dateString = timeFormat.format(new Date());
                    finalTimeTfFXID.setText(dateString);
 
                    try {
                        sleep(1000);
                    } 
                    catch (InterruptedException ex) {
                         //...
                    }
                }  
            }
        };
        liveclockThread.start();
    }
    
    public void handleColorChooserAction(ActionEvent event){
//        finalTextAreaFXID.forfinalColorChooserFXID.getValue();
//        Text textFill = new Text(finalTextAreaFXID.getText());
//        textFill.setFill(finalColorChooserFXID.getValue());
//          finalTextAreaFXID.
        
         
    }
    
    /*********This is only for use, you can delete it*****************************************/
    //finalLineNumberTfFXID
    //finalTextAreaFXID
    //finalRowTfFXID
    //finalLengthTfFXID
    /**
     * @param keyevent**************************************************************************************/
    
    
    
    @FXML
    public void handleTextAreaEvents(KeyEvent keyevent) throws RuntimeException, java.lang.ArrayIndexOutOfBoundsException{
        
        String rowString = finalRowTfFXID.getText();
        if (keyevent.getCode()== KeyCode.ENTER ) {
            int lineNo = Integer.valueOf(rowString);
            lineNo += 1;
            String buffer = newLine + lineNo  ;
            finalRowTfFXID.setText(buffer);
           
        } else if(keyevent.getCode() == KeyCode.BACK_SPACE){
            //not complete
            int no = Integer.valueOf(rowString);
            if(no > 1){
                no -= 1;
                String buffer2 = newLine + no  ;
                finalRowTfFXID.setText(buffer2);
            }
            else{
                finalRowTfFXID.setText("1"); 
            }
        } 
        
        if (keyevent.getCode()== KeyCode.ENTER) {
            String buffer = finalLineNumberTextAreaFXID.getText();
            buffer += flineNo++ + newLine ;
            finalLineNumberTextAreaFXID.setText(buffer);
        } else {
            //Todo
        }
        currentLengthOfText();
//        finalTextAreaFXID.setText(String.valueOf(finalTextAreaFXID.getOnDragDetected()));

        
    }
    
    //caller fuction to textArea
    public void currentLengthOfText() throws RuntimeException{
        finalLengthTfFXID.setText(String.valueOf(finalTextAreaFXID.getText().length()));
       
    }
    
    
    /***********Main Method of the controller class
     * @param url
     * @param rb**********/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) throws RuntimeException,ThreadDeath,
            IllegalThreadStateException, java.lang.ArrayIndexOutOfBoundsException {    
       
       /*************************Methods Calling****************write down********************/
        
       currentDateOnDateTextField();           //date method
       liveTimeOnTimeTextField();              //time method
        
       
       /****************************Default Value when code run********************************************/
       
       /****Check Box************Encrypt*******************************************************/
       
       
       finalBoldCbFXID.setFont(Font.font(fontFamily, FontWeight.NORMAL, 12));
       finalItalicCbFXID.setFont(Font.font(fontFamily, FontWeight.NORMAL, 12));
       
       /*****Label***************Line no*******************************************************/
       
       
        /****Vertical Box************Root******************************************************/
        rootVBoxFXID.setBlendMode(BlendMode.SRC_OVER);
        
        /*****Button**********************ToolTip Manage **************************************/
        finalLightModeBtFXID.setTooltip(new Tooltip("Set Screen to Light"));
        finalDarkModeBtFXID.setTooltip(new Tooltip("Set Screen to Dark"));
        
        /*****Button*********************Mode Manage **************************************/
        finalDarkModeBtFXID.setDisable(false);   //dark mode button not disable (but DarkMode Disable)
        finalLightModeBtFXID.setDisable(true);   //light mode button disable (but LightMode Enable)
        
        /*****Button**********************Setting Manage**************************************/
        finalSettingBtFXID.setDisable(false);         //setting Button disabled
        
        finalSettingBtFXID.setVisible(false);           //set visibility true
        finalSettingBtFXID.setPrefWidth(0);             //remove this line of code
        finalSettingBtFXID.setPrefHeight(0);            //remove this line of code 
        finalSettingBtFXID.setMinHeight(0);             //remove this line of code
        finalSettingBtFXID.setMinHeight(0);            //remove this line of code 
        //and goto the FXMLDocument.fxml and ID finalSettingBtFXID button set pref width and height to USE_COMPUTED_SIZE
       
        /*****Button*********************Calculator Manage **************************************/
        finalCalcButtonFXID.setVisible(false);          //set visibility true
        
        
       /******Button*********************GoTo Manage **************************************************/
        if (finalStatusTfFXID.getText().isEmpty()) {
           finalGotoBtFXID.setDisable(true);
        } else {
            finalGotoBtFXID.setDisable(false);
        }
        
        /*****Text Field**********************Time Manage**************************************/
        finalTimeTfFXID.setDisable(true);               //time text field disabled
        
        /*****Text Field**********************Length Manage**************************************/
        
        
                
        /*****Text Field*****************Row Manage*********************************************/
        finalRowTfFXID.setText(String.valueOf(1));
        
        
        /*****Text Area*********************Text Area Manage**************************************/
        finalTextAreaFXID.getCursor();
        finalTextAreaFXID.setWrapText(false);
        
        finalTextAreaFXID.requestFocus();       
        finalTextAreaFXID.autosize();
        finalTextAreaFXID.setFont(javafx.scene.text.Font.font(fontFamily, FontPosture.REGULAR, defaultTextSize));          //text area default font
        
        /*****Text Area*********************Line Number Manage**************************************/
        finalLineNumberTextAreaFXID.setVisible(true); //true to show line no.
           finalLineNumberTextAreaFXID.setDisable(true);
           finalLineNumberTextAreaFXID.setWrapText(true);
            
        /*****Combo Box*************************Size Manage**********************************************/
        
        finalColorChooserComboBoxFXID.setBlendMode(BlendMode.SRC_OVER);
        
        final Text coloredText = new Text(finalTextAreaFXID.getText());
        
        Color c = finalColorFXID.getValue();
        coloredText.setFill(c);
//        coloredButton.setStyle(createRGBString(c));
        ObservableList<String> textColorPickers = FXCollections.observableArrayList(
                "ALICEBLUE",
                "ANTIQUEWHITE",
                "AQUA",
                "AQUAMARINE",
                "AZURE",
                "BEIGE",
                "BISQUE",
                "BLACK",
                "BLANCHEDALMOND", 
                "BLUE", 
                "BLUEVIOLET",
                "BROWN", 
                "BURLYWOOD",
                "CADETBLUE",
                "CHARTREUSE",
                "CHOCOLATE",
                "CORAL",
                "CORNFLOWERBLUE",
                "CORNSILK",
                "CRIMSON",
                "CYAN",
                "DARKBLUE",
                "DARKCYAN",
                "DARKGOLDENROD",
                "DARKGRAY",
                "DARKGREEN",
                "DARKKHAKI",
                "DARKMAGENTA",
                "DARKOLIVEGREEN",
                "DARKORANGE",
                "DARKORCHID",
                "DARKRED",
                "DARKSALMON",
                "DARKSEAGREEN",
                "DARKSLATEBLUE",
                "DARKSLATEGRAY",
                "DARKTURQUOISE",
                "DARKVIOLET",
                "DEEPPINK",
                "DEEPSKYBLUE",
                "DIMGRAY",
                "DODGERBLUE",
                "FIREBRICK",
                "FLORALWHITE",
                "FORESTGREEN",
                "FUCHSIA",
                "GAINSBORO",
                "GHOSTWHITE",
                "GOLD",
                "GRAY",
                "HONEYDEW",
                "HOTPINK",
                "INDIANRED",
                "INDIGO",
                "IVORY",
                "KHAKI",
                "LAVENDER",
                "LAVENDERBLUSH",
                "LAWNGREEN",
                "LEMONCHIFFON",
                "LIGHTBLUE",
                "LIGHTCORAL",
                "LIGHTCYAN",
                "LIGHTGOLDENRODYELLOW",
                "LIGHTGRAY",
                "LIGHTGREEN",
                "LIGHTPINK",
                "LIGHTSALMON",
                "LIGHTSEAGREEN",
                "LIGHTSKYBLUE",
                "LIGHTSLATEGRAY",
                "LIGHTSTEELBLUE",
                "LIGHTYELLOW",
                "LIME",
                "LIMEGREEN",
                "LINEN",
                "MAGENTA",
                "MAROON",
                "MEDIUMAQUAMARINE",
                "MEDIUMBLUE",
                "MEDIUMORCHID",
                "MEDIUMPURPLE",
                "MEDIUMSEAGREEN",
                "MEDIUMSLATEBLUE",
                "MEDIUMSPRINGGREEN",
                "MEDIUMTURQUOISE",
                "MEDIUMVIOLETRED",
                "MIDNIGHTBLUE",
                "MINTCREAM",
                "MISTYROSE",
                "MOCCASIN",
                "NAVAJOWHITE",
                "NAVY",
                "OLDLACE",
                "OLIVE",
                "OLIVEDRAB",
                "ORANGE",
                "ORANGERED",
                "ORCHID",
                "PALEGOLDENROD",
                "PALEGREEN",
                "PALETURQUOISE",
                "PALEVIOLETRED",
                "PAPAYAWHIP",
                "PEACHPUFF",
                "PERU",
                "PINK",
                "PLUM",
                "POWDERBLUE",
                "PURPLE",
                "RED",
                "ROSYBROWN",
                "ROYALBLUE",
                "SADDLEBROWN",
                "SALMON",
                "SANDYBROWN",
                "SEAGREEN",
                "SEASHELL",
                "SIENNA",
                "SILVER",
                "SKYBLUE",
                "SLATEBLUE",
                "SLATEGRAY",
                "SNOW",
                "SPRINGGREEN",
                "STEELBLUE",
                "TANMAY",
                "TEAL",
                "THISTLE",
                "TOMATO",
                "TRANSPARENT",
                "TURQUOISE",
                "UDAIVAL",
                "VIOLET",
                "WHEAT",
                "WHITE",
                "WHITESMOKE",
                "YELLOW",
                "YELLOWGREEN"       
        );
        finalColorChooserComboBoxFXID.getItems().addAll(textColorPickers);
        finalColorChooserComboBoxFXID.setEditable(false);
        
        finalColorChooserComboBoxFXID.setVisible(false);        //set visibility true
        finalColorChooserComboBoxFXID.setDisable(true);         //set disable false
        finalColorChooserComboBoxFXID.setPrefWidth(0);          //remove this line of code
        finalColorChooserComboBoxFXID.setPrefHeight(0);         //remove this line of code
        finalColorChooserComboBoxFXID.setMinWidth(0);           //remove this line of code
        finalColorChooserComboBoxFXID.setMinHeight(0);          //remove this line of code
        //and goto the FXMLDocument.fxml and ID finalColorChooserComboBoxFXID set pref width and height to USE_COMPUTED_SIZE
       
        
        finalTextSizeComboBoxFXID.setBlendMode(BlendMode.SRC_OVER);       //Combo box default blend mode
        
        ObservableList<String> textFontsList = FXCollections.observableArrayList(Font.getFamilies()); ;
     
        finalFontsComboBoxFXID.getItems().addAll(textFontsList);
        finalFontsComboBoxFXID.setEditable(false);
        
        ObservableList<String> textSizeList = 
            FXCollections.observableArrayList(
        "10","12","14","16","18","20","22","24","26","28","30","32");
        finalTextSizeComboBoxFXID.setPromptText(String.valueOf(defaultTextSize));
        finalTextSizeComboBoxFXID.getItems().addAll(textSizeList);
        finalTextSizeComboBoxFXID.setEditable(false);
        Text t = new Text(finalTextAreaFXID.getText());
        t.setFill(Color.BLUE);
    }    
    
}
////