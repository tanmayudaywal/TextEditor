/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.editor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Tanmay
 */
public class TextEditor extends Application   {
   
    private double x0ffset = 0;
    private double y0ffset = 0;
    @Override
    public void start(Stage stage) throws Exception,ArrayIndexOutOfBoundsException,IOException,RuntimeException {
       
        
        //this code for jfxsa-run stop when close software
        stage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
            System.exit(0);
        });
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
            Scene scene = new Scene(root);
    //        Image image = new Image("batman.png");  //pass in the image path
//            scene.setCursor(new ImageCursor(image));
            stage.getIcons().add(new Image("/iimg/tan_file.png"));
            stage.setTitle("Note10");
            stage.setScene(scene);
            stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("ctrl+w"));
            stage.setResizable(true);                                               //stage.initStyle(StageStyle.UNDECORATED);//hidden minimize maximize
            stage.setMaximized(true);                                                                        //stage.setFullScreen(true);               //ful screen
            
            root.setOnMousePressed((event)-> {
                x0ffset = event.getSceneX();
                y0ffset = event.getSceneY();
            });
        
            root.setOnMouseDragged((event) -> {
                stage.setX(event.getScreenX() - x0ffset );
                stage.setY(event.getScreenY() - y0ffset);
            });
            
            
            stage.show();
        } catch (IOException e) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    /**
     * @param args the command line arguments
     * @author Tanmay
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
