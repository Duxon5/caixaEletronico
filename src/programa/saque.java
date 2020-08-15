package programa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class saque {

	public void sacar() throws Exception{

		int qtd2 = 0, qtd5 = 0, qtd10 = 0, qtd20 = 0, qtd50 = 0, qtd100 = 0;
			
		BD bd = new BD();
		
		if (bd.getConnection()) {
				
			try {
				String sql = "SELECT idnota, qtd FROM notas;";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
					
				ResultSet rs = stmt.executeQuery();					
				
				while (rs.next()) {
		
					int idnotaInt = Integer.parseInt(rs.getString("idnota"));
		
					if (idnotaInt == 2) {
						qtd2 = Integer.parseInt(rs.getString("qtd"));
					}
		
					if (idnotaInt == 5) {
						qtd5 = Integer.parseInt(rs.getString("qtd"));
					}
		
					if (idnotaInt == 10) {
						qtd10 = Integer.parseInt(rs.getString("qtd"));
					}
		
					if (idnotaInt == 20) {
						qtd20 = Integer.parseInt(rs.getString("qtd"));
					}
		
					if (idnotaInt == 50) {
						qtd50 = Integer.parseInt(rs.getString("qtd"));
					}
		
					if (idnotaInt == 100) {
						qtd100 = Integer.parseInt(rs.getString("qtd"));
					}
				}
				if(qtd2<20 || qtd5<=30 || qtd10<=40 || qtd20<=50 || qtd50<=60 || qtd100<=70) {
					JOptionPane.showMessageDialog(null, "Checar a tela de cota mínima. \nUm ou mais valores estão abaixo da quantidade recomendada.");
				}
				rs.close();
				stmt.close();
				bd.close();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, e.toString());
			}
		}else{
			JOptionPane.showMessageDialog(null, "Erro ao conectar");
		}
		
//////////////////////////////////////////////////////////////////////////////////////////				
		if(qtd2<=0 || qtd5<=0 || qtd10<=0 || qtd20<=0 || qtd50<=0 || qtd100<=0) {
			JOptionPane.showMessageDialog(null, "Caixa eletrônico sem notas. Função de sacar indisponível!");
		}else {	
			int valor=0;
			String v = "";
			try {
				//DIGITE O VALOR DO SAQUE
				v = JOptionPane.showInputDialog(null, "Digite o valor de saque: ");
				int numero=0;
				while(numero == 0) {
					if(v.equals("")) {
						JOptionPane.showMessageDialog(null,"Não deixe o campo vazio!" + v);
						sacar();
					}
					numero+=1;
					valor = Integer.parseInt(v);
				}
				if(valor<2) {
					JOptionPane.showMessageDialog(null, "Valor inválido, digite um valor maior ou igual a 2.");
					sacar();
				}
				
				////////////////////////////////////////
				int qtd2Tirado = 0, qtd5Tirado = 0, qtd10Tirado = 0, qtd20Tirado = 0, qtd50Tirado = 0, qtd100Tirado = 0;
				
				BD bd1 = new BD();
				if (bd1.getConnection()) {
					
					String sql = "SELECT idnota, qtd FROM notas;";
					PreparedStatement stUpdate = bd1.con.prepareStatement(sql);
					ResultSet rs = stUpdate.executeQuery();
	
					do {
	
						if ((valor >= 2) && (valor < 5)) {
							valor -= 2;
							qtd2Tirado += 1;
							if(qtd2Tirado>30) {
								JOptionPane.showMessageDialog(null, "Não se pode sacar mais do que 30 notas de cada.");
								return;
							}
						}
						
						if ((valor >= 5) && (valor < 10)) {
							valor -= 5;
							qtd5Tirado += 1;
							if(qtd5Tirado>30) {
								JOptionPane.showMessageDialog(null, "Não se pode sacar mais do que 30 notas de cada.");
								return;
							}
						}
						
						if ((valor >= 10) && (valor < 20)) {
							valor -= 10;
							qtd10Tirado += 1;
							if(qtd10Tirado>30) {
								JOptionPane.showMessageDialog(null, "Não se pode sacar mais do que 30 notas de cada.");
								return;
							}
						}
						
						
						if ((valor >= 20) && (valor < 50)) {
							valor -= 20;
							qtd20Tirado += 1;
							if(qtd20Tirado>30) {
								JOptionPane.showMessageDialog(null, "Não se pode sacar mais do que 30 notas de cada.");
								return;
							}
						}
						
						
						if ((valor >= 50) && (valor < 100)) {
							valor -= 50;
							qtd50Tirado += 1;
							if(qtd50Tirado>30) {
								JOptionPane.showMessageDialog(null, "Não se pode sacar mais do que 30 notas de cada.");
								return;
							}
						}
						
						if (valor >= 100) {
							valor -= 100;	
							qtd100Tirado += 1;
							if(qtd100Tirado>30) {
								JOptionPane.showMessageDialog(null, "Não se pode sacar mais do que 30 notas de cada.");
								return;
							}
						}
						if(valor==1) {
							JOptionPane.showMessageDialog(null, "Este valor não pode ser sacado.");
							return;
						}
					}while(valor != 0);

					int input = JOptionPane.showConfirmDialog(null, "Você esta prestes a sacar 'R$" + v + "' reais na seguinte quantidade de notas: "
							+ "\n\n100:  " + qtd100Tirado + 
							  "\n  50:  " + qtd50Tirado + 
							  "\n  20:  " + qtd20Tirado + 
							  "\n  10:  " + qtd10Tirado +
							  "\n    5:  " + qtd5Tirado + 
							  "\n    2:  " + qtd2Tirado +
							  "\n\nVocê deseja prosseguir?");	
					
					//MOSTRANDO O VALOR SACADO
					if(input==0) {
						if(qtd2>=qtd2Tirado && qtd5>=qtd5Tirado && qtd10>=qtd10Tirado && qtd20>=qtd20Tirado && qtd50>=qtd50Tirado && qtd100>=qtd100Tirado) {
							sql = "UPDATE notas SET qtd = '"+(qtd2-qtd2Tirado)+"' WHERE idnota=2";
							stUpdate.executeUpdate(sql);
												
							sql = "UPDATE notas SET qtd = '"+(qtd5-qtd5Tirado)+"' WHERE idnota=5";
							stUpdate.executeUpdate(sql);	
							
							sql = "UPDATE notas SET qtd = '"+(qtd10-qtd10Tirado)+"' WHERE idnota=10";
							stUpdate.executeUpdate(sql);
							
							sql = "UPDATE notas SET qtd = '"+(qtd20-qtd20Tirado)+"' WHERE idnota=20";
							stUpdate.executeUpdate(sql);
							
							sql = "UPDATE notas SET qtd = '"+(qtd50-qtd50Tirado)+"' WHERE idnota=50";
							stUpdate.executeUpdate(sql);
		
							sql = "UPDATE notas SET qtd = '"+(qtd100-qtd100Tirado)+"' WHERE idnota=100";
							stUpdate.executeUpdate(sql);
							
							JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");	
							if(qtd2<20 || qtd5<=30 || qtd10<=40 || qtd20<=50 || qtd50<=60 || qtd100<=70) {
								JOptionPane.showMessageDialog(null, "Checar a tela de cota mínima. \nUm ou mais valores estão abaixo da quantidade recomendada.");
							}
						}else {			
							JOptionPane.showMessageDialog(null, "Não há notas suficiente para sacar R$" + v + " reais.");
						}
						
					}else{
						sacar();
					}
					
					stUpdate.close();
					rs.close();
					bd1.close();	
				}
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Apenas numeros!");
				sacar();
			}
		}
	}
}
