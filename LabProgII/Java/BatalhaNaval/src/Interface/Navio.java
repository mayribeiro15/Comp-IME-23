package Interface;

import javafx.scene.Parent;

public class Navio extends Parent {
    public int type;
    public boolean vertical = true;

    private int health;

    public Navio(int type, boolean vertical) {
        this.type = type;
        this.vertical = vertical;
        health = type;
    }

    public void hit() {
        health--;
    }

    public boolean isAlive() {
        return health > 0;
    }
}