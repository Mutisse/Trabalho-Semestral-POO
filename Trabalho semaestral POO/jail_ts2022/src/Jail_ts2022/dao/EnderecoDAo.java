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
import Jail_ts2022.model.Recluso;

/**
 *
 * @author Klesia
 */
public class EnderecoDAo {

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ENDRECO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void regitrarEndereco(Recluso salvar) {
        conexao = Conectar.conector();

        String querySq2 = "INSERT INTO `jail_ts2022`.`tbendereco` ( id_endereco,casa, rua, quarteirao, bairro,tbrecluso_id_recluso, tbprovincias_id_Provincias) VALUES ( ?,?, ?, ?, ?, ?, ?);";

        try {
// inicio de salvar  endereco
            stat = conexao.prepareStatement(querySq2);
            stat.setString(1, salvar.getId_registro());
            stat.setString(2, salvar.getEndereco().getCasa());
            stat.setString(3, salvar.getEndereco().getRua());
            stat.setString(4, salvar.getEndereco().getQuarteirao());
            stat.setString(5, salvar.getEndereco().getBairro());
            stat.setString(6, salvar.getId_registro());
            stat.setString(7, salvar.getEndereco().getProvincias().getId_provincias());
            stat.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
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

    // UPDATE 
    public void updateEndereco(Recluso add) {
        conexao = Conectar.conector();

        String querySq2 = "UPDATE `jail_ts2022`.`tbrecluso` SET `casa`=?, `rua`=?, `quarteirao`=?, `bairro`=?, `ID_Recluso`=?) VALUES (?,?,?, ?,?); ";

        try {
// inicio de salvar  endereco
            stat = conexao.prepareStatement(querySq2);
            stat.setString(1, add.getEndereco().getCasa());
            stat.setString(2, add.getEndereco().getRua());
            stat.setString(3, add.getEndereco().getQuarteirao());
            stat.setString(4, add.getEndereco().getBairro());
            //  stat.setString(5,add.getEndereco().getCodigo());
            stat.executeUpdate();
            System.out.println(" endeco salvo");
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

//    public int endrecoId() {
//
//        conexao = Conectar.conector();
//         essa Query faz a selecao do mair valor na base de dados 
//        String querySql = "select Max(id_endereco)from tbendereco";
//        int CriarCod = 0;
//        try {
//            stat = conexao.prepareStatement(querySql);
//            rst = stat.executeQuery();
//
//            if (rst != null && rst.next()) {
//                CriarCod = rst.getInt(1);
//                CriarCod++;
//
//            }
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage() + " Erro do codigo", "Notificação", JOptionPane.ERROR_MESSAGE);
//
//        } finally {
//            try {
//                stat.close();
//                conexao.close();
//            } catch (Exception e) {
//                       JOptionPane.showMessageDialog(null, e.getMessage() + " Erro na conexao", "Notificação", JOptionPane.ERROR);
//
//            }
//
//        }
//        return CriarCod;
//    }
}
