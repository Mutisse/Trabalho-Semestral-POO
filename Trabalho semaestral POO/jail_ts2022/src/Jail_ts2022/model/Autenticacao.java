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
public class Autenticacao {

    private String  email, Senha;

    public Autenticacao(String email, String Senha) {
        this.email = email;
        this.Senha = Senha;
    }

    public Autenticacao() {
    }

    @Override
    public String toString() {
        return "Autenticacao{" + "email=" + email + ", Senha=" + Senha + '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

   

}
