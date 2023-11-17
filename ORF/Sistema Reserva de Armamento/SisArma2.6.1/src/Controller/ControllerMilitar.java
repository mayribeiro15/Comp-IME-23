/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.SQLException;
import model.bean.Militar;
import model.dao.MilitarDao;

/**
 *
 * @author ASUS
 */
public class ControllerMilitar {

    MilitarDao mdao = new MilitarDao();

    public void cadastrar(Militar mil) throws Exception {
        mdao.Cadastrar(mil);

    }

    public void alterar(Militar mil) throws Exception {
        mdao.alterar(mil);

    }

    public Militar pesquisar(String login) throws Exception{
        Militar mil = mdao.pesq(login);
        return mil;
    }
            
            
    public boolean autenticarMilitar(String login, String senha) throws SQLException {
        boolean existe = mdao.autenticacao(login, senha);
        return existe;
    }
    
     public boolean autenticarMilitarInspecionador(String login, String senha) throws SQLException {
        boolean existe = mdao.autenticacaoInspecionador(login, senha);
        return existe;
    }
    
}
