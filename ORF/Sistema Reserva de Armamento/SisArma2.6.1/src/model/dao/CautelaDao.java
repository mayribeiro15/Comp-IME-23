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
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Cautela;
import model.bean.Item;
import model.connection.FabricaConexao;

/**
 *
 * @author ASUS
 */
public class CautelaDao {

    private PreparedStatement pstm; // Prepara a inserção no banco mais segura que Statement, utilizando parametros e evita ataque de sql injection 
    private Connection con;         // executa a conexão com o banco
    private String sql;             // recebe a instrução que será enviada para o banco 
    private ResultSet rs;           // retorna a consulta no banco de dados

    public int getIdCautela() {
        int id = 0;
        con = FabricaConexao.getconnection();
        sql = "select max(id) id from cautela;";
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar id da cautela" + ex.getMessage());
        }
        
        FabricaConexao.closeconnection();
        return id;
    }

    public void registrarCautela(Cautela cautela, List<Item> lista) throws Exception {
        int contador = 0;
        ItemDao itemDao = new ItemDao();
        Cadastrar(cautela);
        cautela.setId(getIdCautela());
        for (Item item : lista) {
            item.setCautela(cautela);
            itemDao.Cadastrar(item);
            contador++;
        }
        
        FabricaConexao.closeconnection();
        JOptionPane.showMessageDialog(null,"  "+contador + " ITEM CAUTELADO \n "
                + "CAUTELA ENCERRADA ");
        
    }

    public void Cadastrar(Cautela entidade) throws Exception {
        con = FabricaConexao.getconnection();
        sql = "insert into cautela (idDestino,idMilitar,idFuncaoMilitar) values (?,?,?);";
        pstm = con.prepareStatement(sql);
        pstm.setInt(1, entidade.getDestino().getId());
        pstm.setInt(2, entidade.getMilitar().getId());
        pstm.setInt(3, entidade.getFuncaomilitar().getId());
        pstm.execute();
        pstm.close();
        FabricaConexao.closeconnection();

    }

}
