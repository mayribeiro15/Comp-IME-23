/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_TelaAlterar;

import Controller.ControllerEquipamento;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.bean.Arma;
import model.bean.Equipamento;
import model.bean.Calibre;
import model.bean.Categoria;
import model.bean.Fabricante;
import model.bean.FuncaoMilitar;
import model.bean.Militar;
import model.dao.ArmaDao;
import model.dao.CalibreDao;
import model.dao.CategoriaDao;
import model.dao.EquipamentoDao;
import model.dao.FabricanteDao;
import model.dao.MilitarDao;
import servicos.CisBiox;
import servicos.LimitaTexto;
import servicos.Maiusculas;
import servicos.Numero;
import view.TlDescautela;
import view_TelaCadastro.TlCadEquipamento;

/**
 *
 * @author ASUS
 */
public class TlAltEquipamento extends javax.swing.JInternalFrame {

    CisBiox biox = new CisBiox();
    List<Militar> listabiometria;
    private byte[] digital;
    Integer codigoOficialDia;
    Integer codigoArmeiro;
    int idEquipamento;
    Equipamento registroAnterior;

    public TlAltEquipamento(int codigoArmeiro) {
        initComponents();
        listarFabricante(jComboBoxfabricante); // chamada do metodo listarFabricante na inicialização da tela
        listarArma(jComboBoxarma);// chamada do metodo listarArma na inicialização da tela
        listarCalibres(jComboBoxcalibre);// chamada do metodo listarCalibre na inicialização da tela
        listarBaioneta(jComboBoxBaioneta);// chamada do metodo listarCalibre na inicialização da tela
        listarCategoria(jComboBoxcategoria);
        jTIdMilitar.setDocument(new LimitaTexto(10));
        jTextnome.setDocument(new Maiusculas());
        jTextobservacao.setDocument(new Maiusculas());
        jTextquantidade.setDocument(new Numero());
        jTextserie.setDocument(new Maiusculas());
        jPassword1.setDocument(new Numero());
        this.codigoArmeiro = codigoArmeiro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Status = new javax.swing.ButtonGroup();
        TipoEquipamento = new javax.swing.ButtonGroup();
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
        jLabel5 = new javax.swing.JLabel();
        jRadioButtondisponivel = new javax.swing.JRadioButton();
        jRadioButtonindisponivel = new javax.swing.JRadioButton();
        jRadioButtonrecolhido = new javax.swing.JRadioButton();
        jLabelobservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextobservacao = new javax.swing.JTextArea();
        jRadioButtonCautelado = new javax.swing.JRadioButton();
        jComboBoxcategoria = new javax.swing.JComboBox<>();
        jLabelselecioneCategoria = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBlerBiometria1 = new javax.swing.JButton();
        jBcancelarBiometria1 = new javax.swing.JToggleButton();
        jLabelLoginMilitar1 = new javax.swing.JLabel();
        jTIdMilitar = new javax.swing.JTextField();
        jLabelSenha1 = new javax.swing.JLabel();
        jPassword1 = new javax.swing.JPasswordField();
        jBautenticar1 = new javax.swing.JButton();
        jBsalvar = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jBeditar = new javax.swing.JButton();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setEnabled(false);
        setFrameIcon(null);
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados Equipamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("SELECIONE O TIPO DE EQUIPAMENTO QUE DESEJA CADASTRAR");

        TipoEquipamento.add(jRadioButtonarmamento);
        jRadioButtonarmamento.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtonarmamento.setText("ARMAMENTO ");
        jRadioButtonarmamento.setEnabled(false);
        jRadioButtonarmamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonarmamentoActionPerformed(evt);
            }
        });

        TipoEquipamento.add(jRadioButtonacessorio);
        jRadioButtonacessorio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtonacessorio.setText("ACESSÓRIO");
        jRadioButtonacessorio.setEnabled(false);
        jRadioButtonacessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonacessorioActionPerformed(evt);
            }
        });

        jLabelnome.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelnome.setText("Nome:");

        jTextnome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextnome.setEnabled(false);
        jTextnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextnomeActionPerformed(evt);
            }
        });

        jLabelserie.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelserie.setText("Nº Série:");

        jTextserie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextserie.setEnabled(false);
        jTextserie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextserieActionPerformed(evt);
            }
        });

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

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Status: ");

        Status.add(jRadioButtondisponivel);
        jRadioButtondisponivel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtondisponivel.setText("DISPONÍVEL");
        jRadioButtondisponivel.setEnabled(false);

        Status.add(jRadioButtonindisponivel);
        jRadioButtonindisponivel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtonindisponivel.setText("INDISPONÍVEL");
        jRadioButtonindisponivel.setEnabled(false);

        Status.add(jRadioButtonrecolhido);
        jRadioButtonrecolhido.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtonrecolhido.setText("RECOLHIDO");
        jRadioButtonrecolhido.setEnabled(false);

        jLabelobservacao.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelobservacao.setText("Observação:");

        jTextobservacao.setColumns(20);
        jTextobservacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextobservacao.setRows(5);
        jTextobservacao.setEnabled(false);
        jScrollPane1.setViewportView(jTextobservacao);

        Status.add(jRadioButtonCautelado);
        jRadioButtonCautelado.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioButtonCautelado.setText("CAUTELADO");
        jRadioButtonCautelado.setEnabled(false);

        jComboBoxcategoria.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha Categoria" }));
        jComboBoxcategoria.setEnabled(false);

        jLabelselecioneCategoria.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelselecioneCategoria.setText("Selecione Categoria:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(303, 303, 303)
                            .addComponent(jRadioButtonarmamento)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButtonacessorio))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabelnome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextnome, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(jLabelserie)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextserie, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(jLabelquantidade)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jRadioButtondisponivel)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButtonindisponivel)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButtonrecolhido)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButtonCautelado))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabelobservacao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabelselecioneCategoria)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBoxcategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabelselecioneArma)
                                            .addGap(52, 52, 52))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabelselecioneFabricante)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxfabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxarma, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelselecioneAcessorio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBoxBaioneta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelselecioneCalibre)
                                    .addGap(24, 24, 24)
                                    .addComponent(jComboBoxcalibre, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonarmamento)
                    .addComponent(jRadioButtonacessorio))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelnome)
                    .addComponent(jTextnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelserie)
                    .addComponent(jTextserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelselecioneFabricante)
                    .addComponent(jComboBoxfabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelselecioneCalibre)
                    .addComponent(jComboBoxcalibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelselecioneArma)
                    .addComponent(jComboBoxarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelselecioneAcessorio)
                    .addComponent(jComboBoxBaioneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelselecioneCategoria)
                    .addComponent(jComboBoxcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButtondisponivel)
                    .addComponent(jRadioButtonindisponivel)
                    .addComponent(jRadioButtonrecolhido)
                    .addComponent(jRadioButtonCautelado))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelobservacao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Aunteticação Oficial de Dia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        jBlerBiometria1.setBackground(new java.awt.Color(255, 255, 255));
        jBlerBiometria1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBlerBiometria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/ler_biometria.png"))); // NOI18N
        jBlerBiometria1.setBorder(null);
        jBlerBiometria1.setBorderPainted(false);
        jBlerBiometria1.setContentAreaFilled(false);
        jBlerBiometria1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBlerBiometria1.setDisabledSelectedIcon(null);
        jBlerBiometria1.setFocusPainted(false);
        jBlerBiometria1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jBlerBiometria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlerBiometria1ActionPerformed(evt);
            }
        });

        jBcancelarBiometria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/cancelar_biometria.png"))); // NOI18N
        jBcancelarBiometria1.setBorder(null);
        jBcancelarBiometria1.setBorderPainted(false);
        jBcancelarBiometria1.setContentAreaFilled(false);
        jBcancelarBiometria1.setFocusPainted(false);
        jBcancelarBiometria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarBiometria1ActionPerformed(evt);
            }
        });

        jLabelLoginMilitar1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelLoginMilitar1.setText("LOGIN:");

        jTIdMilitar.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTIdMilitar.setEnabled(false);
        jTIdMilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdMilitarActionPerformed(evt);
            }
        });

        jLabelSenha1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelSenha1.setText("SENHA:");

        jPassword1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPassword1.setEnabled(false);
        jPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassword1ActionPerformed(evt);
            }
        });
        jPassword1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPassword1KeyReleased(evt);
            }
        });

        jBautenticar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jBautenticar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/pesquisar.png"))); // NOI18N
        jBautenticar1.setBorder(null);
        jBautenticar1.setBorderPainted(false);
        jBautenticar1.setContentAreaFilled(false);
        jBautenticar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBautenticar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jBlerBiometria1)
                .addGap(46, 46, 46)
                .addComponent(jBcancelarBiometria1)
                .addGap(105, 105, 105)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLoginMilitar1)
                    .addComponent(jLabelSenha1))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTIdMilitar, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jPassword1))
                .addGap(18, 18, 18)
                .addComponent(jBautenticar1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(351, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBlerBiometria1)
                    .addComponent(jBcancelarBiometria1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLoginMilitar1)
                            .addComponent(jTIdMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jBautenticar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jBsalvar.setBackground(new java.awt.Color(75, 184, 75));
        jBsalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/salvar.png"))); // NOI18N
        jBsalvar.setText(" SALVAR");
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

        jBeditar.setBackground(new java.awt.Color(244, 199, 109));
        jBeditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBeditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/edit.png"))); // NOI18N
        jBeditar.setText("EDITAR");
        jBeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBcancelar)
                        .addGap(19, 19, 19)
                        .addComponent(jBeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jBsalvar))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBcancelar)
                    .addComponent(jBeditar)
                    .addComponent(jBsalvar))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed
        salvar();
    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        CisBiox dll = new CisBiox();
        dll.cancelarLeitura();
        dispose();
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jRadioButtonacessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonacessorioActionPerformed
        limparCampo();
        jTextnome.setEnabled(true);
        jTextserie.setEnabled(true);
        jBsalvar.setEnabled(false);
        jTextobservacao.setEnabled(false);
        jTextquantidade.setEnabled(false);
        jRadioButtonCautelado.setSelected(false);

    }//GEN-LAST:event_jRadioButtonacessorioActionPerformed

    private void jRadioButtonarmamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonarmamentoActionPerformed
        limparCampo();
        jTextnome.setEnabled(false);
        jTextnome.setText("ARMAMENTO");
        jTextobservacao.setEnabled(false);
        jTextquantidade.setEnabled(false);
        jTextquantidade.setText("1");
        jTextserie.setEnabled(true);
        jBsalvar.setEnabled(false);
        jComboBoxBaioneta.setEnabled(false);
        listarBaioneta(jComboBoxBaioneta);


    }//GEN-LAST:event_jRadioButtonarmamentoActionPerformed

    private void jTextserieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextserieActionPerformed
        jComboBoxBaioneta.setSelectedIndex(0);
        if (tipoEquipamento().equals("AR")) {
            pesquisarArmamento();
        } else {
            pesquisarAcessorioPorserie();
        }
    }//GEN-LAST:event_jTextserieActionPerformed

    private void jTextnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextnomeActionPerformed
        pesquisarAcessorioPorNome();
        
    }//GEN-LAST:event_jTextnomeActionPerformed

    private void jBeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeditarActionPerformed
        if (tipoEquipamento().equals("AR")) {
            jTextobservacao.setEnabled(true);
            jTextobservacao.setEditable(true);
            jTextserie.setEnabled(true);
            jBeditar.setEnabled(false);
            jBsalvar.setEnabled(true);
            jRadioButtondisponivel.setEnabled(true);
            jRadioButtonindisponivel.setEnabled(true);
            jRadioButtonrecolhido.setEnabled(true);
            jComboBoxcategoria.setEnabled(true);
            jComboBoxcategoria.setSelectedIndex(0);
        } else {
            jTextnome.setEnabled(true);
            jTextobservacao.setEnabled(true);
            jTextobservacao.setEditable(true);
            jTextquantidade.setEnabled(true);
            jTextserie.setEnabled(true);
            jBeditar.setEnabled(false);
            jBsalvar.setEnabled(true);
            jRadioButtondisponivel.setEnabled(true);
            jRadioButtonindisponivel.setEnabled(true);
            jRadioButtonrecolhido.setEnabled(true);
            jComboBoxcategoria.setEnabled(true);
            jComboBoxcategoria.setSelectedIndex(0);
        }

    }//GEN-LAST:event_jBeditarActionPerformed

    private void jBlerBiometria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlerBiometria1ActionPerformed
        capturaOficialDia();
    }//GEN-LAST:event_jBlerBiometria1ActionPerformed

    private void jBcancelarBiometria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarBiometria1ActionPerformed
        CisBiox dll = new CisBiox();
        dll.cancelarLeitura();
        biox.finalizar();
        jTIdMilitar.setEnabled(true);
        jPassword1.setEnabled(true);
        jTIdMilitar.requestFocus();
    }//GEN-LAST:event_jBcancelarBiometria1ActionPerformed

    private void jPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassword1ActionPerformed
        autenticaOficialDia();
    }//GEN-LAST:event_jPassword1ActionPerformed

    private void jBautenticar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBautenticar1ActionPerformed
        autenticaOficialDia();
    }//GEN-LAST:event_jBautenticar1ActionPerformed

    private void jTIdMilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdMilitarActionPerformed
        jPassword1.requestFocus();
    }//GEN-LAST:event_jTIdMilitarActionPerformed

    private void jPassword1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPassword1KeyReleased
        if (jPassword1.getPassword().length > 6) {
            JOptionPane.showMessageDialog(this, "APENAS 6 NÚMEROS");
            evt.consume();
            jPassword1.setText("");
            jPassword1.grabFocus();
        }
    }//GEN-LAST:event_jPassword1KeyReleased

    private void capturaOficialDia() {
        new Thread() {
            public void run() {
                try {
                    int iRetorno = biox.iniciar();
                    if (iRetorno != 1) {
                        JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
                        jTIdMilitar.setEnabled(true);
                        jPassword1.setEnabled(true);
                        jTIdMilitar.requestFocus();
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
                    leituraOficialDia();
                } catch (Exception e) {
                    System.out.println("Erro ainda nao sei " + e.getMessage());
                }
            }
        ;
    }

    .start();
    }
    
    private void leituraOficialDia() {
        CisBiox biox2 = new CisBiox();
        MilitarDao mDao = new MilitarDao();
        biox2.iniciar();
        int cod = 0;
        try {
            Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            jPanel1.setCursor(cursor);
            listabiometria = mDao.digitalOficialDia();
            cursor = Cursor.getDefaultCursor();
            jPanel1.setCursor(cursor);
            for (Militar militar : listabiometria) {
                if ((biox2.compararDigital(digital, militar.getDigital())) == 1) {
                    codigoOficialDia = militar.getIdoficialDia().getId();
                    jRadioButtonacessorio.setEnabled(true);
                    jRadioButtonarmamento.setEnabled(true);
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
            System.out.println("Leitura Erro" + ex.getMessage());
            JOptionPane.showMessageDialog(this, "BANCO DESCONECTADO");
            biox2.finalizar();
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

    private void listarBaioneta(JComboBox combo) {

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

    private void pesquisarArmamento() {
        String serie = jTextserie.getText();

        try {
            Equipamento arm = new ControllerEquipamento().buscarArmamentoPorSerie(serie);
            if (arm == null) {
                JOptionPane.showMessageDialog(null, "ARMAMENTO INEXISTENTE!");
            } else {
                // inicio metodo metodo para pegar o idArmeiro e idOficial para inserir na tabela de alterações 
                registroAnterior = arm;
                FuncaoMilitar idarmeiro = new FuncaoMilitar();
                idarmeiro.setId(codigoArmeiro);
                registroAnterior.setArmeiro(idarmeiro);
                FuncaoMilitar oficialDia = new FuncaoMilitar();
                oficialDia.setId(codigoOficialDia);
                registroAnterior.setOficialDia(oficialDia);
                //Finalizao o resgistro do armamento buscado para inserir em outra estancia do objeto Equipamento. FinalizandoMetodo Acima 

                idEquipamento = arm.getId();
                jComboBoxarma.getModel().setSelectedItem(arm.getArma().getArma());
                jComboBoxcalibre.getModel().setSelectedItem(arm.getCalibre().getCalibre());
                jComboBoxfabricante.getModel().setSelectedItem(arm.getFabricante().getFabricante());
                jComboBoxBaioneta.getModel().setSelectedItem(arm.getAcessorio().getSerie());
                jComboBoxcategoria.getModel().setSelectedItem(arm.getCategoria().getCategoria());
                jTextquantidade.setText(String.valueOf(arm.getQtd()));
                jTextobservacao.setText(arm.getObs());
                switch (arm.getStatus()) {
                    case "DISPONIVEL":
                        jRadioButtondisponivel.setSelected(true);
                        break;
                    case "INDISPONIVEL":
                        jRadioButtonindisponivel.setSelected(true);
                        break;
                    case "RECOLHIDO":
                        jRadioButtonrecolhido.setSelected(true);
                        break;
                    default:
                        jRadioButtonCautelado.setSelected(true);
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro ao pesquisar equipamento por serie " + ex.getMessage());
        }
    }

    private void pesquisarAcessorioPorserie() {
        String serie = jTextserie.getText();

        try {
            Equipamento ace = new ControllerEquipamento().buscaAcessorioPorSerie(serie);
            if (ace == null) {
                JOptionPane.showMessageDialog(null, "ACESSÓRIO INEXISTENTE");
            } else {
                jBeditar.setEnabled(true);
                jComboBoxcategoria.getModel().setSelectedItem(ace.getCategoria().getCategoria());
                // inicio metodo metodo para pegar o idArmeiro e idOficial para inserir na tabela de alterações 
                registroAnterior = ace;
                FuncaoMilitar idarmeiro = new FuncaoMilitar();
                idarmeiro.setId(codigoArmeiro);
                registroAnterior.setArmeiro(idarmeiro);
                FuncaoMilitar oficialDia = new FuncaoMilitar();
                oficialDia.setId(codigoOficialDia);
                registroAnterior.setOficialDia(oficialDia);
                //Finalizao o resgistro do armamento buscado para inserir em outra estancia do objeto Equipamento. FinalizandoMetodo Acima 
                idEquipamento = ace.getId();
                jTextnome.setText(ace.getNome());
                jTextquantidade.setText(String.valueOf(ace.getQtd()));
                jTextobservacao.setText(ace.getObs());
                switch (ace.getStatus()) {
                    case "DISPONIVEL":
                        jRadioButtondisponivel.setSelected(true);
                        break;
                    case "INDISPONIVEL":
                        jRadioButtonindisponivel.setSelected(true);
                        break;
                    case "RECOLHIDO":
                        jRadioButtonrecolhido.setSelected(true);
                        break;
                    default:
                        jRadioButtonCautelado.setSelected(true);
                        break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TlAltEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pesquisarAcessorioPorNome() {
        String nome = jTextnome.getText();

        try {
            Equipamento ace = new ControllerEquipamento().buscaAcessorioPorNome(nome);
            if (ace == null) {
                JOptionPane.showMessageDialog(null, "ACESSÓRIO INEXISTENTE");
            } else {
                jBeditar.setEnabled(true);
                jComboBoxcategoria.getModel().setSelectedItem(ace.getCategoria().getCategoria());
                // inicio metodo metodo para pegar o idArmeiro e idOficial para inserir na tabela de alterações 
                registroAnterior = ace;
                FuncaoMilitar idarmeiro = new FuncaoMilitar();
                idarmeiro.setId(codigoArmeiro);
                registroAnterior.setArmeiro(idarmeiro);
                FuncaoMilitar oficialDia = new FuncaoMilitar();
                oficialDia.setId(codigoOficialDia);
                registroAnterior.setOficialDia(oficialDia);
                //Finalizao o resgistro do armamento buscado para inserir em outra estancia do objeto Equipamento. FinalizandoMetodo Acima 
                idEquipamento = ace.getId();
                jTextserie.setText(ace.getSerie());
                jTextquantidade.setText(String.valueOf(ace.getQtd()));
                jTextobservacao.setText(ace.getObs());
                switch (ace.getStatus()) {
                    case "DISPONIVEL":
                        jRadioButtondisponivel.setSelected(true);
                        break;
                    case "INDISPONIVEL":
                        jRadioButtonindisponivel.setSelected(true);
                        break;
                    case "RECOLHIDO":
                        jRadioButtonrecolhido.setSelected(true);
                        break;
                    default:
                        jRadioButtonCautelado.setSelected(true);
                        break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TlAltEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void salvar() {
        Equipamento eqp = new Equipamento();
        ControllerEquipamento controle = new ControllerEquipamento();
        EquipamentoDao dao = new EquipamentoDao();
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
            eqp.setNome(jTextnome.getText());
            eqp.setQtd(Integer.parseInt(jTextquantidade.getText()));
            eqp.setStatus(StatusEquipamento());
            eqp.setId(idEquipamento);
            try {
                if (validarCampoAcessorio() == true) {
                    controle.alterarEquipamento(eqp);
                    dao.registraAlteracaoAcessorio(registroAnterior);
                    JOptionPane.showMessageDialog(null, "Acessório Alterado");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "EQUIPAMENTO NÃO ALTERADO");
                    limparCampo();
                }
            } catch (Exception ex) {
                System.out.println("Erro ao atualizar o acessório " + ex.getMessage());
            }

        } else {
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
            eqp.setNome(jTextnome.getText());
            eqp.setSerie(jTextserie.getText());
            eqp.setQtd(Integer.parseInt(jTextquantidade.getText()));
            eqp.setStatus(StatusEquipamento());
            eqp.setId(idEquipamento);
            try {
                if (validarCampoArmamento() == true) {
                    controle.alterarEquipamento(eqp);
                    dao.registraAlteracao(registroAnterior);
                    JOptionPane.showMessageDialog(null, "Armamento Alterado");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "EQUIPAMENTO NÃO ALTERADO");
                    limparCampo();
                }
            } catch (Exception ex) {
                System.out.println("Erro ao update do armamento " + ex.getMessage());
            }

        }
    }

    private void limparCampo() {
        jTextnome.setText("");
        jTextobservacao.setText("");
        jTextquantidade.setText("");
        jTextserie.setText("");
        jTextquantidade.setText("1");
        jComboBoxBaioneta.setSelectedIndex(0);
        jComboBoxcalibre.setSelectedIndex(0);
        jComboBoxarma.setSelectedIndex(0);
        jComboBoxfabricante.setSelectedIndex(0);
        jComboBoxcategoria.setSelectedIndex(0);
        jRadioButtonCautelado.setSelected(false);
        jRadioButtondisponivel.setSelected(false);
        jRadioButtonindisponivel.setSelected(false);
        jRadioButtonrecolhido.setSelected(false);

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

    private void autenticaOficialDia() {
        String login = jTIdMilitar.getText();
        String senha = jPassword1.getText();
        try {
            Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            jPanel1.setCursor(cursor);
            codigoOficialDia = new MilitarDao().autenticacaoOficialDia(login, senha);
            cursor = Cursor.getDefaultCursor();
            jPanel1.setCursor(cursor);
            if (codigoOficialDia == null) {
                JOptionPane.showMessageDialog(null, " VERIFIQUE LOGIN E SENHA\n VERIFIQUE STATUS DO MILITAR");
                jTIdMilitar.setText("");
                jPassword1.setText("");
                jTIdMilitar.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "OFICIAL DIA AUTENTICADO");
                jRadioButtonacessorio.setEnabled(true);
                jRadioButtonarmamento.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TlDescautela.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Status;
    private javax.swing.ButtonGroup TipoEquipamento;
    private javax.swing.JButton jBautenticar1;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JToggleButton jBcancelarBiometria1;
    private javax.swing.JButton jBeditar;
    private javax.swing.JButton jBlerBiometria1;
    private javax.swing.JButton jBsalvar;
    private javax.swing.JComboBox<String> jComboBoxBaioneta;
    private javax.swing.JComboBox<String> jComboBoxarma;
    private javax.swing.JComboBox<String> jComboBoxcalibre;
    private javax.swing.JComboBox<String> jComboBoxcategoria;
    private javax.swing.JComboBox<String> jComboBoxfabricante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelLoginMilitar1;
    private javax.swing.JLabel jLabelSenha1;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPassword1;
    private javax.swing.JRadioButton jRadioButtonCautelado;
    private javax.swing.JRadioButton jRadioButtonacessorio;
    private javax.swing.JRadioButton jRadioButtonarmamento;
    private javax.swing.JRadioButton jRadioButtondisponivel;
    private javax.swing.JRadioButton jRadioButtonindisponivel;
    private javax.swing.JRadioButton jRadioButtonrecolhido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTIdMilitar;
    private javax.swing.JTextField jTextnome;
    private javax.swing.JTextArea jTextobservacao;
    private javax.swing.JTextField jTextquantidade;
    private javax.swing.JTextField jTextserie;
    // End of variables declaration//GEN-END:variables
}
