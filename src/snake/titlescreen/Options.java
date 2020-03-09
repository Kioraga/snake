package snake.titlescreen;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import snake.Main;

public class Options {

    public Button easyDifficulty;
    public Button normalDifficulty;
    public Button hardDifficulty;


    public void goToTitleScreen(ActionEvent event) throws Exception {
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setScene(Main.titleScreen(false));
        primaryStage.show();
    }
}