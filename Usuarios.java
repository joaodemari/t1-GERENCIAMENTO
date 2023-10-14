import java.util.ArrayList;

import bean.Usuario;

public class Usuarios {

    private ArrayList<Usuario> usuarios;

    public Usuarios() {
        usuarios = new ArrayList<Usuario>();
    }

    public boolean addUser(Usuario u) {
        return usuarios.add(u);

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    // commit pra testar se eu (demari) mudei o author do git
}
