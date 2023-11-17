/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Funcao;
import model.connection.FabricaConexao;

/**
 *
 * @author ASUS
 */
public class FuncaoDao {

    private PreparedStatement pstm; // Prepara a inserção no banco mais segura que Statement, utilizando parametros e evita ataque de sql injection 
    private Connection con;         // executa a conexão com o banco
    private String sql;             // recebe a instrução que será enviada para o banco 
    private ResultSet rs;           // retorna a consulta no banco de dados

    /* public int pegaArmeiro(int id) throws SQLException {
    
    con = FabricaConexao.getconnection();       //abre conexao
    sql = "select f.id as id from funcaomilitar f\n"
    + "left join militar m on f.id = m.id where f.idmilitar = ?;";                   //armazena a instrução sql que será inserida no banco
    pstm = con.prepareStatement(sql);           //prepara o instrução sql no banco
    pstm.setInt(1, id);
    rs = pstm.executeQuery();                   //executa a instrução sql e armazena o retorno na variavel "rs"
    if (rs.next()) {                           //cria condição enquanto resultado existe executa proximo passo
    id = rs.getInt("id");
    }
    return id;
    }*/

    public List<Funcao> listEntidade() throws Exception {
        Funcao fun = null;                               //Declarao classe cria um variavel e atribe o valor null;
        List<Funcao> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();       //abre conexao    
        sql = "select id as idfuncao, nome as funcao from funcao;";                   //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);           //prepara o instrução sql no banco
        rs = pstm.executeQuery();                   //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                           //cria condição enquanto resultado existe executa proximo passo 
            fun = new Funcao();                          //estância o objeto
            fun.setId(rs.getInt("idfuncao"));              //seta no bean o que trouxer do banco 
            fun.setFuncao(rs.getString("funcao"));         //seta no bean o que trouxer do banco 
            lista.add(fun);                          //adiciona tudo na lista 
        }                                           //fecha condição
        FabricaConexao.closeconnection();           //fecha conexao com o banco
        return lista;                                //retorna lista
    }


}
