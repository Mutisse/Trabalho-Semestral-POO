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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Jail_ts2022.conexao.Conectar;
import Jail_ts2022.model.Crimes;
import Jail_ts2022.model.Recluso;

/**
 *
 * @author Klesia
 */
public class CrimesDAo {

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ RELACIONAMENTO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void tbrecluso_has_tbcrimes(Recluso add) {
         System.out.println(" id metodo " + add.getId_registro());
           
        for (int i = 0; i < add.getCrime().size(); i++) {

            System.out.println(" id ciclo  " + add.getId_registro());
            System.out.println(" crimes para gravar: " + add.getCrime().get(i).getId_crimes());

            conexao = Conectar.conector();
            String querySq4 = "INSERT INTO `jail_ts2022`.tbrecluso_has_tbcrimes (tbrecluso_id_recluso,tbcrimes_id_crimes) VALUES (?,?);";
            try {

                stat = conexao.prepareStatement(querySq4);
                stat.setString(1, add.getId_registro());
                stat.setString(2, add.getCrime().get(i).getId_crimes());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, " Relacinamento tbRecluso_has_tbCama_has_tbCrimes feito ", "Notificação", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, " Relacinamento tbRecluso_has_tbCama_has_tbCrimes  nao feito devido ao erro [ " + ex + " ]", " Notificação", JOptionPane.ERROR_MESSAGE);
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

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Preenche a comboxs    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
    public List<Crimes> ListaCrimes() {
        conexao = Conectar.conector();
        List<Crimes> Lista = new ArrayList<>();
        String querySql = "select * from tbcrimes;";

        try {
            stat = conexao.prepareStatement(querySql);
            ResultSet resultado = stat.executeQuery();

            while (resultado.next()) {

                Crimes AddcbCries = new Crimes();
                AddcbCries.setId_crimes(resultado.getString("id_crimes"));
                AddcbCries.setCategoriaDeCrime(resultado.getString("categoriaDeCrime"));
                AddcbCries.setDuracaoEmAno(resultado.getString("duracaoEmAno"));
                AddcbCries.setDuracaoEmMeses(resultado.getString("duracaoEmMeses"));
                Lista.add(AddcbCries);
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

    public List<Crimes> crimesPesq(String pesq) {
        conexao = Conectar.conector();
        List<Crimes> Lista = new ArrayList<>();
        String querySql = " select * from tbcrimes where categoriaDeCrime like?";

        try {

            stat = conexao.prepareStatement(querySql);
            stat.setString(1, "%" + pesq + "%");
            rst = stat.executeQuery();

            if (rst.next()) {
                Crimes AddcbCries = new Crimes();
                AddcbCries.setId_crimes(rst.getString("id_crimes"));
                AddcbCries.setCategoriaDeCrime(rst.getString("categoriaDeCrime"));
                AddcbCries.setDuracaoEmAno(rst.getString("duracaoEmAno"));
                AddcbCries.setDuracaoEmMeses(rst.getString("duracaoEmMeses"));
                Lista.add(AddcbCries);
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

}
