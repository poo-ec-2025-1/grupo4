# Relatório Individual da Etapa 2

- Aluno: José Augusto Gomes de Mendonça.

# - Atribuição de cargo e tarefas:
  O que foi estabelecido inicialmente era que eu ficasse responsável pelo model do projeto. Nesse caso eu teria que implementar toda a lógica 
  de negócios e o gerenciamento do banco de dados para passar para o controller.

  Na prática, devido ao excesso de classes modelo que precisavam ser validadas, mas que não tinham um controller ou tela prontos para que eu prosseguisse com o projeto, eu criei alguns controllers em conjunto com o líder do grupo e também criei algumas telas para dar continuidade.

  Além disso, o líder do grupo, Victor Hugo, me ajudou com o model, criando algumas classes modelo também, principalmente quando ele tinha uma ideia nova ou uma adaptação a ser feita. Depois que ele criava as classes, eu as analisava para ver o que poderia mudar ou ser corrigido para não ocasionar erros.

  De maneira geral, eu fiz muitas partes essenciais para o model e o controller do projeto, além de um rascunho inicial da view em algumas partes. Todas essas partes serão esclarecidas ao longo do relatório.

# - Contribuição de acordo com a atribuição:

  Em relação à atribuição que me foi passada, eu fiz inicialmente as seguintes classes modelo:
  * UserDB
  * UserRep
  * User
  * ProductDB
  * ProductRep
  * Product
  * RepositorioModel

  O commit que introduz a maioria dessas classes no repositório, exceto a classe RepositorioModel, está no seguinte link:

  [Link para o commit: Adicionando métodos para a classe CaixaModel e fazendo pequenas alterações no código.](https://github.com/poo-ec-2025-1/grupo4/commit/fb8385bc47f50a6cea1ebec85004f768055b90de)

  Já o commit que acrescenta a classe RepositorioModel ao projeto é o seguinte:

  [Link para o commit: Alterando algumas classes modelo e adicionando a classe RepositorioModel no projeto.](https://github.com/poo-ec-2025-1/grupo4/commit/e0e5c5437d34d15f2fa890fafab1db9ee76fa876)

  Esses commits apresentam o estado inicial das classes modelo, as alterações feitas estão nos commits posteriores. Mas em resumo, as classes têm as seguintes funções:
  -  UserDB e ProductDB fazem a conexão com o banco de dados com o nome que foi fornecido no construtor, eu separei em duas para deixar o código mais organizado, cada classe central Product e User tem a sua classe de banco de dados. Achei que assim seria mais fácil de entender.
  -  UserRep, ProductRep e RepositorioModel são as classes Repository que gerenciam e manipulam dados no banco de dados. São responsáveis por todo o CRUD do projeto. Além disso, cada uma tem métodos específicos para consulta ou validação de dados no banco, onde a classe UserRep é voltada para o usuário e as classes ProductRep e RepositorioModel são voltadas para o produto. ProductRep é mais geral e RepositorioModel é mais específica.
  -  Product e User são as entidades centrais que são manipuladas e inseridas no banco de dados, cada uma com seus atributos e métodos getters e setters.

  A documentação e os commits apresentam muito bem como funciona o fluxo do projeto, e mais detalhes sobre o model estão nos commits mencionados anteriormente.

  As principais dificuldades neste processo de modelagem das classes model foram:
  * Entender a lógica de negócios e construir um código com um fluxo que não tivesse inconsistências com essa lógica.
  * Perceber aquilo que muitas vezes era desnecessário para o código, por isso o código teve várias mudanças.
  * Tentar encontrar uma relação com os problemas a serem resolvidos e os conceitos apresentados em aula.

  O que não foi possível implementar:
  * O chat entre funcionários, para melhorar a comunicação entre eles em diferentes áreas do mercado.
  * As notificações de quando um produto é removido, adicionado, alterado ou vendido, para manter todos os funcionários atualizados do que está acontecendo.
  * A atribuição de diferentes acessos dependendo do cargo do funcionário.

# - Contribuição além do atribuído:

  Com relação àquilo que eu fiz no controller, eu ajudei na implementação das seguintes classes:
  * LoginController
  * CriacaoController
  * RepositorioController
  * EdicaoController

  As alterações que eu fiz nas classes LoginController e RepositorioController estão no seguinte commit:

  [Link para o commit: Adicionando modificações.](https://github.com/poo-ec-2025-1/grupo4/commit/dc51d8f6b40d6d429f48b8a818a42379bd426fbb)

  Já as alterações que eu fiz com a classe EdicaoController estão no seguinte commit:

  [Link para o commit: Adicionando arquivos para o Repositório.](https://github.com/poo-ec-2025-1/grupo4/commit/9ca52b2b5f3c422090a83041e6a89f1a1fac554c)

  Finalmente, as alterações que eu fiz no CriacaoController estão no seguinte commit:

  [Link para o commit: Adicionando a funcionalidade de criação de contas.](https://github.com/poo-ec-2025-1/grupo4/commit/1e34d6c82328ca7441c857982ee31e10b6d6b90d)

  Neste caso, o LoginController é o controlador da tela de login; o RepositorioController é o controlador do Repositório onde um usuário acessa os produtos através de uma pesquisa; o EdicaoController é o controlador da edição de produtos que ocorre quando um usuário seleciona um produto encontrado na pesquisa do repositório; e o CriacaoController é o controller para a tela de criação de usuários.

  Com relação àquilo que eu fiz na view, eu participei ajudando a fazer um rascunho das seguintes telas:
  * edicao.fxml
  * repositorio.fxml
  * criacao.fxml

  Os commits que mostram as alterações que eu fiz nas telas edicao.fxml, repositorio.fxml e criacao.fxml são os seguintes:

  [Link para o commit: Adicionando modificações.](https://github.com/poo-ec-2025-1/grupo4/commit/dc51d8f6b40d6d429f48b8a818a42379bd426fbb)

  [Link para o commit: Adicionando arquivos para o Repositório.](https://github.com/poo-ec-2025-1/grupo4/commit/9ca52b2b5f3c422090a83041e6a89f1a1fac554c)

  [Link para o commit: Ajustando tela para sincronizar com o código.](https://github.com/poo-ec-2025-1/grupo4/commit/e272ac585d7ed708775759908dc38e27c89581aa)

  [Link para o commit: Adicionando a funcionalidade de criação de contas.](https://github.com/poo-ec-2025-1/grupo4/commit/1e34d6c82328ca7441c857982ee31e10b6d6b90d)

  Essas alterações incluem apenas um rascunho da criação ou configuração, outras modificações de layout foram feitas pelo integrante do grupo responsável pelas telas.

  Também contribui com alterações importantes para toda a aplicação no seguinte commit:

  [Link para o commit: Código final do projeto.](https://github.com/poo-ec-2025-1/grupo4/commit/8660db8a319711eea8573365354adb0f023af516)

  Neste commit, eu atualizei o meu código com o código do líder do projeto. Logo em seguida, fiz as alterações necessárias e corrigi erros para fazer o programa funcionar. Ao finalizar tudo isso, usando o BlueJ, eu consegui criar o .jar para o projeto.

  Como ajudei outras pessoas a resolverem seus problemas?
  - Estou constantemente conversando com o líder do grupo para resolver erros, adicionar funcionalidades e tentar encaminhar o projeto da melhor forma possível.
  - Também converso com o João Pedro, responsável pela documentação, para ajudá-lo a deixá-la mais sincronizada com o projeto e coerente com o que estamos fazendo.

# Considerações gerais:

  * O que aprendi?

    Neste projeto, aprendi o básico sobre como fazer um CRUD e como a estrutura MVC funciona, mesmo que de forma simples. Além disso percebi as etapas que englobam o processo de desenvolvimento de sistemas, entendi a importância que um bom gerenciamento de dados tem em um sistema de forma geral e notei como a programação orientada a objetos tem um papel fundamental para criar um sistema escalável e de fácil manutenção.

  * Quais trabalhos futuros ficaram pendentes?
      * A questão de implementar o uso da internet no nosso sistema.
      * Implementar o chat para os funcionários.
      * Implementar um serviço de notificações para alertar sobre o que acontece no app.
      * Possivelmente, adicionar funcionalidades relacionadas à contabilidade do supermercado ou loja.

  * Conclusão:

    Esse projeto foi desafiador para mim, mas consolidou uma base de aprendizado para o desenvolvimento de software que é essencial no mercado de trabalho. Além disso, atendeu ao que foi proposto na disciplina, apresentando a programação orientada a objetos como uma alternativa para a resolução de problemas reais.
