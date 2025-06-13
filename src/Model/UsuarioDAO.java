import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO
{
    private static UsuarioDB database;
    private static Dao<Usuario, Integer> dao;
    
    
    public UsuarioDAO(UsuarioDB database) {
        UsuarioDAO.setDatabase(database);
    }
    
    public static void setDatabase(UsuarioDB database) {
        UsuarioDAO.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Usuario.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Usuario.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Usuario create(Usuario usuario) {
        int nrows = 0;
        try {
            nrows = dao.create(usuario);
            if ( nrows == 0 )
                throw new SQLException("Erro: usuário não foi salvo.");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return usuario;
    }    

    public void update(Usuario usuario) {
      try {
        int updatedRows = dao.update(usuario);
        if (updatedRows == 0) {
            System.out.println("O usuário não foi atualizado.");
        } else {
            System.out.println("Usuário atualizado com sucesso.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar usuário: " + e.getMessage());
    }
    }

    public void delete(Usuario usuario) {
      try {
        int deletedRows = dao.delete(usuario);
        if (deletedRows == 0) {
            System.out.println("Usuário não deletado.");
        } else {
            System.out.println("Usuário deletado.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao deletar usuário: " + e.getMessage());
    }
    }
    
    public boolean login(String nomeUsuario, String senha) {
        Usuario usuario;
    
        try {
        usuario = dao.queryBuilder()
                     .where()
                     .eq("nomeUsuario", nomeUsuario)
                     .and()
                     .eq("senha", senha)
                     .queryForFirst(); 
        } catch (SQLException e) {
        System.out.println("Erro ao buscar por usuario e senha: " + e.getMessage());
        return false;
        }
        return usuario != null;
    }
    
    public boolean verificaAdmin(String nomeUsuario) {
        Usuario usuario;
    
        try {
        usuario = dao.queryBuilder()
                     .where()
                     .eq("nomeUsuario", nomeUsuario)
                     .and()
                     .eq("tipo", "admin")
                     .queryForFirst(); 
        } catch (SQLException e) {
        System.out.println("Erro ao verificar se´o usuário é um administrador: " + e.getMessage());
        return false;
        }
        return usuario != null;
    }
}