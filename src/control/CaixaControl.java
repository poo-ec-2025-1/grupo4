package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import model.ProductDB;


public class CaixaControl implements Initializable{
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private Label mensagem;
    
    public ProductDB produto = new ProductDB("produtos");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtCodigo.setTextFormatter(new TextFormatter<>(change -> {
        String novoTexto = change.getControlNewText();
        return novoTexto.matches("\\d*") ? change : null;}));

        txtQuantidade.setTextFormatter(new TextFormatter<>(change -> {
        String novoTexto = change.getControlNewText();
        return novoTexto.matches("\\d*(\\.\\d*)?") ? change : null;}));

    }
    @FXML
    public void vender(){
        String cod = txtCodigo.getText();
        double quant = Double.parseDouble(txtQuantidade.getText());
        model.CaixaModel.setDatabase(produto);

        if(model.CaixaModel.confereProduto(cod, quant)){
            mensagem.setText("Vendido");
            limparCampos();
        }
        else mensagem.setText("Produto ou quantidade inexitente em loja");
    }
    @FXML
    public void limparCampos(){
        txtCodigo.setText("");
        txtQuantidade.setText("");
    }
    @FXML
    public void voltarTelaAnterior(){
        produto.close();
        ScreenControl.changeScene("/view/home.fxml");
    }
}
