package snake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage pStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Snake by dcancelas");
        primaryStage.setScene(Main.titleScreen(false));
        primaryStage.setResizable(false);
        primaryStage.show();

        pStage = primaryStage;
    }

    public static Scene titleScreen(boolean start) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("menu.fxml"));
        if (start)
            return new Scene(root, 550, 580);
        else
            return new Scene(root, 560, 590);
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }
}
