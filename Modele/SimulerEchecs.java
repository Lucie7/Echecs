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
public class SimulerEchecs {
    
    public static void main(String[] args) {
        
        JoueurHumain jou1 = new JoueurHumain(true,"player1");
        
        JoueurHumain jou2 = new JoueurHumain(false,"player2");
        
        Partie jeu = new Partie(jou1, jou2);
        
        jeu.JouerPartie();
        
    }
    
}
