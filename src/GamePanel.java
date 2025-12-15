import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GamePanel extends JPanel implements MouseListener {
    protected gameObject[] listeObjets;
    protected int nbrElements;
    protected Image fondCuisine;
    protected gameObject objetClick;

    public GamePanel(gameObject objetClick, Image fondCuisine) {
        super();
        this.listeObjets = new gameObject[1];
        this.objetClick = objetClick;
        this.nbrElements = 0;
        this.addMouseListener(this);
        this.fondCuisine = fondCuisine;

    }

    @Override
    public void mousePressed(MouseEvent e) {

        for (int i = 0; i < nbrObjets(); i++) { // Attention car les x et y commencent en haut à gauche de l'image et
                                                // pas au centre !
            if (e.getX() >= listeObjets[i].posX && e.getX() <= (listeObjets[i].posX + listeObjets[i].tailleX)
                && e.getY() >= listeObjets[i].posY && e.getY() <= (listeObjets[i].posY + listeObjets[i].tailleY)) {
               
                listeObjets[i].isPressed = true; 
                listeObjets[i].changerImage(); // Elle utilise une image préparée dans l'objet pour quand on appui
                    
                setCursor(listeObjets[i].getCursor()); // Met en place le curseur crée spécialement pour l'ingrédient touché
                break;
            } 

            else {
                listeObjets[i].isPressed = false;
            }       
        }
        repaint(); // force le redraw immédiat

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setCursor(Cursor.getDefaultCursor());
        for (int i = 0; i < nbrObjets(); i++) {
            listeObjets[i].isPressed = false;
            listeObjets[i].changerImage();
            
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    public Image getFondCuisine() {
        return fondCuisine;
    }

    public gameObject[] getListeObjets() {
        return listeObjets;
    }

    public gameObject getObjetClick() {
        return objetClick;
    }

    public int nbrObjets() {
        return nbrElements;
    }

    public void addObjectList(gameObject o) { // Ajoute un objet à la liste d'objets. La liste est dynamique,
                                              // elle s'adapte toute seule quand elle n'a plus de place.
        if (nbrElements < listeObjets.length) {
            listeObjets[nbrElements] = o;
            nbrElements++;
        } else {
            gameObject[] nouvelleListeObjets = new gameObject[listeObjets.length * 2];
            for (int i = 0; i < listeObjets.length; i++) {
                nouvelleListeObjets[i] = listeObjets[i];
            }
            nouvelleListeObjets[listeObjets.length] = o;

            listeObjets = nouvelleListeObjets;
            nbrElements++;

        }

    }

    public void toDrawAll(Graphics g) { /// Dessine tous les objets d'un coup
        for (int i = 0; i < nbrElements; i++) {
            listeObjets[i].toDraw(g);
        }
    }

    @Override
    protected void paintComponent(Graphics g) { // Permet d'afficher tous les objets
        super.paintComponent(g); // nettoie le panneau
        if (fondCuisine != null) { // dessine le fond
            Image copieTaillée = fondCuisine.getScaledInstance(540, 960, Image.SCALE_SMOOTH);
            g.drawImage(copieTaillée, 0, 0, null);
        }
        toDrawAll(g); // dessine tous les objets
    }

}
