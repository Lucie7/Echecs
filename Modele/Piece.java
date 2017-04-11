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
public abstract class Piece {
    
    // Joueur1 en haut et sa couleur = true
    protected boolean estVivant;
    protected Point position;
    protected boolean couleur;
    protected Plateau p;
    protected String urlImage;
    
    public Piece(Point po, Plateau plat, boolean coul, String url)
    {
        this.estVivant = true;
        this.position = po;
        this.couleur = coul;
        this.p = plat.getPlateau();
        this.urlImage = url;
    }
    
    public Point getPositionPiece()
    {
        return this.position;
    }
    
    abstract public Point[] getCheminDeplacement(Coup c);
    
    abstract boolean estValideDirection(Coup c);
    
    public void appliquerCoup(Coup c, boolean couleur)
    {
        //if(estValideCoup(c,couleur))
        //{
            System.out.println("Le coup a ete applique");
            this.position = c.getArrivee();
            this.p.setGrille(this.p.getGrillePlateau()[c.getDepart().getY()][c.getDepart().getX()],c.getArrivee());
            this.p.setGrille(null,c.getDepart());
        //}
        //else
        //{
          //  System.out.println("Le coup n'est pas possible");
        //}
    }
    
    
    public boolean estValideCouleur(boolean couleur,Point p)
    {
        boolean res = false;
        if(this.p.getGrillePlateau()[p.getY()][p.getX()].couleur == couleur)
        {
            res = true;
        }
        
        return res;
    }
    
   /* public boolean estValideCoup(Coup c,boolean couleur)
    {
        boolean res = false;
        System.out.println("BYE");
        
        if(estValideCouleur(couleur, c.getDepart()))
        {
            System.out.println("a");

            if(estValideDirection(c))
            {
                System.out.println("b");
                Point[] temp = getCheminDeplacement(c);

                for(int i = 0; i < temp.length ; i++)
                {
                    System.out.println("c");
                    //Si la case est libre alors on peut y aller
		        if(this.p.estLibre(temp[i]))
		        {
                            System.out.println("d");
		            res = true;
                             //Sinon si la case est occupé par une piece qui n'est pas de notre couleur alors on peut y aller et la manger
		        }
		       
		        else if(this.p.getGrillePlateau()[c.getArrivee().getY()][c.getArrivee().getX()].couleur != this.couleur) {
		            System.out.println("e");
                            res = true;
		            this.p.getGrillePlateau()[c.getArrivee().getY()][c.getArrivee().getX()].estMangee();
		        }
                }
            }
        }
        else
        {
            System.out.println("Mauvaise Couleur de piece");
        }
        
        return res;
    }*/
    
    public boolean estValideCoup(Coup c, boolean couleur)
    {
        boolean res = false;
        //Si le roi est en echec et que le coup permet de l'enlever ou qu'il n'y a pas d'échec...
        if((p.estEnEchecRoi(this.couleur) == true && this.estEnleveeEchec(c) == true) || p.estEnEchecRoi(this.couleur) == false) {
            //...et si on bouge bien une de nos piece...
            if(estValideCouleur(couleur, c.getDepart()))
            {
                //...et si la direction est ok...
                if(estValideDirection(c))
                {
                    Point[] temp = getCheminDeplacement(c);
                    //...alors on verifie que toutes les cases du chemin sont libres
                    for(int i = 0; i < temp.length ; i++)
                    {
                        //Si la case est libre alors on peut y aller
                        if(this.p.estLibre(temp[i]))
                        {
                            res = true;
                        }
                        //Sinon si c'est la dernière case est occupé par une piece qui n'est pas de notre couleur alors on peut y aller et la manger
                        else if(i == temp.length) {
                            //On test si la case contient une piece que l'on peut manger
                            if(this.p.getGrillePlateau()[c.getArrivee().getY()][c.getArrivee().getX()].couleur != this.couleur) {
                                res = true;
                                //Et on mange la piece
                                this.p.getGrillePlateau()[c.getArrivee().getY()][c.getArrivee().getX()].estMangee();
                            }
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    public boolean estEnleveeEchec(Coup c)
    {
        boolean res = false;
        Plateau pTemp = new Plateau();
        
        //On fait une copie de l'état actuel du plateau
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                pTemp.getGrillePlateau()[j][i] = this.p.getGrillePlateau()[j][i];
            }
        }
        //Puis on applique le coup
        pTemp.setGrille(this, c.getArrivee());
        pTemp.setGrille(null, c.getDepart());
        
        //Et on verifie si il y a toujours echec
        if(pTemp.estEnEchecRoi(this.couleur) == false) {
            res = true;
        }
        
        
        return res;
    }

	public void estMangee()
        {
            this.estVivant = false;
        }
        
        public String getUrlImage()
        {
            return this.urlImage;
        }
        
        public boolean getPieceCouleur()
        {
            return this.couleur;
        }
        
        public Point[] EnsembleCoup() {
        Point[] res = new Point[27];
        boolean temp;
        int k =0;
        
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                Point p = new Point(j, i);
                Coup c = new Coup(this.position, p);
                temp = this.estValideCoup(c, this.couleur);
                if(temp == true) {
                    res[k] = p;
                    k++;
                }
            }
        }
        
        return res;
    }
    
}
