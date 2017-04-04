/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author testfatoslocal
 */
public class Modele extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        String[] args = new String[1];
        Partie.main(args);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
