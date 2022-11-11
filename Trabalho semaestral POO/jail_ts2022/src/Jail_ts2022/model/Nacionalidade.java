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
public class Nacionalidade {

    private String nacionalidade, id_nacionalidade;

    public Nacionalidade(String nacionalidade, String id_nacionalidade) {
        this.nacionalidade = nacionalidade;
        this.id_nacionalidade = id_nacionalidade;
    }

    public Nacionalidade() {
    }

    
    
    @Override
    public String toString() {
        return  nacionalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getId_nacionalidade() {
        return id_nacionalidade;
    }

    public void setId_nacionalidade(String id_nacionalidade) {
        this.id_nacionalidade = id_nacionalidade;
    }
    
    

}
