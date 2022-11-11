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
import Jail_ts2022.model.Advogado;
import Jail_ts2022.model.Celas;
import Jail_ts2022.model.Crimes;
import Jail_ts2022.model.Endereco;
import Jail_ts2022.model.Nacionalidade;
import Jail_ts2022.model.Provincias;
import Jail_ts2022.model.Recluso;

/**
 *
 * @author Mutisse
 */
public class ReclusoDao {

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;
    int id = 0;
    int idFRenquencia = 0;

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ RECLUSO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void saveRecluso(Recluso add) {

        conexao = Conectar.conector();
        String querySql = "INSERT INTO `jail_ts2022`.`tbrecluso` (`codigoDeRrcluso`, `nome`, `apelido`, `genero`, `datadeNascimento`, `nrbi`, `doenca`, `nivelAcademico`, `registroDeBens`, `caracterizar`, `estadoDePrisao`, `duracaoDapena`, `frequencia`,`tbcelas_id_celas`) VALUES (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?);";

        try {
            stat = conexao.prepareStatement(querySql);
            stat.setString(1, add.getCodigo());
            stat.setString(2, add.getNome());
            stat.setString(3, add.getApelido());
            stat.setString(4, add.getGenero());
            stat.setString(5, add.getDatadeNascimento());
            stat.setString(6, add.getNumeroDeBI());
            ///
            stat.setString(7, add.getDoenca());
            stat.setString(8, add.getNivelAcademico());
            stat.setString(9, add.getRegistroDeBens());
            stat.setString(10, add.getCaracterizarRecluso());
            //
            stat.setString(11, add.getEstadoDaPrisao());
            stat.setString(12, add.getDuracaoDapena());
            stat.setString(13, add.getFrequencia());
            //

            stat.setString(14, add.getCelas().getId_celas());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, " O Recluso << " + add.getNome() + " " + add.getApelido() + " >> foi Cadastrado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "O Recluso  << " + add.getNome() + " " + add.getApelido() + " \n  nao  registrado devido ao erro [ " + ex + " ]", " Notificação", JOptionPane.ERROR_MESSAGE);
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

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ATUALIZAR DADOS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void Update(Recluso add) {
        conexao = Conectar.conector();
        String querySql = "UPDATE `jail_ts2022`.`tbrecluso` SET `codigoDeRrcluso` = '?', `datadeNascimento` = '?', `frequencia` = '?', `dataDeregistro` = '?' WHERE (`id_recluso` = '?');";
        try {
            stat = conexao.prepareStatement(querySql);
            stat.setString(1, add.getApelido());
            stat.setString(2, add.getNome());
            stat.setString(3, add.getGenero());
            stat.setString(4, add.getDatadeNascimento());
            stat.setString(5, add.getNumeroDeBI());
            ///
            stat.setString(6, add.getEstadoCivil());
            stat.setString(7, add.getDoenca());
            stat.setString(8, add.getNivelAcademico());
            stat.setString(9, add.getRegistroDeBens());
            stat.setString(10, add.getEstado());
            //
//            stat.setDate(11, (Date) add.getDuracaoDapena());
            stat.setString(12, add.getCaracterizarRecluso());
            stat.setString(13, add.getFrequencia());
            stat.setString(14, add.getDataDeregistro());
            stat.setString(15, add.getCodigo());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Os Dados do Recluso  de  ID << " + add.getCodigo() + " \n " + add.getNome() + " " + add.getApelido() + " foram atualizados com sucesso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Os Dados do Recluso  de  ID << " + add.getCodigo() + " \n " + add.getNome() + " " + add.getApelido() + " \n Nao foram autalizados devido ao erro [ " + e + " ]", "Notificação", WARNING_MESSAGE);
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
    public void removeRecluso(Recluso delete) {
        conexao = Conectar.conector();
        int confirmar = JOptionPane.showConfirmDialog(null, " Tem a certeza que quer remover O funcionário ? " + delete.getApelido() + " " + delete.getNome(), "Notificação", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "UPDATE `jail_ts2022`.`tbrecluso` SET `StatusRecluso` = 'Removido' WHERE (`codigoDeRrcluso` = '?'); ";
            try {

                stat = conexao.prepareStatement(sql);
                stat.setString(1, delete.getCodigo());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, " O  funcionário << " + delete.getNome() + " " + delete.getApelido() + " >> foi Removido !!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
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

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ remocao de funcionario ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void soltarRecluso(Recluso soltar) {
        conexao = Conectar.conector();
        int confirmar = JOptionPane.showConfirmDialog(null, " Tem a certeza que quer Soltar O Reclusao? " + soltar.getApelido() + " " + soltar.getNome(), "Notificação", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "update tbrecluso set  StatusRecluso ='Solto' where codigoDeRrcluso=?";
            try {

                stat = conexao.prepareStatement(sql);
                stat.setString(1, soltar.getCodigo());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, " O  Rescuso << " + soltar.getNome() + " " + soltar.getApelido() + " >> foi Solto !!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
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

    public long GerarCodigo() {

        conexao = Conectar.conector();
        // essa Query faz a selecao do mair valor na base de dados 
        String querySql = "select Max(id_recluso) from tbrecluso";
        long CriarCod = 0;
        try {
            stat = conexao.prepareStatement(querySql);
            rst = stat.executeQuery();

            if (rst != null && rst.next()) {

                CriarCod = rst.getLong(1);

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

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ remocao de funcionario ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void reativarRecluso(int frquencia, int id_registro) {
        conexao = Conectar.conector();
        String sql = "update tbrecluso set  StatusRecluso ='Activo',frequencia=? where id_recluso=?";
        try {

            stat = conexao.prepareStatement(sql);
            stat.setInt(1, frquencia);
            stat.setInt(2, id_registro);
            stat.executeUpdate();

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

    }

    public boolean verificarAfrequeciasDeRcluso(String bi, String nome, String apelido) {

        conexao = Conectar.conector();
        // essa Query faz a selecao do mair valor na base de dados 
        String querySql = "select  (nrbi  = ? and nome = ? and apelido =?) from tbrecluso where StatusRecluso ='Solto' or StatusRecluso ='Foragido';";

        try {

            stat = conexao.prepareStatement(querySql);
            stat.setString(1, bi);
            stat.setString(2, nome);
            stat.setString(3, apelido);
            rst = stat.executeQuery();

            if (rst.next()) {

                id = rst.getInt(1);
               // idFRenquencia = rst.getInt(2);

                idFRenquencia++;
                System.out.println(" frencia: " + id);
                return true;

            }

            reativarRecluso(idFRenquencia, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " Erro do codigo");

        } finally {
            try {
                stat.close();
                conexao.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " Erro na conexao", "Notificação", JOptionPane.ERROR);

            }

        }

        return false;
    }

    public List<Recluso> listarTodosReclusos() {
        conexao = Conectar.conector();
        List<Recluso> Lista = new ArrayList<>();
        String querySql = "SELECT id_recluso,codigoDeRrcluso, nome, apelido,genero,datadeNascimento, StatusRecluso,estadoDePrisao,duracaoDapena, frequencia,nrcama,id_celas,NomeDacela,capacidadeMax,NomeDaProvincia,nomeDoPais from tbrecluso  LEFT JOIN tbrecluso_has_tbcrimes on tbrecluso.id_recluso=tbrecluso_has_tbcrimes.tbrecluso_id_recluso LEFT JOIN tbcrimes  on tbcrimes.id_crimes= tbrecluso_has_tbcrimes.tbcrimes_id_crimes LEFT join tbendereco on tbendereco.tbrecluso_id_recluso=tbrecluso.id_recluso LEFT join tbprovincias ON tbendereco.tbprovincias_id_Provincias = tbprovincias.id_Provincias LEFT JOIN tbnacionalidade on tbnacionalidade.id_nacionalidade= tbprovincias.tbnacionalidade_id_nacionalidade LEFT JOIN tbcelas on tbcelas.id_celas=tbrecluso.tbcelas_id_celas WHERE StatusRecluso != 'Removido' ORDER BY tbrecluso.nome;";
        String query2 = "SELECT tbrecluso_id_recluso, tbcrimes_id_crimes, categoriaDeCrime FROM `tbrecluso_has_tbcrimes` inner join tbcrimes on tbrecluso_has_tbcrimes.tbcrimes_id_crimes = tbcrimes.id_crimes WHERE tbrecluso_id_recluso=?";
        //
        try {
            stat = conexao.prepareStatement(querySql);
            rst = stat.executeQuery();

            while (rst.next()) {

                Recluso recluso = new Recluso();
                Celas cela = new Celas();
                Crimes crime = new Crimes();
                Endereco endereco = new Endereco();
                Advogado advogado = new Advogado();
                Provincias provincia = new Provincias();
                Nacionalidade pais = new Nacionalidade();
                recluso.setId_registro(rst.getString("id_recluso"));
                recluso.setCodigo(rst.getString("codigoDeRrcluso"));
                recluso.setNome(rst.getString("nome"));
                recluso.setApelido(rst.getString("apelido"));
                recluso.setGenero(rst.getString("genero"));
                recluso.setEstadoDaPrisao(rst.getString("estadoDePrisao"));
                recluso.setDuracaoDapena(rst.getString("duracaodapena"));
                recluso.setFrequencia(rst.getString("frequencia"));
                recluso.setEstado(rst.getString("StatusRecluso"));
                recluso.setDatadeNascimento(rst.getString("datadeNascimento"));
                // cela
                cela.setCela(rst.getString("NomeDacela"));
                recluso.setCelas(cela);
                cela.setCapacitMax(rst.getString("capacidadeMax"));
                recluso.setCelas(cela);
                cela.setId_celas(rst.getString("id_celas"));
                recluso.setCelas(cela);
                cela.setNrcama(rst.getString("nrcama"));
                recluso.setCelas(cela);
                // naionalidade
                pais.setNacionalidade(rst.getString("nomeDoPais"));
                provincia.setNacionalidade(pais);
                // provincia 
                provincia.setProvicias(rst.getString("NomeDaProvincia"));
                endereco.setProvincias(provincia);
                endereco.setProvincias(provincia);
                recluso.setEndereco(endereco);
                recluso.setEndereco(endereco);
                // recuperar crimes.
                PreparedStatement st = conexao.prepareStatement(query2);
                st.setString(1, recluso.getId_registro());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    crime.setId_crimes(rs.getString("tbcrimes_id_crimes"));
                    crime.setCategoriaDeCrime(rs.getString("categoriaDeCrime"));
                    recluso.getCrime().add(crime);
                }
                st.close();
                rs.close();
//                recluso.getCrime(crime);
//                advogado.setNomeDeAdvogado(rst.getString(" nomeDeAdvogado"));
//                recluso.setAdvogado(advogado);
                Lista.add(recluso);
            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
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

    public int reclusoId() {

        conexao = Conectar.conector();
        // essa Query faz a selecao do mair valor na base de dados 
        String querySql = "select Max(id_recluso)from tbrecluso";
        int CriarCod = 0;
        try {
            stat = conexao.prepareStatement(querySql);
            rst = stat.executeQuery();

            if (rst != null && rst.next()) {
                CriarCod = rst.getInt(1);

                CriarCod++;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " Erro do codigo", "Notificação", JOptionPane.ERROR_MESSAGE);

        } finally {
            try {
                stat.close();
                conexao.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " Erro na conexao", "Notificação", JOptionPane.ERROR);

            }
            //                //emdreco
//                endereco.setBairro(rst.getString("id_endereco"));
//                recluso.setEndereco(endereco);
//                endereco.setRua(rst.getString("rua"));
//                recluso.setEndereco(endereco);
//                endereco.setRua(rst.getString("bairro"));
//                recluso.setEndereco(endereco);
//                endereco.setCasa(rst.getString("casa"));
//                recluso.setEndereco(endereco);
//                endereco.setQuarteirao(rst.getString("quarteirao"));
//                recluso.setEndereco(endereco);

        }
        return CriarCod;
    }

}
