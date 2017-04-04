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
public class Roi extends Piece{
    
    public Roi(Point poi, Plateau pla, boolean cou)
    {
        super(poi,pla,cou);
    }

    @Override
    public Point[] getCheminDeplacement(Coup c)
    {
        Point[] chemin = new Point[1];
        chemin[0] = c.getArrivee();
        return chemin;
    }

    @Override
    boolean estValideDirection(Coup c)
    {
        boolean res = false;
        
        //test si je me déplace que d'une case dans n'importe quelle direction
        if(c.getArrivee().getX() <= c.getDepart().getX()+1) {
            if(c.getArrivee().getX() >= c.getDepart().getX()-1) {
                if(c.getArrivee().getY() <= c.getDepart().getY()+1) {
                    if(c.getArrivee().getY() >= c.getDepart().getY()-1) {
                        res = true;
                    }
                }
            }
        }
        
        return res;
    }
}
