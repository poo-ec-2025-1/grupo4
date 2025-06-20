package view;

 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageManagerView extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Scene scene = LoginView.getScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void abrirTela(Scene novaScene) {
        stage.setScene(novaScene);
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
