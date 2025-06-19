package controller;

 
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import model.CaixaModel;

import view.*;


public class CaixaControl implements Initializable{
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private Label mensagem;
    
    public static void caixaRun(String[] args){
        CaixaView view = new CaixaView();
        view.run(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtCodigo.setTextFormatter(new TextFormatter<>(change -> {
        String novoTexto = change.getControlNewText();
        return novoTexto.matches("\\d*") ? change : null;}));

        txtQuantidade.setTextFormatter(new TextFormatter<>(change -> {
        String novoTexto = change.getControlNewText();
        return novoTexto.matches("\\d*(\\.\\d*)?") ? change : null;}));

    }

    public void vender(){
        String cod = txtCodigo.getText();
        double quant = Double.parseDouble(txtQuantidade.getText());

        if(CaixaModel.confereProduto(cod, quant)){
            CaixaModel.retiraProduto(cod, quant);
            mensagem.setText("Vendido");
        }
        else mensagem.setText("Produto ou quantidade inexitente em loja");
    }

    public void limparCampos(){
        txtCodigo.setText("");
        txtQuantidade.setText("");
    }
}
