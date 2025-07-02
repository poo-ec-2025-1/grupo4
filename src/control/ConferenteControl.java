package control;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ConferenteControl implements Initializable{
    
    @FXML
    public TextField nome;
    @FXML
    public TextField codigo;
    @FXML
    public TextField quantidade;
    @FXML
    public TextField preco;
    @FXML
    public TextField dataValidade;
    @FXML
    public TextField secao;
    @FXML
    public TextField gondola;
    @FXML
    public TextField prateleira;
    @FXML
    public TextArea observacoes;
    @FXML
    public ImageView foto;
    @FXML
    private Label mensagem;

    public static String fotoEndereco; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Pattern pattern = Pattern.compile("\\d{0,2}(/\\d{0,2}(/\\d{0,4})?)?");

        UnaryOperator<TextFormatter.Change> filtro = change -> {
            String novoTexto = change.getControlNewText();
            if (pattern.matcher(novoTexto).matches()) {
                return change;
            } else {
                return null; 
            }
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filtro);
        dataValidade.setTextFormatter(textFormatter);
    }

    @FXML
    public void salvarInformacoes(){
        model.Product produto = defineProduto();
        model.ProductDB database = new model.ProductDB("produtos");
        model.ProductRep.setDatabase(database);
        model.ProductRep.create(produto);
        limparTela();
        mensagem.setText("Dados Salvos");
    }
    @FXML
    public void addFoto(){
        ScreenControl.changeScene("/view/camera.fxml", ScreenControl.stage2);
    }

    @FXML
    public void atualizar(){
        Image image = new Image(fotoEndereco);
        foto.setImage(image);
        mensagem.setText("Imagem atualizada");
    }

    @FXML
    public void voltar(){
        ScreenControl.changeScene("/view/home.fxml", ScreenControl.stage1);
    }

    public void limparTela(){
        nome.clear();
        codigo.clear();
        quantidade.clear();
        preco.clear();
        dataValidade.clear();
        secao.clear();
        gondola.clear();
        prateleira.clear();
        observacoes.clear();
        foto.setImage(null);
    }

    public model.Product defineProduto(){
        model.Product produto = new model.Product();
        produto.setName(nome.getText());
        produto.setCode(codigo.getText());
        produto.setStockQuantity(Double.parseDouble(quantidade.getText()));
        produto.setPrice(Double.parseDouble(preco.getText()));
        produto.setExpiration(dataValidade.getText());
        produto.setSectionE(secao.getText());
        produto.setGondolaE(gondola.getText());
        produto.setShelfE(prateleira.getText());
        produto.setObservation(observacoes.getText());
        produto.setStoreQuantity(0);
        produto.setImagemE(fotoEndereco);
        return produto;
    }

}

