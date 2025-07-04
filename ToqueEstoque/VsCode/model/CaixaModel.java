package model;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;

/* A classe CaixaModel seria equivalente à outra classe ProductRep, mas possui 
 * métodos diferentes do CRUD.*/
public class CaixaModel {
    private static Dao<Product, Integer> dao;
      
    public static void setDatabase(ProductDB database) {
        try {
            dao = DaoManager.createDao(database.getConnection(), Product.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Product.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    //verifica se o produto está na loja e retira a quantidade requisitada
    public static boolean confereProduto(String codigo, double quantidade){
        Product product = null;
        try{
            product = dao.queryBuilder()
            .where()
            .eq("code", codigo)
            .and()
            .ge("store_quantity", quantidade)
            .queryForFirst();
            
        } catch(Exception e){
            System.out.println("Erro ao buscar o produto: " + e.getMessage());
            return false;
        }
        if(product != null){
            try{
                product.setStoreQuantity(product.getStoreQuantity() - quantidade);
                dao.update(product);
            }
            catch(SQLException e){
                System.out.println("Erro ao retirar produto: " + e.getMessage());
                return false;
            }
        }
        else return false;
        return true;
    }
}

    
