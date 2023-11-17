/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.bean.OM;
import model.dao.OMDao;

/**
 *
 * @author ASUS
 */
public class ControllerOM {
    
    OMDao omDao = new OMDao();
    
    public void cadastrar(OM om) throws Exception {
        
        omDao.Cadastrar(om);
    }
    
    public void altetar(OM om) throws Exception{
        omDao.alterar(om);
    }
}
