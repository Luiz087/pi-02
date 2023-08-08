-- Excliui o banco de dados
DROP DATABASE IF EXISTS gspAutomoveis;

-- CRIA O BANCO DE DADOS
CREATE DATABASE IF NOT EXISTS gspAutomoveis;

-- USA O BANCO DE DADOS gspAutomoveis
USE gspAutomoveis;

CREATE TABLE IF NOT EXISTS `enderecos` (
  `cep` BIGINT NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cep`)
);

CREATE TABLE IF NOT EXISTS `fornecedores` (
  `id_fornecedor` BIGINT NOT NULL auto_increment,
  `nomeFornecedor` VARCHAR(45) NOT NULL,
  `cnpjFornecedor` BIGINT NOT NULL,
  `telefoneFornecedor` BIGINT NOT NULL,
  `empresa` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `endereco_cep` BIGINT NOT NULL,
  PRIMARY KEY (`id_fornecedor`),
  CONSTRAINT `fk_fornecedor_endereco1` FOREIGN KEY (`endereco_cep`) REFERENCES `enderecos` (`cep`)
  ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `funcionarios` (
  `matricula` BIGINT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` BIGINT NOT NULL,
  `telefone` BIGINT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dataDeNasc` DATE NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `NivelCargo` VARCHAR(45) NOT NULL,
  `salario` DOUBLE NOT NULL,
  `comissao` DOUBLE NOT NULL,
  `funcao` VARCHAR(45) NOT NULL,
  `enderecos_cep` BIGINT NOT NULL,
  PRIMARY KEY (`matricula`),
  CONSTRAINT `fk_funcionarios_enderecos1` FOREIGN KEY (`enderecos_cep`) REFERENCES `enderecos` (`cep`)
  ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `Carros` (
  `id_carro` BIGINT NOT NULL auto_increment,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `novo` TINYINT NOT NULL,
  `ano` INT NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `combustivel` VARCHAR(45) NOT NULL,
  `quilometragem` FLOAT NOT NULL,
  `potencia` VARCHAR(45),
  `abs` TINYINT NOT NULL,
  `preco` DOUBLE NOT NULL,
  `fornecedor_id_fornecedor` BIGINT NOT NULL,
  PRIMARY KEY (`id_carro`),
  CONSTRAINT `fk_veiculos_fornecedor1` FOREIGN KEY (`fornecedor_id_fornecedor`) REFERENCES `fornecedores` (`id_fornecedor`)
  ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `vendidos` (
  `veiculos_id_veiculo` BIGINT NOT NULL auto_increment,
  `funcionarios_matricula` BIGINT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` BIGINT NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `dataVenda` DATE NOT NULL,
  `ipva_pago` TINYINT NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `tipo_veiculo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (
    `Carros_id_Carro`,
    `funcionarios_matricula`
  ),
  CONSTRAINT `fk_vendidos_funcionarios1` FOREIGN KEY (`funcionarios_matricula`) REFERENCES `funcionarios` (`matricula`)
  ON DELETE CASCADE
);

insert into enderecos (cep, rua, bairro, cidade, estado) values (98860771, 'Park Meadow', 'barracão', 'Newport News', 'Virginia');
insert into enderecos (cep, rua, bairro, cidade, estado) values (26360149, 'Beilfuss', 'gaparinho', 'Tyler', 'Texas');
insert into enderecos (cep, rua, bairro, cidade, estado) values (24971323, 'Stoughton', 'figueira', 'Norfolk', 'Virginia');
insert into enderecos (cep, rua, bairro, cidade, estado) values (32813459, 'Pennsylvania', 'agua negras', 'Lawrenceville', 'Georgia');
insert into enderecos (cep, rua, bairro, cidade, estado) values (33395580, 'Meadow Ridge', 'coloninha', 'Dallas', 'Texas');
insert into enderecos (cep, rua, bairro, cidade, estado) values (66575921, 'Loomis', 'bela vista', 'Dallas', 'Texas');
insert into enderecos (cep, rua, bairro, cidade, estado) values (18853418, 'Forster', 'figuira', 'Amarillo', 'Texas');
insert into enderecos (cep, rua, bairro, cidade, estado) values (77727522, 'Merchant', 'sete de setembro', 'Louisville', 'Kentucky');
insert into enderecos (cep, rua, bairro, cidade, estado) values (53015239, 'Bluejay', 'santa terezinha', 'Carlsbad', 'California');
insert into enderecos (cep, rua, bairro, cidade, estado) values (90807252, 'Little Fleur', 'óleo grande', 'Lubbock', 'Texas');
insert into enderecos (cep, rua, bairro, cidade, estado) values (83300006, 'Sloan', 'pocinho', 'Washington', 'District of Columbia');
insert into enderecos (cep, rua, bairro, cidade, estado) values (6131187, 'Oriole', 'aguas negras', 'Plano', 'Texas');
insert into enderecos (cep, rua, bairro, cidade, estado) values (72792903, 'Colorado', 'bela vista', 'Houston', 'Texas');
insert into enderecos (cep, rua, bairro, cidade, estado) values (90000298, 'Debra', 'figueira', 'Maple Plain', 'Minnesota');
insert into enderecos (cep, rua, bairro, cidade, estado) values (41222385, 'Manley', 'lagoa', 'Miami', 'Florida');
insert into enderecos (cep, rua, bairro, cidade, estado) values (71727947, 'Northwestern', 'gaspar grande', 'Fort Wayne', 'Indiana');
insert into enderecos (cep, rua, bairro, cidade, estado) values (8599487, 'Blackbird', 'gaspar mirim', 'Rochester', 'New York');
insert into enderecos (cep, rua, bairro, cidade, estado) values (98012944, 'Lakewood', 'gasparinho', 'Denver', 'Colorado');
insert into enderecos (cep, rua, bairro, cidade, estado) values (37621074, 'Golf', 'sertão verde', 'Meridian', 'Mississippi');
insert into enderecos (cep, rua, bairro, cidade, estado) values (96883597, 'Village', 'macuco', 'Buffalo', 'New York');
insert into enderecos (cep, rua, bairro, cidade, estado) values (57268243, 'Redwing', 'barracão', 'Baltimore', 'Maryland');
insert into enderecos (cep, rua, bairro, cidade, estado) values (95428790, 'Derek', 'farropa', 'Las Vegas', 'Nevada');
insert into enderecos (cep, rua, bairro, cidade, estado) values (11255228, 'Sheridan', 'sete de setembro', 'New York City', 'New York');
insert into enderecos (cep, rua, bairro, cidade, estado) values (21911141, 'Karstens', 'belchior', 'Roanoke', 'Virginia');
insert into enderecos (cep, rua, bairro, cidade, estado) values (5445448, 'Columbus', 'santa terezinha', 'Lake Charles', 'Louisiana');

insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Kristofor', 53217593721871, 5636417237, 'Jabberstorm', 98860771);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Marrilee', 78269610408621, 3784328039, 'Jabberstorm', 26360149);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Mag', 83280557412092, 8125576004, 'Tanoodle', 24971323);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Almire', 74390089876469, 6116345912, 'Fatz', 32813459);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Deedee', 32852831345065, 8161722760, 'Twimm', 33395580);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Billie', 96351611588770, 7744863586, 'Zoomlounge', 66575921);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Minny', 72377443654307, 3512203764, 'Jaxnation', 18853418);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Melinda', 76062709614653, 9555072911, 'Eazzy', 77727522);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Benedikta', 90187484363241, 8638928930, 'Kwimbee', 53015239);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Myra', 89911952851122, 6932423640, 'Dabjam', 53015239);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Catlaina', 98650769044682, 6685031243, 'Gabtune', 83300006);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Peggie', 33299526629846, 1194827427, 'Ntag', 6131187);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Dedra', 11387936755749, 5239009837, 'Eidel', 72792903);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Sarette', 88663418924071, 6732888702, 'Livepath', 90000298);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Deanne', 45166963392729, 6841988947, 'Riffwire', 41222385);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Merill',30123472017368, 6368080537, 'Quaxo', 71727947);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Orbadiah', 8849905555117, 4474275724, 'Yombu', 8599487);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Wolfgang', 28273531692793, 4141608193, 'Brainbox', 98012944);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Sanderson', 33218317298271, 6361220266, 'Ailane', 37621074);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Sula', 87503816182502, 7623216188, 'Thoughtworks', 96883597);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Vaughn', 71754551268602, 8324792894, 'Chatterpoint', 57268243);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Massimo', 81175078723725, 8591088193, 'Feedmix', 95428790);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Hubert', 94092745482858, 4314329449, 'Demivee', 11255228);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Blisse', 90414339055026, 6405793349, 'Youfeed', 21911141);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('Barron', 40384711421368, 6445590003, 'Blogspan', 5445448);

insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Cadillac', 'Escalade ESV', 'Novo', 2023, 'Preto', 'Suv', 'Gasolina', 0, '690 cv',  true, 1.950.000, 1);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Volkswagen', 'Polo', 'Novo', 2021, 'Prata', 'Hatchback,' 'Gasolina e álcool', 0, '128 cv', true, 81.111, 2);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Fiat', 'Toro', 'Usado', 2018, 'Cinza', 'Picape', 'Gasolina e álcool', 29.638, '139 cv', true, 90.900, 3);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Chevrolet', 'Chevette', 'Usado', 1976, 'Preto', 'Cupê', 'Gasolina', 100.000, '68 cv', false, 32.000, 4);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Renault', 'Megane', 'Usado', 2010, 'Preto', 'sedã', 'Gasolina e álcool', 111.000, '115 cv', true, 27.000, 5);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Ford', 'Fusion', 'Usado', 2012, 'Prata', 'Sedã', 'Gasolina', 136.000, '173 cv', true, 41.500, 6);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Mazda', 'MX-3', 'Usado', 1997, 'Vermelho', 'Cupê', 'Gasolina', 130.000, '106 cv', false, 44.000, 7);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Ford', 'Edge', 'Usado', 2019, 'Preto', 'Suv', 'Gasolina', 27.270, '335 cv', true, 244.900, 8);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('GMC', 'Sierra 1500', 'Novo', 2022, 'azul', 'Picape', 'Diesel', 0, '280 cv', true, 1.250.000, 9);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Dodge', 'Ram 2500', 'Usado', 2020, 'Preto', 'Picape', 'Diesel', 35.653, '330 cv', true, 472.990, 10);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Mercedes-Benz', 'GLC 300', 'Usado', 2021, 'Azul', 'Suv', 'Gasolina', 13.000, '254 cv', true, 489.900, 11);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Hyundai', 'I30', 'Usado', 2015, 'branco', 'Hatch', 'Gasolina', 96.000, '150 cv', true, 63.000, 12);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Audi', 'Rs3', 'Usado', 2018, 'Vermelho', 'Sedã', 'Gasolina', 41.000, '400 cv', true, 380.000, 13);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Kia', 'Sportage', 'Usado', 2021, 'Azul', 'Suv', 'Gasolina e álcool', 10.500, '178 cv', true, 120.000, 14);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Honda', 'Accord', 'Usado', 1993, 'Preto', 'Sedã', 'Gasolina', 220.000, '158 cv', false, 65.000, 15);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Toyota', 'Corolla', 'Usado', 2020, 'branco', 'Sedã', 'Gasolina e elétrico', 35.000, '143 cv', true, 148.990, 16);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Mitsubishi', 'lancer Evolution', 'Usado', 2015, 'Vermelho,' 'Sedã', 'Gasolina', 75.737, 1991, '340 cv', true, 189.900, 17);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Volkswagen', 'Golf GTI', 'Usado', 2019, 'Branco', 'hatch', 'Gasolina', 55.000, '220 cv', true, 199.900, 18);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Chevrolet', 'Camaro', 'Usado', 2019, 'Laranja', 'Cupê', 'Gasolina', 22.000, '406 cv', true, 411.500, 19);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Ferrari', 'California', 'Usado', 2014, 'Amarelo', 'Cupê', 'Gasolina', 20.931, '460 cv', true, 1.790.000, 20);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('GMC', 'Hummer', 'Novo', 2022, 'Branco', 'Picape', 'Gasolina e elétrico', 0, '1.014 cv', true, 2.499.990, 21);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Chrysler', '300 C', 'Usado', 2012, 'Prata', 'Sedã', 'Gasolina', 53.862, '296 cv', true, 125.990, 22);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Chevrolet', 'Silverado 1500', 'Usado', 2022, 'Azul', 'Picape', 'Diesel', 5.000, '281 cv', true, 1.050.000, 23);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Porshe', 'Panamera', 'Usado', 2022, 'Roxo', 'Sedã', 'gasolina e elétrico', 10.808, '462 cv', true, 935.000, 24);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, preco, fornecedor_id_fornecedor) values ('Lamborguini', 'Huracan', 'Novo', 2022, 'Verde', 'Cupê', 'Gasolina', 0, '640 cv', true, 5.430.000, 25);

insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_cep) values ('Luiz', 22726014571, 13410553435, 'Luiz@gmail.com' , 2005-07-08, 'Luiz047', 'Luizz123,' 'Administrador', 500.000, 2.5, 96883597);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_cep) values ('Gabriel', 48791425360, 35980146935, 'Biell7@gmail.com', 2004-07-17, 'Gabriel047', 'Biell777', 'Administrador', 500.000, 2.5, 26360149);

insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Gabriel', 48791425360, 'Gabriel047', 2023-07-03 true, 'Huracan','Cupê');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Luiz', 22726014571, 'Luiz047', 2023-07-03 true, 'Panemera','Sedã');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Gabriel', 48791425360, 'Gabriel047', 2023-07-05 false, '300 C','Sedã');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Luiz', 22726014571, 'Luiz047', 2023-07-05 false, 'Camaro','Cupê');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Gabriel', 48791425360, 'Gabriel047', 2023-07-10 true, 'Silverado 1500','Picape');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Luiz', 22726014571, 'Luiz047', 2023-07-10 false, 'California','Cupê');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Gabriel', 48791425360, 'Gabriel047', 2023-07-13 true, 'Golf GTI','Hatch');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Luiz', 22726014571, 'Luiz047', 2023-07-13 true, 'Corolla', 'Sedã');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Gabriel', 48791425360, 'Gabriel047', 2023-07-17 true, 'Sportage','Suv');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Luiz', 22726014571, 'Luiz047', 2023-07-17 true, 'I30','Hatch');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Gabriel', 48791425360, 'Gabriel047', 2023-07-17 false, 'GLC 300','Suv');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Luiz', 22726014571, 'Luiz047', 2023-07-17 false, 'polo', 'Hatch');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Gabriel', 48791425360, 'Gabriel047', 2023-07-22 true, 'Escalade Esv','Suv');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Luiz', 22726014571, 'Luiz047', 2023-07-22 true, 'Ram 2500','Picape');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Gabriel', 48791425360, 'Gabriel047', 2023-07-24 true, 'Fusion','Sedã');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Luiz', 22726014571, 'Luiz047', 2023-07-24 true, 'Chevette','Cupê');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Gabriel', 48791425360, 'Gabriel047', 2023-07-30 false, 'Toro','Picape');
insert into vendidos (nome, cpf, usuario, dataVenda, ipva_pago, modelo, ,tipo_veiculo) values ('Luiz', 22726014571, 'Luiz047', 2023-07-30 false, 'Rs3','Sedã');

SELECT COUNT(*) FROM enderecos;
SELECT COUNT(*) FROM clientes;
SELECT COUNT(*) FROM fornecedores;
SELECT COUNT(*) FROM veiculos;
SELECT COUNT(*) FROM funcionarios;
SELECT COUNT(*) FROM vendidos;

SELECT * FROM enderecos order by cep;
SELECT * FROM clientes order by id_cliente;
SELECT * FROM fornecedores order by id_fornecedor;
SELECT * FROM veiculos order by id_veiculo;
SELECT * FROM funcionarios order by matricula;
SELECT * FROM vendidos order by veiculos_id_veiculo;

SELECT veiculos.modelo,
    veiculos.novos,
    veiculos.eletrico,
    veiculos.esportivo,
    veiculos.picape,
    veiculos.ano,
    veiculos.cor,
    veiculos.marca,
    veiculos.preco,
    veiculos.quilometragem,
    veiculos.potencia,
    veiculos.abs,
    veiculos.fornecedor_id_fornecedor,
    clientes.nome, 
    clientes.cpf,
    clientes.usuario,
    clientes.telefone,
    clientes.gmail,
    clientes.table1_cep,
    funcionarios.nome,
    funcionarios.cpf,
    funcionarios.contato,
    funcionarios.salario,
    funcionarios.funcao,
    funcionarios.enderecos_cep
    FROM vendidos
INNER JOIN funcionarios ON vendidos.funcionarios_matricula = funcionarios.matricula
INNER JOIN veiculos ON vendidos.veiculos_id_veiculo = veiculos.id_veiculo
INNER JOIN clientes ON vendidos.clientes_id_cliente = clientes.id_cliente;

UPDATE enderecos SET rua ="Rua dos bobos",bairro="Velha",cidade="Jaragua",estado="SC" WHERE cep = 98860771;
UPDATE enderecos SET rua ="Blumenau",bairro="Velha",cidade="Blumenau",estado="SC" WHERE cep = 26360149;
UPDATE enderecos SET rua ="Arthur Gieseler",bairro="Nova",cidade="Joinville",estado="SC" WHERE cep = 26360149;
UPDATE enderecos SET rua ="XV",bairro="Centro",cidade="Presidente Getulio",estado="SC" WHERE cep = 32813459;
UPDATE enderecos SET rua ="Rua 7",bairro="Conconhas",cidade="Florianopolis",estado="SC" WHERE cep = 33395580;
UPDATE enderecos SET rua ="Getulio Branco",bairro="Vila Nova",cidade="São Bento do Sul",estado="SC" WHERE cep = 18853418;
UPDATE enderecos SET rua ="Bela Mur",bairro="Bela Vista",cidade="Gaspar",estado="SC" WHERE cep = 66575921;
UPDATE enderecos SET rua ="7 de Novembro",bairro="Velha Nova",cidade="Blumenau",estado="SC" WHERE cep = 77727522;
UPDATE enderecos SET rua ="Rua Steves",bairro="Ponta Aguda",cidade="Springfield",estado="Texas" WHERE cep = 53015239;
UPDATE enderecos SET rua ="Rua Joinville",bairro="Passo Manso",cidade="Blumenau",estado="SC" WHERE cep = 90807252;

UPDATE fornecedores SET nome = "ASTOLFO", endereco="Apt 3543",cnpj=5646765373, telefone= 25254564364, empresa= "slefd", endereco_cep=98860771 WHERE id_fornecedor= 1;
UPDATE fornecedores SET nome = "RODRIGO", endereco="10th flack",cnpj=7583939404, telefone= 46543364653, empresa= "rolú", endereco_cep=26360149 WHERE id_fornecedor= 2;
UPDATE fornecedores SET nome = "LUÍS", endereco="suíte 666",cnpj=9605054839, telefone= 86940285032, empresa= "plasvale", endereco_cep=24971323 WHERE id_fornecedor= 3;
UPDATE fornecedores SET nome = "GABRIEL", endereco="PO BOX 9393",cnpj=0950402819, telefone= 8694031257, empresa= "CIRCULO", endereco_cep=32813459 WHERE id_fornecedor= 4;
UPDATE fornecedores SET nome = "jOÃO", endereco="ROOM 3543",cnpj=8684938289, telefone= 96847302839, empresa= "OTTO", endereco_cep=33395580 WHERE id_fornecedor= 5;
UPDATE fornecedores SET nome = "SABEL", endereco="PO BOX 6547",cnpj=9437439975, telefone= 95837259392, empresa= "TOP", endereco_cep=66575921 WHERE id_fornecedor= 6;
UPDATE fornecedores SET nome = "FERNANDO", endereco="ROOM 5353",cnpj=8963986379, telefone= 05695845944, empresa= "PRECEIRO", endereco_cep=18853418 WHERE id_fornecedor= 7;
UPDATE fornecedores SET nome = "ERIC", endereco="PO BOX 54354",cnpj=5676765735, telefone= 575454745754, empresa= "AVON", endereco_cep=77727522 WHERE id_fornecedor= 8;
UPDATE fornecedores SET nome = "PEDRO", endereco="PO BOX 5435",cnpj=9584930295, telefone= 65858496943, empresa= "OBOTICARIO", endereco_cep=53015239 WHERE id_fornecedor= 9;
UPDATE fornecedores SET nome = "LUCAS", endereco=" BOX 46436",cnpj=5754774567, telefone= 57578474737, empresa= "BARÃO", endereco_cep=53015239 WHERE id_fornecedor= 10;

UPDATE funcionarios SET nome ="Lindy", cpf="51267649003	", contato="95937385512", salario="435345", funcao = 'vendedor', enderecos_cep = 98860771 WHERE matricula = 1;
UPDATE funcionarios SET nome ="Jarret", cpf="73775878068", contato="92935526593", salario="435435", funcao = 'vendedor', enderecos_cep = 98860771 WHERE matricula = 2;
UPDATE funcionarios SET nome ="Arthur", cpf="80662784030", contato="67936405836", salario="123123", funcao = 'vendedor', enderecos_cep = 26360149 WHERE matricula = 3;
UPDATE funcionarios SET nome ="Gieseler", cpf="19870824005", contato="67936405836", salario="43141", funcao = 'atendente', enderecos_cep = 26360149 WHERE matricula = 4;
UPDATE funcionarios SET nome ="Lari", cpf="40007889062", contato="95937385525", salario="768678", funcao = 'atendente', enderecos_cep = 26360149 WHERE matricula = 5;
UPDATE funcionarios SET nome ="Getulio ", cpf="73765807001", contato="92935526500", salario="876867", funcao = 'atendente', enderecos_cep = 26360149 WHERE matricula = 6;
UPDATE funcionarios SET nome ="Lara", cpf="25627834099", contato="67936405823", salario="45654" , funcao = 'aprendiz de vendas', enderecos_cep = 33395580 WHERE matricula = 7;
UPDATE funcionarios SET nome ="Luiz", cpf="04223201026", contato="67936405889", salario="654654", funcao = 'aprendiz de vendas', enderecos_cep = 33395580 WHERE matricula = 8;
UPDATE funcionarios SET nome ="Luis", cpf="36257549086", contato="95937385512", salario="234567", funcao = 'aprendiz de vendas', enderecos_cep = 90807252 WHERE matricula = 9;
UPDATE funcionarios SET nome ="Eric", cpf="54985014044", contato="95937385511", salario="498654", funcao = 'dono', enderecos_cep = 90807252 WHERE matricula = 10;

UPDATE veiculos SET marca = "Ford", modelo = "Ka", potencia = 95, quilometragem = 30000, novos = true, eletrico = true, esportivo = false, picape = true, ano = 2008, cor = "Azul", abs = false, preco = 47000, fornecedor_id_fornecedor = 2 WHERE id_veiculo = 1;
UPDATE veiculos SET marca = "Chevrolet", modelo = "Camaro", potencia = 340, quilometragem = 20000, novos = false, eletrico = false, esportivo = true, picape = false, ano = 2015, cor = "Amarelo", abs = true, preco = 320000, fornecedor_id_fornecedor = 1 WHERE id_veiculo = 2;
UPDATE veiculos SET marca = "Chevrolet", modelo = "Cruize", potencia = 120, quilometragem = 90000, novos = false, eletrico = false, esportivo = false, picape = false, ano = 2016, cor = "Branco", abs = true, preco = 82000, fornecedor_id_fornecedor = 6 WHERE id_veiculo = 3;
UPDATE veiculos SET marca = "Bentley", modelo = "Bentayga", potencia = 450, quilometragem = 0, novos = true, eletrico = false, esportivo = true, picape = false, ano = 2020, cor = "Cinza", abs = true, preco = 750000, fornecedor_id_fornecedor = 8 WHERE id_veiculo = 4;
UPDATE veiculos SET marca = "koenigsegg", modelo = "Agera", potencia = 1176, quilometragem = 10000, novos = false, eletrico = false, esportivo = true, picape = false, ano = 2021, cor = "Vermelho", abs = true, preco = 1200000, fornecedor_id_fornecedor = 10 WHERE id_veiculo = 5;
UPDATE veiculos SET marca = "Bugatti", modelo = "Chiron", potencia = 700, quilometragem = 0, novos = true, eletrico = false, esportivo = true, picape = false, ano = 2017, cor = "Azul", abs = true, preco = 1100000, fornecedor_id_fornecedor = 16 WHERE id_veiculo = 6;
UPDATE veiculos SET marca = "Dodge", modelo = "Ram", potencia = 500, quilometragem = 45000, novos = false, eletrico = false, esportivo = false, picape = true, ano = 2016, cor = "Preto", abs = true, preco = 500000, fornecedor_id_fornecedor = 25 WHERE id_veiculo = 7;
UPDATE veiculos SET marca = "Fiat", modelo = "Uno", potencia = 95, quilometragem = 120000, novos = false, eletrico = false, esportivo = false, picape = false, ano = 2002, cor = "Bordô", abs = false, preco = 25000, fornecedor_id_fornecedor = 24 WHERE id_veiculo = 8;
UPDATE veiculos SET marca = "Nissan", modelo = "Kicks", potencia = 120, quilometragem = 0, novos = true, eletrico = false, esportivo = false, picape = false, ano = 2023, cor = "Branco", abs = true, preco = 95000, fornecedor_id_fornecedor = 23 WHERE id_veiculo = 9;
UPDATE veiculos SET marca = "Hiunday", modelo = "Creta", potencia = 135, quilometragem = 0, novos = true, eletrico = false, esportivo = false, picape = false, ano = 2022, cor = "Cinza", abs = true, preco = 145000, fornecedor_id_fornecedor = 22 WHERE id_veiculo = 10;

UPDATE vendidos SET nome = "Rodrigo", cpf=28716145631, usuario='Eric.o', ipva_pago=false, modelo='Navigator', clientes_id_cliente=1, funcionarios_matricula=1, tipo_veiculo='Picape' WHERE veiculos_id_veiculo =1 ;
UPDATE vendidos SET nome = "Andrei", cpf=16272567685, usuario='luis.g', ipva_pago=true, modelo='Camaro', clientes_id_cliente=2, funcionarios_matricula=2, tipo_veiculo='Picape' WHERE veiculos_id_veiculo = 2;
UPDATE vendidos SET nome = "bernardo", cpf=91315765080, usuario='liz.s', ipva_pago=false, modelo='RAV4', clientes_id_cliente=3, funcionarios_matricula=3, tipo_veiculo='Picape' WHERE veiculos_id_veiculo = 3;
UPDATE vendidos SET nome = "Gustavo", cpf=55035814157, usuario='joao.g', ipva_pago=true, modelo='RAV4', clientes_id_cliente=4, funcionarios_matricula=4, tipo_veiculo='Picape' WHERE veiculos_id_veiculo =4 ;
UPDATE vendidos SET nome = "Amanda", cpf=03567342266, usuario='liz.z', ipva_pago=true, modelo='Camaro', clientes_id_cliente=5, funcionarios_matricula=5, tipo_veiculo='Picape' WHERE veiculos_id_veiculo = 5;
UPDATE vendidos SET nome = "Carlos", cpf=81771519592, usuario='joao.df', ipva_pago=false, modelo='Navigator', clientes_id_cliente=6, funcionarios_matricula=6, tipo_veiculo='Picape' WHERE veiculos_id_veiculo = 6;
UPDATE vendidos SET nome = "Erik", cpf=16164101590, usuario='Eric.de', ipva_pago=true, modelo='Camaro', clientes_id_cliente=7, funcionarios_matricula=7, tipo_veiculo='Picape' WHERE veiculos_id_veiculo =7 ;
UPDATE vendidos SET nome = "Anderson", cpf=66119902759, usuario='luis.lo', ipva_pago=false, modelo='RAV4', clientes_id_cliente=8, funcionarios_matricula=8, tipo_veiculo='Picape' WHERE veiculos_id_veiculo = 8;
UPDATE vendidos SET nome = "Robson", cpf=90190269766, usuario='Eric.sa', ipva_pago=true, modelo='Camaro', clientes_id_cliente=9, funcionarios_matricula=9, tipo_veiculo='Picape' WHERE veiculos_id_veiculo = 9 ;
UPDATE vendidos SET nome = "Welliton", cpf=94642174800, usuario='luiz.s', ipva_pago=false, modelo='Navigator', clientes_id_cliente=10, funcionarios_matricula=10, tipo_veiculo='Picape' WHERE veiculos_id_veiculo = 10;

UPDATE clientes SET nome = "Antônio", cpf = 92704148090, usuario = "toninho", telefone = 2365829356, gmail = "shdbghd@gmail.com" WHERE cep = 98860771;
UPDATE clientes SET nome = "Carlos", cpf = 87655671811, usuario = "carlin", telefone = 876545678, gmail = "uiyrhrg@gmail.com" WHERE cep = 26360149;
UPDATE clientes SET nome = "Carls", cpf = 34254545351, usuario = "clin", telefone = 465365656, gmail = "yrhrg@gmail.com" WHERE cep = 24971323;
UPDATE clientes SET nome = "Cawels", cpf = 34252245551, usuario = "clsin", telefone = 786567654, gmail = "ysadrhrg@gmail.com" WHERE cep = 32813459;
UPDATE clientes SET nome = "Carqwls", cpf = 34253345651, usuario = "clian", telefone = 465365556, gmail = "yrewrhrg@gmail.com" WHERE cep = 33395580;
UPDATE clientes SET nome = "Carlds", cpf = 34254445751, usuario = "clein", telefone = 465366656, gmail = "yqwrhrg@gmail.com" WHERE cep = 66575921;
UPDATE clientes SET nome = "Carlasds", cpf = 34254554551, usuario = "clrin", telefone = 465367756, gmail = "dfhrg@gmail.com" WHERE cep = 18853418;
UPDATE clientes SET nome = "Carlxzcs", cpf = 34254566551, usuario = "cylin", telefone = 465885656, gmail = "yrasdhrg@gmail.com" WHERE cep = 77727522;
UPDATE clientes SET nome = "Carsas", cpf = 34254547751, usuario = "cliin", telefone = 465399656, gmail = "yrahrg@gmail.com" WHERE cep = 53015239;
UPDATE clientes SET nome = "Luis", cpf = 34254545881, usuario = "clkin", telefone = 4653622656, gmail = "yrhxzcrg@gmail.com" WHERE cep = 90807252;

DELETE FROM vendidos WHERE veiculos_id_veiculo = 1;
DELETE FROM vendidos WHERE veiculos_id_veiculo = 2;
DELETE FROM vendidos WHERE veiculos_id_veiculo = 3;
DELETE FROM vendidos WHERE veiculos_id_veiculo = 4;
DELETE FROM vendidos WHERE veiculos_id_veiculo = 5;

DELETE FROM funcionarios WHERE matricula = 1;
DELETE FROM funcionarios WHERE matricula = 2;
DELETE FROM funcionarios WHERE matricula = 3;
DELETE FROM funcionarios WHERE matricula = 4;
DELETE FROM funcionarios WHERE matricula = 5;

DELETE FROM fornecedores WHERE id_fornecedor = 1;
DELETE FROM fornecedores WHERE id_fornecedor = 2;
DELETE FROM fornecedores WHERE id_fornecedor = 3;
DELETE FROM fornecedores WHERE id_fornecedor = 4;
DELETE FROM fornecedores WHERE id_fornecedor = 5;

DELETE FROM veiculos WHERE id_veiculo = 1;
DELETE FROM veiculos WHERE id_veiculo = 2;
DELETE FROM veiculos WHERE id_veiculo = 3;
DELETE FROM veiculos WHERE id_veiculo = 4;
DELETE FROM veiculos WHERE id_veiculo = 5;

DELETE FROM clientes WHERE id_cliente = 3;
DELETE FROM clientes WHERE id_cliente = 8;
DELETE FROM clientes WHERE id_cliente = 13;
DELETE FROM clientes WHERE id_cliente = 14;
DELETE FROM clientes WHERE id_cliente = 15;

DELETE FROM enderecos WHERE cep = 18853418;
DELETE FROM enderecos WHERE cep = 77727522;
DELETE FROM enderecos WHERE cep = 6131187;
DELETE FROM enderecos WHERE cep = 72792903;
DELETE FROM enderecos WHERE cep = 90000298;
