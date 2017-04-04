/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author testfatoslocal
 */
public class Plateau {
    
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
        
        Roi pieceRoiJ1 = new Roi(posRoiJ1, this, true);
        Roi pieceRoiJ2 = new Roi(posRoiJ2, this, false);
        
        Reine pieceReineJ1 = new Reine(posReineJ1, this, true);
        Reine pieceReineJ2 = new Reine(posReineJ2, this, false);
        
        
        Tour pieceFirstTourJ1 = new Tour(posFirstTourJ1, this, true);
        Tour pieceSecTourJ1 = new Tour(posSecTourJ1, this, true);
        Cavalier pieceFirstCavJ1 = new Cavalier(posFirstCavJ1, this, true);
        Cavalier pieceSecCavJ1 = new Cavalier(posSecCavJ1, this, true);
        Fou pieceFirstFouJ1 = new Fou(posFirstFouJ1, this, true);
        Fou pieceSecFouJ1 = new Fou(posSecFouJ1, this, true);
        
        Tour pieceFirstTourJ2 = new Tour(posFirstTourJ1, this, false);
        Tour pieceSecTourJ2 = new Tour(posSecTourJ1, this, false);
        Cavalier pieceFirstCavJ2 = new Cavalier(posFirstCavJ1, this, false);
        Cavalier pieceSecCavJ2 = new Cavalier(posSecCavJ1, this, false);
        Fou pieceFirstFouJ2 = new Fou(posFirstFouJ1, this, false);
        Fou pieceSecFouJ2 = new Fou(posSecFouJ1, this, false);
        
        Pion[] piecePionJ1 = new Pion[8];
        Pion[] piecePionJ2 = new Pion[8];
        
        for(i = 0; i < posPionJ1.length ; i++)
        {
            posPionJ1[i] = new Point(1, i);
        }
        
        for(i = 0; i < piecePionJ1.length ; i++)
        {
            piecePionJ1[i] = new Pion(posPionJ1[i], this, true);
        }
        
        for(j = 0; j < posPionJ2.length ; j++)
        {
            posPionJ2[j] = new Point(6, j);
        }
        
        for(j = 0; j < piecePionJ2.length ; j++)
        {
            piecePionJ2[j] = new Pion(posPionJ2[j], this, false);
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
        boolean res = false;
        if(grille[p.getY()][p.getX()] == null)
        {
            res = true;
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
    
}
