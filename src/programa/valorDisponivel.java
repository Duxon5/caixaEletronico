package programa;

import java.sql.*;

import javax.swing.JOptionPane;

public class valorDisponivel {
	
	public void relatorio() {
		
		BD bd = new BD();
		
		if (bd.getConnection()) {
			
			try {
				
				String sql = "SELECT idnota, qtd, idnota * qtd AS total FROM notas;";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
				ResultSet rs = stmt.executeQuery();
							
				int tudo = 0;
				
				while (rs.next()) {
					String total = rs.getString("total");
					int totalInt = Integer.parseInt(total);
					
					tudo += totalInt;
				}
				JOptionPane.showMessageDialog(null, "Valor total disponivel: \nR$  " + tudo);
				
				rs.close();
				stmt.close();
				bd.close();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao conectar");
		}
		
	}
	
	
}