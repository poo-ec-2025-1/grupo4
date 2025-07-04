# Relatório Individual Victor Hugo de Oliveira Moreira

# atribuição de cargos e tarefas:
    A ideia inicial foi de um app de celular que permitisse que equipes de logística interna se comunicassem de forma mais eficiente com atravez do app; 

    A priori eu fiquei encarregado por idealizar e direcionar a equipe com o formato e a lógica do programa inicialmente e os diagramas se iniciaram a partir de minhas ideias e discuções da equipe(https://github.com/poo-ec-2025-1/grupo4/blob/main/diagramadecasodeuso.md), neste mesmo momento foi decidido a estruturação da equipe e fui responsabilizado por desenvolver a parte de controle do programa e definido com lider do grupo 4 para auxiliar e sincronizar o trabalho da equipe;
 
    Na prática, para que cumprisse da melhor forma, auxiliei na estruturação da visualização e modelagem para alem da controle e fui auxiliado por todos os meus parceiros de equipe;

    O repositório do código fonte foi clonado em duas pastas (src e resource), pois eu trabalhei utilizando a ide VsCode para src e José com BlueJ para resource, na última sincronização e organização feita por mim essa pastas se tornaram respectivamente VsCode e BlueJ.

    Estruturação dos Folders e github:
    [https://github.com/poo-ec-2025-1/grupo4/commit/8d5e35b62bf2e18274668967dfbd23cf72084f2a]

    sincronização do código:
    [https://github.com/poo-ec-2025-1/grupo4/commit/fc0fa7eb0d8cfd966f7b7c512c8d5189212c3576]
    [https://github.com/poo-ec-2025-1/grupo4/commit/8a1edc9d032ca071715c543ac881543e54df4cde]       

#  contribuição de acordo com o que foi atribuido:
  Contribui para:

  * CaixaControl.java :

  Inicialmente comecei os trabalhos com o objetivo de estruturar uma comunicação via web dentro do app, alcancei alguns resultados funcionais mas ficou evidente que para alcançar o objetivo final com essa tecnologia seria muito custoso considerando o prazo, então reformulamos o programa de forma que fosse simplesmente local mas ainda cumprindo a proposta;

  Apartir daí, retirei o que havia sido feito (Comunicador.java e Servidor.java) e introduzi a primeira estrutura do Caixa(CaixaControl.java e caixa.fxml). O que mais tarde foi sendo aperfeiçoado multiplas vezes por mim José Augusto e Yan Caser();

  [https://github.com/poo-ec-2025-1/grupo4/commit/8d5e35b62bf2e18274668967dfbd23cf72084f2a]

  * ScreenControl.java e ControlPrincipal.java e HomeControl.java:

  Afim de simplificar o trabalho, com base em códigos anteriores de josé [https://github.com/poo-ec-2025-1/grupo4/commit/d9839399b7dc7e98d946390d1dde2817b33f1f8c] e várias pesquisas, encontrei uma forma que não precisasse de classes de visualização mas somente do arquivo fxml, atraves da ScreenControl.java.
  
  Assim, estruturei a parte central do programa com a ControlPrincipal e HomeControl, as quais inicializam e comunicam todo o programa.

  [https://github.com/poo-ec-2025-1/grupo4/commit/a1186031bbd9ddb42bc67f86937ed829ad19dc8b]

  * CameraControl e ConferenteControl:

  Aqui introduzi a porta de entrada para os produtos na loja trabalhando com os recursos de bancos de dados que já tinhamos e também a utilização de fotos e camera no programa buscando por bibliotecas extras do sarxos[https://github.com/sarxos/webcam-capture].

  [https://github.com/poo-ec-2025-1/grupo4/commit/43b892fdc464336824f96c0a45486d2a4c308494]

# contribuição alem do atribuido:

  * caixaModel.java, Product.java, productRep.java, productDB.java:

  Aperfeiçoei os métodos model deixando eles mais enxutos.

  [https://github.com/poo-ec-2025-1/grupo4/commit/aa8eeb06c0137bfabb1c3f0f3cbdc35285c36cae]  

  * caixa.fxml, conferente.fxml, home.fxml, camera.fxml:

  Fiz a modelagem básica da página e ela foi sendo aperfeiçoada várias vezes por mim, josé e Yan;

  conferente.fxml:
  [https://github.com/poo-ec-2025-1/grupo4/commit/43b892fdc464336824f96c0a45486d2a4c308494]
  caixa.fxml:
  [https://github.com/poo-ec-2025-1/grupo4/commit/8d5e35b62bf2e18274668967dfbd23cf72084f2a]
  Home.fxml:
  [https://github.com/poo-ec-2025-1/grupo4/commit/9c61824c3f4b2a07e81129d42b92fc29fd93c3d8]

  * Tentei contribuir ao máximo com reuniões e comentários sobre o trabalho dos meus colegas

# considerações gerais:

  Através de desse trabalho nestes últimos dias eu aprendi bastante sobre importância de uma equipe bem seccionada e direcionada para se alcançar o objetivo de forma eficaz;
  Entendi sobre o caminho que a informação percorre desde a entrada pela tela até o processamento com o banco de dados;
  E compreender sobre a comunição das classes e seccionamento do objetivo em objetos que comunicam entre si foi essencial para que eu conseguisse concluir o projeto.

  Ficou inconcluso alguns objetivos como a comunicação web, serviços automáticos de averiguação do estoque e atribuição de fluxos de trabalho, esclarecimentos financeiros sobre o fluxo de produtos dentro da empresa e etc.

  No entanto, este projeto foi desafiador e o que foi feito é uma representação sulficiente sobre o objetivo que sonhavamos alcançar e que provavelmente eu ainda desenvolva no futuro próximo.  

