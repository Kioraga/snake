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
        Image snake = new Image("file:resources/snake.png");

        Tablero[] tablero = new Tablero[20];
        tablero[0] = new Tablero(30, 60);
        for (int i = 1; i < tablero.length; i++) {
            tablero[i] = new Tablero(tablero[i-1].getX(), tablero[i-1].getY());
        }

        new AnimationTimer() {
            public void handle(long now) {

                /*if (input.contains("W"))
                    y[0] = y[0] - 25;
                if (input.contains("A"))
                    x[0] = x[0] - 25;
                if (input.contains("S"))
                    y[0] = y[0] + 25;
                if (input.contains("D"))
                    x[0] = x[0] + 25;*/

                gc.drawImage(background, 0, 0);
                //gc.drawImage(snake, x[0], y[0]);
            }
        }.start();

        return escena;
    }
}
