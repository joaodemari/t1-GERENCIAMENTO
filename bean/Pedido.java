package bean;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	private String id;
	private Usuario usuario;
	private Date dtPedido;
	private Date dtConclusao;
	private String status;
	private ArrayList<Item> itens;
	private double valTotal;

	public Pedido(String id, Usuario usuario, Date dtPedido, Date dtConclusao, String status, ArrayList<Item> itens, double valTotal) {
		this.id = id;
		this.usuario = usuario;
		this.dtPedido = dtPedido;
		this.dtConclusao = dtConclusao;
		this.status = status;
		this.itens = itens;
		this.valTotal = valTotal;	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDtPedido() {
		return dtPedido;
	}
	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}
	public Date getDtConclusao() {
		return dtConclusao;
	}
	public void setDtConclusao(Date dtConclusao) {
		this.dtConclusao = dtConclusao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	public double getValTotal() {
		return valTotal;
	}
	public void setValTotal(double valTotal) {
		this.valTotal = valTotal;
	}
}
