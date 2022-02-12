# Sistema de controle entrada e saída de veículos 



O Sistema consiste  na verificação de entrada e saída de veículos com finalidade de controlar os acessos nos locais restritos, visando manter a segurança, para essa finalidade foi criado um esboço da aplicação em uma diagrama de classe com relacionamento das classes, das quais são apresentadas as entidades com as características que vão ajudar na identificação do veículo como, código único, modelo, marca, cor, placa, o sistema terá também algumas funções importantes como adicionar, editar , pesquisar e excluir um veículo na sua base de dados, e assim manter maior controle dessas informações.
É um projeto inicial ao qual passará por novas versões até ser totalmente modelo, irão ocorrer testes e avaliações criteriosas focado na melhoria continua do desenvolvimento das suas funcionalidades que tem foco principal no controle e segurança.
No projeto serão usada as seguinte tecnologias no desenvolvimento desse projeto Java 11 , framework Spring Boot além de recursos adicionais com banco de dados.  
### Diagrama de classes
![](img/img_diagrama_class.png)

Depois de modelara o projeto com no diagrama de classes, foram cridas as classes do projeto conforme os requisitos do desafio da beca Java:

1. Modelar o Projeto criando entidades.
2. Entendimento dos protocolos Http e confecção dos controllers.
3. Introdução e confecção service.
4. Conexão com uma base de dados utilizando JPA.
5. Aplicar conceitos DTO no projeto.
6. Conceitos de validação, tratamento e manipulação de dados de forma otimizada.
7. Entendimento de como tratar possáveis erros na API.
8. Integração do API com Docker.

###Objetivo do projeto
Aplicação como visa manter a segurança de qualquer veículo venha acessar um determinado local que seja restrito sua entrada, ao ser adicionado informações do veículo da sua placa, modelo, cor , marca e tipo, estará na base de dados daquele estabelecimento para tranquilidade dos clientes e das empresas.  
### Tecnologia aplicada:
* Java versão 11
* Spring Boot
* IntelliJ IDEA
* Postman

![](img/tecnologia_aplicada.png)
##### Teste realizado com método POST:
![](img/img_api_criando-carro.png)
##### Realizado com método Patch:
![](img/img_api_atualizacao-carro.png)

###Utilização banco de dados H2 console do Spring Boot com Postman
