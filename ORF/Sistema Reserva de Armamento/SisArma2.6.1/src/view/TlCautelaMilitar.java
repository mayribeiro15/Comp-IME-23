/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import servicos.LimitaTexto;
import servicos.Relatorio;

/**
 *
 * @author Asus
 */
public class TlCautelaMilitar extends javax.swing.JDialog {

    public TlCautelaMilitar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTidentidade.setDocument(new LimitaTexto(10));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTidentidade = new javax.swing.JTextField();
        jLabelLogin = new javax.swing.JLabel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico Militar");
        setResizable(false);

        jTidentidade.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTidentidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidentidadeActionPerformed(evt);
            }
        });

        jLabelLogin.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelLogin.setText("Identidade:");

        texto1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        texto1.setText("Informe a identidade do militar para verificar  ");

        texto2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        texto2.setText("a relação dos equipamentos cautelado.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTidentidade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto1))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(texto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogin)
                    .addComponent(jTidentidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTidentidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTidentidadeActionPerformed
        String identidade = jTidentidade.getText();
        Relatorio rl = new Relatorio();
        try {
            dispose();
            rl.relatorioCautelaMilitar(identidade);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO GERAR RELATÓRIO");
            Logger.getLogger(TlCautelaMilitar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTidentidadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JTextField jTidentidade;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    // End of variables declaration//GEN-END:variables
}
