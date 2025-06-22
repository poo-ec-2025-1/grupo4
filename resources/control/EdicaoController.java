package control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import model.ProductDB;
import model.Product;
import model.ProductRep;
import model.RepositorioModel;

public class EdicaoController{
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
    private TextField secao;
    @FXML
    private TextField gondola;
    @FXML
    private TextField prateleira;
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
    
    private ProductDB database = new ProductDB("produtos");
    
    @FXML
    public void initialize() {
    Product produto = RepositorioController.produtoSelecionado;
    if (produto != null) {
        nome.setText(produto.getName());
        codigo.setText(produto.getCode());
        secao.setText(produto.getSection());
        gondola.setText(produto.getGondola());
        prateleira.setText(produto.getShelf());
        secaoE.setText(produto.getSectionE());
        gondolaE.setText(produto.getGondolaE());
        prateleiraE.setText(produto.getShelfE());
        preco.setText(String.format("%.2f", produto.getPrice()));
        dataValidade.setText(produto.getExpiration());
        observacoes.setText(produto.getObservation());
        storeQuantity.setText("Qt. Loja: " + String.format("%.2f" , produto.getStoreQuantity()));
        stockQuantity.setText("Qt. Estoque: " + String.format("%.2f" , produto.getStockQuantity()));
        RepositorioModel.setDatabase(database);
        ProductRep.setDatabase(database);
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
        ScreenControl.changeScene("/view/repositorio.fxml");
    }
}

