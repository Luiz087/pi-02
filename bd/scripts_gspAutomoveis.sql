-- Excliui o banco de dados
DROP DATABASE IF EXISTS gspAutomoveis;

-- CRIA O BANCO DE DADOS
CREATE DATABASE IF NOT EXISTS gspAutomoveis;

-- USA O BANCO DE DADOS gspAutomoveis
USE gspAutomoveis;

CREATE TABLE IF NOT EXISTS `enderecos` (
  `id_endereco` BIGINT NOT NULL auto_increment,
  `cep` BIGINT NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_endereco`)
);

CREATE TABLE IF NOT EXISTS `fornecedores` (
  `id_fornecedor` BIGINT NOT NULL auto_increment,
  `nomeFornecedor` VARCHAR(45) NOT NULL,
  `cnpjFornecedor` BIGINT NOT NULL,
  `telefoneFornecedor` BIGINT NOT NULL,
  `empresa` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `enderecos_id_endereco` BIGINT NOT NULL,
  PRIMARY KEY (`id_fornecedor`),
  CONSTRAINT `fk_fornecedor_endereco1` FOREIGN KEY (`enderecos_id_endereco`) REFERENCES `enderecos` (`id_endereco`)
  ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `funcionarios` (
  `matricula` BIGINT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` BIGINT NOT NULL,
  `telefone` BIGINT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dataDeNasc` VARCHAR(10) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `nivelCargo` VARCHAR(45) NOT NULL,
  `salario` DOUBLE NOT NULL,
  `comissao` DOUBLE NOT NULL,
  `enderecos_id_endereco` BIGINT NOT NULL,
  PRIMARY KEY (`matricula`),
  CONSTRAINT `fk_funcionarios_enderecos1` FOREIGN KEY (`enderecos_id_endereco`) REFERENCES `enderecos` (`id_endereco`)
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
  `precoCarro` DOUBLE NOT NULL,
  `promocao` TINYINT NOT NULL,
  `fornecedor_id_fornecedor` BIGINT NOT NULL,
  PRIMARY KEY (`id_carro`),
  CONSTRAINT `fk_veiculos_fornecedor1` FOREIGN KEY (`fornecedor_id_fornecedor`) REFERENCES `fornecedores` (`id_fornecedor`)
  ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `Vendas` (
  `id_venda` BIGINT NOT NULL auto_increment,
  `nomeCliente` VARCHAR(45) NOT NULL,
  `cpfCliente` BIGINT NOT NULL,
  `telefoneCliente` BIGINT NOT NULL,
  `enderecoCliente` VARCHAR(45) NOT NULL,
  `dataVenda` VARCHAR(10) NOT NULL,
  `precoVenda` DOUBLE NOT NULL,
  `funcionarios_matricula` BIGINT NOT NULL,
  `Carros_id_carro` BIGINT NOT NULL,
  PRIMARY KEY (`id_venda`),
  CONSTRAINT `fk_vendidos_funcionarios1` FOREIGN KEY (`funcionarios_matricula`) REFERENCES `funcionarios` (`matricula`)
  ON DELETE CASCADE,
  CONSTRAINT `fk_vendidos_Carros1`
    FOREIGN KEY (`Carros_id_carro`)
    REFERENCES `Carros` (`id_carro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
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

insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Kristofor', 53217593721871, 5636417237, 'Jabberstorm', 'Ford', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Marrilee', 78269610408621, 3784328039, 'Jabberstorm', 'Fiat', 2);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Mag', 83280557412092, 8125576004, 'Tanoodle', 'Mercedes-Benz', 3);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Almire', 74390089876469, 6116345912, 'Fatz', 'Toyota', 4);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Deedee', 32852831345065, 8161722760, 'Twimm', 'Cadillac', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Billie', 96351611588770, 7744863586, 'Zoomlounge', 'Volkswagen', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Minny', 72377443654307, 3512203764, 'Jaxnation', 'Chevrolet', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Melinda', 76062709614653, 9555072911, 'Eazzy', 'Renault', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Benedikta', 90187484363241, 8638928930, 'Kwimbee', 'Mazda', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Myra', 89911952851122, 6932423640, 'Dabjam', 'GMC', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Catlaina', 98650769044682, 6685031243, 'Gabtune', 'Dodge', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Peggie', 33299526629846, 1194827427, 'Ntag', 'Hyundai', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Dedra', 11387936755749, 5239009837, 'Eidel', 'Audi', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Sarette', 88663418924071, 6732888702, 'Livepath', 'Kia', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Deanne', 45166963392729, 6841988947, 'Riffwire', 'Honda', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Merill',30123472017368, 6368080537, 'Quaxo', 'Mitsubishi', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Orbadiah', 8849905555117, 4474275724, 'Yombu', 'Ferrari', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Wolfgang', 28273531692793, 4141608193, 'Brainbox', 'Chrysler', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Sanderson', 33218317298271, 6361220266, 'Ailane', 'Porshe', 1);
insert into fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values ('Sula', 87503816182502, 7623216188, 'Thoughtworks', 'Lamborguini', 1);

insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Cadillac', 'Escalade ESV', true, 2023, 'Preto', 'Suv', 'Gasolina', 0, '690 cv',  true, 1950000, false, 5);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Volkswagen', 'Polo', true, 2021, 'Prata', 'Hatchback', 'Gasolina e álcool', 0, '128 cv', true, 81111, false, 6);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Fiat', 'Toro', false, 2018, 'Cinza', 'Picape', 'Gasolina e álcool', 29.638, '139 cv', true, 90900, false, 2);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Chevrolet', 'Chevette', false, 1976, 'Preto', 'Cupê', 'Gasolina', 100.000, '68 cv', false, 32000, false, 7);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Renault', 'Megane', false, 2010, 'Preto', 'sedã', 'Gasolina e álcool', 111.000, '115 cv', true, 27000, false, 8);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Ford', 'Fusion', false, 2012, 'Prata', 'Sedã', 'Gasolina', 136.000, '173 cv', true, 41500, false, 1);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Mazda', 'MX-3', false, 1997, 'Vermelho', 'Cupê', 'Gasolina', 130.000, '106 cv', false, 44000, false, 9);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Ford', 'Edge', false, 2019, 'Preto', 'Suv', 'Gasolina', 27.270, '335 cv', true, 244900, false, 1);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('GMC', 'Sierra 1500', true, 2022, 'azul', 'Picape', 'Diesel', 0, '280 cv', true, 1250000, false, 10);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Dodge', 'Ram 2500', false, 2020, 'Preto', 'Picape', 'Diesel', 35.653, '330 cv', true, 472990, false, 11);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Mercedes-Benz', 'GLC 300', true, 2021, 'Azul', 'Suv', 'Gasolina', 13.000, '254 cv', true, 489900, false, 3);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Hyundai', 'I30', false, 2015, 'branco', 'Hatch', 'Gasolina', 96.000, '150 cv', true, 63000, false, 12);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Audi', 'Rs3', false, 2018, 'Vermelho', 'Sedã', 'Gasolina', 41.000, '400 cv', true, 380000, false, 13);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Kia', 'Sportage', false, 2021, 'Azul', 'Suv', 'Gasolina e álcool', 10.500, '178 cv', true, 120000, false, 14);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Honda', 'Accord', false, 1993, 'Preto', 'Sedã', 'Gasolina', 220.000, '158 cv', false, 65000, false, 15);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Toyota', 'Corolla', false, 2020, 'branco', 'Sedã', 'Gasolina e elétrico', 35.000, '143 cv', true, 148990, false, 4);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Mitsubishi', 'lancer Evolution', false, 2015, 'Vermelho,' 'Sedã', 'Gasolina', 75.737, 1991, '340 cv', true, 189900, false, 16);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Volkswagen', 'Golf GTI', false, 2019, 'Branco', 'hatch', 'Gasolina', 55.000, '220 cv', true, 199900, false, 6);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Chevrolet', 'Camaro', false, 2019, 'Laranja', 'Cupê', 'Gasolina', 22.000, '406 cv', true, 411500, false, 7);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Ferrari', 'California', false, 2014, 'Amarelo', 'Cupê', 'Gasolina', 20.931, '460 cv', true, 1790000, false, 17);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('GMC', 'Hummer', true, 2022, 'Branco', 'Picape', 'Gasolina e elétrico', 0, '1.014 cv', true, 2499990, false, 10);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Chrysler', '300 C', false, 2012, 'Prata', 'Sedã', 'Gasolina', 53.862, '296 cv', true, 125990, false, 18);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Chevrolet', 'Silverado 1500', false, 2022, 'Azul', 'Picape', 'Diesel', 5.000, '281 cv', true, 1050000, false, 7);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Porshe', 'Panamera', false, 2022, 'Roxo', 'Sedã', 'gasolina e elétrico', 10.808, '462 cv', true, 935000, false, 19);
insert into Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('Lamborguini', 'Huracan', true, 2022, 'Verde', 'Cupê', 'Gasolina', 0, '640 cv', true, 5430000, false, 20);

insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Luiz', 22726014571, 13410553435, 'Luiz@gmail.com', '2005-07-08', 'Luiz047', 'Luizz123', 'Administrador', 500.000, 2.5, 1);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Gabriel', 48791425360, 35980146935, 'Biell7@gmail.com', '2004-07-17', 'Biell047', 'Biell777', 'Administrador', 500.000, 2.5, 2);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Eric', 17541062722, 53964108953, 'Eric@gmail.com' , '2005-10-06', 'Eric047', 'Ericc123', 'Administrador', 500.000, 2.5, 3);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Sabel', 06352419784, 7327146365, 'Sabel@gmail.com', '2005-12-31', 'Sabel047', 'Sabell123', 'Administrador', 500.000, 2.5, 4);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('João', 53435501431, 4006755218, 'João@gmail.com', '2005-12-08', 'João047', 'joaoo123', 'Administrador', 500.000, 2.5, 5);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Puopi', 01907683046, 4926166947, 'Puopi@gmail.com', '2002-05-04', 'Puopi047', 'Puopii123', 'Vendedor', 70.000, 0.5, 9);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Batay', 67459166065, 8433195843, 'Batay@gmail.com', '1999-12-28', 'Batay047', 'Batayy123', 'Gerente de Estoque', 50.000, 0.3, 10);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Lohad', 43206516005, 8132386314, 'Lohad@gmail.com', '2003-11-10', 'Lohad047', 'Lohadd123', 'Gerente de Estoque', 50.000, 0.3, 11);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Faerion', 58749084046, 1833291657, 'Faerion@gmail.com', '1998-01-02', 'Faerion047', 'Faerionn123', 'Gerente de Vendas', 70.000, 1.0, 12);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Geagorod', 06723877004, 6332618715, 'Geagorod@gmail.com', '2000-03-25', 'Geagorod047', 'Geagorod123', 'Vendedor', 70.000, 0.5, 13);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Fowyaze', 82863483030, 6738832922, 'Fowyaze@gmail.com', '1996-08-09', 'Fowyaze047', 'Fowyazee123', 'Vendedor', 70.000, 0.5, 14);
insert into funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_id_endereco) values ('Riek', 87327642005, 6323543033, 'Riek@gmail.com', '2002-10-15', 'Riek047', 'Riekk123', 'Gerente de Vendas', 100.000, 1.0, 15);




insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Flavio', 84803026076, 8133564535, 69915140, '2023-07-03', 5430000, 2, 25);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Sergio', 27678500009, 3233661334, 69088330, '2023-07-03', 935000, 1, 24);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Samuel', 00664059040, 8834760058, 57071707,'2023-07-05', 1050000, 3, 23);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Jorge', 95369554072, 2421330613, 72885095, '2023-07-05', 125990, 4, 22);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Edgar', 32762105099, 7936906457, 80050442,'2023-07-10', 2499990, 5, 21);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Cristiano', 87559312004, 8239385162, 69314704,'2023-07-10', 1790000, 1, 20);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Marcio', 93501152043, 4520117845, 68928054,'2023-07-13', 411500, 2, 19);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Jose', 77643116008, 9536854857, 47802094, '2023-07-13', 199900, 3, 18);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Andre', 64791387082, 7936131906, 69915210,'2023-07-17', 189900, 4, 17);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Oscar', 82616317028, 7927835461, 70238400,'2023-07-17', 148990, 5, 16) ;
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Luiza', 20478554036, 6825993819, 64049360, '2023-07-17', 65000, 1, 15);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Daiana', 75551524019, 5431073613, 68906474,'2023-07-17', 120000, 2, 14);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Julia', 78452109008, 6833333876, 89233450, '2023-07-22', 380000, 3, 13);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Marcia', 80268354090, 7928136502, 66615778, '2023-07-22', 63000, 4, 12);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Luana', 35260766008, 5539317618, 30411018,'2023-07-24', 489900, 5, 11);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Jaqueline', 88836493033, 6525055047, 95072260,'2023-07-24', 472990, 1, 10);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Helena', 69390733022, 2825562999, 77814400,'2023-07-30', 1250000, 2, 9);
insert into Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('Eliana', 19007426087, 6423656942, 53635185,'2023-07-30', 244900, 3, 8);

SELECT COUNT(*) FROM enderecos;
SELECT COUNT(*) FROM fornecedores;
SELECT COUNT(*) FROM Carros;
SELECT COUNT(*) FROM funcionarios;
SELECT COUNT(*) FROM Vendas;

SELECT * FROM enderecos order by cep;
SELECT * FROM fornecedores order by id_fornecedor;
SELECT * FROM Carros order by id_carro;
SELECT * FROM funcionarios order by matricula;
SELECT * FROM Vendas order by id_venda;

SELECT Carros.marca,
    Carros.modelo,
    Carros.novo,
    Carros.ano,
    Carros.cor,
    Carros.tipo,
    Carros.combustivel,
    Carros.quilometragem,
    Carros.potencia,
    Carros.abs,
    Carros.precoCarro,
    Carros.fornecedor_id_fornecedor,
    funcionarios.nome,
    funcionarios.cpf,
    funcionarios.telefone,
    funcionarios.email,
    funcionarios.dataDeNasc,
    funcionarios.usuario,
    funcionarios.nivelCargo,
    funcionarios.salario,
    funcionarios.comissao,
    funcionarios.enderecos_id_endereco
    FROM Vendas
INNER JOIN funcionarios ON Vendas.funcionarios_matricula = funcionarios.matricula
INNER JOIN Carros ON Vendas.Carros_id_carro = Carros.id_carro;

UPDATE enderecos SET rua ="Rua dos bobos",bairro="Velha",cidade="Jaragua",estado="SC" WHERE id_endereco = 1;
UPDATE enderecos SET rua ="Blumenau",bairro="Velha",cidade="Blumenau",estado="SC" WHERE id_endereco = 2;
UPDATE enderecos SET rua ="Arthur Gieseler",bairro="Nova",cidade="Joinville",estado="SC" WHERE id_endereco = 3;
UPDATE enderecos SET rua ="XV",bairro="Centro",cidade="Presidente Getulio",estado="SC" WHERE id_endereco = 4;
UPDATE enderecos SET rua ="Rua 7",bairro="Conconhas",cidade="Florianopolis",estado="SC" WHERE id_endereco = 5;
UPDATE enderecos SET rua ="Getulio Branco",bairro="Vila Nova",cidade="São Bento do Sul",estado="SC" WHERE id_endereco = 6;
UPDATE enderecos SET rua ="Bela Mur",bairro="Bela Vista",cidade="Gaspar",estado="SC" WHERE id_endereco = 7;
UPDATE enderecos SET rua ="7 de Novembro",bairro="Velha Nova",cidade="Blumenau",estado="SC" WHERE id_endereco = 8;
UPDATE enderecos SET rua ="Rua Steves",bairro="Ponta Aguda",cidade="Springfield",estado="Texas" WHERE id_endereco = 9;
UPDATE enderecos SET rua ="Rua Joinville",bairro="Passo Manso",cidade="Blumenau",estado="SC" WHERE id_endereco = 10;

UPDATE fornecedores SET nomeFornecedor = "ASTOLFO", cnpjFornecedor = 5646765373, telefoneFornecedor = 25254564364, empresa = "slefd", enderecos_id_endereco=5 WHERE id_fornecedor= 1;
UPDATE fornecedores SET nomeFornecedor = "RODRIGO", cnpjFornecedor = 7583939404, telefoneFornecedor = 46543364653, empresa = "rolú", enderecos_id_endereco=6 WHERE id_fornecedor= 2;
UPDATE fornecedores SET nomeFornecedor = "LUÍS", cnpjFornecedor =9605054839, telefoneFornecedor = 86940285032, empresa = "plasvale", enderecos_id_endereco=7 WHERE id_fornecedor= 3;
UPDATE fornecedores SET nomeFornecedor = "GABRIEL", cnpjFornecedor = 0950402819, telefoneFornecedor = 8694031257, empresa = "CIRCULO", enderecos_id_endereco=8 WHERE id_fornecedor= 4;
UPDATE fornecedores SET nomeFornecedor = "jOÃO", cnpjFornecedor = 8684938289, telefoneFornecedor = 96847302839, empresa = "OTTO", enderecos_id_endereco=9 WHERE id_fornecedor= 5;
UPDATE fornecedores SET nomeFornecedor = "SABEL", cnpjFornecedor = 9437439975, telefoneFornecedor = 95837259392, empresa = "TOP", enderecos_id_endereco=10 WHERE id_fornecedor= 6;
UPDATE fornecedores SET nomeFornecedor = "FERNANDO",cnpjFornecedor = 8963986379, telefoneFornecedor = 05695845944, empresa = "PRECEIRO", enderecos_id_endereco=11 WHERE id_fornecedor= 7;
UPDATE fornecedores SET nomeFornecedor = "ERIC", cnpjFornecedor = 5676765735, telefoneFornecedor = 575454745754, empresa = "AVON", enderecos_id_endereco=12 WHERE id_fornecedor= 8;
UPDATE fornecedores SET nomeFornecedor = "PEDRO", cnpjFornecedor = 9584930295, telefoneFornecedor = 65858496943, empresa = "OBOTICARIO", enderecos_id_endereco=13 WHERE id_fornecedor= 9;
UPDATE fornecedores SET nomeFornecedor = "LUCAS", cnpjFornecedor = 5754774567, telefoneFornecedor = 57578474737, empresa = "BARÃO", enderecos_id_endereco=14 WHERE id_fornecedor= 10;

-- UPDATE funcionarios SET nome = "Lindy", cpf = "51267649003	", telefone ="95937385512", salario = "435345", enderecos_cep = 98860771 WHERE matricula = 6;
-- UPDATE funcionarios SET nome = "Jarret", cpf = "73775878068", telefone ="92935526593", salario = "435435", enderecos_cep = 98860771 WHERE matricula = 7;
-- UPDATE funcionarios SET nome = "Arthur", cpf = "80662784030", telefone ="67936405836", salario = "123123", enderecos_cep = 26360149 WHERE matricula = 8;
-- UPDATE funcionarios SET nome = "Gieseler", cpf = "19870824005", telefone ="67936405836", salario = "43141", enderecos_cep = 26360149 WHERE matricula = 9;
-- UPDATE funcionarios SET nome = "Lari", cpf = "40007889062", telefone ="95937385525", salario = "768678", enderecos_cep = 26360149 WHERE matricula = 10;
-- UPDATE funcionarios SET nome = "Getulio", cpf = "73765807001", telefone ="92935526500", salario = "876867", enderecos_cep = 26360149 WHERE matricula = 11;
-- UPDATE funcionarios SET nome = "Lara", cpf = "25627834099", telefone ="67936405823", salario = "45654", enderecos_cep = 33395580 WHERE matricula = 12;
-- UPDATE funcionarios SET nome = "Dirku", cpf = "04223201026", telefone ="67936405889", salario = "654654", enderecos_cep = 33395580 WHERE matricula = 13;
-- UPDATE funcionarios SET nome = "Gizayon", cpf = "36257549086", telefone ="95937385512", salario = "234567", enderecos_cep = 90807252 WHERE matricula = 14;
-- UPDATE funcionarios SET nome = "Fior", cpf = "54985014044", telefone ="95937385511", salario = "498654", enderecos_cep = 90807252 WHERE matricula = 15;

-- UPDATE Carros SET marca = "Ford", modelo = "Ka", potencia = 95, quilometragem = 30000, novos = true, eletrico = true, esportivo = false, picape = true, ano = 2008, cor = "Azul", abs = false, preco = 47000, fornecedor_id_fornecedor = 2 WHERE id_veiculo = 1;
-- UPDATE Carros SET marca = "Chevrolet", modelo = "Camaro", potencia = 340, quilometragem = 20000, novos = false, eletrico = false, esportivo = true, picape = false, ano = 2015, cor = "Amarelo", abs = true, preco = 320000, fornecedor_id_fornecedor = 1 WHERE id_veiculo = 2;
-- UPDATE Carros SET marca = "Chevrolet", modelo = "Cruize", potencia = 120, quilometragem = 90000, novos = false, eletrico = false, esportivo = false, picape = false, ano = 2016, cor = "Branco", abs = true, preco = 82000, fornecedor_id_fornecedor = 6 WHERE id_veiculo = 3;
-- UPDATE Carros SET marca = "Bentley", modelo = "Bentayga", potencia = 450, quilometragem = 0, novos = true, eletrico = false, esportivo = true, picape = false, ano = 2020, cor = "Cinza", abs = true, preco = 750000, fornecedor_id_fornecedor = 8 WHERE id_veiculo = 4;
-- UPDATE Carros SET marca = "koenigsegg", modelo = "Agera", potencia = 1176, quilometragem = 10000, novos = false, eletrico = false, esportivo = true, picape = false, ano = 2021, cor = "Vermelho", abs = true, preco = 1200000, fornecedor_id_fornecedor = 10 WHERE id_veiculo = 5;
-- UPDATE Carros SET marca = "Bugatti", modelo = "Chiron", potencia = 700, quilometragem = 0, novos = true, eletrico = false, esportivo = true, picape = false, ano = 2017, cor = "Azul", abs = true, preco = 1100000, fornecedor_id_fornecedor = 16 WHERE id_veiculo = 6;
-- UPDATE Carros SET marca = "Dodge", modelo = "Ram", potencia = 500, quilometragem = 45000, novos = false, eletrico = false, esportivo = false, picape = true, ano = 2016, cor = "Preto", abs = true, preco = 500000, fornecedor_id_fornecedor = 25 WHERE id_veiculo = 7;
-- UPDATE Carros SET marca = "Fiat", modelo = "Uno", potencia = 95, quilometragem = 120000, novos = false, eletrico = false, esportivo = false, picape = false, ano = 2002, cor = "Bordô", abs = false, preco = 25000, fornecedor_id_fornecedor = 24 WHERE id_veiculo = 8;
-- UPDATE Carros SET marca = "Nissan", modelo = "Kicks", potencia = 120, quilometragem = 0, novos = true, eletrico = false, esportivo = false, picape = false, ano = 2023, cor = "Branco", abs = true, preco = 95000, fornecedor_id_fornecedor = 23 WHERE id_veiculo = 9;
-- UPDATE Carros SET marca = "Hiunday", modelo = "Creta", potencia = 135, quilometragem = 0, novos = true, eletrico = false, esportivo = false, picape = false, ano = 2022, cor = "Cinza", abs = true, preco = 145000, fornecedor_id_fornecedor = 22 WHERE id_veiculo = 10;

-- UPDATE Vendas SET nome = "Rodrigo", cpf=28716145631, usuario='Eric.o', ipva_pago=false, modelo='Navigator', funcionarios_matricula=1, tipo_veiculo='Picape' WHERE Carros_id_veiculo =1 ;
-- UPDATE Vendas SET nome = "Andrei", cpf=16272567685, usuario='luis.g', ipva_pago=true, modelo='Camaro', funcionarios_matricula=2, tipo_veiculo='Picape' WHERE Carros_id_veiculo = 2;
-- UPDATE Vendas SET nome = "bernardo", cpf=91315765080, usuario='liz.s', ipva_pago=false, modelo='RAV4', funcionarios_matricula=3, tipo_veiculo='Picape' WHERE Carros_id_veiculo = 3;
-- UPDATE Vendas SET nome = "Gustavo", cpf=55035814157, usuario='joao.g', ipva_pago=true, modelo='RAV4', funcionarios_matricula=4, tipo_veiculo='Picape' WHERE Carros_id_veiculo =4 ;
-- UPDATE Vendas SET nome = "Amanda", cpf=03567342266, usuario='liz.z', ipva_pago=true, modelo='Camaro', funcionarios_matricula=5, tipo_veiculo='Picape' WHERE Carros_id_veiculo = 5;
-- UPDATE Vendas SET nome = "Carlos", cpf=81771519592, usuario='joao.df', ipva_pago=false, modelo='Navigator', funcionarios_matricula=6, tipo_veiculo='Picape' WHERE Carros_id_veiculo = 6;
-- UPDATE Vendas SET nome = "Erik", cpf=16164101590, usuario='Eric.de', ipva_pago=true, modelo='Camaro', funcionarios_matricula=7, tipo_veiculo='Picape' WHERE Carros_id_veiculo =7 ;
-- UPDATE Vendas SET nome = "Anderson", cpf=66119902759, usuario='luis.lo', ipva_pago=false, modelo='RAV4', funcionarios_matricula=8, tipo_veiculo='Picape' WHERE Carros_id_veiculo = 8;
-- UPDATE Vendas SET nome = "Robson", cpf=90190269766, usuario='Eric.sa', ipva_pago=true, modelo='Camaro', funcionarios_matricula=9, tipo_veiculo='Picape' WHERE Carros_id_veiculo = 9 ;
-- UPDATE Vendas SET nome = "Welliton", cpf=94642174800, usuario='luiz.s', ipva_pago=false, modelo='Navigator', funcionarios_matricula=10, tipo_veiculo='Picape' WHERE Carros_id_veiculo = 10;

DELETE FROM Vendas WHERE id_venda = 1;
DELETE FROM Vendas WHERE id_venda = 2;
DELETE FROM Vendas WHERE id_venda = 3;
DELETE FROM Vendas WHERE id_venda = 4;
DELETE FROM Vendas WHERE id_venda = 5;

DELETE FROM funcionarios WHERE matricula = 10;
DELETE FROM funcionarios WHERE matricula = 11;
DELETE FROM funcionarios WHERE matricula = 12;
DELETE FROM funcionarios WHERE matricula = 13;
DELETE FROM funcionarios WHERE matricula = 14;

-- DELETE FROM fornecedores WHERE id_fornecedor = 1;
-- DELETE FROM fornecedores WHERE id_fornecedor = 2;
-- DELETE FROM fornecedores WHERE id_fornecedor = 3;
-- DELETE FROM fornecedores WHERE id_fornecedor = 4;
-- DELETE FROM fornecedores WHERE id_fornecedor = 5;

DELETE FROM Carros WHERE id_carro = 1;
DELETE FROM Carros WHERE id_carro = 2;
DELETE FROM Carros WHERE id_carro = 3;
DELETE FROM Carros WHERE id_carro = 4;
DELETE FROM Carros WHERE id_carro = 5;

DELETE FROM Vendas WHERE id_venda = 3;
DELETE FROM Vendas WHERE id_venda = 8;
DELETE FROM Vendas WHERE id_venda = 13;
DELETE FROM Vendas WHERE id_venda = 14;
DELETE FROM Vendas WHERE id_venda = 15;

-- DELETE FROM enderecos WHERE id_endereco = 13;
-- DELETE FROM enderecos WHERE id_endereco = 12;
-- DELETE FROM enderecos WHERE id_endereco = 11;
-- DELETE FROM enderecos WHERE id_endereco = 10;
-- DELETE FROM enderecos WHERE id_endereco = 14;