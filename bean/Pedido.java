package bean;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	private Usuario usuario;
	private Date dtPedido;
	private Date dtConclusao;
	private String status;
	private ArrayList<Item> itens;
	private double valTotal;

	public Pedido(Usuario usuario, Date dtPedido, Date dtConclusao, String status, ArrayList<Item> itens, double valTotal){
		this.usuario=usuario; 
		this.dtPedido=dtPedido; 
		this.dtConclusao=dtConclusao;
		this.status=status;
		this.itens=itens;
		this.valTotal=valTotal;
	}
  
	public Pedido(Usuario usuario, Date dtPedido, ArrayList<Item> itens, double valTotal) {
		this.usuario = usuario;
		this.dtPedido = dtPedido;
		this.dtConclusao = null;
		this.status = "aberto";
		this.itens = itens;
		this.valTotal = valTotal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Date getDtPedido() {
		return dtPedido;
	}

	public Date getDtConclusao() {
		return dtConclusao;
	}

	public String getStatus() {
		return status;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public double getValTotal() {
		return valTotal;
	}


}
