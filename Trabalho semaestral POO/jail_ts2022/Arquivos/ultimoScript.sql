-- MySQL Workbench Forward Engineering


-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema jail_ts2022
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jail_ts2022
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jail_ts2022` DEFAULT CHARACTER SET utf8mb4 ;



USE `jail_ts2022` ;



-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbcategoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbcategoria` (
    `id_categoria` INT(11) NOT NULL AUTO_INCREMENT,
    `nivelDeAcesso` VARCHAR(20) NULL DEFAULT NULL,
     `estadoNivelDeAcesso` ENUM('Activo', 'Removido') NULL DEFAULT 'Activo',
    PRIMARY KEY (`id_categoria`)
);


-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbcelas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbcelas` (
    `id_celas` INT(11) NOT NULL AUTO_INCREMENT,
    `NomeDacela` VARCHAR(50) NULL DEFAULT NULL,
    `capacidadeMax` INT(11) NULL DEFAULT NULL,
    `estadoDaCela` ENUM('Disponivel', 'Indisponivel','Removido') NULL DEFAULT 'Disponivel',
    `nrcama` INT(11) NULL DEFAULT NULL,
    `estadoDacama` ENUM('Ocupada', 'Deseocupada') NULL DEFAULT 'Deseocupada',
    PRIMARY KEY (`id_celas`)
);


-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbcrimes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbcrimes` (
    `id_crimes` INT(20) NOT NULL AUTO_INCREMENT,
    `categoriaDeCrime` VARCHAR(250) NULL DEFAULT NULL,
    `duracaoEmAno` VARCHAR(250) NULL DEFAULT NULL,
    `duracaoEmMeses` VARCHAR(250) NULL DEFAULT NULL,
     `estadoCrime` ENUM('Activo', 'Removido') NULL DEFAULT 'Activo',
    PRIMARY KEY (`id_crimes`)
);


-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbnacionalidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbnacionalidade` (
    `id_nacionalidade` INT(11) NOT NULL AUTO_INCREMENT,
    `nomeDoPais` VARCHAR(50) NULL DEFAULT NULL,
    `estadoProvincia` ENUM('Activo', 'Removido') NULL DEFAULT 'Activo',
    PRIMARY KEY (`id_nacionalidade`)
);


-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbprovincias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbprovincias` (
    `id_Provincias` INT(11) NOT NULL AUTO_INCREMENT,
    `NomeDaProvincia` VARCHAR(30) NOT NULL,
    `estadoProvincia` ENUM('Activo', 'Removido') NULL DEFAULT 'Activo',
    `tbnacionalidade_id_nacionalidade` INT(11) NOT NULL,
    PRIMARY KEY (`id_Provincias`),
    FOREIGN KEY (`tbnacionalidade_id_nacionalidade`)
        REFERENCES `jail_ts2022`.`tbnacionalidade` (`id_nacionalidade`)
);


-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbfuncionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbfuncionario` (
    `id_funcionario` INT(11) NOT NULL AUTO_INCREMENT,
    `codigoDeFuncionario` BIGINT(20) NULL DEFAULT NULL,
    `apelido` VARCHAR(50) NULL DEFAULT NULL,
    `nome` VARCHAR(50) NULL DEFAULT NULL,
    `Genero` ENUM('Masculino', 'Feminino') NULL DEFAULT NULL,
    `datadeNascimento` DATE,
    `nrbi` VARCHAR(50) UNIQUE,
    `nuit` VARCHAR(50) NULL UNIQUE,
    `Contcto` VARCHAR(50) NULL DEFAULT NULL,
    `email` VARCHAR(250) NULL DEFAULT NULL,
    `Senha` VARCHAR(250) NULL DEFAULT NULL,
    `Statuss` ENUM('Activo', 'Inativo', 'Removido') NULL DEFAULT 'Activo',
    `dataDeregistro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP (),
    `tbcategoria_id_categoria` INT(11) NOT NULL,
    PRIMARY KEY (`id_funcionario`),
    FOREIGN KEY (`tbcategoria_id_categoria`)
        REFERENCES `jail_ts2022`.`tbcategoria` (`id_categoria`),
    `tbprovincias_id_Provincias` INT(11) NOT NULL,
    FOREIGN KEY (`tbprovincias_id_Provincias`)
        REFERENCES `jail_ts2022`.`tbprovincias` (`id_Provincias`)
);


-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbrecluso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbrecluso` (
    `id_recluso` INT(11) NOT NULL AUTO_INCREMENT,
    `codigoDeRrcluso` BIGINT(20) NULL DEFAULT NULL,
    `nome` VARCHAR(50) NULL DEFAULT NULL,
    `apelido` VARCHAR(30) NULL DEFAULT NULL,
    `genero` ENUM('Masculino', 'Feminino') NULL DEFAULT NULL,
    `datadeNascimento` date,
    `nrbi` VARCHAR(50) NULL DEFAULT NULL,
    `StatusRecluso` ENUM('Activo', 'Solto', 'Removido','Foragido') NULL DEFAULT 'Activo',
    `doenca` VARCHAR(50) NULL DEFAULT NULL,
    `nivelAcademico` VARCHAR(50) NULL DEFAULT NULL,
    `registroDeBens` TEXT NULL DEFAULT NULL,
    `caracterizar` TEXT NULL DEFAULT NULL,
    `estadoDePrisao` VARCHAR(50) NULL DEFAULT NULL,
    `duracaoDapena` VARCHAR(250) NULL DEFAULT NULL,
    `frequencia` INT(11) NOT NULL,
    `dataDeregistro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP (),
    `tbcelas_id_celas` INT(11) NOT NULL,
    PRIMARY KEY (`id_recluso`),
    FOREIGN KEY (`tbcelas_id_celas`)
        REFERENCES `jail_ts2022`.`tbcelas` (`id_celas`)
);


-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbendereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbendereco` (
    `id_endereco` INT(11),
    `casa` VARCHAR(50) NULL DEFAULT NULL,
    `rua` VARCHAR(50) NULL DEFAULT NULL,
    `quarteirao` VARCHAR(50) NULL DEFAULT NULL,
    `bairro` VARCHAR(50) NULL DEFAULT NULL,
    `tbprovincias_id_Provincias` INT(11) NOT NULL,
    `tbrecluso_id_recluso` INT(11) NOT NULL,
    PRIMARY KEY (`id_endereco`),
    FOREIGN KEY (`tbprovincias_id_Provincias`)
        REFERENCES `jail_ts2022`.`tbprovincias` (`id_Provincias`),
    FOREIGN KEY (`tbrecluso_id_recluso`)
        REFERENCES `jail_ts2022`.`tbrecluso` (`id_recluso`)
);


-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbadvogados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbadvogados` (
    `id_advogados` INT(11) AUTO_INCREMENT,
    `nomeDeAdvogado` VARCHAR(30) NULL DEFAULT NULL,
    `contactoDeAdvogado` VARCHAR(20) NULL DEFAULT NULL,
    `emailAdvogado` VARCHAR(50) NULL DEFAULT NULL,
    `estadoAdvogado` ENUM('Activo', 'Removido') NULL DEFAULT 'Activo',
    `tbrecluso_id_recluso` INT(11) NOT NULL,
    PRIMARY KEY (`id_advogados`),
    FOREIGN KEY (`tbrecluso_id_recluso`)
        REFERENCES `jail_ts2022`.`tbrecluso` (`id_recluso`)
);

-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbsoltura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbsoltura` (
    `id_soltura` INT(20) NOT NULL AUTO_INCREMENT,
    `especificarAsoltura` VARCHAR(250) NULL DEFAULT NULL,
    `dataSaidaRegistro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP (),
    `tbrecluso_id_recluso` INT(11) NOT NULL,
    `tbcelas_id_celas` INT(11) NOT NULL,
    PRIMARY KEY (`id_soltura`),
    FOREIGN KEY (`tbrecluso_id_recluso`)
        REFERENCES `jail_ts2022`.`tbrecluso` (`id_recluso`),
    FOREIGN KEY (`tbcelas_id_celas`)
        REFERENCES `jail_ts2022`.`tbcelas` (`id_celas`)
);

  
-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbrecluso_has_tbcrimes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbrecluso_has_tbcrimes` (
    `tbrecluso_id_recluso` INT(11) NOT NULL,
    `tbcrimes_id_crimes` INT(20) NOT NULL,
    PRIMARY KEY (`tbrecluso_id_recluso` , `tbcrimes_id_crimes`),
    FOREIGN KEY (`tbrecluso_id_recluso`)
        REFERENCES `jail_ts2022`.`tbrecluso` (`id_recluso`),
    FOREIGN KEY (`tbcrimes_id_crimes`)
        REFERENCES `jail_ts2022`.`tbcrimes` (`id_crimes`)
);


-- -----------------------------------------------------
-- Table `jail_ts2022`.`tbsoltura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jail_ts2022`.`RemoverEbloqueraFuncionario` (
    id_removidos INT PRIMARY KEY AUTO_INCREMENT,
    `especificarMotivo` TEXT NOT NULL,
    `dataSaidaRegistro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP (),
    `tbfuncionario_id_funcionario` INT(11) NOT NULL,
    FOREIGN KEY (`tbfuncionario_id_funcionario`)
        REFERENCES `jail_ts2022`.`tbfuncionario` (`id_funcionario`)
);

select* from tbrecluso;
