/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bean.Arma;
import model.connection.FabricaConexao;

/**
 *
 * @author ASUS
 */
public class ArmaDao{
    
private PreparedStatement pstm; // Prepara a inserção no banco mais segura que Statement, utilizando parametros e evita ataque de sql injection 
private Connection con;         // executa a conexão com o banco
private String sql;             // recebe a instrução que será enviada para o banco 
private ResultSet rs;           // retorna a consulta no banco de dados
   

   
    public List<Arma> listEntidade() throws Exception {
    Arma arm = null;                               //Declarao classe cria um variavel e atribe o valor null;
    List<Arma> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
    con = FabricaConexao.getconnection();       //abre conexao    
    sql = "select id as idarma, nome as arma from arma;";                   //armazena a instrução sql que será inserida no banco
    pstm = con.prepareStatement(sql);           //prepara o instrução sql no banco
    rs = pstm.executeQuery();                   //executa a instrução sql e armazena o retorno na variavel "rs"
    while(rs.next()){                           //cria condição enquanto resultado existe executa proximo passo 
        arm = new Arma();                          //estância o objeto
        arm.setId(rs.getInt("idarma"));              //seta no bean o que trouxer do banco 
        arm.setArma(rs.getString("arma"));         //seta no bean o que trouxer do banco 
        lista.add(arm);                          //adiciona tudo na lista 
    }                                           //fecha condição
    FabricaConexao.closeconnection();           //fecha conexao com o banco
    return lista;                                //retorna lista
        
    }
}
