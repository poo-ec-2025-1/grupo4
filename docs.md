# Documentação do Source Code.
## Sobre o Projeto: 
*Sistema de Gestão de Estoque*
# 1. Visão Geral
*Este projeto é um sistema simples e eficiente para gerenciamento de estoque, desenvolvido em Java com uma interface gráfica feita em JavaFX. O sistema foi estruturado usando o padrão Model-View-Controller (MVC), que ajuda a organizar o código e facilitar futuras manutenções. Ele permite que os usuários adicionem, consultem, atualizem e controlem produtos no estoque de forma prática.*

# 2. Funcionalidades Principais
**Inclusão e edição de produtos com detalhes como nome, categoria, validade, localização e quantidade.*

**Consulta rápida e filtragem do estoque para encontrar produtos facilmente.*

**Registro da saída de produtos, reduzindo o estoque conforme retiradas.*

*Sistema de login.

# 3. Tecnologias Utilizadas
## Linguagem: 
Java

## Interface: 
JavaFX para construção da interface visual.

## Banco de dados: 
SQLite para armazenamento local dos dados.

## Arquitetura:
MVC para organizar o sistema.

## Ferramentas: 
Scene Builder para ajudar na criação das telas.

# 4. Requisitos

## -Funcionais

**Cadastro e edição de produtos com validação de dados.*

**Pesquisa e listagem de produtos no estoque.*

**Atualização de informações de produtos já cadastrados.*

**Controle de retirada de produtos do estoque.*

**Controle de usuários.* 

## -Não Funcionais

**Código organizado e modular seguindo boas práticas de programação orientada a objetos.*

**Uso de banco de dados local para garantir persistência dos dados.*

**Interface intuitiva, com foco na facilidade de uso.*

**Documentação clara para facilitar o entendimento do projeto.*

# 5. Princípios de Programação Orientada a Objetos Aplicados

## Encapsulamento: 
*Mantemos os dados protegidos e acessados via métodos públicos.*

## Polimorfismo: 
*Possibilidade de tratar diferentes tipos de usuários e ações de forma genérica.*

## Abstração: 
*Definimos estruturas comuns para simplificar o desenvolvimento.*

# 6. Estrutura do Sistema

## Modelo:
*Classes que representam produtos, usuários e operações de banco de dados.*

## Visão: 
*Telas feitas com JavaFX que interagem com o usuário.*

## Controle:
*Classes que recebem eventos da interface e coordenam as ações com os dados.*

# 7. Desenvolvimento e Testes

**Desenvolvimento gradual, começando pela modelagem dos dados e interfaces.*

**Testes manuais para garantir o funcionamento do cadastro, consulta, atualização e login.*

**Uso de diagramas para auxiliar o planejamento e a documentação do sistema.*

# 8. Diagramas (em planejamento)

## Diagramas de classes:
*Usado para entender as relações entre entidades.*

## Diagrama de Sequência:
*Usado para detalhar os processos mais importantes.*

## Casos de uso e Diagrama de casos de uso:
*Usados para mostrar as interações dos usuários com o sistema.*
# 9. Uso do Sistema
*1-Faça login com seu usuário e senha cadastrados.*

*2-Cadastre novos produtos preenchendo os dados necessários.*

*3-Consulte e filtre os produtos existentes no estoque.*

*4-Atualize as informações dos produtos quando necessário.*

*5-Registre a saída de produtos para controlar a quantidade disponível.*

# 10. Considerações Finais
*Este sistema busca oferecer uma solução simples e funcional para o controle de estoque. Com a arquitetura MVC e o uso da programação orientada a objetos, ele é preparado para facilitar adaptações futuras e a inclusão de novas funcionalidades. A interface foi desenvolvida para ser fácil de usar, garantindo uma boa experiência para os usuários.*

# 11. Próximos Passos
**Implementar filtros avançados e opções de pesquisa aprimoradas.*

**Adicionar gráficos e exportação de relatórios.*

**Criar alertas para produtos com estoque baixo ou perto da validade.*

**Melhorar a segurança e os níveis de acesso dos usuários.*

**Tornar a interface mais dinâmica e responsiva.*
