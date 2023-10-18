package Colecoes;

import bean.Item;
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

    public ArrayList<Pedido> buscaPedidosPorItem(String nome) {
        ArrayList<Pedido> retorno = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            ArrayList<Item> itens = pedido.getItens();
            for (Item it : itens) {
                if (it.getNome().contains(nome)) {
                    retorno.add(pedido);
                }
            }
        }
        return retorno;
    }
}
