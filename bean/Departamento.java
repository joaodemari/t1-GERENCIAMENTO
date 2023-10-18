package bean;

public class Departamento {
  private String nome;
  private int limite;

  public Departamento(String nome, int limite) {
    this.nome = nome;
    this.limite = limite;
  }

  public String getNome() {
    return this.nome;
  }

  public int getLimite() {
    return this.limite;
  }

}