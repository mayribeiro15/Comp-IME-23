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
import servicos.Maiusculas;
import servicos.Relatorio;

/**
 *
 * @author Asus
 */
public class TlHistoricoEquipamento extends javax.swing.JDialog {

    public TlHistoricoEquipamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTbusca.setDocument(new Maiusculas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TipoBusca = new javax.swing.ButtonGroup();
        jTbusca = new javax.swing.JTextField();
        jLabelLogin = new javax.swing.JLabel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        jLstatus1 = new javax.swing.JLabel();
        jRadioNome = new javax.swing.JRadioButton();
        jRadioSerie = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico Equipamento");
        setResizable(false);

        jTbusca.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTbusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTbuscaActionPerformed(evt);
            }
        });

        jLabelLogin.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelLogin.setText("Nome / Nº Série");

        texto1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        texto1.setText("Informe o número de série ou o nome do equipamento ");

        texto2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        texto2.setText("para verificar o histórico de cautelas.");

        jLstatus1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLstatus1.setText("Tipo de busca:");

        TipoBusca.add(jRadioNome);
        jRadioNome.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioNome.setText("Nome");

        TipoBusca.add(jRadioSerie);
        jRadioSerie.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioSerie.setText("Nº Série");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto1)
                            .addComponent(texto2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLstatus1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioNome)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioSerie)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(texto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLstatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioNome)
                        .addComponent(jRadioSerie)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogin)
                    .addComponent(jTbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTbuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTbuscaActionPerformed
        String busca = jTbusca.getText();
        Relatorio rl = new Relatorio();
        if (getBotao().equals("Nome")) {
            try {
                dispose();
                rl.historicoEquipamentoNome(busca);
                
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "ERRO AO GERAR RELÓRIO");
                Logger.getLogger(TlHistoricoEquipamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                dispose();
                rl.historicoEquipamentoSerie(busca);
              
                                
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "ERRO AO GERAR RELÓRIO");
                Logger.getLogger(TlHistoricoEquipamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jTbuscaActionPerformed

    private String getBotao() {
        String tipo = "Nome";
        if (jRadioSerie.isSelected()) {
            tipo = "Serie";
        }

        return tipo;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup TipoBusca;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLstatus1;
    private javax.swing.JRadioButton jRadioNome;
    private javax.swing.JRadioButton jRadioSerie;
    private javax.swing.JTextField jTbusca;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    // End of variables declaration//GEN-END:variables
}
