# grupo4
Projeto do Grupo 4
Seção 1: Nosso app tem como objetivo melhorar a dinâmica de organização de estoques e otimizar a comunicação da equipe de logística com relação a estocagem e eficiência de tempo.
O funcionamento do nosso app é simples, terá um layoult inicial em que o usuário insira seu login e senha, criados pelo Adm, responsável pela criação e gerenciamento dos logins. Assim que o usuário entre na página seguinte, terá opções 4 opções para escolher: 1- layolt de Loja; 2- Configuração de Estoque; 3- Notificações de loja; 4- Chat de conversa.
Assim poderá conferir informações geradas por outros usuários e gerar as suas proprias informações a respeito de produtos presentes no estoque e nas prateleiras. 
Temos como principal público-alvo o Comércios de varejo. 
O principal problema hoje na questão dos estoques é a ineficiência na logística de comércios de varejo, uma vez que é extremamente complexo a organização de estoque unida à entrada e à saída de produtos do estabelecimento pela falta de interações entre funcionários.  
Nossa motivação para o densenvolvimento desse sistema está diretamente ligada á questão prática, já que o problema foi vivenciado por alguns integrantes do grupo, que sofreram com a ausência de uma plataforma/entidade auxiliadora.

Seção 2: Nosso objetivo geral com esse app é auxiliar os estabelecimentos com a questão da organização de seus produtos, funcionários, tempo e financeiro. 

Seção 3: A organição das tarefas do grupo foi decidida desta maneira:
João Pedro Rodrigues de Almeida(JoaoAlmeida2005): Documentação do Projeto;
José Augusto Gomes de Mendonça(JoseAugustoGM): Model;
Vitor Hugo de Oliveira Moreira(Toorugo): View;
Yan Freire Caser(yancaser) : Controller;

Seção 4: Modelagem Inicial:
 
 Diagrama de casos de uso

![image](https://github.com/user-attachments/assets/529e116d-3d90-4aa3-8505-17a9da10f902)

@startuml

title Diagrama de Caso de Uso - Sistema de Estoque


actor Usuário

usecase "Realizar Login" as UC1

usecase "Gerenciar quantidade de produtos" as UC2

usecase "Consultar estoque" as UC3

usecase "Cadastrar um novo produto" as UC4

usecase "Vender Produtos" as UC5

Usuário --> UC1

Usuário--> UC2

Usuário--> UC3

Usuário --> UC4

Usuário --> UC5

@enduml
