package game;
import java.awt.*;

import javax.swing.JPanel;

public class StartPanel extends JPanel{
    // Dimensions de la fenêtre
    private final int WIDTH = 540;
    private final int HEIGHT = 960;

    // Dimensions et position du bouton "Start"
    private final int START_BUTTON_WIDTH = 200;
    private final int START_BUTTON_HEIGHT = 80; 
    private final int START_BUTTON_X = (WIDTH - START_BUTTON_WIDTH) / 2; // Centré horizontalement
    private final int START_BUTTON_Y = (HEIGHT - START_BUTTON_HEIGHT) / 2;

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

    protected Image fond;
    protected Image startButton;
    protected Image characterImage; // Ici si possible mettre un gif animé du personnage ?? 


    public StartPanel(Image startButton, Image characterImage) {
        this.startButton = startButton;
        this.characterImage = characterImage;
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
        if (startButton != null) {
            g.drawImage(startButton, START_BUTTON_X, START_BUTTON_Y, START_BUTTON_WIDTH, START_BUTTON_HEIGHT, null);
        }

        // Dessiner l'image du personnage
        if (characterImage != null) {
            g.drawImage(characterImage, CHARACTER_IMAGE_X, CHARACTER_IMAGE_Y, CHARACTER_IMAGE_WIDTH, CHARACTER_IMAGE_HEIGHT, null);
        }
    }


    public Image getFond() {
        return fond;
    }


    public void setFond(Image fond) {
        this.fond = fond;
    }


    public Image getStartButton() {
        return startButton;
    }


    public void setStartButton(Image startButton) {
        this.startButton = startButton;
    }


    public Image getCharacterImage() {
        return characterImage;
    }


    public void setCharacterImage(Image characterImage) {
        this.characterImage = characterImage;
    }
    
}
