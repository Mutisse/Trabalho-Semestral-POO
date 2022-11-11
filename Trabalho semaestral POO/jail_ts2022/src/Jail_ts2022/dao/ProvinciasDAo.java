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
import Jail_ts2022.model.Nacionalidade;
import Jail_ts2022.model.Provincias;

/**
 *
 * @author Klesia
 */
public class ProvinciasDAo {

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Preenche a comboxs    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
    /**
     *
     * @return
     */
    public List<Provincias> ListaProvincias() {
        conexao = Conectar.conector();
        List<Provincias> Lista = new ArrayList<>();
        String querySql = "select * from tbprovincias  join  tbnacionalidade on tbprovincias.tbnacionalidade_id_nacionalidade  = tbnacionalidade.id_nacionalidade order by NomeDaProvincia;";

        try {
            stat = conexao.prepareStatement(querySql);
            ResultSet resultado = stat.executeQuery();

            while (resultado.next()) {
                Provincias addcb = new Provincias();
                addcb.setId_provincias(resultado.getString("id_Provincias"));
                addcb.setProvicias(resultado.getString("NomeDaProvincia"));
                Lista.add(addcb);
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

}
