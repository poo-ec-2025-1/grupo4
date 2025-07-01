package control;

import javafx.fxml.FXML;


public class HomeControl {
    @FXML
    void abrirCaixa(){
        ScreenControl.changeScene("/view/caixa.fxml", control.ScreenControl.stage1);
    }
    @FXML
    void abrirRepositorio(){
        ScreenControl.changeScene("/view/repositorio.fxml", ScreenControl.stage1);
    }
    @FXML
    void abrirConferente(){
        ScreenControl.changeScene("/view/conferente.fxml", control.ScreenControl.stage1);
    }
}
