import java.util.Date;
import java.util.Scanner;

import Colecoes.ColecaoItens;
import Colecoes.ColecaoPedidos;
import Colecoes.ColecaoUsuarios;
import bean.Administrador;
import bean.Item;
import bean.Pedido;
import bean.Usuario;

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
        Administrador a = new Administrador("João", "123", "123456");
        usuarios.addUser(a);
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

    private ArrayList<Pedidos> listarPedidosEntreDatas(Date dataInicio, Date dataFim) {
        ArrayList pedidosData = new ArrayList();
        if(dataInicio.compareTo(dataFim) > 0){
            System.out.println("Datas inválidas.");
            return pedidosData;
        }
        for(Pedido p: Pedido){
            if(p.getDtConclusao().compareTo(dataInicio) >= 0 && p.getDtConclusao().compareTo(dataFim) <= 0){
                pedidosData.add(p);
            }
        }
        return pedidosData;
    }

    private void buscarPedidosPorFuncionario(Usuario i) {
        if(Usuario instanceof Funcionario){
            Funcionario f = (Funcionario) i;
             System.out.println("Pedidos encontrados por funcionário solicitante:");
             for(Pedido pedido: pedidos){
                if(pedido.getUsuario().equals(i)){
                    System.out.println("Detalhes do pedido: ");
                    System.out.println("Data: " + pedido.getDtPedido());
                    System.out.println("Status: " + pedido.getStatus());
                    System.out.println("Itens do pedido: " + pedido.getItens());
                    
                }
             }

        } else {
            System.out.println("Usuário não é um funcionário. ")
        }
    }

    private void buscarPedidosPorItem() {
        // TODO: Implementar lógica de busca de pedidos pela descrição de um item
        System.out.println("Pedidos encontrados pela descrição de um item:");
    }

    private void visualizarDetalhesPedido(ColecaoPedidos p) {
        
        System.out.println("Detalhes do pedido:"+ getPedidos());
    }
}
