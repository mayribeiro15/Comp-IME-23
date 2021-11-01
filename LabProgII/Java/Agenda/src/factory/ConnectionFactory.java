package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	//Dados do db
    private static final String USERNAME = "root";
    private static String PASSWORD = "21745070";
    private static final String DATABEASE_URL = "jdbc:mysql://localhost:3306/agenda";

    //Fun��o que cria a conex�o com o db
    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABEASE_URL, USERNAME, PASSWORD);
        return connection;
    }
    public static void main(String[] args) throws Exception{
        //Criar e testar conex�o
        Connection con = createConnectionToMySQL();

        if(con != null){
            System.out.println("Conex�o estabelecida com sucesso");
            con.close();
        }
    }
}
