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
            imgLaitPrendre = ImageIO.read(Main.class.getResource("ressources/images/milk.png"));
            imgFraisesPrendre = ImageIO.read(Main.class.getResource("ressources/images/fraises.png"));
            imgGlaconsPrendre = ImageIO.read(Main.class.getResource("ressources/images/glacons.png"));
            imgSucrePrendre = ImageIO.read(Main.class.getResource("ressources/images/sucre.png"));
        } catch (IOException e) {
            System.out.println("ATTENTION ERREUR :" + e.getMessage());
        }


        //  CREATION DES CURSEURS // 

        Toolkit toolkit = Toolkit.getDefaultToolkit();  // creation d'une boite à outils pour accéder au curseur

        Image imageCuillere = toolkit.getImage("ressources/images/cuillereSucre.png"); 
        Cursor curseurSucre = toolkit.createCustomCursor(imageCuillere, new Point(0, 0), "cuillereSucre");

        Image imageFraisesPrendre = toolkit.getImage("ressources/images/fraisePrises.png");
        Cursor curseurFraise = toolkit.createCustomCursor(imageFraisesPrendre, new Point(0, 0), "fraisePrendre");

        Image imageLaitPrendre = toolkit.getImage("ressources/images/laitPrendre.png");
        Cursor curseurLait = toolkit.createCustomCursor(imageLaitPrendre, new Point(0, 0), "laitPrendre");


        // CREATION DU JEU

        GamePanel gameP1 = new GamePanel(null, fondCuisine);

        /////  Ingrédients cuisine  /////
        int LONGUEUR_OBJETS = 150;
        int LARGEUR_OBJETS = 150;

        Ingredients lait = new Ingredients("lait", 5, 600, LONGUEUR_OBJETS, LARGEUR_OBJETS, imgLait, imgLaitPrendre, imgLait, curseurLait);
        Ingredients sucre = new Ingredients("sucre", 350, 590, LONGUEUR_OBJETS, LARGEUR_OBJETS, imgSucre, imgSucrePrendre, imgSucre, curseurSucre);
        Ingredients fraises = new Ingredients("fraises", 60, 690, LONGUEUR_OBJETS, LARGEUR_OBJETS, imgFraises, imgFraisesPrendre, imgFraises, curseurFraise);
        Ingredients glacons = new Ingredients("glaçons", 300, 690, LONGUEUR_OBJETS, LARGEUR_OBJETS, imgGlacons, imgGlaconsPrendre, imgGlacons, null);
        //gameObject boutonPause = new gameObject("pause", 930, 30, 100, 100, Color.RED);
        

        /////  Ajout au tableau d'objets de l'instance gamePanel  /////
        
        gameP1.addObjectList(lait);
        gameP1.addObjectList(sucre);
        gameP1.addObjectList(fraises);
        gameP1.addObjectList(glacons);
        //gameP1.addObjectList(boutonPause);
         

        ///// TAILLER LES IMAGES //////
        for (int i = 0; i < gameP1.nbrElements; i++) {
            if (gameP1.listeObjets[i].iActuelle != null) {
                Image copieTailleeA = gameP1.listeObjets[i].iActuelle.getScaledInstance(LONGUEUR_OBJETS, LARGEUR_OBJETS, Image.SCALE_SMOOTH);  
                gameP1.listeObjets[i].iActuelle = copieTailleeA; 
            }
             if (gameP1.listeObjets[i].iFerme != null) {
                Image copieTailleeF = gameP1.listeObjets[i].iFerme.getScaledInstance(LONGUEUR_OBJETS, LARGEUR_OBJETS, Image.SCALE_SMOOTH);
                gameP1.listeObjets[i].iFerme = copieTailleeF;

            }
            if (gameP1.listeObjets[i].iOuvert != null) {
                Image copieTailleeO = gameP1.listeObjets[i].iOuvert.getScaledInstance(LONGUEUR_OBJETS, LARGEUR_OBJETS, Image.SCALE_SMOOTH);
                gameP1.listeObjets[i].iOuvert = copieTailleeO;
            }
        }

        

                        //       AFFICHAGE        //
        fenetre.add(gameP1);
        fenetre.setSize(540, 960);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
