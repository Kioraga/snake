package snake;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MenuController {

    public void startGame(ActionEvent event) {
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(Snake.start());
        primaryStage.show();
    }
}
