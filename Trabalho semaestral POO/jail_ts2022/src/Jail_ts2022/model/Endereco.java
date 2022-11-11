/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jail_ts2022.model;

/**
 *
 * @author Klesia
 */
public class Endereco {

    private String id_endereco, casa, bairro, rua, Quarteirao;
    private Provincias provincias;

    public Endereco(String id_endereco, String casa, String bairro, String rua, String Quarteirao, Provincias provincias) {
        this.id_endereco = id_endereco;
        this.casa = casa;
        this.bairro = bairro;
        this.rua = rua;
        this.Quarteirao = Quarteirao;
        this.provincias = provincias;
    }

    public Endereco() {
    }

    public String getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(String id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getQuarteirao() {
        return Quarteirao;
    }

    public void setQuarteirao(String Quarteirao) {
        this.Quarteirao = Quarteirao;
    }

    public Provincias getProvincias() {
        return provincias;
    }

    public void setProvincias(Provincias provincias) {
        this.provincias = provincias;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id_endereco=" + id_endereco + ", casa=" + casa + ", bairro=" + bairro + ", rua=" + rua + ", Quarteirao=" + Quarteirao + ", provincias=" + provincias + '}';
    }

    
}
