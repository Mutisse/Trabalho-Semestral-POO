package Jail_ts2022.controller;

import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EnvioDeEmail {

    public boolean isConfimacao() {
        return confimacao;
    }

    public void setConfimacao(boolean confimacao) {
        this.confimacao = confimacao;
    }

    boolean confimacao;

    public void enviarCodigoDeConfirmacao(String emailUsuario, int codigoDeRecuperacao) {

        System.out.println(" RECUPERAÇÃO DE CONTA ");
        System.out.println(" Codigo de Confirmação: \n " + codigoDeRecuperacao);
      
//        
//        String meuEmail = "immutisse@gmail.com";
//        String senha = "zrfvxfhfktdgvhfz";
//
//        SimpleEmail email = new SimpleEmail();  // email o a qual  pretentedemos envia a msg
//        email.setHostName("smtp.gmail.com");//cofigurando o host do google 
//        email.setSmtpPort(465); //configurando a porta
//        email.setAuthenticator(new DefaultAuthenticator(meuEmail, senha));
//        email.setSSLOnConnect(true);//ativa a conexao de forma segura atraves do protocolo SSLO
//
//        try {
//            email.setFrom(meuEmail); //olocar uma varivcel que tera como parametro o email digitado.
//            email.setSubject("RECUPERAÇÃO DE CONTA ");
//
//            email.setMsg("Codigo de Confirmação: \n " + codigoDeRecuperacao);
//            email.addTo(emailUsuario);//o email destinatario 
//            email.send();// intrucao para enviar o email de facto...
//            JOptionPane.showMessageDialog(null, " O código de confirmação foi enviado no e-mail ", "Atenção", JOptionPane.INFORMATION_MESSAGE);
//            confimacao = true;
//        } catch (org.apache.commons.mail.EmailException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, " Falha na conexão com a internet  ", "Atenção", JOptionPane.INFORMATION_MESSAGE);
//            confimacao = false;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        
    }

    public void enviarAutenticaca(String emailUsuario, String Password) {

        String meuEmail = "immutisse@gmail.com";
        String senha = "zrfvxfhfktdgvhfz";

        SimpleEmail email = new SimpleEmail();  // email o a qual  pretentedemos envia a msg
        email.setHostName("smtp.gmail.com");//cofigurando o host do google 
        email.setSmtpPort(465); //configurando a porta
        email.setAuthenticator(new DefaultAuthenticator(meuEmail, senha));
        email.setSSLOnConnect(true);//ativa a conexao de forma segura atraves do protocolo SSLO

        try {
            email.setFrom(meuEmail); //olocar uma varivcel que tera como parametro o email digitado.
            email.setSubject("Autenticação de usuario");

            email.setMsg("username: " + emailUsuario + "\n A Senha: " + Password);
            email.addTo(emailUsuario);//o email destinatario 
            email.send();// intrucao para enviar o email de facto...
            JOptionPane.showMessageDialog(null, " Autenticação de usuario foi enviado no e-mail ", "Atenção", JOptionPane.INFORMATION_MESSAGE);

        } catch (org.apache.commons.mail.EmailException ex) {

            JOptionPane.showMessageDialog(null, " Falha na conexão com a internet  ", "Atenção", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            //System.out.println(e);
        }

    }

}
