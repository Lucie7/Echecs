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

// Une possibilite d'extension d'avoir un IA
public class JoueurAleatoire extends Joueur{
    
    public JoueurAleatoire(boolean couleur, String name)
    {
        super(couleur,name);
    }

    @Override
    public Point pieceADeplacer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point deplacerPiece() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
