package snake;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Snake {

    public static Scene start() {
        Group root = new Group();
        Scene escena = new Scene(root);

        Canvas canvas = new Canvas(560, 590);
        root.getChildren().add(canvas);

        ArrayList<String> input = new ArrayList<>();

        escena.setOnKeyPressed(
                event -> {
                    String code = event.getCode().toString();
                    if (!input.contains(code))
                        input.add(code);
                });

        escena.setOnKeyReleased(
                event -> {
                    String code = event.getCode().toString();
                    input.remove(code);
                });

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image background = new Image("file:resources/background.png");
        Image snakeSp = new Image("file:resources/snake.png");

        Tablero[][] tablero = Tablero.crearTablero();

        final int[] snakeSize = {2};
        final int[] auxSnSize = {0};
        final int[] dir = {4};
        final int[] f = {9};
        final int[] c = {5};
        final double[] x = {tablero[f[0]][c[0]].getX()};
        final double[] y = {tablero[f[0]][c[0]].getY()};
        final double auxX[] = new double[400];
        final double auxY[] = new double[400];

        new AnimationTimer() {
            public void handle(long now) {
                if ((input.contains("W") || input.contains("UP"))  && dir[0] != 3)
                    dir[0] = 1;
                if ((input.contains("A") || input.contains("LEFT")) && dir[0] != 4)
                    dir[0] = 2;
                if ((input.contains("S") || input.contains("DOWN")) && dir[0] != 1)
                    dir[0] = 3;
                if ((input.contains("D") || input.contains("RIGHT")) && dir[0] != 2)
                    dir[0] = 4;

                switch (dir[0]) {
                    case 1:
                        if (f[0] > 0) {
                            f[0] = f[0] - 1;
                            y[0] = tablero[f[0]][c[0]].getY();
                        }
                        break;
                    case 2:
                        if (c[0] > 0) {
                            c[0] = c[0] - 1;
                            x[0] = tablero[f[0]][c[0]].getX();
                        }
                        break;
                    case 3:
                        if (f[0] < 19) {
                            f[0] = f[0] + 1;
                            y[0] = tablero[f[0]][c[0]].getY();
                        }
                        break;
                    case 4:
                        if (c[0] < 19) {
                            c[0] = c[0] + 1;
                            x[0] = tablero[f[0]][c[0]].getX();
                        }
                        break;
                }

                gc.drawImage(background, 0, 0);
                gc.drawImage(snakeSp, x[0], y[0]);

                System.out.println("x: "+x[0]+" | y: "+y[0]);

                for (int i = 0; i < snakeSize[0]-1; i++) {
                    gc.drawImage(snakeSp, auxX[i], auxY[i]);
                }
                for (int i = snakeSize[0]-2; i > 0; i--) {
                    auxX[i] = auxX[i-1];
                    auxY[i] = auxY[i-1];
                }
                auxX[0] = x[0];
                auxY[0] = y[0];

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return escena;
    }

    public void compColisionPared() {
        
    }
}
