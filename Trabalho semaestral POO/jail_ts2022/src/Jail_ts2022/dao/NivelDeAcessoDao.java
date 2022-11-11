/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jail_ts2022.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Jail_ts2022.conexao.Conectar;
import Jail_ts2022.model.NivelDeAcesso;
import Jail_ts2022.model.Celas;

/**
 *
 * @author Klesia
 */
public class NivelDeAcessoDao {
    
     Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;

     /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Preenche a comboxs    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
     public List<NivelDeAcesso> ListarNivelDeAcesso() {
        conexao = Conectar.conector();
        List<NivelDeAcesso> Lista = new ArrayList<>();
        String querySql = "select * from tbcategoria order by nivelDeAcesso ;";

        try {
            stat = conexao.prepareStatement(querySql);
            ResultSet resultado = stat.executeQuery();

            while (resultado.next()) {

                NivelDeAcesso addCb = new NivelDeAcesso();
                addCb.setId_categoria(resultado.getString("id_categoria"));
                addCb.setCategoria(resultado.getString("nivelDeAcesso"));
                Lista.add(addCb);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e + " Erro ao buscar o registro", "Notificação", JOptionPane.ERROR);
        } finally {
            try {
                stat.close();
                conexao.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "Erro na conexao");

            }
        }
        return Lista;
    }
    
         public void nivelDeAcesso(NivelDeAcesso add) {

        conexao = Conectar.conector();
        String querySql = "INSERT INTO `jail_ts2022`.`tbcategoria` (`categoria`) VALUES (?);";

        try {
            stat = conexao.prepareStatement(querySql);
            stat.setString(1, add.getCategoria());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                stat.close();
                conexao.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "Erro na conexao");

            }
        }
    }
  
}
