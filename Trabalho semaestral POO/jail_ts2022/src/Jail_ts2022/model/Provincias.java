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
public class Provincias {

    private String id_provincias, provicias;
    private  Nacionalidade nacionalidade;

    public Provincias(String id_provincias, String provicias, Nacionalidade nacionalidade) {
        this.id_provincias = id_provincias;
        this.provicias = provicias;
        this.nacionalidade = nacionalidade;
    }
   

    public Provincias() {
    }

    @Override
    public String toString() {
        return provicias ;
    }

    public String getId_provincias() {
        return id_provincias;
    }

    public void setId_provincias(String id_provincias) {
        this.id_provincias = id_provincias;
    }

    public String getProvicias() {
        return provicias;
    }

    public void setProvicias(String provicias) {
        this.provicias = provicias;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    
}
