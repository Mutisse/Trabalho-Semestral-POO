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
public class Advogado {

    private String id_Advogado, nomeDeAdvogado, contactoDeAdvogado, emailAdvogado;

    public String getId_Advogado() {
        return id_Advogado;
    }

    public void setId_Advogado(String id_Advogado) {
        this.id_Advogado = id_Advogado;
    }

    public String getNomeDeAdvogado() {
        return nomeDeAdvogado;
    }

    public void setNomeDeAdvogado(String nomeDeAdvogado) {
        this.nomeDeAdvogado = nomeDeAdvogado;
    }

    public String getContactoDeAdvogado() {
        return contactoDeAdvogado;
    }

    public void setContactoDeAdvogado(String contactoDeAdvogado) {
        this.contactoDeAdvogado = contactoDeAdvogado;
    }

    public String getEmailAdvogado() {
        return emailAdvogado;
    }

    public void setEmailAdvogado(String emailAdvogado) {
        this.emailAdvogado = emailAdvogado;
    }

    public Advogado() {
    }

    public Advogado(String id_Advogado, String nomeDeAdvogado, String contactoDeAdvogado, String emailAdvogado) {
        this.id_Advogado = id_Advogado;
        this.nomeDeAdvogado = nomeDeAdvogado;
        this.contactoDeAdvogado = contactoDeAdvogado;
        this.emailAdvogado = emailAdvogado;
    }

    @Override
    public String toString() {
        return nomeDeAdvogado;
    }

}
