package snake.titlescreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import snake.Main;
import snake.Snake;

public class Options {

    public Button bFacil;
    public Button bNormal;
    public Button bDificil;

    public static int facil = 170;
    public static int normal = 120;
    public static int dificil = 70;

    public void dificultadFacil(ActionEvent event) {
        Snake.setDificultad(facil);
        initialize();
    }
    public void dificultadNormal(ActionEvent event) {
        Snake.setDificultad(normal);
        initialize();
    }
    public void dificultadDificil(ActionEvent event) {
        Snake.setDificultad(dificil);
        initialize();
    }

    public void goToTitleScreen(ActionEvent event) throws Exception {
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setScene(Main.titleScreen(false));
        primaryStage.show();
    }

    @FXML
    public void initialize() {
        if (Snake.getDificultad() == facil) {
            bFacil.setDisable(true);
            bNormal.setDisable(false);
            bDificil.setDisable(false);
        }
        if (Snake.getDificultad() == normal) {
            bNormal.setDisable(true);
            bFacil.setDisable(false);
            bDificil.setDisable(false);
        }
        if (Snake.getDificultad() == dificil) {
            bDificil.setDisable(true);
            bFacil.setDisable(false);
            bNormal.setDisable(false);
        }
    }
}