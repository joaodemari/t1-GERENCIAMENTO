import java.util.Scanner;

import bean.Administrador;
import bean.Usuario;

public class ACMEEmpresa {
    private Scanner entrada;
    private Usuarios usuarios;
    private Usuario Logado;

    public ACMEEmpresa() {
        entrada = new Scanner(System.in);
        usuarios = new Usuarios();
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
                    break;
                default:
                    System.out.println("Entrada inválida.");
            }
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
        // TODO: Implementar lógica de registro de pedido
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

    private void listarPedidosEntreDatas() {
        // TODO: Implementar lógica de listagem de pedidos entre duas datas
        System.out.println("Lista de pedidos entre duas datas:");
    }

    private void buscarPedidosPorFuncionario() {
        // TODO: Implementar lógica de busca de pedidos por funcionário solicitante
        System.out.println("Pedidos encontrados por funcionário solicitante:");
    }

    private void buscarPedidosPorItem() {
        // TODO: Implementar lógica de busca de pedidos pela descrição de um item
        System.out.println("Pedidos encontrados pela descrição de um item:");
    }

    private void visualizarDetalhesPedido() {
        // TODO: Implementar lógica de visualização de detalhes de um pedido para
        // aprovação ou rejeição
        System.out.println("Detalhes do pedido:");
    }
}
