#  Projeto do Grupo 4 – Sistema de Organização de Estoques

##  Membros do Grupo

- **Vitor Hugo de Oliveira Moreira** –  *Controlador (Controller)* – `@toorugo`
- **João Pedro Rodrigues de Almeida** – *Documentação* – `@JoaoAlmeida2005`
- **José Augusto Gomes de Mendonça** – *Modelagem (Model)* – `@JoseAugustoGM`
- **Yan Freire Caser** – *Interface (View)* – `@yancaser`

---

##  Seção 1: Visão Geral do Projeto

Nosso aplicativo tem como objetivo **melhorar a organização do estoque** e otimizar a **comunicação entre os funcionários**, com foco no setor de logística de comércios varejistas.

A ideia é permitir que os colaboradores registrem e acessem facilmente informações sobre os produtos nas prateleiras e no estoque, favorecendo o fluxo de informações e reduzindo erros.

### Funcionalidades principais:

- **Login de usuário**
  - Cada usuário acessa com login e senha.
  - Não há distinção entre administrador e funcionário, somente o Usuário.
  
- **Menu com 3 opções após login:**
  1. *Repositório* - Consulta, atualiza, deleta ou altera a quantidade de produtos na loja e no estoque.
  2. *Conferente* – Cadastro, consulta e atualização de produtos.
  3. *Caixa* – Vende os produtos e atualiza sua quantidade na loja e estoque.
  

### Problemas identificados:

- Baixa eficiência logística no comércio de varejo.
- Falta de interação e comunicação entre funcionários.
- Dificuldade na entrada, saída e localização de produtos.
- Ausência de uma plataforma centralizada e acessível para controle do estoque.

### Motivação:

A motivação surgiu a partir da vivência real de membros do grupo que trabalharam em locais com esse tipo de dificuldade. Notou-se a ausência de uma solução prática e digital que organizasse essas informações de forma compartilhada, clara e funcional.

---

##  Seção 2: Objetivo Geral

Criar um aplicativo que auxilie estabelecimentos comerciais no gerenciamento de produtos, organização da equipe, controle de tempo e melhoria da comunicação interna.

---

##  Seção 3: Organização das Tarefas

| Membro                          | Responsabilidade         |
|---------------------------------|--------------------------|
| João Pedro Rodrigues de Almeida | Documentação             |
| José Augusto Gomes de Mendonça  | Modelagem de dados       |
| Vitor Hugo de Oliveira Moreira  | Controlador (Controller) | 
| Yan Freire Caser                |Interface gráfica (View)  |

---

## Seção 4: Modelagem Inicial:

 ## Diagrama de Sequência:

![image](https://github.com/user-attachments/assets/fdb345fa-be57-429e-9b8a-cbdb5c5f292d)
---

 ## Diagrama de Classes:
![image](https://github.com/user-attachments/assets/65c1f76a-8e8d-42ff-ae47-e1406323af91)
---

 ## Diagrama de casos de uso:

![image](https://github.com/user-attachments/assets/529e116d-3d90-4aa3-8505-17a9da10f902)
---
## Casos de Uso:

### 1.  Cadastrar Produto

| Campo            | Descrição                                                                 |
|------------------|---------------------------------------------------------------------------|
| **Ator Principal**      |  Usuário autenticado.             |
| **Objetivo**     | Adicionar um novo produto ao sistema com todas as informações necessárias.|
| **Pré-condição** | Estar logado no sistema.                                                  |
| **Fluxo Principal** | 1. Acessa tela de cadastro. <br> 2. Preenche dados do produto (nome, validade, categoria, localização, quantidade, etc). <br> 3. Clica em "Salvar". <br> 4. Sistema valida e grava os dados. <br> 5. Confirmação é exibida. |
| **Fluxo Alternativo** | Campos obrigatórios ausentes → erro exibido e cadastro não finalizado. |
| **Pós-condição** | Produto salvo no sistema e visível na listagem de estoque.                |

---

### 2.  Consultar Estoque

| Campo            | Descrição                                                                 |
|------------------|---------------------------------------------------------------------------|
| **Ator Principal**      | Usuário autenticado.                                             |
| **Objetivo**     | Ver os produtos cadastrados e seus dados.                                 |
| **Pré-condição** | Estar logado no sistema.                                                  |
| **Fluxo Principal** | 1. Acessa tela de consulta. <br> 2. Visualiza lista de produtos. <br> 3. Pode usar filtros ou pesquisar por nome/código. |
| **Fluxo Alternativo** | Produto não encontrado → mensagem de "nenhum resultado".              |
| **Pós-condição** | Produtos exibidos com seus dados atualizados.                            |

---

### 3.  Atualizar Informações de Produto

| Campo            | Descrição                                                                 |
|------------------|---------------------------------------------------------------------------|
| **Ator Principal**      | Usuário autenticado.                                             |
| **Objetivo**     | Corrigir ou alterar informações de um produto.                            |
| **Pré-condição** | Produto já existente e login realizado.                                   |
| **Fluxo Principal** | 1. Acessa tela de consulta. <br> 2. Seleciona produto. <br> 3. Altera campos desejados. <br> 4. Salva alterações. <br> 5. Sistema confirma atualização. |
| **Pós-condição** | Informações do produto atualizadas com sucesso.                          |

---

### 4.  Vender Produto

| Campo            | Descrição                                                                 |
|------------------|---------------------------------------------------------------------------|
| **Ator Principal**      |  Usuário autenticado.                                             |
| **Objetivo**     | Reduzir quantidade de um produto ao ser retirado do estoque.              |
| **Pré-condição** | Produto deve existir e ter quantidade disponível.                         |
| **Fluxo Principal** | 1. Localiza o produto. <br> 2. Informa a quantidade a ser retirada. <br> 3. Clica em "Confirmar Baixa". <br> 4. Sistema atualiza o estoque. |
| **Fluxo Alternativo** | Quantidade solicitada maior do que disponível → erro exibido.         |
| **Pós-condição** | Quantidade do produto atualizada na loja.                             |

---

### 5.  Realizar Login

| Campo            | Descrição                                                                 |
|------------------|---------------------------------------------------------------------------|
| **Ator Principal**      |  Usuário autenticado.                |
| **Objetivo**     | Acessar o sistema de acordo com seu perfil.                               |
| **Pré-condição** | Ter uma conta cadastrada.                                                 |
| **Fluxo Principal** | 1. Informa login e senha. <br> 2. Sistema verifica credenciais. <br> 3. Usuário é redirecionado para sua tela inicial. |
| **Fluxo Alternativo** | Dados inválidos → mensagem de erro.                                  |
| **Pós-condição** | Acesso permitido ao sistema com base no perfil.                          |
