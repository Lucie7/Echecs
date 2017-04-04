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
public class Reine extends Piece{
    
     public Reine(Point poi, Plateau pla, boolean cou)
     {
        super(poi,pla,cou);
     }

    @Override
    public Point[] getCheminDeplacement(Coup c)
    {
        
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
            } else { //Le déplacement est en diagonale
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
            //Si le déplacement est en diagonale
            if(Math.abs(c.getArrivee().getX() - c.getDepart().getX()) == Math.abs(c.getArrivee().getY() - c.getDepart().getY()))
            {
                res = true;
            }//Sinon si le déplacement est horizontal
            else if(c.getDepart().getY() == c.getArrivee().getY()) //ET x départ != de x d'arrivée ?
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
