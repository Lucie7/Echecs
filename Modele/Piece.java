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
public abstract class Piece {
    
    private boolean estVivant;
    private Point position;
    private int couleur;
    private Plateau p;
    
    public Piece(Point po, Plateau plat, int coul)
    {
        this.estVivant = true;
        this.position = po;
        this.couleur = coul;
        this.p = plat.getPlateau();
    }
    
    public Point getPositionPiece()
    {
        return this.position;
    }
    abstract public Point[] getCheminDeplacement(Coup c);
    
    abstract boolean estValideDirection(Coup c);
    
    public void appliquerCoup(Coup c)
    {
        if(estValideCoup(c))
        {
            this.position = c.getArrivee();
        }
        else
        {
            System.out.println("Le coup n'est pas possible");
        }
    }
    
    public boolean estValideCoup(Coup c)
    {
        boolean res = false;
        if(estValideDirection(c))
        {
            Point[] temp = getCheminDeplacement(c);
            
            for(int i = 0; i < temp.length ; i++)
            {
                if(this.p.estLibre(temp[i]))
                {
                    res = true;
                }
            }
        }
        return res;
    }
           
}
