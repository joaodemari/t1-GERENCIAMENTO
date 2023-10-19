package Colecoes;

import java.util.ArrayList;
import Colecoes.ColecaoUsuarios;
import bean.Item;
import bean.Pedido;
import bean.Usuario;

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

    public ArrayList<Pedido> buscaPedidoPorFuncionario(ArrayList<Usuario> usuarios, String id) {
        ArrayList<Pedido> retorno = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            for (Usuario u : usuarios) {
                if (pedido.getUsuario().getId().equals(u.getId())) {
                    retorno.add(pedido);
                }
            }
        }
        return retorno;
    }

    public ArrayList<Pedido> buscaPedidoPorNumero(int nPedido) {
        ArrayList<Pedido> retorno = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            for (Pedido nPedido : pedidos) {
                if (pedido.getNPedido()) {
                    retorno.add(pedido);
                }
            }
        }
        return retorno;
    }
}
