package programa;

import java.sql.*;

import javax.swing.JOptionPane;

public class BD {
	
	public Connection con = null;
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DBNAME = "caixaeletronico"; 
	private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
	private final String LOGIN = "root";
	private final String SENHA = "root";
	
	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			
			return true;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe BD - Driver nao encontrado" + e.toString());
			return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Classe BD - Falha ao conectar" + e.toString());
			return false;
		}
	}
	
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {			
		}
	}
}
