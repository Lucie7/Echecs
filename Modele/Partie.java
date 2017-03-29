/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author testfatoslocal
 */
public class Partie extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        System.out.println("HELLO");
        System.out.println("BYE");
        
        Point p2 = new Point(2,2);
        Point p1 = new Point(1,2);
        
        Coup c1 = new Coup(p1,p2);
        
        Pion pi = new Pion(p1);
                
        Plateau pl = new Plateau();
        
        pl.initPlateau();
        
        pi.appliquerCoup(c1);
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
