package control;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

public class LoginController {
    
    @FXML
    private TextField userField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button entrarButton;
    
    
    private static model.UserDB database = new model.UserDB("usuarios");
    private static model.UserRep userRep = 
        new model.UserRep(database);
        
    public static model.User logado;
        
    @FXML
    public void fazerLogin(){
        try{
            logado = userRep.login(userField.getText(), passwordField.getText());
            if(logado != null){
                ScreenControl.changeScene("/view/home.fxml");
            } else{
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setTitle("Login inválido");
                alerta.setHeaderText(null); 
                alerta.setContentText("Usuário ou senha incorretos. Tente novamente.");
                alerta.showAndWait();
                userField.setText("");
                passwordField.setText("");
                }
        }
        catch(Exception e){
            new Alert(AlertType.ERROR, "Erro ao fazer login: "+e.getMessage()).show();
        }
    }
    
    @FXML
    void mudarTela(){
        ScreenControl.changeScene("/view/criacao.fxml");
    }

    
}                                      
