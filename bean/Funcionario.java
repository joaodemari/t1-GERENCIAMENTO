package bean;

public class Funcionario {
    private String nome;
    private String id;
    private boolean isLogged;

    public Funcionario(String nome, String id, boolean isLogged) {
        this.nome = nome;
        this.id = id;
        this.isLogged = false;
    }

    // @Override
    // public void LoginUser() {
    // }

    // @Override
    // public void Logout() {
    // }

    // @Override
    // public String getNome() {
    // return null;
    // }
}
