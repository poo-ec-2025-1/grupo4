public class Administrador extends Usuario {

    public Administrador(String nomeUsuario, String senha, String tipo) {
        super(nomeUsuario, senha, tipo);
    }

    public void cadastrarUsuario(Usuario novoUsuario) {
        Login login = new Login();
        login.inserirUsuario(novoUsuario);
    }
}
