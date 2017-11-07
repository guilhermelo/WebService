package webservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection instance;
	
	private Conexao(){}
	
	public static Connection getConnection(){
		if(instance == null){
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				instance = DriverManager.getConnection("jdbc:mysql://192.168.0.101:3306/noticiario", "root", "mandioca");
				//192.168.0.101 root ""
			} catch (SQLException e) {
				System.out.println("Erro ao tentar conectar ao banco de dados: " + e.getMessage());
			}
		}
		
		return instance;
	}
}
