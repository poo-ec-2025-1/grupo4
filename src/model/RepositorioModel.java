package model;

import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;

public class RepositorioModel
{
    private static ProductDB database;
    private static Dao<Product, Integer> dao;
    
    
    public RepositorioModel(ProductDB database) {
        RepositorioModel.setDatabase(database);
    }
    
    public static void setDatabase(ProductDB database) {
        RepositorioModel.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Product.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Product.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public static List<Product> consultarSection(String section){
        try{
            List<Product> products;
            products = dao.queryBuilder()
            .where()
            .eq("section", section)
            .query();
            return products;
        }
        catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
            return null;
        }
    }
    
    public static List<Product> consultarGondola(String gondola){
        try{
            List<Product> products;
            products = dao.queryBuilder()
            .where()
            .eq("gondola", gondola)
            .query();
            return products;
        }
        catch (SQLException e) {
            System.out.println("Erro ao buscar producto: " + e.getMessage());
            return null;
        }
    }
    
    public static List<Product> consultarShelf(String shelf){
        try{
            List<Product> products;
            products = dao.queryBuilder()
            .where()
            .eq("shelf", shelf)
            .query();
            return products;
        }
        catch (SQLException e) {
            System.out.println("Erro ao buscar producto: " + e.getMessage());
            return null;
        }
    }
    
    public static List<Product> consultarSectionE(String sectionE){
        try{
            List<Product> products;
            products = dao.queryBuilder()
            .where()
            .eq("sectionE", sectionE)
            .query();
            return products;
        }
        catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
            return null;
        }
    }
    
    public static List<Product> consultarGondolaE(String gondolaE){
        try{
            List<Product> products;
            products = dao.queryBuilder()
            .where()
            .eq("gondolaE", gondolaE)
            .query();
            return products;
        }
        catch (SQLException e) {
            System.out.println("Erro ao buscar producto: " + e.getMessage());
            return null;
        }
    }
    
    public static List<Product> consultarShelfE(String shelfE){
        try{
            List<Product> products;
            products = dao.queryBuilder()
            .where()
            .eq("shelfE", shelfE)
            .query();
            return products;
        }
        catch (SQLException e) {
            System.out.println("Erro ao buscar producto: " + e.getMessage());
            return null;
        }
    }
    
    public static List<Product> consultarCode(String code){
        try{
            List<Product> products;
            products = dao.queryBuilder()
            .where()
            .eq("code", code)
            .query();
            return products;
        }
        catch (SQLException e) {
            System.out.println("Erro ao buscar producto: " + e.getMessage());
            return null;
        }
        
        
            
        }
    
    public static List<Product> consultaFiltrada(String section,
        String gondola, String shelf, String code, String sectionE,
        String gondolaE, String shelfE) {
    
        if (code != null && !code.isEmpty()) {
            return RepositorioModel.consultarCode(code);
        }

        if (shelf != null && !shelf.isEmpty()) {
            return RepositorioModel.consultarShelf(shelf);
        }

        if (gondola != null && !gondola.isEmpty()) {
            return RepositorioModel.consultarGondola(gondola);
        }
    
        if (section != null && !section.isEmpty()) {
            return RepositorioModel.consultarSection(section);
        }

         if (shelfE != null && !shelfE.isEmpty()) {
            return RepositorioModel.consultarShelfE(shelfE);
        }

        if (gondolaE != null && !gondolaE.isEmpty()) {
            return RepositorioModel.consultarGondolaE(gondolaE);
        }
    
        if (sectionE != null && !sectionE.isEmpty()) {
            return RepositorioModel.consultarSectionE(sectionE);
        }
        
        return new ArrayList<>();
    }
        
        public static boolean atualizaLoja(String codigo, double quantidade) {
    try {
        Product product = dao.queryBuilder()
            .where()
            .eq("code", codigo)
            .queryForFirst();

        if (product == null) {
            System.out.println("Produto com código " + codigo + " não encontrado.");
            return false;
        }

        if (product.getStockQuantity() >= quantidade) {
            product.setStoreQuantity(product.getStoreQuantity() + quantidade);
            product.setStockQuantity(product.getStockQuantity() - quantidade);
            dao.update(product);
            System.out.println("Quantidade movida para loja: " + quantidade);
            return true;
        } else {
            System.out.println("Estoque insuficiente para movimentar.");
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar loja: " + e.getMessage());
        return false;
    }
}


        
    public static boolean atualizaEstoque(String codigo, double quantidade) {
    try {
        Product product = dao.queryBuilder()
            .where()
            .eq("code", codigo)
            .queryForFirst();

        if (product == null) {
            System.out.println("Produto com código " + codigo + " não encontrado.");
            return false;
        }

        if (product.getStoreQuantity() >= quantidade) {
            product.setStockQuantity(product.getStockQuantity() + quantidade);
            product.setStoreQuantity(product.getStoreQuantity() - quantidade);
            dao.update(product);
            System.out.println("Quantidade devolvida para estoque: " + quantidade);
            return true;
        } else {
            System.out.println("Quantidade insuficiente na loja para devolver.");
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar estoque: " + e.getMessage());
        return false;
    }
}


}
