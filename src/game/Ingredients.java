package game;
import java.awt.*;

public class Ingredients extends GameObject { 

    public Ingredients(String nom,
                       int posX,
                       int posY,
                       int tailleX,
                       int tailleY,
                       Object colorOuImage,
                       Image iPrendre,
                       Image iFerme,
                       Image iCursor,
                       int iCursorTailleX,
                       int iCursorTailleY) {


        super(nom,
              posX,
              posY,
              tailleX,
              tailleY,
              colorOuImage,
              iPrendre,
              iFerme,
              iCursor,
              iCursorTailleX,
              iCursorTailleY);
        }
    
}
