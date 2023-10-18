package service.impl;
import bean.Pedido;
import java.util.ArrayList;

public class PedidoServiceImpl implements PedidoService {

    public ArrayList<Pedido> listarEntreDatas(Date dataInicio, Date dataFim){
        ArrayList pedidosData = new ArrayList();
        if(dataInicio > dataFim  || dataFim < dataInicio){
            System.out.println("Datas inválidas.")
        }

        for(Pedido p: Pedido){
            if(p.getDtConclusao() >= dataInicio && p.getDtConclusao <= dataFim){
                pedidosData.add(p);
            }
        }

        return pedidosData;

    }

    



}
