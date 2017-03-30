/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VueControleur;

import Modele.Partie;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
 
public class Fenetre extends Application
{
    Rectangle caseCourante;
    
    class AffPlateau extends Rectangle
    {
        public AffPlateau(boolean light, int x, int y)
        {
            setWidth(Fenetre.taille);
            setHeight(Fenetre.taille);
            relocate(x * Fenetre.taille, y * Fenetre.taille);
            setFill(light ? Color.WHITE : Color.GREY);
    	}
    }
    
    public static int taille = 100;
    public static int x = /*Partie.plateauPartie.getLongueur()*/ 8;
    public static int y = /*Partie.plateauPartie.getLargeur()*/ 8;
    
    private AffPlateau[][] affichage = new AffPlateau[x][y];
    
    private Group caseGroup = new Group();
    private Group pieceGroup = new Group();
    
    private Parent createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(x * taille, y * taille);
        root.getChildren().addAll(caseGroup, pieceGroup);
        for (int y = 0; y < this.y; y++)
        {
            for (int x = 0; x <this.x; x++)
            {
                AffPlateau rect = new AffPlateau((x + y) % 2 == 0, x, y);
                affichage[x][y] = rect;
                caseGroup.getChildren().add(rect);
                rect.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent t)
                    {
                        rect.setFill(Color.RED);
                    }
                }
                );
            }
        }
        return root;
    }
    
    @Override
    public void start(Stage primaryStage)
    { 
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Echec");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}