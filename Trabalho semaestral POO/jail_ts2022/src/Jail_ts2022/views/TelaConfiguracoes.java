/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jail_ts2022.views;

import Jail_ts2022.dao.CelasDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Jail_ts2022.dao.CrimesDAo;
import Jail_ts2022.dao.FuncionarioDao;
import Jail_ts2022.dao.NacionalidadeDao;
import Jail_ts2022.dao.NivelDeAcessoDao;
import Jail_ts2022.dao.ProvinciasDAo;
import Jail_ts2022.model.NivelDeAcesso;
import Jail_ts2022.model.Celas;
import Jail_ts2022.model.Crimes;
import Jail_ts2022.model.Funcionario;
import Jail_ts2022.model.Nacionalidade;
import Jail_ts2022.model.Provincias;
import java.awt.event.KeyEvent;

/**
 *
 * @author Mutisse
 */
public final class TelaConfiguracoes extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;
//
    DefaultListModel newModel = new DefaultListModel();

    /**
     * Creates new form NewJInternalFrame
     */
    public TelaConfiguracoes() {
        initComponents();
        jListDeElmentos.setModel(newModel);
        btn_atualizar.setEnabled(false);
        btn_remover.setEnabled(false);
        PrencherTabela();
        preencherPerfil();
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jLabel6.setVisible(false);
        jLabel5.setVisible(false);
        jLabel7.setVisible(false);
    }

    void limparAlista() {
        if (jListDeElmentos.getModel().getSize() > 1) {
            btn_add.setEnabled(true);
            jListDeElmentos.removeAll();
            jListDeElmentos.setEnabled(true);
        } else {
            btn_cancelar.setEnabled(false);
        }

    }

    public void sett_campos() {

        try {
            int setar = jT_table.getSelectedRow();
            lbl_Codigo.setText(jT_table.getModel().getValueAt(setar, 0).toString());

            if ((jT_table.getModel().getValueAt(setar, 4).toString()).equalsIgnoreCase("Inativo")) {

                btn_desbloquer.setEnabled(true);
            } else {
                jTextArea_causaDeDemisao.requestFocus();
                btn_desbloquer.setEnabled(false);
                btn_eliminar.setEnabled(false);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + " Erro na conexao");
        }
    }

    public void PrencherTabela() {
        try {
            FuncionarioDao pDao = new FuncionarioDao();
            List<Funcionario> Lista = pDao.ListarTodos();
            DefaultTableModel newModelTable = (DefaultTableModel) jT_table.getModel();
            newModelTable.setRowCount(0);

            Lista.forEach((Funcionario Usuario) -> {

                newModelTable.addRow(new Object[]{Usuario.getCodigo(), Usuario.getNome() + " " + Usuario.getApelido(),
                    Usuario.getGenero(), Usuario.getNivelDeAcesso(), Usuario.getEstado()});

            });
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage() + " Erro ao preencher atabela ", "Notificação", JOptionPane.ERROR);
        }
    }

    public void demitir() {

        try {

            /*validando os campos de preechimento
             */
            if (lbl_Codigo.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, " selecine o funcionario!!", "Atenção", JOptionPane.WARNING_MESSAGE);

            } else {
                Funcionario add = new Funcionario();
                add.setCodigo(lbl_Codigo.getText());
                lbl_Codigo.setText(null);
                FuncionarioDao save = new FuncionarioDao();
                save.demitirFuncionario(add);
                PrencherTabela();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " Erro problema na digitação dos dados ", "Notificação", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }

    }

    public void reademitir() {

        try {

            /*validando os campos de preechimento
             */
            if (lbl_Codigo.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, " selecine o funcionario!!", "Atenção", JOptionPane.WARNING_MESSAGE);

            } else {
                Funcionario add = new Funcionario();
                add.setCodigo(lbl_Codigo.getText());
                lbl_Codigo.setText(null);
                FuncionarioDao save = new FuncionarioDao();
                save.readmitirFuncionario(add);
                PrencherTabela();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " Erro problema na digitação dos dados ", "Notificação", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }

    }

    void Atualizar() {
        if (btn_atualizar.getText().equalsIgnoreCase("Atualizar")) {
            btn_add.setEnabled(false);
            btn_remover.setEnabled(false);
        } else {
            btn_add.setEnabled(true);
            btn_remover.setEnabled(false);
            btn_atualizar.setEnabled(false);
        }
    }

    void setarParaEditar() {
        if (jListDeElmentos.getSelectedIndex() > -1) {
            btn_atualizar.setEnabled(true);
            btn_remover.setEnabled(true);
            btn_add.setEnabled(false);
        }
    }

    void editarEAtualizar() {
        try {
            if (btn_atualizar.getText().equalsIgnoreCase("Editar")) {
                btn_atualizar.setText("Atualizar");
                txt_addElemento.setText(String.valueOf(jListDeElmentos.getSelectedValue()));
                jListDeElmentos.setEnabled(false);
                btn_remover.setEnabled(false);
                btn_cancelar.setEnabled(false);

            } else {
                btn_atualizar.setText("Editar");
                int index = jListDeElmentos.getSelectedIndex();
                newModel.setElementAt(txt_addElemento.getText(), index);
                jListDeElmentos.setEnabled(true);
                btn_add.setEnabled(true);
                btn_atualizar.setEnabled(false);
                btn_remover.setEnabled(false);
                txt_addElemento.setText(null);

                JOptionPane.showMessageDialog(null, "Elemento Atualizado", "", JOptionPane.INFORMATION_MESSAGE);
                limparAlista();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void add() {
        if (txt_addElemento.getText().equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(null, "Sem Elemento para adicionar!", "", JOptionPane.ERROR_MESSAGE);
        } else {
            newModel.addElement(txt_addElemento.getText().trim());
            if (jC_categoria.isSelected()) {
                categoria.setCategoria(txt_addElemento.getText());
                nivel.nivelDeAcesso(categoria);
            }
            JOptionPane.showMessageDialog(null, "Elemento adicionar", "", JOptionPane.INFORMATION_MESSAGE);
            txt_addElemento.setText(null);
            limparAlista();
        }
    }

    void remove() {
        int index = jListDeElmentos.getSelectedIndex();
        int confirmar = JOptionPane.showConfirmDialog(null, "Deseja remover esse elemento da lista? ", "", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            newModel.removeElementAt(index);
            JOptionPane.showMessageDialog(null, "Elemento removido", "", JOptionPane.INFORMATION_MESSAGE);
            txt_addElemento.setText(null);

        } else {
            btn_add.setEnabled(true);
            btn_atualizar.setEnabled(false);
            btn_remover.setEnabled(false);
            limparAlista();
        }
    }

    void cancelar() {
        int confirmar = JOptionPane.showConfirmDialog(null, "Deseja remover Todos elementos da lista? ", "", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            newModel.removeAllElements();
            JOptionPane.showMessageDialog(null, "Elementos removidos", "", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    void addPesq(String pesq) {
        DefaultListModel newPesq = new DefaultListModel();

        CrimesDAo crimes = new CrimesDAo();
        for (Crimes p : crimes.crimesPesq(pesq)) {
            newPesq.addElement(p.getCategoriaDeCrime());

        }

    }

    void preencherPerfil() {

        for (int i = 0; i < niveldeAcesso.size(); i++) {
            if (niveldeAcesso.get(i).getCategoria().equalsIgnoreCase("Director geral")) {
                cb_perfil.addItem(niveldeAcesso.get(i));

            }

        }
    }

    public void cb_categoria() {
        newModel.clear();
        for (int i = 0; i < niveldeAcesso.size(); i++) {
            newModel.addElement(niveldeAcesso.get(i));
        }

    }

    void naturaluadeCb() {
        newModel.clear();
        for (int i = 0; i < listarNacionalidade.size(); i++) {

            newModel.addElement(listarNacionalidade.get(i));

        }

    }

    void cb_celas() {
        newModel.clear();
        for (int i = 0; i < listarCelas.size(); i++) {
            newModel.addElement(listarCelas.get(i));
        }
    }

    void cb_provincias() {

        newModel.clear();
        for (int i = 0; i < listarProvincia.size(); i++) {

            newModel.addElement(listarProvincia.get(i));

        }
    }

    void crimesCb() {
        newModel.clear();
        for (int i = 0; i < listaCrimes.size(); i++) {
            newModel.addElement(listaCrimes.get(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ pesquisa rapida de crimes ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel11 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jC_cimes = new javax.swing.JCheckBox();
        jC_naturalidade = new javax.swing.JCheckBox();
        jC_cela = new javax.swing.JCheckBox();
        jC_categoria = new javax.swing.JCheckBox();
        jC_nacionalidade = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jC_Advogados = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDeElmentos = new javax.swing.JList();
        btn_atualizar = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_addElemento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jT_table = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_causaDeDemisao = new javax.swing.JTextArea();
        txt_pesquisarF = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        lbl_Codigo = new javax.swing.JLabel();
        btn_Bloquer = new javax.swing.JButton();
        btn_desbloquer = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cb_perfil = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().setLayout(null);

        jPanel11.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Selecione o elemento que pretende  fazer a pesquisa ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 10, 430, 30);

        buttonGroup1.add(jC_cimes);
        jC_cimes.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jC_cimes.setText("Crimes");
        jC_cimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_cimesActionPerformed(evt);
            }
        });
        jPanel2.add(jC_cimes);
        jC_cimes.setBounds(30, 70, 100, 23);

        buttonGroup1.add(jC_naturalidade);
        jC_naturalidade.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jC_naturalidade.setText("Naturalidade");
        jC_naturalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_naturalidadeActionPerformed(evt);
            }
        });
        jPanel2.add(jC_naturalidade);
        jC_naturalidade.setBounds(200, 70, 100, 23);

        buttonGroup1.add(jC_cela);
        jC_cela.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jC_cela.setText("Celas");
        jC_cela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_celaActionPerformed(evt);
            }
        });
        jPanel2.add(jC_cela);
        jC_cela.setBounds(200, 120, 100, 23);

        buttonGroup1.add(jC_categoria);
        jC_categoria.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jC_categoria.setText("Categoria");
        jC_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_categoriaActionPerformed(evt);
            }
        });
        jPanel2.add(jC_categoria);
        jC_categoria.setBounds(30, 120, 100, 20);

        buttonGroup1.add(jC_nacionalidade);
        jC_nacionalidade.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jC_nacionalidade.setText("provincias");
        jC_nacionalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_nacionalidadeActionPerformed(evt);
            }
        });
        jPanel2.add(jC_nacionalidade);
        jC_nacionalidade.setBounds(380, 130, 110, 23);

        jTextField1.setEnabled(false);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField1MouseEntered(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(800, 80, 70, 30);

        jTextField2.setEnabled(false);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField2MouseEntered(evt);
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(660, 80, 80, 30);
        jPanel2.add(jLabel5);
        jLabel5.setBounds(800, 50, 160, 20);
        jPanel2.add(jLabel6);
        jLabel6.setBounds(660, 50, 110, 20);
        jPanel2.add(jLabel7);
        jLabel7.setBounds(660, 20, 250, 20);

        buttonGroup1.add(jC_Advogados);
        jC_Advogados.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jC_Advogados.setText("Advogados");
        jC_Advogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_AdvogadosActionPerformed(evt);
            }
        });
        jPanel2.add(jC_Advogados);
        jC_Advogados.setBounds(380, 70, 110, 23);

        jPanel11.add(jPanel2);
        jPanel2.setBounds(10, 430, 1040, 170);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(null);

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel64.setText("ID");
        jPanel6.add(jLabel64);
        jLabel64.setBounds(600, 50, 40, 30);

        jListDeElmentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListDeElmentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListDeElmentos);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(830, 100, 190, 260);

        btn_atualizar.setBackground(new java.awt.Color(204, 204, 0));
        btn_atualizar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_atualizar.setText("Editar");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_atualizar);
        btn_atualizar.setBounds(720, 200, 100, 32);

        btn_add.setBackground(new java.awt.Color(0, 255, 0));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_add.setText("Adcionar");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel6.add(btn_add);
        btn_add.setBounds(600, 200, 100, 32);

        btn_remover.setBackground(new java.awt.Color(255, 102, 102));
        btn_remover.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_remover.setText("Remover");
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
            }
        });
        jPanel6.add(btn_remover);
        btn_remover.setBounds(600, 250, 100, 32);

        btn_cancelar.setBackground(new java.awt.Color(102, 102, 102));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_cancelar);
        btn_cancelar.setBounds(720, 250, 100, 32);

        txt_addElemento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_addElementoFocusGained(evt);
            }
        });
        jPanel6.add(txt_addElemento);
        txt_addElemento.setBounds(600, 120, 220, 34);

        jT_table = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIdex){
                return false;
            }
        };
        jT_table.setBackground(new java.awt.Color(204, 204, 204));
        jT_table.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jT_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome Completo", "Genero", "perfil ", "Estado"
            }
        ));
        jT_table.setFocusable(false);
        jT_table.setPreferredSize(new java.awt.Dimension(897, 606));
        jT_table.setSelectionBackground(new java.awt.Color(232, 242, 252));
        jT_table.setSelectionForeground(new java.awt.Color(240, 240, 240));
        jT_table.setShowHorizontalLines(false);
        jT_table.setShowVerticalLines(false);
        jT_table.getTableHeader().setReorderingAllowed(false);
        jT_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jT_table);

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(20, 260, 540, 120);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea_causaDeDemisao.setColumns(20);
        jTextArea_causaDeDemisao.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jTextArea_causaDeDemisao.setRows(5);
        jTextArea_causaDeDemisao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea_causaDeDemisaoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea_causaDeDemisao);

        jPanel6.add(jScrollPane3);
        jScrollPane3.setBounds(360, 60, 200, 100);
        jPanel6.add(txt_pesquisarF);
        txt_pesquisarF.setBounds(20, 80, 270, 30);

        txt_id.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id.setEnabled(false);
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idKeyPressed(evt);
            }
        });
        jPanel6.add(txt_id);
        txt_id.setBounds(640, 50, 50, 30);

        jLabel3.setText("Pesquisa");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(70, -30, 120, 14);

        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.add(jLabel1);
        jLabel1.setBounds(580, 20, 450, 360);

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel65.setText("ID");
        jPanel6.add(jLabel65);
        jLabel65.setBounds(30, 30, 30, 20);

        lbl_Codigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Codigo.setForeground(new java.awt.Color(255, 51, 51));
        lbl_Codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Codigo.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));
        jPanel6.add(lbl_Codigo);
        lbl_Codigo.setBounds(70, 30, 70, 25);

        btn_Bloquer.setBackground(new java.awt.Color(255, 102, 102));
        btn_Bloquer.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_Bloquer.setText("Bloquear");
        btn_Bloquer.setToolTipText("seleciona o funcinario ba tabela");
        btn_Bloquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BloquerActionPerformed(evt);
            }
        });
        jPanel6.add(btn_Bloquer);
        btn_Bloquer.setBounds(230, 210, 120, 32);

        btn_desbloquer.setBackground(new java.awt.Color(153, 255, 51));
        btn_desbloquer.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_desbloquer.setText("Desbloquer");
        btn_desbloquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desbloquerActionPerformed(evt);
            }
        });
        jPanel6.add(btn_desbloquer);
        btn_desbloquer.setBounds(420, 210, 130, 32);

        jLabel4.setText("Cuasa");
        jPanel6.add(jLabel4);
        jLabel4.setBounds(270, -20, 80, 14);

        btn_eliminar.setBackground(new java.awt.Color(204, 255, 255));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/remov.png"))); // NOI18N
        btn_eliminar.setText("Remover");
        btn_eliminar.setToolTipText("especifique a cusa para poder bloquer");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel6.add(btn_eliminar);
        btn_eliminar.setBounds(30, 210, 120, 32);

        jLabel8.setText("Motivo");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(360, 30, 160, 14);

        cb_perfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_perfil.setToolTipText("");
        cb_perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_perfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cb_perfilMouseEntered(evt);
            }
        });
        cb_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_perfilActionPerformed(evt);
            }
        });
        cb_perfil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cb_perfilKeyPressed(evt);
            }
        });
        jPanel6.add(cb_perfil);
        cb_perfil.setBounds(30, 160, 180, 30);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Atribuir novo nivel de Acesso:");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(30, 130, 240, 20);

        jPanel11.add(jPanel6);
        jPanel6.setBounds(10, 0, 1040, 420);

        getContentPane().add(jPanel11);
        jPanel11.setBounds(0, 0, 1070, 670);

        setBounds(0, 0, 1072, 640);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_addElementoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_addElementoFocusGained
        Atualizar();
    }//GEN-LAST:event_txt_addElementoFocusGained

    private void jListDeElmentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListDeElmentosMouseClicked
        try {

            setarParaEditar();
            if (jC_cimes.isSelected()) {
                Crimes remover = (Crimes) jListDeElmentos.getSelectedValue();
                txt_id.setText(remover.getId_crimes());
                jTextField1.setText(remover.getDuracaoEmAno());
                jTextField2.setText(remover.getDuracaoEmMeses());
            }
            if (jC_categoria.isSelected()) {
                NivelDeAcesso remover = (NivelDeAcesso) jListDeElmentos.getSelectedValue();
                txt_id.setText(remover.getId_categoria());
            }
            if (jC_naturalidade.isEnabled()) {
                Nacionalidade remover = (Nacionalidade) jListDeElmentos.getSelectedValue();
                txt_id.setText(remover.getId_nacionalidade());
            }
            if (jC_cela.isSelected()) {
                Celas remover = (Celas) jListDeElmentos.getSelectedValue();
                txt_id.setText(remover.getId_celas());
                jTextField1.setText(remover.getCapacitMax());
                jTextField2.setText(remover.getNrcama());
            }
            if (jC_nacionalidade.isSelected()) {
                Provincias remover = (Provincias) jListDeElmentos.getSelectedValue();
                txt_id.setText(remover.getId_provincias());
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jListDeElmentosMouseClicked

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        editarEAtualizar();
    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        add();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        remove();
    }//GEN-LAST:event_btn_removerActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        txt_addElemento.setText(null);

    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_BloquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BloquerActionPerformed
        demitir();
    }//GEN-LAST:event_btn_BloquerActionPerformed

    private void btn_desbloquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desbloquerActionPerformed
        reademitir();
    }//GEN-LAST:event_btn_desbloquerActionPerformed

    private void jC_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_categoriaActionPerformed
        cb_categoria();
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jLabel6.setVisible(false);
        jLabel5.setVisible(false);
        jLabel7.setVisible(false);
    }//GEN-LAST:event_jC_categoriaActionPerformed

    private void jT_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_tableMouseClicked
        sett_campos();
    }//GEN-LAST:event_jT_tableMouseClicked

    private void txt_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyPressed
        if (btn_atualizar.getText().equalsIgnoreCase("Editar")) {
            txt_id.setEnabled(true);
        }

    }//GEN-LAST:event_txt_idKeyPressed

    private void jC_cimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_cimesActionPerformed
        jLabel5.setText("Meses");
        jLabel6.setText("Anos");
        jLabel7.setText("Dados do crime");
        crimesCb();
        //
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jLabel6.setVisible(true);
        jLabel5.setVisible(true);
        jLabel7.setVisible(true);
    }//GEN-LAST:event_jC_cimesActionPerformed

    private void jC_celaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_celaActionPerformed
        jLabel5.setText("Capacidade maxima");
        jLabel6.setText("Nr Camas");
        jLabel7.setText("Dados da Cela");
        //
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jLabel6.setVisible(true);
        jLabel5.setVisible(true);
        jLabel7.setVisible(true);
        cb_celas();
    }//GEN-LAST:event_jC_celaActionPerformed

    private void jC_nacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_nacionalidadeActionPerformed
        cb_provincias();
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jLabel6.setVisible(false);
        jLabel5.setVisible(false);
        jLabel7.setVisible(false);
    }//GEN-LAST:event_jC_nacionalidadeActionPerformed

    private void jTextField2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseEntered
        jTextField2.setEnabled(true);
    }//GEN-LAST:event_jTextField2MouseEntered

    private void jTextField1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseEntered
        jTextField1.setEnabled(true);
    }//GEN-LAST:event_jTextField1MouseEntered

    private void jC_naturalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_naturalidadeActionPerformed
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jLabel6.setVisible(false);
        jLabel5.setVisible(false);
        jLabel7.setVisible(false);
        naturaluadeCb();
    }//GEN-LAST:event_jC_naturalidadeActionPerformed

    private void jTextArea_causaDeDemisaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea_causaDeDemisaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jTextArea_causaDeDemisao.getText().isEmpty()) {
                btn_Bloquer.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Esse campo deve ser preenchido na exclusao de funcionario", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                btn_Bloquer.setEnabled(false);
                btn_eliminar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jTextArea_causaDeDemisaoKeyPressed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        removerFuncionario();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void cb_perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_perfilMouseClicked

    }//GEN-LAST:event_cb_perfilMouseClicked

    private void cb_perfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_perfilMouseEntered

    }//GEN-LAST:event_cb_perfilMouseEntered

    private void cb_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_perfilActionPerformed

    }//GEN-LAST:event_cb_perfilActionPerformed

    private void cb_perfilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb_perfilKeyPressed

    }//GEN-LAST:event_cb_perfilKeyPressed

    private void jC_AdvogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_AdvogadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jC_AdvogadosActionPerformed

    NivelDeAcessoDao nivel = new NivelDeAcessoDao();
    List<NivelDeAcesso> niveldeAcesso = nivel.ListarNivelDeAcesso();
    NivelDeAcesso categoria = new NivelDeAcesso();

    CelasDao celaDAo = new CelasDao();
    List<Celas> listarCelas = celaDAo.ListarCelas();

    CrimesDAo crimes = new CrimesDAo();
    List<Crimes> listaCrimes = crimes.ListaCrimes();
    //---- CAMAS 
    ProvinciasDAo provincia = new ProvinciasDAo();
    List<Provincias> listarProvincia = provincia.ListaProvincias();
    //
    NacionalidadeDao nacionalidade = new NacionalidadeDao();
    List<Nacionalidade> listarNacionalidade = nacionalidade.ListaNacionalidade();
    //


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Bloquer;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_desbloquer;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_remover;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Jail_ts2022.model.NivelDeAcesso> cb_perfil;
    private javax.swing.JCheckBox jC_Advogados;
    private javax.swing.JCheckBox jC_categoria;
    private javax.swing.JCheckBox jC_cela;
    private javax.swing.JCheckBox jC_cimes;
    private javax.swing.JCheckBox jC_nacionalidade;
    private javax.swing.JCheckBox jC_naturalidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jListDeElmentos;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jT_table;
    private javax.swing.JTextArea jTextArea_causaDeDemisao;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_Codigo;
    private javax.swing.JTextField txt_addElemento;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_pesquisarF;
    // End of variables declaration//GEN-END:variables

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Remover dados de funcionario ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void removerFuncionario() {

        try {

            /*validando os campos de preechimento
             */
            Funcionario funcionario = new Funcionario();
            funcionario.setCodigo(lbl_Codigo.getText());
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            funcionarioDao.removerFuncionario(funcionario);

            PrencherTabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " Erro problema na digitação dos dados ", "Notificação", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }

    }

}
