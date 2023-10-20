package bean;

public class Funcionario extends Usuario {
    private String departamento;

    public Funcionario(String nome, String id, String senha, String departamento) {
        super(nome, id, senha);
        this.departamento = departamento;
    }
}
