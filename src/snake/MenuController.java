package snake;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MenuController {

    public void startGame(ActionEvent event) {
        Stage primaryStage = Main.getPrimaryStage();
        primaryStage.setScene(Snake.start());
        primaryStage.show();
    }
}
