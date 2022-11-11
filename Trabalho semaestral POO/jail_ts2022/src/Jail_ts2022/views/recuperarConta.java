/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jail_ts2022.views;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import Jail_ts2022.conexao.Conectar;
import Jail_ts2022.controller.EnvioDeEmail;
import Jail_ts2022.controller.ControllerFuncionario;
import Jail_ts2022.dao.FuncionarioDao;
import Jail_ts2022.model.Funcionario;

/**
 *
 * @author Mutisse
 */
public class recuperarConta extends javax.swing.JFrame {

    ControllerFuncionario f = new ControllerFuncionario();
    EnvioDeEmail emailUsuario = new EnvioDeEmail();
    //FuncionarioDao codigoVerficado = new FuncionarioDao();
//
    Connection conexao = null;
    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
    ResultSet rst = null;
    private int id;

    /**
     * Creates new form recuperarConta
     */
    public recuperarConta() {
        initComponents();
        setIconImage();
        Lbl7.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        pf_Senha2.setVisible(false);
        pf_Senha.setVisible(false);
        btn_salvar.setVisible(false);
        jCsenha.setVisible(false);
        txt_ConfirmarCodigo.setVisible(false);
        btn_2.setVisible(false);
        jLabel5.setVisible(false);
        pf_Senha2.setEnabled(false);
        btn_sair.setEnabled(false);
        txt_codigoFuncionario.setEnabled(false);
        btn_1.setEnabled(false);
    }

    void confirmar3() {
        if (!pf_Senha.getText().isEmpty()) {
            if (!pf_Senha2.getText().isEmpty()) {
                salvar();
            } else {
                JOptionPane.showMessageDialog(null, "confirme a senha definada!", "", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Defina uma senha!", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    void verificandoAsCredencias() {
        if (txt_Username.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor,preencha o campo nova e-mail!", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else if (txt_codigoFuncionario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor Preencha com o Id do funcionário!", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            verificarFuncionario();
        }
    }

    void confirmar2() {

        if (txt_ConfirmarCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digte o codigo de cinfirmacao!", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            confirmar3();
        }

    }

    void enviarCodigo() {
        /* enviar codigo de confirmacao,
                 onde e gerado o codgo de recuperacao */
        Random random = new Random();
        int codigoParaEmal = random.nextInt(900000);

        while (codigoParaEmal < 100000) {
            codigoParaEmal = random.nextInt(900000);

        }// fim while

        codigoDeConfirmacao = codigoParaEmal;

        System.out.println("              RECUPERAÇÃO DE CONTA            ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" Codigo de Confirmação:  " + codigoParaEmal);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        JOptionPane.showMessageDialog(null, "Foi enviado o codigo de confirmacao", "Atenção", JOptionPane.INFORMATION_MESSAGE);

    }

    public void verificarFuncionario() {

        conexao = Conectar.conector();
        // essa Query faz a selecao do mair valor na base de dados 
        String querySql = "select * from tbfuncionario where email =? and codigoDeFuncionario = ? and  Senha!=' '";

        try {

            stat = conexao.prepareStatement(querySql);
            stat.setString(1, txt_Username.getText());
            stat.setString(2, txt_codigoFuncionario.getText());
            rst = stat.executeQuery();

            if (rst.next()) {
                id = rst.getInt(1);
                //return true;
                txt_Username.setVisible(false);
                txt_codigoFuncionario.setVisible(false);
                lbl_IdFuncionario.setVisible(false);
                jLabel3.setVisible(false);
                btn_1.setVisible(false);
                //
                enviarCodigo();

                ///
                txt_ConfirmarCodigo.setVisible(true);
                txt_ConfirmarCodigo.requestFocus();
                Lbl7.setVisible(true);
                txt_ConfirmarCodigo.setBounds(200, 150, 100, 30);
                jLabel5.setBounds(200, 200, 110, 23);
                jLabel5.setVisible(true);
                Lbl7.setBounds(200, 110, 250, 30);
                btn_2.setVisible(true);
                btn_2.setBounds(320, 150, 130, 30);

            } else {
                JOptionPane.showMessageDialog(null, "Não existe funcionário com e-mail / ID ", "Atenção", JOptionPane.WARNING_MESSAGE);
                txt_Username.setText(null);
                txt_Username.requestFocus();
                txt_codigoFuncionario.setText(null);
                txt_codigoFuncionario.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                txt_Username.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " Erro do codigo");

        } finally {
            try {
                stat.close();
                conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " Erro na conexao", "Notificação", JOptionPane.ERROR);

            }

        }

    }

    void verificarOCodigoEnviado() {

        if (!txt_ConfirmarCodigo.getText().equalsIgnoreCase(String.valueOf(codigoDeConfirmacao))) {
            JOptionPane.showMessageDialog(null, "Codigo de confimacao invalido! ", "Atenção", JOptionPane.WARNING_MESSAGE);
            txt_ConfirmarCodigo.setText(null);
            txt_ConfirmarCodigo.requestFocus();
        } else {
            // desabilitar
            pf_Senha.requestFocus();
            txt_ConfirmarCodigo.setVisible(false);
            Lbl7.setVisible(false);
            btn_2.setVisible(false);
            jLabel5.setVisible(false);
            //
            pf_Senha.requestFocus();
            pf_Senha2.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            pf_Senha.setVisible(true);
            btn_salvar.setVisible(true);
            jCsenha.setVisible(true);
            // bounds
            jLabel7.setBounds(200, 100, 100, 30);
            jLabel8.setBounds(330, 100, 100, 30);
            pf_Senha.setBounds(200, 140, 100, 30);
            pf_Senha2.setBounds(330, 140, 100, 30);
            jCsenha.setBounds(200, 170, 150, 30);

        }
    }

    void salvar() {
        FuncionarioDao saveDao = new FuncionarioDao();
        Funcionario add = new Funcionario();
        add.setCodigo(String.valueOf(id));
        add.setSenha(pf_Senha.getText());
        saveDao.RecuperarSenha(add);
        JOptionPane.showMessageDialog(null, "A sua conta foi recuperada.\n Use o seu e-mail e sua nova senha para fazer o login.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        new TelaLogin().setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_Username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Lbl7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnLimpar1 = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        pf_Senha = new javax.swing.JPasswordField();
        lbl_IdFuncionario = new javax.swing.JLabel();
        pf_Senha2 = new javax.swing.JPasswordField();
        jCsenha = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        txt_codigoFuncionario = new javax.swing.JTextField();
        txt_ConfirmarCodigo = new javax.swing.JFormattedTextField();
        btn_1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel1.setLayout(null);

        txt_Username.setBackground(new java.awt.Color(204, 204, 204));
        txt_Username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UsernameActionPerformed(evt);
            }
        });
        txt_Username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_UsernameKeyPressed(evt);
            }
        });
        jPanel1.add(txt_Username);
        txt_Username.setBounds(200, 100, 260, 33);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Email:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 70, 110, 20);

        Lbl7.setBackground(new java.awt.Color(255, 255, 255));
        Lbl7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Lbl7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl7.setText("Digite  Código enviado  no e-mail:");
        jPanel1.add(Lbl7);
        Lbl7.setBounds(20, 10, 260, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Recuperar Conta  de Funcionário");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 10, 450, 40);

        btn_2.setBackground(new java.awt.Color(204, 255, 255));
        btn_2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/telegram.png"))); // NOI18N
        btn_2.setText("Enviar");
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });
        btn_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_2KeyPressed(evt);
            }
        });
        jPanel1.add(btn_2);
        btn_2.setBounds(350, 230, 120, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/login-icon-png-27.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 50, 150, 180);

        btnLimpar1.setBackground(new java.awt.Color(204, 255, 255));
        btnLimpar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/clean.png"))); // NOI18N
        btnLimpar1.setText("Limpar");
        btnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar1);
        btnLimpar1.setBounds(170, 260, 130, 30);

        btn_sair.setBackground(new java.awt.Color(204, 255, 255));
        btn_sair.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/Cancel.png"))); // NOI18N
        btn_sair.setText("Cancelar");
        btn_sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_sairMouseEntered(evt);
            }
        });
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sair);
        btn_sair.setBounds(10, 260, 150, 31);

        pf_Senha.setBackground(new java.awt.Color(204, 204, 204));
        pf_Senha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pf_Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_SenhaActionPerformed(evt);
            }
        });
        pf_Senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pf_SenhaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pf_SenhaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pf_SenhaKeyTyped(evt);
            }
        });
        jPanel1.add(pf_Senha);
        pf_Senha.setBounds(20, 50, 100, 30);

        lbl_IdFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        lbl_IdFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_IdFuncionario.setText("ID de Funcionário:");
        jPanel1.add(lbl_IdFuncionario);
        lbl_IdFuncionario.setBounds(200, 160, 150, 20);

        pf_Senha2.setBackground(new java.awt.Color(204, 204, 204));
        pf_Senha2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pf_Senha2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pf_Senha2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pf_Senha2KeyReleased(evt);
            }
        });
        jPanel1.add(pf_Senha2);
        pf_Senha2.setBounds(370, 50, 100, 30);

        jCsenha.setBackground(new java.awt.Color(204, 204, 204));
        jCsenha.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jCsenha.setText("Mostrar a Senha ");
        jCsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCsenhaActionPerformed(evt);
            }
        });
        jPanel1.add(jCsenha);
        jCsenha.setBounds(190, 230, 140, 20);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Nova Senha:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(200, 140, 100, 20);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Confirmar senha:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(330, 140, 130, 16);

        btn_salvar.setBackground(new java.awt.Color(204, 255, 255));
        btn_salvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/add.png"))); // NOI18N
        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });
        btn_salvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_salvarKeyPressed(evt);
            }
        });
        jPanel1.add(btn_salvar);
        btn_salvar.setBounds(330, 260, 130, 30);

        txt_codigoFuncionario.setBackground(new java.awt.Color(204, 204, 204));
        txt_codigoFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_codigoFuncionario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_codigoFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoFuncionarioKeyPressed(evt);
            }
        });
        jPanel1.add(txt_codigoFuncionario);
        txt_codigoFuncionario.setBounds(200, 190, 120, 30);

        txt_ConfirmarCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txt_ConfirmarCodigo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        try {
            txt_ConfirmarCodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_ConfirmarCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_ConfirmarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ConfirmarCodigoActionPerformed(evt);
            }
        });
        txt_ConfirmarCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ConfirmarCodigoKeyPressed(evt);
            }
        });
        jPanel1.add(txt_ConfirmarCodigo);
        txt_ConfirmarCodigo.setBounds(10, 220, 110, 30);

        btn_1.setBackground(new java.awt.Color(204, 255, 255));
        btn_1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/telegram.png"))); // NOI18N
        btn_1.setText("Enviar");
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });
        btn_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_1KeyPressed(evt);
            }
        });
        jPanel1.add(btn_1);
        btn_1.setBounds(350, 190, 120, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("Reenviar o codigo");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(220, 50, 120, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 480, 310);

        setSize(new java.awt.Dimension(483, 311));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UsernameActionPerformed

    }//GEN-LAST:event_txt_UsernameActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        verificarOCodigoEnviado();
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar1ActionPerformed
        // LimparCampos();
    }//GEN-LAST:event_btnLimpar1ActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.dispose();
        new TelaLogin().setVisible(true);
    }//GEN-LAST:event_btn_sairActionPerformed

    private void jCsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCsenhaActionPerformed
        if (jCsenha.isSelected()) {
            pf_Senha.setEchoChar((char) 0);
            pf_Senha2.setEchoChar((char) 0);
        } else {
            pf_Senha2.setEchoChar('•');
            pf_Senha.setEchoChar('•');

        }
    }//GEN-LAST:event_jCsenhaActionPerformed

    private void pf_SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_SenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_SenhaActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        confirmar3();
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        verificandoAsCredencias();
    }//GEN-LAST:event_btn_1ActionPerformed

    private void pf_SenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_SenhaKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (pf_Senha.getText().length() > 3 || pf_Senha2.getText().length() > 3) {
                    pf_Senha2.setEnabled(false);
                    pf_Senha2.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Senha inválida.\nCombine pelo menos 4 caracteres!", "Notificacao", JOptionPane.INFORMATION_MESSAGE);
                }

                break;

            case KeyEvent.VK_RIGHT:
                pf_Senha2.requestFocus();
                break;

        }
    }//GEN-LAST:event_pf_SenhaKeyPressed

    private void pf_SenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_SenhaKeyTyped
        if (!pf_Senha.getText().isEmpty()) {
            pf_Senha2.setEnabled(true);
        }
    }//GEN-LAST:event_pf_SenhaKeyTyped

    private void pf_Senha2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_Senha2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ((pf_Senha.getText().equalsIgnoreCase(pf_Senha2.getText()) || (pf_Senha.getText().length() > 3 || pf_Senha2.getText().length() > 3))) {
                pf_Senha.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GREEN));
                pf_Senha2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GREEN));
                btn_salvar.setEnabled(true);
                btn_salvar.requestFocus();

            } else {
                pf_Senha2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
                btn_salvar.setEnabled(false);

            }

        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            pf_Senha2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        }
    }//GEN-LAST:event_pf_Senha2KeyPressed

    private void pf_Senha2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_Senha2KeyReleased


    }//GEN-LAST:event_pf_Senha2KeyReleased

    private void pf_SenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_SenhaKeyReleased
        if (!(pf_Senha.getText().equalsIgnoreCase(pf_Senha2.getText()))) {
            pf_Senha2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));

        }
    }//GEN-LAST:event_pf_SenhaKeyReleased

    private void txt_UsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UsernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (f.validarEmail(txt_Username.getText()) == false) {
                txt_Username.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
                txt_Username.requestFocus();
                txt_codigoFuncionario.setEnabled(false);

            } else {
                txt_codigoFuncionario.setEnabled(true);
                txt_codigoFuncionario.requestFocus();
                txt_Username.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GREEN));

            }
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            txt_Username.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        }

    }//GEN-LAST:event_txt_UsernameKeyPressed

    private void txt_codigoFuncionarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoFuncionarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_codigoFuncionario.getText().isEmpty()) {
                txt_codigoFuncionario.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
                txt_codigoFuncionario.requestFocus();
                btn_1.setEnabled(false);
            } else {
                btn_1.requestFocus();
                btn_1.setEnabled(true);
                txt_codigoFuncionario.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GREEN));

            }
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            txt_codigoFuncionario.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        }
    }//GEN-LAST:event_txt_codigoFuncionarioKeyPressed

    private void btn_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_1KeyPressed
        verificandoAsCredencias();
    }//GEN-LAST:event_btn_1KeyPressed

    private void txt_ConfirmarCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ConfirmarCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_Username.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por Favor preencha o campo nova e-mail!", "Erro!", JOptionPane.WARNING_MESSAGE);
            } else if (txt_codigoFuncionario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor Preencha com o Id do funcionário!", "Erro!", JOptionPane.WARNING_MESSAGE);
            } else {
                btn_2.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_ConfirmarCodigoKeyPressed

    private void btn_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            verificarOCodigoEnviado();
        }
    }//GEN-LAST:event_btn_2KeyPressed

    private void txt_ConfirmarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ConfirmarCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ConfirmarCodigoActionPerformed

    private void btn_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_salvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            confirmar3();
        }
    }//GEN-LAST:event_btn_salvarKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        enviarCodigo();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btn_sairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseEntered
      btn_sair.setEnabled(true);
    }//GEN-LAST:event_btn_sairMouseEntered

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(recuperarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(recuperarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(recuperarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(recuperarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new recuperarConta().setVisible(true);
//            }
//        });
//    }
    int codigoDeConfirmacao;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl7;
    private javax.swing.JButton btnLimpar1;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JCheckBox jCsenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_IdFuncionario;
    private javax.swing.JPasswordField pf_Senha;
    private javax.swing.JPasswordField pf_Senha2;
    private javax.swing.JFormattedTextField txt_ConfirmarCodigo;
    private javax.swing.JTextField txt_Username;
    private javax.swing.JTextField txt_codigoFuncionario;
    // End of variables declaration//GEN-END:variables

    private void setIconImage() {
        URL url = this.getClass().getResource("/Jail_ts2022/icons/login-icon-png-27.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

}
