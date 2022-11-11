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
public class Solturas {

    private String id_soltura, dataSaida;

    public Solturas() {
    }

    public Solturas(String id_soltura, String dataSaida) {
        this.id_soltura = id_soltura;
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return "Soltura{" + "id_soltura=" + id_soltura + ", dataSaida=" + dataSaida + '}';
    }

    public String getId_soltura() {
        return id_soltura;
    }

    public void setId_soltura(String id_soltura) {
        this.id_soltura = id_soltura;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

}
