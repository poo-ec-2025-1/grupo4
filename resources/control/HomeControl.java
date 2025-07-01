package control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeControl {
    
    model.User usuarioAtual;
    
    @FXML
    private Label result;
    
    @FXML
    public void initialize() {
        usuarioAtual = LoginController.logado;
        if(usuarioAtual != null){
            result.setText("Usuário: " + usuarioAtual.getUsername() + 
            "   Cargo: " + usuarioAtual.getCargo());
        } else{
            result.setText("Usuário não carregado.");
        }
    }
    
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
