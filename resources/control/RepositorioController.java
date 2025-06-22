package control;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import java.util.List;

import model.RepositorioModel;
import model.Product;
import model.ProductDB;
import control.ScreenControl;

public class RepositorioController {
    @FXML
    private TextField sectionField;
    @FXML
    private TextField gondolaField;
    @FXML
    private TextField shelfField;
    @FXML
    private TextField sectionEField;
    @FXML
    private TextField gondolaEField;
    @FXML
    private TextField shelfEField;
    @FXML
    private TextField codeField;
    @FXML
    private TableView<Product> tabela;
    @FXML
    private TableColumn<Product, String> colName;
    @FXML
    private TableColumn<Product, String> colCode;
    @FXML
    private TableColumn<Product, String> colSection;
    @FXML
    private TableColumn<Product, String> colGondola;
    @FXML
    private TableColumn<Product, String> colShelf;
    @FXML
    private TableColumn<Product, Double> colStore;
    @FXML
    private TableColumn<Product, Double> colStock;
    @FXML
    private TableColumn<Product, Double> colPrice;
    @FXML
    private TableColumn<Product, String> colExpiration;
    
    private static ProductDB database = new ProductDB("produtos");
    private static RepositorioModel repositorio = 
        new RepositorioModel(database);

    private ObservableList<Product> productList = FXCollections.observableArrayList();

    public static Product produtoSelecionado;
    
    
    public RepositorioController() {}

    @FXML
    public void initialize() {

        if (colName == null || colCode == null || colSection == null 
        || colGondola == null || colShelf == null) {
            System.out.println("Erro: Alguma coluna da tabela está nula! Verifique os fx:id no FXML.");
            return;
        }

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colSection.setCellValueFactory(new PropertyValueFactory<>("section"));
        colGondola.setCellValueFactory(new PropertyValueFactory<>("gondola"));
        colShelf.setCellValueFactory(new PropertyValueFactory<>("shelf"));
        
        tabela.setOnMouseClicked(event -> {
    if (event.getClickCount() == 2) { 
        Product produtoSelecionado = tabela.getSelectionModel().getSelectedItem();
        RepositorioController.produtoSelecionado = produtoSelecionado;
        if (produtoSelecionado != null) {
            ScreenControl.changeScene("/view/edicao.fxml");
        }
    }
});

    }

    @FXML
    public void buscar() {
        List<Product> products = RepositorioModel.consultaFiltrada(
                sectionField.getText(),
                gondolaField.getText(),
                shelfField.getText(),
                codeField.getText(),
                sectionEField.getText(),
                gondolaEField.getText(),
                shelfEField.getText());

        productList.clear();
        productList.addAll(products);
        tabela.setItems(productList);
        limparCampos();
    }

    public void limparCampos() {
        sectionField.setText("");
        gondolaField.setText("");
        shelfField.setText("");
        codeField.setText("");
        sectionEField.setText("");
        gondolaEField.setText("");
        shelfEField.setText("");
    }

    @FXML
    public void voltarTelaAnterior() {
        ScreenControl.changeScene("/view/home.fxml");
    }
}
