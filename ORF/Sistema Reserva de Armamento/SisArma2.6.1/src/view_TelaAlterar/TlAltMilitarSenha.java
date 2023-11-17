/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_TelaAlterar;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Categoria;
import model.bean.Equipamento;
import model.bean.FuncaoMilitar;
import model.bean.Militar;
import model.dao.EquipamentoDao;
import model.dao.MilitarDao;
import servicos.Maiusculas;
import servicos.Numero;

/**
 *
 * @author ASUS
 */
public class TlAltMilitarSenha extends javax.swing.JDialog {

    Integer codigoArmeiro;
    Integer codigoOficialDia;
    Integer codigoMilitar;

    public TlAltMilitarSenha(int codigoArmeiro, int codigoOficial, int codigoMilitar) {
        initComponents();
        jPasswordConfimacao.setDocument(new Numero());
        jPasswordsenha.setDocument(new Numero());
        this.codigoArmeiro = codigoArmeiro;
        this.codigoMilitar = codigoMilitar;
        this.codigoOficialDia = codigoOficial;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonsalvar = new javax.swing.JButton();
        jButtoncanelar = new javax.swing.JButton();
        jPasswordsenha = new javax.swing.JPasswordField();
        jLsenha = new javax.swing.JLabel();
        jLconfirmarSenha = new javax.swing.JLabel();
        jPasswordConfimacao = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setIconImages(null);

        jButtonsalvar.setBackground(new java.awt.Color(75, 184, 75));
        jButtonsalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/salvar.png"))); // NOI18N
        jButtonsalvar.setText("SALVAR");
        jButtonsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsalvarActionPerformed(evt);
            }
        });

        jButtoncanelar.setBackground(new java.awt.Color(242, 67, 56));
        jButtoncanelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtoncanelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/cancela32.png"))); // NOI18N
        jButtoncanelar.setText("CANCELAR");
        jButtoncanelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncanelarActionPerformed(evt);
            }
        });

        jPasswordsenha.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPasswordsenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordsenhaKeyReleased(evt);
            }
        });

        jLsenha.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLsenha.setText("Redefinir Senha:");

        jLconfirmarSenha.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLconfirmarSenha.setText("Confirmar Senha:");

        jPasswordConfimacao.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPasswordConfimacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordConfimacaoFocusLost(evt);
            }
        });
        jPasswordConfimacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordConfimacaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLsenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jPasswordsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLconfirmarSenha)
                            .addComponent(jButtoncanelar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonsalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(jPasswordConfimacao))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLsenha)
                    .addComponent(jPasswordsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLconfirmarSenha)
                    .addComponent(jPasswordConfimacao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtoncanelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsalvarActionPerformed
        Militar militar = new Militar();
        militar.setId(codigoMilitar);
        militar.setSenha(jPasswordConfimacao.getText());
        FuncaoMilitar armeiro = new FuncaoMilitar();
        armeiro.setId(codigoArmeiro);
        FuncaoMilitar oficialDia = new FuncaoMilitar();
        oficialDia.setId(codigoOficialDia);
        militar.setIdarmeiro(armeiro);
        militar.setIdoficialDia(oficialDia);
        MilitarDao dao = new MilitarDao();
        try {
            dao.alterarSenha(militar);
            dispose();
            JOptionPane.showMessageDialog(null, "SENHA ALTERADA");

        } catch (Exception ex) {
            Logger.getLogger(TlAltMilitarSenha.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro alteracao senha" + ex.getMessage());
        }

    }//GEN-LAST:event_jButtonsalvarActionPerformed

    private void jButtoncanelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncanelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtoncanelarActionPerformed

    private void jPasswordsenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordsenhaKeyReleased
        if (jPasswordsenha.getPassword().length > 6) {
            JOptionPane.showMessageDialog(this, "APENAS 6 NÚMEROS");
            evt.consume();
            jPasswordsenha.setText("");
            jPasswordsenha.grabFocus();
        }
    }//GEN-LAST:event_jPasswordsenhaKeyReleased

    private void jPasswordConfimacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordConfimacaoFocusLost
        if (jPasswordsenha.getText().equals(jPasswordConfimacao.getText())) {

        } else {
            JOptionPane.showMessageDialog(null, "SENHAS DIFERENTES");
            jPasswordsenha.setText("");
            jPasswordConfimacao.setText("");
            jPasswordsenha.requestFocus();
        }
    }//GEN-LAST:event_jPasswordConfimacaoFocusLost

    private void jPasswordConfimacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordConfimacaoKeyReleased
        if (jPasswordConfimacao.getPassword().length > 6) {
            JOptionPane.showMessageDialog(this, "APENAS 6 NÚMEROS");
            evt.consume();
            jPasswordConfimacao.setText("");
            jPasswordConfimacao.grabFocus();
        }
    }//GEN-LAST:event_jPasswordConfimacaoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtoncanelar;
    private javax.swing.JButton jButtonsalvar;
    private javax.swing.JLabel jLconfirmarSenha;
    private javax.swing.JLabel jLsenha;
    private javax.swing.JPasswordField jPasswordConfimacao;
    private javax.swing.JPasswordField jPasswordsenha;
    // End of variables declaration//GEN-END:variables
}
