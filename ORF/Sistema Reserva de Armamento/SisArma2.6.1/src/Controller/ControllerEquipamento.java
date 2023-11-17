/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.SQLException;
import java.util.List;
import model.bean.Equipamento;
import model.dao.EquipamentoDao;

/**
 *
 * @author ASUS
 */
public class ControllerEquipamento {

    EquipamentoDao equiDao = new EquipamentoDao();


    public void descautelar(Equipamento eqp) throws SQLException {
        equiDao.descautelar(eqp);
    }

    public List<Equipamento> listarEquipamentoPorFiltro(String nome, String serie, String arma, String fabricante, String calibre) throws Exception {
        List<Equipamento> lista = equiDao.listFiltro(nome, serie, arma, fabricante, calibre);
        return lista;
    }

    public Equipamento buscarArmamentoPorSerie(String serie) throws Exception {
        Equipamento eqp = equiDao.pesqPorSerie(serie);
        return eqp;
    }

    public Equipamento buscaAcessorioPorNome(String nome) throws Exception {
        Equipamento eqp = equiDao.pesquisarAcessorioPorNome(nome);
        return eqp;
    }

    public Equipamento buscaAcessorioPorSerie(String serie) throws Exception {
        Equipamento eqp = equiDao.pesquiarAcessorioPorSerie(serie);
        return eqp;
    }

    public void alterarEquipamento(Equipamento eqp) throws Exception {
        equiDao.alterar(eqp);
    }
}
