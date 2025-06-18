package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.File;
import java.net.URL;

public class LoginView {

    public static Scene getScene() {
        try {
            URL url = new File("login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            return new Scene(root);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
