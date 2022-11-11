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
public class NivelDeAcesso {

    
    private String id_categoria, categoria;

    public NivelDeAcesso(String id_categoria, String categoria) {
        this.id_categoria = id_categoria;
        this.categoria = categoria;
    }

    public NivelDeAcesso() {
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

  
    @Override
    public String toString() {
        return categoria;
    }

}
