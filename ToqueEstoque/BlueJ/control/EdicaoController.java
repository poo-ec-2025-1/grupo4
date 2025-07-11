package control;

import java.util.regex.Pattern;
import java.net.URL;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.function.UnaryOperator;
import javafx.scene.control.TextFormatter;


import model.ProductDB;
import model.Product;
import model.ProductRep;
import model.RepositorioModel;

public class EdicaoController implements Initializable{
    @FXML
    private TextField nome;
    @FXML
    private TextField codigo;
    @FXML
    private TextField dataValidade;
    @FXML
    private TextField quantidade;
    @FXML
    private TextField quantidadeE;
    @FXML
    private TextField preco;
    @FXML
    private TextField enderecoL;
    @FXML
    private TextField secaoE;
    @FXML
    private TextField gondolaE;
    @FXML
    private TextField prateleiraE;
    @FXML
    private TextArea observacoes;
    @FXML
    private Label label;
    @FXML
    private Label storeQuantity;
    @FXML
    private Label stockQuantity;
    @FXML
    private ImageView imagemEstoque;
    @FXML
    private ImageView imagemLoja;
    
    String imagemE;
    String imagemL; 
    
    private ProductDB database = new ProductDB("produtos");
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    Product produto = RepositorioController.produtoSelecionado;
    if (produto != null) {
        
        nome.setText(produto.getName());
        codigo.setText(produto.getCode());
        enderecoL.setText(produto.getSection() + "/" + produto.getGondola() 
        + "/" + produto.getShelf());
        secaoE.setText(produto.getSectionE());
        gondolaE.setText(produto.getGondolaE());
        prateleiraE.setText(produto.getShelfE());
        preco.setText(String.format("%.2f", produto.getPrice()));
        dataValidade.setText(produto.getExpiration());
        observacoes.setText(produto.getObservation());
        storeQuantity.setText("Qt. Loja: " + String.format("%.2f" , produto.getStoreQuantity()));
        stockQuantity.setText("Qt. Estoque: " + String.format("%.2f" , produto.getStockQuantity()));
        imagemL = produto.getImage();
        
        if(imagemL == null || imagemL.isEmpty()){
            imagemL = produto.getImageE();
        }
        
        imagemE = produto.getImageE();

        if (imagemE != null && !imagemE.isEmpty()) {
            imagemEstoque.setImage(new Image(imagemE));
        }

        if (imagemL != null && !imagemL.isEmpty()) {
            imagemLoja.setImage(new Image(imagemL));
        }
        RepositorioModel.setDatabase(database);
        ProductRep.setDatabase(database);
        
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
    else{
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText("Produto não carregado!");
        alert.showAndWait();
    }
    
}
    
    @FXML
    public void salvar(){
    try {
        boolean resultado1;
        boolean resultado2;

        String texto = enderecoL.getText();

        Pattern patternCompleto = Pattern.compile("^[A-Za-z]/[A-Za-z]\\d{1,2}/[A-Za-z]\\d{1,3}$");

    if (!patternCompleto.matcher(texto).matches()) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro de validação");
        alert.setHeaderText(null);
        alert.setContentText("Endereço inválido! Use o padrão A/A1/A11, de 1 a 2 números depois da primeira barra e \nde 1 até 3 números depois da segunda barra.");
        alert.showAndWait();
        return; 
        } else {
            String[] partes = separaString(enderecoL.getText());
            Product produto = RepositorioController.produtoSelecionado;

            if (produto != null) {
                String nomeProduto = nome.getText().trim();
                String codigoProduto = codigo.getText().trim();

                if (nomeProduto.isEmpty() || codigoProduto.isEmpty()) {
                    Alert alerta = new Alert(AlertType.ERROR);
                    alerta.setTitle("Erro ao salvar");
                    alerta.setHeaderText("Campos obrigatórios vazios!");
                    alerta.setContentText("O campo NOME e o campo CÓDIGO não podem estar vazios.");
                    alerta.showAndWait();
                    return;
                }
                produto.setName(nome.getText());
                produto.setCode(codigo.getText());
                produto.setSectionE(secaoE.getText());
                produto.setGondolaE(gondolaE.getText());
                produto.setShelfE(prateleiraE.getText());
                produto.setExpiration(dataValidade.getText());
                produto.setObservation(observacoes.getText());
                produto.setImagem(imagemL);
                produto.setImagemE(imagemE);

                if (!preco.getText().isEmpty()) {
                    String precoLimpo = preco.getText().replace(",", ".");
                    produto.setPrice(Double.parseDouble(precoLimpo));
                } else {
                     produto.setPrice(0.0);
                }


                produto.setSection(partes[0]);

                if (partes.length > 1) {
                    produto.setGondola(partes[1]);
                }

                if (partes.length > 2) {
                    produto.setShelf(partes[2]);
                }

                ProductRep.update(produto);

                label.setText("Produto atualizado com sucesso!");
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro ao atualizar o produto");
                alert.setContentText("Produto selecionado não encontrado.");
                alert.showAndWait();
                return;
            }
        }

        if (quantidade.getText().isEmpty()) {
            resultado1 = RepositorioModel.atualizaLoja(codigo.getText(), 0);
        } else {
            resultado1 = RepositorioModel.atualizaLoja(codigo.getText(), Double.parseDouble(quantidade.getText()));
        }

        if (quantidadeE.getText().isEmpty()) {
            resultado2 = RepositorioModel.atualizaEstoque(codigo.getText(), 0);
        } else {
            resultado2 = RepositorioModel.atualizaEstoque(codigo.getText(), Double.parseDouble(quantidadeE.getText()));
        }

        if (resultado1 || resultado2) {
            Product produtoAtualizado = ProductRep.buscarPorCodigo(codigo.getText());

            if (produtoAtualizado != null) {
                storeQuantity.setText("Qt. Loja: " + String.format("%.2f", produtoAtualizado.getStoreQuantity()));
                stockQuantity.setText("Qt. Estoque: " + String.format("%.2f", produtoAtualizado.getStockQuantity()));

                label.setText("Produto atualizado com sucesso!");
            } else {
                label.setText("Erro: Produto não encontrado após atualização.");
            }
        } else {
            label.setText("Código ou quantidade inválida!");
        }
    } catch (Exception e) {
        e.printStackTrace();
        label.setText("Erro ao atualizar produto: " + e.getMessage());
    }
    }



    
    @FXML
    public void deletar(){
        Product produtoAtual = RepositorioController.produtoSelecionado;
        try{
            ProductRep.delete(produtoAtual);
            label.setText("Produto deletado!");
        }
        catch(Exception e){
            label.setText("Erro ao deletar!");
        }
    }
    
    @FXML
    public void voltarTelaAnterior() {
        ScreenControl.changeScene("/view/repositorio.fxml", ScreenControl.stage1);
    }
    
    public String[] separaString(String palavra){
        String[] partes = palavra.split("/");
        return partes;
    }

    @FXML
    public void subirL(){
        imagemL = control.ConferenteControl.fotoEndereco;
        Image imagem = new Image(imagemL);
        imagemLoja.setImage(imagem);
    }
    @FXML
    public void subirE(){
        imagemE = control.ConferenteControl.fotoEndereco;
        Image imagem = new Image(imagemE);
        imagemLoja.setImage(imagem);
    }

    @FXML
    public void capturarFoto(){
        ScreenControl.changeScene("/view/camera.fxml", ScreenControl.stage2);
    }
}

