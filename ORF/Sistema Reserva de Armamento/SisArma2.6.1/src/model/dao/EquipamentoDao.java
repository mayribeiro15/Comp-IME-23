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
import model.bean.Equipamento;
import model.bean.Calibre;
import model.bean.Categoria;
import model.bean.Fabricante;
import model.connection.FabricaConexao;

/**
 *
 * @author ASUS
 */
public class EquipamentoDao {

    private PreparedStatement pstm; // Prepara a inserção no banco mais segura que Statement, utilizando parametros e evita ataque de sql injection 
    private Connection con;         // executa a conexão com o banco
    private String sql;             // recebe a instrução que será enviada para o banco 
    private ResultSet rs;           // retorna a consulta no banco de dados    

    public void cadastrarArmamentoComBaioneta(Equipamento entidade) throws Exception {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "call sp_inserirArmamento(?,?,?,?,?,?,?,?,?,?,?,?); ";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                          // prepara o instrução sql no banco
        pstm.setString(1, entidade.getNome());
        pstm.setString(2, entidade.getSerie());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(3, entidade.getStatus());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(4, entidade.getQtd());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(5, entidade.getObs());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(6, entidade.getTipo());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(7, entidade.getArma().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(8, entidade.getFabricante().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(9, entidade.getCalibre().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(10, entidade.getCategoria().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(11, entidade.getAcessorio().getId());          // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(12, entidade.getArmeiro().getId());          // prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                                      // executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();                   // fechar conexao com o banco

    }

    public void cadastrarArmamentoSemBaioneta(Equipamento entidade) throws Exception {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "call sp_inserirArmamento(?,?,?,?,?,?,?,?,?,?,?,?); ";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                          // prepara o instrução sql no banco
        pstm.setString(1, entidade.getNome());
        pstm.setString(2, entidade.getSerie());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(3, entidade.getStatus());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(4, entidade.getQtd());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(5, entidade.getObs());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(6, entidade.getTipo());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(7, entidade.getArma().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(8, entidade.getFabricante().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(9, entidade.getCalibre().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(10, entidade.getCategoria().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(11, entidade.getAcessorio());          // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(12, entidade.getArmeiro().getId());
        pstm.execute();                                      // executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();                   // fechar conexao com o banco

    }

    public void cadastrarAcessorio(Equipamento entidade) throws Exception {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "insert into equipamento (nome, serie, statusEqp, qtd, obs, tipo, idCategoria, idArmeiro)"
                + " values (?,?,?,?,?,?,?,?); ";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                          // prepara o instrução sql no banco
        pstm.setString(1, entidade.getNome());
        pstm.setString(2, entidade.getSerie());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(3, entidade.getStatus());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(4, entidade.getQtd());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(5, entidade.getObs());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(6, entidade.getTipo());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(7, entidade.getCategoria().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(8, entidade.getArmeiro().getId());
        pstm.execute();                                      // executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();                   // fechar conexao com o banco

    }

    public void alterar(Equipamento entidade) throws Exception {
        con = FabricaConexao.getconnection();          //abre a conexao no banco
        sql = "update equipamento set nome = ?, serie = ?, statusEqp = ?, obs = ?, qtd = ?, idCategoria = ? where id = ?;";
        pstm = con.prepareStatement(sql);
        pstm.setObject(1, entidade.getNome());
        pstm.setObject(2, entidade.getSerie());
        pstm.setString(3, entidade.getStatus());
        pstm.setObject(4, entidade.getObs());
        pstm.setInt(5, entidade.getQtd());
        pstm.setObject(6, entidade.getCategoria().getId());
        pstm.setInt(7, entidade.getId());
        pstm.execute();
        pstm.close();
        FabricaConexao.closeconnection();
    }

    public void registraAlteracao(Equipamento entidade) throws Exception {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "insert into alteracaoEquipamento(id, nome, serie, statuseqp, qtd, obs, tipo, dataalteracao, Arma, Fabricante, Calibre, Categoria, idArmeiro, idOficialDia)\n"
                + " values (?,?,?,?,?,?,?,now(),?,?,?,?,?,?);";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                          // prepara o instrução sql no banco
        pstm.setInt(1, entidade.getId());
        pstm.setString(2, entidade.getNome());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(3, entidade.getSerie());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(4, entidade.getStatus());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(5, entidade.getQtd());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(6, entidade.getObs());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(7, entidade.getTipo());
        pstm.setObject(8, entidade.getArma().getArma());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(9, entidade.getFabricante().getFabricante());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(10, entidade.getCalibre().getCalibre());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(11, entidade.getCategoria().getCategoria());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(12, entidade.getArmeiro().getId());          // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(13, entidade.getOficialDia().getId());
        pstm.execute();                                      // executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();                   // fechar conexao com o banco

    }

    public void registraAlteracaoAcessorio(Equipamento entidade) throws Exception {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "insert into alteracaoEquipamento(id, nome, serie, statuseqp, qtd, obs, tipo, dataalteracao, categoria, idArmeiro, idOficialDia)\n"
                + " values (?,?,?,?,?,?,?,now(),?,?,?);";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                          // prepara o instrução sql no banco
        pstm.setInt(1, entidade.getId());
        pstm.setString(2, entidade.getNome());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(3, entidade.getSerie());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(4, entidade.getStatus());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(5, entidade.getQtd());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(6, entidade.getObs());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(7, entidade.getTipo());
        pstm.setObject(8, entidade.getCategoria().getCategoria());
        pstm.setObject(9, entidade.getArmeiro().getId());          // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(10, entidade.getOficialDia().getId());
        pstm.execute();                                      // executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();                   // fechar conexao com o banco

    }

    public void descautelar(Equipamento eqp) throws SQLException {
        con = FabricaConexao.getconnection();          //abre a conexao no banco
        sql = "update equipamento set equipamento.statusEqp = 'DISPONIVEL', "
                + "equipamento.qtd = equipamento.qtd + (?) where id = ?;";  //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);              //prepara o instrução sql no banco
        pstm.setInt(1, eqp.getQtd());          //prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(2, eqp.getId());           //prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                                //executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();              // fecha conexao com o banco
    }

    // metodo utizado na tela de pequisa equipamento para listar equipamentos por status
    public List<Equipamento> listEquipamentoPorStatus(String status) throws Exception {
        Equipamento arm = null;                                   //Declarao classe cria um variavel e atribe o valor null;
        List<Equipamento> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select\n"
                + "armamento.id as idarmamento,\n"
                + "armamento.nome as equipamento,\n"
                + "ifnull(armamento.serie, '-' )as seriearmamento,\n"
                + "armamento.tipo as tipo,\n"
                + "armamento.qtd as armqtd,\n"
                + "armamento.statuseqp as statuseqp,\n"
                + "ifnull(armamento.obs, '-') as 'obs',\n"
                + "ifnull(a.nome, '-')as arma,\n"
                + "ifnull(c.nome, '-')as calibre,\n"
                + "ifnull(f.nome, '-' )as fabricante,\n"
                + "ifnull(ca.nome, '-' )as categoria\n"
                + "from equipamento as armamento\n"
                + "left join arma a on a.id = armamento.idArma\n"
                + "left join fabricante f on f.id = armamento.idFabricante\n"
                + "left join calibre c on c.id = armamento.idCalibre\n"
                + "left join categoria ca on ca.id = armamento.idCategoria\n"
                + "where ca.nome <> 'PARTICULAR' and armamento.statuseqp = ? order by armamento.nome;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, status);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            arm = new Equipamento();                              //estância o objeto
            arm.setId(rs.getInt("idArmamento"));                  //seta no bean o que trouxer do banco 
            arm.setNome(rs.getString("equipamento"));             //seta no bean o que trouxer do banco 
            arm.setSerie(rs.getString("serieArmamento"));             //seta no bean o que trouxer do banco 
            arm.setQtd(rs.getInt("armqtd"));             //seta no bean o que trouxer do banco 
            arm.setTipo(rs.getString("tipo"));             //seta no bean o que trouxer do banco 
            arm.setStatus(rs.getString("statuseqp"));             //seta no bean o que trouxer do banco 
            arm.setObs(rs.getString("obs"));

            Categoria ca = new Categoria();
            ca.setCategoria(rs.getString("categoria"));
            arm.setCategoria(ca);

            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            arm.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            arm.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            arm.setCalibre(cal);             //seta no bean o que trouxer do banco 

            lista.add(arm);                         //adiciona tudo na lista 
        }                                               //fecha condição
        FabricaConexao.closeconnection();
        //fecha conexao com o banco
        return lista;                                       //retorna lista

    }

    // metodo utizado na tela de pequisa equipamento para listar equipamentos por tipo material
    public List<Equipamento> listEquipamentoTipoMaterial(String status) throws Exception {
        Equipamento arm = null;                                   //Declarao classe cria um variavel e atribe o valor null;
        List<Equipamento> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select\n"
                + "armamento.id as idarmamento,\n"
                + "armamento.nome as equipamento,\n"
                + "ifnull(armamento.serie, '-' )as seriearmamento,\n"
                + "armamento.tipo as tipo,\n"
                + "armamento.qtd as armqtd,\n"
                + "armamento.statuseqp as statuseqp,\n"
                + "ifnull(armamento.obs, '-') as 'obs',\n"
                + "ifnull(a.nome, '-')as arma,\n"
                + "ifnull(c.nome, '-')as calibre,\n"
                + "ifnull(f.nome, '-' )as fabricante,\n"
                + "ifnull(ca.nome, '-' )as categoria\n"
                + "from equipamento as armamento\n"
                + "left join arma a on a.id = armamento.idArma\n"
                + "left join fabricante f on f.id = armamento.idFabricante\n"
                + "left join calibre c on c.id = armamento.idCalibre\n"
                + "left join categoria ca on ca.id = armamento.idCategoria\n"
                + "where ca.nome = ? order by armamento.nome;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, status);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            arm = new Equipamento();                              //estância o objeto
            arm.setId(rs.getInt("idArmamento"));                  //seta no bean o que trouxer do banco 
            arm.setNome(rs.getString("equipamento"));             //seta no bean o que trouxer do banco 
            arm.setSerie(rs.getString("serieArmamento"));             //seta no bean o que trouxer do banco 
            arm.setQtd(rs.getInt("armqtd"));             //seta no bean o que trouxer do banco 
            arm.setTipo(rs.getString("tipo"));             //seta no bean o que trouxer do banco 
            arm.setStatus(rs.getString("statuseqp"));             //seta no bean o que trouxer do banco 
            arm.setObs(rs.getString("obs"));

            Categoria ca = new Categoria();
            ca.setCategoria(rs.getString("categoria"));
            arm.setCategoria(ca);

            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            arm.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            arm.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            arm.setCalibre(cal);             //seta no bean o que trouxer do banco 

            lista.add(arm);                         //adiciona tudo na lista 
        }                                               //fecha condição
        FabricaConexao.closeconnection();
        //fecha conexao com o banco
        return lista;                                       //retorna lista

    }

    // metodo listBaioneta é utilizada para listar no comboBox da tela cadastro do equipamento
    // para listar somente as baionetas que não possuem cadastrado em um armamento
    public List<Equipamento> listBaioneta() throws SQLException {
        Equipamento bai = null;
        List<Equipamento> lista = new ArrayList<>();
        con = FabricaConexao.getconnection();
        sql = "select e.id as idbaioneta, e.nome as baioneta, e.serie as "
                + "serie from equipamento e where nome = 'baioneta' "
                + "and e.idEquipamento is null;";
        pstm = con.prepareStatement(sql);
        rs = pstm.executeQuery();
        while (rs.next()) {
            bai = new Equipamento();
            bai.setId(rs.getInt("idbaioneta"));
            bai.setNome(rs.getString("baioneta"));
            bai.setSerie(rs.getString("serie"));
            lista.add(bai);
        }

        return lista;
    }

    // metodo utilizado na pesquisa de equipamento para fazer uso de filtro
    public List<Equipamento> listFiltro(String nome, String serie, String arma, String fabricante, String calibre) throws Exception {
        Equipamento arm = null;                                   //Declarao classe cria um variavel e atribe o valor null;
        List<Equipamento> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql =" select armamento.id as idarmamento, \n"
                + "                	  armamento.nome as nome,\n"
                + "                       ifnull(armamento.serie, '-') as seriearmamento,\n"
                + "                       armamento.tipo as tipo,\n"
                + "                       armamento.qtd as armqtd,\n"
                + "                       armamento.statusEqp as 'status',\n"
                + "                       ifnull(armamento.obs, '-') as 'obs',\n"
                + "                       ifnull(a.nome, '-')as arma,\n"
                + "                       ifnull(c.nome, '-')as calibre,\n"
                + "                       ifnull(f.nome, '-')as fabricante,\n"
                + "                       ifnull(ca.nome, '-')as categoria\n"
                + "                       from equipamento as armamento\n"
                + "                       left join arma a on a.id = armamento.idArma\n"
                + "                       left join fabricante f on f.id = armamento.idFabricante\n"
                + "                       left join calibre c on c.id = armamento.idCalibre\n"
                + "                       left join categoria ca on ca.id = armamento.idCategoria\n"
                + "                       where ca.nome <> 'PARTICULAR' and armamento.nome like (?) or armamento.serie like (?) or \n"
                + "                       a.nome like (?) or \n"
                + "                       f.nome like (?) or \n"
                + "                       c.nome like (?);";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setObject(1, "%" + nome + "%");               //prepara o instrução sql no banco
        pstm.setObject(2, "%" + serie + "%");               //prepara o instrução sql no banco
        pstm.setObject(3, "%" + arma + "%");               //prepara o instrução sql no banco
        pstm.setObject(4, "%" + fabricante + "%");               //prepara o instrução sql no banco
        pstm.setObject(5, "%" + calibre + "%");               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            arm = new Equipamento();                              //estância o objeto
            arm.setId(rs.getInt("idarmamento"));             //seta no bean o que trouxer do banco 
            arm.setNome(rs.getString("nome"));             //seta no bean o que trouxer do banco 
            arm.setSerie(rs.getString("seriearmamento"));             //seta no bean o que trouxer do banco 
            arm.setTipo(rs.getString("tipo"));
            arm.setQtd(rs.getInt("armqtd"));
            arm.setStatus(rs.getString("status"));
            arm.setObs(rs.getString("obs"));

            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            arm.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            arm.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            arm.setCalibre(cal);             //seta no bean o que trouxer do banco 
            lista.add(arm);
        }                                               //fecha condição
        FabricaConexao.closeconnection();
        return lista;
    }

    // metodo utilizado na pesquisa de equipamento particulares na hora de realizar a entrega do mesmo 
    public List<Equipamento> listEqpParituclar() throws Exception {
        List<Equipamento> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select itemparticular.id id, armamento.nome as nome, armamento.serie serie,\n"
                + "armamento.obs obs, a.nome arma, f.nome fabricante, c.nome calibre  from itemparticular\n"
                + "inner join equipamento armamento on armamento.id = itemparticular.idEquipamento\n"
                + "left join arma a on a.id = armamento.idArma\n"
                + "left join fabricante f on f.id = armamento.idFabricante\n"
                + "left join calibre c on c.id = armamento.idCalibre\n"
                + "where dataSaida is null;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 

            Equipamento arm = new Equipamento();                              //estância o objeto
            arm.setId(rs.getInt("id"));             //seta no bean o que trouxer do banco 
            arm.setNome(rs.getString("nome"));             //seta no bean o que trouxer do banco 
            arm.setSerie(rs.getString("serie"));             //seta no bean o que trouxer do banco 
            arm.setObs(rs.getString("obs"));

            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            arm.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            arm.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            arm.setCalibre(cal);             //seta no bean o que trouxer do banco 
            lista.add(arm);
        }                                               //fecha condição
        FabricaConexao.closeconnection();
        return lista;
    }

    // metodo pesq é utilizado na tela cautela para pesquisar o armamento
    public Equipamento pesq(String entidade) throws Exception {
        Equipamento arm = null;                                   //Declarao classe cria um variavel e atribe o valor null;v
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select \n"
                + "armamento.id as idarmamento, \n"
                + "armamento.serie as seriearmamento,\n"
                + "armamento.tipo as tipo,\n"
                + "armamento.qtd as armqtd,\n"
                + "a.nome as arma,\n"
                + "c.nome as calibre,\n"
                + "f.nome as fabricante,\n"
                + "acessorio.id as idacessorio,\n"
                + "acessorio.nome as acessorio,\n"
                + "acessorio.serie as serieacessorio,\n"
                + "acessorio.qtd as qtdacessorio\n"
                + "from equipamento as armamento\n"
                + "inner join arma a on a.id = armamento.idArma\n"
                + "inner join fabricante f on f.id = armamento.idFabricante\n"
                + "inner join calibre c on c.id = armamento.idCalibre\n"
                + "left join categoria ca on ca.id = armamento.idCategoria\n"
                + "left join equipamento as acessorio on acessorio.id = armamento.idEquipamento"
                + " where ca.nome <> 'PARTICULAR' and armamento.serie = ? and armamento.statuseqp = 'Disponivel';";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, entidade);                    //prepara os dados utilizando os parametros pegando da tela
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        if (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            arm = new Equipamento();                              //estância o objeto
            arm.setId(rs.getInt("idarmamento"));             //seta no bean o que trouxer do banco 
            arm.setSerie(rs.getString("seriearmamento"));             //seta no bean o que trouxer do banco 
            arm.setTipo(rs.getString("tipo"));
            arm.setQtd(rs.getInt("armqtd"));

            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            arm.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            arm.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            arm.setCalibre(cal);             //seta no bean o que trouxer do banco 

            Equipamento ace = new Equipamento();                              //estância o objeto
            ace.setId(rs.getInt("idacessorio"));             //seta no bean o que trouxer do banco 
            ace.setNome(rs.getString("acessorio"));          //seta no bean o que trouxer do banco 
            ace.setSerie(rs.getString("serieacessorio"));          //seta no bean o que trouxer do banco 
            ace.setQtd(rs.getInt("qtdacessorio"));          //seta no bean o que trouxer do banco 
            arm.setAcessorio(ace);                         //seta no bean o que trouxer do banco 

        }                                            //fecha condição        
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return arm;
    }

    // metodo pesquisarPorSerie é utilizado na tela altear para pesquisar o armamento
    public Equipamento pesqPorSerie(String entidade) throws Exception {
        Equipamento arm = null;                                   //Declarao classe cria um variavel e atribe o valor null;v
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select armamento.id as idarmamento, \n"
                + "       armamento.serie as seriearmamento,\n"
                + "       armamento.nome as nome,\n"
                + "       armamento.tipo as tipo,\n"
                + "       armamento.qtd as armqtd,\n"
                + "       armamento.statusEqp as 'status',\n"
                + "       armamento.obs as obs,\n"
                + "       e.serie as 'seriebaioneta',\n"
                + "       a.nome as arma,\n"
                + "       c.nome as calibre,\n"
                + "       f.nome as fabricante, \n"
                + "       ca.nome as categoria  \n"
                + "       from equipamento as armamento\n"
                + "       left join  equipamento e on e.id = armamento.idEquipamento\n"
                + "       left join arma a on a.id = armamento.idArma\n"
                + "       left join fabricante f on f.id = armamento.idFabricante\n"
                + "       left join calibre c on c.id = armamento.idCalibre \n"
                + "       left join categoria ca on ca.id = armamento.idCategoria  \n"
                + "       where armamento.serie = ? and armamento.nome <> ('BAIONETA');";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, entidade);                    //prepara os dados utilizando os parametros pegando da tela
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        if (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            arm = new Equipamento();                              //estância o objeto
            arm.setId(rs.getInt("idarmamento"));             //seta no bean o que trouxer do banco 
            arm.setSerie(rs.getString("seriearmamento"));             //seta no bean o que trouxer do banco 
            arm.setNome(rs.getString("nome"));             //seta no bean o que trouxer do banco 
            arm.setTipo(rs.getString("tipo"));
            arm.setQtd(rs.getInt("armqtd"));
            arm.setStatus(rs.getString("status"));
            arm.setObs(rs.getString("obs"));

            Categoria categoria = new Categoria();
            categoria.setCategoria(rs.getString("categoria"));
            arm.setCategoria(categoria);

            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            arm.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            arm.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            arm.setCalibre(cal);             //seta no bean o que trouxer do banco 

            Equipamento ace = new Equipamento();
            ace.setSerie(rs.getString("seriebaioneta"));
            arm.setAcessorio(ace);

        }                                            //fecha condição        
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return arm;
    }

    //metodo pesqAcessorioSerie e pesqAcessorioNome são utilizado na tela cautela para pesquisar 
    //o armamento na hora da cautela
    public Equipamento pesqAcessorioSerie(String entidade) throws Exception {
        Equipamento ace = null;                                   //Declarao classe cria um variavel e atribe o valor null;v
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select Acessorio.id, Acessorio.nome, Acessorio.serie, Acessorio.qtd from equipamento as Acessorio\n"
                + "left join categoria on categoria.id = Acessorio.idCategoria\n"
                + "where categoria.nome <> 'PARTICULAR' and Acessorio.serie = ? and Acessorio.statusEqp = 'DISPONIVEL';";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, entidade);                    //prepara os dados utilizando os parametros pegando da tela
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        if (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            ace = new Equipamento();
            ace.setId(rs.getInt("Acessorio.id"));             //seta no bean o que trouxer do banco 
            ace.setNome(rs.getString("Acessorio.nome"));          //seta no bean o que trouxer do banco 
            ace.setSerie(rs.getString("Acessorio.serie"));          //seta no bean o que trouxer do banco 
            ace.setQtd(rs.getInt("Acessorio.qtd"));          //seta no bean o que trouxer do banco 
            ace.setAcessorio(ace);                         //seta no bean o que trouxer do banco 
        }                                            //fecha condição        
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return ace;
    }

    public Equipamento pesqAcessorioNome(String entidade) throws Exception {
        Equipamento ace = null;                                   //Declarao classe cria um variavel e atribe o valor null;v
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select Acessorio.id, Acessorio.nome, Acessorio.serie, Acessorio.qtd from equipamento as Acessorio\n"
                + "left join categoria on categoria.id = Acessorio.idCategoria\n"
                + "where categoria.nome <> 'PARTICULAR' and Acessorio.nome = ? and Acessorio.qtd != 0 and Acessorio.statusEqp = 'DISPONIVEL';";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, entidade);                    //prepara os dados utilizando os parametros pegando da tela
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        if (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            ace = new Equipamento();
            ace.setId(rs.getInt("Acessorio.id"));             //seta no bean o que trouxer do banco 
            ace.setNome(rs.getString("Acessorio.nome"));          //seta no bean o que trouxer do banco 
            ace.setSerie(rs.getString("Acessorio.serie"));          //seta no bean o que trouxer do banco 
            ace.setQtd(rs.getInt("Acessorio.qtd"));          //seta no bean o que trouxer do banco 
            ace.setAcessorio(ace);                         //seta no bean o que trouxer do banco 
        }                                            //fecha condição        
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return ace;
    }

    // método pesquisarAcessorioPorSerie e pesquisarAcessorioPorNome são utilizado na tela 
    // alterar equipamento 
    public Equipamento pesquiarAcessorioPorSerie(String entidade) throws Exception {
        Equipamento ace = null;                                   //Declarao classe cria um variavel e atribe o valor null;v
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select Acessorio.id, Acessorio.nome, Acessorio.tipo, \n"
                + "Acessorio.serie, Acessorio.qtd, Acessorio.obs, Acessorio.statusEqp, categoria.nome as categoria from equipamento as Acessorio\n"
                + "left join categoria on categoria.id = Acessorio.idCategoria where Acessorio.serie = ?;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, entidade);                    //prepara os dados utilizando os parametros pegando da tela
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        if (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            ace = new Equipamento();
            Categoria categoria = new Categoria();
            categoria.setCategoria(rs.getString("categoria"));
            ace.setCategoria(categoria);
            ace.setId(rs.getInt("Acessorio.id"));             //seta no bean o que trouxer do banco 
            ace.setNome(rs.getString("Acessorio.nome"));          //seta no bean o que trouxer do banco 
            ace.setSerie(rs.getString("Acessorio.serie"));          //seta no bean o que trouxer do banco 
            ace.setQtd(rs.getInt("Acessorio.qtd"));          //seta no bean o que trouxer do banco 
            ace.setObs(rs.getString("Acessorio.obs"));          //seta no bean o que trouxer do banco 
            ace.setStatus(rs.getString("Acessorio.statusEqp"));
            ace.setTipo(rs.getString("Acessorio.tipo"));
            ace.setAcessorio(ace);                         //seta no bean o que trouxer do banco 
        }                                            //fecha condição        
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return ace;
    }

    public Equipamento pesquisarAcessorioPorNome(String entidade) throws Exception {
        Equipamento ace = null;                                   //Declarao classe cria um variavel e atribe o valor null;v
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select Acessorio.id, Acessorio.nome, Acessorio.tipo, \n"
                + "Acessorio.serie, Acessorio.qtd, Acessorio.obs, Acessorio.statusEqp, categoria.nome as categoria from equipamento as Acessorio\n"
                + "left join categoria on categoria.id = Acessorio.idCategoria where Acessorio.nome = ?;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, entidade);                    //prepara os dados utilizando os parametros pegando da tela
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        if (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            ace = new Equipamento();
            Categoria categoria = new Categoria();
            categoria.setCategoria(rs.getString("categoria"));
            ace.setCategoria(categoria);
            ace.setId(rs.getInt("Acessorio.id"));             //seta no bean o que trouxer do banco 
            ace.setNome(rs.getString("Acessorio.nome"));          //seta no bean o que trouxer do banco 
            ace.setSerie(rs.getString("Acessorio.serie"));          //seta no bean o que trouxer do banco 
            ace.setQtd(rs.getInt("Acessorio.qtd"));          //seta no bean o que trouxer do banco 
            ace.setObs(rs.getString("Acessorio.obs"));          //seta no bean o que trouxer do banco 
            ace.setStatus(rs.getString("Acessorio.statusEqp"));
            ace.setTipo(rs.getString("Acessorio.tipo"));
            ace.setAcessorio(ace);                         //seta no bean o que trouxer do banco 
        }                                            //fecha condição        
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return ace;
    }

    public int getIdEquipamento() {
        int id = 0;
        con = FabricaConexao.getconnection();
        sql = "select max(id) id from equipamento;";
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar id da cautela" + ex.getMessage());
        }
        return id;
    }

    public void inserirArmamentoParticular(Equipamento entidade) throws SQLException {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "insert into equipamento(nome,serie,qtd,obs,tipo,idArma,idFabricante,idCalibre,idCategoria,idArmeiro) values \n"
                + "(?,?,?,?,?,?,?,?,3,?);";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                          // prepara o instrução sql no banco
        pstm.setString(1, entidade.getNome());
        pstm.setString(2, entidade.getSerie());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(3, entidade.getQtd());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(4, entidade.getObs());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(5, entidade.getTipo());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(6, entidade.getArma().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(7, entidade.getFabricante().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setObject(8, entidade.getCalibre().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(9, entidade.getArmeiro().getId());          // prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                                      // executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();                   // fechar conexao com o banco

    }

}
