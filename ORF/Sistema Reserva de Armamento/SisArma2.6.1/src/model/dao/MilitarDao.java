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
import model.bean.FuncaoMilitar;
import model.bean.Graduacao;
import model.bean.Militar;
import model.bean.OM;
import model.connection.FabricaConexao;

/**
 *
 * @author ASUS
 */
public class MilitarDao {

    byte[] digital;
    private PreparedStatement pstm; // Prepara a inserção no banco mais segura que Statement, utilizando parametros e evita ataque de sql injection 
    private Connection con;         // executa a conexão com o banco
    private String sql;             // recebe a instrução que será enviada para o banco 
    private ResultSet rs;           // retorna a consulta no banco de dados

    public void Cadastrar(Militar entidade) throws Exception {
        con = FabricaConexao.getconnection();       // abre a conexao no banco
        sql = "insert into militar (idmilitar,nome,guerra,login,senha,sexo,statusMil,idGraduacao,idOm,idArmeiro,digital)"
                + " values (?,?,?,?,md5(?),?,?,?,?,?,?); ";     // armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);                                   // prepara o instrução sql no banco
        pstm.setString(1, entidade.getIdmilitar());
        pstm.setString(2, entidade.getNome());                              // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(3, entidade.getGuerra());                            // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(4, entidade.getLogin());                             // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(5, entidade.getSenha());                             // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(6, entidade.getSexo());                              // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(7, entidade.getStatus());                         // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(8, entidade.getGraduacao().getId());                    // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(9, entidade.getOm().getId());                           // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(10, entidade.getIdarmeiro().getId());                           // prepara os dados utilizando os parametros pegando do bean
        pstm.setBytes(11, entidade.getDigital());                           // prepara os dados utilizando os parametros pegando do bean
        pstm.execute();
        pstm.close();// executa a instrução sql
        FabricaConexao.closeconnection();                                   // fechar conexao com o banco
    }

    public void alterar(Militar entidade) throws Exception {

        con = FabricaConexao.getconnection();          //abre a conexao no banco
        sql = "update militar set nome=?,guerra=?,login=?,sexo=?,statusmil=?,idGraduacao=?,idOm=?, digital= ?, idArmeiro = ?, idOficialDia = ? where id=?;";  //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);              //prepara o instrução sql no bancopstm.setString(1, entidade.getNome());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(1, entidade.getNome());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(2, entidade.getGuerra());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(3, entidade.getLogin());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(4, entidade.getSexo());              // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(5, entidade.getStatus());        // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(6, entidade.getGraduacao().getId());     // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(7, entidade.getOm().getId());            // prepara os dados utilizando os parametros pegando do bean
        pstm.setBytes(8, entidade.getDigital());
        pstm.setInt(9, entidade.getIdarmeiro().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(10, entidade.getIdoficialDia().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(11, entidade.getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                                //executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();              // fecha conexao com o banco
    }

     public void alterarSenha(Militar entidade) throws Exception {

        con = FabricaConexao.getconnection();          //abre a conexao no banco
        sql = "update militar set senha=md5(?),idArmeiro = ?, idOficialDia = ? where id=?;";  //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);              //prepara o instrução sql no bancopstm.setString(1, entidade.getNome());                     // prepara os dados utilizando os parametros pegando do bean
        pstm.setString(1, entidade.getSenha());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(2, entidade.getIdarmeiro().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(3, entidade.getIdoficialDia().getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.setInt(4, entidade.getId());                // prepara os dados utilizando os parametros pegando do bean
        pstm.execute();                                //executa a instrução sql
        pstm.close();
        FabricaConexao.closeconnection();              // fecha conexao com o banco
    }
    
    public List<Militar> listEntidade() throws Exception {
        Militar mil = null;                                   //Declarao classe cria um variavel e atribe o valor null;
        List<Militar> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select m.id id, m.nome nome, m.guerra guerra, m.sexo sexo, m.login login,  m.senha senha, m.statusmil 'status',\n"
                + "g.nome graduacao, o.nome om from militar m\n"
                + "inner join graduacao g on g.id = m.idgraduacao \n"
                + "inner join om o on o.id = m.idom\n"
                + "order by g.id\n"
                + ";";  //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            mil = new Militar();                              //estância o objeto
            mil.setId(rs.getInt("id"));                  //seta no bean o que trouxer do banco 
            mil.setNome(rs.getString("nome"));             //seta no bean o que trouxer do banco 
            mil.setGuerra(rs.getString("guerra"));             //seta no bean o que trouxer do banco 
            mil.setLogin(rs.getString("login"));             //seta no bean o que trouxer do banco 
            mil.setSenha(rs.getString("senha"));             //seta no bean o que trouxer do banco 
            mil.setSexo(rs.getString("sexo"));             //seta no bean o que trouxer do banco 
            mil.setStatus(rs.getString("status"));             //seta no bean o que trouxer do banco 

            Graduacao gra = new Graduacao();                              //estância o objeto
            gra.setGraduacao(rs.getString("graduacao"));             //seta no bean o que trouxer do banco 
            mil.setGraduacao(gra);                         //seta no bean o que trouxer do banco 

            OM o = new OM();                              //estância o objeto
            o.setOm(rs.getString("om"));          //seta no bean o que trouxer do banco 
            mil.setOm(o);                         //seta no bean o que trouxer do banco 

            lista.add(mil);                         //adiciona tudo na lista 
        }                                               //fecha condição
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return lista;                                         //retorna lista
    }

    // Metodo para pesquisar militar pelo nome de GUERRA = atributo guerra
    public Militar pesq(String entidade) throws Exception {
        Militar mil = null;                                   //Declarao classe cria um variavel e atribe o valor null;
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select mil.id 'milid', mil.idmilitar as identidade, mil.nome 'nome', mil.guerra 'guerra', mil.login 'login', mil.senha 'senha', mil.sexo 'sexo', mil.statusmil 'status',\n"
                + "                gra.id 'graid', gra.nome 'graduacao', o.id 'omid', o.nome 'om', digital\n"
                + "                from militar mil inner join graduacao gra on gra.id = idgraduacao \n"
                + "                inner join om o on o.id = idom where mil.idmilitar = ?";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, entidade);                    //prepara os dados utilizando os parametros pegando da tela
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        if (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            mil = new Militar();                              //estância o objeto
            mil.setId(rs.getInt("milid"));                  //seta no bean o que trouxer do banco 
            mil.setIdmilitar(rs.getString("identidade"));                  //seta no bean o que trouxer do banco 
            mil.setNome(rs.getString("nome"));             //seta no bean o que trouxer do banco 
            mil.setGuerra(rs.getString("guerra"));             //seta no bean o que trouxer do banco 
            mil.setLogin(rs.getString("login"));             //seta no bean o que trouxer do banco 
            mil.setSenha(rs.getString("senha"));             //seta no bean o que trouxer do banco 
            mil.setSexo(rs.getString("sexo"));             //seta no bean o que trouxer do banco 
            mil.setStatus(rs.getString("status"));             //seta no bean o que trouxer do banco 
            Graduacao gra = new Graduacao();                              //estância o objeto
            gra.setGraduacao(rs.getString("graduacao"));             //seta no bean o que trouxer do banco 
            mil.setGraduacao(gra);                         //seta no bean o que trouxer do banco 
            OM o = new OM();                              //instância o objeto
            o.setOm(rs.getString("om"));          //seta no bean o que trouxer do banco 
            mil.setOm(o);                         //seta no bean o que trouxer do banco 
            mil.setDigital(rs.getBytes("digital"));
        }                                               //fecha condição
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return mil;                                         //retorna objeto
    }

    public List<Militar> digitalCautela() throws Exception {
        List<Militar> lista = new ArrayList<>();
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select mil.id 'milid', mil.idmilitar as identidade, mil.nome 'nome', mil.guerra 'guerra', mil.login 'login', mil.senha 'senha', mil.sexo 'sexo', mil.statusmil 'status',\n"
                + "							gra.id 'graid', gra.nome 'graduacao', o.id 'omid', o.nome 'om', mil.digital 'digital'\n"
                + "                               from militar mil inner join graduacao gra on gra.id = idgraduacao \n"
                + "                                inner join om o on o.id = idom where mil.statusMil = 'ATIVO';";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            Militar mil = new Militar();                              //estância o objeto
            mil.setId(rs.getInt("milid"));                  //seta no bean o que trouxer do banco 
            mil.setIdmilitar(rs.getString("identidade"));                  //seta no bean o que trouxer do banco 
            mil.setNome(rs.getString("nome"));             //seta no bean o que trouxer do banco 
            mil.setGuerra(rs.getString("guerra"));             //seta no bean o que trouxer do banco 
            mil.setLogin(rs.getString("login"));             //seta no bean o que trouxer do banco 
            mil.setSenha(rs.getString("senha"));             //seta no bean o que trouxer do banco 
            mil.setSexo(rs.getString("sexo"));             //seta no bean o que trouxer do banco 
            mil.setStatus(rs.getString("status"));             //seta no bean o que trouxer do banco 
            Graduacao gra = new Graduacao();                              //estância o objeto
            gra.setGraduacao(rs.getString("graduacao"));             //seta no bean o que trouxer do banco 
            mil.setGraduacao(gra);                         //seta no bean o que trouxer do banco 
            OM o = new OM();                              //instância o objeto
            o.setOm(rs.getString("om"));          //seta no bean o que trouxer do banco 
            mil.setOm(o);                         //seta no bean o que trouxer do banco 
            mil.setDigital(rs.getBytes("digital"));

            lista.add(mil);
        }                                               //fecha condição
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return lista;                                         //retorna objeto
    }

    // Pego a Digital do Armeiro para qualquer situação Principalmente para Login no Sistema;
    public List<Militar> digitalArmeiro() throws Exception {
        List<Militar> lista = new ArrayList<>();
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select militar.login 'login', militar.digital 'digital', funcaomilitar.id as idarmeiro from militar\n"
                + "inner join funcaomilitar  on militar.id = funcaomilitar.idMilitar \n"
                + "inner join funcao on funcao.id = funcaomilitar.idfuncao\n"
                + "where militar.statusMil = 'ATIVO' and funcaomilitar.statusFM = 'ATIVO' and funcao.nome = 'ARMEIRO';";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            Militar mil = new Militar();                              //estância o objeto
            mil.setLogin(rs.getString("login"));             //seta no bean o que trouxer do banco 
            mil.setDigital(rs.getBytes("digital"));
            FuncaoMilitar armeiro = new FuncaoMilitar();
            armeiro.setId(rs.getInt("idarmeiro"));
            mil.setIdarmeiro(armeiro);
            lista.add(mil);
        }                                               //fecha condição
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return lista;                                         //retorna objeto
    }

    public List<Militar> digitalOficialDia() throws Exception {
        List<Militar> lista = new ArrayList<>();
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select funcaomilitar.id idOficialDia, militar.digital as digital from funcaomilitar\n"
                + "inner join militar on funcaomilitar.idMilitar = militar.id\n"
                + "inner join funcao on funcaomilitar.idFuncao = funcao.id\n"
                + "where funcao.nome = 'Oficial Dia' and funcaomilitar.statusFM = 'Ativo'and militar.statusmil = 'Ativo';";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            Militar mil = new Militar();                              //estância o objeto
            FuncaoMilitar idOficialDia = new FuncaoMilitar();
            idOficialDia.setId(rs.getInt("idOficialDia"));
            mil.setIdoficialDia(idOficialDia);
            mil.setDigital(rs.getBytes("digital"));
            lista.add(mil);
        }                                               //fecha condição
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return lista;                                         //retorna objeto
    }

    public List<Militar> digitalItemCautela() throws SQLException {
        List<Militar> lista = new ArrayList<>();
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select militar.id as id,\n"
                + "   militar.idmilitar as nome,\n"
                + "   militar.digital\n"
                + "   from item\n"
                + "   inner join cautela on cautela.id = item.idCautela\n"
                + "   inner join destino on destino.id = cautela.idDestino\n"
                + "   inner join militar on militar.id = cautela.idMilitar \n"
                + "   where item.idArmeiro is null;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            Militar mil = new Militar();                              //estância o objeto
            mil.setId(rs.getInt("id"));
            mil.setLogin(rs.getString("nome"));
            mil.setDigital(rs.getBytes("digital"));
            lista.add(mil);
        }                                               //fecha condição
        FabricaConexao.closeconnection();                  //fecha conexao com o banco
        return lista;                                         //retorna objetoFF   
    }

    public boolean autenticacao(String login, String senha) throws SQLException {
        boolean existe = false;
        con = FabricaConexao.getconnection();
        sql = "select mil.login 'login', mil.senha 'senha' from militar mil \n"
                + "where mil.idmilitar = ? and mil.senha = md5(?) and statusMil = 'ATIVO';";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, login);
        pstm.setString(2, senha);
        rs = pstm.executeQuery();
        if (rs.next()) {
            existe = true;
        }
        FabricaConexao.closeconnection();

        return existe;
    }

    public Integer autenticacaoOficialDia(String login, String senha) throws SQLException {
        Integer id = null;
        con = FabricaConexao.getconnection();
        sql = "select fmil.id as id, mil.nome as nome \n"
                + "from funcaomilitar fmil\n"
                + "inner join militar mil on mil.id = fmil.idmilitar\n"
                + "inner join funcao fun on fun.id = fmil.idfuncao \n"
                + "where mil.idmilitar = ? and mil.senha = md5(?) \n"
                + "and fun.id in(3) and fmil.statusFM = 'ATIVO' and mil.statusMil = 'ATIVO';";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, login);
        pstm.setString(2, senha);
        rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id");
        }
        FabricaConexao.closeconnection();

        return id;
    }

    public boolean autenticacaoInspecionador(String login, String senha) throws SQLException {
        boolean existe = false;
        con = FabricaConexao.getconnection();
        sql = "select "
                + "mil.id as id,  fun.nome as funcao, mil.login from funcaomilitar fmil\n"
                + "                inner join militar mil on mil.id = fmil.idmilitar\n"
                + "                inner join funcao fun on fun.id = fmil.idfuncao \n"
                + "                where mil.idmilitar = ? and mil.senha = md5(?) and fun.id in(2) and mil.statusmil = 'Ativo';";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, login);
        pstm.setString(2, senha);
        rs = pstm.executeQuery();
        if (rs.next()) {
            existe = true;
        }
        FabricaConexao.closeconnection();

        return existe;
    }

    public Militar validarUsuario(String login, String senha) throws SQLException {
        Militar mil = null;
        con = FabricaConexao.getconnection();
        sql = "select militar.login, funcaomilitar.id as idarmeiro from funcaomilitar\n"
                + "       inner join militar on militar.id = funcaomilitar.idmilitar\n"
                + "       inner join funcao on funcao.id = funcaomilitar.idfuncao \n"
                + "       where militar.idmilitar = ? and militar.senha = md5(?)\n"
                + "       and militar.statusmil = 'ativo' and funcaomilitar.statusFM = 'ativo' and funcao.nome = 'armeiro';";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, login);
        pstm.setString(2, senha);
        rs = pstm.executeQuery();
        if (rs.next()) {
            mil = new Militar();
            mil.setLogin(rs.getString("login"));
            FuncaoMilitar armeiro = new FuncaoMilitar();
            armeiro.setId(rs.getInt("idarmeiro"));
            mil.setIdarmeiro(armeiro);
        }
        FabricaConexao.closeconnection();
        return mil;
    }

    public int getIdMilitar() {
        int id = 0;
        con = FabricaConexao.getconnection();
        sql = "select max(id) id from militar;";
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

    public int pesqIdentidade(String entidade) throws Exception {
        int valida = 1;
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select id from militar where idmilitar = ?;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, entidade);                    //prepara os dados utilizando os parametros pegando da tela
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        if (rs.next()) {
            valida = 2;
        }                                               //fecha condição
        FabricaConexao.closeconnection();                  //fecha conexao com o banco

        return valida;                                         //retorna objeto

    }

    public List<Militar> pesqMilitarStatus(String status) throws SQLException {
        List<Militar> lista = new ArrayList<>();
        con = FabricaConexao.getconnection();
        sql = "select idmilitar,nome, login from militar where statusMil = ? order by nome asc;";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, status);
        rs = pstm.executeQuery();
        while (rs.next()) {
            Militar mil = new Militar();
            mil.setIdmilitar(rs.getString("idmilitar"));
            mil.setNome(rs.getString("nome"));
            mil.setLogin(rs.getString("login"));
            lista.add(mil);
        }
        return lista;
    }

    public Integer verificarIdentidade(String entidade) throws Exception {
        Integer identidade = null;
        con = FabricaConexao.getconnection();           //abre a conexao no banco 
        sql = "select id from militar where idmilitar = ?;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        pstm.setString(1, entidade);                    //prepara os dados utilizando os parametros pegando da tela
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        if (rs.next()) {
            identidade = rs.getInt("id");
        }                                               //fecha condição
        FabricaConexao.closeconnection();                  //fecha conexao com o banco

        return identidade;                                         //retorna objeto

    }

    public List<Militar> listaMilitarPorNome(String busca, String status) throws Exception {

        List<Militar> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.getconnection();       //abre conexao    
        sql = "select idmilitar, nome, login from militar where statusMil = ? and nome like ?;";                   //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);           //prepara o instrução sql no banco
        pstm.setString(1, status);           //prepara o instrução sql no banco
        pstm.setString(2, "%" + busca + "%");           //prepara o instrução sql no banco
        rs = pstm.executeQuery();                   //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                           //cria condição enquanto resultado existe executa proximo passo 
            Militar mil = new Militar();
            mil.setIdmilitar(rs.getString("idmilitar"));
            mil.setNome(rs.getString("nome"));
            mil.setLogin(rs.getString("login"));
            lista.add(mil);
        }                                           //fecha condição
        FabricaConexao.closeconnection();           //fecha conexao com o banco
        return lista;                                //retorna lista

    }
}
