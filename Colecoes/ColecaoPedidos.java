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
        System.out.println("Pedidos encontrados pela descrição de um item:");
        ArrayList<Pedido> retorno = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            ArrayList<Item> itens = pedido.getItens();
            for (Item it : itens) {
                if (it.getNome().equals(nome)) {
                    retorno.add(pedido);
                    break;
                }
            }
        }
        return null;
    }
}
