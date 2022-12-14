
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jail_ts2022.views;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import Jail_ts2022.model.Funcionario;

/**
 *
 * @author Mutisse
 */
public final class TelaMenu extends javax.swing.JFrame {

    public Funcionario usuarioActual;

    public Funcionario getUsuarioActual() {
        return usuarioActual;
    }

    public void TelaMenu(Funcionario usuarioActual) {
        this.usuarioActual = usuarioActual;
        initComponents();
        HoraData();
        setIconImage();
        jDesktopPane1.add(tdescricao);
        tdescricao.setVisible(true);
        lbl_Usuario.setText(usuarioActual.getNome() + " " + usuarioActual.getApelido());
        lbl_Perfil.setText(usuarioActual.getNivelDeAcesso() + "");
        lbl_email.setText(usuarioActual.getEmail());
        //
        tRecluso.getLbl_idFuncionaio().setText(usuarioActual.getCodigo());

//        tperfil.gettxt fazer sete do usuaruio para perfil
        tperfil.getTxt_Nome().setText(usuarioActual.getNome());
        tperfil.getTxt_Apelido().setText(usuarioActual.getApelido());
        tperfil.getTf_nuit().setText(usuarioActual.getNuit());
        tperfil.getTxt_email().setText(usuarioActual.getEmail());
//        tperfil.getTxt_nbi().setText(usuarioActual.getNumeroDeBI());
        tperfil.getLbl_Codigo().setText(usuarioActual.getCodigo());
        tperfil.getLbl_perfil().setText(usuarioActual.getNivelDeAcesso().toString());
        //tperfil.getCh_dataNascimento().setDate(usuarioActual.);
        if (usuarioActual.getGenero().equals("Feminino")) {
            tperfil.getRb_Femenino().isSelected();
        } else {
            tperfil.getRb_Masculino().isSelected();
        }

        //
        trelatorioImpresso.getLbl_nomeDorequerente().setText(usuarioActual.getNome() + " " + usuarioActual.getApelido());

        if (lbl_Perfil.getText().equalsIgnoreCase("Gestor")) {
            lbl_addp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/manager-icon-png-7 (Copy).jpg")));

        } else {
            lbl_addp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/human-icon-png-1903 (3).png")));

        }
//        tdescricao.listaDeSuperLotacao();
    }

    /**
     * Creates new form Menu
     *
     * @param usuarioActual
     */
//    public TelaMenu() {
//         initComponents();
//
//    }
    public void HoraData() {
        Date data = new Date();
        sdf = new SimpleDateFormat("dd MMMM yyyy");

        Calendar now = Calendar.getInstance();

        class hora implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                lbl_horaData.setText(String.format(" %1$tH : %1$tM : %1$tS", now));

            }

        }

        Timer timer = new Timer(1000, new hora());
        timer.start();

        lbl_data.setText(sdf.format(data));

        Calendar c1 = Calendar.getInstance();
        int hora = c1.get(Calendar.HOUR_OF_DAY);

        if (hora <= 12 && hora <= 12) {
            lbl_Saudacao.setText(" Bom Dia,    Sr: ");
        } else if (hora > 12 && hora < 18) {
            lbl_Saudacao.setText(" Boa Tarde,  Sr: ");
        } else {
            lbl_Saudacao.setText(" Boa Noite,  Sr: ");
        }
        lbl_texto.setText("  @" + now.getWeekYear() + " * Maputo-Mo??ambique ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // telas 
    FuncionarioRegistro tFuncionario = new FuncionarioRegistro();
    RegistarDeRecluso tRecluso = new RegistarDeRecluso();
    TelaSoltarRecluso tSoltarrecluso = new TelaSoltarRecluso();
    TelaPerfil tperfil = new TelaPerfil();
    RelatorioGraficos trelatorio = new RelatorioGraficos();
    TelaInicial tdescricao = new TelaInicial();
    TelaConfiguracoes tconfigurar = new TelaConfiguracoes();
    relatorioImpresso trelatorioImpresso = new relatorioImpresso();

//    public void move() {
//        x1 = -200;
//        java.util.Timer t = new java.util.Timer();
//        TimerTask tt = new TimerTask() {
//            @Override
//            public void run() {
//
//                lbl_texto.setBounds(x1, 665, 180, 30);
//
//                x1++;
//                if (x1 == 200) {
//                    x1 = -200;
//                }
//            }
//        };
//        t.scheduleAtFixedRate(tt, 70, 70);
//
//    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        jPanel4 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        lbl_Perfil = new javax.swing.JLabel();
        lbl_addp = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btn_addRecluso = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_soltarRecluso = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_horaData = new javax.swing.JLabel();
        lbl_data = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_Usuario = new javax.swing.JLabel();
        lbl_texto = new javax.swing.JLabel();
        lbl_Saudacao = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        m_item_sair = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuRegistro = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        GerarRelatorio = new javax.swing.JMenuItem();

        setTitle("Menu");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1134, 657));
        setUndecorated(true);

        jPanel4.setLayout(null);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(897, 549));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(897, 4));
        jDesktopPane1.setVerifyInputWhenFocusTarget(false);
        jDesktopPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDesktopPane1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDesktopPane1MouseReleased(evt);
            }
        });
        jPanel4.add(jDesktopPane1);
        jDesktopPane1.setBounds(225, 10, 1073, 640);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Perfil.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        lbl_Perfil.setForeground(new java.awt.Color(255, 51, 51));
        lbl_Perfil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(lbl_Perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 150, 20));

        lbl_addp.setBackground(new java.awt.Color(204, 204, 204));
        lbl_addp.setToolTipText("Clica para ver o seu perfil");
        lbl_addp.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbl_addp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_addpActionPerformed(evt);
            }
        });
        lbl_addp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_addpKeyPressed(evt);
            }
        });
        jPanel2.add(lbl_addp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, 190));

        jSeparator2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(240, 240, 240)));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 240));

        jPanel3.setLayout(null);

        btn_addRecluso.setBackground(new java.awt.Color(153, 153, 153));
        btn_addRecluso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_addRecluso.setForeground(new java.awt.Color(102, 102, 102));
        btn_addRecluso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/prisoner_200px.png"))); // NOI18N
        btn_addRecluso.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        btn_addRecluso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addReclusoActionPerformed(evt);
            }
        });
        btn_addRecluso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_addReclusoKeyPressed(evt);
            }
        });
        jPanel3.add(btn_addRecluso);
        btn_addRecluso.setBounds(18, 40, 120, 60);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar Recluso");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 10, 120, 16);

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 160, 120));

        jPanel1.setLayout(null);

        btn_soltarRecluso.setBackground(new java.awt.Color(153, 153, 153));
        btn_soltarRecluso.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btn_soltarRecluso.setForeground(new java.awt.Color(102, 102, 102));
        btn_soltarRecluso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/algemas (1).png"))); // NOI18N
        btn_soltarRecluso.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        btn_soltarRecluso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_soltarReclusoActionPerformed(evt);
            }
        });
        btn_soltarRecluso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_soltarReclusoKeyPressed(evt);
            }
        });
        jPanel1.add(btn_soltarRecluso);
        btn_soltarRecluso.setBounds(18, 40, 120, 60);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Soltar Recluso");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(18, 10, 120, 16);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 160, 120));

        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 180, 280));

        lbl_horaData.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lbl_horaData.setForeground(new java.awt.Color(153, 153, 153));
        lbl_horaData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lbl_horaData, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 20));

        lbl_data.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lbl_data.setForeground(new java.awt.Color(102, 102, 102));
        lbl_data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lbl_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 160, 30));

        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), java.awt.Color.white));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 10, 190, 620));

        jPanel4.add(jPanel2);
        jPanel2.setBounds(10, 10, 204, 640);

        jPanel5.setBackground(new java.awt.Color(230, 230, 230));
        jPanel5.setLayout(null);

        lbl_Usuario.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lbl_Usuario.setForeground(new java.awt.Color(153, 153, 153));
        lbl_Usuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel5.add(lbl_Usuario);
        lbl_Usuario.setBounds(650, 5, 390, 20);

        lbl_texto.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        lbl_texto.setForeground(new java.awt.Color(102, 102, 102));
        jPanel5.add(lbl_texto);
        lbl_texto.setBounds(20, 5, 180, 15);

        lbl_Saudacao.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lbl_Saudacao.setForeground(new java.awt.Color(153, 153, 153));
        jPanel5.add(lbl_Saudacao);
        lbl_Saudacao.setBounds(550, 5, 90, 20);

        lbl_email.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(153, 153, 153));
        jPanel5.add(lbl_email);
        lbl_email.setBounds(1050, 5, 230, 20);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(10, 660, 1290, 26);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(281, 30));

        m_item_sair.setBackground(new java.awt.Color(255, 51, 51));
        m_item_sair.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        m_item_sair.setForeground(new java.awt.Color(255, 51, 51));
        m_item_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/icon-configuracoes (2).png"))); // NOI18N
        m_item_sair.setText("Opcoes");
        m_item_sair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/info_15181.png"))); // NOI18N
        jMenuItem2.setText("Informa????o Do SI");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        m_item_sair.add(jMenuItem2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/kindpng.png"))); // NOI18N
        jMenuItem5.setText("Mudar de Usuario");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        m_item_sair.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/off.png"))); // NOI18N
        jMenuItem6.setText("Encerar o Sistema");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        m_item_sair.add(jMenuItem6);

        jMenuBar1.add(m_item_sair);

        jMenu2.setBackground(new java.awt.Color(204, 255, 255));
        jMenu2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/add1.png"))); // NOI18N
        jMenu2.setText("Registros");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu2.add(jSeparator3);

        jMenuRegistro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuRegistro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/multest1.png"))); // NOI18N
        jMenuRegistro.setText("Funcion??rio");
        jMenuRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegistroActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuRegistro);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/report.png"))); // NOI18N
        jMenuItem1.setText("Configurar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/pie-chart.png"))); // NOI18N
        jMenu3.setText("Relatorios");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu3.add(jSeparator4);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/graph-with-arrow-icon-3479 (Copy).png"))); // NOI18N
        jMenuItem4.setText("Estat??sticas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        GerarRelatorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        GerarRelatorio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jail_ts2022/icons/printer_green_10875 - Copy.png"))); // NOI18N
        GerarRelatorio.setText("Imprimir Relat??rio pdf");
        GerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarRelatorioActionPerformed(evt);
            }
        });
        jMenu3.add(GerarRelatorio);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1310, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1310, 722));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegistroActionPerformed
        try {
            jDesktopPane1.remove(trelatorioImpresso);
            jDesktopPane1.remove(trelatorio);
            jDesktopPane1.remove(tconfigurar);
            jDesktopPane1.remove(tperfil);
            jDesktopPane1.remove(tRecluso);
            jDesktopPane1.remove(tSoltarrecluso);
            jDesktopPane1.add(tFuncionario);
            jDesktopPane1.remove(tdescricao);
            tFuncionario.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, " Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuRegistroActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            jDesktopPane1.remove(trelatorioImpresso);
            jDesktopPane1.remove(tconfigurar);
            jDesktopPane1.remove(tperfil);
            jDesktopPane1.remove(tRecluso);
            jDesktopPane1.remove(tFuncionario);
            jDesktopPane1.remove(tSoltarrecluso);
            jDesktopPane1.add(trelatorio);
            jDesktopPane1.remove(tdescricao);
            trelatorio.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            jDesktopPane1.remove(trelatorioImpresso);
            jDesktopPane1.remove(tperfil);
            jDesktopPane1.remove(tconfigurar);
            jDesktopPane1.remove(tRecluso);
            jDesktopPane1.remove(tFuncionario);
            jDesktopPane1.remove(tSoltarrecluso);
            jDesktopPane1.remove(trelatorio);
            jDesktopPane1.add(tdescricao);
            tdescricao.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        i = JOptionPane.showConfirmDialog(null, "Deseja terminar a se????o?", "fim da se????o", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
            new TelaLogin().setVisible(true);

        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        i = JOptionPane.showConfirmDialog(null, "Deseja Encerar o Programa?", "Encerar", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
            JOptionPane.showMessageDialog(null, "Fim da Execu????o! At?? breve");

        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void lbl_addpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_addpActionPerformed
        try {
            lbl_addp.setBackground(new Color(192, 220, 243));
            btn_soltarRecluso.setBackground(new Color(153, 153, 153));
            btn_addRecluso.setBackground(new Color(153, 153, 153));
            //
            jDesktopPane1.remove(trelatorioImpresso);
            jDesktopPane1.remove(trelatorio);
            jDesktopPane1.remove(tFuncionario);
            jDesktopPane1.remove(tconfigurar);
            jDesktopPane1.remove(tRecluso);
            jDesktopPane1.remove(tSoltarrecluso);
            jDesktopPane1.remove(tdescricao);
            jDesktopPane1.add(tperfil);
            tperfil.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_lbl_addpActionPerformed

    private void btn_soltarReclusoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_soltarReclusoActionPerformed
        try {
            btn_soltarRecluso.setBackground(new Color(192, 220, 243));
            lbl_addp.setBackground(new Color(153, 153, 153));
            btn_addRecluso.setBackground(new Color(153, 153, 153));
            //
            jDesktopPane1.remove(trelatorioImpresso);
            jDesktopPane1.remove(tperfil);
            jDesktopPane1.remove(tconfigurar);
            jDesktopPane1.remove(tdescricao);
            jDesktopPane1.remove(trelatorio);
            jDesktopPane1.remove(tFuncionario);
            jDesktopPane1.remove(tRecluso);
            jDesktopPane1.add(tSoltarrecluso);
            tSoltarrecluso.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_soltarReclusoActionPerformed

    private void btn_addReclusoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addReclusoActionPerformed
        try {
            btn_addRecluso.setBackground(new Color(192, 220, 243));
            btn_soltarRecluso.setBackground(new Color(153, 153, 153));
            lbl_addp.setBackground(new Color(153, 153, 153));
            //
            jDesktopPane1.remove(trelatorioImpresso);
            jDesktopPane1.remove(tperfil);
            jDesktopPane1.remove(tconfigurar);
            jDesktopPane1.remove(trelatorio);
            jDesktopPane1.remove(tFuncionario);
            jDesktopPane1.remove(tSoltarrecluso);
            jDesktopPane1.remove(tdescricao);
            jDesktopPane1.add(tRecluso);
            tRecluso.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_addReclusoActionPerformed

    private void btn_addReclusoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_addReclusoKeyPressed
        switch (evt.getKeyCode()) {

            case KeyEvent.VK_UP:
                lbl_addp.requestFocus();
                break;
            case KeyEvent.VK_DOWN:
                btn_soltarRecluso.requestFocus();
                break;
            case KeyEvent.VK_ENTER:
                try {

                btn_addRecluso.setBackground(new Color(192, 220, 243));
                btn_soltarRecluso.setBackground(new Color(153, 153, 153));
                lbl_addp.setBackground(new Color(153, 153, 153));
                //
                jDesktopPane1.remove(trelatorioImpresso);
                jDesktopPane1.remove(tperfil);
                jDesktopPane1.remove(tconfigurar);
                jDesktopPane1.remove(trelatorio);
                jDesktopPane1.remove(tFuncionario);
                jDesktopPane1.remove(tSoltarrecluso);
                jDesktopPane1.remove(tdescricao);
                jDesktopPane1.add(tRecluso);
                tRecluso.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, " Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
            }
            break;

        }
    }//GEN-LAST:event_btn_addReclusoKeyPressed

    private void lbl_addpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_addpKeyPressed
        switch (evt.getKeyCode()) {

            case KeyEvent.VK_UP:
                btn_soltarRecluso.requestFocus();
                break;
            case KeyEvent.VK_DOWN:
                btn_addRecluso.requestFocus();
                break;
            case KeyEvent.VK_ENTER:
                try {
                lbl_addp.setBackground(new Color(192, 220, 243));
                btn_soltarRecluso.setBackground(new Color(153, 153, 153));
                btn_addRecluso.setBackground(new Color(153, 153, 153));
                //
                jDesktopPane1.remove(trelatorio);
                jDesktopPane1.remove(tFuncionario);
                jDesktopPane1.remove(tRecluso);
                jDesktopPane1.remove(tSoltarrecluso);
                jDesktopPane1.remove(tdescricao);
                jDesktopPane1.remove(tconfigurar);
                jDesktopPane1.remove(trelatorioImpresso);
                jDesktopPane1.add(tperfil);
                tperfil.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, " Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
            }
            break;

        }
    }//GEN-LAST:event_lbl_addpKeyPressed

    private void btn_soltarReclusoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_soltarReclusoKeyPressed
        switch (evt.getKeyCode()) {

            case KeyEvent.VK_UP:
                btn_addRecluso.requestFocus();
                break;

            case KeyEvent.VK_ENTER:
                btn_soltarRecluso.setBackground(new Color(192, 220, 243));
                lbl_addp.setBackground(new Color(153, 153, 153));
                btn_addRecluso.setBackground(new Color(153, 153, 153));
                //
                try {

                    jDesktopPane1.remove(tperfil);
                    jDesktopPane1.remove(tdescricao);
                    jDesktopPane1.remove(trelatorio);
                    jDesktopPane1.remove(tFuncionario);
                    jDesktopPane1.remove(tRecluso);
                    jDesktopPane1.remove(trelatorioImpresso);
                    jDesktopPane1.remove(tconfigurar);
                    jDesktopPane1.add(tSoltarrecluso);
                    tSoltarrecluso.setVisible(true);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
                }

        }


    }//GEN-LAST:event_btn_soltarReclusoKeyPressed

    private void jDesktopPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDesktopPane1MouseClicked

    }//GEN-LAST:event_jDesktopPane1MouseClicked

    private void jDesktopPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDesktopPane1MouseReleased
//        if (evt.isPopupTrigger()) {
//            jPopupMenu.add(jList);
//            jPopupMenu.show(this, evt.getX(), evt.getY());
//            jList.setVisible(true);
//
//        };
    }//GEN-LAST:event_jDesktopPane1MouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {

            jDesktopPane1.remove(trelatorio);
            jDesktopPane1.remove(tFuncionario);
            jDesktopPane1.remove(tperfil);
            jDesktopPane1.remove(tRecluso);
            jDesktopPane1.remove(tSoltarrecluso);
            jDesktopPane1.add(tconfigurar);
            jDesktopPane1.remove(tdescricao);
            jDesktopPane1.remove(trelatorioImpresso);
            tconfigurar.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, " Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void GerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarRelatorioActionPerformed
        try {

            jDesktopPane1.remove(trelatorio);
            jDesktopPane1.remove(tFuncionario);
            jDesktopPane1.remove(tperfil);
            jDesktopPane1.remove(tRecluso);
            jDesktopPane1.remove(tSoltarrecluso);
            jDesktopPane1.remove(tconfigurar);
            jDesktopPane1.remove(tdescricao);
            jDesktopPane1.add(trelatorioImpresso);
            trelatorioImpresso.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, " Erro! Esta  tela j?? esta em execu????o", "Notifica????o", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_GerarRelatorioActionPerformed

    private String dataf;
    private SimpleDateFormat sdf;
    int i, x1 = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem GerarRelatorio;
    private javax.swing.JButton btn_addRecluso;
    private javax.swing.JButton btn_soltarRecluso;
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenu jMenu3;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuRegistro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    public javax.swing.JLabel lbl_Perfil;
    private javax.swing.JLabel lbl_Saudacao;
    public javax.swing.JLabel lbl_Usuario;
    public javax.swing.JButton lbl_addp;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_horaData;
    private javax.swing.JLabel lbl_texto;
    private javax.swing.JMenu m_item_sair;
    // End of variables declaration//GEN-END:variables
  /**
     * // * @param args the command line arguments // //
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaMenu().setVisible(true);
//            }
//        });
//    }

    private void setIconImage() {
        URL url = this.getClass().getResource("/Jail_ts2022/icons/multest.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }
}
