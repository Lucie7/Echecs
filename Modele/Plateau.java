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
        int i,j;
        for(i = 0 ; i < 8 ; i++)
        {
            for( j = 0 ; j < 8 ; j++)
            {
                this.grille[i][j] = null;
            }
        }
        
        Point pos = new Point(1,2);
        Pion monPion = new Pion(pos);
        this.grille[pos.getY()][pos.getX()] = monPion;
    }
    
    public boolean estLibre(Point p)
    {
        if(grille[p.getY()][p.getX()] == null)
        {
            return true;
        }
        else
        {
                return false;
        }
    }
}
