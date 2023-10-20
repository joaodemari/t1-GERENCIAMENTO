package bean;

public class Funcionario extends Usuario {
    private Departamento departamento;

    public Funcionario(String nome, String id, String senha, Departamento d) {
        super(nome, id, senha);
        this.departamento = d;
    }
}
