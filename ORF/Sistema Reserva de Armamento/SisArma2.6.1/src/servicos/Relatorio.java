/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.awt.Frame;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import model.connection.FabricaConexao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class Relatorio {

    public void relatorioAlteracaoUsuario() throws JRException {

        Connection con = FabricaConexao.getconnection();
        // pega o caminho físico até o arquivo .jasper 
        String arquivo = System.getProperty("user.dir") + "/relatorio/relatorioAltUsuario.jrxml";
        JasperDesign design = JRXmlLoader.load(arquivo);
        //Representa o JasperDesign compilado. O processo de compilacao verifica
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, null, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void relatorioAlteracaoEquipamento() throws JRException {
        Connection con = FabricaConexao.getconnection();
        // pega o caminho físico até o arquivo .jasper 
        String arquivo = System.getProperty("user.dir") + "/relatorio/relatorioAltEquipamento.jrxml";
        JasperDesign design = JRXmlLoader.load(arquivo);
        //Representa o JasperDesign compilado. O processo de compilacao verifica
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, null, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Relatório Militares Ativos");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();
    }

    public void militarInativo() throws JRException {

        Connection con = FabricaConexao.getconnection();
        String arquivo = System.getProperty("user.dir") + "/relatorio/militarInativo.jrxml";
        System.out.println(arquivo);
        JasperDesign design = JRXmlLoader.load(arquivo);
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, null, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void militarAtivo() throws JRException {

        Connection con = FabricaConexao.getconnection();
        String arquivo = System.getProperty("user.dir") + "/relatorio/militarAtivo.jrxml";
        System.out.println(arquivo);
        JasperDesign design = JRXmlLoader.load(arquivo);
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, null, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void invetario(String armeiro, String inspecionador) throws JRException {

        Connection con = FabricaConexao.getconnection();
        // pega o caminho físico até o arquivo .jasper 
        String arquivo = System.getProperty("user.dir") + "/relatorio/relatorioEquipamentoTotal.jrxml";
        HashMap filtro = new HashMap();
        filtro.put("armeiro", armeiro);
        filtro.put("inspecionador", inspecionador);
        JasperDesign design = JRXmlLoader.load(arquivo);
        //Representa o JasperDesign compilado. O processo de compilacao verifica
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, filtro, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Inventário");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void prontoDestino(String armeiro, String inspecionador) throws JRException {

        Connection con = FabricaConexao.getconnection();
        String arquivo = System.getProperty("user.dir") + "/relatorio/relatorioProntoReservaDetalhado.jrxml";
        String subarquivo = System.getProperty("user.dir") + "/relatorio/subRelatorioProntoReservaDetalhado.jasper";
        HashMap filtro = new HashMap();
        filtro.put("armeiro", armeiro);
        filtro.put("inspecionador", inspecionador);
        filtro.put("$P{REPORT_CONNECTION}", subarquivo);
        JasperDesign design = JRXmlLoader.load(arquivo);
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, filtro, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Pronto Destino");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void historicoEquipamentoNome(String nome) throws JRException {
        Connection con = FabricaConexao.getconnection();
        String arquivo = System.getProperty("user.dir") + "/relatorio/historicoEquipamentoNome.jrxml";
        HashMap filtro = new HashMap();
        filtro.put("nome", nome);
        JasperDesign design = JRXmlLoader.load(arquivo);
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, filtro, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Relatório Histórico Equipamento Por Nome");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void historicoEquipamentoSerie(String nome) throws JRException {
        Connection con = FabricaConexao.getconnection();
        String arquivo = System.getProperty("user.dir") + "/relatorio/historicoEquipamentoSerie.jrxml";
        HashMap filtro = new HashMap();
        filtro.put("nome", nome);
        JasperDesign design = JRXmlLoader.load(arquivo);
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, filtro, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Relatório Histórico Equipamento Por Série");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void historicoMilitar(String identidade) throws JRException {
        Connection con = FabricaConexao.getconnection();
        String arquivo = System.getProperty("user.dir") + "/relatorio/historicoMilitar.jrxml";
        HashMap filtro = new HashMap();
        filtro.put("Identidade", identidade);
        JasperDesign design = JRXmlLoader.load(arquivo);
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, filtro, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Relatório Histórico Militar");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void relatorioProntoReserva(String armeiro, String inspecionador) throws JRException {

        Connection con = FabricaConexao.getconnection();
        // pega o caminho físico até o arquivo .jasper 
        String arquivo = System.getProperty("user.dir") + "/relatorio/relatorioProntoReserva.jrxml";
        String prontoDetalhado = System.getProperty("user.dir") + "/relatorio/relatorioProntoReservaDetalhado.jasper";
        String prontoIndisponivel = System.getProperty("user.dir") + "/relatorio/relatorioProntoIndisponivel.jasper";
        String prontoRecolhido = System.getProperty("user.dir") + "/relatorio/relatorioProntoRecolhido.jasper";
        String prontoRelacionado = System.getProperty("user.dir") + "/relatorio/relatorioProntoRelacionado.jasper";
        String prontoParticular = System.getProperty("user.dir") + "/relatorio/relatorioProntoParticular.jasper";
        
        HashMap filtro = new HashMap();
        filtro.put("armeiro", armeiro);
        filtro.put("inspecionador", inspecionador);
        filtro.put("$P{REPORT_CONNECTION}", prontoDetalhado);
        filtro.put("$P{REPORT_CONNECTION}", prontoIndisponivel);
        filtro.put("$P{REPORT_CONNECTION}", prontoRecolhido);
        filtro.put("$P{REPORT_CONNECTION}", prontoRelacionado);
        filtro.put("$P{REPORT_CONNECTION}", prontoParticular);
        
        JasperDesign design = JRXmlLoader.load(arquivo);
        //Representa o JasperDesign compilado. O processo de compilacao verifica
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, filtro, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Relatório Pronto Reserva");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void relatorioProntoParticular(String armeiro, String inspecionador) throws JRException {

        Connection con = FabricaConexao.getconnection();
        // pega o caminho físico até o arquivo .jasper 
        String arquivo = System.getProperty("user.dir") + "/relatorio/relatorioProntoParticular.jrxml";
        HashMap filtro = new HashMap();
        filtro.put("armeiro", armeiro);
        filtro.put("inspecionador", inspecionador);
        JasperDesign design = JRXmlLoader.load(arquivo);
        //Representa o JasperDesign compilado. O processo de compilacao verifica
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, filtro, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Relatório Pronto Reserva");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void relatorioPorData(Date datainicial, Date datafinal) throws JRException {
        Connection con = FabricaConexao.getconnection();
        String arquivo = System.getProperty("user.dir") + "/relatorio/equipamentoPorData.jrxml";
        HashMap filtro = new HashMap();
        filtro.put("datainicial", datainicial);
        filtro.put("datafinal", datafinal);
        JasperDesign design = JRXmlLoader.load(arquivo);
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, filtro, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Relatório Detalhado Equipamento Por Data");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();
    }

    public void relatorioEquipamentoCautelado() throws JRException {

        Connection con = FabricaConexao.getconnection();
        // pega o caminho físico até o arquivo .jasper 
        String arquivo = System.getProperty("user.dir") + "/relatorio/relatorioEquipamentoCautelado.jrxml";
        // Representa o design do meu relatorio o modelo do meu latorio a partir do template XML é criado
        JasperDesign design = JRXmlLoader.load(arquivo);
        //Representa o JasperDesign compilado. O processo de compilacao verifica
        JasperReport jr = JasperCompileManager.compileReport(design);
        //HasMao de parametros utilizados no relatorio. Sempre instanciados
        //HashedMap valores = new HashedMap(); so uso quando passo parametro
        JasperPrint impressao = JasperFillManager.fillReport(jr, null, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Relatório Detalhado Equipamento Cautelado");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();
    }

    public void relatorioEquipamentoDescautelados() throws JRException {

        Connection con = FabricaConexao.getconnection();
        // pega o caminho físico até o arquivo .jasper 
        String arquivo = System.getProperty("user.dir") + "/relatorio/relatorioEquipamentoDescautelado.jrxml";
        // Representa o design do meu relatorio o modelo do meu latorio a partir do template XML é criado
        JasperDesign design = JRXmlLoader.load(arquivo);
        //Representa o JasperDesign compilado. O processo de compilacao verifica
        JasperReport jr = JasperCompileManager.compileReport(design);
        //HasMao de parametros utilizados no relatorio. Sempre instanciados
        //HashedMap valores = new HashedMap(); so uso quando passo parametro
        JasperPrint impressao = JasperFillManager.fillReport(jr, null, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Relatório Detalhado Equipamento Descautelado");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();

    }

    public void relatorioCautelaMilitar(String identidade) throws JRException {
        Connection con = FabricaConexao.getconnection();
        // pega o caminho físico até o arquivo .jasper 
        String arquivo = System.getProperty("user.dir") + "/relatorio/relatorioCautelaMilitar.jrxml";
        HashMap parametro = new HashMap();
        parametro.put("identidade", identidade);
        JasperDesign design = JRXmlLoader.load(arquivo);
        //Representa o JasperDesign compilado. O processo de compilacao verifica
        JasperReport jr = JasperCompileManager.compileReport(design);
        JasperPrint impressao = JasperFillManager.fillReport(jr, parametro, con);
        JasperViewer jrviewer = new JasperViewer(impressao, false);
        jrviewer.setTitle("Relatório Cautelas Militar");
        jrviewer.setExtendedState(Frame.MAXIMIZED_BOTH);
        jrviewer.setVisible(true);
        jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        FabricaConexao.closeconnection();
    }

    /*public void relatorioEquipamentoDescautelados(String armeiro, String inspecionador) throws JRException {
     
     Connection con = FabricaConexao.getconnection();
     // pega o caminho físico até o arquivo .jasper
     String arquivo = System.getProperty("user.dir") + "/src/relatorio/relatorioEquipamentoDescautelado.jasper";
     HashMap filtro = new HashMap();
     filtro.put("armeiro", armeiro);
     filtro.put("inspecionador", inspecionador);
     // Representa o design do meu relatorio o modelo do meu latorio a partir do template XML é criado
     //JasperDesign design = JRXmlLoader.load(arquivo);
     //Representa o JasperDesign compilado. O processo de compilacao verifica
     //JasperReport jr = JasperCompileManager.compileReport(design);
     //HasMao de parametros utilizados no relatorio. Sempre instanciados
     //HashedMap valores = new HashedMap(); so uso quando passo parametro
     JasperPrint impressao = JasperFillManager.fillReport(arquivo, filtro, con);
     JasperViewer jrviewer = new JasperViewer(impressao, false);
     jrviewer.setVisible(true);
     jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
     }*/
}
