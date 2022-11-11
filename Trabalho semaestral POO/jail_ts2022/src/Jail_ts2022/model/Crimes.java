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
public class Crimes {

    private String id_crimes, categoriaDeCrime,duracaoEmAno,duracaoEmMeses;

    public Crimes(String id_crimes, String categoriaDeCrime, String duracaoEmAno, String duracaoEmMeses) {
        this.id_crimes = id_crimes;
        this.categoriaDeCrime = categoriaDeCrime;
        this.duracaoEmAno = duracaoEmAno;
        this.duracaoEmMeses = duracaoEmMeses;
    }

    public Crimes() {
    }

    @Override
    public String toString() {
        return  categoriaDeCrime;
    }

    public String getId_crimes() {
        return id_crimes;
    }

    public void setId_crimes(String id_crimes) {
        this.id_crimes = id_crimes;
    }

    public String getCategoriaDeCrime() {
        return categoriaDeCrime;
    }

    public void setCategoriaDeCrime(String categoriaDeCrime) {
        this.categoriaDeCrime = categoriaDeCrime;
    }

    public String getDuracaoEmAno() {
        return duracaoEmAno;
    }

    public void setDuracaoEmAno(String duracaoEmAno) {
        this.duracaoEmAno = duracaoEmAno;
    }

    public String getDuracaoEmMeses() {
        return duracaoEmMeses;
    }

    public void setDuracaoEmMeses(String duracaoEmMeses) {
        this.duracaoEmMeses = duracaoEmMeses;
    }

   
}
