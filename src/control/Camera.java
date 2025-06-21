package control;

import com.github.sarxos.webcam.Webcam;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;

public class Camera extends Application {

    private Webcam webcam;
    private ImageView imageView = new ImageView();
    private volatile boolean cameraAtiva = false;

    @Override
    public void start(Stage stage) {
        Button abrirCameraBtn = new Button("Abrir câmera");

        abrirCameraBtn.setOnAction(e -> {
            if (!cameraAtiva) {
                iniciarCamera();
                cameraAtiva = true;
            }
        });

        VBox root = new VBox(10, abrirCameraBtn, imageView);
        Scene scene = new Scene(root, 640, 520);
        stage.setTitle("Webcam JavaFX Simples");
        stage.setScene(scene);
        stage.show();
    }

    private void iniciarCamera() {
        webcam = Webcam.getDefault();
        webcam.open();

        // Thread para capturar continuamente
        Thread cameraThread = new Thread(() -> {
            while (cameraAtiva) {
                BufferedImage image = webcam.getImage();
                if (image != null) {
                    WritableImage fxImage = SwingFXUtils.toFXImage(image, null);
                    Platform.runLater(() -> imageView.setImage(fxImage));
                }
                try {
                    Thread.sleep(30); // ~30 FPS
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        cameraThread.setDaemon(true);
        cameraThread.start();
    }

    @Override
    public void stop() {
        cameraAtiva = false;
        if (webcam != null && webcam.isOpen()) {
            webcam.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
