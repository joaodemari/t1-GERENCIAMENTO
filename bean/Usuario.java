package bean;

public class Usuario {
    private String nome;
    private String id;
    private String senha;

    public Usuario(String nome, String id, String senha) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
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
    // Criei uma classe usuário de exemplo que pode estar logado ou não
}
