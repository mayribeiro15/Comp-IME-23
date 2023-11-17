/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ControllerItem;
import Controller.ControllerMilitar;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Cautela;
import model.bean.Destino;
import model.bean.Equipamento;
import model.bean.FuncaoMilitar;
import model.bean.Item;
import model.bean.Militar;
import model.dao.CautelaDao;
import model.dao.DestinoDao;
import model.dao.EquipamentoDao;
import model.dao.MilitarDao;
import servicos.CisBiox;
import servicos.LimitaTexto;
import servicos.Maiusculas;
import servicos.Numero;

public class TlCautela extends javax.swing.JInternalFrame {

    CisBiox biox = new CisBiox();
    private byte[] digital;
    List<Militar> listabiometria;
    List<Item> listaitem;
    Integer codigoArmeiro;
    Integer codigoMilitar;
    Equipamento eqp = new Equipamento();

    public TlCautela(int codigoMilitar) {

        initComponents();
        listarDestino(jComboBoxDestino);
        setTitle("CAUTELA");
        jTlogin.setDocument(new LimitaTexto(10));
        jTBuscaAcessorio.setDocument(new Maiusculas());
        jTBuscaArmamento.setDocument(new Maiusculas());
        jTQuantidadeAcessorio.setDocument(new Maiusculas());
        jPassword.setDocument(new Numero());
        this.codigoArmeiro = codigoMilitar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jBEncerrarrCautela = new javax.swing.JButton();
        jButtoncanelar = new javax.swing.JButton();
        jBremoveritem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelLogin = new javax.swing.JLabel();
        jTlogin = new javax.swing.JTextField();
        jBautenticar = new javax.swing.JButton();
        jLabelNomeCompleto = new javax.swing.JLabel();
        jLabelGraduacao = new javax.swing.JLabel();
        jTNomeCompleto = new javax.swing.JTextField();
        jTGraduacao = new javax.swing.JTextField();
        jLabelSexo = new javax.swing.JLabel();
        jTSexo = new javax.swing.JTextField();
        jLabelGuerra = new javax.swing.JLabel();
        jTGuerra = new javax.swing.JTextField();
        jLabelOM = new javax.swing.JLabel();
        jTOM = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jLabelSenha = new javax.swing.JLabel();
        jBlerBiometria = new javax.swing.JButton();
        jBcancelarBiometria = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelSerieArmamento = new javax.swing.JLabel();
        jRadioButtonSemBaioneta = new javax.swing.JRadioButton();
        jRadioButtonComBaioneta = new javax.swing.JRadioButton();
        jTBuscaArmamento = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTBuscaAcessorio = new javax.swing.JTextField();
        jTQuantidadeAcessorio = new javax.swing.JTextField();
        jLabelBuscaAcessorio = new javax.swing.JLabel();
        jRadioButtonNome = new javax.swing.JRadioButton();
        jRadioButtonSerie = new javax.swing.JRadioButton();
        jLabelQuantidade = new javax.swing.JLabel();
        jLabelQuantidadeDisponível = new javax.swing.JLabel();
        jTQtdDisponivel = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaEquipamento = new javax.swing.JTable();
        jComboBoxDestino = new javax.swing.JComboBox<>();
        jLabelDestino = new javax.swing.JLabel();

        setFrameIcon(null);

        jBEncerrarrCautela.setBackground(new java.awt.Color(75, 184, 75));
        jBEncerrarrCautela.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBEncerrarrCautela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/salvar.png"))); // NOI18N
        jBEncerrarrCautela.setText("  FINALIZAR CAUTELA");
        jBEncerrarrCautela.setEnabled(false);
        jBEncerrarrCautela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEncerrarrCautelaActionPerformed(evt);
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

        jBremoveritem.setBackground(new java.awt.Color(242, 67, 56));
        jBremoveritem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBremoveritem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/lixeira.png"))); // NOI18N
        jBremoveritem.setText("REMOVER ITEM");
        jBremoveritem.setEnabled(false);
        jBremoveritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBremoveritemActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Militar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16))); // NOI18N

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

        jLabelNomeCompleto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelNomeCompleto.setText("NOME COMPLETO:");

        jLabelGraduacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelGraduacao.setText("GRADUAÇÃO:");

        jTNomeCompleto.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTNomeCompleto.setEnabled(false);

        jTGraduacao.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTGraduacao.setEnabled(false);

        jLabelSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelSexo.setText("SEXO:");

        jTSexo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTSexo.setEnabled(false);

        jLabelGuerra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelGuerra.setText("NOME DE GUERRA:");

        jTGuerra.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTGuerra.setEnabled(false);

        jLabelOM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelOM.setText("O M:");

        jTOM.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTOM.setEnabled(false);

        jPassword.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabelSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelGraduacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTGraduacao, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelGuerra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBlerBiometria)
                .addGap(37, 37, 37)
                .addComponent(jBcancelarBiometria)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBautenticar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelOM)
                        .addGap(18, 18, 18)
                        .addComponent(jTOM, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(384, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogin)
                    .addComponent(jTlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBautenticar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBlerBiometria)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNomeCompleto)
                                        .addComponent(jTNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelSexo)
                                        .addComponent(jTSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelGraduacao)
                                        .addComponent(jTGraduacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jBcancelarBiometria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelOM))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelGuerra, jLabelNomeCompleto, jLabelOM});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Armamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16))); // NOI18N

        jLabelSerieArmamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelSerieArmamento.setText("Nº SÉRIE ARMAMENTO:");

        buttonGroup1.add(jRadioButtonSemBaioneta);
        jRadioButtonSemBaioneta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRadioButtonSemBaioneta.setSelected(true);
        jRadioButtonSemBaioneta.setText("SEM BAIONETA");
        jRadioButtonSemBaioneta.setEnabled(false);

        buttonGroup1.add(jRadioButtonComBaioneta);
        jRadioButtonComBaioneta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRadioButtonComBaioneta.setText("COM BAIONETA");
        jRadioButtonComBaioneta.setEnabled(false);

        jTBuscaArmamento.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTBuscaArmamento.setEnabled(false);
        jTBuscaArmamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBuscaArmamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButtonSemBaioneta)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonComBaioneta)
                        .addGap(69, 196, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelSerieArmamento)
                        .addGap(18, 18, 18)
                        .addComponent(jTBuscaArmamento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSemBaioneta)
                    .addComponent(jRadioButtonComBaioneta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSerieArmamento)
                    .addComponent(jTBuscaArmamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(170, 170, 170))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Acessório", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16))); // NOI18N

        jTBuscaAcessorio.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTBuscaAcessorio.setEnabled(false);
        jTBuscaAcessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBuscaAcessorioActionPerformed(evt);
            }
        });

        jTQuantidadeAcessorio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTQuantidadeAcessorio.setEnabled(false);
        jTQuantidadeAcessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTQuantidadeAcessorioActionPerformed(evt);
            }
        });

        jLabelBuscaAcessorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelBuscaAcessorio.setText("BUSCAR ACESSÓRIO POR:");

        buttonGroup2.add(jRadioButtonNome);
        jRadioButtonNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRadioButtonNome.setSelected(true);
        jRadioButtonNome.setText("NOME");
        jRadioButtonNome.setEnabled(false);

        buttonGroup2.add(jRadioButtonSerie);
        jRadioButtonSerie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRadioButtonSerie.setText("Nº SÉRIE");
        jRadioButtonSerie.setEnabled(false);

        jLabelQuantidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelQuantidade.setText("INFORME A QUANTIDADE:");

        jLabelQuantidadeDisponível.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelQuantidadeDisponível.setText("QTD DISPONÍVEL:");

        jTQtdDisponivel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTQtdDisponivel.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTBuscaAcessorio, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabelBuscaAcessorio, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonNome)
                                .addGap(27, 27, 27)
                                .addComponent(jRadioButtonSerie)))
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTQuantidadeAcessorio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelQuantidadeDisponível)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTQtdDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBuscaAcessorio)
                        .addComponent(jRadioButtonNome)
                        .addComponent(jRadioButtonSerie))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jTBuscaAcessorio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidade)
                    .addComponent(jTQtdDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQuantidadeDisponível)
                    .addComponent(jTQuantidadeAcessorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabelaEquipamento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTabelaEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Equipamento", "Nº Série", "Arma", "Calibre", "Fabricante", "Qtd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaEquipamento.setRowHeight(22);
        jTabelaEquipamento.setRowMargin(5);
        jTabelaEquipamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTabelaEquipamento);
        if (jTabelaEquipamento.getColumnModel().getColumnCount() > 0) {
            jTabelaEquipamento.getColumnModel().getColumn(0).setMinWidth(0);
            jTabelaEquipamento.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTabelaEquipamento.getColumnModel().getColumn(0).setMaxWidth(0);
            jTabelaEquipamento.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTabelaEquipamento.getColumnModel().getColumn(1).setMaxWidth(100);
            jTabelaEquipamento.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTabelaEquipamento.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaEquipamento.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTabelaEquipamento.getColumnModel().getColumn(3).setMaxWidth(150);
            jTabelaEquipamento.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTabelaEquipamento.getColumnModel().getColumn(4).setMaxWidth(70);
            jTabelaEquipamento.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTabelaEquipamento.getColumnModel().getColumn(6).setPreferredWidth(30);
        }

        jComboBoxDestino.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha Destino" }));
        jComboBoxDestino.setEnabled(false);

        jLabelDestino.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelDestino.setText("Destino:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabelDestino)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBoxDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDestino))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtoncanelar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jBremoveritem, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jBEncerrarrCautela, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBremoveritem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBEncerrarrCautela))
                    .addComponent(jButtoncanelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBautenticarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBautenticarActionPerformed
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        jPanel3.setCursor(cursor);
        autenticarMilitar();
        cursor = Cursor.getDefaultCursor();
        jPanel3.setCursor(cursor);

    }//GEN-LAST:event_jBautenticarActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        jPanel3.setCursor(cursor);
        autenticarMilitar();
        cursor = Cursor.getDefaultCursor();
        jPanel3.setCursor(cursor);
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jBlerBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlerBiometriaActionPerformed
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        jPanel3.setCursor(cursor);
        captura();
        cursor = Cursor.getDefaultCursor();
        jPanel3.setCursor(cursor);
        jBcancelarBiometria.setEnabled(true);
    }//GEN-LAST:event_jBlerBiometriaActionPerformed

    private void jBremoveritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBremoveritemActionPerformed
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        jPanel3.setCursor(cursor);
        removerItens();
        cursor = Cursor.getDefaultCursor();
        jPanel3.setCursor(cursor);

    }//GEN-LAST:event_jBremoveritemActionPerformed

    private void jBEncerrarrCautelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEncerrarrCautelaActionPerformed
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        jPanel3.setCursor(cursor);
        encerrarCautela();
        cursor = Cursor.getDefaultCursor();
        jPanel3.setCursor(cursor);

    }//GEN-LAST:event_jBEncerrarrCautelaActionPerformed

    private void jButtoncanelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncanelarActionPerformed
        CisBiox dll = new CisBiox();
        dll.cancelarLeitura();
        biox.finalizar();
        dispose();
    }//GEN-LAST:event_jButtoncanelarActionPerformed

    private void jBcancelarBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarBiometriaActionPerformed
        CisBiox dll = new CisBiox();
        dll.cancelarLeitura();
        int iRetorno = biox.finalizar();
        jTlogin.setEnabled(true);
        jPassword.setEnabled(true);
        jTNomeCompleto.setText("");
        jTGuerra.setText("");
        jTOM.setText("");
        jTGraduacao.setText("");
        jTSexo.setText("");
        jTlogin.setText("");
        jPassword.setText("");
        jTlogin.requestFocus();
    }//GEN-LAST:event_jBcancelarBiometriaActionPerformed

    private void jTBuscaAcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBuscaAcessorioActionPerformed
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        jPanel3.setCursor(cursor);
        buscarAcessorio();
        cursor = Cursor.getDefaultCursor();
        jPanel3.setCursor(cursor);

    }//GEN-LAST:event_jTBuscaAcessorioActionPerformed

    private void jTBuscaArmamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBuscaArmamentoActionPerformed
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
        jPanel3.setCursor(cursor);
        buscarArmamento();
        cursor = Cursor.getDefaultCursor();
        jPanel3.setCursor(cursor);
    }//GEN-LAST:event_jTBuscaArmamentoActionPerformed

    private void jTQuantidadeAcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTQuantidadeAcessorioActionPerformed
        int qtd, qtd2;
        qtd = Integer.parseInt(jTQuantidadeAcessorio.getText());
        qtd2 = Integer.parseInt(jTQtdDisponivel.getText());
        if (qtd > qtd2) {
            JOptionPane.showMessageDialog(null, "QUANTIDADE INDISPONÍVEL");
            jTQuantidadeAcessorio.setText("");
        } else {
            inserirAcessorioNome();
        }
    }//GEN-LAST:event_jTQuantidadeAcessorioActionPerformed

    private void jTloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTloginActionPerformed
        jPassword.requestFocus();
    }//GEN-LAST:event_jTloginActionPerformed

    private void jPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyReleased
        if (jPassword.getPassword().length > 6) {
            JOptionPane.showMessageDialog(this, "APENAS 6 NÚMEROS");
            evt.consume();
            jPassword.setText("");
            jPassword.grabFocus();
        }
    }//GEN-LAST:event_jPasswordKeyReleased

    private void listarDestino(JComboBox combo) {
        try {
            List<Destino> lista = new DestinoDao().listEntidade();
            for (Destino dest : lista) {
                combo.addItem(dest);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar Destino" + ex.getMessage());
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
                        jTNomeCompleto.setText(mili.getNome());
                        jTGuerra.setText(mili.getGuerra());
                        jTOM.setText(mili.getOm().getOm());
                        jTGraduacao.setText(mili.getGraduacao().getGraduacao());
                        if (mili.getSexo().equals("M")) {
                            jTSexo.setText("MASCULINO");
                        } else {
                            jTSexo.setText("FEMININO");
                        }
                        verificaCautelas(mili.getIdmilitar());

                    }
                } catch (Exception ex) {
                    System.out.println("Erro ao pesquisar " + ex.getMessage());
                }
                jRadioButtonComBaioneta.setEnabled(true);
                jRadioButtonSemBaioneta.setEnabled(true);
                jRadioButtonNome.setEnabled(true);
                jRadioButtonSerie.setEnabled(true);
                jComboBoxDestino.setEnabled(true);
                jBEncerrarrCautela.setEnabled(true);
                jBremoveritem.setEnabled(true);
                jTBuscaAcessorio.setEnabled(true);
                jTBuscaArmamento.setEnabled(true);
                jTBuscaArmamento.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, " VERIFIQUE LOGIN E SENHA\n VERIFIQUE STATUS DO MILITAR");
                jTlogin.setText("");
                jPassword.setText("");
                jTlogin.requestFocus();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao autenticar:" + ex.getMessage());
        }

    }

    private void verificaCautelas(String login) {
        DefaultTableModel tabela = (DefaultTableModel) jTabelaEquipamento.getModel();
        try {
            List<Item> lista = new ControllerItem().listarCautelaPorMilitar(login);
            if (lista.isEmpty()) {
            } else {                
               String saida = "<html>"
                        + "<table border = '1'>"
                        + "<tr><th>EQUIPAMENTO</th>"
                        + "<th>SÉRIE</th>"
                        + "<th>ARMA</th>"
                        + "<th>CALIBRE</th>"
                        + "<th>FABRICANTE</th>"
                        + "<th>QTD</th></tr>";
                for (Item i : lista) {
                    saida = saida + "<tr>"
                            + "<td>" + i.getEquipamento().getNome() + "</td>"
                            + "<td>" + i.getEquipamento().getSerie() + "</td>"
                            + "<td>" + i.getEquipamento().getArma().getArma() + "</td>"
                            + "<td>" + i.getEquipamento().getCalibre().getCalibre() + "</td>"
                            + "<td>" + i.getEquipamento().getFabricante().getFabricante() + "</td>"
                            + "<td>" + i.getQtd() + "</td>"
                            + "</tr>";
                }
                saida = saida + "</table></html>";
                JOptionPane.showMessageDialog(rootPane, saida, "ALERTA - MILITAR JÁ POSSUE CAUTELAS EXISTENTE", -1);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao criar a lista das cautelas ja existente" + ex.getMessage());
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
                } catch (HeadlessException e) {
                    System.out.println("Erro ainda nao sei " + e.getMessage());
                }
            }
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
                    codigoMilitar = militar.getId();
                    jTNomeCompleto.setText(militar.getNome());
                    jTGuerra.setText(militar.getGuerra());
                    jTOM.setText(militar.getOm().getOm());
                    jTGraduacao.setText(militar.getGraduacao().getGraduacao());
                    if (militar.getSexo().equals("M")) {
                        jTSexo.setText("MASCULINO");
                    } else {
                        jTSexo.setText("FEMININO");
                    }
                    jRadioButtonComBaioneta.setEnabled(true);
                    jRadioButtonSemBaioneta.setEnabled(true);
                    jRadioButtonNome.setEnabled(true);
                    jRadioButtonSerie.setEnabled(true);
                    jComboBoxDestino.setEnabled(true);
                    jBEncerrarrCautela.setEnabled(true);
                    jBremoveritem.setEnabled(true);
                    jTQuantidadeAcessorio.setEnabled(true);
                    jTBuscaAcessorio.setEnabled(true);
                    jTBuscaArmamento.setEnabled(true);
                    jTBuscaArmamento.requestFocus();
                    verificaCautelas(militar.getIdmilitar());
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

    private void buscarArmamento() {
        try {
            eqp = new EquipamentoDao().pesq(jTBuscaArmamento.getText());
            if (eqp == null) {
                JOptionPane.showMessageDialog(null, "INDISPONÍVEL");
            } else {
                if (jRadioButtonSemBaioneta.isSelected()) {
                    inserirArmaSemBaioneta();
                } else {
                    inserirArmaSemBaioneta();
                    inserirArmaComBaioneta();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TlCautela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inserirArmaSemBaioneta() {
        DefaultTableModel tabela = (DefaultTableModel) jTabelaEquipamento.getModel();
        if (verificarItemArmamento() == true) {
            JOptionPane.showMessageDialog(null, "ARMAMENTO JÁ INSERIDO");
        } else {
            String nome = "Armamento";
            tabela.addRow(new Object[]{
                eqp.getId(),
                nome,
                eqp.getSerie(),
                eqp.getArma().getArma(),
                eqp.getCalibre().getCalibre(),
                eqp.getFabricante().getFabricante(),
                eqp.getQtd(),});
            jTBuscaArmamento.setText("");
            jComboBoxDestino.requestFocus();

        }
    }

    private void inserirArmaComBaioneta() {
        DefaultTableModel tabela = (DefaultTableModel) jTabelaEquipamento.getModel();
        if (verificarItemArmamentoBaioneta() == true) {
            JOptionPane.showMessageDialog(null, "BAIONETA JÁ INSERIDA ");
        } else {
            if (eqp == null) {
                JOptionPane.showMessageDialog(null, "INDISPONÍVEL");
            } else {
                String nome = "    -";
                tabela.addRow(new Object[]{
                    eqp.getAcessorio().getId(),
                    eqp.getAcessorio().getNome(),
                    eqp.getAcessorio().getSerie(),
                    nome, nome, nome,
                    eqp.getAcessorio().getQtd(),});
                jTBuscaArmamento.setText("");
                jComboBoxDestino.requestFocus();
            }
        }
    }

    private boolean verificarItemArmamento() {
        boolean retorno = false;
        for (int i = 0; i < jTabelaEquipamento.getRowCount(); i++) {
            int codigoTabela = Integer.parseInt(String.valueOf(jTabelaEquipamento.getValueAt(i, 0)));
            if (eqp.getId() == codigoTabela) {
                retorno = true;
            }
        }
        return retorno;
    }

    private boolean verificarItemArmamentoBaioneta() {
        boolean retorno = false;
        for (int i = 0; i < jTabelaEquipamento.getRowCount(); i++) {
            int codigoTabela = Integer.parseInt(String.valueOf(jTabelaEquipamento.getValueAt(i, 0)));
            if (eqp.getAcessorio().getId() == codigoTabela) {
                retorno = true;
            }
        }
        return retorno;
    }

    private void buscarAcessorio() {
        try {
            if (jRadioButtonNome.isSelected()) {
                eqp = new EquipamentoDao().pesqAcessorioNome(jTBuscaAcessorio.getText());
                if (eqp == null) {
                    JOptionPane.showMessageDialog(null, " ACESSÓRIO INDISPONÍVEL");
                } else {
                    jTQuantidadeAcessorio.setEnabled(true);
                    jTQtdDisponivel.setText(String.valueOf(eqp.getQtd()));
                }
            } else {
                eqp = new EquipamentoDao().pesqAcessorioSerie(jTBuscaAcessorio.getText());
                if (eqp == null) {
                    JOptionPane.showMessageDialog(null, " ACESSÓRIO INDISPONÍVEL");
                } else {
                    inserirAcessorio();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TlCautela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inserirAcessorio() {
        DefaultTableModel tabela = (DefaultTableModel) jTabelaEquipamento.getModel();
        if (verificarItemAcessorio() == true) {
            JOptionPane.showMessageDialog(null, " ACESSÓRIO JÁ INSERIDO ");
        } else {
            String nome = "    - ";
            tabela.addRow(new Object[]{
                eqp.getId(),
                eqp.getNome(),
                eqp.getSerie(),
                nome, nome, nome,
                eqp.getQtd(),});
            jTBuscaAcessorio.setText("");
            jComboBoxDestino.requestFocus();
        }
    }

    private void inserirAcessorioNome() {
        DefaultTableModel tabela = (DefaultTableModel) jTabelaEquipamento.getModel();
        if (verificarItemAcessorio() == true) {
            JOptionPane.showMessageDialog(null, " ACESSÓRIO JÁ INSERIDO ");
        } else {
            String nome = "    - ";
            tabela.addRow(new Object[]{
                eqp.getId(),
                eqp.getNome(),
                eqp.getSerie(),
                nome, nome, nome,
                jTQuantidadeAcessorio.getText(),});
            jTQtdDisponivel.setText("");
            jTBuscaAcessorio.setText("");
            jTQuantidadeAcessorio.setText("");
            jTQuantidadeAcessorio.setEnabled(false);
            jComboBoxDestino.requestFocus();
        }
    }

    private boolean verificarItemAcessorio() {
        boolean retorno = false;
        for (int i = 0; i < jTabelaEquipamento.getRowCount(); i++) {
            int codigoTabela = Integer.parseInt(String.valueOf(jTabelaEquipamento.getValueAt(i, 0)));
            if (eqp.getId() == codigoTabela) {
                retorno = true;
            }
        }
        return retorno;
    }

    private void removerItens() {
        DefaultTableModel tabela = (DefaultTableModel) jTabelaEquipamento.getModel();
        int linha = jTabelaEquipamento.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um item da tabela");
        } else {
            tabela.removeRow(linha);
        }
    }

    private void encerrarCautela() {
        Militar militar = new Militar();
        Cautela cautela = new Cautela();
        FuncaoMilitar armeiro = new FuncaoMilitar();
        listaitem = new ArrayList<>();
        // Pegando o Destino 
        if (jComboBoxDestino.getSelectedIndex() > 0) {
            Destino des = (Destino) jComboBoxDestino.getSelectedItem();
            cautela.setDestino(des);
            int linhaarmamento = jTabelaEquipamento.getRowCount();// pegar total de linha da tabela
            if (linhaarmamento <= 0) {
                JOptionPane.showMessageDialog(null, "NÃO EXISTE ITENS");
                return;
            } else {
                for (int i = 0; i < linhaarmamento; i++) {
                    Equipamento eqpi = new Equipamento();
                    Item it = new Item();
                    eqpi.setId(Integer.parseInt(String.valueOf(jTabelaEquipamento.getValueAt(i, 0))));
                    it.setQtd(Integer.parseInt(String.valueOf(jTabelaEquipamento.getValueAt(i, 6))));
                    it.setEquipamento(eqpi);
                    it.setStatus("CAUTELADO");
                    listaitem.add(it);
                }
            }

            //Pegando o Id do militar no caso o Militar que vai receber o armamento 
            militar.setId(codigoMilitar);
            cautela.setMilitar(militar);
            //Pegando o Id do MilitarFunção no caso o Armeiro que vai entregar o armamento

            //milfun.setId(Integer.parseInt(jLloginid.getText()));
            armeiro.setId(codigoArmeiro);
            cautela.setFuncaomilitar(armeiro);
        } else {
            JOptionPane.showMessageDialog(null, "FALTOU O DESTINO");
            return;
        }

        try {
            new CautelaDao().registrarCautela(cautela, listaitem);
            dispose();
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar cautela " + ex.getMessage());
        }
    }

    private void limparCampos() {
        DefaultTableModel tabela = (DefaultTableModel) jTabelaEquipamento.getModel();
        tabela.setNumRows(0);
        tabela.setRowCount(0);
        jComboBoxDestino.setSelectedIndex(0);
        jTNomeCompleto.setText("");
        jTGuerra.setText("");
        jTOM.setText("");
        jTGraduacao.setText("");
        jTSexo.setText("");
        jTlogin.setText("");
        jPassword.setText("");

        jRadioButtonNome.setSelected(true);
        jRadioButtonSemBaioneta.setSelected(true);
        jRadioButtonComBaioneta.setEnabled(false);
        jRadioButtonSemBaioneta.setEnabled(false);
        jRadioButtonNome.setEnabled(false);
        jRadioButtonSerie.setEnabled(false);
        jComboBoxDestino.setEnabled(false);
        jBEncerrarrCautela.setEnabled(false);
        jBremoveritem.setEnabled(false);
        jTBuscaAcessorio.setEnabled(false);
        jTBuscaArmamento.setEnabled(false);
        jTlogin.setEnabled(false);
        jPassword.setEnabled(false);
        listaitem = new ArrayList<>();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBEncerrarrCautela;
    private javax.swing.JButton jBautenticar;
    private javax.swing.JToggleButton jBcancelarBiometria;
    private javax.swing.JButton jBlerBiometria;
    private javax.swing.JButton jBremoveritem;
    private javax.swing.JButton jButtoncanelar;
    private javax.swing.JComboBox<String> jComboBoxDestino;
    private javax.swing.JLabel jLabelBuscaAcessorio;
    private javax.swing.JLabel jLabelDestino;
    private javax.swing.JLabel jLabelGraduacao;
    private javax.swing.JLabel jLabelGuerra;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelNomeCompleto;
    private javax.swing.JLabel jLabelOM;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JLabel jLabelQuantidadeDisponível;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelSerieArmamento;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JRadioButton jRadioButtonComBaioneta;
    private javax.swing.JRadioButton jRadioButtonNome;
    private javax.swing.JRadioButton jRadioButtonSemBaioneta;
    private javax.swing.JRadioButton jRadioButtonSerie;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTBuscaAcessorio;
    private javax.swing.JTextField jTBuscaArmamento;
    private javax.swing.JTextField jTGraduacao;
    private javax.swing.JTextField jTGuerra;
    private javax.swing.JTextField jTNomeCompleto;
    private javax.swing.JTextField jTOM;
    private javax.swing.JTextField jTQtdDisponivel;
    private javax.swing.JTextField jTQuantidadeAcessorio;
    private javax.swing.JTextField jTSexo;
    private javax.swing.JTable jTabelaEquipamento;
    private javax.swing.JTextField jTlogin;
    // End of variables declaration//GEN-END:variables
}
