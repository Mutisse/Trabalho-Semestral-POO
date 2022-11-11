/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jail_ts2022.controller;

import java.time.YearMonth;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mutisse
 */
public class ControllerFuncionario {

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ validar email ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     vai validar o campos de email.
    */
    public boolean validarEmail(String email) {
        String emailRegular = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

        Pattern emailPatt = Pattern.compile(emailRegular, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPatt.matcher(email);

        return matcher.find();

    }
  /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ validar email ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    gera um codigo aleatorio para cada fiuncionario
    */
    public String SenhaFuncionario() {
        // parte da senha 
        Random random = new Random(); // onde e gerado os cod. de funcionario
        int codgo = random.nextInt(9000);
        while (codgo < 1000) {
            codgo = random.nextInt(9000);

        }// fim while
        return ("  " + codgo + "@" + YearMonth.now().getYear());
    }
 
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ validar email ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     faz a criptografia da senha 
    */
    public String Emcriptar(String str) {
        return new String(Base64.getEncoder().encode(str.getBytes()));
    }

    ; 
      /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ validar email ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     defaz a criptografia da senh.
    */
    public String DesEmcriptar(String str) {
        return new String(Base64.getDecoder().decode(str.getBytes()));
    }

   public boolean  vAlidarCampodeNomes(){
       
       return false;
   }

}
