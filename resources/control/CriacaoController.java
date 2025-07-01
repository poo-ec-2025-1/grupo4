package control;

import javafx.fxml.FXML;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

public class CriacaoController{
    
    @FXML
    private TextField userField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField positionField;
    @FXML
    private Label result;
    
    private static model.UserDB database = new model.UserDB("usuarios");
    private static model.UserRep userRep = 
        new model.UserRep(database);
        
    private model.User usuarioCriado;
    
    @FXML
    public void criaConta(){
        try{
            model.User usuario = new model.User();
            Pattern patternCompleto = Pattern.compile(".{3,}");

            if (!patternCompleto.matcher(userField.getText()).matches() &&
            !patternCompleto.matcher(passwordField.getText()).matches() &&
            !patternCompleto.matcher(positionField.getText()).matches()) {
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setTitle("Campos inválidos.");
                alerta.setHeaderText(null); 
                alerta.setContentText("Todos os campos precisam ter pelo menos 3 caracteres.");
                alerta.showAndWait();
                limparCampos();
            } else{
                usuario.setUsername(userField.getText());
                usuario.setPassword(passwordField.getText());
                usuario.setCargo(positionField.getText());
            }
            
            usuarioCriado = userRep.create(usuario);
            
            if(usuarioCriado != null){
                limparCampos();
                result.setText("Conta criada. Você pode fazer o login.");
            } else{
                result.setText("A conta não foi criada.");
            }
            }
            catch(Exception e){
                result.setText("Erro ao criar a conta.");
            }
    }
    
    @FXML
    public void voltarTelaAnterior() {
        ScreenControl.changeScene("/view/login.fxml");
    }
    
    public void limparCampos(){
        userField.setText("");
        passwordField.setText("");
        positionField.setText("");
    }
}