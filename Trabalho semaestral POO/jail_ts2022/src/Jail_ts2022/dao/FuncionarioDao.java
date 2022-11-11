
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
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import Jail_ts2022.conexao.Conectar;
import Jail_ts2022.model.NivelDeAcesso;
import Jail_ts2022.model.Funcionario;

/**
 *
 * @author Mutisse
 */
public class FuncionarioDao {

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Salvar dados de funcionario ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void saveFuncionario(Funcionario add) {

        conexao = Conectar.conector();
        String querySql = "INSERT INTO `jail_ts2022`.`tbfuncionario` (codigoDeFuncionario, apelido, nome,Genero,datadeNascimento,nrbi,nuit,Contcto,email,Senha,tbcategoria_id_categoria,tbprovincias_id_Provincias) VALUES (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?,?)";

        try {

            stat = conexao.prepareStatement(querySql);
            stat.setString(1, add.getCodigo());
            stat.setString(2, add.getApelido());
            stat.setString(3, add.getNome());
            stat.setString(4, add.getGenero());
            stat.setString(5, add.getDatadeNascimento());
            //
            stat.setString(6, add.getNumeroDeBI());
            stat.setString(7, add.getNuit());
            stat.setString(8, add.getContacto());
            stat.setString(9, add.getEmail());
            stat.setString(10, add.getSenha());
            //
            stat.setString(11, add.getNivelDeAcesso().getId_categoria());
            stat.setString(12, add.getProvincia().getId_provincias());
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, " O Cadastrado do funcionário << " + add.getNome() + " " + add.getApelido() + " >> foi efectuado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
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

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ atualiza os dados  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void Update(Funcionario add) {
        conexao = Conectar.conector();
        String querySql = "UPDATE `jail_ts2022`.`tbfuncionario` SET  apelido = ?,nome = ?, Genero = ?, datadeNascimento = ?,nrbi = ?, nuit = ?, Contcto = ?, email = ?, Senha = ?, tbcategoria_id_categoria = ?,tbprovincias_id_Provincias=? WHERE (codigoDeFuncionario = ?);";

        try {
            // autenticacao
            stat = conexao.prepareStatement(querySql);
            stat.setString(1, add.getApelido());
            stat.setString(2, add.getNome());
            stat.setString(3, add.getGenero());
            stat.setString(4, add.getDatadeNascimento());
            //
            stat.setString(5, add.getNumeroDeBI());
            stat.setString(6, add.getNuit());
            stat.setString(7, add.getContacto());
            stat.setString(8, add.getEmail());
            stat.setString(9, add.getSenha());
            //
            stat.setString(10, add.getNivelDeAcesso().getId_categoria());
            stat.setString(11, add.getProvincia().getId_provincias());
            stat.setString(12, add.getCodigo());
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, " Os dados do funcionário  << " + add.getNome() + " " + add.getApelido() + "  >>  com o Id << " + add.getCodigo() + " >> foram atualizados com sucesso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " Erro ao atualizar", "Notificação", WARNING_MESSAGE);
        } finally {
            try {
                stat.close();
                conexao.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "Erro na conexao");

            }
        }
    }


    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ remocao de funcionario ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void removerFuncionario(Funcionario delete) {
        conexao = Conectar.conector();
        int confirmar = JOptionPane.showConfirmDialog(null, " Tem a certeza que quer remover O funcionário ? de codigo " + delete.getCodigo(), "Notificação", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "UPDATE `jail_ts2022`.`tbfuncionario` SET Statuss = 'Removido' WHERE (codigoDeFuncionario = ?);";
            try {

                stat = conexao.prepareStatement(sql);
                stat.setString(1, delete.getCodigo());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, " O  funcionário foi Removido !!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + " Erro ao remover", "Notificação", JOptionPane.ERROR);
            } finally {
                try {
                    stat.close();
                    conexao.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e + "Erro na conexao");

                }
            }

        } else {
            JOptionPane.showInternalMessageDialog(null, " Operacao cancelada!!");

        }
    }


    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ativar funcionario ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void readmitirFuncionario(Funcionario id) {
        conexao = Conectar.conector();
        String querySql = "UPDATE `jail_ts2022`.`tbfuncionario` SET Statuss = 'Activo' WHERE (codigoDeFuncionario = ?);";

        try {
            stat = conexao.prepareStatement(querySql);
            stat.setString(1, id.getCodigo());

            int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Readmitir este Funcionário?", "Confirmação!", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                int c = stat.executeUpdate();
                if (c > 0) {
                    JOptionPane.showMessageDialog(null, "Funcionario Readmitido!");
                }
                conexao.close();

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "erro ao Readmitir funcionario " + ex);

        }

    }

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ativar funcionario ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void demitirFuncionario(Funcionario id) {
        conexao = Conectar.conector();
        String querySql = "UPDATE `jail_ts2022`.`tbfuncionario` SET Statuss = 'Inativo' WHERE (codigoDeFuncionario = ?);";

        try {
            stat = conexao.prepareStatement(querySql);
            stat.setString(1, id.getCodigo());

            int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Readmitir este Funcionário?", "Confirmação!", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                int c = stat.executeUpdate();
                if (c > 0) {
                    JOptionPane.showMessageDialog(null, "Funcionario demitido!");
                }
                conexao.close();

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "erro ao Readmitir funcionario " + ex);

        }

    }

    public long gerarCodigo() {

        conexao = Conectar.conector();
        // essa Query faz a selecao do mair valor na base de dados 
        String querySql = "select Max(codigoDeFuncionario)from tbfuncionario";
        long CriarCod = 0;
        try {
            stat = conexao.prepareStatement(querySql);
            rst = stat.executeQuery();

            if (rst != null && rst.next()) {
                CriarCod = rst.getLong(1);
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

    public void RecuperarSenha(Funcionario add) {

        conexao = Conectar.conector();
        String querySql = "UPDATE `jail_ts2022`.`tbfuncionario` SET `Senha` = ? WHERE (`id_funcionario` = ?)";

        try {
            stat = conexao.prepareStatement(querySql);
            stat.setString(1, add.getSenha());
            stat.setString(2, add.getCodigo());
            stat.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, " Não foi possível actualizar a sua senha ", " Notificação", JOptionPane.ERROR_MESSAGE);
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

    public List<Funcionario> ListarTodos() {
        conexao = Conectar.conector();
        List<Funcionario> Lista = new ArrayList<>();
        String querySql = "select * from tbfuncionario inner join tbcategoria  on tbfuncionario.tbcategoria_id_categoria = tbcategoria.id_categoria  and Statuss != 'removido' order by nome;";

        try {
            stat = conexao.prepareStatement(querySql);
            ResultSet resultado = stat.executeQuery();

            while (resultado.next()) {

                Funcionario Usuario = new Funcionario();
                NivelDeAcesso categoria = new NivelDeAcesso();
                Usuario.setId_registroFuncionario(resultado.getString("id_funcionario"));
                Usuario.setCodigo(resultado.getString("codigoDeFuncionario"));
                Usuario.setNome(resultado.getString("Nome"));
                Usuario.setApelido(resultado.getString("Apelido"));
                Usuario.setGenero(resultado.getString("Genero"));
                Usuario.setNumeroDeBI(resultado.getString("nrbi"));
                Usuario.setNuit(resultado.getString("nuit"));
                Usuario.setDatadeNascimento(resultado.getString("datadeNascimento"));
                Usuario.setContacto(resultado.getString("Contcto"));
                categoria.setCategoria(resultado.getString("nivelDeAcesso"));
                Usuario.setNivelDeAcesso(categoria);
                Usuario.setEmail(resultado.getString("email"));
                Usuario.setEstado(resultado.getString("Statuss"));
                Usuario.setSenha(resultado.getString("Senha"));
                Lista.add(Usuario);
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

}
