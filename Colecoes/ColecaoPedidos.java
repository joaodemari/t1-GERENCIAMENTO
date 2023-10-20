package Colecoes;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public ArrayList<Pedido> buscaPedidoPorFuncionario(String id) {
        ArrayList<Pedido> retorno = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getUsuario().getId().equals(id)) {
                retorno.add(pedido);
            }

        }
        return retorno;
    }

    public Pedido buscaPedidoPorNumero(String id) {
        Pedido p = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                p = pedido;
                break;
            }
        }
        return p;
    }

}
