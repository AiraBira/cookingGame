package game;

import java.awt.Image;
import java.util.List;

public class InteractifObject extends GameObject {
    private boolean animationEnCours;
    private int numAnimationEnCours; // Commence à 0, et correspond à l'index de l'animation en cours dans la liste
                                     // d'animations
    private int animationIndex = 0;
    private List<List<Image>> animations;

    public InteractifObject(String nom, int posX, int posY,
            int tailleX, int tailleY, List<List<Image>> animations) {

        super(nom, posX, posY, tailleX, tailleY, animations.get(0).get(0), animations.get(0).get(2),
                animations.get(0).get(0),
                null, 0, 0);

        if (animations == null || animations.size() < 3) {
            throw new IllegalArgumentException("animations must contain at least 3 images");
        }

        animationEnCours = false;
        this.animations = animations;
    }

    public void interact() {
        if (animations == null || animations.isEmpty())
            return;

        int idx = getAnimationIndex();
        if (idx < 0)
            idx = 0;

        if (isPressed()) { // si l'objet est pressé, on lance l'animation, s'il ne l'est pas, il laisse
                           // l'animation
                           // se dérouler jusqu'à la fin si y'en a une en cours
            animationEnCours = true;
        }

        animationSuivante();
    }


    /**
     * Permet de passer à l'image suivante de l'animation en cours, et de mettre à jour le statut de
     * l'animation (en cours ou terminée)
     */
    public void animationSuivante() {
        if (isAnimationEnCours()) {
            List<Image> animCourante = animations.get(numAnimationEnCours);
            int idx = getAnimationIndex();
            if (idx + 1 < animCourante.size()) { // on met à jour l'image pour la prochaine étape de l'animation
                iActuelle = animCourante.get(idx + 1);
                animationIndex++;
            } else { // si on arrive à la fin de l'animation, on reste sur la dernière image de
                     // l'animation
                animationEnCours = false;
            }
        }
    }

    /**
     * Permet de choisir quelle animation jouer (par son index)
     * et de la relancer depuis le début.
     */
    public void setAnimation(int index) {
        if (index >= 0 && index < animations.size()) {
            numAnimationEnCours = index;
            animationIndex = 0;
            if (!animations.get(index).isEmpty()) {
                iActuelle = animations.get(index).get(0);
            }
        }
    }

    public boolean isAnimationEnCours() {
        return animationEnCours;
    }

    public int getAnimationIndex() {
        return animationIndex;
    }

    public List<List<Image>> getAnimations() {
        return animations;
    }
}
