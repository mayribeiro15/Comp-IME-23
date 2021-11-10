package interfacegrafica;

import reservasaereas.Passageiro;
import reservasaereas.Voo;
import passageiro.dao.*;
import voo.dao.*;
import javax.swing.JTable;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class Interface extends javax.swing.JFrame  {
    VooDAO vooDao = new VooDAO();
    PassageiroDAO passageiroDao = new PassageiroDAO();
    JTable modeloPassageiro = new JTable(new DefaultTableModel(new Object[]{"Id", "Número Fidelidade","Categoria Fidelidade","Nome","Email","Cpf","Sexo","Passaporte","Data Nascimento", "Id do Voo"},0));
    JTable modeloVoo = new JTable(new DefaultTableModel(new Object[]{"Id", "Número Voo", "Aeroporto Origem", "Aeroporto Destino", "Distancia Km", "Modelo Avião", "Total Poltronas", "Poltronas Vagas", "Número Autorização Anac"},0));
    
    public void LoadTablePassageiro(){ 
    	while (tbl_passageiro.getRowCount() > 0){
            ((DefaultTableModel) tbl_passageiro.getModel()).removeRow(0);            
        }
    	
		for (Passageiro p: passageiroDao.getPassageiros()) {
            Object linhaPassageiro[] = new Object[]{p.getId(),
                    p.getNumeroFidelidade(),
                    p.getCategoriaFidelidade(),
                    p.getNome(),
                    p.getEmail(),
                    p.getCpf(),
                    p.getSexo(),
                    p.getPassaporte(),
                    p.getDataNascimento(),
                    p.getIdVoo()};
            ((DefaultTableModel) modeloPassageiro.getModel()).addRow(linhaPassageiro);
		}
		tbl_passageiro.setModel(modeloPassageiro.getModel());
	    tbl_passageiro.getColumnModel().getColumn(0).setPreferredWidth(50);
	    tbl_passageiro.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    public void LoadTableVoo() {
    	while (tbl_voo.getRowCount() > 0){
            ((DefaultTableModel) tbl_voo.getModel()).removeRow(0);            
        }
    	
		for (Voo v: vooDao.getVoos()) {
            Object linhaVoo[] = new Object[]{v.getId(),
                    v.getNumeroVoo(),
                    v.getAeroportoOrigem(),
                    v.getAeroportoDestino(),
                    v.getDistanciaKm(),
                    v.getModeloAviao(),
                    v.getTotalPoltronas(),
                    v.getPoltronasVagas(),
                    v.getNumeroAutorizacaoAnac()};
            ((DefaultTableModel) modeloVoo.getModel()).addRow(linhaVoo);
		}
        tbl_voo.setModel(modeloVoo.getModel());
        tbl_voo.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_voo.getColumnModel().getColumn(1).setPreferredWidth(200);
    }
    
    public Interface() {
        initComponentsPassageiro();
        setLocationRelativeTo(null);
        LoadTablePassageiro();
        LoadTableVoo();
        btn_salvar_passageiro.setEnabled(false);
        btn_atualizar_passageiro.setEnabled(false);
        btn_atualizar_voo.setEnabled(false);
        btn_salvar_voo.setEnabled(false);
        c_numero_fidelidade.setEnabled(false);
        c_categoria_fidelidade.setEnabled(false);
        c_nome.setEnabled(false);
        c_email.setEnabled(false);
        c_cpf.setEnabled(false);
        c_sexo.setEnabled(false);
        c_passaporte.setEnabled(false);
        c_data_nascimento.setEnabled(false);
        c_id_voo.setEnabled(false);
        c_numero_voo.setEnabled(false);
        c_aeroporto_origem.setEnabled(false);
        c_aeroporto_destino.setEnabled(false);
        c_distancia_km.setEnabled(false);
        c_modelo_aviao.setEnabled(false);
        c_total_poltronas.setEnabled(false);
        c_numero_autorizacao_anac.setEnabled(false);
    }
    
    private void initComponentsPassageiro() {
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_passageiro = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_voo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_numero_fidelidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        c_categoria_fidelidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        c_cpf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        c_sexo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        c_passaporte = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        c_data_nascimento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        c_numero_voo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        c_aeroporto_origem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        c_aeroporto_destino = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        c_distancia_km = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        c_modelo_aviao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        c_total_poltronas = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        c_numero_autorizacao_anac = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        c_id_voo = new javax.swing.JTextField();
        btn_salvar_passageiro = new javax.swing.JButton();
        btn_atualizar_passageiro = new javax.swing.JButton();
        btn_atualizar_voo = new javax.swing.JButton();
        btn_novo_passageiro = new javax.swing.JButton();
        btn_salvar_voo = new javax.swing.JButton();
        btn_novo_voo = new javax.swing.JButton();
        btn_editar_passageiro = new javax.swing.JButton();
        btn_excluir_passageiro = new javax.swing.JButton();
        btn_editar_voo = new javax.swing.JButton();
        btn_excluir_voo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_passageiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
            		"Id", "Número Fidelidade","Categoria Fidelidade","Nome","Email","Cpf","Sexo","Passaporte","Data Nascimento", "Id do Voo"
            }
        ));
        jScrollPane1.setViewportView(tbl_passageiro);
        if (tbl_passageiro.getColumnModel().getColumnCount() > 0) {
        	tbl_passageiro.getColumnModel().getColumn(0).setPreferredWidth(50);
        	tbl_passageiro.getColumnModel().getColumn(1).setPreferredWidth(200);
        }
        
        tbl_voo.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                		"Id", "Número Voo", "Aeroporto Origem", "Aeroporto Destino", "Distancia Km", "Modelo Avião", "Total Poltronas", "Poltronas Vagas", "Número Autorização Anac"
                }
            ));
        jScrollPane2.setViewportView(tbl_voo);
        if (tbl_voo.getColumnModel().getColumnCount() > 0) {
        	tbl_voo.getColumnModel().getColumn(0).setPreferredWidth(50);
        	tbl_voo.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Passageiro"));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Voo"));

        jLabel1.setText("Número Fidelidade:");
        jLabel2.setText("Categoria Fidelidade:");
        jLabel3.setText("Nome:");
        jLabel4.setText("Email:");
        jLabel5.setText("Cpf:");
        jLabel6.setText("Sexo:");
        jLabel7.setText("Passaporte:");
        jLabel8.setText("Data Nascimento:");
        jLabel16.setText("Id do Voo");
        
        jLabel9.setText("Número Voo: ");
        jLabel10.setText("Aeroporto Origem: ");
        jLabel11.setText("Aeroporto Destino: ");
        jLabel12.setText("Distância em Km");
        jLabel13.setText("Modelo Avião: ");
        jLabel14.setText("Total Poltronas: ");
        jLabel14.setText("Total Vagas: ");
        jLabel15.setText("Número Autorização Anac: ");

        btn_salvar_passageiro.setText("Salvar Passageiro");
        btn_salvar_passageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_passageiroActionPerformed(evt);
            }
        });
        
        btn_atualizar_passageiro.setText("Atualizar Passageiro");
        btn_atualizar_passageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizar_passageiroActionPerformed(evt);
            }
        });
        
        btn_atualizar_voo.setText("Atualizar Voo");
        btn_atualizar_voo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizar_vooActionPerformed(evt);
            }
        });
        
        btn_salvar_voo.setText("Salvar Voo");
        btn_salvar_voo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_vooActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                	.addComponent(jLabel16)
            		.addComponent(jLabel8)
            		.addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(c_numero_fidelidade))
	                .addComponent(c_categoria_fidelidade)
	                .addComponent(c_nome)
	                .addComponent(c_email)
	                .addComponent(c_cpf)
	                .addComponent(c_sexo)
	                .addComponent(c_passaporte)
                    .addComponent(c_data_nascimento)
                	.addComponent(c_id_voo))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_salvar_passageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_atualizar_passageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(c_numero_fidelidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(c_categoria_fidelidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(c_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(c_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(c_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel7)
	                    .addComponent(c_passaporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                		.addComponent(jLabel8)
                		.addComponent(c_data_nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(c_id_voo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar_passageiro)
                    .addComponent(btn_atualizar_passageiro))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            		.addComponent(jLabel9)
            		.addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(c_numero_voo))
	                .addComponent(c_aeroporto_origem)
	                .addComponent(c_aeroporto_destino)
	                .addComponent(c_distancia_km)
	                .addComponent(c_modelo_aviao)
	                .addComponent(c_total_poltronas)
	                .addComponent(c_numero_autorizacao_anac))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_salvar_voo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_atualizar_voo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(c_numero_voo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(c_aeroporto_origem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(c_aeroporto_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(c_distancia_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(c_modelo_aviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(c_total_poltronas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel15)
	                    .addComponent(c_numero_autorizacao_anac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar_voo)
                    .addComponent(btn_atualizar_voo))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btn_novo_passageiro.setText("Novo Passageiro");
        btn_novo_passageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novo_passageiroActionPerformed(evt);
            }
        });
        
        btn_novo_voo.setText("Novo Voo");
        btn_novo_voo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novo_vooActionPerformed(evt);
            }
        });

        btn_editar_passageiro.setText("Editar Passageiro");
        btn_editar_passageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_passageiroActionPerformed(evt);
            }
        });
        
        btn_editar_voo.setText("Editar Voo");
        btn_editar_voo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_vooActionPerformed(evt);
            }
        });
        
        btn_excluir_passageiro.setText("Excluir Passageiro");
        btn_excluir_passageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluir_passageiroActionPerformed(evt);
            }
        });
        
        btn_excluir_voo.setText("Excluir Voo");
        btn_excluir_voo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluir_vooActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_novo_passageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_editar_passageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_excluir_passageiro, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_novo_passageiro)
                    .addComponent(btn_editar_passageiro)
                    .addComponent(btn_excluir_passageiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados dos Passageiros", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btn_novo_voo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_editar_voo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_excluir_voo, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_novo_voo)
                            .addComponent(btn_editar_voo)
                            .addComponent(btn_excluir_voo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

        jTabbedPane1.addTab("Dados dos Voos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }
    
    private void btn_novo_passageiroActionPerformed(java.awt.event.ActionEvent evt) {
        c_numero_fidelidade.setText("");
        c_categoria_fidelidade.setText("");
        c_nome.setText("");
        c_email.setText("");
        c_cpf.setText("");
        c_sexo.setText("");
        c_passaporte.setText("");
        c_data_nascimento.setText("");
        c_id_voo.setText("");
        
        btn_salvar_passageiro.setEnabled(true);
        c_numero_fidelidade.setEnabled(true);
        c_categoria_fidelidade.setEnabled(true);
        c_nome.setEnabled(true);
        c_email.setEnabled(true);
        c_cpf.setEnabled(true);
        c_sexo.setEnabled(true);
        c_passaporte.setEnabled(true);
        c_data_nascimento.setEnabled(true);
        c_id_voo.setEnabled(true);
    }
    
    private void btn_novo_vooActionPerformed(java.awt.event.ActionEvent evt) {
    	c_numero_voo.setText("");
    	c_aeroporto_origem.setText("");
    	c_aeroporto_destino.setText("");
    	c_distancia_km.setText("");
        c_modelo_aviao.setText("");
        c_total_poltronas.setText("");
        c_numero_autorizacao_anac.setText("");
        
        btn_salvar_voo.setEnabled(true);
        c_numero_voo.setEnabled(true);
        c_aeroporto_origem.setEnabled(true);
        c_aeroporto_destino.setEnabled(true);
        c_distancia_km.setEnabled(true);
        c_modelo_aviao.setEnabled(true);
        c_total_poltronas.setEnabled(true);
        c_numero_autorizacao_anac.setEnabled(true);
    }

    private void btn_salvar_passageiroActionPerformed(java.awt.event.ActionEvent evt) {
    	int numeroFidelidade = Integer.parseInt(c_numero_fidelidade.getText());
    	String categoriaFidelidade = c_categoria_fidelidade.getText();
    	String nome = c_nome.getText();
    	String email = c_email.getText();
    	String cpf = c_cpf.getText();
    	String sexo = c_sexo.getText();
    	String passaporte = c_passaporte.getText();
    	String dataNascimento = c_data_nascimento.getText();
    	int idVoo = Integer.parseInt(c_id_voo.getText());
        Passageiro P = new Passageiro(numeroFidelidade, categoriaFidelidade, nome, email, cpf, sexo, passaporte, dataNascimento, idVoo);
		passageiroDao.save(P);
        
		c_numero_fidelidade.setText("");
        c_categoria_fidelidade.setText("");
        c_nome.setText("");
        c_email.setText("");
        c_cpf.setText("");
        c_sexo.setText("");
        c_passaporte.setText("");
        c_data_nascimento.setText("");
        c_id_voo.setText("");
        
        btn_salvar_passageiro.setEnabled(false);
        c_numero_fidelidade.setEnabled(false);
        c_categoria_fidelidade.setEnabled(false);
        c_nome.setEnabled(false);
        c_email.setEnabled(false);
        c_cpf.setEnabled(false);
        c_sexo.setEnabled(false);
        c_passaporte.setEnabled(false);
        c_data_nascimento.setEnabled(false);
        c_id_voo.setEnabled(false);
        
        LoadTablePassageiro();
        LoadTableVoo();
    }
    
    private void btn_salvar_vooActionPerformed(java.awt.event.ActionEvent evt) {
    	String numeroVoo = c_numero_voo.getText();
    	String aeroportoOrigem = c_aeroporto_origem.getText();
    	String aeroportoDestino = c_aeroporto_destino.getText();
    	double distanciaKm = Double.parseDouble(c_distancia_km.getText());
    	String modeloAviao = c_modelo_aviao.getText();
    	int totalPoltronas = Integer.parseInt(c_total_poltronas.getText());
    	String numeroAutorizacaoAnac = c_numero_autorizacao_anac.getText();
        Voo V = new Voo(numeroVoo, aeroportoOrigem, aeroportoDestino, distanciaKm, modeloAviao, totalPoltronas, numeroAutorizacaoAnac);
		vooDao.save(V);
    	
		c_numero_voo.setText("");
    	c_aeroporto_origem.setText("");
    	c_aeroporto_destino.setText("");
    	c_distancia_km.setText("");
        c_modelo_aviao.setText("");
        c_total_poltronas.setText("");
        c_numero_autorizacao_anac.setText("");
        
        btn_salvar_voo.setEnabled(false);
        c_numero_voo.setEnabled(false);
        c_aeroporto_origem.setEnabled(false);
        c_aeroporto_destino.setEnabled(false);
        c_distancia_km.setEnabled(false);
        c_modelo_aviao.setEnabled(false);
        c_total_poltronas.setEnabled(false);
        c_numero_autorizacao_anac.setEnabled(false);
        
        LoadTableVoo();
    }

    private void btn_editar_vooActionPerformed(java.awt.event.ActionEvent evt) {
    	int index = modeloPassageiro.getSelectedRow() + 1;
    	c_numero_voo.setText(String.valueOf(vooDao.getVoos().get(index).getNumeroVoo()));
    	c_aeroporto_origem.setText(String.valueOf(vooDao.getVoos().get(index).getAeroportoOrigem()));
    	c_aeroporto_destino.setText(String.valueOf(vooDao.getVoos().get(index).getAeroportoDestino()));
    	c_distancia_km.setText(String.valueOf(vooDao.getVoos().get(index).getDistanciaKm()));
        c_modelo_aviao.setText(String.valueOf(vooDao.getVoos().get(index).getModeloAviao()));
        c_total_poltronas.setText(String.valueOf(vooDao.getVoos().get(index).getTotalPoltronas()));
        c_numero_autorizacao_anac.setText(String.valueOf(vooDao.getVoos().get(index).getNumeroAutorizacaoAnac()));
        btn_atualizar_voo.setEnabled(true);
        c_numero_voo.setEnabled(true);
        c_aeroporto_origem.setEnabled(true);
        c_aeroporto_destino.setEnabled(true);
        c_distancia_km.setEnabled(true);
        c_modelo_aviao.setEnabled(true);
        c_total_poltronas.setEnabled(true);
        c_numero_autorizacao_anac.setEnabled(true);
    }
    
    private void btn_editar_passageiroActionPerformed(java.awt.event.ActionEvent evt) {
    	int index = tbl_passageiro.getSelectedRow();
        c_numero_fidelidade.setText(String.valueOf(passageiroDao.getPassageiros().get(index).getNumeroFidelidade()));
        c_categoria_fidelidade.setText(String.valueOf(passageiroDao.getPassageiros().get(index).getCategoriaFidelidade()));     
        c_nome.setText(String.valueOf(passageiroDao.getPassageiros().get(index).getNome()));
        c_email.setText(String.valueOf(passageiroDao.getPassageiros().get(index).getEmail()));
        c_cpf.setText(String.valueOf(passageiroDao.getPassageiros().get(index).getCpf()));
        c_sexo.setText(String.valueOf(passageiroDao.getPassageiros().get(index).getSexo()));
        c_passaporte.setText(String.valueOf(passageiroDao.getPassageiros().get(index).getPassaporte()));
        c_data_nascimento.setText(String.valueOf(passageiroDao.getPassageiros().get(index).getDataNascimento()));
        c_id_voo.setText(String.valueOf(passageiroDao.getPassageiros().get(index).getIdVoo()));
        btn_atualizar_passageiro.setEnabled(true);
        c_numero_fidelidade.setEnabled(true);
        c_categoria_fidelidade.setEnabled(true);
        c_nome.setEnabled(true);
        c_email.setEnabled(true);
        c_cpf.setEnabled(true);
        c_sexo.setEnabled(true);
        c_passaporte.setEnabled(true);
        c_data_nascimento.setEnabled(true);
        c_id_voo.setEnabled(true);
    }
    
    private void btn_atualizar_passageiroActionPerformed(java.awt.event.ActionEvent evt) {
    	int index = tbl_passageiro.getSelectedRow();
    	Passageiro passageiro = passageiroDao.getPassageiros().get(index);
        passageiro.setNumeroFidelidade(Integer.parseInt(c_numero_fidelidade.getText()));
        passageiro.setCategoriaFidelidade(c_categoria_fidelidade.getText());
        passageiro.setNome(c_nome.getText());
        passageiro.setEmail(c_email.getText());
        passageiro.setCpf(c_cpf.getText());
        passageiro.setSexo(c_sexo.getText());
        passageiro.setPassaporte(c_passaporte.getText());
        passageiro.setDataNascimento(c_data_nascimento.getText());
        passageiro.setIdVoo(Integer.parseInt(c_id_voo.getText()));
        passageiroDao.update(passageiro);
        
        c_numero_fidelidade.setText("");
        c_categoria_fidelidade.setText("");
        c_nome.setText("");
        c_email.setText("");
        c_cpf.setText("");
        c_sexo.setText("");
        c_passaporte.setText("");
        c_data_nascimento.setText("");
        c_id_voo.setText("");
        
        btn_atualizar_passageiro.setEnabled(false);
        c_numero_voo.setEnabled(true);
        c_aeroporto_origem.setEnabled(true);
        c_aeroporto_destino.setEnabled(true);
        c_distancia_km.setEnabled(true);
        c_modelo_aviao.setEnabled(true);
        c_total_poltronas.setEnabled(true);
        c_numero_autorizacao_anac.setEnabled(true);
        
        LoadTablePassageiro();
        LoadTableVoo();
    }
    
    private void btn_atualizar_vooActionPerformed(java.awt.event.ActionEvent evt) {
    	int index = tbl_voo.getSelectedRow();
    	Voo voo = vooDao.getVoos().get(index);
    	voo.setAeroportoDestino(c_aeroporto_destino.getText());
    	voo.setAeroportoOrigem(c_aeroporto_origem.getText());
    	voo.setDistanciaKm(Double.parseDouble(c_distancia_km.getText()));
    	voo.setModeloAviao(c_modelo_aviao.getText());
    	voo.setNumeroVoo(c_numero_voo.getText());
    	voo.setTotalPoltronas(Integer.parseInt(c_total_poltronas.getText()));
    	voo.setNumeroAutorizacaoAnac(c_numero_autorizacao_anac.getText());
        vooDao.update(voo);
        
    	c_numero_voo.setText("");
    	c_aeroporto_origem.setText("");
    	c_aeroporto_destino.setText("");
    	c_distancia_km.setText("");
        c_modelo_aviao.setText("");
        c_total_poltronas.setText("");
        c_numero_autorizacao_anac.setText("");
        
        btn_atualizar_voo.setEnabled(false);
        c_numero_fidelidade.setEnabled(false);
        c_categoria_fidelidade.setEnabled(false);
        c_nome.setEnabled(false);
        c_email.setEnabled(false);
        c_cpf.setEnabled(false);
        c_sexo.setEnabled(false);
        c_passaporte.setEnabled(false);
        c_data_nascimento.setEnabled(false);
        c_id_voo.setEnabled(false);
        
        LoadTableVoo();
    }
    
    private void btn_excluir_vooActionPerformed(java.awt.event.ActionEvent evt) {  			
    	int index = tbl_voo.getSelectedRow();
    	Voo voo = vooDao.getVoos().get(index);
    	vooDao.deleteByID(voo.getId());
		LoadTableVoo();
    }
    
    private void btn_excluir_passageiroActionPerformed(java.awt.event.ActionEvent evt) {
    	int index = tbl_passageiro.getSelectedRow();
    	Passageiro passageiro = passageiroDao.getPassageiros().get(index);
    	passageiroDao.deleteByID(passageiro.getId());
    	LoadTablePassageiro();
    	LoadTableVoo();
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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    
    private javax.swing.JButton btn_editar_voo;
    
    private javax.swing.JButton btn_editar_passageiro;
    private javax.swing.JButton btn_excluir_voo;
    private javax.swing.JButton btn_excluir_passageiro;
    private javax.swing.JButton btn_novo_passageiro;
    private javax.swing.JButton btn_atualizar_passageiro;
    private javax.swing.JButton btn_salvar_passageiro;
    private javax.swing.JButton btn_novo_voo;
    private javax.swing.JButton btn_salvar_voo;
    private javax.swing.JButton btn_atualizar_voo;
    private javax.swing.JTextField c_numero_fidelidade;
    private javax.swing.JTextField c_categoria_fidelidade;
    private javax.swing.JTextField c_nome;
    private javax.swing.JTextField c_email;
    private javax.swing.JTextField c_cpf;
    private javax.swing.JTextField c_sexo;
    private javax.swing.JTextField c_passaporte;
    private javax.swing.JTextField c_data_nascimento;
    private javax.swing.JTextField c_id_voo;
    private javax.swing.JTextField c_numero_voo;
    private javax.swing.JTextField c_aeroporto_origem;
    private javax.swing.JTextField c_aeroporto_destino;
    private javax.swing.JTextField c_distancia_km;
    private javax.swing.JTextField c_modelo_aviao;
    private javax.swing.JTextField c_total_poltronas;
    private javax.swing.JTextField c_numero_autorizacao_anac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_passageiro;
    private javax.swing.JTable tbl_voo;
}

