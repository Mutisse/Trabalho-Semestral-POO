/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jail_ts2022.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Jail_ts2022.conexao.Conectar;
import Jail_ts2022.model.Advogado;
import Jail_ts2022.model.Recluso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Klesia
 */
public class AdvogadoDao {

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ADVOGADO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void regitrarAdvogado(Recluso add) {
        conexao = Conectar.conector();

        String querySq3 = "INSERT INTO `jail_ts2022`.`tbadvogados` (nomeDeAdvogado,contactoDeAdvogado,emailAdvogado) VALUES (?,?,?,?);";
        try {
            /// inicio de salvar advogado
            stat = conexao.prepareStatement(querySq3);
            stat.setString(1, add.getAdvogado().getNomeDeAdvogado());
            stat.setString(2, add.getAdvogado().getContactoDeAdvogado());
            stat.setString(3, add.getAdvogado().getEmailAdvogado());
            stat.executeUpdate();
            System.out.println("registrado");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, " Os dados de advogado noa foram registrados devido ao err [" + ex + "]", " Notificação", JOptionPane.ERROR_MESSAGE);
        } finally {

            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão " + e);

            }

        }
    }
    // update

    public void tbrecluso_has_tbadvogados(Recluso add) {
        conexao = Conectar.conector();

        String querySq2 = "INSERT INTO `jail_ts2022`.`tbrecluso_has_tbadvogados` (id_recluso,id_advogados) VALUES (?,?);";

        try {
// inicio de salvar  endereco
            stat = conexao.prepareStatement(querySq2);
            stat.setString(1, add.getId_registro());
            stat.setString(2, add.getAdvogado().getId_Advogado());
            stat.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, " endereco nao registrado devido ao erro [ " + ex + " ]", " Notificação", JOptionPane.ERROR_MESSAGE);
        } finally {

            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão " + e);

            }

        }
    }

    public List<Advogado> listarAdvogado() {
        conexao = Conectar.conector();
        List<Advogado> Lista = new ArrayList<>();
        String querySql = "select * from tbadvogados a left outer join tbrecluso_has_tbadvogados rela  on  a.id_advogados=rela.id_advogados order by nomeDeAdvogado ;";

        try {
            stat = conexao.prepareStatement(querySql);
            ResultSet resultado = stat.executeQuery();

            while (resultado.next()) {

                Advogado addCamas = new Advogado();
                addCamas.setId_Advogado(resultado.getString("id_advogados"));
                addCamas.setNomeDeAdvogado(resultado.getString("nomeDeAdvogado"));
                addCamas.setEmailAdvogado(resultado.getString("emailAdvogado"));
                addCamas.setContactoDeAdvogado(resultado.getString("contactoDeAdvogado"));
                Lista.add(addCamas);
            }

        } catch (Exception e) {
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

    //    public void updateAdvogado(Recluso add) {
//        conexao = Conectar.conector();
//
//        String querySq3 = "UPDATE `jail_ts2022`.`tbadvogados` SET `id_advogados` = '1', `nomeDeAdvogado` = '?', `contactoDeAdvogado` = '?', `emailAdvogado` = '?', `id_Recluso` = '?' WHERE (`id_advogados` = '?');";
//        try {
//            /// inicio de salvar advogado
//            stat = conexao.prepareStatement(querySq3);
//            stat.setString(1, add.getNomeDeAdvogado());
//            stat.setString(2, add.getContactoDeAdvogado());
//            stat.setString(3, add.getEmail());
//            stat.setString(4, add.getCodigo());
//            stat.executeUpdate();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, " Os dados de advogado noa foram registrados devido ao err [" + ex + "]", " Notificação", JOptionPane.ERROR_MESSAGE);
//        } finally {
//
//            try {
//                if (conexao != null) {
//                    conexao.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Erro ao fechar conexão " + e);
//
//            }
//
//        }
//    }
}
