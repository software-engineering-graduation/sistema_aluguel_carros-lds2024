-- Inserting Clientes
INSERT INTO cliente (nome, email, senha, tipo, rg, cpf, profissao, endereco) VALUES
('João Silva', 'joao.silva@email.com', 'senha123', 'CLIENTE', '123456789', '12345678901', 'Engenheiro', 'Rua A, 123, Cidade X'),
('Maria Santos', 'maria.santos@email.com', 'senha456', 'CLIENTE', '987654321', '98765432109', 'Advogada', 'Rua B, 456, Cidade Y');

-- Inserting FuncionariosBanco
INSERT INTO funcionario_banco (nome, email, senha, tipo, cnpj, cargo, banco) VALUES
('Carlos Ferreira', 'carlos.ferreira@banco.com', 'senha789', 'FUNCIONARIO_BANCO', '12345678000190', 'Gerente de Contas', 'Banco ABC');

-- Inserting FuncionariosEmpresa
INSERT INTO funcionario_empresa (nome, email, senha, tipo, cnpj, cargo, empresa) VALUES
('Ana Oliveira', 'ana.oliveira@empresa.com', 'senha101', 'AGENTE', '98765432000190', 'Gerente de Vendas', 'Empresa XYZ');

-- Inserting Automoveis
INSERT INTO automovel (matricula, ano, marca, modelo, placa, status, valor_mensal, proprietario_identificacao, proprietario_tipo) VALUES
('ABC123', 2022, 'Toyota', 'Corolla', 'ABC1234', 'DISPONIVEL', 1000.00, '12345678901', 'CLIENTE'),
('DEF456', 2021, 'Honda', 'Civic', 'DEF5678', 'DISPONIVEL', 900.00, '98765432109', 'CLIENTE');

-- Inserting Rendimentos
INSERT INTO rendimento (nome, cnpj, atual, renda, data_inicio, data_fim, cliente_id) VALUES
('Empresa X', '12345678000190', true, 5000.00, '2022-01-01', NULL, 1),
('Empresa Y', '98765432000190', false, 4000.00, '2021-01-01', '2021-12-31', 2);

-- Inserting Creditos
INSERT INTO credito (valor, taxa_juros, concedente_id) VALUES
(24000.00, 0.05, 1);

-- Inserting ContratoAlugueis
INSERT INTO contrato_aluguel (status, valor_total, credito_id) VALUES
('ATIVO', 24000.00, 1);

-- Inserting Alugueis
INSERT INTO aluguel (prazo, status, valor, data_inicio, contrato_id, automovel_id, adquirir_propriedade) VALUES
('MESES_12', 'PENDENTE', 1000.00, '2023-07-01', 1, 1, true);