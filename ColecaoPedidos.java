import java.util.ArrayList;
import bean.Pedido;

public class ColecaoPedidos {

    private ArrayList<Pedido> pedidos;

    public ColecaoPedidos() {
        pedidos = new ArrayList<Pedido>();
    }

    public boolean addPedido(Pedido p) {
        return pedidos.add(p);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
