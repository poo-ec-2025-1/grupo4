package model;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;

/* A classe CaixaModel seria equivalente à outra classe ProductRep, mas possui 
 * métodos diferentes do CRUD.*/
public class CaixaModel {
    private static ProductDB database;
    private static Dao<Product, Integer> dao;
    
    public CaixaModel(ProductDB database) {
        CaixaModel.setDatabase(database);
    }
    
    public static void setDatabase(ProductDB database) {
        CaixaModel.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Product.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Product.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    //verifica se o produto está na loja
    public static boolean confereProduto(String codigo, double quantidade){
    Product product = null;
    try {
        product = dao.queryBuilder()
                .where()
                .eq("code", codigo)
                .queryForFirst();

        if (product != null && product.getStoreQuantity() >= quantidade) {
            return true;
        }
    } catch (Exception e) {
        System.out.println("Erro ao buscar o produto: " + e.getMessage());
    }
    return false;
    }

    //retira a quantidade requisitada da estante da loja
    public static boolean retiraProduto(String codigo, double quantidade){
    Product product = null;
    try {
        product = dao.queryBuilder()
                .where()
                .eq("code", codigo)
                .queryForFirst();
        if (product != null) {
            if (product.getStoreQuantity() >= quantidade) {
                product.setStoreQuantity(product.getStoreQuantity() - quantidade);
                dao.update(product);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    } catch(SQLException e) {
        System.out.println("Erro ao buscar produto: " + e.getMessage());
    }
    return false;
    }
    
}

    
