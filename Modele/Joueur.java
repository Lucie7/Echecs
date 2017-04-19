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
// classe abstraite car si par la suite on veut ajouter un IA contre un joueur humain
public abstract class Joueur {
    
    protected boolean couleur; //mettre la couleur du joueur soit a blanc=true soit a noir=false
    protected String nom; //si on veut choisir un nom au joueur
    
    public Joueur(boolean c, String n)
    {
        this.couleur = c;
        this.nom = n;
    }
    
    // renvoie le nom du joueur
    public String getJoueurNom()
    {
        return this.nom;
    }
    
    // renvoie la couleur du joueur
    public boolean getJoueurCouleur()
    {
        return this.couleur;
    }
    
    //methode abstraite qui permet de choisir quelle piece du plateau on veut deplacer en revoyant sa coordonnee
    abstract public Point pieceADeplacer();
    
    //methode abstraite qui permet de deplacer une piece du plateau en renvoyant les coordonnee d'arrivee
    abstract public Point deplacerPiece();
    
    
}
