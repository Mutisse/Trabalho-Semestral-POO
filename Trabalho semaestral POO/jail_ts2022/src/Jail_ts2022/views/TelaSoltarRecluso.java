/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Jail_ts2022.views;

import Jail_ts2022.conexao.Conectar;
import Jail_ts2022.dao.ReclusoDao;
import Jail_ts2022.model.Recluso;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mutisse
 */
public final class TelaSoltarRecluso extends javax.swing.JInternalFrame {

    int enter = 0;
    String[] index = new String[5];

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;
    DefaultListModel modelo = new DefaultListModel();

    /**
     * Creates new form FuncionarioDados
     */
    public TelaSoltarRecluso() {
        initComponents();

        listPesquisa.setModel(modelo);
        listPesquisa.setVisible(false);
        btn_soltar.setEnabled(false);

        verificarValidade();
    }

    public long controleDeValidade(String validade) {

        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date valida = formatador.parse(validade);
            Date dataSistema = formatador.parse((formatador.format(data)));
            total = Math.abs(dataSistema.getTime() - valida.getTime());
            diferencaDias = TimeUnit.DAYS.convert(total, TimeUnit.MILLISECONDS);

        } catch (ParseException e) {

            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        return diferencaDias;

    }

    public void verificarValidade() {
        ArrayList<Recluso> recluso = ListarTodosReclusos();

        DefaultTableModel newModelTable = (DefaultTableModel) jT_soltura.getModel();
        newModelTable.setRowCount(0);

        for (Recluso detento : recluso) {

            try {
                if (controleDeValidade(detento.getDuracaoDapena()) <= 60) {
                    // JOptionPane.showMessageDialog(null, " O recluso ` " + detento.getNome() + " `\n A sua  pena sera cunprida em 60 Dias!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    newModelTable.addRow(new Object[]{detento.getCodigo(), detento.getNome() + " " + detento.getApelido(),
                        detento.getGenero(), detento.getDatadeNascimento(), detento.getEndereco().getProvincias().getNacionalidade(), detento.getDuracaoDapena(),
                        detento.getFrequencia(), detento.getCelas().getCela(), detento.getCelas().getNrcama(), detento.getRegistroDeBens(), detento.getEstado()
                    });
                    //,detento.getAdvogado().getNomeDeAdvogado()

                } else if (controleDeValidade(detento.getDuracaoDapena()) <= 30) {
                    JOptionPane.showMessageDialog(null, " O recluso ` " + detento.getNome() + " `\n A sua  pena sera cunprida em  30 dias!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                } else if (controleDeValidade(detento.getDuracaoDapena()) <= 7) {
                    JOptionPane.showMessageDialog(null, " O recluso ` " + detento.getNome() + " `\n A sua  pena sera cunprida em  7 dias!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                } else if (controleDeValidade(detento.getDuracaoDapena()) <= 0) {
                    JOptionPane.showMessageDialog(null, " O recluso ` " + detento.getNome() + " `\n  Ja cumpriu a sua pena, e nao podem estar mais na peniteciaria!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {

            }
        }
    }


    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Setar campos    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   esse metodo vai prencher os campos  de formulario funcionario com falaores perenchidos na tabela 
     */
    void listarPesquisa() {

        try {
            conexao = Conectar.conector();
            String querySql = "select * from tbrecluso where nome like? order by nome;";

            stat = conexao.prepareStatement(querySql);
            stat.setString(1, txt_pesquisar.getText() + "%");
            rst = stat.executeQuery();
            int i = 0;

            if (rst.next() & i < 5) {

                modelo.addElement(rst.getString("nome") + " " + rst.getString("apelido"));
                index[i] = rst.getString("id_recluso");
                i++;

                lbl_NomeCompleto.setText(rst.getString("nome") + " " + rst.getString("apelido"));
            }
            if (i >= 1) {
                listPesquisa.setVisible(true);
            } else {
                listPesquisa.setVisible(false);
            }
            // g.listarTodosReclusos();
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

    }

    void mostrarPesqisa() {
        int linha = listPesquisa.getSelectedIndex();
        if (linha >= 0) {
            String querySql = "select * from tbrecluso where id_recluso=" + index[linha] + "";
            // g.listarTodosReclusos();
        }
    }

    public void sett_campos() {
        System.out.println(" 1");
        try {
            int setar = jT_soltura.getSelectedRow();

            List<Recluso> Lista = reclusaoDAo.listarTodosReclusos();
            for (Recluso prisioneiro : Lista) {
                if (jT_soltura.getModel().getValueAt(setar, 0).toString().equals(prisioneiro.getCodigo())) {

                    if (prisioneiro.getEstado().equalsIgnoreCase("Activo")) {

                        lbl_Codigo.setText(prisioneiro.getCodigo());
                        lbl_NomeCompleto.setText(prisioneiro.getNome()+" "+prisioneiro.getApelido());
                        lbl_genero.setText(prisioneiro.getGenero());
                        lbl_estado_criminoso.setText(prisioneiro.getEstado());
                        lbl_Cela.setText(prisioneiro.getCelas().getCela());
                        lbl_cama.setText(prisioneiro.getCelas().getNrcama());
                        lbl_duracao.setText(prisioneiro.getDuracaoDapena());
                        lbl_frequencia.setText(prisioneiro.getFrequencia());
                        lbl_NomeAdvogado.setText(prisioneiro.getAdvogado().getNomeDeAdvogado());
                        lbl_Provincia.setText(String.valueOf(prisioneiro.getEndereco().getProvincias()));
                        if (lbl_genero.getText().equals("Masculino")) {
                           btn_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/PrisonerM.png")));

                        } else if (lbl_genero.getText().equals("Feminino")) {
                            btn_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/PrisonerF.png")));

                        }

                       
                        
                       // jList_deCrimes3.set(prisioneiro.getRegistroDeBens());
                        // endereco
//                        txt_rua.setText(prisioneiro.getEndereco().getRua());
//                        txt_bairro.setText(prisioneiro.getEndereco().getCasa());
//                        txt_nCasa.setText(prisioneiro.getEndereco().getRua());
//                        txt_quarteirao.setText(prisioneiro.getEndereco().getQuarteirao());
//                        cb_provincias.setSelectedItem(prisioneiro.getEndereco().getProvincias());
//                        cb_provincias.setSelectedItem(prisioneiro.getEndereco().getProvincias().getNacionalidade());
//                        // txt_rua.setText(prisioneiro.getEndereco().getRua());
//
////                        tf_contacto.setText(prisioneiro.getContacto());
////                        txt_email.setText(prisioneiro.getEmail());
////                        pf_Senha.setText(prisioneiro.getSenha());
////                        
//                        cb_nivelAcadademico.setSelectedItem(prisioneiro.getNivelAcademico());
//                        cb_doencas.setSelectedItem(prisioneiro.getNivelAcademico());
//
//                        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                        Date date = (Date) formatter.parse(prisioneiro.getDatadeNascimento());
//                        JDataFormatada.setDate(date);

                    }

                }
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e + " Erro!! Campo Selecionado esta vazio", "Notificação", JOptionPane.ERROR);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        listPesquisa = new javax.swing.JList<>();
        btn_foto = new javax.swing.JButton();
        lbl_Codigo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_frequencia = new javax.swing.JLabel();
        lbl_genero = new javax.swing.JLabel();
        lbl_Cela = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_NomeCompleto = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_Provincia = new javax.swing.JLabel();
        lbl_estado_criminoso = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jc_cumprida = new javax.swing.JCheckBox();
        jc_caucao = new javax.swing.JCheckBox();
        btn_soltar = new javax.swing.JButton();
        lbl_NomeAdvogado = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_idade = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jList_deCrimes2 = new javax.swing.JList<>();
        jLabel24 = new javax.swing.JLabel();
        lbl_cama = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jT_soltura = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        txt_pesquisar = new javax.swing.JTextField();
        lbl_duracao = new javax.swing.JLabel();
        jList_deCrimes3 = new javax.swing.JList<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Soltar de  recluso");
        setMinimumSize(new java.awt.Dimension(897, 606));
        setPreferredSize(new java.awt.Dimension(897, 606));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(new java.awt.Color(153, 153, 153));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(897, 606));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setToolTipText("");
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        listPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        listPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listPesquisaKeyReleased(evt);
            }
        });
        jPanel2.add(listPesquisa);
        listPesquisa.setBounds(10, 55, 210, 128);

        btn_foto.setBackground(new java.awt.Color(204, 204, 204));
        btn_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/prisoner.png"))); // NOI18N
        btn_foto.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jPanel2.add(btn_foto);
        btn_foto.setBounds(30, 130, 170, 210);

        lbl_Codigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_Codigo.setForeground(new java.awt.Color(255, 0, 51));
        lbl_Codigo.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel2.add(lbl_Codigo);
        lbl_Codigo.setBounds(120, 90, 80, 25);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Id de recluso ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(30, 90, 90, 16);

        lbl_frequencia.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_frequencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lbl_frequencia);
        lbl_frequencia.setBounds(500, 360, 60, 30);

        lbl_genero.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_genero.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lbl_genero);
        lbl_genero.setBounds(250, 140, 120, 30);

        lbl_Cela.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_Cela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lbl_Cela);
        lbl_Cela.setBounds(430, 280, 60, 30);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Nome de detento");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(250, 40, 180, 22);

        lbl_NomeCompleto.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_NomeCompleto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lbl_NomeCompleto);
        lbl_NomeCompleto.setBounds(250, 70, 350, 30);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Especificar a soltura ");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(780, 260, 190, 20);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Género");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(250, 110, 60, 20);

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Provincia");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(250, 170, 100, 20);

        lbl_Provincia.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_Provincia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lbl_Provincia);
        lbl_Provincia.setBounds(250, 190, 180, 30);

        lbl_estado_criminoso.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_estado_criminoso.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lbl_estado_criminoso);
        lbl_estado_criminoso.setBounds(240, 280, 170, 30);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Nome de Advogado");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(750, 80, 250, 22);

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Crimes");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(590, 250, 150, 20);

        buttonGroup1.add(jc_cumprida);
        jc_cumprida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jc_cumprida.setText("Pena cumprido");
        jc_cumprida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_cumpridaActionPerformed(evt);
            }
        });
        jPanel2.add(jc_cumprida);
        jc_cumprida.setBounds(810, 330, 140, 25);

        buttonGroup1.add(jc_caucao);
        jc_caucao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jc_caucao.setText("Caução");
        jc_caucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_caucaoActionPerformed(evt);
            }
        });
        jPanel2.add(jc_caucao);
        jc_caucao.setBounds(810, 300, 140, 25);

        btn_soltar.setBackground(new java.awt.Color(204, 255, 255));
        btn_soltar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_soltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/algemas.png"))); // NOI18N
        btn_soltar.setText("Soltar");
        btn_soltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_soltarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_soltar);
        btn_soltar.setBounds(810, 370, 160, 30);

        lbl_NomeAdvogado.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_NomeAdvogado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lbl_NomeAdvogado);
        lbl_NomeAdvogado.setBounds(750, 120, 270, 30);

        jLabel29.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray)));
        jPanel2.add(jLabel29);
        jLabel29.setBounds(10, 70, 210, 290);

        jLabel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray), "Dados de Advogado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N
        jPanel2.add(jLabel32);
        jLabel32.setBounds(730, 20, 310, 210);

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Estado de criminoso:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(240, 250, 130, 20);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Frequencia ");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(500, 330, 80, 20);

        lbl_idade.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_idade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_idade.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lbl_idade);
        lbl_idade.setBounds(620, 70, 60, 30);

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Idade");
        jPanel2.add(jLabel33);
        jLabel33.setBounds(630, 40, 50, 20);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText(" Cela ");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(430, 250, 60, 20);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText(" bens     ");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(470, 100, 80, 20);

        jList_deCrimes2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList_deCrimes2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jList_deCrimes2.setEnabled(false);
        jList_deCrimes2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList_deCrimes2MousePressed(evt);
            }
        });
        jPanel2.add(jList_deCrimes2);
        jList_deCrimes2.setBounds(590, 280, 160, 110);

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("N ° cama");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(500, 250, 60, 20);

        lbl_cama.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_cama.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lbl_cama);
        lbl_cama.setBounds(500, 280, 50, 30);

        jT_soltura = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIdex){
                return false;
            }
        };
        jT_soltura.setBackground(new java.awt.Color(204, 204, 204));
        jT_soltura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jT_soltura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Género", "Data de Nascimento", "Naturaliade ", "duracao da pena", "frequencia", "Crime", "cela", "Bens", "Advogado"
            }
        ));
        jT_soltura.setToolTipText("Selecione o recluso que pretendes Soltar.");
        jT_soltura.setFocusable(false);
        jT_soltura.setPreferredSize(new java.awt.Dimension(897, 606));
        jT_soltura.setSelectionBackground(new java.awt.Color(232, 242, 252));
        jT_soltura.setSelectionForeground(new java.awt.Color(240, 240, 240));
        jT_soltura.setShowHorizontalLines(false);
        jT_soltura.setShowVerticalLines(false);
        jT_soltura.getTableHeader().setReorderingAllowed(false);
        jT_soltura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_solturaMouseClicked(evt);
            }
        });
        jT_soltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_solturaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jT_soltura);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(20, 440, 1020, 110);

        jLabel40.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel40);
        jLabel40.setBounds(10, 420, 1040, 140);

        txt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisarActionPerformed(evt);
            }
        });
        txt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyReleased(evt);
            }
        });
        jPanel2.add(txt_pesquisar);
        txt_pesquisar.setBounds(10, 20, 210, 30);

        lbl_duracao.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_duracao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(lbl_duracao);
        lbl_duracao.setBounds(240, 360, 230, 30);

        jList_deCrimes3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList_deCrimes3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jList_deCrimes3.setEnabled(false);
        jList_deCrimes3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList_deCrimes3MousePressed(evt);
            }
        });
        jPanel2.add(jList_deCrimes3);
        jList_deCrimes3.setBounds(470, 130, 160, 90);

        jLabel30.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray)));
        jPanel2.add(jLabel30);
        jLabel30.setBounds(230, 30, 480, 200);

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Duração da para o termino");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(240, 330, 150, 20);

        jLabel34.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel34);
        jLabel34.setBounds(230, 240, 540, 160);

        jTabbedPane1.addTab("Dados do Recluso", jPanel2);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(20, 160, 260, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/Pesq.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(290, 160, 30, 30);

        jPanel3.setLayout(null);

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIdex){
                return false;
            }};
            jTable1.setBackground(new java.awt.Color(204, 204, 204));
            jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String [] {
                    "Id", "Nome do detento", "Género ", "Nome de advogado", "Categoria de crime", "Frequencia", "Estado da pena ", "tipo de soltura "
                }
            ));
            jTable1.setPreferredSize(new java.awt.Dimension(897, 606));
            jTable1.setShowHorizontalLines(false);
            jTable1.setShowVerticalLines(false);
            jScrollPane1.setViewportView(jTable1);

            jPanel3.add(jScrollPane1);
            jScrollPane1.setBounds(10, 20, 1010, 250);

            jPanel1.add(jPanel3);
            jPanel3.setBounds(10, 260, 1040, 290);

            jTabbedPane1.addTab("Listar e pesquisar Reclusos", jPanel1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            setBounds(0, 0, 1072, 640);
        }// </editor-fold>//GEN-END:initComponents

    private void btn_soltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_soltarActionPerformed
        Soltar();
    }//GEN-LAST:event_btn_soltarActionPerformed

    private void jList_deCrimes2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_deCrimes2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jList_deCrimes2MousePressed

    private void jc_cumpridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_cumpridaActionPerformed
        if (jc_cumprida.isSelected()) {
            btn_soltar.setEnabled(true);
        }
    }//GEN-LAST:event_jc_cumpridaActionPerformed

    private void jc_caucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_caucaoActionPerformed
        if (jc_caucao.isSelected()) {
            btn_soltar.setEnabled(true);
        }
    }//GEN-LAST:event_jc_caucaoActionPerformed

    private void listPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listPesquisaKeyReleased
        mostrarPesqisa();
        listPesquisa.setVisible(false);
    }//GEN-LAST:event_listPesquisaKeyReleased

    private void txt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisarActionPerformed
        listPesquisa.setVisible(false);
        enter = 1;
    }//GEN-LAST:event_txt_pesquisarActionPerformed

    private void txt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyReleased
        if (enter == 0) {
            listarPesquisa();
        } else {
            enter = 0;
        }

    }//GEN-LAST:event_txt_pesquisarKeyReleased

    private void txt_pesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            modelo.removeAllElements();

        }
    }//GEN-LAST:event_txt_pesquisarKeyPressed

    private void jList_deCrimes3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_deCrimes3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jList_deCrimes3MousePressed

    private void jT_solturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_solturaKeyPressed

    }//GEN-LAST:event_jT_solturaKeyPressed

    private void jT_solturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_solturaMouseClicked
        // TODO add your handling code here:
        sett_campos();
        System.out.println("Cliquei");
    }//GEN-LAST:event_jT_solturaMouseClicked

    long total, diferencaDias = 0;
    ReclusoDao reclusaoDAo = new ReclusoDao();
    Recluso recluso = new Recluso();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_foto;
    private javax.swing.JButton btn_soltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList_deCrimes2;
    private javax.swing.JList<String> jList_deCrimes3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jT_soltura;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JCheckBox jc_caucao;
    private javax.swing.JCheckBox jc_cumprida;
    private javax.swing.JLabel lbl_Cela;
    private javax.swing.JLabel lbl_Codigo;
    private javax.swing.JLabel lbl_NomeAdvogado;
    private javax.swing.JLabel lbl_NomeCompleto;
    private javax.swing.JLabel lbl_Provincia;
    private javax.swing.JLabel lbl_cama;
    private javax.swing.JLabel lbl_duracao;
    private javax.swing.JLabel lbl_estado_criminoso;
    private javax.swing.JLabel lbl_frequencia;
    private javax.swing.JLabel lbl_genero;
    private javax.swing.JLabel lbl_idade;
    private javax.swing.JList<String> listPesquisa;
    private javax.swing.JTextField txt_pesquisar;
    // End of variables declaration//GEN-END:variables
   public void Soltar() {

        try {

            /*validando os campos de preechimento
             */
//            if (txt_Nome.getText().isEmpty() || txt_Apelido.getText().isEmpty()
//                    || txt_NumeroDeBI.getText().isEmpty() || cb_provincias.getActionCommand().isEmpty()
//                    || cb_crimes.getActionCommand().isEmpty() || cb_Estado.getActionCommand().isEmpty()
//                    || cb_celas.getActionCommand().isEmpty()) {
//
//                JOptionPane.showMessageDialog(null, "Preencha todos campos obrigatorios", "Atenção", JOptionPane.WARNING_MESSAGE);
//
//            } else {
            recluso.setCodigo(lbl_Codigo.getText());
            recluso.setNome(lbl_NomeCompleto.getText());
            reclusaoDAo.soltarRecluso(recluso);

            // }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e + " Erro problema na digitação dos dados ", "Notificação", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }

    }

    private ArrayList<Recluso> ListarTodosReclusos() {

        return new Recluso().listar();

    }
}
