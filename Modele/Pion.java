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
public class Pion extends Piece{
    
    public boolean premierDeplacement; //boolean pour savoir si c'est le premier deplacement du pion
    
    public Pion(Point poi, Plateau pla, boolean cou, String url)
    {
        super(poi,pla,cou,url);
        this.premierDeplacement = true;
    }

    @Override
    public Point[] getCheminDeplacement(Coup c)
    {
        //la taille a reserver depend si c'est le premier deplacement ou non du pion
        int tailleAReserver = abs(c.getArrivee().getY() - c.getDepart().getY());
        Point[] res = new Point[tailleAReserver];
        
        Point temp1;
        
        //si c'est le joueur1, le joueur du haut
        if(this.couleur == true)
        {
            temp1 = new Point(c.getDepart().getY()+1,c.getDepart().getX());
        }
        else
        {
            temp1 = new Point(c.getDepart().getY()-1,c.getDepart().getX());
        }
        
        res[0] = temp1;
        
        //si c'est le premier deplacement du pion
        if(tailleAReserver == 2)
        {
            Point temp2;
            
            if(this.couleur == true)
            {
                temp2 = new Point(c.getDepart().getY()+2,c.getDepart().getX());
            }
            else
            {
                temp2 = new Point(c.getDepart().getY()-2,c.getDepart().getX());
            }
            
            res[1] = temp2;
        }
        
        return res;
    }

    @Override
    boolean estValideDirection(Coup c)
    {
        boolean res = false;
        
        //test si au depart il est bien dans les dimensions de la grille
        if((c.getDepart().getY() >= 0) && (c.getDepart().getY() < 8))
        {
            //test si à l'arrivee il ne depasse pas la grille
            if(c.getArrivee().getY() >= 0 && c.getArrivee().getY() < 8)
            {
                //si c'est le joueur du haut
                if(this.couleur == true)
                {
                    //si la case devant le pion est vide
                    if(this.p.getGrillePlateau()[c.getDepart().getY()+1][c.getDepart().getX()] == null)
                    {
                        //test si il se deplace vers le bas et uniquement sur l'axe des ordonnee
                        if(c.getDepart().getY() < c.getArrivee().getY() && c.getArrivee().getX() == c.getDepart().getX())
                        {
                            //test si c'est le premier deplacement du pion
                            if(this.premierDeplacement == true)
                            {
                                //test si il respecte le bon nombre de deplacement
                                if(((c.getArrivee().getY()) - (c.getDepart().getY()) <= 2) /*&& ((c.getArrivee().getY()) - (c.getDepart().getY()) > 0)*/)
                                {
                                    //dans ce cas le pion peut se deplacer
                                    res = true;
                                    //on met le booleen testant si c'est le premier deplacement du pion a faux
                                    this.premierDeplacement = false;
                                }
                            }
                            else
                            {
                                //test si il respecte le bon nombre de deplacement
                                if(((c.getArrivee().getY()) - (c.getDepart().getY()) == 1))
                                {
                                    res = true;
                                }
                            }
                        }
                    }
                    
                    if(c.getDepart().getX() != 7)
                    {
                       
                        //si il y a un pion adverse dans la diagonale à gauche du pion il peut se deplacer
                        if((this.p.getGrillePlateau()[c.getDepart().getY()+1][c.getDepart().getX()+1] != null)/* && (this.p.getGrillePlateau()[c.getDepart().getY()+1][c.getDepart().getX()+1].couleur != this.couleur)*/)
                        {
                            if(this.p.getGrillePlateau()[c.getDepart().getY()+1][c.getDepart().getX()+1].couleur != this.couleur)
                            {
                                if(c.getArrivee().getY() == c.getDepart().getY()+1)
                                {
                                    if(c.getArrivee().getX() == c.getDepart().getX()+1)
                                    {
                                        res = true;
                                    }
                                }
                            }
                        }
                    }
                    
                    if(c.getDepart().getX() != 0)
                    {
                        //si il y a un pion adverse dans la diagonale à droite du pion il peut se deplacer
                        if((this.p.getGrillePlateau()[c.getDepart().getY()+1][c.getDepart().getX()-1] != null)/* && (this.p.getGrillePlateau()[c.getDepart().getY()+1][c.getDepart().getX()-1].couleur != this.couleur)*/)
                        {
                            if(this.p.getGrillePlateau()[c.getDepart().getY()+1][c.getDepart().getX()-1].couleur != this.couleur)
                            {
                                if(c.getArrivee().getY() == c.getDepart().getY()+1)
                                {
                                    if(c.getArrivee().getX() == c.getDepart().getX()-1)
                                    {
                                        res = true;
                                    }
                                }
                            }
                        }
                    }
                }
                else
                {
                    //si la case devant le pion est vide
                    if(this.p.getGrillePlateau()[c.getDepart().getY()-1][c.getDepart().getX()] == null)
                    {
                        //test si il se deplace vers le haut et uniquement sur l'axe des ordonnee
                        if( (c.getDepart().getY() > c.getArrivee().getY()) && (c.getArrivee().getX() == c.getDepart().getX()) )
                        {
                             //test si c'est le premier deplacement du pion
                            if(this.premierDeplacement == true)
                            {
                               //test si il respecte le bon nombre de deplacement
                                if((abs((c.getDepart().getY())-(c.getArrivee().getY()))<=2)/*&&((abs((c.getDepart().getY())-(c.getArrivee().getY()))>0))*/)
                                {
                                    res = true;
                                    this.premierDeplacement = false;
                                }
                            }
                            else
                            {
                                if( abs( ( c.getDepart().getY() - c.getArrivee().getY() ) ) == 1 ) 
                                {
                                    res = true;
                                }
                            }
                        }
                    }
                    
                    if(c.getDepart().getX() != 7)
                    {
                        //si il y a un pion adverse dans la diagonale à droite du pion il peut se deplacer
                        if((this.p.getGrillePlateau()[c.getDepart().getY()-1][c.getDepart().getX()+1] != null) && (this.p.getGrillePlateau()[c.getDepart().getY()-1][c.getDepart().getX()+1].couleur != this.couleur))
                        {
                            if(c.getArrivee().getY() == c.getDepart().getY()-1)
                            {
                                if(c.getArrivee().getX() == c.getDepart().getX()+1)
                                {
                                    res = true;
                                }
                            }
                        }
                    }
                    
                    if(c.getDepart().getX() != 0)
                    {
                        //si il y a un pion adverse dans la diagonale à gauche du pion il peut se deplacer
                        if((this.p.getGrillePlateau()[c.getDepart().getY()-1][c.getDepart().getX()-1] != null) && (this.p.getGrillePlateau()[c.getDepart().getY()-1][c.getDepart().getX()-1].couleur != this.couleur))
                        {
                            if(c.getArrivee().getY() == c.getDepart().getY()-1)
                            {
                                if(c.getArrivee().getX() == c.getDepart().getX()-1)
                                {
                                    res = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    
}
