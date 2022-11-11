/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jail_ts2022.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mutisse
 */
public class CriarbaseDados {

    /*-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema peniteciariadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema peniteciariadb
-- -----------------------------------------------------*/
    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;

    public void criarbd() {
        conexao = Conectar.conector();
        String querySql = "CREATE DATABASE IF NOT EXISTS jail_ts2022;";

        try {
            stat = conexao.prepareStatement(querySql);
            stat.executeUpdate();
        } catch (SQLException e) {
        }
    }

    /*-- -----------------------------------------------------
-- Table `peniteciariadb`.`tbfuncionario`
-- -----------------------------------------------------*/
    /**
     *
     * @throws SQLException
     */
    public void tbfuncionario() {

        conexao = Conectar.conector();
        String querySql = "USE jail_ts2022 ;"
                + "CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbfuncionario` (\n"
                + " `ID_Funcionario` BIGINT(20) primary key NOT NULL,\n"
                + " `apelido` VARCHAR(30) NOT NULL,\n"
                + " `nome` VARCHAR(30) NOT NULL,\n"
                + " `Genero` ENUM('Masculino', 'Femenino') NULL DEFAULT NULL,\n"
                + " `datadeNascimento` DATE NULL DEFAULT NULL,\n"
                + " `nrbi` VARCHAR(20) NULL DEFAULT NULL,\n"
                + " `nuit` INT(10) NULL DEFAULT NULL,\n"
                + " `Contcto` VARCHAR(20) NULL DEFAULT NULL,\n"
                + " `Statuss` ENUM('Activo', 'Inativo', 'Removido') NULL DEFAULT NULL,\n"
                + " `dataDeregistro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP (),\n"
                + " `dataSaidaRegistro` DATETIME NULL DEFAULT NULL,\n"
                + " `id_naturalidade` int,\n"
                + " `id_categoria` int,\n"
                + " `id_auteticacao` bigint,\n"
                + " foreign key (`id_categoria`) references `tbcategoria` (`id_categoria`),\n"
                + " foreign key (`id_auteticacao`) references `tbauteticacao` (`id_auteticacao`),\n"
                + " foreign key (`id_naturalidade`) references `tbnaturalidade` (`id_naturalidade`)\n"
                + ") ENGINE=INNODB DEFAULT CHARACTER SET=UTF8MB4";

        try {
            stat = conexao.prepareStatement(querySql);
            stat.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    /*-- -----------------------------------------------------
-- Table `peniteciariadb`.`tbadmin`
-- -----------------------------------------------------*/
    public void tbauteticacao() {

        conexao = Conectar.conector();
        String querySql = "USE jail_ts2022 ;"
                + "CREATE TABLE IF NOT EXISTS `jail_ts2022`.`tbauteticacao` (\n"
                + " `id_auteticacao` BIGINT(20) primary key NOT NULL,\n"
                + " `email` VARCHAR(250) NOT NULL,\n"
                + " `Senha` VARCHAR(250) NULL DEFAULT NULL\n"
                + ") ENGINE=INNODB DEFAULT CHARACTER SET=UTF8MB4;";

        try {
            stat = conexao.prepareStatement(querySql);
            stat.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    /*-- -----------------------------------------------------
-- Table `peniteciariadb`.`tbcelas`
-- -----------------------------------------------------
     */
    public void createTableCelas() {

        conexao = Conectar.conector();
        String querySql = "USE  peniteciariadb;\n"
                + "CREATE TABLE IF NOT EXISTS tbrecluso (\n"
                + "  Idrecluso INT(11) PRIMARY KEY AUTO_INCREMENT,\n"
                + "  Apelido VARCHAR(30) NOT NULL,\n"
                + "  Nome VARCHAR(30) NOT NULL,\n"
                + "  Genero  ENUM('Masculino', 'Femenino') ,\n"
                + "  datadeNascimento DATE ,\n"
                + "  nrbi VARCHAR(50) UNIQUE,\n"
                + "  nuit  INT(50) UNIQUE,\n"
                + "  estadoCivil ENUM('Casado', 'Solteiro') ,\n"
                + "  naturalidade VARCHAR(50) DEFAULT 'Moçambicana',\n"
                + "  endereco TEXT,\n"
                + "  Contcto VARCHAR(20) ,\n"
                + "  contactoSecundario VARCHAR(50) ,\n"
                + "  nivelAcademico  VARCHAR(10) ,\n"
                + "  doenca TEXT,\n"
                + "  nomeDeAdvogado VARCHAR(50) ,\n"
                + "  contactoDeAdvogado VARCHAR(20) ,\n"
                + "  registroDeBens TEXT ,\n"
                + "  IdFuncionario INT(11) ,\n"
                + "  FOREIGN KEY (IdFuncionario)\n"
                + "  REFERENCES tbfuncionario (IdFuncionario) );";

        try {
            stat = conexao.prepareStatement(querySql);
            stat.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    /*-- -----------------------------------------------------
-- Table `peniteciariadb`.`tbrecluso`
-- -----------------------------------------------------*/
    public void createTableRecluso() throws SQLException {

        conexao = Conectar.conector();
        String querySql = "USE  peniteciariadb;\n"
                + "CREATE TABLE IF NOT EXISTS tbcelas (\n"
                + "  Idcela INT(11) PRIMARY KEY AUTO_INCREMENT,\n"
                + "  estado VARCHAR(20),\n"
                + "  crime VARCHAR(20) ,\n"
                + "  duracao VARCHAR(20) ,\n"
                + "  cela  VARCHAR(20) ,\n"
                + "  datadeEntrada TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),\n"
                + "  dataSaida datetime,\n"
                + "  Idrecluso INT(11) ,\n"
                + " FOREIGN KEY (Idrecluso)\n"
                + " REFERENCES tbrecluso (Idrecluso) ) ;";

        try {
            stat = conexao.prepareStatement(querySql);
            stat.executeUpdate();
        } catch (SQLException ex) {

        }
    }

}
