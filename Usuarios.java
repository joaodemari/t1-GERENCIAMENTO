import java.util.ArrayList;

public class Usuarios {
    

    private ArrayList<Usuario> usuarios;

    public Usuarios(){
        usuarios = new ArrayList<Usuario>();
    }

    public boolean addUser(Usuario u){
        return usuarios.add(u);

    }

    // commit pra testar se eu (demari) mudei o author do git
}
