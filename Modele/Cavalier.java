/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import static java.lang.Math.abs;

/**
 *
 * @author testfatoslocal
 */
public class Cavalier extends Piece{
    
    public Cavalier(Point p)
    {
        super(p);
    }

    @Override
    public Point[] getCheminDeplacement(Coup c)
    {
        //Pour le cavalier on ne stock que le point d'arrive
        Point temp = new Point(c.getArrivee().getY(), c.getArrivee().getX());
        
        Point[] res = new Point[1];
        
        res[0] = temp;
        
        return res;
    }

    @Override
    boolean estValideDirection(Coup c)
    {
        boolean res = false;
        
        //test si au depart il est bien dans les dimension de la grille
        if((c.getDepart().getY() > 0) && (c.getDepart().getY() < 8) && (c.getDepart().getX() > 0) && (c.getDepart().getX() < 8))
        {
            //test si il se deplace de 1 case horizontalement alors il se deplace de deux cases verticalement
            if((abs(c.getArrivee().getY() - c.getDepart().getY()) == 1) && (abs(c.getArrivee().getX() - c.getDepart().getX()) == 2))
            {
                res = true;
            }
            //test si il se deplace de 1 case verticalement alors il se deplace de deux cases horizontalement
            else if((abs(c.getArrivee().getY() - c.getDepart().getY()) == 2) && (abs(c.getArrivee().getX() - c.getDepart().getX()) == 1))
            {
                res = true;
            }
        }
        
        return res;
    }
    
}
