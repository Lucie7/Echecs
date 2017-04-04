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
    
    Joueur j1;
    Joueur j2;
    Plateau plat;
    boolean estAuTourDeJ1;
    
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
    
    public static void main(String[] args)
    {
        System.out.println("HELLO");
        
        /*Point departPion = new Point(1,2); // premiere ligne, deuxieme colonne
        Point departFou = new Point(7,2);
        
        Plateau pla = new Plateau();
        pla.initPlateau();
        
        Pion pi = new Pion(departPion,pla,0);
        Fou fo = new Fou(departFou,pla,0);
        
        Point poi1 = new Point(3,2);
        Point poi2 = new Point(5,2);
        Point poi3 = new Point(6,2);
        Point poi4 = new Point(6,3);
        
        Coup coupPion1 = new Coup(pi.getPositionPiece(),poi1);
        Coup coupFou1 = new Coup(fo.getPositionPiece(),poi3);
        
        System.out.println("Pour le pion :");
        
        System.out.println(pi.getPositionPiece().getY());
        System.out.println(pi.getPositionPiece().getX());
        
        pi.appliquerCoup(coupPion1);
        
        System.out.println(pi.getPositionPiece().getY());
        System.out.println(pi.getPositionPiece().getX());
        
        Coup coupPion2 = new Coup(pi.getPositionPiece(),poi2);
        
        pi.appliquerCoup(coupPion2);
        
        System.out.println(pi.getPositionPiece().getY());
        System.out.println(pi.getPositionPiece().getX());
        
        System.out.println("Pour le fou :");
        
        System.out.println(fo.getPositionPiece().getY());
        System.out.println(fo.getPositionPiece().getX());
        
        fo.appliquerCoup(coupFou1);
        
        System.out.println(fo.getPositionPiece().getY());
        System.out.println(fo.getPositionPiece().getX());
        
        Coup coupFou2 = new Coup(fo.getPositionPiece(),poi4);
         
        fo.appliquerCoup(coupFou2);

        System.out.println(fo.getPositionPiece().getY());
        System.out.println(fo.getPositionPiece().getX());*/
        
        /*Plateau plat = new Plateau();
        
        plat.initPlateau();
        
        plat.AffichePlateau();
        
        Point arr = new Point(3, 0);
        
        Coup c = new Coup(plat.getGrillePlateau()[0][0].getPositionPiece(), arr);
        
        plat.getGrillePlateau()[0][0].appliquerCoup(c);
        
        plat.AffichePlateau();*/
        
        System.out.println("BYE");
    }
}
