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
import model.bean.Calibre;
import model.bean.Categoria;
import model.bean.Equipamento;
import model.bean.Fabricante;
import model.bean.ItemParticular;
import model.bean.Militar;
import model.connection.FabricaConexao;

/**
 *
 * @author Asus
 */
public class ItemParticularDao {

    private PreparedStatement pstm; // Prepara a inserção no banco mais segura que Statement, utilizando parametros e evita ataque de sql injection 
    private Connection con;         // executa a conexão com o banco
    private String sql;             // recebe a instrução que será enviada para o banco 
    private ResultSet rs;

    public void Cadastrar(ItemParticular entidade) throws Exception {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "insert into itemparticular (idEquipamento,idArmeiroEntrada,idMilitarEntrada,situacao,dataEntrada) values (?,?,?,'RECEBIDO',now());";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                          // prepara o instrução sql no banco
        pstm.setObject(1, entidade.getEquipamento().getId());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(2, entidade.getArmeiro().getId());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(3, entidade.getMilitar().getId());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                                      // executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();                   // fechar conexao com o banco
    }

    public void Saida(ItemParticular entidade) throws Exception {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "update itemparticular set situacao = 'ENTREGUE', idMilitarSaida = ?, idArmeiroSaida = ?, dataSaida = now() where id = ?;";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                          // prepara o instrução sql no banco
        pstm.setObject(1, entidade.getMilitar().getId());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(2, entidade.getArmeiro().getId());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(3, entidade.getId());
        pstm.execute();                                      // executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();                   // fechar conexao com o banco
    }

    public List<ItemParticular> listporSituacao(String status) throws Exception {

        List<ItemParticular> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select armamento.nome as nome, armamento.serie serie, armamento.obs obs, a.nome arma, f.nome fabricante, c.nome calibre,\n"
                + "		itemparticular.dataEntrada, itemparticular.dataSaida, \n"
                + "        armeiroentrada.login as armeiroEntrada, armeirosaida.login as armeiroSaida,\n"
                + "        respentrada.login as responsavelEntrada, respsaida.login as responsavelSaida\n"
                + "				from itemparticular\n"
                + "                inner join equipamento armamento on armamento.id = itemparticular.idEquipamento\n"
                + "                left join arma a on a.id = armamento.idArma\n"
                + "                left join fabricante f on f.id = armamento.idFabricante\n"
                + "                left join calibre c on c.id = armamento.idCalibre\n"
                + "                left join funcaomilitar as entrada on entrada.id = itemparticular.idArmeiroEntrada\n"
                + "                left join militar as armeiroentrada on armeiroentrada.id = entrada.idMilitar\n"
                + "                left join funcaomilitar as saida on saida.id = itemparticular.idArmeiroSaida\n"
                + "                left join militar as armeirosaida on armeirosaida.id = entrada.idMilitar\n"
                + "                left join militar as respentrada on respentrada.id = itemparticular.idMilitarEntrada\n"
                + "                left join militar as respsaida on respsaida.id = itemparticular.idMilitarSaida\n"
                + "                where itemparticular.situacao = ?;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, status);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            ItemParticular item = new ItemParticular();

            item.setDataentrada(rs.getDate("dataEntrada"));
            item.setDatasaida(rs.getDate("dataSaida"));

            Militar armeiroEntrada = new Militar();
            armeiroEntrada.setLogin(rs.getString("armeiroEntrada"));
            item.setArmeiroEntrada(armeiroEntrada);

            Militar armeiroSaida = new Militar();
            armeiroSaida.setLogin(rs.getString("armeiroSaida"));
            item.setArmeiroSaida(armeiroSaida);

            Militar responsalveEntrada = new Militar();
            responsalveEntrada.setLogin(rs.getString("responsavelEntrada"));
            item.setResponsavelEntrada(responsalveEntrada);

            Militar responsavelSaida = new Militar();
            responsavelSaida.setLogin(rs.getString("responsavelSaida"));
            item.setResponsavelSaida(responsavelSaida);

            Equipamento eqp = new Equipamento();
            eqp.setNome(rs.getString("nome"));
            eqp.setSerie(rs.getString("serie"));
            eqp.setObs(rs.getString("obs"));
            item.setEquipamento(eqp);

            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            eqp.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            eqp.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            eqp.setCalibre(cal);             //seta no bean o que trouxer do banco 

            lista.add(item);
        }                                               //fecha condição
        FabricaConexao.closeconnection();
        //fecha conexao com o banco
        return lista;                                       //retorna lista

    }
}
