package bean;

public class Usuario {
    private String nome;
    private String id;
    private String senha;
    protected boolean isAdmin;

    public Usuario(String nome, String id, String senha) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.isAdmin = false;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
    // Criei uma classe usuário de exemplo que pode estar logado ou não
}
