package Jail_ts2022.dao;

/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
////package projecto001.dao;
////
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.util.ArrayList;
////import java.util.List;
////import javax.swing.JOptionPane;
////import projecto001.conexao.Conectar;
////import projecto001.model.Definicoes;
////
/////**
//// *
//// * @author Mutisse
//// */
////public class DefinicoesDao {
////
////    Connection conexao = null;
////    PreparedStatement stat = null; //pst quer dizer  PreparedStatement
////    ResultSet rst = null;
////
////    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Cbnaturalidade    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
////    public void AddNaturalidade(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "INSERT INTO tbdefinicoes (Cbnaturalidade) VALUES (?)";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbnaturalidade());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////
////    public void UdpdatNaturalidade(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "UPDATE  tbdefinicoes SET Cbnaturalidade WHERE Idf =?";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbnaturalidade());
////            stat.setString(1, add.getId());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  cbNivelDeAcesso    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
////    public void AddNivelDeAcesso(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "INSERT INTO tbdefinicoes (cbNivelDeAcesso) VALUES (?)";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbNivelDeAcesso());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////
////    public void UdpdatNivelDeAcesso(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "UPDATE  tbdefinicoes SET cbNivelDeAcesso WHERE Idf =?";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbNivelDeAcesso());
////            stat.setString(2, add.getId());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////   
////    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  cbduracaoDapena    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
////    public void AddcbduracaoDapena(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "INSERT INTO tbdefinicoes (cbduracaoDapena) VALUES (?)";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbduracaoDapena());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////
////    public void UdpdatcbduracaoDapena(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "UPDATE  tbdefinicoes SET cbduracaoDapena WHERE Idf =?";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbduracaoDapena());
////            stat.setString(1, add.getId());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  cbestadosDecriminosos    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
////    public void AddcbestadosDecriminosos(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "INSERT INTO tbdefinicoes (cbestadosDecriminosos) VALUES (?)";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbestadosDecriminosos());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////
////    public void UdpdatcbestadosDecriminosos(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "UPDATE  tbdefinicoes SET cbestadosDecriminosos WHERE Idf =?";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbestadosDecriminosos());
////            stat.setString(1, add.getId());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  cbtipoDeCrime    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
////    public void AddcbtipoDeCrime(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "INSERT INTO tbdefinicoes (cbtipoDeCrime) VALUES (?)";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbtipoDeCrime());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////
////    public void UdpdatcbtipoDeCrime(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "UPDATE  tbdefinicoes SET cbtipoDeCrime WHERE Idf =?";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbtipoDeCrime());
////            stat.setString(1, add.getId());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  cbdoenca    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
////    public void Addcbdoenca(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "INSERT INTO tbdefinicoes (cbdoenca) VALUES (?)";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbdoenca());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////
////    public void Udpdatcbdoenca(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "UPDATE  tbdefinicoes SET cbdoenca WHERE Idf =?";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbdoenca());
////            stat.setString(1, add.getId());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  cbaltura    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
////    public void Addcbaltura(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "INSERT INTO tbdefinicoes (cbaltura) VALUES (?)";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbaltura());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////
////    public void Udpcbaltura(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "UPDATE  tbdefinicoes SET cbaltura WHERE Idf =?";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbaltura());
////            stat.setString(1, add.getId());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////
////  
////    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  cbnivelAcademico    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
////    public void AddcbnivelAcademico(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "INSERT INTO tbdefinicoes (cbnivelAcademico) VALUES (?)";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbnivelAcademico());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////
////    public void UpdatcbnivelAcademico(Definicoes add) {
////
////        conexao = Conectar.conector();
////        String querySql = "UPDATE  tbdefinicoes SET cbnivelAcademico WHERE Idf =?";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            stat.setString(1, add.getCbnivelAcademico());
////            stat.setString(1, add.getId());
////            stat.executeUpdate();
////            JOptionPane.showMessageDialog(null, "adicionado com sucesso!!", "Notificação", JOptionPane.INFORMATION_MESSAGE);
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e + " Erro no cadastro", "Notificação", JOptionPane.ERROR_MESSAGE);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////    }
////
////  
//// /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  Preenche a comboxs    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
////    public List<Definicoes> ListarTodos() {
////        conexao = Conectar.conector();
////        List<Definicoes> Lista = new ArrayList<>();
////        String querySql = "select * from tbdefinicoes ";
////
////        try {
////            stat = conexao.prepareStatement(querySql);
////            ResultSet resultado = stat.executeQuery();
////
////            while (resultado.next()) {
////
////                Definicoes cbAdd = new Definicoes();
////                cbAdd.setCbnaturalidade(resultado.getString("Idf"));
////                cbAdd.setCbnaturalidade(resultado.getString("Cbnaturalidade"));
////                cbAdd.setCbNivelDeAcesso(resultado.getString("cbNivelDeAcesso"));
////                cbAdd.setCbCelas(resultado.getString("cbCelas"));
////                cbAdd.setCbestadosDecriminosos(resultado.getString("cbestadosDecriminosos"));
////                cbAdd.setCbtipoDeCrime(resultado.getString("cbtipoDeCrime"));
////                cbAdd.setCbdoenca(resultado.getString("cbdoenca"));
////                cbAdd.setCbaltura(resultado.getString("cbaltura"));
////                cbAdd.setCbnivelAcademico(resultado.getString("cbnivelAcademico"));
////                Lista.add(cbAdd);
////            }
////
////        } catch (Exception e) {
////            System.out.println(e);
////            JOptionPane.showMessageDialog(null, e + " Erro ao buscar o registro", "Notificação", JOptionPane.ERROR);
////        } finally {
////            try {
////                stat.close();
////                conexao.close();
////            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e + "Erro na conexao");
////
////            }
////        }
////        return Lista;
////    }
////
////}
