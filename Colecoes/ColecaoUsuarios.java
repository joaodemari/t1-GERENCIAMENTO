package Colecoes;
import java.util.ArrayList;
import bean.Usuario;

public class ColecaoUsuarios {

    private ArrayList<Usuario> usuarios;

    public ColecaoUsuarios() {
        usuarios = new ArrayList<Usuario>();
    }

    public boolean addUser(Usuario u) {
        return usuarios.add(u);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario buscarPorNome(String nome) {
        for (Usuario u : usuarios) {
            if (u.getNome().equals(nome)) {
                return u;
            }
        }
        return null;
    }
    // commit pra testar se eu (demari) mudei o author do git
}
