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
public class Pion extends Piece{
    
    private boolean premierDeplacement;
    
    public Pion(Point po, Plateau plat, int coul)
    {
        super(p);
        this.premierDeplacement = true;
    }

    @Override
    public Point[] getCheminDeplacement(Coup c)
    {
        int tailleAReserver = c.getArrivee().getY() - c.getDepart().getY();
        Point[] res = new Point[tailleAReserver];
        
        Point temp1 = new Point(c.getDepart().getY()+1,c.getDepart().getX());
        
        res[0] = temp1;
        
        if(tailleAReserver == 2)
        {
            Point temp2 = new Point(c.getDepart().getY()+2,c.getDepart().getX());
            
            res[1] = temp2;
        }
        
        return res;
    }

    @Override
    boolean estValideDirection(Coup c)
    {
        boolean res = false;
        
        //test si au depart il est bien dans les dimensions de la grille
        if((c.getDepart().getY() > 0) && (c.getDepart().getY() < 8))
        {
            //test si à l'arrivee il s'est bien deplacer d'au moin une case et qui'il ne depasse pas la grille
            if(c.getArrivee().getY() > 1 && c.getArrivee().getY() < 8)
            {
                //test si il se deplace vers l'avant et uniquement sur l'axe verticale
                if(c.getDepart().getY() < c.getArrivee().getY() && c.getArrivee().getX() == c.getDepart().getX())
                {
                    //test si c'est le premier coup de la partie
                    if(this.premierDeplacement)
                    {
                        //test si il respecte le bon nombre de deplacement et qu'il se deplace obligatoirement
                        if(((c.getArrivee().getY()) - (c.getDepart().getY()) < 2) && ((c.getArrivee().getY()) - (c.getDepart().getY()) > 0))
                        {
                            res = true;
                            this.premierDeplacement = false;
                        }
                    }
                    else
                    {
                        if(((c.getArrivee().getY()) - (c.getDepart().getY()) == 1))
                        {
                            res = true;
                        }
                    }
                }
            }
        }
        return res;
    }
    
}
