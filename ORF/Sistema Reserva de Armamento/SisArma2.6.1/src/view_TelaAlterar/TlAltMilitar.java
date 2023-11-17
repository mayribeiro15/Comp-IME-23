/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_TelaAlterar;

import Controller.ControllerMilitar;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.bean.FuncaoMilitar;
import model.bean.Graduacao;
import model.bean.Militar;
import model.bean.OM;
import model.dao.GraduacaoDao;
import model.dao.MilitarDao;
import model.dao.OMDao;
import servicos.CisBiox;
import servicos.LimitaTexto;
import servicos.Maiusculas;
import servicos.Numero;
import view.TlDescautela;

/**
 *
 * @author ASUS
 */
public class TlAltMilitar extends javax.swing.JInternalFrame {

    CisBiox biox = new CisBiox();
    List<Militar> listabiometria;
    private byte[] digitalOficialDia;
    private byte[] digital;
    private byte[] digital2;
    Integer codigoOficialDia;
    Integer codigoArmeiro;
    int idMilitar;

    public TlAltMilitar(int codigoArmeiro) {
        initComponents();
        listarOM(jComboBoxom); // metodos para listar todas as OM assim que a tela for chamada
        listarGraduacao(jComboBoxgraduacao);   // metodos para listar todas as OM assim que a tela for chamada
        jTIdentidade.setDocument(new LimitaTexto(10));
        jTlogin.setDocument(new Maiusculas());
        jTnome.setDocument(new Maiusculas());
        jTIdentidadeBusca.setDocument(new LimitaTexto(10));
        jTidentidade.setDocument(new LimitaTexto(10));
        jTguerra.setDocument(new Maiusculas());
        jPassword.setDocument(new Numero());
        this.codigoArmeiro = codigoArmeiro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sexo = new javax.swing.ButtonGroup();
        Status = new javax.swing.ButtonGroup();
        jBeditar = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLnome = new javax.swing.JLabel();
        jTidentidade = new javax.swing.JTextField();
        jLlogin = new javax.swing.JLabel();
        jTlogin = new javax.swing.JTextField();
        jLguerra = new javax.swing.JLabel();
        jTguerra = new javax.swing.JTextField();
        jLsexo = new javax.swing.JLabel();
        jRadiomasculino = new javax.swing.JRadioButton();
        jRadiofeminino = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioativo = new javax.swing.JRadioButton();
        jRadioinativo = new javax.swing.JRadioButton();
        jLgraduacao = new javax.swing.JLabel();
        jComboBoxgraduacao = new javax.swing.JComboBox<>();
        jLom = new javax.swing.JLabel();
        jComboBoxom = new javax.swing.JComboBox<>();
        jLidentidade = new javax.swing.JLabel();
        jTnome = new javax.swing.JTextField();
        jLloginBusca = new javax.swing.JLabel();
        jTIdentidadeBusca = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonBiomatria = new javax.swing.JButton();
        jButtonBiomatria2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBcancelarBiometria = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jBsalvar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jBautenticar1 = new javax.swing.JButton();
        jBlerBiometriaOficial = new javax.swing.JButton();
        jBcancelarBiometria1 = new javax.swing.JToggleButton();
        jLabelLoginMilitar1 = new javax.swing.JLabel();
        jTIdentidade = new javax.swing.JTextField();
        jLabelSenha1 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jBRedefinirSenha = new javax.swing.JButton();

        setBorder(null);
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(1387, 620));

        jBeditar.setBackground(new java.awt.Color(244, 199, 109));
        jBeditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBeditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/edit.png"))); // NOI18N
        jBeditar.setText("EDITAR");
        jBeditar.setEnabled(false);
        jBeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeditarActionPerformed(evt);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        jLnome.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLnome.setText("Nome:");

        jTidentidade.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jTidentidade.setEnabled(false);

        jLlogin.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLlogin.setText("Usuário:");

        jTlogin.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTlogin.setEnabled(false);

        jLguerra.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLguerra.setText("Nome de Guerra:");

        jTguerra.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTguerra.setEnabled(false);

        jLsexo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLsexo.setText("Sexo: ");

        Sexo.add(jRadiomasculino);
        jRadiomasculino.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadiomasculino.setSelected(true);
        jRadiomasculino.setText("Masculino");
        jRadiomasculino.setEnabled(false);

        Sexo.add(jRadiofeminino);
        jRadiofeminino.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadiofeminino.setText("Feminino");
        jRadiofeminino.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setText("Status:");

        Status.add(jRadioativo);
        jRadioativo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioativo.setSelected(true);
        jRadioativo.setText("Ativo");
        jRadioativo.setEnabled(false);

        Status.add(jRadioinativo);
        jRadioinativo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jRadioinativo.setText("Inativo");
        jRadioinativo.setEnabled(false);

        jLgraduacao.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLgraduacao.setText("Posto / Graduação:");

        jComboBoxgraduacao.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxgraduacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Posto / Graduação" }));
        jComboBoxgraduacao.setEnabled(false);

        jLom.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLom.setText("Organização Militar:");

        jComboBoxom.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Organização Militar" }));
        jComboBoxom.setEnabled(false);

        jLidentidade.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLidentidade.setText("Identidade Militar:");

        jTnome.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTnome.setEnabled(false);

        jLloginBusca.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLloginBusca.setText("Identidade Militar:");

        jTIdentidadeBusca.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jTIdentidadeBusca.setEnabled(false);
        jTIdentidadeBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdentidadeBuscaActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados Biométrico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        jButtonBiomatria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonBiomatria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/ler_biometria.png"))); // NOI18N
        jButtonBiomatria.setBorderPainted(false);
        jButtonBiomatria.setEnabled(false);
        jButtonBiomatria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBiomatriaActionPerformed(evt);
            }
        });

        jButtonBiomatria2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonBiomatria2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/ler_biometria.png"))); // NOI18N
        jButtonBiomatria2.setBorderPainted(false);
        jButtonBiomatria2.setEnabled(false);
        jButtonBiomatria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBiomatria2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Inserir polegar direito:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Inserir polegar direito:");

        jBcancelarBiometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/cancelar_biometria.png"))); // NOI18N
        jBcancelarBiometria.setBorder(null);
        jBcancelarBiometria.setBorderPainted(false);
        jBcancelarBiometria.setEnabled(false);
        jBcancelarBiometria.setFocusPainted(false);
        jBcancelarBiometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarBiometriaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Cancelar leitura:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBcancelarBiometria, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBiomatria, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonBiomatria2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBiomatria)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBiomatria2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBcancelarBiometria, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLloginBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTIdentidadeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jLidentidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTidentidade, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLguerra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTguerra, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLnome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLsexo)
                            .addComponent(jLlogin))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadiomasculino)
                                .addGap(18, 18, 18)
                                .addComponent(jRadiofeminino))))
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jRadioativo)
                        .addGap(20, 20, 20)
                        .addComponent(jRadioinativo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLgraduacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxgraduacao, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxom, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLloginBusca)
                    .addComponent(jTIdentidadeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLidentidade)
                    .addComponent(jTidentidade, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLnome)
                    .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLguerra)
                    .addComponent(jTguerra))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLlogin))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLsexo)
                    .addComponent(jRadiomasculino)
                    .addComponent(jRadiofeminino))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioativo)
                        .addComponent(jRadioinativo)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLgraduacao)
                    .addComponent(jComboBoxgraduacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLom)
                    .addComponent(jComboBoxom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jBsalvar1.setBackground(new java.awt.Color(75, 184, 75));
        jBsalvar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBsalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/salvar.png"))); // NOI18N
        jBsalvar1.setText("  SALVAR");
        jBsalvar1.setEnabled(false);
        jBsalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvar1ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Aunteticação Oficial de Dia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

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

        jBlerBiometriaOficial.setBackground(new java.awt.Color(255, 255, 255));
        jBlerBiometriaOficial.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBlerBiometriaOficial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconeSisArma/ler_biometria.png"))); // NOI18N
        jBlerBiometriaOficial.setBorder(null);
        jBlerBiometriaOficial.setBorderPainted(false);
        jBlerBiometriaOficial.setContentAreaFilled(false);
        jBlerBiometriaOficial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBlerBiometriaOficial.setDisabledSelectedIcon(null);
        jBlerBiometriaOficial.setFocusPainted(false);
        jBlerBiometriaOficial.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jBlerBiometriaOficial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlerBiometriaOficialActionPerformed(evt);
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

        jTIdentidade.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTIdentidade.setEnabled(false);
        jTIdentidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdentidadeActionPerformed(evt);
            }
        });

        jLabelSenha1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelSenha1.setText("SENHA:");

        jPassword.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jBlerBiometriaOficial)
                .addGap(46, 46, 46)
                .addComponent(jBcancelarBiometria1)
                .addGap(105, 105, 105)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLoginMilitar1)
                    .addComponent(jLabelSenha1))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTIdentidade, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(jPassword))
                .addGap(60, 60, 60)
                .addComponent(jBautenticar1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLoginMilitar1)
                            .addComponent(jTIdentidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabelSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE))))
                    .addComponent(jBlerBiometriaOficial)
                    .addComponent(jBcancelarBiometria1)
                    .addComponent(jBautenticar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jBRedefinirSenha.setBackground(new java.awt.Color(244, 199, 109));
        jBRedefinirSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBRedefinirSenha.setText("REDEFINIR SENHA");
        jBRedefinirSenha.setEnabled(false);
        jBRedefinirSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRedefinirSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jBRedefinirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jBeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jBsalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBRedefinirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBsalvar1)
                        .addComponent(jBcancelar)
                        .addComponent(jBeditar)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeditarActionPerformed
        jTnome.setEnabled(true);
        jTlogin.setEnabled(true);
        jTguerra.setEnabled(true);
        jRadiomasculino.setEnabled(true);
        jRadiofeminino.setEnabled(true);
        jRadioinativo.setEnabled(true);
        jRadioativo.setEnabled(true);
        jComboBoxgraduacao.setEnabled(true);
        jComboBoxom.setEnabled(true);
        jComboBoxgraduacao.setSelectedIndex(0);
        jComboBoxom.setSelectedIndex(0);
        jBsalvar1.setEnabled(true);
        jButtonBiomatria.setEnabled(true);
        jButtonBiomatria2.setEnabled(true);

    }//GEN-LAST:event_jBeditarActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        CisBiox dll = new CisBiox();
        dll.cancelarLeitura();
        biox.finalizar();
        dispose();
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jBsalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvar1ActionPerformed
        salvar();

    }//GEN-LAST:event_jBsalvar1ActionPerformed

    private void jBlerBiometriaOficialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlerBiometriaOficialActionPerformed
        capturaOficialDia();
    }//GEN-LAST:event_jBlerBiometriaOficialActionPerformed

    private void jBcancelarBiometria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarBiometria1ActionPerformed
        CisBiox dll = new CisBiox();
        dll.cancelarLeitura();
        int iRetorno = biox.finalizar();
        jTIdentidade.setEnabled(true);
        jPassword.setEnabled(true);
        jTIdentidade.requestFocus();
        
    }//GEN-LAST:event_jBcancelarBiometria1ActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        autenticaOficialDia();
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jBautenticar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBautenticar1ActionPerformed
        autenticaOficialDia();
    }//GEN-LAST:event_jBautenticar1ActionPerformed

    private void jPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyReleased
        if (jPassword.getPassword().length > 6) {
            JOptionPane.showMessageDialog(this, "APENAS 6 NÚMEROS");
            evt.consume();
            jPassword.setText("");
            jPassword.grabFocus();
        }
    }//GEN-LAST:event_jPasswordKeyReleased

    private void jTIdentidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdentidadeActionPerformed
        jPassword.requestFocus();
    }//GEN-LAST:event_jTIdentidadeActionPerformed

    private void jBcancelarBiometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarBiometriaActionPerformed
        CisBiox dll = new CisBiox();

        // Cancelar a leitura
        dll.cancelarLeitura();
        int iRetorno = biox.finalizar();
        if (iRetorno != 1) {
            JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
            return;
        }
        jBcancelarBiometria.setEnabled(false);
        jButtonBiomatria.setEnabled(true);
        jButtonBiomatria2.setEnabled(true);
    }//GEN-LAST:event_jBcancelarBiometriaActionPerformed

    private void jButtonBiomatria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBiomatria2ActionPerformed
        jBcancelarBiometria.setEnabled(true);
        new Thread() {
            public void run() {
                try {
                    int iRetorno = biox.iniciar();
                    if (iRetorno != 1) {
                        JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
                        return;
                    }
                    digital2 = biox.capturarDigital();
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
                    jButtonBiomatria2.setEnabled(false);
                } catch (Exception e) {
                    System.out.println("Erro ainda nao sei " + e.getMessage());
                }
            }
            ;
        }.start();
    }//GEN-LAST:event_jButtonBiomatria2ActionPerformed

    private void jButtonBiomatriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBiomatriaActionPerformed
        jBcancelarBiometria.setEnabled(true);
        new Thread() {
            public void run() {
                try {
                    int iRetorno = biox.iniciar();
                    if (iRetorno != 1) {
                        JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
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
                    JOptionPane.showMessageDialog(null, "CAPTURADA");
                    jButtonBiomatria.setEnabled(false);
                    jButtonBiomatria2.setEnabled(true);
                } catch (Exception e) {
                    System.out.println("Erro ainda nao sei " + e.getMessage());
                }
            }
            ;
        }.start();
    }//GEN-LAST:event_jButtonBiomatriaActionPerformed

    private void jTIdentidadeBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdentidadeBuscaActionPerformed
        pesquisarMilitar();
    }//GEN-LAST:event_jTIdentidadeBuscaActionPerformed

    private void jBRedefinirSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRedefinirSenhaActionPerformed
        TlAltMilitarSenha tl = new TlAltMilitarSenha(codigoArmeiro, codigoOficialDia, idMilitar);
        tl.setVisible(true);
    }//GEN-LAST:event_jBRedefinirSenhaActionPerformed

    private void leitura() {
        CisBiox biox2 = new CisBiox();
        biox2.iniciar();

        int iRetorno = biox.compararDigital(digital, digital2);

        switch (iRetorno) {
            case 1:
                JOptionPane.showMessageDialog(null, " DIGITAIS IGUAIS ");
                jButtonBiomatria2.setEnabled(false);
                break;
            case -2:
                JOptionPane.showMessageDialog(null, "! REPETIR COLETA !");
                jButtonBiomatria.setEnabled(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
                break;
        }

        biox2.finalizar();
    }

    private void capturaOficialDia() {
        new Thread() {
            public void run() {
                try {
                    int iRetorno = biox.iniciar();
                    if (iRetorno != 1) {
                        JOptionPane.showMessageDialog(null, "Erro: " + CisBiox.mensagens(iRetorno));
                        jTIdentidade.setEnabled(true);
                        jPassword.setEnabled(true);
                        jTIdentidade.requestFocus();
                        return;
                    }
                    digitalOficialDia = biox.capturarDigital();
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
                } catch (HeadlessException e) {
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
            for (Militar militar : listabiometria) {

                if ((biox2.compararDigital(digitalOficialDia, militar.getDigital())) == 1) {
                    codigoOficialDia = militar.getIdoficialDia().getId();
                    jTIdentidadeBusca.setEnabled(true);
                    cod = 1;
                    break;
                }

                cursor = Cursor.getDefaultCursor();
                jPanel1.setCursor(cursor);

            }

            if (cod == 0) {
                for (Militar militar : listabiometria) {
                    if ((biox2.compararDigital(digitalOficialDia, militar.getDigital())) == -2) {
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

    private void salvar() {
        Militar mil = new Militar();
        ControllerMilitar controle = new ControllerMilitar();

        if (jComboBoxgraduacao.getSelectedIndex() > 0) {
            Graduacao gra = (Graduacao) jComboBoxgraduacao.getSelectedItem();
            mil.setGraduacao(gra);
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE GRADUAÇÃO");
            return;
        }

        if (jComboBoxom.getSelectedIndex() > 0) {
            OM om = (OM) jComboBoxom.getSelectedItem();
            mil.setOm(om);
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE ORG. MILITAR");
            return;
        }
        mil.setId(idMilitar);
        mil.setNome(jTnome.getText());
        mil.setGuerra(jTguerra.getText());
        mil.setLogin(jTlogin.getText());
        mil.setSexo(getSexo());
        mil.setStatus(getStatus());
        mil.setDigital(digital);
        FuncaoMilitar armeiro = new FuncaoMilitar();
        armeiro.setId(codigoArmeiro);
        FuncaoMilitar oficialDia = new FuncaoMilitar();
        oficialDia.setId(codigoOficialDia);
        mil.setIdarmeiro(armeiro);
        mil.setIdoficialDia(oficialDia);

        try {
            controle.alterar(mil);
            JOptionPane.showMessageDialog(null, "ALTERAÇÃO REALIZADA!");
            dispose();
        } catch (Exception ex) {
            System.out.println("erro ao editar" + ex.getMessage());
            limparCampos();
        }

    }

    private void limparCampos() {
        jTIdentidadeBusca.setText("");
        jTidentidade.setText("");
        jTidentidade.setEnabled(false);
        jTnome.setText("");
        jTnome.setEnabled(false);
        jTguerra.setText("");
        jTguerra.setEnabled(false);
        jTlogin.setText("");
        jTlogin.setEnabled(false);
        jComboBoxgraduacao.setSelectedIndex(0);
        jComboBoxgraduacao.setEnabled(false);
        jComboBoxom.setSelectedIndex(0);
        jComboBoxom.setEnabled(false);
    }

    private void listarGraduacao(JComboBox combo) {

        try {
            List<Graduacao> lista = new GraduacaoDao().listEntidade();
            for (Graduacao g : lista) {
                combo.addItem(g);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar Graduação:" + ex.getMessage());
        }

    }

    private void listarOM(JComboBox combo) {

        try {
            List<OM> lista = new OMDao().listEntidade();
            for (OM om : lista) {
                combo.addItem(om);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar OM:" + ex.getMessage());
        }
    }

    private String getSexo() {
        String sexo = "M";
        if (jRadiofeminino.isSelected()) {
            sexo = "F";
        }
        return sexo;
    }

    private String getStatus() {
        String status = "ATIVO";

        if (jRadioinativo.isSelected()) {
            status = "INATIVO";
        }
        return status;

    }

    private void pesquisarMilitar() {
        String busca = jTIdentidadeBusca.getText();

        try {
            Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            jPanel1.setCursor(cursor);
            Militar mil = new ControllerMilitar().pesquisar(busca);
            cursor = Cursor.getDefaultCursor();
            jPanel1.setCursor(cursor);
            if (mil == null) {
                JOptionPane.showMessageDialog(null, "Militar Não Cadastrado");
            } else {
                jBRedefinirSenha.setEnabled(true);
                jBeditar.setEnabled(true);
                idMilitar = mil.getId();
                jTidentidade.setText(mil.getIdmilitar());
                jTnome.setText(mil.getNome());
                jTguerra.setText(mil.getGuerra());
                jTlogin.setText(mil.getLogin());
                if (mil.getSexo().equals("M")) {
                    jRadiomasculino.setSelected(true);
                } else {
                    jRadiofeminino.setSelected(true);
                }
                if (mil.getStatus().equals("ATIVO")) {
                    jRadioativo.setSelected(true);
                } else {
                    jRadioinativo.setSelected(true);
                }
                jComboBoxgraduacao.getModel().setSelectedItem(mil.getGraduacao().getGraduacao());
                jComboBoxom.getModel().setSelectedItem(mil.getOm().getOm());
                digital = mil.getDigital();
            }
        } catch (Exception ex) {
            System.out.println("Erro ao no metodo pesquisar Militar" + ex.getMessage());
        }

    }

    private void autenticaOficialDia() {
        String login = jTIdentidade.getText();
        String senha = jPassword.getText();
        try {
            Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            jPanel1.setCursor(cursor);
            codigoOficialDia = new MilitarDao().autenticacaoOficialDia(login, senha);
            cursor = Cursor.getDefaultCursor();
            jPanel1.setCursor(cursor);
            if (codigoOficialDia == null) {
                JOptionPane.showMessageDialog(null, " VERIFIQUE LOGIN E SENHA\n VERIFIQUE STATUS DO MILITAR");
                jTIdentidade.setText("");
                jPassword.setText("");
                jTIdentidade.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null,"OFICIAL DIA AUTENTICADO");
                jTIdentidadeBusca.setEnabled(true);
                jTIdentidadeBusca.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TlDescautela.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Sexo;
    private javax.swing.ButtonGroup Status;
    private javax.swing.JButton jBRedefinirSenha;
    private javax.swing.JButton jBautenticar1;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JToggleButton jBcancelarBiometria;
    private javax.swing.JToggleButton jBcancelarBiometria1;
    private javax.swing.JButton jBeditar;
    private javax.swing.JButton jBlerBiometriaOficial;
    private javax.swing.JButton jBsalvar1;
    private javax.swing.JButton jButtonBiomatria;
    private javax.swing.JButton jButtonBiomatria2;
    private javax.swing.JComboBox<String> jComboBoxgraduacao;
    private javax.swing.JComboBox<String> jComboBoxom;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelLoginMilitar1;
    private javax.swing.JLabel jLabelSenha1;
    private javax.swing.JLabel jLgraduacao;
    private javax.swing.JLabel jLguerra;
    private javax.swing.JLabel jLidentidade;
    private javax.swing.JLabel jLlogin;
    private javax.swing.JLabel jLloginBusca;
    private javax.swing.JLabel jLnome;
    private javax.swing.JLabel jLom;
    private javax.swing.JLabel jLsexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JRadioButton jRadioativo;
    private javax.swing.JRadioButton jRadiofeminino;
    private javax.swing.JRadioButton jRadioinativo;
    private javax.swing.JRadioButton jRadiomasculino;
    private javax.swing.JTextField jTIdentidade;
    private javax.swing.JTextField jTIdentidadeBusca;
    private javax.swing.JTextField jTguerra;
    private javax.swing.JTextField jTidentidade;
    private javax.swing.JTextField jTlogin;
    private javax.swing.JTextField jTnome;
    // End of variables declaration//GEN-END:variables

}
