/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ControllerMilitar;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Equipamento;
import model.bean.FuncaoMilitar;
import model.bean.ItemParticular;
import model.bean.Militar;
import model.dao.EquipamentoDao;
import model.dao.ItemParticularDao;
import model.dao.MilitarDao;
import servicos.CisBiox;
import servicos.LimitaTexto;
import servicos.Maiusculas;
import servicos.Numero;

/**
 *
 * @author ASUS
 */
public class TlSaidaEqpParticular extends javax.swing.JInternalFrame {

    Integer codigoArmeiro;
    CisBiox biox = new CisBiox();
    private byte[] digital;
    List<Militar> listabiometria;
    Integer codigoMilitar;

    public TlSaidaEqpParticular(int codigoArmeiro) {
        initComponents();
        setTitle("DEVOLUÇÃO ARMAMENTO PARTICULAR");
        jTidMilitar.setDocument(new LimitaTexto(10));
        jPassword.setDocument(new Numero());
        this.codigoArmeiro = codigoArmeiro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Status = new javax.swing.ButtonGroup();
        TipoEquipamento = new javax.swing.ButtonGroup();
        jBentregar = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelLogin = new javax.swing.JLabel();
        jTidMilitar = new javax.swing.JTextField();
        jBautenticar = new javax.swing.JButton();
        jPassword = new javax.swing.JPasswordField();
        jLabelSenha = new javax.swing.JLabel();
        jBlerBiometria = new javax.swing.JButton();
        jBcancelarBiometria = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setEnabled(false);
        setFrameIcon(null);
        setVisible(true);

        jBentregar.setBackground(new java.awt.Color(75, 184, 75));
        jBentregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBentregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/salvar.png"))); // NOI18N
        jBentregar.setText("ENTREGAR");
        jBentregar.setEnabled(false);
        jBentregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBentregarActionPerformed(evt);
            }
        });

        jBcancelar.setBackground(new java.awt.Color(242, 67, 56));
        jBcancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/cancela32.png"))); // NOI18N
        jBcancelar.setText("CANCELAR");
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Militar Responsável", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        jLabelLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelLogin.setText("LOGIN:");

        jTidMilitar.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTidMilitar.setEnabled(false);
        jTidMilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidMilitarActionPerformed(evt);
            }
        });

        jBautenticar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jBautenticar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/pesquisar.png"))); // NOI18N
        jBautenticar.setBorder(null);
        jBautenticar.setBorderPainted(false);
        jBautenticar.setContentAreaFilled(false);
        jBautenticar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBautenticarActionPerformed(evt);
            }
        });

        jPassword.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jPassword.setEnabled(false);
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordKeyReleased(evt);
            }
        });

        jLabelSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelSenha.setText("SENHA:");

        jBlerBiometria.setBackground(new java.awt.Color(255, 255, 255));
        jBlerBiometria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBlerBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/ler_biometria.png"))); // NOI18N
        jBlerBiometria.setBorder(null);
        jBlerBiometria.setBorderPainted(false);
        jBlerBiometria.setContentAreaFilled(false);
        jBlerBiometria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBlerBiometria.setDisabledSelectedIcon(null);
        jBlerBiometria.setFocusPainted(false);
        jBlerBiometria.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jBlerBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlerBiometriaActionPerformed(evt);
            }
        });

        jBcancelarBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/cancelar_biometria.png"))); // NOI18N
        jBcancelarBiometria.setBorder(null);
        jBcancelarBiometria.setBorderPainted(false);
        jBcancelarBiometria.setContentAreaFilled(false);
        jBcancelarBiometria.setFocusPainted(false);
        jBcancelarBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarBiometriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(jBlerBiometria)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelLogin)
                        .addGap(13, 13, 13)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTidMilitar, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jPassword))
                .addGap(18, 18, 18)
                .addComponent(jBautenticar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBcancelarBiometria)
                .addGap(407, 407, 407))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBautenticar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBcancelarBiometria)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelLogin)
                                    .addComponent(jTidMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jBlerBiometria)
                                .addGap(1, 1, 1)))))
                .addGap(33, 33, 33))
        );

        jTabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabela.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Equipamento", "Série", "Arma", "Calibre", "Fabricante", "Obs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabela.setToolTipText("");
        jTabela.setRowHeight(22);
        jTabela.setRowMargin(5);
        jTabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTabela);
        if (jTabela.getColumnModel().getColumnCount() > 0) {
            jTabela.getColumnModel().getColumn(0).setMinWidth(0);
            jTabela.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTabela.getColumnModel().getColumn(0).setMaxWidth(0);
            jTabela.getColumnModel().getColumn(1).setMinWidth(100);
            jTabela.getColumnModel().getColumn(2).setMinWidth(100);
            jTabela.getColumnModel().getColumn(3).setMinWidth(100);
            jTabela.getColumnModel().getColumn(4).setMinWidth(100);
            jTabela.getColumnModel().getColumn(5).setMinWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jBentregar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBentregar)
                    .addComponent(jBcancelar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBentregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBentregarActionPerformed
        removerItem();
    }//GEN-LAST:event_jBentregarActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        biox.finalizar();
        dispose();
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jTidMilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTidMilitarActionPerformed
        jPassword.requestFocus();
    }//GEN-LAST:event_jTidMilitarActionPerformed

    private void jBautenticarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBautenticarActionPerformed
        autenticarMilitar();
    }//GEN-LAST:event_jBautenticarActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        autenticarMilitar();
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jBlerBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlerBiometriaActionPerformed
        captura();
    }//GEN-LAST:event_jBlerBiometriaActionPerformed

    private void jBcancelarBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarBiometriaActionPerformed
        CisBiox dll = new CisBiox();
        dll.cancelarLeitura();
        int iRetorno = biox.finalizar();
        if (iRetorno != 1) {
            JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
            return;
        }
        jTidMilitar.setEnabled(true);
        jTidMilitar.requestFocus();
        jPassword.setEnabled(true);
    }//GEN-LAST:event_jBcancelarBiometriaActionPerformed

    private void jPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyReleased
        if (jPassword.getPassword().length > 6) {
            JOptionPane.showMessageDialog(this, "APENAS 6 NÚMEROS");
            evt.consume();
            jPassword.setText("");
            jPassword.grabFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordKeyReleased

    private void captura() {

        new Thread() {
            public void run() {
                try {
                    int iRetorno = biox.iniciar();
                    if (iRetorno != 1) {
                        JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
                        jTidMilitar.setEnabled(true);
                        jPassword.setEnabled(true);
                        jTidMilitar.requestFocus();
                        return;
                    }

                    digital = biox.capturarDigital();

                    if (biox.getResultado() != 1) {
                        biox.finalizar();
                        return;
                    }
                    iRetorno = biox.finalizar();
                    if (iRetorno != 1) {
                        JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
                        return;
                    }
                    leitura();
                } catch (Exception e) {
                    System.out.println("Erro ainda nao sei " + e.getMessage());
                }
            }
        ;
    }

    .start();
    }
    
    private void leitura() {
        MilitarDao mDao = new MilitarDao();
        biox.iniciar();
        int cod = 0;
        try {
            listabiometria = mDao.digitalCautela();
            for (Militar militar : listabiometria) {
                if ((biox.compararDigital(digital, militar.getDigital())) == 1) {
                    JOptionPane.showMessageDialog(null, militar.getLogin() + "\n AUTENTICADO");
                    codigoMilitar = militar.getId();
                    lista();
                    jBentregar.setEnabled(true);
                    cod = 1;
                    break;
                }
            }

            if (cod == 0) {
                for (Militar militar : listabiometria) {
                    if ((biox.compararDigital(digital, militar.getDigital())) == -2) {
                        JOptionPane.showMessageDialog(null, "MILITAR NÃO ENCONTRADO");
                        break;
                    }
                }
            }
            biox.finalizar();
        } catch (Exception ex) {
            System.out.println("Leitura Erro" + ex.getMessage());
        }

    }

    private void autenticarMilitar() {
        String login = jTidMilitar.getText();
        String senha = jPassword.getText();
        try {
            boolean mil = new ControllerMilitar().autenticarMilitar(login, senha);
            if (mil == true) {
                try {
                    Militar mili = new ControllerMilitar().pesquisar(login);
                    if (mili != null) {
                        codigoMilitar = mili.getId();
                        JOptionPane.showMessageDialog(null, mili.getLogin() + " \n AUTENTICADO");
                        jBentregar.setEnabled(true);
                        lista();
                    }
                } catch (Exception ex) {
                    System.out.println("Erro ao pesquisar " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "LOGIN OU SENHA INCORRETO");
                jTidMilitar.setText("");
                jPassword.setText("");
                jTidMilitar.requestFocus();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao autenticar:" + ex.getMessage());
        }

    }

    private void lista() {
        List<Equipamento> lista;
        try {
            lista = new EquipamentoDao().listEqpParituclar();
            DefaultTableModel tabela = (DefaultTableModel) jTabela.getModel();
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existe registros");
                tabela.setNumRows(0);
            } else {
                tabela.setNumRows(0);
                for (Equipamento e : lista) {
                    tabela.addRow(new Object[]{
                        e.getId(),
                        e.getNome(),
                        e.getSerie(),
                        e.getArma().getArma(),
                        e.getCalibre().getCalibre(),
                        e.getFabricante().getFabricante(),
                        e.getObs(),});
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro ao carregar lista de indisponivel" + ex.getMessage());
        }

    }

    private void removerItem() {

        DefaultTableModel tabela = (DefaultTableModel) jTabela.getModel();

        int linha = jTabela.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um item da tabela");
        } else {
            ItemParticular item = new ItemParticular();

            int id = (int) tabela.getValueAt(linha, 0);
            System.out.println("id" + id);
            FuncaoMilitar armeiro = new FuncaoMilitar();
            armeiro.setId(codigoArmeiro);
            Militar militar = new Militar();
            militar.setId(codigoMilitar);

            item.setId(id);
            item.setArmeiro(armeiro);
            item.setMilitar(militar);

            ItemParticularDao itemdao = new ItemParticularDao();

            try {
                itemdao.Saida(item);
                JOptionPane.showMessageDialog(null, "ARMAMENTO ENTREGUE");
                tabela.setNumRows(0);
                jBentregar.setEnabled(true);
                jTidMilitar.setText("");
                jPassword.setText("");
                jTidMilitar.requestFocus();
            } catch (Exception ex) {
                Logger.getLogger(TlSaidaEqpParticular.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Status;
    private javax.swing.ButtonGroup TipoEquipamento;
    private javax.swing.JButton jBautenticar;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JToggleButton jBcancelarBiometria;
    private javax.swing.JButton jBentregar;
    private javax.swing.JButton jBlerBiometria;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabela;
    private javax.swing.JTextField jTidMilitar;
    // End of variables declaration//GEN-END:variables
}
