package snake;

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

    public static Tablero[][] crearTablero() {
        Tablero[][] tablero = new Tablero[20][20];

        double iX = 30;
        double iY = 60;
        for (int i = 0; i < 20; i++) {
            tablero[i][0] = new Tablero(iX, iY);
            for (int j = 1; j < 20; j++) {
                tablero[i][j] = new Tablero(tablero[i][j-1].getX()+25, iY);
            }
            iY = iY + 25;
        }

        return tablero;
    }

    public static void mostrarTablero(Tablero[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j].getX()+" "+tablero[i][j].getY()+" , ");
            }
            System.out.println("");
        }
    }
}
