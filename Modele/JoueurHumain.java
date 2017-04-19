/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Scanner;

/**
 *
 * @author testfatoslocal
 */
public class JoueurHumain extends Joueur{
    
    public JoueurHumain(boolean c, String n)
    {
        super(c,n);
    }
    
    @Override
    public Point pieceADeplacer()
    {
        int abs; //la coordonne sur l'axe vertical
        int ord; //la coordonne sur l'axe horizontal
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ligne de la piece a deplacer : ");
        ord = sc.nextInt();
        System.out.println("Colonne de la piece a deplacer : ");
        abs = sc.nextInt();
        
        Point depart =  new Point(ord, abs);
        
        return depart;
    }
    
    @Override
    public Point deplacerPiece()
    {
        int abs;
        int ord;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ligne sur laquelle deplacer la piece");
        ord = sc.nextInt();
        System.out.println("Colonne sur laquelle deplacer la piece");
        abs = sc.nextInt();
        
        Point destination =  new Point(ord, abs);
        
        return destination;
    }
}
