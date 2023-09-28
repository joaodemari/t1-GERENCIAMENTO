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
    // como mudar o autor e email do git?
    // git config --global user.name "John Doe" --> configura nome
    // git config --global user.email "john@doe.org" --> configura email
}
