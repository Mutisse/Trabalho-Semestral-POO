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
import Jail_ts2022.model.Celas;
import Jail_ts2022.model.Recluso;

/**
 *
 * @author Klesia
 */
public class CelasDao {

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;
    int novaCapacidade;
    String novoStatus, estadoDacama;

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  cbCelas    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
    public void ocuparAcela(Recluso add) {

        conexao = Conectar.conector();
        String querySql = "UPDATE `jail_ts2022`.`tbcelas` SET capacidadeMax = ?, estadoDaCela = ?, nrcama = ?, estadoDacama = ? WHERE (id_celas =?);";

        try {

            novaCapacidade = Integer.valueOf(add.getCelas().getCapacitMax());
            --novaCapacidade;
            estadoDacama = "Ocupada";

            if (novaCapacidade <= 0) {
                novoStatus = "Indisponivel";
            } else {
                novoStatus = "Disponivel";
            }

            //
            stat = conexao.prepareStatement(querySql);
            stat.setInt(1, novaCapacidade);
            stat.setString(2, novoStatus);
            stat.setInt(3, novaCapacidade);
            stat.setString(4, estadoDacama);
            stat.setString(5, add.getCelas().getId_celas());
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "O recluso ja pertencer a uma cela!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
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

//    public void UdpdatcbCelas(Definicoes add) {
//
//        conexao = Conectar.conector();
//        String querySql = "UPDATE  tbdefinicoes SET cbCelas WHERE Idf =?";
//
//        try {
//            stat = conexao.prepareStatement(querySql);
//            stat.setString(1, add.getCbCelas());
//            stat.setString(1, add.getId());
//            stat.executeUpdate();
//            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            try {
//                stat.close();
//                conexao.close();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
//
//            }
//        }
//    }

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Preenche a comboxs    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
    public List<Celas> ListarCelas() {
        conexao = Conectar.conector();
        List<Celas> Lista = new ArrayList<>();
        String querySql = " select * from  tbcelas where estadoDaCela='Disponivel' order by NomeDacela ; ";

        try {
            stat = conexao.prepareStatement(querySql);
            ResultSet resultado = stat.executeQuery();

            while (resultado.next()) {

                Celas AddcbCelas = new Celas();
                AddcbCelas.setId_celas(resultado.getString("id_celas"));
                AddcbCelas.setCela(resultado.getString("NomeDacela"));
                AddcbCelas.setCapacitMax(resultado.getString("capacidadeMax"));
                AddcbCelas.setNrcama(resultado.getString("nrcama"));
                AddcbCelas.setEstadoDaCela(resultado.getString("estadoDaCela"));

                Lista.add(AddcbCelas);
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

//    public int capaciadedMax(int capacit) {
//        int CriarCod = 0;
//        try {
//            conexao = Conectar.conector();
//            // essa Query faz a selecao do mair valor na base de dados 
//            String querySql = "select * from  tbcelas where capacidadeMax !=0;";
//            stat = conexao.prepareStatement(querySql);
//            stat.setInt(1, capacit);
//            rst = stat.executeQuery();
//
//            if (rst.next()) {
//                CriarCod = rst.getInt(3);
//                // CriarCod++;
//                System.out.println("campacidade max"+CriarCod);
//
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage() + " Erro do codigo", "Notificação", JOptionPane.ERROR_MESSAGE);
//
//        } finally {
//            try {
//                stat.close();
//                conexao.close();
//            } catch (Exception e) {
//
//            }
//
//        }
//        return CriarCod;
//    }
}
