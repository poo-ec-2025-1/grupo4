package control;

import javafx.application.Application;
import javafx.stage.Stage;


public class ControlPrincipal extends Application {

    public void start(Stage primaryStage) {
        ScreenControl.setStage1(primaryStage);
        ScreenControl.setStage2(new Stage());
        ScreenControl.changeScene("/view/login.fxml", primaryStage);
    }
    public static void main(String[] args){
        launch(args);
    }

}
