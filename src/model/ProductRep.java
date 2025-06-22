package model;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;

public class ProductRep
{
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
    
    public static Product create(Product product) {
        int nrows = 0;
        try {
            nrows = dao.create(product);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }    

    public static void update(Product product) {
      try {
        int updatedRows = dao.update(product);
        if (updatedRows == 0) {
            System.out.println("O produto não foi atualizado.");
        } else {
            System.out.println("Produto atualizado com sucesso.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar produto: " + e.getMessage());
    }
    }

    public static void delete(Product product) {
      try {
        int deletedRows = dao.delete(product);
        if (deletedRows == 0) {
            System.out.println("Produto não deletado.");
        } else {
            System.out.println("Produto deletado.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao deletar produto: " + e.getMessage());
    }
    }
    
}
