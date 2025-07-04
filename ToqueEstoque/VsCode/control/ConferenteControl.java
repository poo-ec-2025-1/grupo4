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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



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
        String nomeProduto = nome.getText().trim();
        String codigoProduto = codigo.getText().trim();
        String validade = dataValidade.getText().trim();
        String quantidadeEstoque = quantidade.getText().trim();

        if (nomeProduto.isEmpty() || codigoProduto.isEmpty() || validade.isEmpty()
        || fotoEndereco == null || quantidadeEstoque.isEmpty()) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Erro ao salvar");
            alerta.setHeaderText("Campos obrigatórios vazios!");
            alerta.setContentText("Os campos NOME, CÓDIGO, VALIDADE e QUANTIDADE não podem estar vazios. Além disso, a foto tem que ser adicionada.");
            alerta.showAndWait();
            return;
        }
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
    if (fotoEndereco != null && !fotoEndereco.isEmpty()) {
        Image image = new Image(fotoEndereco);
        foto.setImage(image);
        mensagem.setText("Imagem atualizada");
    } else {
        mensagem.setText("Nenhuma imagem adicionada.");
    }
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
        
        double precoProduto = preco.getText().isEmpty() ? 0.0 : Double.parseDouble(preco.getText());
        
        produto.setStockQuantity(Double.parseDouble(quantidade.getText()));
        produto.setPrice(precoProduto);
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

