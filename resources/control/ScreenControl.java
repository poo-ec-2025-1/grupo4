package control;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenControl {
    public static Stage stage1;
    public static Stage stage2;

    public static void setStage1(Stage s) {
        stage1 = s;
    }

    public static void setStage2(Stage s) {
        stage2 = s;
    }

    public static void changeScene(String fxml, Stage stage) {
        try {
            Parent root = FXMLLoader.load(ScreenControl.class.getResource(fxml));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
