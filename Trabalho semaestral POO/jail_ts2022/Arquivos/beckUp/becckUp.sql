-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema peniteciariadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema peniteciariadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `peniteciariadb` DEFAULT CHARACTER SET utf8mb4 ;
USE `peniteciariadb` ;

-- -----------------------------------------------------
-- Table `peniteciariadb`.`tbrecluso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peniteciariadb`.`tbrecluso` (
  `IdR` INT(11) NOT NULL AUTO_INCREMENT,
  `codigoDeRecluso` VARCHAR(30) NOT NULL,
  `Apelido` VARCHAR(30) NOT NULL,
  `Nome` VARCHAR(30) NOT NULL,
  `Genero` ENUM('Masculino', 'Femenino') NULL DEFAULT NULL,
  `datadeNascimento` DATE NULL DEFAULT NULL,
  `nrbi` VARCHAR(50) NULL DEFAULT NULL,
  `nuit` INT(50) NULL DEFAULT NULL,
  `estadoCivil` ENUM('Casado', 'Solteiro') NULL DEFAULT NULL,
  `endereco` TEXT NULL DEFAULT NULL,
  `Contcto` VARCHAR(20) NULL DEFAULT NULL,
  `nomeDeAdvogado` VARCHAR(50) NULL DEFAULT NULL,
  `contactoDeAdvogado` VARCHAR(20) NULL DEFAULT NULL,
  `emailAdvogado` VARCHAR(50) NOT NULL,
  `registroDeBens` TEXT NULL DEFAULT NULL,
  `removedo` ENUM('true', 'false') NULL DEFAULT NULL,
  PRIMARY KEY (`IdR`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `peniteciariadb`.`tbrelacimamentorecluso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peniteciariadb`.`tbrelacimamentorecluso` (
  `Idcela` INT(11) NOT NULL AUTO_INCREMENT,
  `celasExitentes` VARCHAR(20) NULL DEFAULT NULL,
  `duracaoDapena` VARCHAR(20) NULL DEFAULT NULL,
  `estadosDecriminosos` VARCHAR(20) NULL DEFAULT NULL,
  `tipoDeCrime` VARCHAR(20) NULL DEFAULT NULL,
  `doenca` VARCHAR(20) NULL DEFAULT NULL,
  `naturalidade` VARCHAR(50) NULL DEFAULT 'Moçambicana',
  `altura` VARCHAR(20) NULL DEFAULT NULL,
  `nivelAcademico` VARCHAR(10) NULL DEFAULT NULL,
  `datadeEntrada` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `dataSaida` DATETIME NULL DEFAULT NULL,
  `tbrecluso_IdR` INT(11) NOT NULL,
    PRIMARY KEY (`Idcela`, `tbrecluso_IdR`),
    FOREIGN KEY (`tbrecluso_IdR`)
    REFERENCES `peniteciariadb`.`tbrecluso` (`IdR`)
    )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `peniteciariadb`.`tbfuncionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peniteciariadb`.`tbfuncionario` (
  `IdF` INT(11) NOT NULL AUTO_INCREMENT,
  `CodigoFuncionario` VARCHAR(30) NOT NULL,
  `Apelido` VARCHAR(30) NOT NULL,
  `Nome` VARCHAR(30) NOT NULL,
  `Genero` ENUM('Masculino', 'Femenino') NULL DEFAULT NULL,
  `email` VARCHAR(50) NOT NULL,
  `Senha` VARCHAR(250) NOT NULL,
  `NivelDeAcesso` VARCHAR(35) NULL DEFAULT 'Funcionário',
  `Statuss` ENUM('Activo', 'Inativo') NULL DEFAULT NULL,
  `removedo` ENUM('true', 'false') NULL DEFAULT NULL,
  `nrbi` VARCHAR(20) NULL DEFAULT NULL,
  `nuit` INT(10) NULL DEFAULT NULL,
  `datadeNascimento` DATE NULL DEFAULT NULL,
  `naturalidade` VARCHAR(20) NULL DEFAULT 'Moçambicana',
  `Contcto` VARCHAR(20) NULL DEFAULT NULL,
  `estadoCivil` ENUM('Casado', 'Solteiro') NULL DEFAULT NULL,
  `datadeEntrada` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `dataSaida` DATETIME NULL DEFAULT NULL,
  `tbrecluso_IdR` INT(11) NOT NULL,
  PRIMARY KEY (`IdF`, `tbrecluso_IdR`),
  UNIQUE INDEX `CodigoFuncionario` (`CodigoFuncionario` ASC) VISIBLE,
  UNIQUE INDEX `email` (`email` ASC) VISIBLE,
  UNIQUE INDEX `Senha` (`Senha` ASC) VISIBLE,
  UNIQUE INDEX `nrbi` (`nrbi` ASC) VISIBLE,
  UNIQUE INDEX `nuit` (`nuit` ASC) VISIBLE,
  INDEX `fk_tbfuncionario_tbrecluso1_idx` (`tbrecluso_IdR` ASC) VISIBLE,
  CONSTRAINT `fk_tbfuncionario_tbrecluso1`
    FOREIGN KEY (`tbrecluso_IdR`)
    REFERENCES `peniteciariadb`.`tbrecluso` (`IdR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `peniteciariadb`.`tbdefinicoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peniteciariadb`.`tbdefinicoes` (
  `Idf` INT(11) NOT NULL AUTO_INCREMENT,
  `Cbnaturalidade` TEXT NULL DEFAULT NULL,
  `cbNovascelas` TEXT NULL DEFAULT NULL,
  `cbNivelDeAcesso` TEXT NULL DEFAULT NULL,
  `cbCelas` VARCHAR(20) NULL DEFAULT NULL,
  `cbduracaoDapena` VARCHAR(20) NULL DEFAULT NULL,
  `cbestadosDecriminosos` VARCHAR(20) NULL DEFAULT NULL,
  `cbtipoDeCrime` VARCHAR(20) NULL DEFAULT NULL,
  `cbdoenca` VARCHAR(20) NULL DEFAULT NULL,
  `cbaltura` VARCHAR(20) NULL DEFAULT NULL,
  `cbnivelAcademico` VARCHAR(10) NULL DEFAULT NULL,

  PRIMARY KEY (`Idf`)
  
    )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
