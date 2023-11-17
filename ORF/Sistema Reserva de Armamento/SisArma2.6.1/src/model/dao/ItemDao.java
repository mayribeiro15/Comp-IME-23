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
import model.bean.Arma;
import model.bean.Calibre;
import model.bean.Cautela;
import model.bean.Destino;
import model.bean.Equipamento;
import model.bean.Fabricante;
import model.bean.FuncaoMilitar;
import model.bean.Item;
import model.bean.Militar;
import model.connection.FabricaConexao;

/**
 *
 * @author ASUS
 */
public class ItemDao {

    private PreparedStatement pstm; // Prepara a inserção no banco mais segura que Statement, utilizando parametros e evita ataque de sql injection 
    private Connection con;         // executa a conexão com o banco
    private String sql;             // recebe a instrução que será enviada para o banco 
    private ResultSet rs;           // retorna a consulta no banco de dados

    public void Cadastrar(Item entidade) throws Exception {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "insert into item (qtd,dtcautela,obs,statusite,idcautela,idequipamento) values (?,now(),?,?,?,?);";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                          // prepara o instrução sql no banco
        pstm.setInt(1, entidade.getQtd());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(2, entidade.getObs());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(3, entidade.getStatus());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(4, entidade.getCautela().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(5, entidade.getEquipamento().getId());                // prepara os dados utilizando os parametros pegando do bean        
        pstm.execute();                                      // executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();                   // fechar conexao com o banco
    }

    public void descautelarItem(Item ite) throws SQLException {
        con = FabricaConexao.getconnection();          //abre a conexao no banco
        sql = "update item set dtdescautela = now(), obs = ?, idArmeiro = ?, idOficialDia = ?, statusIte = 'DESCAUTELADO' where id = ?;";  //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);              //prepara o instrução sql no banco
        pstm.setObject(1, ite.getObs());           //prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(2, ite.getArmeiroDescautela().getId());           //prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(3, ite.getOficialDia().getId());
        pstm.setInt(4, ite.getId());           //prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                                //executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();              // fecha conexao com o banco
    }

    public List<Item> listaDescautela(String login) throws Exception {
        List<Item> lista = new ArrayList<>();
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select item.id as iditem, equipamento.id as ideqp, militar.login as militar, \n"
                + "item.dtcautela as datacautela, item.qtd as qtd,\n"
                + "equipamento.nome as equipamento, ifnull(equipamento.serie, '  -') as serie, \n"
                + "ifnull(arma.nome,'  -') as arma, ifnull(calibre.nome,'  -') as calibre, "
                + "ifnull(fabricante.nome,'  -') as fabricante,\n"
                + "destino.nome as destino, item.statusIte as statusite,\n"
                + "item.obs as obsite\n"
                + " from item\n"
                + "inner join cautela on cautela.id = item.idCautela\n"
                + "inner join destino on destino.id = cautela.idDestino\n"
                + "inner join equipamento on equipamento.id = item.idEquipamento\n"
                + "left join arma on equipamento.idarma = arma.id  \n"
                + "left join calibre on equipamento.idCalibre = calibre.id\n"
                + "left join fabricante on equipamento.idFabricante = fabricante.id \n"
                + "inner join militar on militar.id = cautela.idMilitar where militar.idmilitar = ? and item.statusIte = 'Cautelado'";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, login);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();
        while (rs.next()) {
            Item ite = new Item();                              //estância o objeto
            ite.setId(rs.getInt("iditem"));             //seta no bean o que trouxer do banco 
            ite.setQtd(rs.getInt("qtd"));
            ite.setStatus(rs.getString("statusite"));             //seta no bean o que trouxer do banco 
            ite.setObs(rs.getString("obsite"));             //seta no bean o que trouxer do banco 
            ite.setData_cautela(rs.getTimestamp("datacautela"));             //seta no bean o que trouxer do banco 
            Cautela cau = new Cautela();                              //estância o objeto
            Destino des = new Destino();                              //estância o objeto
            des.setDestino(rs.getString("destino"));        //seta no bean o que trouxer do banco 
            cau.setDestino(des);
            ite.setCautela(cau);
            Equipamento eqp = new Equipamento();                              //estância o objeto
            eqp.setId(rs.getInt("ideqp"));                  //seta no bean o que trouxer do banco 
            eqp.setSerie(rs.getString("serie"));             //seta no bean o que trouxer do banco 
            eqp.setNome(rs.getString("equipamento"));
            ite.setEquipamento(eqp);
            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            eqp.setArma(ar);
            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            eqp.setFabricante(fab);             //seta no bean o que trouxer do banco 
            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            eqp.setCalibre(cal);             //seta no bean o que trouxer do banco 
            lista.add(ite);                         //adiciona tudo na lista 
        }

        FabricaConexao.closeconnection();
        //fecha conexao com o banco

        return lista;

    }

    public List<Item> listItemStatus(String status) throws Exception {

        List<Item> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "	  select militar.login as militar,\n"
                + "                   armeiro.login as cautelou,\n"
                + "                   item.dtcautela as datacautela,	\n"
                + "                   item.dtdescautela as datadescautela				   ,\n"
                + "                   item.qtd as qtd,\n"
                + "                   equipamento.nome as equipamento, \n"
                + "                   equipamento.serie as serie, \n"
                + "                   arma.nome as arma, \n"
                + "                   calibre.nome as calibre,\n"
                + "                   fabricante.nome as fabricante,\n"
                + "                   destino.nome as destino, item.statusIte as statusite,\n"
                + "                   item.obs as obsite,\n"
                + "                   descautela.login as descautelou\n"
                + "                   from item\n"
                + "				   left join funcaomilitar f on f.id = item.idArmeiro\n"
                + "                   left join militar as descautela on descautela.id = f.idMilitar                 \n"
                + "                   inner join cautela on cautela.id = item.idCautela\n"
                + "                   inner join destino on destino.id = cautela.idDestino\n"
                + "                   inner join funcaomilitar on funcaomilitar.id = cautela.idFuncaoMilitar\n"
                + "                   inner join funcao on funcao.id = funcaomilitar.idFuncao\n"
                + "                   inner join militar as armeiro on armeiro.id = funcaomilitar.idMilitar\n"
                + "                   inner join equipamento on equipamento.id = item.idEquipamento\n"
                + "                   left join arma on equipamento.idarma = arma.id \n"
                + "                   left join calibre on equipamento.idCalibre = calibre.id\n"
                + "                   left join fabricante on equipamento.idFabricante = fabricante.id\n"
                + "                   inner join militar on militar.id = cautela.idMilitar \n"
                + "                   where item.statusIte = ? order by datacautela desc;   ";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, status);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            Item ite = new Item();
            ite.setQtd(rs.getInt("qtd"));
            ite.setStatus(rs.getString("statusite"));             //seta no bean o que trouxer do banco 
            ite.setObs(rs.getString("obsite"));             //seta no bean o que trouxer do banco 
            ite.setData_cautela(rs.getDate("datacautela"));             //seta no bean o que trouxer do banco 
            ite.setData_descautela(rs.getDate("datadescautela"));             //seta no bean o que trouxer do banco 
            ite.setObs(rs.getString("obsite"));

            Militar mil = new Militar();
            mil.setLogin(rs.getString("militar"));

            Militar armeiro = new Militar();
            armeiro.setLogin(rs.getString("cautelou"));

            FuncaoMilitar funmil = new FuncaoMilitar();
            funmil.setMilitar(armeiro);

            Militar descautela = new Militar();
            descautela.setLogin(rs.getString("descautelou"));

            FuncaoMilitar fundesc = new FuncaoMilitar();
            fundesc.setMilitar(descautela);

            ite.setArmeiroDescautela(fundesc);

            Cautela cau = new Cautela();                              //estância o objeto

            cau.setMilitar(mil);
            cau.setFuncaomilitar(funmil);

            Destino des = new Destino();                              //estância o objeto
            des.setDestino(rs.getString("destino"));        //seta no bean o que trouxer do banco 
            cau.setDestino(des);
            ite.setCautela(cau);

            Equipamento eqp = new Equipamento();                              //estância o objeto
            eqp.setSerie(rs.getString("serie"));             //seta no bean o que trouxer do banco 
            eqp.setNome(rs.getString("equipamento"));

            ite.setEquipamento(eqp);

            Arma ar = new Arma();                              //estância o objeto

            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            eqp.setArma(ar);

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            eqp.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            eqp.setCalibre(cal);             //seta no bean o que trouxer do banco 

            lista.add(ite);                         //adiciona tudo na lista 
        }

        FabricaConexao.closeconnection();
        //fecha conexao com o banco
        return lista;                                       //retorna lista
    }

    public List<Item> historicoMilitar(String login) throws Exception {
        List<Item> lista = new ArrayList<>();
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select item.id as iditem, equipamento.id as ideqp, militar.login as militar, \n"
                + "item.dtcautela as datacautela, item.qtd as qtd,\n"
                + "equipamento.nome as equipamento, equipamento.serie as serie, \n"
                + "arma.nome as arma, calibre.nome as calibre, fabricante.nome as fabricante,\n"
                + "destino.nome as destino, item.statusIte as statusite,\n"
                + "item.obs as obsite\n"
                + " from item\n"
                + "inner join cautela on cautela.id = item.idCautela\n"
                + "inner join destino on destino.id = cautela.idDestino\n"
                + "inner join equipamento on equipamento.id = item.idEquipamento\n"
                + "left join arma on equipamento.idarma = arma.id  \n"
                + "left join calibre on equipamento.idCalibre = calibre.id\n"
                + "left join fabricante on equipamento.idFabricante = fabricante.id \n"
                + "inner join militar on militar.id = cautela.idMilitar where militar.login = ? and item.statusIte = 'Cautelado'";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, login);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();
        while (rs.next()) {
            Item ite = new Item();                              //estância o objeto
            ite.setId(rs.getInt("iditem"));             //seta no bean o que trouxer do banco 
            ite.setQtd(rs.getInt("qtd"));
            ite.setStatus(rs.getString("statusite"));             //seta no bean o que trouxer do banco 
            ite.setObs(rs.getString("obsite"));             //seta no bean o que trouxer do banco 
            ite.setData_cautela(rs.getTimestamp("datacautela"));             //seta no bean o que trouxer do banco 
            Cautela cau = new Cautela();                              //estância o objeto
            Destino des = new Destino();                              //estância o objeto
            des.setDestino(rs.getString("destino"));        //seta no bean o que trouxer do banco 
            cau.setDestino(des);
            ite.setCautela(cau);
            Equipamento eqp = new Equipamento();                              //estância o objeto
            eqp.setId(rs.getInt("ideqp"));                  //seta no bean o que trouxer do banco 
            eqp.setSerie(rs.getString("serie"));             //seta no bean o que trouxer do banco 
            eqp.setNome(rs.getString("equipamento"));
            ite.setEquipamento(eqp);
            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            eqp.setArma(ar);
            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            eqp.setFabricante(fab);             //seta no bean o que trouxer do banco 
            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            eqp.setCalibre(cal);             //seta no bean o que trouxer do banco 
            lista.add(ite);                         //adiciona tudo na lista 
        }

        FabricaConexao.closeconnection();
        //fecha conexao com o banco

        return lista;

    }

}
