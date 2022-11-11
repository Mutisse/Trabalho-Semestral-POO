/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jail_ts2022.model;

/**
 *
 * @author Mutisse
 */
public class Celas {

    private String id_celas, cela, capacitMax,estadoDaCela,nrcama,StatusCama;;

    public Celas(String id_celas, String cela, String capacitMax, String estadoDaCela, String nrcama, String StatusCama) {
        this.id_celas = id_celas;
        this.cela = cela;
        this.capacitMax = capacitMax;
        this.estadoDaCela = estadoDaCela;
        this.nrcama = nrcama;
        this.StatusCama = StatusCama;
    }

    public Celas() {
    }

    @Override
    public String toString() {
        return cela;
    }

    public String getId_celas() {
        return id_celas;
    }

    public void setId_celas(String id_celas) {
        this.id_celas = id_celas;
    }

    public String getCela() {
        return cela;
    }

    public void setCela(String cela) {
        this.cela = cela;
    }

    public String getCapacitMax() {
        return capacitMax;
    }

    public void setCapacitMax(String capacitMax) {
        this.capacitMax = capacitMax;
    }

    public String getEstadoDaCela() {
        return estadoDaCela;
    }

    public void setEstadoDaCela(String estadoDaCela) {
        this.estadoDaCela = estadoDaCela;
    }

    public String getNrcama() {
        return nrcama;
    }

    public void setNrcama(String nrcama) {
        this.nrcama = nrcama;
    }

    public String getStatusCama() {
        return StatusCama;
    }

    public void setStatusCama(String StatusCama) {
        this.StatusCama = StatusCama;
    }

   

   

   
   
  
}
