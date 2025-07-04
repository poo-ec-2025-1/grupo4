package control;

import com.github.sarxos.webcam.Webcam;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class CameraControl implements Initializable{

    private Webcam webcam;
    @FXML
    private ImageView imageView;
    private volatile boolean cameraAtiva = false;
    private BufferedImage ultimaImagemCapturada;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.setProperty("com.github.sarxos.webcam.driver", "com.github.sarxos.webcam.ds.buildin.WebcamDefaultDriver");
        webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        webcam.open();


        Thread cameraThread = new Thread(() -> {
            while (cameraAtiva || webcam.isOpen()) {
                ultimaImagemCapturada = webcam.getImage();
                if (ultimaImagemCapturada != null) {
                    WritableImage fxImage = SwingFXUtils.toFXImage(ultimaImagemCapturada, null);
                    Platform.runLater(() -> imageView.setImage(fxImage));
                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        cameraAtiva = true;
        cameraThread.setDaemon(true);
        cameraThread.start();
    }
    @FXML
    public void salvarImagemEFechar() {
        try {
            if (ultimaImagemCapturada != null) {
                String foto = nameFoto() + ".png";
                File arquivo = new File(foto);
                ImageIO.write(ultimaImagemCapturada, "PNG", arquivo);
                control.ConferenteControl.fotoEndereco = "file:" + arquivo.getAbsolutePath();
                // Encerra câmera e janela
                cameraAtiva = false;
                webcam.close();
                ScreenControl.stage2.close(); 
            }
        } catch (Exception e) {
            System.err.println("Erro ao salvar imagem: " + e.getMessage());
        }
    }

    public String nameFoto(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd_MM_yyyy-HH_mm_ss");
        String dataHoraString = agora.format(formatador);
        dataHoraString = "_" + dataHoraString;
        return dataHoraString;
    }
}