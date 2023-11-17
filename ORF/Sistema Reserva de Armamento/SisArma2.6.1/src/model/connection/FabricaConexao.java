/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FabricaConexao {

    /*private static final String URL = "jdbc:mysql://127.0.0.1:3306/reserva";
    private static final String USUARIO = "sisarma";
    private static final String SENHA = "Sisarma@20";*/
    /*private static final String URL = "jdbc:mysql://10.78.48.16:3306/reservaciacap";
    private static final String USUARIO = "sisarma";
    private static final String SENHA = "Sisarma@20";*/
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/reservateste";
    private static final String USUARIO = "sisarma";
    private static final String SENHA = "Sisarma@20";

    private static Connection con;

    public static Connection getconnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("conectou");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na autenticação:" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no driver:" + ex.getMessage());
        }
        return con;
    }

    public static void closeconnection() {

        try {
            con.close();
            System.out.println("perdeu conexao");
        } catch (SQLException ex) {
            System.out.println("Erro ao Desconectar :" + ex.getMessage());
        }
    }

}
