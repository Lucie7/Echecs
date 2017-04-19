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
    
    protected boolean estVivant;
    protected Point position;
    protected boolean couleur; // la couleur des pieces du joueur1 = blanc = true
    protected Plateau p;
    protected String urlImage;
    
    public Piece(Point po, Plateau plat, boolean coul, String url)
    {
        this.estVivant = true;
        this.position = po;
        this.couleur = coul;
        this.p = plat;
        this.urlImage = url;
    }
    
    public Point getPositionPiece()
    {
        return this.position;
    }
    
    // methode permettant de recuperer les cases intermediaires entre le point de depart et le point d'arrivee
    abstract public Point[] getCheminDeplacement(Coup c);
    
    // methode permettant verifier si les pieces respectent bien leurs deplacements
    abstract boolean estValideDirection(Coup c);
    
    public void appliquerCoup(Coup c, boolean couleur)
    {
        if(estValideCoup(c,couleur))
        {
            this.position = c.getArrivee();
            this.p.setGrille(this.p.getGrillePlateau()[c.getDepart().getY()][c.getDepart().getX()],c.getArrivee());
            this.p.setGrille(null,c.getDepart());
            System.out.println();
            System.out.println("Le coup a ete applique");
            
            /*
            if(this.p.estEnEchecRoi(!couleur))
            {
                System.out.println("Apres appliquerCoup, le roi est en echec");
            }
            else
            {
                System.out.println("Apres appliquerCoup, le roi n'est pas en echec");
            }
            */
        }
        else
        {
            System.out.println();
            System.out.println("Le coup n'est pas valide, il n'a pas ete applique");
        }
    }
    
    //methode permettant d'appliquer un coup sans tester si le coup est valide auparavant
    public void appliquerDirectementCoup(Coup c)
    {
        this.position = c.getArrivee();
        this.p.setGrille(this.p.getGrillePlateau()[c.getDepart().getY()][c.getDepart().getX()],c.getArrivee());
        this.p.setGrille(null,c.getDepart());
        System.out.println();
        System.out.println("Le coup a ete applique");
        
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
    
    public boolean estValideCoup(Coup c,boolean couleur)
    {
        boolean res = true;
        
        if(this.p.getGrillePlateau()[c.getDepart().getY()][c.getDepart().getX()] instanceof Piece)
        {
        
            if(estValideCouleur(couleur, c.getDepart()))
            {
                if(estValideDirection(c))
                {
                    Point[] temp = getCheminDeplacement(c);

                    for(int i = 0; i < temp.length ; i++)
                    {
                        //Si la case est libre alors on peut y aller
                        if(this.p.estLibre(temp[i]))
                        {
                            //res = true;
                        }
                        else if( i == temp.length-1) //sinon si on est sur la case d'arrivee du coup souhaitee
                        {
                            // si la piece presente sur la case d'arrive est une piece adverse
                            if(this.p.getGrillePlateau()[temp[i].getY()][temp[i].getX()].couleur != couleur)
                            {
                                //res = true;
                                //on mange la piece adverse
                                this.p.getGrillePlateau()[temp[i].getY()][temp[i].getX()].estMangee();
                            }
                            else
                            {
                                res = false;
                            }
                        }
                        else //sinon c'est que la case n'est pas libre
                        {
                            res = false;
                        }
                    }
                }
                else
                {
                    res = false;
                }
            }
            else
            {
                System.out.println();
                System.out.println("Ceci est une piece adverse, vous ne pouvez pas la deplacer");
                res = false;
            }
        }
        else
        {
            res = false;
            System.out.println("La case de depart est une case vide, il n'y a pas de coup a applique");
        }
        
        return res;
    }
    
    /*
    public boolean estEnleveeEchec(Coup c)
    {
        boolean res = false;
        Plateau pTemp = new Plateau();
        
        //On fait une copie de l'état actuel du plateau
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                pTemp.getGrillePlateau()[j][i] = this.p.getGrillePlateau()[j][i];
            }
        }
        
        //Puis on applique le coup
        pTemp.setGrille(this, c.getArrivee());
        pTemp.setGrille(null, c.getDepart());
        
        //Et on verifie si il y a toujours echec
        if(pTemp.estEnEchecRoi(this.couleur) == false)
        {
            res = true;
        }
        
        return res;
    }
    */
    
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
    
    //methode permettant de recuperer toutes les cases où la piece peut se deplacer
    public Point[] EnsembleCoup()
    {
        Point[] res = new Point[27];//car au maximum on a calcule qu'une piece pouvait se deplacer au maximum sur 27 cases
        boolean temp;
        int k = 0;
        
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                Point poi = new Point(i, j);
                Coup c = new Coup(this.position, poi);
                temp = this.estValideCoup(c, this.couleur);
                if(temp == true)
                {
                    res[k] = poi;
                    k++;
                }
            }
        }
        
        return res;
    }
    
}
