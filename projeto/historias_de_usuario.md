# Histórias de usuário

1. **Cadastro de usuário**  
   Eu como **usuário (cliente ou agente)**  
   Quando **quero acessar o sistema**  
   Quero um **formulário de cadastro**  
   Para que **possa fornecer minhas informações e acessar as funcionalidades**

   **Critérios de aceite:**  
   - Dado que **o usuário do tipo cliente acessa a página de cadastro**, deve haver um formulário para inserir RG, CPF, nome, endereço, profissão, entidades empregadoras e rendimentos (máximo 3).  
   - Dado que **o usuário do tipo agente acessa a página de cadastro**, deve haver um formulário para inserir nome, endereço, CNPJ, e-mail e telefone.

2. **Introduzir pedido de aluguel**  
   Eu como **cliente**  
   Quando **quero alugar um automóvel**  
   Quero um **formulário de pedido de aluguel**  
   Para que **possa enviar meu pedido com os detalhes do veículo e contrato**

   **Critérios de aceite:**  
   - Dado que **o cliente preenche o formulário de pedido**, deve haver campos para selecionar o veículo, matrícula, ano, marca, modelo e placa.
   - Deve haver a opção de escolher a duração do contrato (12, 24, 36 ou 48 meses).
   - O sistema deve permitir ao cliente indicar se deseja a possível compra do veículo ao final do contrato.

3. **Modificar pedido de aluguel**  
   Eu como **cliente**  
   Quando **quero alterar meu pedido de aluguel**  
   Quero uma **opção de modificação**  
   Para que **possa ajustar os detalhes do pedido antes da execução do contrato**

   **Critérios de aceite:**  
   - Dado que **o cliente acessa o pedido**, deve permitir a edição dos detalhes do pedido (ex: veículo, duração do contrato, opção de compra).

4. **Consultar pedidos de aluguel**  
   Eu como **cliente**  
   Quando **quero visualizar meus pedidos de aluguel**  
   Quero uma **página de consulta de pedidos**  
   Para que **possa ver o status e detalhes dos meus pedidos**

   **Critérios de aceite:**  
   - Dado que **o cliente acessa a página de pedidos**, deve exibir uma lista com os pedidos e seus respectivos status, tipo de contrato, veículo e data de solicitação.

5. **Cancelar pedido de aluguel**  
   Eu como **cliente**  
   Quando **decido não prosseguir com o aluguel**  
   Quero uma **opção de cancelamento de pedido**  
   Para que **possa cancelar o pedido antes da execução do contrato**

   **Critérios de aceite:**  
   - Dado que **o cliente acessa a lista de pedidos**, deve permitir cancelar um pedido antes da execução do contrato.

6. **Avaliação de pedidos pelos agentes**  
   Eu como **agente (empresa ou banco)**  
   Quando **recebo um pedido de aluguel para avaliação**  
   Quero uma **ferramenta para avaliar a viabilidade financeira do pedido**  
   Para que **possa decidir se o contrato pode ser executado ou não**

   **Critérios de aceite:**  
   - Dado que **um agente acessa o pedido**, deve permitir a inserção de uma avaliação financeira e o status (aprovado/rejeitado).

7. **Execução do contrato**  
   Eu como **cliente com pedido aprovado**  
   Quando **meu pedido é aprovado**  
   Quero **revisar e aceitar o contrato de aluguel**  
   Para que **o aluguel seja formalizado**

   **Critérios de aceite:**  
   - Dado que **o cliente tem um pedido aprovado**, deve permitir revisar o contrato antes de aceitar ou rejeitar a execução.

8. **Registro da propriedade do veículo**  
   Eu como **cliente, empresa ou banco**  
   Quando **alugo um veículo**  
   Quero que **o veículo seja registrado com a propriedade adequada**  
   Para que **os documentos de propriedade sejam emitidos corretamente**

   **Critérios de aceite:**  
   - Dado que **o contrato é formalizado**, o sistema deve registrar a propriedade do veículo no nome do cliente, empresa ou banco conforme o tipo de contrato.

9. **Associação de contrato de crédito (seguro)**  
   Eu como **agente bancário**  
   Quando **aprovo um pedido de aluguel**  
   Quero **associar um contrato de crédito (seguro)**  
   Para que **o cliente tenha cobertura financeira adicional durante o período de aluguel**

   **Critérios de aceite:**  
   - Dado que **um pedido é aprovado**, o sistema deve permitir que o agente associe um contrato de crédito (seguro) ao pedido.

10. **Consulta de status de pedidos por agentes**  
    Eu como **agente (empresa ou banco)**  
    Quando **quero acompanhar os pedidos em análise**  
    Quero **consultar uma lista de pedidos pendentes ou aprovados/rejeitados**  
    Para que **possa gerenciar o fluxo de trabalho**

    **Critérios de aceite:**  
    - Dado que **o agente acessa a página de pedidos**, o sistema deve exibir uma lista de pedidos com seus status atuais.