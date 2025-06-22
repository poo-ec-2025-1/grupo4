package control;

import javafx.fxml.FXML;


public class HomeControl {
    @FXML
    void abrirCaixa(){
        ScreenControl.changeScene("/view/caixa.fxml");
    }
    @FXML
    void abrirRepositorio(){
        ScreenControl.changeScene("/view/repositorio.fxml");
    }
    @FXML
    void abrirConferente(){
        ScreenControl.changeScene("/view/conferente.fxml");
    }
}
