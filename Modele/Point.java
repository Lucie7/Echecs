/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author testfatoslocal
 */
public class Point {
    
    private int x;
    private int y;
    
    public Point(int i, int j)
    {
        this.y = i;
        this.x = j;
    }
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public void setX(int xx)
    {
        this.x = xx;
    }
    
    public void setY(int yy)
    {
        this.y = yy;
    }
}
