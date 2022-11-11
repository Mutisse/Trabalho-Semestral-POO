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
import Jail_ts2022.model.Funcionario;

/**
 *
 * @author Klesia
 */
public class DirectorDao {

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;

    public void savarDirector(Funcionario add) {

        conexao = Conectar.conector();
        String querySql = "INSERT INTO `jail_ts2022`.`tbfuncionario` (`codigoDeFuncionario`, `apelido`, `nome`, `Genero`, `email`, `Senha`, `tbcategoria_id_categoria`,tbprovincias_id_Provincias) VALUES (?,?, ?, ?, ?, ?, ?, ?);";

        try {
            // autenticacao
            stat = conexao.prepareStatement(querySql);
            stat.setString(1, add.getCodigo());
            stat.setString(2, add.getApelido());
            stat.setString(3, add.getNome());
            stat.setString(4, add.getGenero());
            stat.setString(5, add.getEmail());
            stat.setString(6, add.getSenha());
            stat.setString(7, add.getNivelDeAcesso().getId_categoria());
            stat.setString(8, add.getProvincia().getId_provincias());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, " O Cadastrado do funcionário << " + add.getNome() + " " + add.getApelido() + " >> foi efectuado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, " Erro ao cadastrar o funcionário << " + add.getNome() + " " + add.getApelido() + " >> " + ex, " Notificação", JOptionPane.ERROR_MESSAGE);
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

    public int recuperrarIdCategoria() {

        conexao = Conectar.conector();
        // essa Query faz a selecao do mair valor na base de dados 
        String querySql = "select Max(id_categoria)from tbcategoria";
        int CriarCod = 0;
        try {
            stat = conexao.prepareStatement(querySql);
            rst = stat.executeQuery();

            if (rst != null && rst.next()) {
                CriarCod = rst.getInt(1);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " Erro do codigo", "Notificação", JOptionPane.ERROR_MESSAGE);

        } finally {
            try {
                stat.close();
                conexao.close();
            } catch (Exception e) {
                //       JOptionPane.showMessageDialog(null, e.getMessage() + " Erro na conexao", "Notificação", JOptionPane.ERROR);

            }

        }
        return CriarCod;
    }

    public int recuperrarIdCredencias() {

        conexao = Conectar.conector();
        // essa Query faz a selecao do mair valor na base de dados 
        String querySql = "select Max(id_auteticacao)from tbauteticacao";
        int CriarCod = 0;
        try {
            stat = conexao.prepareStatement(querySql);
            rst = stat.executeQuery();

            if (rst != null && rst.next()) {
                CriarCod = rst.getInt(1);
                CriarCod++;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " Erro do codigo", "Notificação", JOptionPane.ERROR_MESSAGE);

        } finally {
            try {
                stat.close();
                conexao.close();
            } catch (Exception e) {
                //       JOptionPane.showMessageDialog(null, e.getMessage() + " Erro na conexao", "Notificação", JOptionPane.ERROR);

            }

        }
        return CriarCod;
    }

}
