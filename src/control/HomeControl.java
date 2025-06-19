package control;

import javafx.fxml.FXML;


public class HomeControl {
    @FXML
    void abrirCaixa(){
        ScreenControl.changeScene("view/caixa.fxml");
    }
    @FXML
    void abrirRepositorio(){
        //ScreenControl.changeScene("/repositorio.fxml");
    }
    @FXML
    void abrirConferente(){
        //ScreenControl.changeScene("/conferente.fxml");
    }
}
