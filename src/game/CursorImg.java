package game;
import java.awt.*;

public class CursorImg {

    protected int posX;
    protected int posY;
    protected int tailleX;
    protected int tailleY;
    protected Image cursor;

    public CursorImg(int posX, int posY, int tailleX, int tailleY, Image cursor) {
        this.posX = posX;
        this.posY = posY;
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.cursor = cursor;
    }
    
    public void setCursor(Image cursor) {
        this.cursor = cursor;
    }

    public void toDraw(Graphics g) {
        if (cursor != null) {
            g.drawImage(cursor, posX, posY, tailleX, tailleY, null);
        }
    }


    public int getPosX() {
        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public int getPosY() {
        return posY;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public int getTailleX() {
        return tailleX;
    }
    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }
    public int getTailleY() {
        return tailleY;
    }
    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }
    public Image getCursor() {
        return cursor;
    }
    
    
}
