/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.SQLException;
import java.util.List;
import model.bean.Item;
import model.dao.ItemDao;

/**
 *
 * @author ASUS
 */
public class ControllerItem {

    ItemDao iteDao = new ItemDao();

    public List<Item> listarCautelaPorMilitar(String militar) throws Exception {
        List<Item> lista = iteDao.listaDescautela(militar);
        return lista;
    }
    
    public void descautelarItem(Item ite) throws SQLException{
        iteDao.descautelarItem(ite);
    }
    
    public List<Item> listarItemPorStatus(String status) throws Exception{
        List<Item> lista = iteDao.listItemStatus(status);
        return lista;
        
    }
}
