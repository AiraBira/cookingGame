import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

 
public class Main 
{
    public static void main(String[] args) 
    {
                         //       FENETRE        //
        JFrame fenetre = new JFrame("My First Cooking Game !");
        Image blankImage = Toolkit.getDefaultToolkit().createImage(new byte[0]);

        

                     //       CREATION OBJETS        //

        
        //// CHARGEMENT DONNEES  ///// 
        Image fondCuisine = null;
        Image imgLait = null;
        Image imgFraises = null;
        Image imgGlacons = null;
        Image imgSucre = null;

        Image imgLaitPrendre = null;
        Image imgFraisesPrendre = null;
        Image imgGlaconsPrendre = null;
        Image imgSucrePrendre = null;
        

        try {
            fondCuisine = ImageIO.read(Main.class.getResource("ressources/images/fond.png")); // si fond_pixel alors fond moins pixelisé
            imgLait = ImageIO.read(Main.class.getResource("ressources/images/milk.png"));
            imgFraises = ImageIO.read(Main.class.getResource("ressources/images/fraises.png"));
            imgGlacons = ImageIO.read(Main.class.getResource("ressources/images/glacons.png"));
            imgSucre = ImageIO.read(Main.class.getResource("ressources/images/sucre.png"));

            ///////////////////// NE PAS OUBLIER DE CHANGER LES IMAGES DES INGREDIENTS QUAND ILS SONT CLIQUES !!!! /////////////////////
            imgFraisesPrendre = ImageIO.read(Main.class.getResource("ressources/images/fraises.png"));
            imgGlaconsPrendre = ImageIO.read(Main.class.getResource("ressources/images/glacons.png"));
            imgSucrePrendre = ImageIO.read(Main.class.getResource("ressources/images/sucre.png"));
        } catch (IOException e) {
            System.out.println("ATTENTION ERREUR :" + e.getMessage());
        }


        //  CREATION DES CURSEURS // 

        Toolkit toolkit = Toolkit.getDefaultToolkit();  // creation d'une boite à outils pour accéder au curseur

        Image curseurSucre = toolkit.getImage("ressources/images/cuillereSucre.png"); 

        Image curseurFraise = toolkit.getImage("ressources/images/fraisePrises.png");

        Image curseurLait = toolkit.getImage("ressources/images/laitPrendre.png");


        // CREATION DU JEU

        GamePanel gameP1 = new GamePanel(null, fondCuisine);

        /////  Ingrédients cuisine  /////
        int LONGUEUR_OBJETS = 150;
        int LARGEUR_OBJETS = 150;

        Ingredients lait = new Ingredients("lait", 5, 600, LONGUEUR_OBJETS, LARGEUR_OBJETS, imgLait, blankImage, imgLait, curseurLait);
        Ingredients sucre = new Ingredients("sucre", 350, 590, LONGUEUR_OBJETS, LARGEUR_OBJETS, imgSucre, blankImage, imgSucre, curseurSucre);
        Ingredients fraises = new Ingredients("fraises", 60, 690, LONGUEUR_OBJETS, LARGEUR_OBJETS, imgFraises, blankImage, imgFraises, curseurFraise);
        Ingredients glacons = new Ingredients("glaçons", 300, 690, LONGUEUR_OBJETS, LARGEUR_OBJETS, imgGlacons, blankImage, imgGlacons, null);
        //gameObject boutonPause = new gameObject("pause", 930, 30, 100, 100, Color.RED);
        

        /////  Ajout au tableau d'objets de l'instance gamePanel  /////
        
        gameP1.addObjectList(lait);
        gameP1.addObjectList(sucre);
        gameP1.addObjectList(fraises);
        gameP1.addObjectList(glacons);
        //gameP1.addObjectList(boutonPause);
         

        ///// TAILLER LES IMAGES //////
        for (int i = 0; i < gameP1.getListeObjets().size(); i++) {
            if (gameP1.listeObjets.get(i).iActuelle != null) {
                Image copieTailleeA = gameP1.listeObjets.get(i).iActuelle.getScaledInstance(LONGUEUR_OBJETS, LARGEUR_OBJETS, Image.SCALE_SMOOTH);  
                gameP1.listeObjets.get(i).iActuelle = copieTailleeA; 
            }
             if (gameP1.listeObjets.get(i).iFerme != null) {
                Image copieTailleeF = gameP1.listeObjets.get(i).iFerme.getScaledInstance(LONGUEUR_OBJETS, LARGEUR_OBJETS, Image.SCALE_SMOOTH);
                gameP1.listeObjets.get(i).iFerme = copieTailleeF;

            }
            if (gameP1.listeObjets.get(i).iOuvert != null) {
                Image copieTailleeO = gameP1.listeObjets.get(i).iOuvert.getScaledInstance(LONGUEUR_OBJETS, LARGEUR_OBJETS, Image.SCALE_SMOOTH);
                gameP1.listeObjets.get(i).iOuvert = copieTailleeO;
            }
        }

        

                        //       AFFICHAGE        //
        fenetre.add(gameP1);
        fenetre.setSize(540, 960);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
