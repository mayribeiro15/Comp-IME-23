/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_TelaCadastro;

import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.bean.Arma;
import model.bean.Equipamento;
import model.bean.Calibre;
import model.bean.Categoria;
import model.bean.Fabricante;
import model.bean.FuncaoMilitar;
import model.dao.ArmaDao;
import model.dao.CalibreDao;
import model.dao.CategoriaDao;
import model.dao.EquipamentoDao;
import model.dao.FabricanteDao;
import servicos.Maiusculas;
import servicos.Numero;

/**
 *
 * @author ASUS
 */
public class TlCadEquipamento extends javax.swing.JInternalFrame {

    Integer codigoArmeiro;

    public TlCadEquipamento(int codigoArmeiro) {
        initComponents();
        listarFabricante(jComboBoxfabricante); // chamada do metodo listarFabricante na inicialização da tela
        listarArma(jComboBoxarma);// chamada do metodo listarArma na inicialização da tela
        listarCalibres(jComboBoxcalibre);// chamada do metodo listarCalibre na inicialização da tela
        listarBaioneta(jComboBoxBaioneta);// chamada do metodo listarCalibre na inicialização da tela
        listarCategoria(jComboBoxcategoria);
        jTextnome.setDocument(new Maiusculas());
        jTextobservacao.setDocument(new Maiusculas());
        jTextquantidade.setDocument(new Numero());
        jTextserie.setDocument(new Maiusculas());
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
        jRadioButtonarmamento = new javax.swing.JRadioButton();
        jRadioButtonacessorio = new javax.swing.JRadioButton();
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
        jLabelselecioneAcessorio = new javax.swing.JLabel();
        jComboBoxarma = new javax.swing.JComboBox<>();
        jComboBoxBaioneta = new javax.swing.JComboBox<>();
        jButtonadcAcessorio = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtondisponivel = new javax.swing.JRadioButton();
        jRadioButtonindisponivel = new javax.swing.JRadioButton();
        jRadioButtonRecolhido = new javax.swing.JRadioButton();
        jLabelobservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextobservacao = new javax.swing.JTextArea();
        jLabelselecioneCategoria = new javax.swing.JLabel();
        jComboBoxcategoria = new javax.swing.JComboBox<>();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setEnabled(false);
        setFrameIcon(null);
        setVisible(true);

        jBsalvar.setBackground(new java.awt.Color(75, 184, 75));
        jBsalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/salvar.png"))); // NOI18N
        jBsalvar.setText("SALVAR");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados Equipamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("SELECIONE O TIPO DE EQUIPAMENTO QUE DESEJA CADASTRAR");

        TipoEquipamento.add(jRadioButtonarmamento);
        jRadioButtonarmamento.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtonarmamento.setText("ARMAMENTO ");
        jRadioButtonarmamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonarmamentoActionPerformed(evt);
            }
        });

        TipoEquipamento.add(jRadioButtonacessorio);
        jRadioButtonacessorio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtonacessorio.setText("ACESSÓRIO");
        jRadioButtonacessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonacessorioActionPerformed(evt);
            }
        });

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

        jLabelselecioneAcessorio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelselecioneAcessorio.setText("Selecione Baioneta:");

        jComboBoxarma.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxarma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha Arma" }));
        jComboBoxarma.setEnabled(false);

        jComboBoxBaioneta.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxBaioneta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha Baioneta" }));
        jComboBoxBaioneta.setToolTipText("");
        jComboBoxBaioneta.setEnabled(false);

        jButtonadcAcessorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonadcAcessorio.setText("+");
        jButtonadcAcessorio.setEnabled(false);
        jButtonadcAcessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonadcAcessorioActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Status:");

        Status.add(jRadioButtondisponivel);
        jRadioButtondisponivel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtondisponivel.setText("DISPONÍVEL");
        jRadioButtondisponivel.setEnabled(false);

        Status.add(jRadioButtonindisponivel);
        jRadioButtonindisponivel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtonindisponivel.setText("INDISPONÍVEL");
        jRadioButtonindisponivel.setEnabled(false);

        Status.add(jRadioButtonRecolhido);
        jRadioButtonRecolhido.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtonRecolhido.setText("RECOLHIDO");
        jRadioButtonRecolhido.setEnabled(false);

        jLabelobservacao.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelobservacao.setText("Observação:");

        jTextobservacao.setColumns(20);
        jTextobservacao.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTextobservacao.setRows(5);
        jTextobservacao.setEnabled(false);
        jScrollPane1.setViewportView(jTextobservacao);

        jLabelselecioneCategoria.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelselecioneCategoria.setText("Selecione Categoria:");

        jComboBoxcategoria.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha Categoria" }));
        jComboBoxcategoria.setEnabled(false);

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
                                .addGap(10, 10, 10)
                                .addComponent(jLabelobservacao)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelselecioneArma)
                                            .addComponent(jLabelselecioneFabricante)
                                            .addComponent(jLabelselecioneCategoria))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxfabricante, 0, 390, Short.MAX_VALUE)
                                            .addComponent(jComboBoxarma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxcategoria, 0, 390, Short.MAX_VALUE))
                                        .addGap(80, 80, 80)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelselecioneCalibre)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBoxcalibre, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelselecioneAcessorio)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxBaioneta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelnome)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextnome, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabelserie)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextserie, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jRadioButtonarmamento)
                                                .addGap(72, 72, 72)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelquantidade)
                                            .addComponent(jRadioButtonacessorio))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48)
                                .addComponent(jButtonadcAcessorio))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtondisponivel)
                                .addGap(35, 35, 35)
                                .addComponent(jRadioButtonindisponivel)
                                .addGap(33, 33, 33)
                                .addComponent(jRadioButtonRecolhido)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonarmamento)
                    .addComponent(jRadioButtonacessorio))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelnome)
                    .addComponent(jTextnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelserie)
                    .addComponent(jTextserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelselecioneFabricante)
                    .addComponent(jComboBoxfabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelselecioneCalibre)
                    .addComponent(jComboBoxcalibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelselecioneArma)
                    .addComponent(jComboBoxarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelselecioneAcessorio)
                    .addComponent(jComboBoxBaioneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonadcAcessorio))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelselecioneCategoria)
                    .addComponent(jComboBoxcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButtondisponivel)
                    .addComponent(jRadioButtonindisponivel)
                    .addComponent(jRadioButtonRecolhido))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelobservacao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jBsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBsalvar)
                    .addComponent(jBcancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //metodo para cadastar os armamentos
    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed
        salvar();

    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jButtonadcAcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonadcAcessorioActionPerformed
        TlCadBaioneta tl = new TlCadBaioneta(codigoArmeiro);
        tl.setVisible(true);
        listarBaioneta(jComboBoxBaioneta);
    }//GEN-LAST:event_jButtonadcAcessorioActionPerformed

    private void jRadioButtonacessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonacessorioActionPerformed
        limparCampo();
        jTextnome.grabFocus();
        jTextnome.setEnabled(true);
        jTextobservacao.setEnabled(true);
        jTextquantidade.setEnabled(true);
        jTextquantidade.setText("1");
        jTextserie.setEnabled(true);
        jBsalvar.setEnabled(true);
        jRadioButtondisponivel.setEnabled(true);
        jRadioButtonindisponivel.setEnabled(true);
        jRadioButtonRecolhido.setEnabled(true);
        jButtonadcAcessorio.setEnabled(false);
        jComboBoxBaioneta.setEnabled(false);
        jComboBoxarma.setEnabled(false);
        jComboBoxfabricante.setEnabled(false);
        jComboBoxcalibre.setEnabled(false);
        jComboBoxcategoria.setEnabled(true);


    }//GEN-LAST:event_jRadioButtonacessorioActionPerformed

    private void jRadioButtonarmamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonarmamentoActionPerformed
        limparCampo();
        jTextserie.grabFocus();
        jTextnome.setEnabled(false);
        jTextnome.setText("ARMAMENTO");
        jTextobservacao.setEnabled(true);
        jTextquantidade.setEnabled(false);
        jTextquantidade.setText("1");
        jTextserie.setEnabled(true);
        jBsalvar.setEnabled(true);

        jRadioButtondisponivel.setEnabled(true);
        jRadioButtonindisponivel.setEnabled(true);
        jRadioButtonRecolhido.setEnabled(true);

        jButtonadcAcessorio.setEnabled(true);

        jComboBoxBaioneta.setEnabled(true);
        listarBaioneta(jComboBoxBaioneta);
        jComboBoxarma.setEnabled(true);
        jComboBoxfabricante.setEnabled(true);
        jComboBoxcalibre.setEnabled(true);
        jComboBoxcategoria.setEnabled(true);

    }//GEN-LAST:event_jRadioButtonarmamentoActionPerformed

    private void listarCategoria(JComboBox combo) {
        try {
            List<Categoria> lista = new CategoriaDao().listEntidade();
            for (Categoria c : lista) {
                combo.addItem(c);
            }
        } catch (Exception ex) {
            Logger.getLogger(TlCadEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    private void listarBaioneta(JComboBox combo) {

        DefaultComboBoxModel jcomobo = (DefaultComboBoxModel) combo.getModel();

        jcomobo.removeAllElements();
        jcomobo.setSelectedItem("Escolha Baioneta");

        try {

            List<Equipamento> lista = new EquipamentoDao().listBaioneta();

            for (Equipamento e : lista) {

                combo.addItem(e);

            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar baioneta na tela:" + ex.getMessage());

        }

    }

    private String tipoEquipamento() {
        String tipo = "AR";

        if (jRadioButtonarmamento.isSelected()) {
            return tipo;
        } else {
            return tipo = "AC";
        }
    }

    private String StatusEquipamento() {
        String status = "DISPONIVEL";
        if (jRadioButtondisponivel.isSelected()) {
            return status;
        } else if (jRadioButtonindisponivel.isSelected()) {
            return status = "INDISPONIVEL";
        } else {
            return status = "RECOLHIDO";
        }
    }

    private void salvar() {
        Equipamento eqp = new Equipamento();
        EquipamentoDao eqpDAo = new EquipamentoDao();
        
        if (tipoEquipamento().equals("AC")) {
            if (jComboBoxcategoria.getSelectedIndex() > 0) {
                Categoria categoria = (Categoria) jComboBoxcategoria.getSelectedItem();
                eqp.setCategoria(categoria);
            } else {
                JOptionPane.showMessageDialog(null, "SELECIONE CATEGORIA");
                return;
            }
            if (jTextobservacao.getText().equals("")) {
                eqp.setObs(null);
            } else {
                eqp.setObs(jTextobservacao.getText());
            }
            if (jTextserie.getText().equals("")) {
                eqp.setSerie(null);
            } else {
                eqp.setSerie(jTextserie.getText());
            }
            eqp.setTipo(tipoEquipamento());
            eqp.setNome(jTextnome.getText());
            eqp.setQtd(Integer.parseInt(jTextquantidade.getText()));
            eqp.setStatus(StatusEquipamento());
            FuncaoMilitar armeiro = new FuncaoMilitar();
            armeiro.setId(codigoArmeiro);
            eqp.setArmeiro(armeiro);
            try {
                if (validarCampoAcessorio() == true) {
                    eqpDAo.cadastrarAcessorio(eqp);
                    JOptionPane.showMessageDialog(null, " CADASTRADO ");
                    dispose();

                }
            } catch (Exception ex) {
                System.out.println("Erro ao cadastrar equipamento " + ex.getMessage());
            }

        } else {

            if (jComboBoxcategoria.getSelectedIndex() > 0) {
                Categoria categoria = (Categoria) jComboBoxcategoria.getSelectedItem();
                eqp.setCategoria(categoria);
            } else {
                JOptionPane.showMessageDialog(null, "SELECIONE CATEGORIA");

            }

            if (jComboBoxarma.getSelectedIndex() > 0) {
                Arma arm = (Arma) jComboBoxarma.getSelectedItem();
                eqp.setArma(arm);
            } else {
                JOptionPane.showMessageDialog(null, "SELECIONE ARMA");

            }

            if (jComboBoxfabricante.getSelectedIndex() > 0) {
                Fabricante fab = (Fabricante) jComboBoxfabricante.getSelectedItem();
                eqp.setFabricante(fab);
            } else {
                JOptionPane.showMessageDialog(null, "SELECIONE FABRICANTE");
            }

            if (jComboBoxcalibre.getSelectedIndex() > 0) {
                Calibre cab = (Calibre) jComboBoxcalibre.getSelectedItem();
                eqp.setCalibre(cab);
            } else {
                JOptionPane.showMessageDialog(null, "SELECIONE CALIBRE ");
            }
            if (jTextobservacao.getText().equals("")) {
                eqp.setObs(null);
            } else {
                eqp.setObs(jTextobservacao.getText());
            }

            if (jComboBoxBaioneta.getSelectedIndex() >= 0) {
                Equipamento bai = (Equipamento) jComboBoxBaioneta.getSelectedItem();
                eqp.setAcessorio(bai);
                eqp.setNome(jTextnome.getText());
                eqp.setTipo(tipoEquipamento());
                eqp.setSerie(jTextserie.getText());
                eqp.setQtd(Integer.parseInt(jTextquantidade.getText()));
                eqp.setStatus(StatusEquipamento());
                FuncaoMilitar armeiro = new FuncaoMilitar();
                armeiro.setId(codigoArmeiro);
                eqp.setArmeiro(armeiro);
                System.out.println(bai.toString());
                try {
                    if (validarCampoArmamento() == true) {
                        //controle.cadastrarComBaioneta(eqp);
                        eqpDAo.cadastrarArmamentoComBaioneta(eqp);
                        JOptionPane.showMessageDialog(null, " CADASTRADO ");
                        dispose();
                        limparCampoArmamento();

                    }

                } catch (Exception ex) {
                    System.out.println("Erro ao cadastrar sem baioneta : " + ex.getMessage());
                }
            } else {
                eqp.setAcessorio(null);
                eqp.setNome(jTextnome.getText());
                eqp.setTipo(tipoEquipamento());
                eqp.setSerie(jTextserie.getText());
                eqp.setQtd(Integer.parseInt(jTextquantidade.getText()));
                eqp.setStatus(StatusEquipamento());
                FuncaoMilitar armeiro = new FuncaoMilitar();
                armeiro.setId(codigoArmeiro);
                eqp.setArmeiro(armeiro);
                try {
                    if (validarCampoArmamento() == true) {
                        //controle.cadastrarSemBaioneta(eqp);
                        eqpDAo.cadastrarArmamentoSemBaioneta(eqp);
                        JOptionPane.showMessageDialog(null, " CADASTRADO ");
                        dispose();
                        limparCampoArmamento();
                    }
                } catch (Exception ex) {
                    System.out.println("Erro ao cadastrar equipamento sem baioneta" + ex.getMessage());
                }
            }
        }
    }

    private void limparCampo() {
        jTextnome.setText("");
        jTextobservacao.setText("");
        jTextquantidade.setText("");
        jTextserie.setText("");
        jTextquantidade.setText("1");
        listarBaioneta(jComboBoxBaioneta);
        jComboBoxcalibre.setSelectedIndex(0);
        jComboBoxarma.setSelectedIndex(0);
        jComboBoxfabricante.setSelectedIndex(0);
        jComboBoxcategoria.setSelectedIndex(0);
        jRadioButtondisponivel.isSelected();

    }

    private void limparCampoArmamento() {
        jTextnome.setText("ARMAMENTO");
        jTextobservacao.setText("");
        jTextquantidade.setText("");
        jTextserie.setText("");
        jTextquantidade.setText("1");
        listarBaioneta(jComboBoxBaioneta);
        jComboBoxcalibre.setSelectedIndex(0);
        jComboBoxarma.setSelectedIndex(0);
        jComboBoxfabricante.setSelectedIndex(0);
        jComboBoxcategoria.setSelectedIndex(0);
        jRadioButtondisponivel.isSelected();
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

    private boolean validarCampoAcessorio() {
        if (jTextnome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório");
            jLabelnome.setForeground(Color.RED);
            jTextnome.requestFocus();
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
    private javax.swing.JButton jBcancelar;
    private javax.swing.JButton jBsalvar;
    private javax.swing.JButton jButtonadcAcessorio;
    private javax.swing.JComboBox<String> jComboBoxBaioneta;
    private javax.swing.JComboBox<String> jComboBoxarma;
    private javax.swing.JComboBox<String> jComboBoxcalibre;
    private javax.swing.JComboBox<String> jComboBoxcategoria;
    private javax.swing.JComboBox<String> jComboBoxfabricante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelnome;
    private javax.swing.JLabel jLabelobservacao;
    private javax.swing.JLabel jLabelquantidade;
    private javax.swing.JLabel jLabelselecioneAcessorio;
    private javax.swing.JLabel jLabelselecioneArma;
    private javax.swing.JLabel jLabelselecioneCalibre;
    private javax.swing.JLabel jLabelselecioneCategoria;
    private javax.swing.JLabel jLabelselecioneFabricante;
    private javax.swing.JLabel jLabelserie;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonRecolhido;
    private javax.swing.JRadioButton jRadioButtonacessorio;
    private javax.swing.JRadioButton jRadioButtonarmamento;
    private javax.swing.JRadioButton jRadioButtondisponivel;
    private javax.swing.JRadioButton jRadioButtonindisponivel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextnome;
    private javax.swing.JTextArea jTextobservacao;
    private javax.swing.JTextField jTextquantidade;
    private javax.swing.JTextField jTextserie;
    // End of variables declaration//GEN-END:variables
}
