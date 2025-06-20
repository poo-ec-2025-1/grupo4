package control;

import javafx.application.Application;
import javafx.stage.Stage;


public class ControlPrincipal extends Application {

    public void start(Stage primaryStage) {
        ScreenControl.setStage(primaryStage);
        ScreenControl.changeScene("/view/login.fxml");
    }
    public static void main(String[] args){
        launch(args);
    }

}
