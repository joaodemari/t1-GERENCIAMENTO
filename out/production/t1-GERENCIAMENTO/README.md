Menu 1 (Menu Principal):

[0] Sair do Sistema
[1] Logar
Menu Funcionário:

[0] Deslogar do Sistema
[1] Registrar um novo pedido de aquisição
[2] Ver Meus Últimos Pedidos
Menu Administrador:

[0] Deslogar do Sistema
[1] Registrar um novo pedido de aquisição
[2] Pedidos (Menu Pedidos)
Menu Pedidos (Submenu do Administrador):

[0] Voltar ao Menu Anterior (Administrador)
[1] Listar todos os pedidos entre duas datas
[2] Buscar pedidos por funcionário solicitante
[3] Buscar pedidos pela descrição de um item
[4] Visualizar os detalhes de um pedido para aprová-lo ou rejeitá-lo
=======================================
Classe Usuario
Atributos:

idUsuario: Identificador único do usuário.
nome: Nome do usuário.
tipo: Tipo do usuário (funcionário ou administrador).
Operações:

Construtor para inicializar os atributos.
Métodos para acessar e modificar os atributos.
====================================
Classe Departamento
Atributos:

nomeDepartamento: Nome do departamento.
limitePorPedido: Valor máximo permitido por pedido para este departamento.
Operações:

Construtor para inicializar os atributos.
Métodos para acessar e modificar os atributos.

========================================
Classe Funcionario
Atributos:

Herda os atributos da classe Usuario.
departamento: Departamento ao qual o funcionário está alocado.
Operações:

Construtor para inicializar os atributos.
Métodos para acessar e modificar os atributos.
============================================
Classe PedidoAquisicao
Atributos:

funcionarioSolicitante: Referência ao funcionário que fez o pedido.
departamentoSolicitante: Referência ao departamento do funcionário.
dataPedido: Data do pedido.
dataConclusao: Data de conclusão do pedido (pode ser nulo se o pedido estiver aberto).
statusPedido: Status do pedido (aberto, aprovado, reprovado).
itens: Lista de itens a serem adquiridos (contendo descrição, valor unitário, quantidade e total do item).
valorTotalPedido: Valor total do pedido.
Operações:

Construtor para inicializar os atributos.
Métodos para acessar e modificar os atributos.
Métodos para adicionar itens ao pedido.
Método para calcular o valor total do pedido.
Método para alterar o status do pedido.

============================================
Classe Administrador
Atributos:

Herda os atributos da classe Usuario.
Operações:

Construtor para inicializar os atributos.
Métodos para acessar e modificar os atributos.
Métodos para avaliar pedidos (listar pedidos entre datas, buscar por funcionário, buscar por descrição, visualizar detalhes e aprovar/reprovar pedidos).
================================================
Classe Estatisticas
Operações:

Métodos para calcular estatísticas gerais (número total de pedidos, percentuais de pedidos aprovados/reprovados, número de pedidos nos últimos 30 dias, valor médio dos pedidos nos últimos 30 dias, valor total de cada categoria nos últimos 30 dias, detalhes do pedido de aquisição de maior valor ainda aberto).
Esta é uma visão geral das classes e suas operações. Você precisará implementar essas classes de acordo com os requisitos específicos do sistema em Java, adicionando os métodos e lógica necessários para cada funcionalidade. Certifique-se de estabelecer relações apropriadas entre as classes, como a associação entre Funcionario e Departamento, para atender aos requisitos do sistema.
==================================================
Classe ItemAquisicao
Atributos:

descricao: Descrição do item.
valorUnitario: Valor unitário do item.
quantidade: Quantidade do item.
totalItem: Total do item (calculado como valorUnitario \* quantidade).
Operações:

Construtor para inicializar os atributos.
Métodos para acessar e modificar os atributos.

=======================================================
Classe Menu
Operações:

Métodos para exibir os menus e receber a entrada do usuário para selecionar as opções de menu.
Métodos para interagir com o usuário, como receber dados de entrada.
Classe SistemaAquisicao (Classe Principal)
Operações:

Método principal main para iniciar e controlar o fluxo do programa.
Métodos para gerenciar a lógica de login e logout.
Métodos para implementar as funcionalidades de registrar um novo pedido de aquisição, ver os últimos pedidos do funcionário e acessar o menu de pedidos (para administradores).
Métodos para calcular estatísticas gerais com base nos requisitos fornecidos.
===========================================================================
