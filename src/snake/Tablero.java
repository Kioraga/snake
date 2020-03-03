package snake;

import java.util.ArrayList;

public class Tablero {
    private double x;
    private double y;

    public Tablero() {

    }
    public Tablero(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
}
