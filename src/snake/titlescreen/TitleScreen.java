package snake.titlescreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import snake.Main;
import snake.Snake;

import java.io.IOException;

public class TitleScreen {

    public void startGame(ActionEvent event) {
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setScene(Snake.start());
        primaryStage.show();
    }
    public void goToOpciones(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("titlescreen/options.fxml"));
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setScene(new Scene(root, 560, 590));
    }
}
