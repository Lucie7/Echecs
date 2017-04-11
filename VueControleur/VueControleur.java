/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VueControleur;

import Modele.Coup;
import Modele.JoueurHumain;
import Modele.Partie;
import Modele.Piece;
import Modele.Plateau;
import Modele.Point;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
//import sun.java2d.loops.FillSpans;
 
public class Vue extends Application
{
    //Text affichage;
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();
        Scene scene = new Scene(root,Color.BEIGE);
        GridPane gp = new GridPane();
        
        Plateau plat = new Plateau();
        
        plat.initPlateau();
        
        afficheVueGrille(gp, plat);
        
        root.getChildren().add(gp);
        //Scene scene = new Scene(root, 700, 500, Color.BEIGE);
        
        primaryStage.setTitle("Echecs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void afficheVueGrille(GridPane echiquier, Plateau pl)
    {
        int j;
        
        // gestion du placement (permet de palcer le champ Text affichage en haut, et GridPane gPane au centre)
        BorderPane border = new BorderPane();
        
        int column = 0;
        int row = 0;
        
        for(j = 0 ; j <64 ; j++)
        {
            Rectangle rec = new Rectangle(60,60);
                       
            if(((column+row) % 2) == 0)
            {
                rec.setFill(Color.LIGHTGREY);
            }
            else
            {
                rec.setFill(Color.DARKRED);
            }
            
            StackPane stackP = new StackPane();
            if(pl.getGrillePlateau()[row][column] instanceof Piece)
            {
                ImageView imView = new ImageView(pl.getGrillePlateau()[row][column].getUrlImage());
                stackP.getChildren().addAll(rec,imView);
            }
            
            echiquier.add(rec, column, row);
            echiquier.add(stackP, column, row);
            
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
       
        for(Node n : echiquier.getChildren())
        {
            n.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent event)
                {
                    if(n.getBoundsInParent().contains(event.getSceneX(),event.getSceneY()))
                    {
                        int ligneDepart = GridPane.getRowIndex(n);
                        int colonneDepart = GridPane.getColumnIndex(n);
                        
                        if(!pl.estLibre(new Point(ligneDepart, colonneDepart)))
                        {
                            n.setStyle("-fx-border-color: #FF0000");
                            
                            for(Node n2 : echiquier.getChildren())
                            {
                                n2.setOnMouseClicked(new EventHandler<MouseEvent>()
                                {
                                    public void handle(MouseEvent event2)
                                    {
                                        if(n2.getBoundsInParent().contains(event2.getSceneX(),event2.getSceneY()))
                                        {
                                            int ligneDest = GridPane.getRowIndex(n2);
                                            int colonneDest = GridPane.getColumnIndex(n2);
                                            
                                            Point dep = new Point(ligneDepart, colonneDepart);
                                            Point dest = new Point(ligneDest, colonneDest);
                                            Coup c = new Coup(dep, dest);
                                            pl.AfficheDetailPlateau();
                                            pl.getGrillePlateau()[ligneDepart][colonneDepart].appliquerCoup(c,pl.getGrillePlateau()[ligneDepart][colonneDepart].getPieceCouleur());
                                            pl.AfficheDetailPlateau();
                                            afficheVueGrille(echiquier, pl);
                                        }
                                    }
                                });
                            }
                        } 
                    }
                }
            });
        }
    
        //border.setTop(echiquier);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        Application.launch(Vue.class,args);
    }
}