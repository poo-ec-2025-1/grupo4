package Model;
import java.sql.*;

public class Login {
    private static final String URL = "jdbc:sqlite:usuarios.db";

    public Login() {
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
    String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                 "nomeUsuario TEXT PRIMARY KEY," +
                 "senha TEXT NOT NULL," +
                 "tipo TEXT NOT NULL);"; 
    try (Connection conn = DriverManager.getConnection(URL);
         Statement stmt = conn.createStatement()) {
        stmt.execute(sql);
    } catch (SQLException e) {
        System.out.println("Erro ao criar tabela: " + e.getMessage());
    }
}


   public void inserirUsuario(Usuario usuario) {
    String sql = "INSERT INTO usuarios(nomeUsuario, senha, tipo) VALUES(?, ?, ?);";
    try (Connection conn = DriverManager.getConnection(URL);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, usuario.getNomeUsuario());
        pstmt.setString(2, usuario.getSenha());
        pstmt.setString(3, usuario.getTipo());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Erro ao inserir usuário: " + e.getMessage());
    }
}


    public boolean verificarLogin(String nomeUsuario, String senha) {
        String sql = "SELECT * FROM usuarios WHERE nomeUsuario = ? AND senha = ?;";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nomeUsuario);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            System.out.println("Erro ao verificar login: " + e.getMessage());
            return false;
        }
    }
    
    public boolean ehAdministrador(String nomeUsuario) {
    String sql = "SELECT tipo FROM usuarios WHERE nomeUsuario = ?;";
    try (Connection conn = DriverManager.getConnection(URL);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, nomeUsuario);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString("tipo").equalsIgnoreCase("admin");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao verificar tipo: " + e.getMessage());
    }
    return false;
    }

}
