/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author lucie
 */
public class Tour extends Piece{
    
    public Tour(Point po, Plateau plat, int coul) {
        super(p);
    }

    @Override
    public Point[] getCheminDeplacement(Coup c) {
        int tailleTableau;
        
        if(c.getDepart().getX() == c.getArrivee().getX())
        {
            tailleTableau = Math.abs(c.getArrivee().getY() - c.getDepart().getY());        
        }
        else {
            tailleTableau = Math.abs(c.getArrivee().getX() - c.getDepart().getX());
        }
        
        Point[] chemin = new Point[tailleTableau];
        
        for(int i = 0; i<chemin.length; i++)
        {
            //Si le déplacement est vertical
            if(c.getDepart().getX() == c.getArrivee().getX()) {
                //si je vais vers l'avant
                if(c.getDepart().getY() < c.getArrivee().getY()) {
                    Point temp = new Point(c.getDepart().getY()+i+1, c.getDepart().getX());
                    chemin[i] = temp;
                }else { //je me déplace vers l'arrière
                    Point temp = new Point(c.getDepart().getY()-i-1, c.getDepart().getX());
                    chemin[i] = temp;
                }
                
            //Sinon si le déplacement est horizontal
            } else if(c.getDepart().getY() == c.getArrivee().getY()) {
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
    boolean estValideDirection(Coup c) {
        boolean res = false;
        
        //Si la pièce est dans le plateau
        if(c.getArrivee().getX() >= 0 && c.getArrivee().getX() < 8 && c.getArrivee().getY() >= 0 && c.getArrivee().getY() < 8)
        {
            //Si le déplacement est horizontal
            if(c.getDepart().getY() == c.getArrivee().getY()) //ET x départ != de x d'arrivée ?
            {
                res = true;
            } //Sinon si le déplacement est vertical
            else if(c.getDepart().getX() == c.getArrivee().getX()) //ET y départ != de y arrivée ?
            {
                res = true;
            }
        }
        
        return res;
    }
    
}
