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
    
    public Joueur j1; //le premier joueur
    public Joueur j2; //le second joueur
    public Plateau plat; // le plateau de jeu
    private boolean estAuTourDeJ1; //booleen pour savoir c'est au tour de j1 de jouer
    
    public Partie(Joueur jou1, Joueur jou2)
    {
        this.j1 = jou1;
        this.j2 = jou2;
        this.plat = new Plateau();
        this.plat.initPlateau(); //initialise le plateau avec les pieces placer au bonne coordonnee
        this.estAuTourDeJ1 = true; //on commence la partie avec le j1
    }
    
    //renvoi le joueur qui doit jouer au prochain tour
    public Joueur joueurSuivant()
    {
        //si c'est au tour de j1 de jouer
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
    
    //methode qui permet de fixer les condition de fin de partie, dans notre cas si on a echec et mat
    public boolean estTermineePartie(boolean couleur)
    {
        //comme nos fonction permettant de tester si le roi est en echec ne fonctionne pas, on ne peut pas
        //completer la methode estTermineePartie
        boolean res = false;
        
        return res;
    }
    
    //methode simulant une partie de jeu d'echec
    public void JouerPartie()
    {
        //le joueur qui doit jouer dans le tour courant
        Joueur joueurCourant = null;
        int i = 0;
        
        this.plat.AfficheDetailPlateau();
        
        //Normalement ici on devrait avoir while(!estTermineePartie), mais comme elle n'est pas complete
        //on a juste mis une boucle pour effectuer 3 tour dans le jeu
        while(i < 3)
        {
            //de base d'apres notre methode joueurSuivant, ici c'est le joueur1 qui est renvoyé
            joueurCourant = joueurSuivant();
            
            //on recupere les coordonne servant à appliquer le coup du joueur
            Point dep = joueurCourant.pieceADeplacer();
            Point dest = joueurCourant.deplacerPiece();
            Coup c = new Coup(dep, dest);
            
            System.out.println("ici on est avant le while");
            
            while(!this.plat.getGrillePlateau()[dep.getY()][dep.getX()].estValideCoup(c, joueurCourant.couleur))
            {
                System.out.println("ici on est dans le while");
                dep = joueurCourant.pieceADeplacer();
                dest = joueurCourant.deplacerPiece();
                System.out.println("avant les set");
                c.setDepart(dep);
                c.setArrivee(dest);
                System.out.println("apres les set");
            }
            
            System.out.println("ici on est pas dans le while");
            //this.plat.getGrillePlateau()[dep.getY()][dep.getX()].appliquerCoup(c,joueurCourant.couleur);
            this.plat.getGrillePlateau()[dep.getY()][dep.getX()].appliquerDirectementCoup(c);
            System.out.println("apres le applik coup");
            
            this.plat.AfficheDetailPlateau();
            i++;
        }
    }
}
