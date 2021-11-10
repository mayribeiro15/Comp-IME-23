package factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// Nome do usuário no banco MySQL
	private static final String USERNAME = "root";	
	
	// Senha do usuário no banco MySQL
	private static String PASSWORD = "21745070";
	
	// Caminho do banco MySQL, porta e o nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/reservasaereas";
	
	// Conexão com o Banco de dados
	public static Connection createConnectionToMySQL() throws Exception {
		// Carrega classe no JVM
		Class.forName("com.mysql.jdbc.Driver");
		// Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		// Recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		// Testar a conexão
		if(con != null) {
			System.out.println("Conexão estabelecida com sucesso");
			con.close();
		}
	}
}
