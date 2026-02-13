package game;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;


public class StartPanel extends JPanel implements MouseListener, MouseMotionListener{
    // Dimensions de la fenêtre
    private final int WIDTH = 540;
    private final int HEIGHT = 960;

    // Dimensions et position du bouton "Start"
    private final int START_BUTTON_WIDTH = 200;
    private final int START_BUTTON_HEIGHT = 80; 
    private final int START_BUTTON_X = (WIDTH - START_BUTTON_WIDTH) / 2; // Centré horizontalement
    private final int START_BUTTON_Y = (1400 - START_BUTTON_HEIGHT) / 2;
    private boolean isStartButtonClicked = false; // Variable pour suivre l'état du bouton "Start"

    private final int MUSIC_BUTTON_WIDTH = 200;
    private final int MUSIC_BUTTON_HEIGHT = 80; 
    private final int MUSIC_BUTTON_X = (WIDTH - MUSIC_BUTTON_WIDTH + 200) / 2; // Centré horizontalement
    private final int MUSIC_BUTTON_Y = (HEIGHT - MUSIC_BUTTON_HEIGHT) / 2;

    private final int CERCLE_DIAMETER = 600;
    private final int CERCLE_X = (0 - CERCLE_DIAMETER/4);
    private final int CERCLE_Y = (WIDTH/2 - CERCLE_DIAMETER/3);

    // Dimensions et position de l'image du personnage
    private final int CHARACTER_IMAGE_WIDTH = 150;
    private final int CHARACTER_IMAGE_HEIGHT = 150;
    private final int CHARACTER_IMAGE_X = (WIDTH - CHARACTER_IMAGE_WIDTH) / 2; // Centré horizontalement
    private final int CHARACTER_IMAGE_Y = START_BUTTON_Y - CHARACTER_IMAGE_HEIGHT - 20;
    
    private final Color BACKGROUND_COLOR = new Color(250, 128, 114); // Couleur de fond

    protected static Image FOND;
    protected static Image START_BUTTON;
    protected static Image PERSONNAGE_IMAGE; // Ici si possible mettre un gif animé du personnage ?? 


    static { // Code se lancant une seule fois lors du chargement de la classe
        try {
            START_BUTTON = ImageIO.read(new File("ressources/images/play_button_prototype.png"));
        } catch (IOException e) {
            System.out.println("ATTENTION ERREUR :" + e.getMessage());
        }
    }


    public StartPanel() {
    // C'est cette ligne qui permet de détecter les clics !
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
}
       
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX() >= START_BUTTON_X &&
            e.getX() <= (START_BUTTON_X + START_BUTTON_WIDTH) &&
            e.getY() >= START_BUTTON_Y &&
            e.getY() <= (START_BUTTON_Y + START_BUTTON_HEIGHT)) { 
            
            isStartButtonClicked = true; // Le bouton "Start" a été cliqué
        }

        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) { // Permet d'afficher tous les objets
        super.paintComponent(g); // nettoie le panneau
        // Dessiner le fond
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Cercle blanc au centre
        g.setColor(Color.WHITE);
        g.fillOval(CERCLE_X, CERCLE_Y, CERCLE_DIAMETER, CERCLE_DIAMETER);


        // Dessiner le bouton "Start"
        if (START_BUTTON != null) {
            g.drawImage(START_BUTTON, START_BUTTON_X, START_BUTTON_Y, START_BUTTON_WIDTH, START_BUTTON_HEIGHT, null);
        }

        // Dessiner l'image du personnage
        if (PERSONNAGE_IMAGE != null) {
            g.drawImage(PERSONNAGE_IMAGE, CHARACTER_IMAGE_X, CHARACTER_IMAGE_Y, CHARACTER_IMAGE_WIDTH, CHARACTER_IMAGE_HEIGHT, null);
        }
    }


    public Image getFond() {
        return FOND;
    }


    public void setFond(Image fond) {
        this.FOND = FOND;
    }


    public Image getStartButton() {
        return START_BUTTON;
    }


    public void setStartButton(Image startButton) {
        this.START_BUTTON = START_BUTTON;
    }


    public Image getCharacterImage() {
        return PERSONNAGE_IMAGE;
    }


    public void setCharacterImage(Image characterImage) {
        this.PERSONNAGE_IMAGE = PERSONNAGE_IMAGE;
    }


    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseDragged(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}

    public int getWIDTH() {
        return WIDTH;
    }


    public int getHEIGHT() {
        return HEIGHT;
    }


    public int getSTART_BUTTON_WIDTH() {
        return START_BUTTON_WIDTH;
    }


    public int getSTART_BUTTON_HEIGHT() {
        return START_BUTTON_HEIGHT;
    }


    public int getSTART_BUTTON_X() {
        return START_BUTTON_X;
    }


    public int getSTART_BUTTON_Y() {
        return START_BUTTON_Y;
    }


    public boolean isStartButtonClicked() {
        return isStartButtonClicked;
    }


    public int getMUSIC_BUTTON_WIDTH() {
        return MUSIC_BUTTON_WIDTH;
    }


    public int getMUSIC_BUTTON_HEIGHT() {
        return MUSIC_BUTTON_HEIGHT;
    }


    public int getMUSIC_BUTTON_X() {
        return MUSIC_BUTTON_X;
    }


    public int getMUSIC_BUTTON_Y() {
        return MUSIC_BUTTON_Y;
    }


    public int getCERCLE_DIAMETER() {
        return CERCLE_DIAMETER;
    }


    public int getCERCLE_X() {
        return CERCLE_X;
    }


    public int getCERCLE_Y() {
        return CERCLE_Y;
    }


    public int getCHARACTER_IMAGE_WIDTH() {
        return CHARACTER_IMAGE_WIDTH;
    }


    public int getCHARACTER_IMAGE_HEIGHT() {
        return CHARACTER_IMAGE_HEIGHT;
    }


    public int getCHARACTER_IMAGE_X() {
        return CHARACTER_IMAGE_X;
    }


    public int getCHARACTER_IMAGE_Y() {
        return CHARACTER_IMAGE_Y;
    }


    public Color getBACKGROUND_COLOR() {
        return BACKGROUND_COLOR;
    }


    public static Image getFOND() {
        return FOND;
    }


    public static Image getSTART_BUTTON() {
        return START_BUTTON;
    }


    public static Image getPERSONNAGE_IMAGE() {
        return PERSONNAGE_IMAGE;
    }
    
}
