package game;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;

 
public class Game {
    private final int LONGUEUR_OBJETS = 150;
    private final int LARGEUR_OBJETS = 150;
    private final Image blankImage = Toolkit.getDefaultToolkit().createImage(new byte[0]);

    protected HashMap<String, Image> images;

    private JFrame fenetre;
    private StartPanel menu;
    private GamePanel partie;


    // ETAT DU JEU 
    protected int state = 0; // 0 : menu, 1 : jeu, 2 : pause, 3 : fin


    public Game() {
        fenetre = new JFrame("My First Cooking Game !");
        images = new HashMap<>();
        
        menu = new StartPanel(null, null); // Ici mettre les images du menu (bouton start et image du personnage)

        // CREATION DE LA PARTIE
        creationImages();
        partie = new GamePanel(null, getListImages().get("fondCuisine"));
        creationIngredients(getListImages(), partie);  
        tailleImages(partie.getListeObjets());
    }


    public void start() {
        //getFenetre().add(getMenu());
        getFenetre().add(getPartie());

        getFenetre().setSize(540, 960);
        getFenetre().setVisible(true);
        getFenetre().setResizable(false);
        getFenetre().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void creationImages(){
        
        try {
            Image fondCuisine = ImageIO.read(Game.class.getResource("../ressources/images/fond.png")); // si fond_pixel alors fond moins pixelisé
            images.put("fondCuisine", fondCuisine);
            Image imgLait = ImageIO.read(Game.class.getResource("../ressources/images/milk.png"));
            images.put("imgLait", imgLait);
            Image imgFraises = ImageIO.read(Game.class.getResource("../ressources/images/fraises.png"));
            images.put("imgFraises", imgFraises);
            Image imgGlacons = ImageIO.read(Game.class.getResource("../ressources/images/glacons.png"));
            images.put("imgGlacons", imgGlacons);
            Image imgSucre = ImageIO.read(Game.class.getResource("../ressources/images/sucre.png"));
            images.put("imgSucre", imgSucre);

            ///////////////////// NE PAS OUBLIER DE CHANGER LES IMAGES DES INGREDIENTS QUAND ILS SONT CLIQUES !!!! /////////////////////
            Image imgFraisesPris = ImageIO.read(Game.class.getResource("../ressources/images/fraises.png"));
            images.put("imgFraisesPris", imgFraisesPris);
            Image imgGlaconsPris = ImageIO.read(Game.class.getResource("../ressources/images/glacons.png"));
            images.put("imgGlaconsPris", imgGlaconsPris);
            Image imgSucrePris = ImageIO.read(Game.class.getResource("../ressources/images/sucre.png"));
            images.put("imgSucrePris", imgSucrePris);

            ///     CURSEURS    ////
            Image curseurSucre = ImageIO.read(Game.class.getResource("../ressources/images/cuillereSucre.png")); 
            images.put("curseurSucre", curseurSucre);
            Image curseurFraise = ImageIO.read(Game.class.getResource("../ressources/images/fraisePrises.png"));
            images.put("curseurFraise", curseurFraise);
            Image curseurLait = ImageIO.read(Game.class.getResource("../ressources/images/laitPrendre.png"));
            images.put("curseurLait", curseurLait);

        } catch (IOException e) {
            System.out.println("ATTENTION ERREUR :" + e.getMessage());
        }
    }


    public void creationIngredients(HashMap<String, Image> images, GamePanel partie){

        Ingredients lait = new Ingredients("lait", 5, 600, LONGUEUR_OBJETS, LARGEUR_OBJETS, getListImages().get("imgLait"), blankImage, getListImages().get("imgLait"), getListImages().get("curseurLait"), 140, 140);
        Ingredients sucre = new Ingredients("sucre", 350, 590, LONGUEUR_OBJETS, LARGEUR_OBJETS, getListImages().get("imgSucre"), blankImage, getListImages().get("imgSucre"), getListImages().get("curseurSucre"), 140, 140);
        Ingredients fraises = new Ingredients("fraises", 60, 690, LONGUEUR_OBJETS, LARGEUR_OBJETS, getListImages().get("imgFraises"), blankImage, getListImages().get("imgFraises"), getListImages().get("curseurFraise"), 90, 90);
        Ingredients glacons = new Ingredients("glaçons", 300, 690, LONGUEUR_OBJETS, LARGEUR_OBJETS, getListImages().get("imgGlacons"), blankImage, getListImages().get("imgGlacons"), null, 100, 100);
      
        partie.addObjectList(lait);
        partie.addObjectList(sucre);
        partie.addObjectList(fraises);
        partie.addObjectList(glacons);
    }


    public void tailleImages(ArrayList<GameObject> listeObjets){
        ///// TAILLER LES IMAGES //////
        for (int i = 0; i < listeObjets.size(); i++) {
            if (listeObjets.get(i).iActuelle != null) {
                Image copieTailleeA = listeObjets.get(i).iActuelle.getScaledInstance(LONGUEUR_OBJETS, LARGEUR_OBJETS, Image.SCALE_SMOOTH);  
                listeObjets.get(i).iActuelle = copieTailleeA; 
            }
             if (listeObjets.get(i).iFerme != null) {
                Image copieTailleeF = listeObjets.get(i).iFerme.getScaledInstance(LONGUEUR_OBJETS, LARGEUR_OBJETS, Image.SCALE_SMOOTH);
                listeObjets.get(i).iFerme = copieTailleeF;

            }
            if (listeObjets.get(i).iOuvert != null) {
                Image copieTailleeO = listeObjets.get(i).iOuvert.getScaledInstance(LONGUEUR_OBJETS, LARGEUR_OBJETS, Image.SCALE_SMOOTH);
                listeObjets.get(i).iOuvert = copieTailleeO;
            }
        }
    }


    public int getLONGUEUR_OBJETS() {
        return LONGUEUR_OBJETS;
    }

    public int getLARGEUR_OBJETS() {
        return LARGEUR_OBJETS;
    }

    public Image getBlankImage() {
        return blankImage;
    }

    public HashMap<String, Image> getListImages() {
        return images;
    }

    public int getState() {
        return state;
    }


    public HashMap<String, Image> getImages() {
        return images;
    }


    public JFrame getFenetre() {
        return fenetre;
    }


    public StartPanel getMenu() {
        return menu;
    }


    public GamePanel getPartie() {
        return partie;
    }
}
