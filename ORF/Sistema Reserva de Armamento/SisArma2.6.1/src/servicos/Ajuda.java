/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Ajuda {
    
     public void abrirPDF(){
         java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
         try {
             String arquivo = System.getProperty("user.dir")+"manual.pdf";
             System.out.println(arquivo);
             desktop.getClass().getResource(arquivo);
             desktop.open(new File("manual.pdf"));
         } catch (IOException ex) {
             Logger.getLogger(Ajuda.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Erro pdf" +ex.getMessage());
         }
     }
}
