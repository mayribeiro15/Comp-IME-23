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
import model.bean.Categoria;
import model.connection.FabricaConexao;

/**
 *
 * @author Asus
 */
public class CategoriaDao {

    private PreparedStatement pstm; // Prepara a inserção no banco mais segura que Statement, utilizando parametros e evita ataque de sql injection 
    private Connection con;         // executa a conexão com o banco
    private String sql;             // recebe a instrução que será enviada para o banco 
    private ResultSet rs;           // retorna a consulta no banco de dados

    public List<Categoria> listEntidade() throws Exception {
        Categoria categoria = null;                               //Declarao classe cria um variavel e atribe o valor null;
        List<Categoria> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();       //abre conexao    
        sql = "select id as idcategoria, nome as categoria from categoria where nome <> 'PARTICULAR';";                   //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);           //prepara o instrução sql no banco
        rs = pstm.executeQuery();                   //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                           //cria condição enquanto resultado existe executa proximo passo 
            categoria = new Categoria();                          //estância o objeto
            categoria.setId(rs.getInt("idcategoria"));              //seta no bean o que trouxer do banco 
            categoria.setCategoria(rs.getString("categoria"));         //seta no bean o que trouxer do banco 
            lista.add(categoria);                          //adiciona tudo na lista 
        }                                           //fecha condição
        FabricaConexao.closeconnection();           //fecha conexao com o banco
        return lista;                                //retorna lista

    }

}
