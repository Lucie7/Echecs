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
    
    // Joueur1 en bas et sa couleur = true
    protected boolean estVivant;
    protected Point position;
    protected boolean couleur;
    protected Plateau p;
    
    public Piece(Point po, Plateau plat, boolean coul)
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
    
    public void appliquerCoup(Coup c, Joueur j)
    {
        if(estValideCoup(c,j))
        {
            System.out.println("Le coup a ete applique");
            this.position = c.getArrivee();
        }
        else
        {
            System.out.println("Le coup n'est pas possible");
        }
    }
    
    
    public boolean estValideCouleur(Joueur j,Point p)
    {
        boolean res = false;
        if(this.p.getGrillePlateau()[p.getY()][p.getX()].couleur == j.couleur)
        {
            res = true;
        }
        
        return res;
    }
    
    public boolean estValideCoup(Coup c,Joueur j)
    {
        boolean res = false;
        
        if(estValideCouleur(j, c.getDepart()))
        {

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
        }
        
        return res;
    }
    
}
