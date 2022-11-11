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
public class solturaDao {

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;

    public void tbrecluso_has_tbsoltura(Recluso add) {

        conexao = Conectar.conector();

        String querySq4 = "INSERT INTO `jail_ts2022`.`tbrecluso_has_tbsoltura` (`id_recluso`, `id_soltura`) VALUES ('?', '?');";
        try {
            stat = conexao.prepareStatement(querySq4);
            stat.setLong(1, Long.parseLong(add.getCodigo()));
            //    stat.setInt(2, Integer.parseInt(add.getCrime().get(i).getId_crimes()));
            stat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, " Relacinamento nao feito devido ao erro [ " + ex + " ]", " Notificação", JOptionPane.ERROR_MESSAGE);
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

}
