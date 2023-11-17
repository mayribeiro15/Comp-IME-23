/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_TelaPesq;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.ItemParticular;
import model.dao.ItemParticularDao;

/**
 *
 * @author Asus
 */
public class TlPesqPartEntregue extends javax.swing.JInternalFrame {

    int contador = 0;

    public TlPesqPartEntregue() {
        initComponents();
        setTitle("Pesquisar Armamento Particular");
        lista();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabelaPesquisaCautela = new javax.swing.JTable();
        jButtoncanelar2 = new javax.swing.JButton();
        jLTotal = new javax.swing.JLabel();
        jTtotal = new javax.swing.JTextField();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Armamento Particular Entregue", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        jTabelaPesquisaCautela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabelaPesquisaCautela.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTabelaPesquisaCautela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Armeiro", "Equipamento", "Série", "Arma", "Fabricante", "Calibre", "Data", "Responsavel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaPesquisaCautela.setToolTipText("");
        jTabelaPesquisaCautela.setRowHeight(22);
        jTabelaPesquisaCautela.setRowMargin(5);
        jTabelaPesquisaCautela.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTabelaPesquisaCautela);
        if (jTabelaPesquisaCautela.getColumnModel().getColumnCount() > 0) {
            jTabelaPesquisaCautela.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtoncanelar2.setBackground(new java.awt.Color(242, 67, 56));
        jButtoncanelar2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtoncanelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/cancela32.png"))); // NOI18N
        jButtoncanelar2.setText("CANCELAR");
        jButtoncanelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncanelar2ActionPerformed(evt);
            }
        });

        jLTotal.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLTotal.setText("TOTAL:");

        jTtotal.setEditable(false);
        jTtotal.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jTtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTtotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtoncanelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtoncanelar2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtoncanelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncanelar2ActionPerformed
        dispose();

    }//GEN-LAST:event_jButtoncanelar2ActionPerformed

    private void lista() {
        String status = "ENTREGUE";
        List<ItemParticular> lista;
        try {
            lista = new ItemParticularDao().listporSituacao(status);
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO MOMENTO NÃO EXISTE \n EQUIPAMENTO PARTICULAR ENTREGUE ");
               } else {
                DefaultTableModel tabela = (DefaultTableModel) jTabelaPesquisaCautela.getModel();
                tabela.setNumRows(0);
                contador = 0;
                for (ItemParticular i : lista) {
                    tabela.addRow(new Object[]{
                        i.getArmeiroSaida(),
                        i.getEquipamento().getNome(),
                        i.getEquipamento().getSerie(),
                        i.getEquipamento().getArma().getArma(),
                        i.getEquipamento().getFabricante().getFabricante(),
                        i.getEquipamento().getCalibre().getCalibre(),
                        i.getDatasaida(),
                        i.getResponsavelSaida().getLogin(),
                    });
                    contador++;
                    jTtotal.setText(String.valueOf(contador));
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro ao carregar lista de indisponivel" + ex.getMessage());
        }
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtoncanelar2;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTabelaPesquisaCautela;
    private javax.swing.JTextField jTtotal;
    // End of variables declaration//GEN-END:variables
}
