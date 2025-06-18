package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import view.LoginView;
import view.HomeView;
import view.StageManagerView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

public class LoginController {
    
    @FXML
    private TextField userField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button entrarButton;
    
    LoginView loginView;
    
    private static model.UserDB database = new model.UserDB("usuarios");
    private static model.UserRep userRep = 
        new model.UserRep(database);
        
    private boolean logado;
        
    public LoginController() {
        this.loginView = new view.LoginView();
    }
    

    
    public void fazerLogin(){
        try{
            logado = userRep.login(userField.getText(), passwordField.getText());
            System.out.println("Botão clicado.");
            if(logado){
                StageManagerView.abrirTela(HomeView.getScene());
            } else{
                Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Login inválido");
        alerta.setHeaderText(null); 
        alerta.setContentText("Usuário ou senha incorretos. Tente novamente.");
        alerta.showAndWait();
            }
        }
        catch(Exception e){
            new Alert(AlertType.ERROR, "Erro ao salvar: "+e.getMessage()).show();
        }
    }
    
}                                      