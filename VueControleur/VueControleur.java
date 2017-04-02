/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VueControleur;

import Modele.Partie;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
 
public class VueControleur extends Application
{
    // modèle : ce qui réalise le calcule de l'expression
    //Modele m;
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();
        
        // gestion du placement (permet de palcer le champ Text affichage en haut, et GridPane gPane au centre)
        BorderPane border = new BorderPane();
        
        // permet de placer les diffrents boutons dans une grille
        GridPane echiquier = new GridPane();
        
        GridPane piecesMangeeJ1 = new GridPane();
        GridPane piecesMangeeJ2 = new GridPane();
                
        Text tableauBord = new Text("Ceci est le tableau de bord");
        tableauBord.setFont(Font.font(20));
        tableauBord.setFill(Color.BLUE);
        
        Text affichage = new Text("Ceci est une longue phrase servant a donner des information sur la partie en cours");
        affichage.setFont(Font.font(20));
        //affichage.setWrappingWidth(600);
        //affichage.setTextAlignment(TextAlignment.CENTER);
        //affichage.setLineSpacing(100);
        affichage.setFill(Color.ORCHID);

        int i,j;
        int column = 0;
        int row = 0;
        
        for( i = 0 ; i < 16 ; i++)
        {
            Rectangle r1 = new Rectangle(20,20);
            Rectangle r2 = new Rectangle(20,20);
            
            r1.setFill(Color.RED);
            r2.setFill(Color.GREEN);
            
            piecesMangeeJ1.add(r1, column, row);
            piecesMangeeJ2.add(r2, column, row);
            
            column++;
            
            if(column > 1)
            {
                column = 0;
                row++;
            }
        }
        column = 0;
        row = 0;   
        
        // on change l'affichage lors du clic
        affichage.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            
            @Override
            public void handle(MouseEvent event)
            {
                affichage.setText("Veuillez deplacer une piece");
            }
        });
        
       /*
        for (String s : new String[]{"To", "Ca", "Fo", "Re", "Ro", "Fo", "Ca", "To", "Pi", "Pi", "Pi", "Pi", "Pi", "Pi", "Pi", "Pi"})
        {
            final Text t = new Text(s);
            Rectangle rec = new Rectangle(200,200);
            t.setWrappingWidth(50);
            t.setFont(Font.font ("Verdana", 20));
            t.setTextAlignment(TextAlignment.CENTER);
            
            gPane.add(t, column++, row);
            
            if (column > 7) {
                column = 0;
                row++;
            }
            
            // un controleur (EventHandler) par bouton écoute et met à jour le champ affichage
            t.setOnMouseClicked(new EventHandler<MouseEvent>() {
                
                @Override
                public void handle(MouseEvent event) {
                    affichage.setText(affichage.getText() + t.getText());
                }
                
            });
            
        }*/
        
        for(j = 0 ; j <64 ; j++)
        {
            Rectangle rec = new Rectangle(70,70);
            
            if(((column+row) % 2) == 0)
            {
                rec.setFill(Color.WHITE);
                /*
                final String imageURI = new File("C:\\Users\\pac-_\\Documents\\LIF13\\pion.png").toURI().toString();
                Image monPion = new Image(imageURI);
                gPane.add(new ImageView(monPion), column, row);
                */
            }
            
            echiquier.add(rec, column, row);
            
            column++;
            
            if(column > 7)
            {
                column = 0;
                row++;
            }
        }
        
        column = 0;
        row = 0;
                
        echiquier.setGridLinesVisible(true);
        piecesMangeeJ1.setGridLinesVisible(true);
        piecesMangeeJ2.setGridLinesVisible(true);
        
        
        
        border.setTop(tableauBord);
        border.setLeft(piecesMangeeJ1);
        border.setCenter(echiquier);
        border.setRight(piecesMangeeJ2);
        border.setBottom(affichage);
        
        piecesMangeeJ1.setAlignment(Pos.CENTER);
        piecesMangeeJ2.setAlignment(Pos.CENTER);
        echiquier.setAlignment(Pos.CENTER);
        
        
        root.getChildren().add(border);
        
        Scene scene = new Scene(root,Color.BEIGE);
        
        primaryStage.setTitle("Echecs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}