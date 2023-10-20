package bean;

public class Administrador extends Usuario {
    public Administrador(String nome, String id, String senha) {
        super(nome, id, senha);
        this.isAdmin = true;
    }
}
