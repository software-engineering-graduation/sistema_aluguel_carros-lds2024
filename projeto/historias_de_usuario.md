# Histórias de usuário

### 1. **Cadastro de Usuário**
   - **Como um cliente**, quero me cadastrar no sistema fornecendo minhas informações pessoais (RG, CPF, nome, e-mail, senha, profissão, empregadores e rendimentos), para que eu possa utilizar o sistema para realizar pedidos de aluguel.
     - **Critérios de Aceite:**
       - O sistema deve validar que todas as informações obrigatórias (RG, CPF, nome, e-mail, senha) foram preenchidas.
       - O sistema deve verificar que o CPF é único e válido.
   
   - **Como um agente (empresa ou banco)**, quero me cadastrar no sistema fornecendo minhas informações para acessar e avaliar pedidos de aluguel.
     - **Critérios de Aceite:**
       - O sistema deve validar que todos os campos obrigatórios foram preenchidos.

### 2. **Criação de Pedido de Aluguel**
   - **Como um cliente**, quero criar um pedido de aluguel, informando o automóvel desejado e a duração do contrato (12, 24, 36 ou 48 meses), para solicitar a assinatura de um veículo.
     - **Critérios de Aceite:**
       - O sistema deve permitir a seleção de automóveis disponíveis para aluguel.
       - O sistema deve validar que a duração do contrato está entre 12, 24, 36 ou 48 meses.

   - **Como um cliente**, quero ter a opção de selecionar a compra do veículo ao final do contrato, para que o veículo seja registrado em meu nome.
     - **Critérios de Aceite:**
       - O sistema deve incluir a opção de compra ao final do contrato.

### 3. **Modificação de Pedido de Aluguel**
   - **Como um cliente**, quero modificar meu pedido de aluguel, alterando as informações do contrato antes da avaliação financeira, para ajustar detalhes como o veículo ou a duração do contrato.
     - **Critérios de Aceite:**
       - O sistema deve validar as novas informações, como duração e veículo escolhido.

### 4. **Consulta de Pedido de Aluguel**
   - **Como um cliente**, quero consultar meus pedidos de aluguel, para acompanhar o status dos meus contratos e verificar se eles foram aprovados, negados ou estão em andamento.
     - **Critérios de Aceite:**
       - O sistema deve exibir todos os pedidos de aluguel do cliente, com status (em análise, aprovado, negado).

### 5. **Cancelamento de Pedido de Aluguel**
   - **Como um cliente**, quero cancelar um pedido de aluguel que ainda não foi aprovado, para que eu possa desistir do aluguel sem incorrer em penalidades.
     - **Critérios de Aceite:**
       - O sistema deve permitir cancelar apenas pedidos que ainda não foram aprovados.

### 6. **Avaliação de Pedido de Aluguel**
   - **Como um agente**, quero avaliar os pedidos de aluguel submetidos por clientes, para analisar a viabilidade financeira e decidir se o pedido será aprovado ou negado.
     - **Critérios de Aceite:**
       - O agente deve ser capaz de aprovar ou negar pedidos com base em critérios financeiros.

   - **Como um agente bancário**, quero avaliar os pedidos de crédito associados aos pedidos de aluguel, para aprovar ou negar a concessão de crédito ao cliente.
     - **Critérios de Aceite:**
       - O agente bancário deve poder aprovar ou negar a concessão de crédito.

### 7. **Execução do Contrato de Aluguel**
   - **Como um cliente**, quero executar o contrato de aluguel após aprovação do pedido, para formalizar o aluguel do veículo e iniciar o período de uso.
     - **Critérios de Aceite:**
       - O sistema deve gerar o contrato automaticamente após a aprovação do pedido.
       - O contrato deve conter todas as informações do veículo e do cliente.

### 8. **Concessão de Crédito**
   - **Como um banco**, quero conceder crédito associado ao pedido de aluguel de um cliente, para facilitar o financiamento e seguro do contrato de aluguel.
     - **Critérios de Aceite:**
       - O sistema deve vincular o crédito aprovado ao contrato de aluguel.

### 9. **Gerenciamento de Automóveis**
   - **Como um agente do sistema**, quero registrar e atualizar informações dos automóveis (matrícula, marca, modelo, ano, placa, e status), para manter o controle sobre os veículos disponíveis para aluguel.
     - **Critérios de Aceite:**
       - O sistema deve permitir adicionar, remover e modificar informações de automóveis.
       - O sistema deve validar que as informações obrigatórias do automóvel foram preenchidas.
