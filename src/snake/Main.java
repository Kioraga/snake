package snake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage pStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image("file:resources/snake_icon/snake_icon.png"));
        primaryStage.setTitle("Snake");
        primaryStage.setScene(Main.titleScreen(false));
        primaryStage.setResizable(false);
        primaryStage.show();

        pStage = primaryStage;
    }

    public static Scene titleScreen(boolean start) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("titlescreen/titleScreen.fxml"));
        if (start)
            return new Scene(root, 550, 580);
        else
            return new Scene(root, 560, 590);
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }
}
