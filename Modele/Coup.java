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
public class Coup {
    
    private Point depart;
    private Point arrivee;
    
    public Coup(Point d, Point a)
    {
        this.depart = d;
        this.arrivee = a;
    }
    
    public Point getDepart() {
        return this.depart;
    }
    
    public Point getArrivee() {
        return this.arrivee;
    }
    
    public void setDepart(Point p) {
        this.depart = p;
    }
    
    public void setArrivee(Point p) {
        this.arrivee = p;
    }
    
}
