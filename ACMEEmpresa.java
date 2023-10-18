import java.util.Date;
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

public class ACMEEmpresa {
    private Scanner entrada;
    private ColecaoUsuarios usuarios;
    private Usuario Logado;
    private ColecaoPedidos pedidos;

    public ACMEEmpresa() {
        entrada = new Scanner(System.in);
        usuarios = new ColecaoUsuarios();
        pedidos = new ColecaoPedidos();
        this.Logado = null;
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
        ColecaoItens itens1 = new ColecaoItens();
        itens1.addItem(i1);
        itens1.addItem(i2);
        itens1.addItem(i3);
        ColecaoItens itens2 = new ColecaoItens();
        itens2.addItem(i4);
        itens2.addItem(i5);
        itens2.addItem(i6);
        Date d1 = new Date();
        Date d2 = new Date(d1.getTime() + 3600000);
        Pedido p1 = new Pedido(f1, d1, itens1.getItens(), 0.0);
        Pedido p2 = new Pedido(f2, d2, itens2.getItens(), 0.0);
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
            this.Logado = found;
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
        Pedido p = new Pedido(Logado, d, itensPedido.getItens(), valorTotal);
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
                // case 1:
                // listarPedidosEntreDatas(Date dataFim, Date dataInicio);
                // break;
                // case 2:
                // buscarPedidosPorFuncionario();
                // break;
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

    /**
     * private ArrayList<ColecaoPedidos> listarPedidosEntreDatas(Date dataInicio,
     * Date dataFim) {
     * ArrayList pedidosData = new ArrayList();
     * if(dataInicio.compareTo(dataFim) > 0){
     * System.out.println("Datas inválidas.");
     * return pedidosData;
     * }
     * for(Pedido p : pedidos.getPedidos()){
     * if(p.getDtConclusao().compareTo(dataInicio) >= 0 &&
     * p.getDtConclusao().compareTo(dataFim) <= 0){
     * pedidosData.add(p);
     * }
     * }
     * return pedidosData;
     * }
     **/

    /**
     * private void buscarPedidosPorFuncionario(Usuario i) {
     * if(i instanceof Funcionario){
     * Funcionario f = (Funcionario) i;
     * System.out.println("Pedidos encontrados por funcionário solicitante:");
     * for(Pedido pedido : pedidos.getPedidos()){
     * if(pedido.getUsuario().equals(i)){
     * System.out.println("Detalhes do pedido: ");
     * System.out.println("Data: " + pedido.getDtPedido());
     * System.out.println("Status: " + pedido.getStatus());
     * System.out.println("Itens do pedido: " + pedido.getItens());
     * 
     * }
     * }
     * } else {
     * System.out.println("Usuário não é um funcionário. ");
     * }
     * }
     **/

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

    private void visualizarDetalhesPedido() {
        // TODO: Implementar lógica de visualização de detalhes de um pedido para
        // aprovação ou rejeição
        System.out.println("Detalhes do pedido:");
    }
}
