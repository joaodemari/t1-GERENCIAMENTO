package bean;
public class Usuario {
    private String nome;
    private String id;
    private boolean isLogged;

    public Usuario(String nome, String id){
        this.nome = nome;
        this.id = id;
        this.isLogged = false;
    }

    public void LoginUser(){
        isLogged = true;
    }

    public void Logout(){
        isLogged = false;
    }

    public String getNome(){
        return nome;
    }

    // Criei uma classe usuário de exemplo que pode estar logado ou não
}
