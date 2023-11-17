/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ControllerMilitar;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.bean.Arma;
import model.bean.Equipamento;
import model.bean.Calibre;
import model.bean.Fabricante;
import model.bean.FuncaoMilitar;
import model.bean.ItemParticular;
import model.bean.Militar;
import model.dao.ArmaDao;
import model.dao.CalibreDao;
import model.dao.EquipamentoDao;
import model.dao.FabricanteDao;
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
public class TlCadEqpParticular extends javax.swing.JInternalFrame {

    Integer codigoArmeiro;
    CisBiox biox = new CisBiox();
    private byte[] digital;
    List<Militar> listabiometria;
    Integer codigoMilitar;

    public TlCadEqpParticular(int codigoArmeiro) {
        initComponents();
        setTitle("RECEBIMENTO ARMAMENTO PARTICULAR");
        listarFabricante(jComboBoxfabricante); // chamada do metodo listarFabricante na inicialização da tela
        listarArma(jComboBoxarma);// chamada do metodo listarArma na inicialização da tela
        listarCalibres(jComboBoxcalibre);// chamada do metodo listarCalibre na inicialização da tela
        jTextnome.setDocument(new Maiusculas());
        jTextobservacao.setDocument(new Maiusculas());
        jTextquantidade.setDocument(new Numero());
        jTextserie.setDocument(new Maiusculas());
        jTlogin.setDocument(new LimitaTexto(10));
        jPassword.setDocument(new Numero());
        this.codigoArmeiro = codigoArmeiro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Status = new javax.swing.ButtonGroup();
        TipoEquipamento = new javax.swing.ButtonGroup();
        jBsalvar = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelnome = new javax.swing.JLabel();
        jTextnome = new javax.swing.JTextField();
        jLabelserie = new javax.swing.JLabel();
        jTextserie = new javax.swing.JTextField();
        jLabelquantidade = new javax.swing.JLabel();
        jTextquantidade = new javax.swing.JTextField();
        jLabelselecioneFabricante = new javax.swing.JLabel();
        jComboBoxfabricante = new javax.swing.JComboBox<>();
        jLabelselecioneCalibre = new javax.swing.JLabel();
        jComboBoxcalibre = new javax.swing.JComboBox<>();
        jLabelselecioneArma = new javax.swing.JLabel();
        jComboBoxarma = new javax.swing.JComboBox<>();
        jLabelobservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextobservacao = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabelLogin = new javax.swing.JLabel();
        jTlogin = new javax.swing.JTextField();
        jBautenticar = new javax.swing.JButton();
        jPassword = new javax.swing.JPasswordField();
        jLabelSenha = new javax.swing.JLabel();
        jBlerBiometria = new javax.swing.JButton();
        jBcancelarBiometria = new javax.swing.JToggleButton();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setEnabled(false);
        setFrameIcon(null);
        setVisible(true);

        jBsalvar.setBackground(new java.awt.Color(75, 184, 75));
        jBsalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/salvar.png"))); // NOI18N
        jBsalvar.setText("REGISTRAR");
        jBsalvar.setEnabled(false);
        jBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarActionPerformed(evt);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados Equipamento Particular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("SELECIONE O TIPO DE EQUIPAMENTO PARTICULAR QUE DESEJA CADASTRAR");

        jLabelnome.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelnome.setText("Nome:");

        jTextnome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextnome.setEnabled(false);

        jLabelserie.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelserie.setText("Nº Série:");

        jTextserie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextserie.setEnabled(false);

        jLabelquantidade.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelquantidade.setText("Quantidade:");

        jTextquantidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextquantidade.setEnabled(false);

        jLabelselecioneFabricante.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelselecioneFabricante.setText("Selecione Fabricante:");

        jComboBoxfabricante.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxfabricante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha Fabricante" }));
        jComboBoxfabricante.setEnabled(false);

        jLabelselecioneCalibre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelselecioneCalibre.setText("Selecione Calibre:");

        jComboBoxcalibre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxcalibre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha Calibre" }));
        jComboBoxcalibre.setEnabled(false);

        jLabelselecioneArma.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelselecioneArma.setText("Selecione Arma:");

        jComboBoxarma.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxarma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha Arma" }));
        jComboBoxarma.setEnabled(false);

        jLabelobservacao.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelobservacao.setText("Observação:");

        jTextobservacao.setColumns(20);
        jTextobservacao.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTextobservacao.setRows(5);
        jTextobservacao.setEnabled(false);
        jScrollPane1.setViewportView(jTextobservacao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelobservacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelnome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextnome, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jLabelserie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextserie, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabelquantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelselecioneFabricante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxfabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(jLabelselecioneCalibre)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxcalibre, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelselecioneArma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxarma, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelnome)
                    .addComponent(jTextnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelserie)
                    .addComponent(jTextserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelselecioneFabricante)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxfabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelselecioneCalibre)
                        .addComponent(jComboBoxcalibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelselecioneArma)
                        .addComponent(jComboBoxarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelobservacao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Militar Responsável", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        jLabelLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelLogin.setText("LOGIN:");

        jTlogin.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTlogin.setEnabled(false);
        jTlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTloginActionPerformed(evt);
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
                .addContainerGap(241, Short.MAX_VALUE)
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
                    .addComponent(jTlogin, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jPassword))
                .addGap(18, 18, 18)
                .addComponent(jBautenticar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBcancelarBiometria)
                .addGap(413, 413, 413))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBcancelarBiometria)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelLogin)
                            .addComponent(jTlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jBlerBiometria)
                    .addComponent(jBautenticar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jBcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(jBsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBsalvar)
                    .addComponent(jBcancelar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //metodo para cadastar os armamentos
    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed
        salvar();
    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        biox.finalizar();
        dispose();
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jTloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTloginActionPerformed
        jPassword.requestFocus();
    }//GEN-LAST:event_jTloginActionPerformed

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
        jBcancelarBiometria.setEnabled(false);
        jTlogin.setEnabled(true);
        jPassword.setEnabled(true);
        jTlogin.requestFocus();
    }//GEN-LAST:event_jBcancelarBiometriaActionPerformed

    private void jPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyReleased
        if (jPassword.getPassword().length > 6) {
            JOptionPane.showMessageDialog(this, "APENAS 6 NÚMEROS");
            evt.consume();
            jPassword.setText("");
            jPassword.grabFocus();
        }
    }//GEN-LAST:event_jPasswordKeyReleased

    private void listarFabricante(JComboBox combo) {
        try {
            List<Fabricante> lista = new FabricanteDao().listEntidade();
            for (Fabricante f : lista) {
                combo.addItem(f);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar fabricante na tela:" + ex.getMessage());
        }
    }

    private void listarArma(JComboBox combo) {

        try {
            List<Arma> lista = new ArmaDao().listEntidade();
            for (Arma a : lista) {
                combo.addItem(a);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar arma na tela:" + ex.getMessage());
        }
    }

    private void listarCalibres(JComboBox combo) {
        try {
            List<Calibre> lista = new CalibreDao().listEntidade();
            for (Calibre c : lista) {
                combo.addItem(c);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar calibre na tela:" + ex.getMessage());
        }
    }

    private void captura() {

        new Thread() {
            public void run() {
                try {
                    int iRetorno = biox.iniciar();
                    if (iRetorno != 1) {
                        JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
                        return;
                    } else if (biox.getResultado() != 1) {
                        biox.finalizar();
                        return;
                    }
                    digital = biox.capturarDigital();
                    biox.finalizar();
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
                    JOptionPane.showMessageDialog(null, militar.getLogin() + " \n AUTENTICADO");
                    codigoMilitar = militar.getId();
                    jTextnome.setEnabled(false);
                    jTextnome.setText("ARMAMENTO");
                    jTextobservacao.setEnabled(true);
                    jTextquantidade.setEnabled(false);
                    jTextquantidade.setText("1");
                    jTextserie.setEnabled(true);
                    jBsalvar.setEnabled(true);
                    jComboBoxarma.setEnabled(true);
                    jComboBoxcalibre.setEnabled(true);
                    jComboBoxfabricante.setEnabled(true);

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
        String login = jTlogin.getText();
        String senha = jPassword.getText();
        try {
            boolean mil = new ControllerMilitar().autenticarMilitar(login, senha);
            if (mil == true) {
                try {
                    Militar mili = new ControllerMilitar().pesquisar(login);
                    if (mili != null) {
                        codigoMilitar = mili.getId();
                        JOptionPane.showMessageDialog(null, mili.getLogin() + "\n AUTENTICADO");
                        jTextnome.setEnabled(false);
                        jTextnome.setText("ARMAMENTO");
                        jTextobservacao.setEnabled(true);
                        jTextquantidade.setEnabled(false);
                        jTextquantidade.setText("1");
                        jTextserie.setEnabled(true);
                        jBsalvar.setEnabled(true);
                        jComboBoxarma.setEnabled(true);
                        jComboBoxcalibre.setEnabled(true);
                        jComboBoxfabricante.setEnabled(true);

                    }
                } catch (Exception ex) {
                    System.out.println("Erro ao pesquisar " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "LOGIN OU SENHA INCORRETO");
                jTlogin.setText("");
                jPassword.setText("");
                jTlogin.requestFocus();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao autenticar:" + ex.getMessage());
        }

    }

    private void salvar() {
        Equipamento eqp = new Equipamento();
        ItemParticular item = new ItemParticular();

        if (jComboBoxarma.getSelectedIndex() > 0) {
            Arma arm = (Arma) jComboBoxarma.getSelectedItem();
            eqp.setArma(arm);
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE ARMA");
            return;
        }

        if (jComboBoxfabricante.getSelectedIndex() > 0) {
            Fabricante fab = (Fabricante) jComboBoxfabricante.getSelectedItem();
            eqp.setFabricante(fab);
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE FABRICANTE");
            return;
        }

        if (jComboBoxcalibre.getSelectedIndex() > 0) {
            Calibre cab = (Calibre) jComboBoxcalibre.getSelectedItem();
            eqp.setCalibre(cab);
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE CALIBRE ");
            return;
        }
        if (jTextobservacao.getText().equals("")) {
            eqp.setObs(null);
        } else {
            eqp.setObs(jTextobservacao.getText());
        }

        eqp.setNome(jTextnome.getText());
        eqp.setTipo("AR");
        eqp.setSerie(jTextserie.getText());
        eqp.setQtd(Integer.parseInt(jTextquantidade.getText()));

        FuncaoMilitar armeiro = new FuncaoMilitar();
        armeiro.setId(codigoArmeiro);
        eqp.setArmeiro(armeiro);

        Militar militar = new Militar();
        militar.setId(codigoMilitar);

        try {
            if (validarCampoArmamento() == true) {
                new EquipamentoDao().inserirArmamentoParticular(eqp);

                int id = new EquipamentoDao().getIdEquipamento();

                Equipamento particular = new Equipamento();
                particular.setId(id);
                item.setArmeiro(armeiro);
                item.setEquipamento(particular);
                item.setMilitar(militar);
                new ItemParticularDao().Cadastrar(item);
                JOptionPane.showMessageDialog(null, " CADASTRADO ");
                dispose();
            }
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar equipamento  particular: " + ex.getMessage());
        }
    }

    private void limparCampoArmamento() {
        jTextnome.setText("");
        jTextobservacao.setText("");
        jTextquantidade.setText("");
        jTextserie.setText("");
        jTextquantidade.setText("");
        jComboBoxcalibre.setSelectedIndex(0);
        jComboBoxarma.setSelectedIndex(0);
        jComboBoxfabricante.setSelectedIndex(0);

        jTextnome.setEnabled(false);
        jTextobservacao.setEnabled(false);
        jTextquantidade.setEnabled(false);
        jTextserie.setEnabled(false);
        jTextquantidade.setEnabled(false);
        jComboBoxcalibre.setEnabled(false);
        jComboBoxarma.setEnabled(false);
        jComboBoxfabricante.setEnabled(false);

    }

    private boolean validarCampoArmamento() {
        if (jTextserie.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório");
            jLabelserie.setForeground(Color.red);
            jTextserie.requestFocus();
            return false;
        }
        if (jTextquantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório");
            jLabelquantidade.setForeground(Color.RED);
            jTextquantidade.requestFocus();
            return false;
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Status;
    private javax.swing.ButtonGroup TipoEquipamento;
    private javax.swing.JButton jBautenticar;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JToggleButton jBcancelarBiometria;
    private javax.swing.JButton jBlerBiometria;
    private javax.swing.JButton jBsalvar;
    private javax.swing.JComboBox<String> jComboBoxarma;
    private javax.swing.JComboBox<String> jComboBoxcalibre;
    private javax.swing.JComboBox<String> jComboBoxfabricante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelnome;
    private javax.swing.JLabel jLabelobservacao;
    private javax.swing.JLabel jLabelquantidade;
    private javax.swing.JLabel jLabelselecioneArma;
    private javax.swing.JLabel jLabelselecioneCalibre;
    private javax.swing.JLabel jLabelselecioneFabricante;
    private javax.swing.JLabel jLabelserie;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextnome;
    private javax.swing.JTextArea jTextobservacao;
    private javax.swing.JTextField jTextquantidade;
    private javax.swing.JTextField jTextserie;
    private javax.swing.JTextField jTlogin;
    // End of variables declaration//GEN-END:variables
}
