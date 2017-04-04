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
public class Fou extends Piece{
    
    public Fou(Point poi, Plateau pla, boolean cou)
    {
        super(poi,pla,cou);
    }
    
    @Override
    public Point[] getCheminDeplacement(Coup c) {
        
        int tailleTableau = Math.abs(c.getArrivee().getX() - c.getDepart().getX());
        Point[] chemin = new Point[tailleTableau];
        
        for(int i = 0; i<chemin.length; i++)
        {
        
            if(c.getArrivee().getY() > c.getDepart().getY()) //Si je me déplace vers l'avant
            {
                if(c.getArrivee().getX() > c.getDepart().getX()) //Si je me déplace vers la droite
                {
                    //On fait plus 1 à chaque coordonée à chaque itération
                    Point temp = new Point(c.getDepart().getY()+i+1, c.getDepart().getX()+i+1);
                    chemin[i] = temp;

                }
                else //Je me déplace vers la gauche
                {
                    //A chaque itération on fait plus 1 pour y et moins 1 pour x
                    Point temp = new Point(c.getDepart().getY()+i+1, c.getDepart().getX()-i-1);
                    chemin[i] = temp;
                }
            }
            else //Je me déplace vers l'arrière
            {
                if(c.getArrivee().getX() > c.getDepart().getX()) //Si je me déplace vers la droite
                {
                    //A chaque itération on fait plus 1 pour x et moins 1 pour y
                    Point temp = new Point(c.getDepart().getY()-i-1, c.getDepart().getX()+i+1);
                    chemin[i] = temp;
                }
                else //Je me déplace vers la gauche
                {
                    //On fait moins 1 à chaque coordonée à chaque itération
                    Point temp = new Point(c.getDepart().getY()-i-1, c.getDepart().getX()-i-1);
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
            //Si le déplacement est bien en diagonale
            if(Math.abs(c.getArrivee().getX() - c.getDepart().getX()) == Math.abs(c.getArrivee().getY() - c.getDepart().getY()))
            {
                res = true;
            }
        }
        else
        {
            res = false;
        }
        
        return res;
    }
}
