/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.bean.FuncaoMilitar;
import model.dao.FuncaoMilitarDao;

/**
 *
 * @author ASUS
 */
public class ControllerFuncaoMilitar {

    FuncaoMilitarDao fmDao = new FuncaoMilitarDao();

    public void cadastrar(FuncaoMilitar fm) throws Exception {

        fmDao.Cadastrar(fm);
    }


}
