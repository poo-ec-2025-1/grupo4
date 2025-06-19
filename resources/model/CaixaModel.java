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
    public boolean confereProduto(String codigo, double quantidade){
        Product product = null;
        try{
            product = dao.queryBuilder()
            .where()
            .eq("code", codigo)
            .and()
            .eq("store_quantity", quantidade)
            .queryForFirst();
            
        } catch(Exception e){
            System.out.println("Erro ao buscar o produto: " + e.getMessage());
        return false;
        }
        return product != null;
    }
    //retira a quantidade requisitada da estante da loja
    public boolean retiraProduto(String codigo, double quantidade){
        Product product = null;
        try{
            product = dao.queryBuilder()
            .where()
            .eq("code", codigo)
            .queryForFirst();
            product.setStoreQuantity(product.getStoreQuantity() - quantidade);
            if(product.getStoreQuantity() >= 0){
                dao.update(product);
                return true;
            } else{
                return false;
            }
        }
        catch(SQLException e){
            System.out.println("Erro ao buscar por usuario e senha: " + e.getMessage());
        return false;
        }
    }
    
}

    
