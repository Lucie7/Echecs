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
public abstract class Joueur {
    
    protected boolean couleur;
    protected String nom;
    
    public Joueur(boolean c, String n)
    {
        this.couleur = c;
        this.nom = n;
    }
    
    public String getJoueurNom()
    {
        return this.nom;
    }
    
    public boolean getJoueurCouleur()
    {
        return this.couleur;
    }
    
    
}
