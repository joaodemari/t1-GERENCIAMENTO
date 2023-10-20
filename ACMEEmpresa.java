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
        Funcionario f2 = new Funcionario("Pedro", "789", "345678");
        Funcionario f3 = new Funcionario("Alice", "789", "123456");
        Funcionario f4 = new Funcionario("Bob", "012", "567890");
        Funcionario f5 = new Funcionario("Eve", "345", "678901");
        Funcionario f6 = new Funcionario("Charlie", "901", "234567");
        Funcionario f7 = new Funcionario("David", "234", "456789");
        Funcionario f8 = new Funcionario("Grace", "567", "890123");
        Funcionario f9 = new Funcionario("Hannah", "678", "901234");
        Funcionario f10 = new Funcionario("Isabel", "789", "012345");
        Funcionario f11 = new Funcionario("James", "890", "123456");
        Funcionario f13 = new Funcionario("Lily", "456", "567890");
        Funcionario f14 = new Funcionario("Michael", "567", "678901");
        Funcionario f15 = new Funcionario("Nina", "678", "789012");

        // Add the additional Funcionario objects to the ColecaoUsuarios
        usuarios.addUser(f3);
        usuarios.addUser(f4);
        usuarios.addUser(f5);
        usuarios.addUser(f6);
        usuarios.addUser(f7);
        usuarios.addUser(f8);
        usuarios.addUser(f9);
        usuarios.addUser(f10);
        usuarios.addUser(f11);
        usuarios.addUser(f13);
        usuarios.addUser(f14);
        usuarios.addUser(f15);
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
        Date d2 = new Date(d1.getTime() - 3600000);

        Pedido p2 = new Pedido("2", f2, d2, itens2.getItens(), 0.0);
        pedidos.addPedido(p2);
        usuarios.addUser(a);

        usuarios.addUser(f2);
        Item i7 = new Item("Item 7", "Description 7", 7.0, 7);
        Item i8 = new Item("Item 8", "Description 8", 8.0, 8);
        Item i9 = new Item("Item 9", "Description 9", 9.0, 9);
        Item i10 = new Item("Item 10", "Description 10", 10.0, 10);
        Item i11 = new Item("Item 11", "Description 11", 11.0, 11);
        Item i12 = new Item("Item 12", "Description 12", 12.0, 12);
        Item i13 = new Item("Item 13", "Description 13", 13.0, 13);
        Item i14 = new Item("Item 14", "Description 14", 14.0, 14);
        Item i15 = new Item("Item 15", "Description 15", 15.0, 15);

        ArrayList<Item> itens5 = new ArrayList<>();
        itens5.add(i7);
        itens5.add(i8);

        ArrayList<Item> itens6 = new ArrayList<>();
        itens6.add(i9);
        itens6.add(i10);

        ArrayList<Item> itens7 = new ArrayList<>();
        itens7.add(i11);
        itens7.add(i12);

        ArrayList<Item> itens8 = new ArrayList<>();
        itens8.add(i13);
        itens8.add(i14);

        ArrayList<Item> itens9 = new ArrayList<>();
        itens9.add(i15);

        Date d3 = new Date();
        Date d4 = new Date(d3.getTime() + 3600000);
        Date d5 = new Date(d4.getTime() + 3600000);
        Date d6 = new Date(d5.getTime() + 3600000);
        Date d7 = new Date(d6.getTime() + 3600000);
        Date d8 = new Date(d7.getTime() + 3600000);
        Date d9 = new Date(d8.getTime() + 3600000);

        Pedido p3 = new Pedido("3", f3, d3, itens5, 0.0);
        Pedido p4 = new Pedido("4", f4, d4, itens6, 0.0);
        Pedido p5 = new Pedido("5", f5, d5, itens7, 0.0);
        Pedido p6 = new Pedido("6", f6, d6, itens8, 0.0);
        Pedido p7 = new Pedido("7", f7, d7, itens9, 0.0);

        pedidos.addPedido(p3);
        pedidos.addPedido(p4);
        pedidos.addPedido(p5);
        pedidos.addPedido(p6);
        pedidos.addPedido(p7);
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
            Logado = found;
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
            // se usuario logado for funcionario ->
            if (!Logado.isAdmin()) {
                System.out.println("[2] Ver meus últimos pedidos");
            } else {
                System.out.println("[2] Pedidos (Menu Pedidos)");
            }
            opc = entrada.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Deslogando do sistema...");
                    break;
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    if (Logado instanceof Funcionario) {
                        verPedidosFuncionario();
                    }
                    if (Logado instanceof Administrador) {
                        menuPedidos();
                    }
                    break;
                default:
                    System.out.println("Entrada inválida.");
            }
        }
    }

    private void verPedidosFuncionario() {
        ArrayList<Pedido> Busca = pedidos.buscaPedidoPorFuncionario(Logado.getId());
        int count = 1;
        for (Pedido b : Busca) {
            System.out.println("------------------------------------------------");
            System.out.println("Detalhes do pedido n° " + b.getId());
            System.out.println("------------------------------------------------");
            System.out.println("Data: " + b.getDtPedido());
            System.out.println("Status: " + b.getStatus());
            System.out.println("Valor total do pedido: " + b.getValorTotal(b.getItens()));
            ArrayList<Item> itens = b.getItens();
            for (Item q : itens) {
                System.out.println("Itens do pedido: " + q.getNome());
            }
            count++;
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

        try {
            System.out.println("Digite a data inicial:");
            String dataInicial = entrada.next();
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            Date dtInicial = df.parse(dataInicial);
            System.out.println("Digite a data final:");
            String dataFinal = entrada.next();
            ArrayList<Pedido> Busca = new ArrayList<>();
            Date dtFinal = df.parse(dataFinal);
            for (Pedido pedido : pedidos.getPedidos()) {
                if (pedido.getDtConclusao() != null) {
                    if (pedido.getDtPedido().getTime() > dtInicial.getTime()
                            && pedido.getDtPedido().getTime() < dtFinal.getTime()) {

                        Busca.add(pedido);
                    }
                }
            }
            if (Busca.size() < 1) {
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

        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Certifique-se de usar o formato correto.");
        } catch (NullPointerException e) {
            System.out.println("Pedido sem data de conclusão.");
        }
    }

    private void buscarPedidosPorFuncionario() {
        System.out.println("Digite o id do funcionário");
        String id = entrada.next();
        ArrayList<Pedido> Busca = pedidos.buscaPedidoPorFuncionario(id);
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

    private void visualizarDetalhesPedido() {
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
        for (Item i : pedido.getItens()) {
            System.out.println("Item " + cont++ + " : " + i.getNome());
        }
        System.out.println("Valor total: R$" + pedido.getValorTotal(pedido.getItens()));
    }
    /**
     * private void visualizarDetalhesPedido() {
     * ArrayList<Pedido> Busca = pedidos.buscaPedidoPorFuncionario(Logado.getId());
     * int count =1;
     * for (Pedido b : Busca) {
     * System.out.println("Número do pedido: " + b.getNPedido());
     * System.out.println("Funcionário que cadastrou: " + b.getUsuario());
     * System.out.println("Data: " + b.getDtPedido());
     * System.out.println("Status: " + b.getStatus());
     * System.out.println("Valor total do pedido: " + b.getValTotal());
     * ArrayList<Item> itens = b.getItens();
     * for (Item q : itens) {
     * System.out.println("Itens do pedido: " + q.getNome());
     * }
     * count++;
     * }
     * 
     * System.out.println("Digite o número do pedido que deseja atualizar:");
     * int proxNum = entrada.nextInt();
     * 
     * if(this.nPedido==proxNum){
     * Pedido pedidoBuscado = buscaPedidoPorNumero(proxNum);
     * 
     * return pedidoBuscado;
     * }else{
     * return "Pedido não encontrado";
     * }
     * }
     **/
}
