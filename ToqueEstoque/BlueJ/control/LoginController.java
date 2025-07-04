package control;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    private ImageView marca;
    
    
    private static model.UserDB database = new model.UserDB("usuarios");
    private static model.UserRep userRep = 
        new model.UserRep(database);
        
    public static model.User logado;

    public void initialize(){
        if(marca == null){
            Image image = new Image("file:/home/victor-hugo/Facul/Trabalho_POO/grupo4/logos/LOGO_TE-SEM_FUNDO.png");
            marca.setImage(image);
        }
    }
        
    @FXML
    public void fazerLogin(){
        try{
            logado = userRep.login(userField.getText(), passwordField.getText());
            if(logado != null){
                ScreenControl.changeScene("/view/home.fxml", ScreenControl.stage1);
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
        ScreenControl.changeScene("/view/criacao.fxml", ScreenControl.stage1);
    }

    
}                                      
