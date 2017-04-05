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
    
    public static void main(String[] args)
    {
        System.out.println("HELLO");
        
        Plateau plat = new Plateau();
        
        plat.initPlateau();
        
        plat.AffichePlateau();
        
        Point p1 = new Point(0, 0);
        
        Tour t = new Tour(p1, plat, true);
        
        Point p2 = new Point(3,1);
        
        plat.setGrille(t, p2);
        
        plat.AffichePlateau();
        
        System.out.println("BYE");
    }
}
