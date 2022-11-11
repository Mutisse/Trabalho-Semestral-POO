/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jail_ts2022.model;

import java.util.ArrayList;
import Jail_ts2022.dao.ReclusoDao;

/**
 *
 * @author Mutisse
 */
public class Recluso extends Pessoa {

    private String estadoCivil, id_registro, estadoDaPrisao, doenca, caracterizarRecluso, nivelAcademico, frequencia = "1", registroDeBens, duracaoDapena;
    private Celas celas;
    private ArrayList<Crimes> crime = new ArrayList<Crimes>();
    private Funcionario funcionario;
    private Advogado advogado;
    private Endereco endereco;

    public Recluso() {
    }

    @Override
    public String toString() {
        return "Recluso{" + "estadoCivil=" + estadoCivil + ", id_registro=" + id_registro + ", estadoDaPrisao=" + estadoDaPrisao + ", doenca=" + doenca + ", caracterizarRecluso=" + caracterizarRecluso + ", nivelAcademico=" + nivelAcademico + ", frequencia=" + frequencia + ", registroDeBens=" + registroDeBens + ", duracaoDapena=" + duracaoDapena + ", celas=" + celas + ", crime=" + crime + ", funcionario=" + funcionario + ", advogado=" + advogado + ", endereco=" + endereco + '}';
    }

    
    
    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getId_registro() {
        return id_registro;
    }

    public void setId_registro(String id_registro) {
        this.id_registro = id_registro;
    }

    public String getEstadoDaPrisao() {
        return estadoDaPrisao;
    }

    public void setEstadoDaPrisao(String estadoDaPrisao) {
        this.estadoDaPrisao = estadoDaPrisao;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getCaracterizarRecluso() {
        return caracterizarRecluso;
    }

    public void setCaracterizarRecluso(String caracterizarRecluso) {
        this.caracterizarRecluso = caracterizarRecluso;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getRegistroDeBens() {
        return registroDeBens;
    }

    public void setRegistroDeBens(String registroDeBens) {
        this.registroDeBens = registroDeBens;
    }

    public String getDuracaoDapena() {
        return duracaoDapena;
    }

    public void setDuracaoDapena(String duracaoDapena) {
        this.duracaoDapena = duracaoDapena;
    }

    public Celas getCelas() {
        return celas;
    }

    public void setCelas(Celas celas) {
        this.celas = celas;
    }

    public ArrayList<Crimes> getCrime() {

        return crime;
    }

    public void setCrime(ArrayList<Crimes> crime) {
        this.crime = crime;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Recluso(String estadoCivil, String id_registro, String estadoDaPrisao, String doenca, String caracterizarRecluso, String nivelAcademico, String registroDeBens, String duracaoDapena, Celas celas, ArrayList<Crimes> crime, Funcionario funcionario, Advogado advogado, Endereco endereco, String codigo, String nome, String apelido, String genero, String numeroDeBI, String Nuit, String contacto, String datadeNascimento, String dataDeregistro, String dataSaidaRegistro, String email, String estado) {
        super(codigo, nome, apelido, genero, numeroDeBI, Nuit, contacto, datadeNascimento, dataDeregistro, dataSaidaRegistro, email, estado);
        this.estadoCivil = estadoCivil;
        this.id_registro = id_registro;
        this.estadoDaPrisao = estadoDaPrisao;
        this.doenca = doenca;
        this.caracterizarRecluso = caracterizarRecluso;
        this.nivelAcademico = nivelAcademico;
        this.registroDeBens = registroDeBens;
        this.duracaoDapena = duracaoDapena;
        this.celas = celas;
        this.crime = crime;
        this.funcionario = funcionario;
        this.advogado = advogado;
        this.endereco = endereco;
    }

    public ArrayList<Recluso> listar() {
        return (ArrayList<Recluso>) new ReclusoDao().listarTodosReclusos();
    }

}
