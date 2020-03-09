package snake;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
        Image food = new Image("file:resources/food.png");

        Tablero[][] tablero = Tablero.crearTablero();

        final int[] snakeSize = {2};
        final boolean[] foodGen = {true};
        final int[] dir = {4};
        final int[] f = {11};
        final int[] c = {7};
        final int[] fComida = {0};
        final int[] cComida = {0};
        final double[] x = {tablero[f[0]][c[0]].getX()};
        final double[] y = {tablero[f[0]][c[0]].getY()};
        final double auxX[] = new double[400];
        final double auxY[] = new double[400];

        new AnimationTimer() {
            public void handle(long now) {
                //Comprueba la tecla pulsada y establece la dirección
                if ((input.contains("W") || input.contains("UP"))  && dir[0] != 3)
                    dir[0] = 1;
                if ((input.contains("A") || input.contains("LEFT")) && dir[0] != 4)
                    dir[0] = 2;
                if ((input.contains("S") || input.contains("DOWN")) && dir[0] != 1)
                    dir[0] = 3;
                if ((input.contains("D") || input.contains("RIGHT")) && dir[0] != 2)
                    dir[0] = 4;

                //Comprueba la dirección y actualiza la cordenada correspondiente
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
                        if (f[0] < 21) {
                            f[0] = f[0] + 1;
                            y[0] = tablero[f[0]][c[0]].getY();
                        }
                        break;
                    case 4:
                        if (c[0] < 21) {
                            c[0] = c[0] + 1;
                            x[0] = tablero[f[0]][c[0]].getX();
                        }
                        break;
                }

                //Dibuja el fondo
                gc.drawImage(background, 0, 0);

                //Dibuja la comida en una casilla aleatoria
                if (foodGen[0]) {
                    fComida[0] = (int) ((Math.random() * 19) + 1);
                    cComida[0] = (int) ((Math.random() * 19) + 1);
                }
                gc.drawImage(food, tablero[fComida[0]][cComida[0]].getX(), tablero[fComida[0]][cComida[0]].getY());
                foodGen[0] = false;

                //Dibuja el bloque principal de la seroiente
                gc.drawImage(snakeSp, x[0], y[0]);

                //Dibuja el resto de bloques que forman la serpiente a partir de la variable "snakeSize"
                for (int i = 0; i < snakeSize[0]-1; i++) {
                    gc.drawImage(snakeSp, auxX[i], auxY[i]);
                }
                for (int i = snakeSize[0]-2; i > 0; i--) {
                    auxX[i] = auxX[i-1];
                    auxY[i] = auxY[i-1];
                }
                auxX[0] = x[0];
                auxY[0] = y[0];

                //Muestra las cordenadas actuales
                System.out.println("x: "+x[0]+" | y: "+y[0]);

                //Aumenta el tamaño de la serpiente al comer
                if (Snake.comer(fComida, cComida, x, y, tablero)) {
                    snakeSize[0]++;
                    foodGen[0] = true;
                }

                //Detiene el AnimationTimer si se cumplen las condiciones
                if (Snake.colisionPared(x, y) || Snake.colisionSnake(x, y, auxX, auxY, snakeSize)) {
                    try {
                        Snake.goToTitleScreen();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    stop();
                }

                //Establece el tiempo de espera entre las ejecuciones del bucle
                try {
                    Thread.sleep(150); //200
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return escena;
    }

    public static boolean comer(int[] fComida, int[] cComida, double[] x, double[] y, Tablero[][] tablero) {
        double xComida = tablero[fComida[0]][cComida[0]].getX();
        double yComida = tablero[fComida[0]][cComida[0]].getY();

        if (xComida == x[0] && yComida == y[0]) {
            return true;
        }
        return false;
    }

    public static boolean colisionSnake(double[] x, double[] y, double[] auxX, double[] auxY, int[] snakeSize) {
        for (int i = 1; i < snakeSize[0]-1; i++) {
            if (x[0] == auxX[i] && y[0] == auxY[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean colisionPared(double[] x, double[] y) {
        if (x[0] < 30 || y[0] < 60 || x[0] > 505 || y[0] > 535) {
            return true;
        }
        return false;
    }

    public static void goToTitleScreen() throws Exception {
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setScene(Main.titleScreen());
        primaryStage.show();
    }
}
