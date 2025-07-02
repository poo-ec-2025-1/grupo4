package control;

import com.github.sarxos.webcam.Webcam;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class CameraControl implements Initializable {

    private Webcam webcam;

    @FXML
    private ImageView imageView;

    @FXML
    private Button btnInverter;

    private volatile boolean cameraAtiva = false;
    private BufferedImage ultimaImagemCapturada;
    private boolean precisaGirar = false;

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
                    BufferedImage imgParaMostrar = precisaGirar
                            ? girar180(ultimaImagemCapturada)
                            : ultimaImagemCapturada;

                    WritableImage fxImage = SwingFXUtils.toFXImage(imgParaMostrar, null);
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
    private void inverterImagem() {
        precisaGirar = !precisaGirar;
        System.out.println("Inverter imagem? " + precisaGirar);
    }

    @FXML
    public void salvarImagemEFechar() {
        try {
            if (ultimaImagemCapturada != null) {
                BufferedImage imagemCorrigida = precisaGirar
                        ? girar180(ultimaImagemCapturada)
                        : ultimaImagemCapturada;

                WritableImage fxImage = SwingFXUtils.toFXImage(imagemCorrigida, null);
                Platform.runLater(() -> imageView.setImage(fxImage));

                String foto = nameFoto() + ".png";
                File arquivo = new File(foto);
                ImageIO.write(imagemCorrigida, "PNG", arquivo);

                control.ConferenteControl.fotoEndereco = "file:" + arquivo.getAbsolutePath();

                cameraAtiva = false;
                webcam.close();
                ScreenControl.stage2.close();
            }
        } catch (Exception e) {
            System.err.println("Erro ao salvar imagem: " + e.getMessage());
        }
    }

    public String nameFoto() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd_MM_yyyy-HH_mm_ss");
        return "_" + agora.format(formatador);
    }

    public BufferedImage girar180(BufferedImage imagemOriginal) {
        BufferedImage imagem = new BufferedImage(
                imagemOriginal.getWidth(),
                imagemOriginal.getHeight(),
                BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D g = imagem.createGraphics();
        g.drawImage(imagemOriginal, 0, 0, null);
        g.dispose();

        AffineTransform at = AffineTransform.getRotateInstance(
                Math.PI,
                imagem.getWidth() / 2.0,
                imagem.getHeight() / 2.0
        );
        AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(imagem, null);
    }
}
