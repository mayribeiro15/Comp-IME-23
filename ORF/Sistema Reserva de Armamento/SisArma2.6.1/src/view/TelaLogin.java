/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import model.bean.Militar;
import model.dao.MilitarDao;
import servicos.CisBiox;
import servicos.LimitaTexto;
import servicos.Numero;

public class TelaLogin extends javax.swing.JFrame {

    CisBiox biox = new CisBiox();
    private byte[] digital;
    List<Militar> listabiometria;

    public TelaLogin() {
        initComponents();
        setIcon();
        jTlidMilitar.setDocument(new LimitaTexto(10));
        jPassword.setDocument(new Numero());
        jPanelLogin.setVisible(false);
        jBacessar.setVisible(false);
        jBcancelar.setVisible(false);
        captura();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTlidMilitar = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jBacessar = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonCancelarBiomatria = new javax.swing.JButton();
        jButtonLerBiometria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistemas Reserva de Armamentos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("LOGIN:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("SENHA:");

        jTlidMilitar.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N

        jPassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPassword.setToolTipText("");
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

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTlidMilitar, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(jPassword))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTlidMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jBacessar.setBackground(new java.awt.Color(75, 184, 75));
        jBacessar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jBacessar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/login.png"))); // NOI18N
        jBacessar.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        jBacessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBacessarActionPerformed(evt);
            }
        });

        jBcancelar.setBackground(new java.awt.Color(242, 67, 56));
        jBcancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jBcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/cancela_login.png"))); // NOI18N
        jBcancelar.setText("  ");
        jBcancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Sistema Reserva de Armamento  \t");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Versão: 2.6.1");

        jButtonCancelarBiomatria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/cancelar_biometria.png"))); // NOI18N
        jButtonCancelarBiomatria.setBorder(null);
        jButtonCancelarBiomatria.setContentAreaFilled(false);
        jButtonCancelarBiomatria.setFocusPainted(false);
        jButtonCancelarBiomatria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarBiomatriaActionPerformed(evt);
            }
        });

        jButtonLerBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/ler_biometria.png"))); // NOI18N
        jButtonLerBiometria.setBorder(null);
        jButtonLerBiometria.setContentAreaFilled(false);
        jButtonLerBiometria.setFocusPainted(false);
        jButtonLerBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLerBiometriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButtonLerBiometria, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jBacessar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jBcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelarBiomatria, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLerBiometria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelarBiomatria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBacessar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBacessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBacessarActionPerformed
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        jPanelLogin.setCursor(cursor);
        validar();
        cursor = Cursor.getDefaultCursor();
        jPanelLogin.setCursor(cursor);
    }//GEN-LAST:event_jBacessarActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        jPanelLogin.setCursor(cursor);
        validar();
        cursor = Cursor.getDefaultCursor();
        jPanelLogin.setCursor(cursor);
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jButtonCancelarBiomatriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarBiomatriaActionPerformed
        CisBiox dll = new CisBiox();
        dll.cancelarLeitura();
        biox.finalizar();
        jPanelLogin.setVisible(true);
        jBacessar.setVisible(true);
        jBcancelar.setVisible(true);
        jTlidMilitar.requestFocus();
    }//GEN-LAST:event_jButtonCancelarBiomatriaActionPerformed

    private void jButtonLerBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLerBiometriaActionPerformed
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        jPanelLogin.setCursor(cursor);
        captura();
        cursor = Cursor.getDefaultCursor();
        jPanelLogin.setCursor(cursor);

    }//GEN-LAST:event_jButtonLerBiometriaActionPerformed

    private void jPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyReleased
        if (jPassword.getPassword().length > 6) {
            JOptionPane.showMessageDialog(this, "APENAS 6 NÚMEROS");
            evt.consume();
            jPassword.setText("");
            jPassword.grabFocus();
        }
    }//GEN-LAST:event_jPasswordKeyReleased

    private void captura() {
        new Thread() {
            public void run() {
                try {
                    int iRetorno = biox.iniciar();
                    if (iRetorno != 1) {
                        JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
                        jPanelLogin.setVisible(true);
                        jBacessar.setVisible(true);
                        jBcancelar.setVisible(true);
                        jTlidMilitar.requestFocus();

                        // apagar depois
                        // jTlogin.setText("CBNETO");
                        //jPassword.setText("051726");
                        //jPassword.requestFocus();
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

        CisBiox biox2 = new CisBiox();
        MilitarDao mDao = new MilitarDao();
        biox2.iniciar();
        int cod = 0;
        try {
            listabiometria = mDao.digitalArmeiro();
            for (Militar militar : listabiometria) {
                if ((biox2.compararDigital(digital, militar.getDigital())) == 1) {
                    TelaPrincipal tl = new TelaPrincipal(militar);
                    tl.setVisible(true);
                    dispose();
                    cod = 1;
                    break;
                }
            }

            if (cod == 0) {
                for (Militar militar : listabiometria) {
                    if ((biox2.compararDigital(digital, militar.getDigital())) == -2) {
                        JOptionPane.showMessageDialog(null, "SEM PERMISSÃO ");
                        break;
                    }
                }
            }
            biox2.finalizar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "BANCO DESCONECTADO");
            biox2.finalizar();
        }

    }

    private void validar() {
        String login = jTlidMilitar.getText();
        String senha = jPassword.getText();
        MilitarDao mildao = new MilitarDao();
        try {
            Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            jPanelLogin.setCursor(cursor);
            Militar mil = mildao.validarUsuario(login, senha);
            if (mil != null) {
                TelaPrincipal tl = new TelaPrincipal(mil);
                tl.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, " VERIFIQUE LOGIN E SENHA\n VERIFIQUE STATUS DO MILITAR");
                jTlidMilitar.setText("");
                jPassword.setText("");
                jTlidMilitar.requestFocus();
            }
            cursor = Cursor.getDefaultCursor();
            jPanelLogin.setCursor(cursor);

        } catch (SQLException ex) {
            System.out.println("Erro Login" + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TlCautela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBacessar;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JButton jButtonCancelarBiomatria;
    private javax.swing.JButton jButtonLerBiometria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTlidMilitar;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconeSisArma/brasil16.png")));
    }

}
