package game;
import java.awt.*;
//import javax.swing.*;


public abstract class GameObject {
    protected String nom;
    protected int posX;
    protected int posY;
    protected int tailleX;
    protected int tailleY;
    protected boolean isPressed;
    protected Image iActuelle; // Image de l'objet 
    protected Color c;
    protected Image iOuvert; // Image de l'objet avant utilisation
    protected Image iFerme; // Image de l'objet après utilisation 

    protected Image iCursor;
    protected int iCursorTailleX;
    protected int iCursorTailleY;

    public GameObject (String nom,
                       int posX,
                       int posY, 
                       int tailleX,
                       int tailleY,
                       Object imageOuColor,
                       Image iOuvert,
                       Image iFerme,
                       Image iCursor,
                       int iCursorTailleX,
                       int iCursorTailleY) {
                        
        this.nom = nom;
        this.posX = posX;
        this.posY = posY;
        this.tailleX = tailleX;
        this.tailleY= tailleY;
        this.isPressed = false;
        this.iOuvert = iOuvert;
        this.iFerme = iFerme;
        this.iCursor = iCursor;
        this.iCursorTailleX = iCursorTailleX;
        this.iCursorTailleY = iCursorTailleY;

        if (imageOuColor instanceof Color) {
            this.iActuelle = null;
            this.c = (Color) imageOuColor;
        }
        else if (imageOuColor instanceof Image) {
            this.iActuelle = (Image) imageOuColor;
            this.c = null;
        } 
        else {
            throw new IllegalArgumentException("Paramètre doit être Color ou Image");
        }
    
    }

    public String getNom() {
        return nom;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getTailleX() {
        return tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }

    public Color getColor() {
        return c;
    }

    public Image getiCursor() {
        return iCursor;
    }

    public void toDraw(Graphics g) {
        if (iActuelle == null) {
            g.setColor(this.c);
            g.fillRect(posX, posY, tailleX, tailleY);
        }
        else {
            g.drawImage(iActuelle, posX, posY, null);
        }
    }

    public void changerImage(){
        if (isPressed == true) {
            iActuelle = iOuvert;
        }
        else {
            iActuelle = iFerme;
        }
    }

    public boolean isPressed() {
        return isPressed;
    }

    public Image getiActuelle() {
        return iActuelle;
    }

    public Color getC() {
        return c;
    }

    public Image getiOuvert() {
        return iOuvert;
    }

    public Image getiFerme() {
        return iFerme;
    }

    public int getiCursorTailleX() {
        return iCursorTailleX;
    }

    public int getiCursorTailleY() {
        return iCursorTailleY;
    }
}
