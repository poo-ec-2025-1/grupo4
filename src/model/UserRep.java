package model;

 

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;

public class UserRep
{
    private static UserDB database;
    private static Dao<User, Integer> dao;
    
    
    public UserRep(UserDB database) {
        UserRep.setDatabase(database);
    }
    
    public static void setDatabase(UserDB database) {
        UserRep.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), User.class);
            TableUtils.createTableIfNotExists(database.getConnection(), User.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public User create(User user) {
        int nrows = 0;
        try {
            nrows = dao.create(user);
            if ( nrows == 0 )
                throw new SQLException("Erro: usuário não foi salvo.");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }    

    public void update(User user) {
      try {
        int updatedRows = dao.update(user);
        if (updatedRows == 0) {
            System.out.println("O usuário não foi atualizado.");
        } else {
            System.out.println("Usuário atualizado com sucesso.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar usuário: " + e.getMessage());
    }
    }

    public void delete(User user) {
      try {
        int deletedRows = dao.delete(user);
        if (deletedRows == 0) {
            System.out.println("Usuário não deletado.");
        } else {
            System.out.println("Usuário deletado.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao deletar usuário: " + e.getMessage());
    }
    }
    
    public boolean login(String username, String password) {
        User user;
    
        try {
        user = dao.queryBuilder()
                     .where()
                     .eq("username", username)
                     .and()
                     .eq("password", password)
                     .queryForFirst(); 
        } catch (SQLException e) {
        System.out.println("Erro ao buscar por usuario e senha: " + e.getMessage());
        return false;
        }
        return user != null;
    }
    

}
