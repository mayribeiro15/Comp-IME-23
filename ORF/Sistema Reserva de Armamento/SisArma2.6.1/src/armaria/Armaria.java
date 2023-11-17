/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaria;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.MilitarDao;

/**
 *
 *
 * @author
 */
public class Armaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        try {
            int id = new MilitarDao().verificarIdentidade("1200242376");
            System.out.println("Id " + id);
        } catch (Exception ex) {
            Logger.getLogger(Armaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    

    }
    /*  
            ItemParticular item = new ItemParticular();
        
        Equipamento eqp = new Equipamento();
        Arma arma = new Arma();
        arma.setId(1);

        Categoria categoria = new Categoria();
        categoria.setId(2);

        Fabricante fabricante = new Fabricante();
        fabricante.setId(1);

        Calibre calibre = new Calibre();
        calibre.setId(1);

        Militar militar = new Militar();
        militar.setId(1);

        FuncaoMilitar funcao = new FuncaoMilitar();
        funcao.setId(1);
        
        eqp.setArmeiro(funcao);
        eqp.setArma(arma);
        eqp.setFabricante(fabricante);
        eqp.setCalibre(calibre);
        eqp.setCategoria(categoria);
        eqp.setNome("aaa");
        eqp.setQtd(1);
        eqp.setObs(null);
        eqp.setSerie("00");
        eqp.setTipo("AR");
        try {
            new EquipamentoDao().inserirArmamentoParticular(eqp);
            
            int id = new EquipamentoDao().getIdEquipamento();
            Equipamento particular = new Equipamento();
            particular.setId(id);
            item.setEquipamento(particular);
            item.setMilitar(militar);
            item.setArmeiro(funcao);
            new ItemParticularDao().Cadastrar(item);
            System.out.println("Funfou");
         } catch (SQLException ex) {
            
            Logger.getLogger(Armaria.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro " +ex.getMessage());
        }
    
    Equipamento eqp = new Equipamento();
        eqp.setId(9);
        eqp.setQtd(10);
        EquipamentoDao eqdao = new EquipamentoDao();
        try {
        eqdao.descautelar(eqp);
        JOptionPane.showMessageDialog(null,"VAI VEADO");
        } catch (SQLException ex) {
        Logger.getLogger(Armaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    
 /*
        try {
        List<Equipamento> lista = new EquipamentoDao().listEntidade();
        for( Equipamento eqp : lista){
        System.out.println("Armamento id :" +eqp.getId());
        System.out.println("Serie : " +eqp.getSerie());
        System.out.println("Status : " +eqp.getStatus());
        System.out.println("Quantidade : " +eqp.getQtd());
        System.out.println("Tipo Armamento: " +eqp.getTipo());
        System.out.println("Arma : " +eqp.getArma().getArma());
        System.out.println("Fabricante : " +eqp.getFabricante().getFabricante());
        System.out.println("Calibre : " +eqp.getCalibre().getCalibre());
        System.out.println("Acessorio id: " +eqp.getEquipamento().getId());
        System.out.println("Acessorio : " +eqp.getEquipamento().getNome());
        System.out.println("Status :"+eqp.getEquipamento().getStatus());
        System.out.println("Serie : " +eqp.getEquipamento().getSerie());
        System.out.println("Tipo Armamento :" +eqp.getEquipamento().getTipo());
        System.out.println("Quantidade :" +eqp.getEquipamento().getQtd());
        System.out.println("################################");
        }
        } catch (Exception ex) {
        System.out.println("Erro "+ex.getMessage());
        }
     */
 /*Cautela cau = new Cautela();
            
            Militar mil = new Militar();
            mil.setId(1);
            cau.setMilitar(mil);
            
            FuncaoMilitar milfun = new FuncaoMilitar();
            milfun.setId(1);
            cau.setMilitarfuncao(milfun);
            
            Destino des = new Destino();
            des.setId(1);
            cau.setDestino(des);
            
            CautelaDao caudao = new CautelaDao();
            try {
            caudao.Cadastrar(cau);
            System.out.println("Funcionou");
            } catch (Exception ex) {
            Logger.getLogger(Armaria.class.getName()).log(Level.SEVERE, null, ex);
            }*/
 /*    String pesq = "123131";
            
            
            try {
            Equipamento arm = new EquipamentoDao().pesq(pesq);
            if(arm == null){
            System.out.println("Vazio ");
            }else{
            System.out.println("Equipamento:" +arm.getArma().getArma());
            System.out.println("Calibre: " +arm.getCalibre().getCalibre());
            System.out.println("Numero: "+arm.getSerie());
            System.out.println("Fabricante: "+arm.getFabricante().getFabricante());
            System.out.println("Acessorio :" +arm.getAcessorio().getNome());
            System.out.println("Acessrio Numero: "+arm.getAcessorio().getSerie());
            }
            } catch (Exception ex) {
            System.out.println("Erro na pesquisa" +ex.getMessage());
            }
     */ /*try {
            List<Militar> lista = new MilitarDao().listEntidade();
            for(Militar mil : lista){
            System.out.println("nome: " +mil.getNome());
            System.out.println("guerra: " +mil.getGuerra());
            System.out.println("sexo: "  +mil.getSexo());
            System.out.println("login: " +mil.getLogin());
            System.out.println("senha: " +mil.getSenha());
            System.out.println("status:" +mil.getMilstatus());
            System.out.println("graduacao: " +mil.getGraduacao().getGraduacao());
            System.out.println("om: "+mil.getOm().getOm());
            }
            } catch (Exception ex) {
            Logger.getLogger(Armaria.class.getName()).log(Level.SEVERE, null, ex);
            }*/

}
