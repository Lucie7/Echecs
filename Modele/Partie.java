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
public class Partie {
    
    public Joueur j1;
    public Joueur j2;
    private Plateau plat;
    private boolean estAuTourDeJ1;
    
    public Partie(Joueur jou1, Joueur jou2)
    {
        this.j1 = jou1;
        this.j2 = jou2;
        this.plat = new Plateau();
        this.plat.initPlateau();
        this.estAuTourDeJ1 = true;
    }
    
    public Joueur joueurSuivant()
    {
        if(this.estAuTourDeJ1)
        {
            this.estAuTourDeJ1 = false;
            return this.j1;
        }
        else
        {
            this.estAuTourDeJ1 = true;
            return this.j2;
        }
    }
    
    public Joueur getPremierJoueur()
    {
        return this.j1;
    }
    
    public Joueur getSecondJoueur()
    {
        return this.j2;
    }
    
    public boolean estTermineePartie(boolean couleur)
    {
        boolean res = false;
        
        if(this.plat.echecEtMat(couleur) == true)
        {
            res = true;
        }
        
        return res;
    }
    
    public void JouerPartie()
    {
        Joueur joueurCourant = null;
        int i = 0;
        
        this.plat.AfficheDetailPlateau();
        
        while(i<1/*estTermineePartie(joueurSuivant().couleur*/)
        {
            joueurCourant = joueurSuivant();
            
            Point dep = joueurCourant.pieceADeplacer();
            Point dest = joueurCourant.deplacerPiece();
            Coup c = new Coup(dep, dest);
            
            while(!this.plat.getGrillePlateau()[dep.getY()][dep.getX()].estValideCoup(c, joueurCourant.couleur))
            {
                dep = joueurCourant.pieceADeplacer();
                dest = joueurCourant.deplacerPiece();
                c.setDepart(dep);
                c.setArrivee(dest);
            }
            
            this.plat.getGrillePlateau()[dep.getY()][dep.getX()].appliquerCoup(c,joueurCourant.couleur);
            
            this.plat.AfficheDetailPlateau();
            i++;
        }
    }
}
