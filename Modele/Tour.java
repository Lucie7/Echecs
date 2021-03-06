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
public class Tour extends Piece{
    
    public Tour(Point poi, Plateau pla, boolean cou,String url)
    {
        super(poi,pla,cou,url);
    }

    @Override
    public Point[] getCheminDeplacement(Coup c)
    {
        int tailleTableau;
        
        if(c.getDepart().getX() == c.getArrivee().getX())
        {
            tailleTableau = Math.abs(c.getArrivee().getY() - c.getDepart().getY());        
        }
        else
        {
            tailleTableau = Math.abs(c.getArrivee().getX() - c.getDepart().getX());
        }
        
        Point[] chemin = new Point[tailleTableau];
        
        for(int i = 0; i<chemin.length; i++)
        {
            //Si le déplacement est vertical
            if(c.getDepart().getX() == c.getArrivee().getX()) {
                //si je vais vers le bas
                if(c.getDepart().getY() < c.getArrivee().getY()) {
                    Point temp = new Point(c.getDepart().getY()+i+1, c.getDepart().getX());
                    chemin[i] = temp;
                }else { //je me déplace vers le haut
                    Point temp = new Point(c.getDepart().getY()-i-1, c.getDepart().getX());
                    chemin[i] = temp;
                }
            }
            else if(c.getDepart().getY() == c.getArrivee().getY()) {
                //si je vais vers la droite
                if(c.getDepart().getX() < c.getArrivee().getX()) {
                    Point temp = new Point(c.getDepart().getY(), c.getDepart().getX()+i+1);
                    chemin[i] = temp;
                }else { //je me déplace vers la gauche
                    Point temp = new Point(c.getDepart().getY(), c.getDepart().getX()-i-1);
                    chemin[i] = temp;
                }
            }
        }
        
        return chemin;
    }

    
    @Override
    boolean estValideDirection(Coup c)
    {
        boolean res = false;
        
        //Si la pièce est dans le plateau
        if(c.getArrivee().getX() >= 0 && c.getArrivee().getX() < 8 && c.getArrivee().getY() >= 0 && c.getArrivee().getY() < 8)
        {
            //Si le déplacement est horizontal
            if((c.getDepart().getY() == c.getArrivee().getY()) && (c.getDepart().getX() != c.getArrivee().getX()))
            {
                res = true;
            } //Sinon si le déplacement est vertical
            else if((c.getDepart().getX() == c.getArrivee().getX()) && (c.getDepart().getY() != c.getArrivee().getY()))
            {
                res = true;
            }
        }
        
        return res;
    }
}
