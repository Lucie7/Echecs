/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Observable;

/**
 *
 * @author testfatoslocal
 */
public class Plateau /*extends Observable*/{
    
    private Piece[][] grille;
    
    public Plateau()
    {
        this.grille = new Piece[8][8];
    }
    
    public void initPlateau()
    {
        int i,j,k;
        
        Point posRoiJ1 = new Point(0, 4);
        Point posRoiJ2 = new Point(7, 4);
        Point posReineJ1 = new Point(0, 3);
        Point posReineJ2 = new Point(7, 3);
        Point[] posPionJ1 = new Point[8];
        Point[] posPionJ2 = new Point[8];
        
        Point posFirstCavJ1 = new Point(0, 1);
        Point posFirstCavJ2 = new Point(7, 1);
        Point posFirstFouJ1 = new Point(0, 2);
        Point posFirstFouJ2 = new Point(7, 2);
        Point posFirstTourJ1 = new Point(0, 0);
        Point posFirstTourJ2 = new Point(7, 0);
        
        Point posSecCavJ1 = new Point(0, 6);
        Point posSecCavJ2 = new Point(7, 6);
        Point posSecFouJ1 = new Point(0, 5);
        Point posSecFouJ2 = new Point(7, 5);
        Point posSecTourJ1 = new Point(0, 7);
        Point posSecTourJ2 = new Point(7, 7);
        
        Roi pieceRoiJ1 = new Roi(posRoiJ1, this, true, "file:images/roi_blanc.png");
        Roi pieceRoiJ2 = new Roi(posRoiJ2, this, false, "file:images/roi_noir.png");
        
        Reine pieceReineJ1 = new Reine(posReineJ1, this, true,"file:images/reine_blanc.png");
        Reine pieceReineJ2 = new Reine(posReineJ2, this, false,"file:images/reine_noir.png");
        
        
        Tour pieceFirstTourJ1 = new Tour(posFirstTourJ1, this, true,"file:images/tour_blanc.png");
        Tour pieceSecTourJ1 = new Tour(posSecTourJ1, this, true,"file:images/tour_blanc.png");
        Cavalier pieceFirstCavJ1 = new Cavalier(posFirstCavJ1, this, true,"file:images/cavalier_blanc.png");
        Cavalier pieceSecCavJ1 = new Cavalier(posSecCavJ1, this, true,"file:images/cavalier_blanc.png");
        Fou pieceFirstFouJ1 = new Fou(posFirstFouJ1, this, true,"file:images/fou_blanc.png");
        Fou pieceSecFouJ1 = new Fou(posSecFouJ1, this, true,"file:images/fou_blanc.png");
        
        Tour pieceFirstTourJ2 = new Tour(posFirstTourJ1, this, false,"file:images/tour_noir.png");
        Tour pieceSecTourJ2 = new Tour(posSecTourJ1, this, false,"file:images/tour_noir.png");
        Cavalier pieceFirstCavJ2 = new Cavalier(posFirstCavJ1, this, false,"file:images/cavalier_noir.png");
        Cavalier pieceSecCavJ2 = new Cavalier(posSecCavJ1, this, false,"file:images/cavalier_noir.png");
        Fou pieceFirstFouJ2 = new Fou(posFirstFouJ1, this, false,"file:images/fou_noir.png");
        Fou pieceSecFouJ2 = new Fou(posSecFouJ1, this, false,"file:images/fou_noir.png");
        
        Pion[] piecePionJ1 = new Pion[8];
        Pion[] piecePionJ2 = new Pion[8];
        
        for(i = 0; i < posPionJ1.length ; i++)
        {
            posPionJ1[i] = new Point(1, i);
        }
        
        for(i = 0; i < piecePionJ1.length ; i++)
        {
            piecePionJ1[i] = new Pion(posPionJ1[i], this, true,"file:images/pion_blanc.png");
        }
        
        for(j = 0; j < posPionJ2.length ; j++)
        {
            posPionJ2[j] = new Point(6, j);
        }
        
        for(j = 0; j < piecePionJ2.length ; j++)
        {
            piecePionJ2[j] = new Pion(posPionJ2[j], this, false,"file:images/pion_noir.png");
        }
        
        this.grille[posReineJ1.getY()][posReineJ1.getX()] = pieceReineJ1;
        this.grille[posReineJ2.getY()][posReineJ2.getX()] = pieceReineJ2;
        
        this.grille[posRoiJ1.getY()][posRoiJ1.getX()] = pieceRoiJ1;
        this.grille[posRoiJ2.getY()][posRoiJ2.getX()] = pieceRoiJ2;
        
        this.grille[posFirstTourJ1.getY()][posFirstTourJ1.getX()] = pieceFirstTourJ1;
        this.grille[posSecTourJ1.getY()][posSecTourJ1.getX()] = pieceSecTourJ1;
        this.grille[posFirstFouJ1.getY()][posFirstFouJ1.getX()] = pieceFirstFouJ1;
        this.grille[posSecFouJ1.getY()][posSecFouJ1.getX()] = pieceSecFouJ1;
        this.grille[posFirstCavJ1.getY()][posFirstCavJ1.getX()] = pieceFirstCavJ1;
        this.grille[posSecCavJ1.getY()][posSecCavJ1.getX()] = pieceSecCavJ1;
        
        this.grille[posFirstTourJ2.getY()][posFirstTourJ2.getX()] = pieceFirstTourJ2;
        this.grille[posSecTourJ2.getY()][posSecTourJ2.getX()] = pieceSecTourJ2;
        this.grille[posFirstFouJ2.getY()][posFirstFouJ2.getX()] = pieceFirstFouJ2;
        this.grille[posSecFouJ2.getY()][posSecFouJ2.getX()] = pieceSecFouJ2;
        this.grille[posFirstCavJ2.getY()][posFirstCavJ2.getX()] = pieceFirstCavJ2;
        this.grille[posSecCavJ2.getY()][posSecCavJ2.getX()] = pieceSecCavJ2;
        
        for(k = 0; k < this.grille.length ; k++)
        {
            this.grille[posPionJ1[k].getY()][posPionJ1[k].getX()] = piecePionJ1[k];
        }
        
        for(k = 0; k < this.grille.length ; k++)
        {
            this.grille[posPionJ2[k].getY()][posPionJ2[k].getX()] = piecePionJ2[k];
        }
        
        for( i = 2 ; i < 5 ; i++)
        {
            for( j = 0 ; j < this.grille.length ; j++)
            {
                this.grille[i][j] = null;
            }
        }
    }
    
    public boolean estLibre(Point p)
    {
        System.out.println("debut estLibre");
        boolean res = false;
        if(grille[p.getY()][p.getX()] == null)
        {
            System.out.println("if de estLibre");
            res = true;
        }
        else
        {
            System.out.println("case " + p.getY() +","+ (p.getX()) + " non libre");
        }
        
        return res;
    }
    
    public Plateau getPlateau()
    {
        return this;
    }
    
    public Piece[][] getGrillePlateau()
    {
        return this.grille;
    }


    public void setGrille(Piece pi, Point po) {
        this.grille[po.getY()][po.getX()] = pi;
    }
    
    public void AffichePlateau()
    {
        int i, j;
        
        for( i = 0 ; i < this.grille.length ; i++)
        {
            for( j = 0 ; j < this.grille.length ; j++)
            {
                if(this.grille[i][j] != null)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
    
    public void AfficheDetailPlateau()
    {
        int i, j;
        
        for( i = 0 ; i < this.grille.length ; i++)
        {
            for( j = 0 ; j < this.grille.length ; j++)
            {
                if(this.grille[i][j] != null)
                {
                    if(this.grille[i][j] instanceof Cavalier )
                    {
                        System.out.print("Ca\t");
                    }
                    else if(this.grille[i][j] instanceof Fou )
                    {
                        System.out.print("Fo\t");
                    }
                    else if(this.grille[i][j] instanceof Pion )
                    {
                        System.out.print("Pi\t");
                    }
                    else if(this.grille[i][j] instanceof Reine )
                    {
                        System.out.print("Re\t");
                    }
                    else if(this.grille[i][j] instanceof Roi )
                    {
                        System.out.print("Ro\t");
                    }
                    else if(this.grille[i][j] instanceof Tour )
                    {
                        System.out.print("To\t");
                    }
                    else
                    {
                        System.out.print("!\t");
                    }
                    
                }
                else
                {
                    System.out.print("-\t");
                }
            }
            System.out.println();
        }
    }
    
   /*
    public boolean estEnEchecRoi(boolean couleur) {
        boolean res = false;
        int i, j;
        Point positionRoi = null;
        
        //On créé un tableau qui va contenir des 0 et des 1
        //Il y aura un 1 si il y a une piece(qui n'est pas le roi) sur la case ou si une des pieces adverse peut se déplacer dessus
        int[][] tableau = new int[8][8];
        //On initialise le tableau:
        for(i=0; i<8; i++) {
            for(j=0; j<8; j++) {
                tableau[j][i] = 0;
            }
        }
        
        //On parcourt le plateau pour trouver le roi
        //Et on remplit notre tableau avec des 1 si il y a une piece ou si une piece peut se dépacer dessus
        for(i = 0; i<8; i++) {
            for(j=0; j<8; j++) {
                Point p = new Point(j, i);
                //Si il y a une piece sur la case
                if(!this.estLibre(p)) {
                    //Si la piece est un roi de la couleur qu'on cherche
                    if((this.grille[j][i] instanceof Roi) && (this.grille[j][i].couleur == couleur)) {
                        positionRoi = new Point(j,i);
                        //Si ce n'est pas le roi que l'on cherche alors on met un un dans le tableau
                    }
                    else {
                        tableau[j][i] = 1;
                        
                        //Si la piece est une piece adverse alors on met un 1 partout où elle peut se déplacer
                        if(this.grille[j][i].couleur != couleur) {
                            Point[] tabCoupPossible = this.grille[j][i].EnsembleCoup();
                        
                            int k = 0;
                            while(tabCoupPossible[k] != null) {
                                tableau[tabCoupPossible[k].getY()][tabCoupPossible[k].getX()] = 1;
                                k++;
                            }
                        }
                    }
                }
            }
        }
        
        //Maintenant, on a la position du roi et une grille rempli de 0 et de 1
        //Si le roi est sur un 1 alors il est en echec
        if(tableau[positionRoi.getY()][positionRoi.getX()] == 1){
            res = true;
            //this.grille[positionRoi.getY()][positionRoi.getX()].setEstEnEchec(true);
        }
        
        return res;
    }
    */
    

    
    /*public boolean estEnEchecRoi(boolean couleur) {
        
        boolean res = false;
        Point positionRoi = null;
        
         for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                Point p = new Point(j, i);
                
                if(!this.estLibre(p))
                {
                    if(this.grille[j][i] instanceof Roi && this.grille[j][i].couleur == couleur)
                    {
                        positionRoi = new Point(j, i);
                    }
                }
            }
         }
        
//On parcourt le plateau
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                Point ptemp = new Point(j,i);
                
                //On test si il y a quelque chose dans la case
                if(!this.estLibre(ptemp)) {
                    //Si la piece n'est pas de la même couleur que le roi alors on test si elle peut le manger
                    if(this.getGrillePlateau()[j][i].couleur != couleur) {
                        Coup c = new Coup(ptemp, positionRoi);
                        boolean coul = this.getGrillePlateau()[j][i].couleur;
                        //Si elle peut manger le roi alors le roi est en échec
                        if(this.getGrillePlateau()[j][i].estValideCoup(c, coul)) {
                            //this.estEnEchec = true;
                            res = true;
                        }
                    }
                }
            }
        }
        
        return res;
    }*/
    
    /*
    public boolean echecEtMat(boolean couleur) {
        boolean res = true;
        
        //On parcourt notre plateau
        for(int i = 0; i<8; i++) {
            for(int j=0; j<8; j++) {
                Point p = new Point(j, i);
                //Si il y a une piece sur la case
                if(!this.estLibre(p)) {
                    //si c'est une piece de ma couleur
                    if(this.grille[j][i].couleur == couleur) {
                        Point[] tabCoup = this.grille[j][i].EnsembleCoup();
                        //si il n'y a au moins un coup possible alors il n'y a pas echec et mat
                        if(tabCoup[0] != null) {
                            res = false;
                        }
                    }
                }
            }
        }
        return res;
    }
*/
    
}
