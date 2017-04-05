/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VueControleur;

import Modele.Modele;
import Modele.Partie;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
 
public class Vue extends Application
{    
     public Text tableauBord = new Text("Ceci est le tableau de bord");
    
    @Override
    public void start(Stage primaryStage) {
        
        Image imPionBl = new Image("file:images/pion_blanc.png");
        Image imPionNo = new Image("file:images/pion_noir.png");
        Image imReineBl = new Image("file:images/reine_blanc.png");
        Image imReineNo = new Image("file:images/reine_noir.png");
        Image imRoiBl = new Image("file:images/roi_blanc.png");
        Image imRoiNo = new Image("file:images/roi_noir.png");
        Image imTourBl = new Image("file:images/tour_blanc.png");
        Image imTourNo = new Image("file:images/tour_noir.png");
        Image imFouBl = new Image("file:images/fou_blanc.png");
        Image imFouNo = new Image("file:images/fou_noir.png");
        Image imCavalierBl = new Image("file:images/cavalier_blanc.png");
        Image imCavalierNo = new Image("file:images/cavalier_noir.png");
        
        ImageView viewPremTourBl = new ImageView(imTourBl);
        ImageView viewSecTourBl = new ImageView(imTourBl);
        ImageView viewPremCavalierBl = new ImageView(imCavalierBl);
        ImageView viewSecCavalierBl = new ImageView(imCavalierBl);
        ImageView viewPremFouBl = new ImageView(imFouBl);
        ImageView viewSecFouBl = new ImageView(imFouBl);
        ImageView viewRoiBl = new ImageView(imRoiBl);
        ImageView viewReineBl = new ImageView(imReineBl);
        
        ImageView viewPremTourNo = new ImageView(imTourNo);
        ImageView viewSecTourNo = new ImageView(imTourNo);
        ImageView viewPremCavalierNo = new ImageView(imCavalierNo);
        ImageView viewSecCavalierNo = new ImageView(imCavalierNo);
        ImageView viewPremFouNo = new ImageView(imFouNo);
        ImageView viewSecFouNo = new ImageView(imFouNo);
        ImageView viewRoiNo = new ImageView(imRoiNo);
        ImageView viewReineNo = new ImageView(imReineNo);
        
        ImageView[] viewPionBl = new ImageView[8];
        ImageView[] viewPionNo = new ImageView[8];
        
        int i;
        
        for(i = 0 ; i < 8 ; i++)
        {
            viewPionBl[i] = new ImageView(imPionBl);
        }
        
        for(i = 0 ; i < 8 ; i++)
        {
            viewPionNo[i] = new ImageView(imPionNo);
        }
        
        Group root = new Group();
        
        // gestion du placement (permet de palcer le champ Text affichage en haut, et GridPane gPane au centre)
        BorderPane border = new BorderPane();
        
        // permet de placer les diffrents boutons dans une grille
        GridPane echiquier = new GridPane();
        
        VBox piecesMangeeJ1 = new VBox();
        VBox piecesMangeeJ2 = new VBox();
        
                        
       
        tableauBord.setFont(Font.font(20));
        tableauBord.setFill(Color.BLUE);
        
        Text affichage = new Text("Ceci est une longue phrase servant a donner des information sur la partie en cours");
        affichage.setFont(Font.font(20));
        //affichage.setWrappingWidth(600);
        //affichage.setTextAlignment(TextAlignment.CENTER);
        //affichage.setLineSpacing(100);
        affichage.setFill(Color.ORCHID);

        int j;
        int column = 0;
        int row = 0;
        
        /*
        for( i = 0 ; i < 16 ; i++)
        {
            Rectangle r1 = new Rectangle(20,20);
            Rectangle r2 = new Rectangle(20,20);
            
            r1.setFill(Color.RED);
            r2.setFill(Color.GREEN);
            
            //piecesMangeeJ1.add(r1, column, row);
            //piecesMangeeJ1.getChildren().add(r1);
            piecesMangeeJ2.add(r2, column, row);
            
            column++;
            
            if(column > 1)
            {
                column = 0;
                row++;
            }
        }
        */
        //column = 0;
        //row = 0;   
        
       /* // on change l'affichage lors du clic
        affichage.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            
            @Override
            public void handle(MouseEvent event)
            {
                affichage.setText("Veuillez deplacer une piece");
            }
        });
        */
        
        for(j = 0 ; j <64 ; j++)
        {
            Rectangle rec = new Rectangle(70,70);
            
            if(((column+row) % 2) == 0)
            {
                rec.setFill(Color.LIGHTGREY);
            }
            else
            {
                rec.setFill(Color.DARKRED);
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
        
        echiquier.add(viewPremTourBl, column++, row);
        echiquier.add(viewPremCavalierBl, column++, row);
        echiquier.add(viewPremFouBl, column++, row);
        echiquier.add(viewReineBl, column++, row);
        echiquier.add(viewRoiBl, column++, row);
        echiquier.add(viewSecFouBl, column++, row);
        echiquier.add(viewSecCavalierBl, column++, row);
        echiquier.add(viewSecTourBl, column++, row);
        
        
        column = 0;
        
        for(i = 0 ; i < 8; i++)
        {
            echiquier.add(viewPionBl[i],column++,row+1);
        }
        
        column = 0;
        row = 7;
        
        echiquier.add(viewPremTourNo, column++, row);
        echiquier.add(viewPremCavalierNo, column++, row);
        echiquier.add(viewPremFouNo, column++, row);
        echiquier.add(viewReineNo, column++, row);
        echiquier.add(viewRoiNo, column++, row);
        echiquier.add(viewSecFouNo, column++, row);
        echiquier.add(viewSecCavalierNo, column++, row);
        echiquier.add(viewSecTourNo, column++, row);
        
        column = 0;
        row = 6;
        
        for(i = 0 ; i < 8 ; i++)
        {
            echiquier.add(viewPionNo[i],column++,row);
        }
        //echiquier.add(viewFouBl, column, row);
        //echiquier.add(viewTourBl, column, row);
        
        GridPane.setHalignment(viewPremTourBl, HPos.CENTER);
        GridPane.setHalignment(viewSecTourBl, HPos.CENTER);
        
        GridPane.setHalignment(viewPremCavalierBl, HPos.CENTER);
        GridPane.setHalignment(viewSecCavalierBl, HPos.CENTER);
        
        GridPane.setHalignment(viewPremFouBl, HPos.CENTER);
        GridPane.setHalignment(viewSecFouBl, HPos.CENTER);
        
        GridPane.setHalignment(viewReineBl, HPos.CENTER);
        GridPane.setHalignment(viewRoiBl, HPos.CENTER);
        
        GridPane.setHalignment(viewPremTourNo, HPos.CENTER);
        GridPane.setHalignment(viewSecTourNo, HPos.CENTER);
        
        GridPane.setHalignment(viewPremCavalierNo, HPos.CENTER);
        GridPane.setHalignment(viewSecCavalierNo, HPos.CENTER);
        
        GridPane.setHalignment(viewPremFouNo, HPos.CENTER);
        GridPane.setHalignment(viewSecFouNo, HPos.CENTER);
        
        GridPane.setHalignment(viewReineNo, HPos.CENTER);
        GridPane.setHalignment(viewRoiNo, HPos.CENTER);
        
        for(i = 0 ; i < 8 ; i++)
        {
            GridPane.setHalignment(viewPionBl[i], HPos.CENTER);
        }
        
        for(i = 0 ; i < 8 ; i++)
        {
            GridPane.setHalignment(viewPionNo[i], HPos.CENTER);
        }
        
                
        echiquier.setGridLinesVisible(true);
        //piecesMangeeJ1.setGridLinesVisible(true);
        //piecesMangeeJ2.setGridLinesVisible(true);
        
        //piecesMangeeJ1.paddingProperty(new Insets(0,0,0,50));
        piecesMangeeJ1.setPadding(new Insets(0,20,0,30));
        piecesMangeeJ2.setPadding(new Insets(0,30,0,20));
        
        piecesMangeeJ1.getChildren().add(viewPremCavalierBl);
        piecesMangeeJ2.getChildren().add(viewPremCavalierNo);
        
        piecesMangeeJ1.getChildren().add(viewPremFouBl);
        piecesMangeeJ2.getChildren().add(viewPremFouNo);
        
        
        viewPremCavalierBl.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
                @Override
                public void handle(MouseEvent event)
                {
                   affichage.setText("clique sur cavalier");
                }
                
            });
                
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