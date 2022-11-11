/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Jail_ts2022.views;

import Jail_ts2022.model.Recluso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mutisse
 */
public final class TelaInicial extends javax.swing.JInternalFrame {

    DefaultListModel newModel = new DefaultListModel();

    /**
     * Creates new form NewJInternalFrame
     */
    public TelaInicial() {
        initComponents();
        jList_superLotacao.setVisible(false);
        verificarDuracaoDaPena();
        jList_superLotacao.setModel(newModel);
        limparAlista();
    }


    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    void limparAlista() {
        if (jList_superLotacao.getModel().getSize() > 0) {
            jLabel5.setVisible(false);
            jList_superLotacao.setVisible(true);
            JOptionPane.showMessageDialog(null, "Foi preenchida uma lista de reclusos que ja tem a sua pena \n cumprida ou preste a ser cumprir. \n por favor verifique a area de soltura.", "Notificação", JOptionPane.WARNING_MESSAGE);
        } else {
            jLabel5.setVisible(true);
            jList_superLotacao.setVisible(false);
        }

    }

    public long controleDeDiasDaPana(String validade) {

        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        long diferencaDias = 0;

        try {
            Date valida = formatador.parse(validade);
            Date dataSistema = formatador.parse((formatador.format(data)));
            long total = Math.abs(dataSistema.getTime() - valida.getTime());
            diferencaDias = TimeUnit.DAYS.convert(total, TimeUnit.MILLISECONDS);

        } catch (ParseException e) {

            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        return diferencaDias;

    }

    public void verificarDuracaoDaPena() {

        try {
            ArrayList<Recluso> recluso = ListarTodosReclusos();

            for (Recluso deteno : recluso) {
                if (deteno.getEstado().equalsIgnoreCase("Activo")) {

                    try {
                        if (controleDeDiasDaPana(deteno.getDuracaoDapena()) == 60) {
                            jList_superLotacao.setVisible(true);
                          newModel.addElement(deteno.getNome() + " " + deteno.getApelido());
                        } else if (controleDeDiasDaPana(deteno.getDuracaoDapena()) == 30) {
                            jList_superLotacao.setVisible(true);
                            newModel.addElement(deteno.getNome() + " " + deteno.getApelido());
                        } else if (controleDeDiasDaPana(deteno.getDuracaoDapena()) == 7) {
                            jList_superLotacao.setVisible(true);
                            newModel.addElement(deteno.getNome() + " " + deteno.getApelido());
                        } else if (controleDeDiasDaPana(deteno.getDuracaoDapena()) == 0) {
                            jList_superLotacao.setVisible(true);
                            newModel.addElement(deteno.getNome() + " " + deteno.getApelido());
                        }
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_superLotacao = new javax.swing.JList<>();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(null);

        jScrollPane2.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setEnabled(false);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(1);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextArea2.setRows(7);
        jTextArea2.setTabSize(7);
        jTextArea2.setText("\n       Em moçambique tem se registrado problemas de superlotação nas penitenciárias, isso se devem\n por um fraco controlo dos reclusos.\n Muitos deles têm ficado lá durante muito tempo nas celas esperando o julgamento,ou com a sua\n pena já cumprida e isso faz com que as cadeias do nosso país fiquem superlotadas.\n\n      Esse software tem como objectivo ajudar na regularização dos reclusos visto que se regista \n superlotação de cadeias principalmente na província e cidade de Maputo, um exemplo claro é a\n cadeia central em Maputo, onde existem muitos reclusos que dormem em corredores por falta de \n espaço.\n\n O sistema consiste em um mecanismo de gestão e controle do preenchimento de estabelecimentos \n penitenciários, nesse âmbito, com a implementação desse sistema as penitenciárias terão controlo \n da capacidade de alojamento dos seus reclusos e terá mais controle no cumprimento de penas dos\n reclusos, uma vez que têm-se ouvido muitas reclamações de reclusos que ficam muito mais tempo\n encarcerados do que o da sua pena de condenação.\n\n “Todo cidadão tem direito à vida e à integridade física e moral e não pode ser \n sujeito à tortura ou tratamentos cruéis ou desumanos”. \n (MOÇAMBIQUE, 2004, art. 40)\n\n\n");
        jTextArea2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextArea2.setEnabled(false);
        jTextArea2.setMargin(new java.awt.Insets(3, 10, 2, 2));
        jTextArea2.setPreferredSize(new java.awt.Dimension(805, 480));
        jScrollPane2.setViewportView(jTextArea2);
        jTextArea2.getAccessibleContext().setAccessibleParent(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 200, 830, 400);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/prisoner_.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(880, 180, 170, 150);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sistema Penitenciária");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 70, 430, 70);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/criminal-pointing-a-gun-to-a-victim-on-the-floor.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(710, 40, 130, 140);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/criminal-posing-for-police-picture.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(870, 350, 190, 220);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/violent-criminal.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 40, 130, 140);

        jScrollPane1.setViewportView(jList_superLotacao);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(870, 350, 190, 240);

        setBounds(0, 0, 1072, 640);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        ///   try {

//            jDesktopPane1.remove(tdescricao);
//            jDesktopPane1.add(tdescricao);
//////            tdescricao.setVisible(true);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro! Esta  tela já esta em execução", "Notificação", JOptionPane.WARNING_MESSAGE);
//        }

    }//GEN-LAST:event_jLabel5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList_superLotacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Recluso> ListarTodosReclusos() {

        return new Recluso().listar();

    }

}