package model;

import java.util.List;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;

public class RepositorioModel
{
    private static Dao<Product, Integer> dao;
    
    
    public RepositorioModel(ProductDB database) {
        RepositorioModel.setDatabase(database);
    }
    
    public static void setDatabase(ProductDB database) {
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
}
