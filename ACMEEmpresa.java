import java.util.Date;
import java.text.DateFormat;
import java.util.Scanner;
import java.util.ArrayList;

import Colecoes.ColecaoItens;
import Colecoes.ColecaoPedidos;
import Colecoes.ColecaoUsuarios;

import bean.Administrador;
import bean.Item;
import bean.Pedido;
import bean.Usuario;
import bean.Funcionario;

import java.text.ParseException;


public class ACMEEmpresa {
    private Scanner entrada;
    private ColecaoUsuarios usuarios;
    private Usuario usuario;
    private ColecaoPedidos pedidos;

    public ACMEEmpresa() {
        entrada = new Scanner(System.in);
        usuarios = new ColecaoUsuarios();
        pedidos = new ColecaoPedidos();
        this.usuario = null;
    }

    public void executa() {
        // Criando alguns objetos de exemplo
        Administrador a = new Administrador("João", "123", "123456");
        Funcionario f1 = new Funcionario("Maria", "456", "789012");
        Funcionario f2 = new Funcionario("Pedro", "789", "345678");
        Item i1 = new Item("Caneta", "Caneta esferográfica azul", 1.5, 10);
        Item i2 = new Item("Caderno", "Caderno universitário 100 folhas", 10.0, 5);
        Item i3 = new Item("Lápis", "Lápis preto nº2", 0.5, 20);
        Item i4 = new Item("Borracha", "Borracha branca", 0.3, 15);
        Item i5 = new Item("Mochila", "Mochila escolar", 50.0, 2);
        Item i6 = new Item("Estojo", "Estojo escolar", 5.0, 5);
        ArrayList<Item> itens1 = new ArrayList<>();
        itens1.add(i1);
        itens1.add(i2);
        itens1.add(i3);
        ColecaoItens itens2 = new ColecaoItens();
        itens2.addItem(i4);
        itens2.addItem(i5);
        itens2.addItem(i6);
        Date d1 = new Date();
        Date d2 = new Date(d1.getTime() + 3600000);
        Pedido p1 = new Pedido("1", f1, d1, itens1, 0.0);
        Pedido p2 = new Pedido("2", f2, d2, itens2.getItens(), 0.0);
        pedidos.addPedido(p1);
        pedidos.addPedido(p2);
        usuarios.addUser(a);
        usuarios.addUser(f1);
        usuarios.addUser(f2);
        menuLogin();
    }

    private void menuLogin() {

        int opc = 1;
        while (opc != 0) {
            System.out.println("[0] Sair do sistema");
            System.out.println("[1] Fazer Login");
            opc = entrada.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                case 1:
                    fazerLogin();
                    break;
                default:
                    System.out.println("Entrada inválida.");
            }
        }
    }

    private void fazerLogin() {
        Usuario found = null;
        do {
            System.out.println("Digite seu id:");
            String id = entrada.next();

            for (Usuario u : usuarios.getUsuarios()) {
                if (u.getId().equals(id)) {
                    found = u;
                    System.out.println("Usuário encontrado!");
                    break;
                }
            }
            if (found == null)
                System.out.println("Usuário não encontrado! Tente novamente.");
        } while (found == null);
        System.out.println("Digite sua senha:");
        String senha = entrada.next();
        if (found.getSenha().equals(senha)) {
            System.out.println("Login efetuado com sucesso!");
            this.usuario = found;
            menuPrincipal();
        } else {
            System.out.println("Senha incorreta! Tente novamente.");
        }
    }

    private void menuPrincipal() {
        int opc = 1;
        while (opc != 0) {
            System.out.println("[0] Deslogar do Sistema");
            System.out.println("[1] Registrar um novo pedido de aquisição");
            System.out.println("[2] Pedidos (Menu Pedidos)");
            opc = entrada.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Deslogando do sistema...");
                    break;
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    menuPedidos();
                    break;
                default:
                    System.out.println("Entrada inválida.");
            }
        }
    }

    private void registrarPedido() {
        System.out.println("ADICIONAR ITENS AO SEU PEDIDO");
        ColecaoItens itensPedido = new ColecaoItens();
        while (true) {
            System.out.println("Digite o nome do item:");
            String nome = entrada.next();
            System.out.println("Digite a descrição do item:");
            String descricao = entrada.next();
            System.out.println("Digite o valor do item:");
            double valor = entrada.nextDouble();
            System.out.println("Digite a quantidade do item:");
            int quantidade = entrada.nextInt();
            Item i = new Item(nome, descricao, valor, quantidade);

            itensPedido.addItem(i);
            System.out.println("Item adicionado com sucesso!");
            System.out.println("Deseja adicionar mais itens? [S/N]");
            String resp = entrada.next();
            if (resp.equals("N"))
                break;
        }
        double valorTotal = 0.0;
        Date d = new Date();
        Pedido p = new Pedido(usuario, d, itensPedido.getItens(), valorTotal);
        pedidos.addPedido(p);
        System.out.println("Pedido registrado com sucesso!");
    }

    private void menuPedidos() {
        int opc = 1;
        while (opc != 0) {
            System.out.println("[0] Voltar ao Menu Anterior (Administrador)");
            System.out.println("[1] Listar todos os pedidos entre duas datas");
            System.out.println("[2] Buscar pedidos por funcionário solicitante");
            System.out.println("[3] Buscar pedidos pela descrição de um item");
            System.out.println("[4] Visualizar os detalhes de um pedido para aprová-lo ou rejeitá-lo");
            opc = entrada.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Voltando ao Menu Anterior (Administrador)...");
                    break;
                case 1:
                    listarPedidosEntreDatas();
                   break;
                case 2:
                    buscarPedidosPorFuncionario();
                    break;
                case 3:
                    buscarPedidosPorItem();
                    break;
                case 4:
                    visualizarDetalhesPedido();
                    break;
                default:
                    System.out.println("Entrada inválida.");
            }
        }
    }

    // Método implementado;
  private void listarPedidosEntreDatas() {
    DateFormat f = DateFormat.getDateInstance(); 
    System.out.println("Digite a data de início: ");
    String inicio = entrada.next();
    System.out.println("Digite a data limite: ");
    String limite = entrada.next();
  
    try {
        Date dataInicio = f.parse(inicio);
        Date dataFinal = f.parse(limite);

        if (dataInicio.compareTo(dataFinal) > 0) {
            System.out.println("Datas inválidas.");
            return;
        }

        ArrayList<Pedido> pedidosData = new ArrayList<>();
        for (Pedido p : pedidos.getPedidos()) {
            if (p.getDtConclusao().after(dataInicio) && p.getDtConclusao().before(dataFinal)) {
                pedidosData.add(p);
            }
        }

        System.out.println("Pedidos encontrados entre as datas:");
        for (Pedido pedido : pedidosData) {
            System.out.println("Detalhes do pedido:");
            System.out.println("ID do pedido: " + pedido.getId()); 
            System.out.println("Data de conclusão: " + pedido.getDtConclusao()); 
            System.out.println("Itens: " + pedido.getItens());
            System.out.println("---------------------------------------");
        }
    } catch (ParseException e) {
        System.out.println("Formato de data inválido. Certifique-se de usar o formato correto.");
        e.printStackTrace(); 
    }
}

}
     

    private void buscarPedidosPorFuncionario() {
        System.out.println("Digite o id do funcionário");
        String id = entrada.next();
        ArrayList<Pedido> Busca = pedidos.buscaPedidoPorFuncionario(usuarios.getUsuarios(), id);
        if (Busca == null) {
            System.out.println("Nenhum pedido encontrado.");
        } else {
            System.out.println("Pedidos encontrados:");
            for (Pedido p : Busca) {
                System.out.println("------------------------------------------------");
                System.out.println("Detalhes do pedido de" + p.getUsuario().getNome());
                System.out.println("------------------------------------------------");
                System.out.println("Data: " + p.getDtPedido());
                System.out.println("Status: " + p.getStatus());
                ArrayList<Item> itens = p.getItens();
                for (Item q : itens) {
                    System.out.println("Itens do pedido: " + q.getNome());
                }
            }
        }
    }

    private void buscarPedidosPorItem() {
        System.out.println("Digite o nome do item:");
        String nome = entrada.next();
        ArrayList<Pedido> Busca = pedidos.buscaPedidosPorItem(nome);
        if (Busca == null) {
            System.out.println("Nenhum pedido encontrado.");
        } else {
            System.out.println("Pedidos encontrados:");
            for (Pedido p : Busca) {
                System.out.println("------------------------------------------------");
                System.out.println("Detalhes do pedido de" + p.getUsuario().getNome());
                System.out.println("------------------------------------------------");
                System.out.println("Data: " + p.getDtPedido());
                System.out.println("Status: " + p.getStatus());
                ArrayList<Item> itens = p.getItens();
                for (Item q : itens) {
                    System.out.println("Itens do pedido: " + q.getNome());
                }
            }
        }
    }

    private void visualizarDetalhesPedido(){
        System.out.println("Digite o número do pedido: ");
        int cont = 0;
        String id = entrada.next();
        Pedido pedido = pedidos.buscaPedidoPorNumero(id);
        System.out.println("---------------------------------------");
        System.out.println("Detalhes do pedido n° " + pedido.getId());
        System.out.println("---------------------------------------");
        System.out.println("Usuário: " + pedido.getUsuario().getNome());
        System.out.println("Data: " + pedido.getDtPedido());
        System.out.println("Status: " + pedido.getStatus());
        for(Item i : pedido.getItens()){
            System.out.println("Item " + cont++ + " : " + i.getNome());
        }
        System.out.println("Valor total: R$" + pedido.getValorTotal(pedido.getItens()));
    }
/**
 private void visualizarDetalhesPedido() {
 ArrayList<Pedido> Busca = pedidos.buscaPedidoPorFuncionario(Logado.getId());
 int count =1;
 for (Pedido b : Busca) {
 System.out.println("Número do pedido: " + b.getNPedido());
 System.out.println("Funcionário que cadastrou: " + b.getUsuario());
 System.out.println("Data: " + b.getDtPedido());
 System.out.println("Status: " + b.getStatus());
 System.out.println("Valor total do pedido: " + b.getValTotal());
 ArrayList<Item> itens = b.getItens();
 for (Item q : itens) {
 System.out.println("Itens do pedido: " + q.getNome());
 }
 count++;
 }

 System.out.println("Digite o número do pedido que deseja atualizar:");
 int proxNum = entrada.nextInt();

 if(this.nPedido==proxNum){
 Pedido pedidoBuscado = buscaPedidoPorNumero(proxNum);

 return pedidoBuscado;
 }else{
 return "Pedido não encontrado";
 }
 }
 **/
}
