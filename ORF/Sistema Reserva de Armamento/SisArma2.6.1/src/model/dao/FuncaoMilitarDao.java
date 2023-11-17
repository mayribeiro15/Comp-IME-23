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
import model.bean.FuncaoMilitar;
import model.bean.Militar;
import model.connection.FabricaConexao;

/**
 *
 * @author ASUS
 */
public class FuncaoMilitarDao {

    private PreparedStatement pstm; // Prepara a inserção no banco mais segura que Statement, utilizando parametros e evita ataque de sql injection 
    private Connection con;         // executa a conexão com o banco
    private String sql;             // recebe a instrução que será enviada para o banco 
    private ResultSet rs;           // retorna a consulta no banco de dados

    public void Cadastrar(FuncaoMilitar entidade) throws Exception {
        con = FabricaConexao.getconnection();                         // abre a conexao no banco
        sql = "insert into funcaomilitar values (default,'ATIVO',?,?)";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                             // prepara o instrução sql no banco
        pstm.setInt(1, entidade.getMilitar().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(2, entidade.getFuncao().getId());                 // prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                                               // executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();                             // fechar conexao com o banco
    }

    public void alterar(FuncaoMilitar entidade) throws Exception {
        con = FabricaConexao.getconnection();          //abre a conexao no banco
        sql = "update funcaomilitar set statusFM = ? where id = ?;";  //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);              //prepara o instrução sql no bancopstm.setString(1, entidade.getNome());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(1, entidade.getStatus());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(2, entidade.getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                                //executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();              // fecha conexao com o banco
    }

    public FuncaoMilitar pesqPorId(int idmilitar) throws Exception {
        FuncaoMilitar fm = null;
        con = FabricaConexao.getconnection();
        sql = "select funcaomilitar.id, funcaomilitar.statusFM, militar.id, militar.login, funcao.id, funcao.nome from funcaomilitar\n"
                + "inner join militar on militar.id = funcaomilitar.idMilitar\n"
                + "inner join funcao on funcao.id = funcaomilitar.idFuncao\n"
                + "where funcaomilitar.idMilitar = ?;";
        pstm = con.prepareStatement(sql);
        pstm.setInt(1, idmilitar);
        rs = pstm.executeQuery();
        if (rs.next()) {
            Militar mil = new Militar();
            Funcao fun = new Funcao();
            fm = new FuncaoMilitar();
            fm.setStatus(rs.getString("funcaomilitar.statusFm"));
            mil.setId(rs.getInt("militar.id"));
            mil.setLogin(rs.getString("militar.login"));
            fm.setMilitar(mil);
            fun.setId(rs.getInt("funcao.id"));
            fun.setFuncao(rs.getString("funcao.nome"));
            fm.setFuncao(fun);
            fm.setId(rs.getInt("funcaomilitar.id"));
        }

        FabricaConexao.closeconnection();
        return fm;

    }

     public String buscaInpescionador(String idInpescionador) throws Exception {
        String inspecionador = null;
        con = FabricaConexao.getconnection();
        sql = "select login from militar where idmilitar = ?;";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, idInpescionador);
        rs = pstm.executeQuery();
        if (rs.next()) {
            inspecionador = (rs.getString("login"));
        }
        FabricaConexao.closeconnection();
        return inspecionador;
    }
     
    public String buscaArmeiro(int idfuncaomilitar) throws Exception {
        String armeiro = null;
        con = FabricaConexao.getconnection();
        sql = "select militar.login as armeiro from funcaomilitar\n"
                + "inner join militar on militar.id = funcaomilitar.idMilitar\n"
                + "where funcaomilitar.id = ?;";
        pstm = con.prepareStatement(sql);
        pstm.setInt(1, idfuncaomilitar);
        rs = pstm.executeQuery();
        if (rs.next()) {
            armeiro = (rs.getString("armeiro"));
        }
        FabricaConexao.closeconnection();
        return armeiro;
    }

    public List<FuncaoMilitar> pesqFuncao(String status) throws SQLException {
        List<FuncaoMilitar> lista = new ArrayList<>();
        con = FabricaConexao.getconnection();
        sql = "select militar.nome as nome , militar.login as login , funcao.nome as funcao, funcaomilitar.statusFM as status from funcaomilitar \n"
                + "inner join militar on militar.id = funcaomilitar.idMilitar\n"
                + "inner join funcao on funcao.id = idfuncao where funcao.nome= ?;";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, status);
        rs = pstm.executeQuery();
        while (rs.next()) {
            FuncaoMilitar funcao = new FuncaoMilitar();
            Militar mil = new Militar();
            mil.setNome(rs.getString("nome"));
            mil.setLogin(rs.getString("login"));
            Funcao fun = new Funcao();
            fun.setFuncao(rs.getString("funcao"));
            funcao.setStatus(rs.getString("status"));
            funcao.setMilitar(mil);
            funcao.setFuncao(fun);
            lista.add(funcao);
        }
        return lista;
    }

    public List<FuncaoMilitar> buscaFuncoes(String identidade) throws SQLException {
        List<FuncaoMilitar> lista = new ArrayList<>();
        con = FabricaConexao.getconnection();
        sql = "select funcaomilitar.id as funcaomilitar, militar.id as militar, funcao.nome as funcao, funcaomilitar.statusfm as 'status' from funcaomilitar\n"
                + "inner join militar on militar.id = funcaomilitar.idmilitar\n"
                + "inner join funcao on funcao.id = funcaomilitar.idfuncao\n"
                + "where militar.idmilitar = ?;";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, identidade);
        rs = pstm.executeQuery();
        while (rs.next()) {
            Militar militar = new Militar();
            Funcao funcao = new Funcao();
            militar.setId(rs.getInt("militar"));
            funcao.setFuncao(rs.getString("funcao"));
            FuncaoMilitar funcaomilitar = new FuncaoMilitar();
            funcaomilitar.setStatus(rs.getString("status"));
            funcaomilitar.setId(rs.getInt("funcaomilitar"));
            funcaomilitar.setFuncao(funcao);
            funcaomilitar.setMilitar(militar);
            lista.add(funcaomilitar);
        }
        FabricaConexao.closeconnection();
        return lista;
    }


}