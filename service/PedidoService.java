package service;

import java.util.ArrayList;
import java.util.Date;

import bean.Item;
import bean.Pedido;
import bean.Usuario;

public interface PedidoService {
	public ArrayList<Pedido> listarEntreDatas(Date dataInicio, Date dataFim);
	public ArrayList<Pedido> listarPorSolicitante(Usuario usuario);
	public ArrayList<Pedido> listarPorDescricaoItem(Item item);
	public Pedido abrirPedido(String id);
}
