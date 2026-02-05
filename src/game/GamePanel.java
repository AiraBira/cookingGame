package game;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener {
    protected ArrayList<GameObject> listeObjets;
    protected Image fondCuisine;
    protected GameObject objetClick;
    protected CursorImg cursorImg;

    // Créer une image vide pour le curseur invisible
    private final Image CURSORIMGBLANK = Toolkit.getDefaultToolkit().createImage(new byte[0]);
    // Créer le curseur invisible
    private final Cursor BLANKCURSOR = Toolkit.getDefaultToolkit().createCustomCursor(
                    CURSORIMGBLANK, new Point(0, 0), "blank cursor");


    public GamePanel(GameObject objetClick, Image fondCuisine) {
        super();
        this.listeObjets = new ArrayList<>();
        this.objetClick = objetClick;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.fondCuisine = fondCuisine;
        this.cursorImg = new CursorImg(0,0,150,150,CURSORIMGBLANK);
    }

    @Override
    public void mousePressed(MouseEvent e) {

        for (int i = 0; i < nbrObjets(); i++) { // Attention car les x et y commencent en haut à gauche de l'image et
                                                // pas au centre !
            if (e.getX() >= listeObjets.get(i).posX && e.getX() <= (listeObjets.get(i).posX + listeObjets.get(i).tailleX)
                && e.getY() >= listeObjets.get(i).posY && e.getY() <= (listeObjets.get(i).posY + listeObjets.get(i).tailleY)) {
               
                listeObjets.get(i).isPressed = true; 
                listeObjets.get(i).changerImage(); // Elle utilise une image préparée dans l'objet pour quand on appui
                    
                // Crée un curseur invisible pour "cacher" le curseur système
                setCursor(BLANKCURSOR);
                cursorImg.setCursor(listeObjets.get(i).iCursor); // Met à jour l'image du curseur flottant 
                
                // recentrer l'image flottante autour du point de clic
                cursorImg.setTailleX(listeObjets.get(i).iCursorTailleX);
                cursorImg.setTailleY(listeObjets.get(i).iCursorTailleY);
                cursorImg.setPosX(e.getX() - cursorImg.getTailleX()/2);
                cursorImg.setPosY(e.getY() - cursorImg.getTailleY()/2);
                
                break;
            } 

            else {
                listeObjets.get(i).isPressed = false;
            }       
        }
        repaint(); // force le redraw immédiat

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        cursorImg.setCursor(CURSORIMGBLANK); // Si on relache, on remet le curseur invisible
        setCursor(Cursor.getDefaultCursor());
        for (int i = 0; i < nbrObjets(); i++) {
            listeObjets.get(i).isPressed = false;
            listeObjets.get(i).changerImage();
            
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

    @Override
    public void mouseMoved(MouseEvent e) {
        // déplacer l'image flottante pour suivre la souris (centrée)
        cursorImg.setPosX(e.getX() - cursorImg.getTailleX()/2);
        cursorImg.setPosY(e.getY() - cursorImg.getTailleY()/2);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }


    public Image getFondCuisine() {
        return fondCuisine;
    }

    public ArrayList<GameObject> getListeObjets() {
        return listeObjets;
    }

    public GameObject getObjetClick() {
        return objetClick;
    }

    public int nbrObjets() {
        return listeObjets.size();
    }

    public void addObjectList(GameObject o) { // Ajoute un objet à la liste d'objets. La liste est dynamique,
                                              // elle s'adapte toute seule quand elle n'a plus de place.
        listeObjets.add(o);
    }

    public void toDrawAll(Graphics g) { /// Dessine tous les objets d'un coup
        for (GameObject obj : listeObjets) {
            obj.toDraw(g);
        }
        // Dessine le curseur flottant au-dessus de tous les objets
        if (cursorImg != null) cursorImg.toDraw(g);
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
