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
import model.bean.OM;
import model.connection.FabricaConexao;

/**
 *
 * @author ASUS
 */
public class OMDao {

    private PreparedStatement pstm; // Prepara a inserção no banco mais segura que Statement, utilizando parametros e evita ataque de sql injection 
    private Connection con;         // executa a conexão com o banco
    private String sql;             // recebe a instrução que será enviada para o banco 
    private ResultSet rs;           // retorna a consulta no banco de dados

    public void Cadastrar(OM entidade) throws Exception {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "insert into om values (default,?) "; // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);           // prepara o instrução sql no banco
        pstm.setString(1, entidade.getOm());        // prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                             // executa a instrução sql
        FabricaConexao.closeconnection();           // fechar conexao com o banco
    }

    public void alterar(OM entidade) throws Exception {
        con = FabricaConexao.getconnection();          //abre a conexao no banco
        sql = "update om set nome = ? where id = ?;";  //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);              //prepara o instrução sql no banco
        pstm.setString(1, entidade.getOm());           //prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(2, entidade.getId());              //prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                                //executa a instrução sql
        FabricaConexao.closeconnection();              // fecha conexao com o banco
    }

    public List<OM> listEntidade() throws Exception {
        OM om = null;                               //Declarao classe cria um variavel e atribe o valor null;
        List<OM> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();       //abre conexao    
        sql = "select left(nome,2) as dois, id as idom, nome as om from om\n"
                + "order by dois not like '%º%',nome asc;";                   //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);           //prepara o instrução sql no banco
        rs = pstm.executeQuery();                   //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                           //cria condição enquanto resultado existe executa proximo passo 
            om = new OM();                          //estância o objeto
            om.setId(rs.getInt("idom"));              //seta no bean o que trouxer do banco 
            om.setOm(rs.getString("om"));         //seta no bean o que trouxer do banco 
            lista.add(om);                          //adiciona tudo na lista 
        }                                           //fecha condição
        FabricaConexao.closeconnection();           //fecha conexao com o banco
        return lista;                                //retorna lista

    }

    public List<OM> listaOmPorNome(String busca) throws Exception {

        List<OM> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();       //abre conexao    
        sql = "select id as idom, nome as om from om where nome like ?;";                   //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);           //prepara o instrução sql no banco
        pstm.setString(1, "%" + busca + "%");           //prepara o instrução sql no banco
        rs = pstm.executeQuery();                   //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                           //cria condição enquanto resultado existe executa proximo passo 
            OM om = new OM();                          //estância o objeto
            om.setId(rs.getInt("idom"));              //seta no bean o que trouxer do banco 
            om.setOm(rs.getString("om"));         //seta no bean o que trouxer do banco 
            lista.add(om);                          //adiciona tudo na lista 
        }                                           //fecha condição
        FabricaConexao.closeconnection();           //fecha conexao com o banco
        return lista;                                //retorna lista

    }

}
